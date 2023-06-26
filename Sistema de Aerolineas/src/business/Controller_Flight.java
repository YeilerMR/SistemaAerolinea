package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import data.FilesXMLAirplane;
import data.FilesXMLFlight;
import domain.Flight;
import domain.User;
import presentation.GUI_Flight;

public class Controller_Flight implements ActionListener{
	
	private int dataDayE,dataMonthE,dataYearE;
	private int dataDayA,dataMonthA,dataYearA;
	
	private String dataDateE,dataDateA, dataHourE, dataHourA;
	private String dataTXT;
	
	private Flight flight;
	private GUI_Flight gui;
	private FilesXMLFlight fXMLFlight;
	
	private FilesXMLAirplane filesXMLAirplane;
	
	final String nameFileAirplane= "Airplane.xml";
	final String nameFile= "Flight.xml";
	final String elementType= "Vuelo";
	
	private ArrayList<Flight> arrayFlights;
	private ArrayList<String> arrayStringAirplanes;
	

	public Controller_Flight(User user) {
		gui= new GUI_Flight(user);
		
		fXMLFlight= new FilesXMLFlight();
		fXMLFlight.createXML(elementType, nameFile);
		
		//cargar aviones al combo
		filesXMLAirplane= new FilesXMLAirplane();
		filesXMLAirplane.setAirplane(filesXMLAirplane.readXMLToArrayList(nameFileAirplane, "Avion"));
		arrayStringAirplanes=filesXMLAirplane.getArrayAirplanes();
		gui.fillcomboAirplane(arrayStringAirplanes);
		
		initializer();
	}

