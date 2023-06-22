package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FileXMLModel;
import data.FilesXMLAirline;
import data.FilesXMLAirplane;
import domain.Airplane;
import domain.User;
import presentation.GUI_Airplane;

public class Controller_Airplane implements ActionListener{
	
	private Airplane airplane;
	private GUI_Airplane gui;
	private FilesXMLAirplane fXMLAirplane;
	
	private FilesXMLAirline filesXMLAirline;
	private FileXMLModel filesXMLModel;
	
	final String nameFileAirline="Airline.xml";
	final String nameFileModel= "Model.xml";
	final String nameFile= "Airplane.xml";
	final String elementType= "Avion";
	
	private ArrayList<Airplane> arrayAirplanes;
	
	private ArrayList<String> arrayStringAirlines;
	private ArrayList<String> arrayStringModels;
	
	public Controller_Airplane(User user) {
		gui= new GUI_Airplane(user);
		
		fXMLAirplane= new FilesXMLAirplane();
		fXMLAirplane.createXML("Airplane", elementType);
		
		//carga las aerolineas al comboBox
		filesXMLAirline= new FilesXMLAirline();
		filesXMLAirline.setAirlines(filesXMLAirline.readXMLToArrayList(nameFileAirline, "Aerolinea"));
		arrayStringAirlines= filesXMLAirline.getArrayAirlines();
		gui.fillComboAirlines(arrayStringAirlines);
		
		//carga los modelos al comboBox
		filesXMLModel= new FileXMLModel();
		filesXMLModel.setModels(filesXMLModel.readXMLToArrayList(nameFileModel, "Modelo"));
		arrayStringModels= filesXMLModel.getArrayModels();
		gui.fillComboModels(arrayStringModels);
		
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
		// TODO Auto-generated method stub
		if (e.getSource()== gui.getBAdd()) {
			
			addAirplane();
		}
		if (e.getSource()==gui.getBModify()) {
			updateAirplane();
		}
		if(e.getSource()== gui.getBConsult()) {
			consultAirplane();
		}
		if (e.getSource()== gui.getBDelete()) {
			deleteAirplane();
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void addAirplane() {
		String dataTXT= gui.getTxtRegistration().getText();
		String dataABox= ""+gui.getComboAirline().getSelectedItem();
		String dataMBox= ""+gui.getComboModel().getSelectedItem();
		String dataYear= gui.getTxtYear().getText();
		
		if (fXMLAirplane.isEmpty(dataTXT)||fXMLAirplane.isEmpty(dataABox)||
			fXMLAirplane.isEmpty(dataMBox)||fXMLAirplane.isEmpty(dataYear)) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLAirplane.checkExists(nameFile, elementType, dataTXT)) {
				gui.showMessage("Ya existe un avion con esta matricula");
			}else {
				airplane= new Airplane(dataTXT,dataABox,dataMBox,dataYear);
				fXMLAirplane.writeXML(nameFile, elementType, airplane.getDataName(), airplane.getData());
				gui.clearForm();
				gui.showMessage("Se agrego un avion exitosamente");
			}
		}
		
	}//fin de addAirplane
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void updateAirplane() {
		String dataTXT= gui.getTxtRegistration().getText();
		String dataABox= ""+gui.getComboAirline().getSelectedItem();
		String dataMBox= ""+gui.getComboModel().getSelectedItem();
		String dataYear= gui.getTxtYear().getText();
		
		if (fXMLAirplane.isEmpty(dataTXT)||dataABox.equalsIgnoreCase("Vacio")|| 
			dataMBox.equalsIgnoreCase("Vacio")||fXMLAirplane.isEmpty(dataYear)) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if(fXMLAirplane.checkExists(nameFile, elementType, dataTXT)) {
				airplane= new Airplane(dataTXT, dataABox, dataMBox, dataYear);
				
				fXMLAirplane.updateAirplane(nameFile, elementType, airplane.getDataName(), airplane.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay un avion ["+dataTXT+"] registrado");
			}
		}
		
	}//fin de updateAirplane
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void consultAirplane() {
		String dataTXT= gui.getTxtRegistration().getText();
		arrayAirplanes= fXMLAirplane.readXMLToArrayList(nameFile, elementType);
		
		fXMLAirplane.setDataMatrixAirplane(arrayAirplanes);
		if (fXMLAirplane.isEmpty(dataTXT)) {
			gui.getDTMAirplane().setDataVector(fXMLAirplane.getDataMatrixAirplane(), gui.getColumnsName());
		}else {
			arrayAirplanes= fXMLAirplane.readAirplane(arrayAirplanes, dataTXT);
			fXMLAirplane.setDataMatrixAirplane(arrayAirplanes);
			gui.getDTMAirplane().setDataVector(fXMLAirplane.getDataMatrixAirplane(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultAirplane
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void deleteAirplane() {
		String dataTXT= gui.getTxtRegistration().getText();
		if(fXMLAirplane.isEmpty(dataTXT)) {
			gui.showMessage("No dejar el espacio 'Matricula' en blanco");
			
		}else {
			//Falta validar que no esten registrado a algun VUELO!!
			if (fXMLAirplane.checkExists(nameFile, elementType, dataTXT)) {
				fXMLAirplane.deleteFromXML(nameFile, elementType, dataTXT);
				gui.showMessage("Se elimino el avion ["+dataTXT+"] Correctamente");
				gui.clearForm();
			}else {
				gui.showMessage("No se encontro el avion con matricula ["+dataTXT+"]");
			}
		}
	
	}//fin de deleteAirplane
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//falta metodo isAssociated
	
}
