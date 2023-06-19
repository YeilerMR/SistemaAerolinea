package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FileXMLModel;
import data.LogicXML;
import domain.Model;
import domain.User;
import presentation.GUI_Model;

public class Controller_Model implements ActionListener{

	private Model model;
	private GUI_Model gui;
	private LogicXML lXml;
	private FileXMLModel fXMLModel;
	
	final String nameFile= "Model.xml";
	final String nameFBrand= "Brand.xml";
	
	private ArrayList<Model> arrayModels;
	
	
	public Controller_Model(User user) {
		lXml= new LogicXML();
		gui= new GUI_Model(user);
		
		fXMLModel= new FileXMLModel();
		fXMLModel.createXML("Model", nameFile);
		
		initializer();
	}
	public void initializer() {
		gui.getBAdd().addActionListener(this);
		gui.getBModify().addActionListener(this);
		gui.getBConsult().addActionListener(this);
		gui.getBDelete().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==gui.getBAdd()) {
			//Listo!!!
			gui.showMessage("Agregar");
			addModel();
		}
		if(e.getSource()==gui.getBModify()) {
			gui.showMessage("Modificar");
		}
		if(e.getSource()==gui.getBConsult()) {
			//Listo!!!
			gui.showMessage("Consultar");
			consultModels();
		}
		if(e.getSource()==gui.getBDelete()) {
			gui.showMessage("Eliminar");
		}
		
	}
	//Verifica si el jtext esta vacio
	public boolean isEmpty(String text) {
		boolean valid;
		
		if (text.equalsIgnoreCase("")) {
			valid= true;
		}else {
			valid= false;
		}
		return valid;
	}//fin de isEmpty
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Agrega un modelo al xml
	private void addModel() {
		//EN PROCESO
		String dataTXT= gui.getTxtNombre().getText();
		//Falta capturar el dato del JComboBox.
		String dataBClass= gui.getTxtBClass().getText();
		String dataTClass= gui.getTxtTClass().getText();
		String dataEClass= gui.getTxtEconomic().getText();
		
		if (isEmpty(dataTXT)|| isEmpty(""+dataBClass)|| 
			isEmpty(""+dataTClass) || isEmpty(""+dataEClass)) {
			
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLModel.checkExists(nameFile, dataTXT)) {
				gui.showMessage("Ya existe una modelo con este nombre");
			}else {
				model= new Model(dataTXT,"Brand",Integer.parseInt(dataBClass),
					Integer.parseInt(dataTClass),Integer.parseInt(dataEClass));
				
				fXMLModel.writeXML(nameFile, "Modelo", model.getDataName(), model.getData());
				gui.clearForm();
				gui.showMessage("Se agrego una marca exitosamente");
			}
		}
	}//fin de addModel
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void consultModels() {
		String dataTXT= gui.getTxtNombre().getText();
		arrayModels= fXMLModel.readXMLToArrayList(nameFile, "Modelo", dataTXT);
		
		fXMLModel.setDataMatrixModel(arrayModels);
		if (isEmpty(dataTXT)) {
			gui.getDTMModel().setDataVector(fXMLModel.getDataMatrixModel(), gui.getColumnsName());
		}else {
			arrayModels= fXMLModel.readModel(arrayModels, dataTXT);
			fXMLModel.setDataMatrixModel(arrayModels);
			gui.getDTMModel().setDataVector(fXMLModel.getDataMatrixModel(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultModels
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
}//fin de Controller_Model
