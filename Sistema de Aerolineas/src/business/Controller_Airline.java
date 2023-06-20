package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXMLAirline;
import domain.Airline;
import domain.User;
import presentation.GUI_Airline;

public class Controller_Airline implements ActionListener{
	
	private Airline airline;
	private GUI_Airline gui;
	private FilesXMLAirline fXMLAirline;
	
	
	final String nameFile= "Airline.xml";
	final String elementType= "Aerolinea";
	
	private ArrayList<Airline> arrayAirlines;

	public Controller_Airline(User user) {
		
		gui= new GUI_Airline(user);
		
		fXMLAirline= new FilesXMLAirline();
		fXMLAirline.createXML("Airline", nameFile);
		
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
		if (e.getSource()==gui.getBAdd()) {
			gui.showMessage("Agregar");
			addAirline();
		}
		if (e.getSource()==gui.getBModify()) {
			gui.showMessage("Modificar");
		}
		if (e.getSource()==gui.getBConsult()) {
			gui.showMessage("Consultar");
		}
		if (e.getSource()==gui.getBDelete()) {
			gui.showMessage("Eliminar");
		}
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Agrega una aerolinea al xml
	private void addAirline() {
		
		String dataTXT= gui.getTxtNombre().getText();
		String dataCOperation= gui.getTxtOperationCenter().getText(); 
		
		if (fXMLAirline.isEmpty(dataTXT)||fXMLAirline.isEmpty(dataCOperation)) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLAirline.checkExists(nameFile, elementType, dataTXT)) {
				//airline= new Airline(da); 
				gui.showMessage("Ya existe una aerolinea con este nombre");
			}else {
				airline= new Airline(dataTXT, dataCOperation);
				fXMLAirline.writeXML(nameFile, elementType, airline.getDataName(), airline.getData());
				gui.clearForm();
				gui.showMessage("Se agrego una aerolinea correctamente");
			}
		}
	}//fin de addAirline
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
}