	public void initializer() {
		gui.getBAdd().addActionListener(this);
		gui.getBModify().addActionListener(this);
		gui.getBConsult().addActionListener(this);
		gui.getBDelete().addActionListener(this);
		gui.getBNumber().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==gui.getBAdd()) {
			gui.showMessage("agregar");
			addFlight();
		}
		if (e.getSource()==gui.getBModify()) {
			gui.showMessage("modificar");
			updateFlight();
		}
		if (e.getSource()==gui.getBConsult()) {
			gui.showMessage("consultar");
			consultFlight();
		}
		if (e.getSource()==gui.getBDelete()) {
			gui.showMessage("eliminar");
			deleteFlight();
		}
		if (e.getSource()==gui.getBNumber()) {
			gui.showMessage("agregarNdeVuelo");
			addIDFlight(getIDFlight());
		}
	}
	public int getIDFlight() {
		int numero = (int)(Math.random()*1000+1);
		
		//revisar el metodo checkExists;
		if (fXMLFlight.checkExists(nameFile, elementType,""+numero)) {
			getIDFlight();
		}
		return numero;
	}
	public void addIDFlight(int randNum) {
		gui.getTxtNFlight().setText(""+randNum);
	}
	public void addDate() {
		
		dataHourA= gui.getTxtHourE().getText();
		dataHourE= gui.getTxtHourA().getText();
		
		dataDayE=gui.getDcDateE().getCalendar().get(Calendar.DAY_OF_MONTH);
		dataMonthE= gui.getDcDateE().getCalendar().get(Calendar.MONTH);
		dataYearE= gui.getDcDateE().getCalendar().get(Calendar.YEAR);
		
		dataDayA=gui.getDcDateA().getCalendar().get(Calendar.DAY_OF_MONTH);
		dataMonthA= gui.getDcDateA().getCalendar().get(Calendar.MONTH);
		dataYearA= gui.getDcDateA().getCalendar().get(Calendar.YEAR);
		
		dataDateE=""+dataDayE+"/"+dataMonthE+"/"+dataYearE; 
		dataDateA=""+dataDayA+"/"+dataMonthA+"/"+dataYearA;
		
		System.out.println(dataDateA);
		System.out.println(dataDateE);
		
	}

	private void addFlight() {
		//capturar datos del jCalendary
		addDate();
		//++++++++++++++++++++++
		dataTXT=gui.getTxtNFlight().getText();
		String dataCityE=gui.getTxtCityE().getText();
		String dataCityA=gui.getTxtCityA().getText();
		String dataABox= ""+gui.getComboAirplane().getSelectedItem();
		
		int dataClassB=Integer.parseInt(gui.getTxtClassB().getText());
		int dataClassT=Integer.parseInt(gui.getTxtClassT().getText());
		int dataClassE=Integer.parseInt(gui.getTxtClassE().getText());
		
		//Debo validar que las fechas no tengan incongruencias

		if (fXMLFlight.isEmpty(dataTXT)||fXMLFlight.isEmpty(dataCityE)||fXMLFlight.isEmpty(dataHourE)||fXMLFlight.isEmpty(dataDateE)||
			dataABox.equals("Vacio")||fXMLFlight.isEmpty(dataCityA)||fXMLFlight.isEmpty(dataHourA)||fXMLFlight.isEmpty(dataDateA)||
			fXMLFlight.isEmpty(""+dataClassB)||fXMLFlight.isEmpty(""+dataClassT)||fXMLFlight.isEmpty(""+dataClassE)) {
			gui.showMessage("No puede dejar espacios en blancos.");
		}else {
			if (fXMLFlight.checkExists(nameFile, elementType, dataTXT)) {
				gui.showMessage("Ya existe un vuelo con esta matricula");
			}else {
				flight= new Flight(dataTXT,dataCityE,dataHourE, dataDateE,dataABox,dataCityA,dataHourA,dataDateA,dataClassB,dataClassT,dataClassE);
				fXMLFlight.writeXML(nameFile, elementType, flight.getDataName(), flight.getData());
				gui.clearForm();
				gui.showMessage("Se agrego un vuelo exitosamente");
			}
		}
		
	}//fin de addFlight
	
	private void updateFlight() {
		addDate();
		//++++++++++++++++++++++
		String dataTXTCompare=gui.getTxtNFlightCompare().getText();
		String dataCityE=gui.getTxtCityE().getText();
		String dataCityA=gui.getTxtCityA().getText();
		String dataABox= ""+gui.getComboAirplane().getSelectedItem();
		
		int dataClassB=Integer.parseInt(gui.getTxtClassB().getText());
		int dataClassT=Integer.parseInt(gui.getTxtClassT().getText());
		int dataClassE=Integer.parseInt(gui.getTxtClassE().getText());
		
		//Debo validar que las fechas no tengan incongruencias

		gui.showMessage(dataTXTCompare);
		
		if (fXMLFlight.isEmpty(dataTXTCompare)||fXMLFlight.isEmpty(dataCityE)||fXMLFlight.isEmpty(dataHourE)||fXMLFlight.isEmpty(dataDateE)||
			dataABox.equals("Vacio")||fXMLFlight.isEmpty(dataCityA)||fXMLFlight.isEmpty(dataHourA)||fXMLFlight.isEmpty(dataDateA)||
			fXMLFlight.isEmpty(""+dataClassB)||fXMLFlight.isEmpty(""+dataClassT)||fXMLFlight.isEmpty(""+dataClassE)) {
			gui.showMessage("No puede dejar espacios en blancos.");
		}else {
			if (fXMLFlight.checkExistsFlight(nameFile, elementType, dataTXTCompare)) {
				System.out.println("Bandera: entro al if del updateFlight");
				flight= new Flight(dataTXTCompare,dataCityE,dataHourE, dataDateE,dataABox,dataCityA,dataHourA,dataDateA,dataClassB,dataClassT,dataClassE);
				
				fXMLFlight.updateFlight(nameFile, elementType, flight.getDataName(), flight.getData(), dataTXTCompare);
				gui.clearForm();
			}else {
				gui.showMessage("No hay un avion ["+dataTXTCompare+"] registrado");
			}
		}
	}//fin de updateFlight
	
	private void consultFlight() {
		String dataTXTCompare=gui.getTxtNFlightCompare().getText();//gui.getTxtNFlight().getText();
		arrayFlights= fXMLFlight.readXMLToArrayList(nameFile, elementType);
		
		fXMLFlight.setDataMatrixFlight(arrayFlights);
		if (fXMLFlight.isEmpty(dataTXTCompare)) {
			gui.getDTMFlight().setDataVector(fXMLFlight.getDataMatrixFligh(), gui.getColumnsName());
		}else {
			arrayFlights= fXMLFlight.readFlight(arrayFlights, dataTXTCompare);
			fXMLFlight.setDataMatrixFlight(arrayFlights);
			gui.getDTMFlight().setDataVector(fXMLFlight.getDataMatrixFligh(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultFlight
	private void deleteFlight() {
		String dataTXTCompare=gui.getTxtNFlightCompare().getText();

		if (fXMLFlight.isEmpty(dataTXTCompare)) {
			gui.showMessage("No dejar el espacio 'N° de Vuelo' en blanco");
		}else {
			if(fXMLFlight.checkExistsFlight(nameFile, elementType, dataTXTCompare)) {
				fXMLFlight.deleteFromXML(nameFile, elementType, dataTXTCompare);
				gui.showMessage("Se elimino el vuelo con n°["+dataTXTCompare+"] Correctamente");
				gui.clearForm();
				
			}else {
				gui.showMessage("No se encontro el vuelo con n°["+dataTXTCompare+"]");
			}
		}
	}
}//fin de Controller_Flight
