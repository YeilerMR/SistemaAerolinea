package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import presentation.GUI_Brand;
import presentation.GUI_Main;


public class Controller_Main implements ActionListener{
	
	private GUI_Main gui_M;

	private Controller_Brand cBrand;
	private Controller_Model cModel;
	
	public Controller_Main(){
		gui_M= new GUI_Main();

		initializer();
	}
	
	public void initializer() {
		gui_M.getBtnMbrand().addActionListener(this);
		gui_M.getBtnMModel().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==gui_M.getBtnMbrand()) {
			//abre la pestaña GUI_Brand;
			JOptionPane.showMessageDialog(null, "Si entra al if");
			cBrand= new Controller_Brand();
		}
		if (e.getSource()==gui_M.getBtnMModel()) {
			//Abre la pestaña GUI_Model;
			cModel= new Controller_Model();
			JOptionPane.showMessageDialog(null, "Entra a models");
		}
		if(e.getSource()== gui_M.getBtnMAirline()) {
			//Abre la pestaña GUI_Airline
			
		}
		if (e.getSource()==gui_M.getBtnMAirplane()) {
			//Abre la pestaña GUI_Airplane
		}
		if (e.getSource()==gui_M.getBtnMFlights()) {
			
		}
		
	}
}
