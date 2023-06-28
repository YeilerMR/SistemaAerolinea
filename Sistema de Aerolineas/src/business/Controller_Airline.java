package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXMLAirline;
import data.FilesXMLAirplane;
import domain.Airline;
import domain.Airplane;
import domain.User;
import presentation.GUI_Airline;

public class Controller_Airline implements ActionListener{
	
	private Airline airline;
	private GUI_Airline gui;
	
	private FilesXMLAirline fXMLAirline;
	private FilesXMLAirplane filesXMLAirplane;
	
	
	final String nameFile= "Airline.xml";
	final String nameFAirplane= "Airplane.xml";
	final String elementType= "Aerolinea";
	
	private ArrayList<Airline> arrayAirlines;

	public Controller_Airline(User user) {
		
		gui= new GUI_Airline(user);
		
		fXMLAirline= new FilesXMLAirline();
		fXMLAirline.createXML(elementType, nameFile);
		
		filesXMLAirplane= new FilesXMLAirplane();
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
			updateAirline();
		}
		if (e.getSource()==gui.getBConsult()) {
			gui.showMessage("Consultar");
			consultAirline();
		}
		if (e.getSource()==gui.getBDelete()) {
			gui.showMessage("Eliminar");
			deleteAirline();
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
	private void updateAirline() {
		String dataTXT= gui.getTxtNombre().getText();
		String dataNew= gui.getTxtNew().getText();
		
		String dataOperationC= gui.getTxtOperationCenter().getText();
		
		if (fXMLAirline.isEmpty(dataTXT)||fXMLAirline.isEmpty(dataNew)||fXMLAirline.isEmpty(dataOperationC)) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLAirline.checkExists(nameFile, elementType, dataTXT)) {
				airline= new Airline(dataNew, dataOperationC);
				fXMLAirline.updateAirline(nameFile, elementType, airline.getDataName(), airline.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay una aerolinea ["+dataTXT+"] registrado");
			}
		}
	}//fin de updateAirline
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void consultAirline() {
		String dataTXT= gui.getTxtNombre().getText();
		arrayAirlines= fXMLAirline.readXMLToArrayList(nameFile, elementType);
		
		fXMLAirline.setDataMatrixAirline(arrayAirlines);
		if (fXMLAirline.isEmpty(dataTXT)) {
			gui.getDTMAirline().setDataVector(fXMLAirline.getDataMatrixAirline(), gui.getColumnNames());
		}else {
			arrayAirlines= fXMLAirline.readAirline(arrayAirlines, dataTXT);
			fXMLAirline.setDataMatrixAirline(arrayAirlines);
			gui.getDTMAirline().setDataVector(fXMLAirline.getDataMatrixAirline(), gui.getColumnNames());
			gui.clearForm();
		}
	}//fin de consultAirline
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void deleteAirline() {
		String dataTXT= gui.getTxtNombre().getText();
		if (fXMLAirline.isEmpty(dataTXT)) {
			gui.showMessage("No dejar el espacio 'Nombre' en blanco");
		}else {
			if (isAssociate(filesXMLAirplane.readXMLToArrayList(nameFAirplane, "Avion"), dataTXT)) {
				gui.showMessage("No puede eliminar una aerolinea asociada.");
			}else {
				if (fXMLAirline.checkExists(nameFile, elementType, dataTXT)) {
					fXMLAirline.deleteFromXMLAirline(nameFile, elementType, dataTXT);
					gui.showMessage("Se elimino el modelo ["+dataTXT+"] Correctamente");
					gui.clearForm();
				}else {
					gui.showMessage("No se encontro la aerolinea ["+dataTXT+"]");
				}
			}
			
		}
	}//fin de deleteAirline
	
	private boolean isAssociate(ArrayList<Airplane> arrayAirplane,String dataTXT) {
		boolean valid= false;
		gui.showMessage("Entro al metodo isAssociate");
		for (int i = 0; i < arrayAirplane.size(); i++) {
			if(dataTXT.equalsIgnoreCase(arrayAirplane.get(i).getArrayAirlines())) {
				valid= true;
			}
		}
		return valid;
	}
}
