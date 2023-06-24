package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXMLPassenger;
import domain.Passenger;
import domain.User;
import presentation.GUI_Passenger;

public class Controller_Passenger implements ActionListener{

	private Passenger passenger;
	private GUI_Passenger gui;
	private FilesXMLPassenger fXMLPassenger;
	
	final String nameFile="Passenger.xml";
	final String elementType= "Pasajero";
	
	private ArrayList<Passenger> arrayPassengers;
	
	public Controller_Passenger(User user) {
		gui=new GUI_Passenger(user);
		
		fXMLPassenger= new FilesXMLPassenger();
		fXMLPassenger.createXML(elementType, nameFile);
		
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
			//gui.showMessage("Agregar");
			//listo
			addPassenger();
		}
		if (e.getSource()== gui.getBModify()) {
			//gui.showMessage("Modificar");
			updatePassenger();
		}
		if (e.getSource()== gui.getBConsult()) {
			//gui.showMessage("Consultar");
			consultPassenger();
		}
		if (e.getSource()== gui.getBDelete()) {
			//gui.showMessage("Eliminar");
			deletePassenger();
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void addPassenger() {
		String dataTXT= gui.getTxtPassport().getText();
		String dataName= gui.getTxtName().getText();
		String dataLastN= gui.getTxtLastName().getText();
		String dataDBirth= gui.getTxtDateBirth().getText();
		String dataEmail= gui.getTxtEmail().getText();
		String dataPhone= gui.getTxtPhone().getText();
		
		if (fXMLPassenger.isEmpty(dataTXT)||fXMLPassenger.isEmpty(dataName)||fXMLPassenger.isEmpty(dataLastN)||
			fXMLPassenger.isEmpty(dataDBirth)||fXMLPassenger.isEmpty(dataEmail)||fXMLPassenger.isEmpty(dataPhone)) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			//fXMLPassenger.checkExists(nameFile, elementType, dataTXT)
			if (fXMLPassenger.checkExistsPassenger(nameFile, elementType, dataTXT)) {
				gui.showMessage("Ya existe un pasajero registrado con el numero de pasaporte["+dataTXT+"]");
			}else {
				passenger= new Passenger(dataTXT, dataName, dataLastN, dataDBirth, dataEmail, dataPhone);
				fXMLPassenger.writeXML(nameFile, elementType, passenger.getDataName(), passenger.getData());
				gui.clearForm();
				gui.showMessage("Se agrego un pasajero de forma exitosa");
			}
		}
	}//fin de addPassenger
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void updatePassenger() {
		String dataTXT= gui.getTxtPassport().getText();
		String dataName= gui.getTxtName().getText();
		String dataLastN= gui.getTxtLastName().getText();
		String dataDBirth= gui.getTxtDateBirth().getText();
		String dataEmail= gui.getTxtEmail().getText();
		String dataPhone= gui.getTxtPhone().getText();
		
		if (fXMLPassenger.isEmpty(dataTXT)||fXMLPassenger.isEmpty(dataName)||fXMLPassenger.isEmpty(dataLastN)||
				fXMLPassenger.isEmpty(dataDBirth)||fXMLPassenger.isEmpty(dataEmail)||fXMLPassenger.isEmpty(dataPhone)) {
				gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLPassenger.checkExistsPassenger(nameFile, elementType, dataTXT)) {
				passenger= new Passenger(dataTXT, dataName, dataLastN, dataDBirth, dataEmail, dataPhone);
				fXMLPassenger.updatePassenger(nameFile, elementType, passenger.getDataName(), passenger.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay un numero de pasaporte ["+dataTXT+"] registrado");
			}
		}
	}//updatePassenger
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void consultPassenger() {
		String dataTXT= gui.getTxtPassport().getText();
		arrayPassengers= fXMLPassenger.readXMLToArrayList(nameFile, elementType);
		fXMLPassenger.setDataMatrixPassenger(arrayPassengers);
		
		if (fXMLPassenger.isEmpty(dataTXT)) {
			gui.getDTMPassenger().setDataVector(fXMLPassenger.getDataMatrixPassenger(), gui.getColumnsName());
		}else {
			arrayPassengers= fXMLPassenger.readPassenger(arrayPassengers, dataTXT);
			fXMLPassenger.setDataMatrixPassenger(arrayPassengers);
			gui.getDTMPassenger().setDataVector(fXMLPassenger.getDataMatrixPassenger(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultPassenger
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void deletePassenger() {
		String dataTXT= gui.getTxtPassport().getText();
		if (fXMLPassenger.isEmpty(dataTXT)) {
			gui.showMessage("No dejar el espacio '# Pasaporte' en blanco");
		}else {
			if (fXMLPassenger.checkExistsPassenger(nameFile, elementType, dataTXT)) {
				fXMLPassenger.deleteFromXML(nameFile, elementType, dataTXT);
				gui.showMessage("Se elimino el pasajero con el # de pasaporte ["+dataTXT+"] Correctamente");
				gui.clearForm();
			}else {
				gui.showMessage("No se encontro el pasajero con el # de pasaporte ["+dataTXT+"]");
			}
		}
	}//fin de deletePassenger
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
