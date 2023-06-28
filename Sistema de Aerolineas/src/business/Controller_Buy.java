package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;

import data.FilesXMLBuy;
import data.FilesXMLTicket;
import domain.Buy;
import presentation.GUI_Buy;

public class Controller_Buy implements ActionListener{
	
	private Buy buy;
	private GUI_Buy gui;
	private FilesXMLBuy fXMLBuy;
	private FilesXMLTicket filesXMLTicket;
	
	final String nameFile="Buy.xml";
	final String elementType="Compra";
	
	final String nameFileTickets= "Ticket.xml";
	
	private ArrayList<String> arrayStringTicket;
	

	public Controller_Buy() {
		gui= new GUI_Buy();
		
		fXMLBuy= new FilesXMLBuy();
		fXMLBuy.createXML(elementType, nameFile);
		loadTickets();
		
		initializer();
	}
	public void initializer() {
		gui.getBBuy().addActionListener(this);
	}
	private void loadTickets() {
		filesXMLTicket= new FilesXMLTicket();
		filesXMLTicket.setTicket(filesXMLTicket.readXMLToArrayList(nameFileTickets, "Tiquete"));
		arrayStringTicket= filesXMLTicket.getArrayTickets();
		gui.fillComboTicket(arrayStringTicket);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()== gui.getBBuy()) {
			gui.showMessage("Comprar");
			confirmBuy();
		}
	}
	private void confirmBuy() {
		String dataTickets= ""+gui.getComboTicket().getSelectedItem();
		String dataDate= gui.getLDate().getText();
		String dataHour= gui.getLHour().getText();
		int answer= gui.showConfirm(dataTickets);
		
		if (dataTickets.equals("Vacio")) {
			gui.showMessage("No dejar espacios en blanco");
		}else {
			switch (answer){
			case 0: 
				buy= new Buy(dataTickets,dataDate,dataHour);
				fXMLBuy.writeXML(nameFile, elementType, buy.getDataName(), buy.getData());
				break;
			case 2: 
				gui.showMessage("Se cancela la compra!!");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + answer);
				
			}
		
		}
	}//fin de confirmBuy

}//fin de Controller_Buy
