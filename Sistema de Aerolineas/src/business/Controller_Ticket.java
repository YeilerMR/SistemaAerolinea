package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXMLFlight;
import data.FilesXMLPassenger;
import data.FilesXMLTicket;
import domain.Ticket;
import domain.User;
import presentation.GUI_Buy;
import presentation.GUI_Print;
import presentation.GUI_Ticket;

public class Controller_Ticket implements ActionListener{

	private String dataTXT, dataNPassenger, 
				dataNFlight, dataSType;
	
	
	private Ticket ticket;
	private GUI_Ticket gui;
//	private GUI_Print gPrint;
//	private GUI_Buy gBuy;
	private FilesXMLTicket fXMLTicket;
	
	private FilesXMLPassenger filesXMLPassenger;
	private FilesXMLFlight filesXMLFlight;
	
	final String nameFilePassenger= "Passenger.xml";
	final String nameFileFlight= "Flight.xml";
	
	final String nameFile= "Ticket.xml";
	final String elementType= "Tiquete";
	
//	final String nameFileBuy= "Buy.xml";
//	final String elementTypeBuy= "Compra";
	
	private ArrayList<Ticket> arrayTickets;
	
	private ArrayList<String> arrayStringPasssengers;
	private ArrayList<String> arrayStringFlights;
	private ArrayList<String> arrayStringSTypes;
	
	public Controller_Ticket(User user) {
		
		gui= new GUI_Ticket(user);
//		gBuy= new GUI_Buy();
//		gPrint= new GUI_Print();
		
		fXMLTicket= new FilesXMLTicket();
		fXMLTicket.createXML(elementType, nameFile);
		//fXMLTicket.createXML(elementTypeBuy,nameFileBuy);
		
		loadPassengers();
		loadFlights();
		loadSTypes();
		
		initializer();
		
	}
	public void initializer() {
		gui.getBAdd().addActionListener(this);
		gui.getBModify().addActionListener(this);
		gui.getBConsult().addActionListener(this);
		gui.getBDelete().addActionListener(this);
		//gui.getMntPrint().addActionListener(this);
		gui.getMntBuy().addActionListener(this);
	}
	private void loadPassengers() {
		filesXMLPassenger= new FilesXMLPassenger();
		filesXMLPassenger.setPassengers(filesXMLPassenger.readXMLToArrayList(nameFilePassenger, "Pasajero"));
		arrayStringPasssengers= filesXMLPassenger.getArrayPassengers();
		gui.fillComboPassenger(arrayStringPasssengers);
	}
	private void loadFlights() {
		filesXMLFlight= new FilesXMLFlight();
		filesXMLFlight.setFlights(filesXMLFlight.readXMLToArrayList(nameFileFlight, "Vuelo"));
		arrayStringFlights= filesXMLFlight.getArrayFlights();
		gui.fillComboFlight(arrayStringFlights);
	}
	private void loadSTypes() {
		arrayStringSTypes= new ArrayList<String>();
		arrayStringSTypes.add("Ejecutivo");
		arrayStringSTypes.add("Turista");
		arrayStringSTypes.add("Economico");
		gui.fillComboSTypes(arrayStringSTypes);
	}
	private void addData() {
		dataTXT= gui.getTxtNTicket().getText();
		dataNPassenger= ""+gui.getComboPassport().getSelectedItem();
		dataNFlight= ""+gui.getComboFlight().getSelectedItem();
		dataSType= ""+gui.getComboSTypes().getSelectedItem();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==gui.getBAdd()) {
			gui.showMessage("Agregar");
			addTicket();
		}
		if (e.getSource()==gui.getBModify()) {
			gui.showMessage("modificar");
			updateTicket();
		}
		if (e.getSource()==gui.getBConsult()) {
			gui.showMessage("consultar");
			consultTicket();
		}
		if (e.getSource()==gui.getBDelete()) {
			gui.showMessage("eliminar");
			deleteTicket();
		}
		
		if (e.getSource()==gui.getMntBuy()) {
			gui.showMessage("Compra el tiquete");
			new Controller_Buy(); 
		}
		
	}
	private void addTicket(){
		addData();
		if (fXMLTicket.isEmpty(dataTXT)||dataNPassenger.equals("Vacio")||
			dataNFlight.equals("Vacio")||dataSType.equals("Vacio")) {
			gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLTicket.checkExistsTicket(nameFile, elementType, dataTXT)) {
				gui.showMessage("Ya existe un tiquete con ese numero");
			}else {
				ticket= new Ticket(dataTXT, dataNPassenger, dataNFlight,dataSType);
				fXMLTicket.writeXML(nameFile, elementType, ticket.getDataName(), ticket.getData());
				
				gui.clearForm();
				gui.showMessage("Se agrego un avion exitosamente");
				
			}
		}
		
	}//fin de addTicket
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void updateTicket() {
		addData();
		if (fXMLTicket.isEmpty(dataTXT)||dataNPassenger.equals("Vacio")||
				dataNFlight.equals("Vacio")||dataSType.equals("Vacio")) {
				gui.showMessage("No puede dejar ningun espacio en blanco");
		}else {
			if (fXMLTicket.checkExistsTicket(nameFile, elementType, dataTXT)) {
				ticket= new Ticket(dataTXT, dataNPassenger, dataNFlight,dataSType);
				fXMLTicket.updateTickets(nameFile, elementType, ticket.getDataName(), ticket.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay un numero de tiquete: ["+dataTXT+"] registrado");
			}
		}
	}//fin de updateTicket
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void consultTicket() {
		String dataTXT= gui.getTxtNTicket().getText();
		arrayTickets= fXMLTicket.readXMLToArrayList(nameFile, elementType);
		
		fXMLTicket.setDataMatrixTicket(arrayTickets);
		if (fXMLTicket.isEmpty(dataTXT)) {
			gui.getDTMTicket().setDataVector(fXMLTicket.getDataMatrixticket(), gui.getColumnsName());
		}else {
			arrayTickets= fXMLTicket.readTicket(arrayTickets, dataTXT);
			fXMLTicket.setDataMatrixTicket(arrayTickets);
			gui.getDTMTicket().setDataVector(fXMLTicket.getDataMatrixticket(), gui.getColumnsName());
			gui.clearForm();
		}
	}//fin de consultTicket
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void deleteTicket(){
		String dataTXT= gui.getTxtNTicket().getText();
		if (fXMLTicket.isEmpty(dataTXT)) {
			gui.showMessage("No dejar el espacio 'Numero de tiquete' en blanco");
		}else {
			if(fXMLTicket.checkExistsTicket(nameFile, elementType, dataTXT)) {
				fXMLTicket.deleteFromXML(nameFile, elementType, dataTXT);
				gui.showMessage("Se elimino el tiquete N°["+dataTXT+"] correctamente");
				gui.clearForm();
			}else {
				gui.showMessage("No se encontro el tiquete con el N°["+dataTXT+"]");
			}
		}
	}//fin de deleteTicket
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	private void printTicket() {
//		String dataTXTPrint= gPrint.getTxtNTicket().getText();
//		if (fXMLTicket.isEmpty(dataTXTPrint)) {
//			gui.showMessage("No dejar el espacio 'N° de Tiquete' en blanco");
//		}else {
//			fXMLTicket.
//		}
//	}
//	private void buyTicket() {
//		String dataTXTBuy= gBuy.getTxtNTicket().getText();
//		if(fXMLTicket.isEmpty(dataTXTBuy)) {
//			gui.showMessage("No dejar el espacio 'Numero de tiquete' en blanco");
//		}else {
//			
//		}
//	}
}//fin de Controller_Ticket
