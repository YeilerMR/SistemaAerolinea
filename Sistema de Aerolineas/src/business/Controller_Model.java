package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FileXMLModel;
import data.FilesXMLBrand;
import data.LogicXML;
import domain.Model;
import domain.User;
import presentation.GUI_Model;

public class Controller_Model implements ActionListener{

	private Model model;
	private GUI_Model gui;
	//private LogicXML lXml;
	private FileXMLModel fXMLModel;
	private FilesXMLBrand filesXMLBrand;
	
	
	final String nameFileBrand= "Brand.xml";
	final String nameFile= "Model.xml";
	final String elementType= "Modelo";
	
	//final String nameFBrand= "Brand.xml";
	
	private ArrayList<Model> arrayModels;
	private ArrayList<String> arrayStringBrands; 
	
	
	
	public Controller_Model(User user) {
		
		gui= new GUI_Model(user);
		
		fXMLModel= new FileXMLModel();
		fXMLModel.createXML("Model", nameFile);
		
		//Carga las marcas al comboBox
		filesXMLBrand= new FilesXMLBrand();
		filesXMLBrand.setBrands(filesXMLBrand.readXMLToArrayList(nameFileBrand, "Marca"));
		arrayStringBrands= filesXMLBrand.getArrayBrands();
		gui.fillComboBox(arrayStringBrands);
		
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
			updateModel();
			gui.showMessage("Modificar");
		}
		if(e.getSource()==gui.getBConsult()) {
			//Listo!!!
			gui.showMessage("Consultar");
			consultModels();
		}
		if(e.getSource()==gui.getBDelete()) {
			gui.showMessage("Eliminar");
			deleteModel();
		}
		
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Agrega un modelo al xml
	private void addModel() {
		//EN PROCESO
		String dataTXT= gui.getTxtNombre().getText();
		//Falta capturar el dato del JComboBox.
		String dataCBox= ""+gui.getComboBrands().getSelectedItem();
		String dataBClass= gui.getTxtBClass().getText();
		String dataTClass= gui.getTxtTClass().getText();
		String dataEClass= gui.getTxtEconomic().getText();
		
		if (fXMLModel.isEmpty(dataTXT)|| fXMLModel.isEmpty(""+dataBClass)|| dataCBox.equals("Vacio")|| 
				fXMLModel.isEmpty(""+dataTClass) || fXMLModel.isEmpty(""+dataEClass)) {
			
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLModel.checkExists(nameFile,elementType,dataTXT)) {
				gui.showMessage("Ya existe un modelo con este nombre");
			}else {
				model= new Model(dataTXT,dataCBox,Integer.parseInt(dataBClass),
					Integer.parseInt(dataTClass),Integer.parseInt(dataEClass));
				
				fXMLModel.writeXML(nameFile, elementType, model.getDataName(), model.getData());
				gui.clearForm();
				gui.showMessage("Se agrego un modelo exitosamente");
			}
		}
	}//fin de addModel
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void updateModel() {
		String dataTXT= gui.getTxtNombre().getText();
		String dataNew= gui.getTxtNew().getText();
		//Falta capturar el dato del JComboBox.
		String dataCBox= ""+gui.getComboBrands().getSelectedItem(); 
		String dataBClass= gui.getTxtBClass().getText();
		String dataTClass= gui.getTxtTClass().getText();
		String dataEClass= gui.getTxtEconomic().getText();
		
		if (fXMLModel.isEmpty(dataTXT)||fXMLModel.isEmpty(dataNew)|| 
				dataCBox.equals("Vacio")||fXMLModel.isEmpty(""+dataBClass)|| 
				fXMLModel.isEmpty(""+dataTClass) ||fXMLModel.isEmpty(""+dataEClass)){	
			
			gui.showMessage("No puede dejar ningun espacio en blanco");
			
		}else {
			if (fXMLModel.checkExists(nameFile,elementType, dataTXT)) {
				
				model= new Model(dataNew, dataCBox,Integer.parseInt(dataBClass),
						Integer.parseInt(dataTClass), Integer.parseInt(dataEClass));
				System.out.println("desde el vector: "+model.getData()[0]);
				fXMLModel.updateModel(nameFile, elementType, model.getDataName(), model.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay un modelo ["+dataTXT+"] registrado");
			}
		}
	}//fin de updateModel
	
	//consulta la info del xml
	private void consultModels() {
		String dataTXT= gui.getTxtNombre().getText();
		arrayModels= fXMLModel.readXMLToArrayList(nameFile, elementType);
		
		fXMLModel.setDataMatrixModel(arrayModels);
		if (fXMLModel.isEmpty(dataTXT)) {
			gui.getDTMModel().setDataVector(fXMLModel.getDataMatrixModel(), gui.getColumnsName());
		}else {
			arrayModels= fXMLModel.readModel(arrayModels, dataTXT);
			fXMLModel.setDataMatrixModel(arrayModels);
			gui.getDTMModel().setDataVector(fXMLModel.getDataMatrixModel(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultModels
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void deleteModel() {
		String dataTXT= gui.getTxtNombre().getText();
		if (fXMLModel.isEmpty(dataTXT)) {
			gui.showMessage("No dejar el espacio 'Nombre' en blanco");
		}else {
			if (fXMLModel.checkExists(nameFile, elementType,dataTXT)) {
				fXMLModel.deleteFromXML(nameFile, elementType, dataTXT);
				gui.showMessage("Se elimino el modelo ["+dataTXT+"] Correctamente");
				gui.clearForm();
			}else {
				gui.showMessage("No se encontro el modelo ["+dataTXT+"]");
			}
		}
	}//fin de deleteModel
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}//fin de Controller_Model
