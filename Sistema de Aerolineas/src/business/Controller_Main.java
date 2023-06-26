package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import data.FileXMLModel;
import data.FilesXMLAirline;
import data.FilesXMLAirplane;
import data.FilesXMLBrand;
import data.FilesXMLFlight;
import data.FilesXMLPassenger;
import data.FilesXMLTicket;
import domain.User;
import presentation.GUI_Brand;
import presentation.GUI_Main;


public class Controller_Main implements ActionListener{
	
	private GUI_Main gui_M;

	private Controller_Brand cBrand;
	private Controller_Model cModel;
	private Controller_Airline cAirline;
	private Controller_Airplane cAirplane;
	private Controller_Flight cFlight;
	private Controller_Passenger cPassenger;
	private Controller_Ticket cTicket;
	
	private FilesXMLBrand fXMLBrand;
	private FileXMLModel fXMLModel;
	private FilesXMLAirline fXMLAirline;
	private FilesXMLAirplane fXMLAirplane;
	private FilesXMLFlight fXMLFlight;
	private FilesXMLPassenger filesXMLPassenger;
	private FilesXMLTicket fXMLTicket;
	
	private User user;
	
	public Controller_Main(User user){
		
		System.out.println("Entro al Controller_Main");
		this.user= user;
		System.out.println(user.getType());
		gui_M= new GUI_Main();

		//Crea el archivo Brand.xml
		fXMLBrand= new FilesXMLBrand();
		fXMLBrand.createXML("Brand", "Brand.xml");
		
		//Crea el archivo Model.xml
		fXMLModel= new FileXMLModel();
		fXMLModel.createXML("Model", "Model.xml");
		
		fXMLAirline= new FilesXMLAirline();
		fXMLAirline.createXML("Airline", "Airline.xml");
		
		fXMLAirplane= new FilesXMLAirplane();
		fXMLAirplane.createXML("Airplane", "Airplane.xml");
		
		fXMLFlight= new FilesXMLFlight();
		fXMLFlight.createXML("Flight", "Flight.xml");
		
		filesXMLPassenger= new FilesXMLPassenger();
		filesXMLPassenger.createXML("Passenger", "Passenger.xml");
		//fXMLAirplane.createXML("Passenger", "Passenger.xml");
		
		fXMLTicket= new FilesXMLTicket();
		fXMLTicket.createXML("Ticket", "Ticket.xml");
		
		initializer();
	}
	
	public void initializer() {
		gui_M.getBtnMbrand().addActionListener(this);
		gui_M.getBtnMModel().addActionListener(this);
		gui_M.getBtnMAirline().addActionListener(this);
		gui_M.getBtnMAirplane().addActionListener(this);
		gui_M.getBtnMFlights().addActionListener(this);
		gui_M.getBtnMPassenger().addActionListener(this);
		gui_M.getBTicket().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==gui_M.getBtnMbrand()) {
			//abre la pestaña GUI_Brand;
			//JOptionPane.showMessageDialog(null, "Si entra al if");
			cBrand= new Controller_Brand(user,fXMLBrand,fXMLModel);
		}
		if (e.getSource()==gui_M.getBtnMModel()) {
			//Abre la pestaña GUI_Model;

			cModel= new Controller_Model(user, fXMLAirplane);
			JOptionPane.showMessageDialog(null, "Entra a models");
		}
		if(e.getSource()== gui_M.getBtnMAirline()) {
			//Abre la pestaña GUI_Airline
			JOptionPane.showMessageDialog(null, "Entra a Airlines");
			cAirline= new Controller_Airline(user,fXMLAirplane);
			
		}
		if (e.getSource()==gui_M.getBtnMAirplane()) {
			//Abre la pestaña GUI_Airplane
			JOptionPane.showMessageDialog(null, "Entra a Airplane");
			cAirplane= new Controller_Airplane(user);
		}
		if (e.getSource()==gui_M.getBtnMFlights()) {
			JOptionPane.showMessageDialog(null, "Entra a Vuelos");
			cFlight= new Controller_Flight(user);
		}
		if (e.getSource()==gui_M.getBtnMPassenger()) {
			JOptionPane.showMessageDialog(null, "Entra a Pasajeros");
			cPassenger= new Controller_Passenger(user);
		}
		if (e.getSource()==gui_M.getBTicket()) {
			JOptionPane.showMessageDialog(null, "Entra a Tiquetes");
			cTicket= new Controller_Ticket(user);
		}
		
	}
}
