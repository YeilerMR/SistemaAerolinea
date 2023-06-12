package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import data.FilesXML;
import domain.Brand;
import presentation.GUI_Brand;

public class Controller_Brand implements ActionListener{

	//private Path path;
	
	private GUI_Brand gui;
	private FilesXML fXML;
	private Brand brand;
	//private String path= "C:\\Users\\yeile\\git\\ProyectoAerolineas\\Sistema de Aerolineas\\";
	
	public Controller_Brand() {
		
		gui= new GUI_Brand();
		fXML= new FilesXML();
		//path= new Path();
		
		//Indica el path donde se crea o crearan los archivos.
		fXML.createXML("Brand","Brand.xml");
//		
		initializer();
	}
	
	public void initializer() {
		gui.getBAgregar().addActionListener(this);
		gui.getBModificar().addActionListener(this);
		gui.getBConsultar().addActionListener(this);
		gui.getBEliminar().addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==gui.getBAgregar()) {
			//agregar avion al xml
			brand= new Brand(gui.getTxtNombre().getText());
			fXML.writeXML("Brand.xml", "Marca", brand.getDataName(), brand.getData());
			JOptionPane.showMessageDialog(null, "Se agrego la marca al xml");
		}
		if (e.getSource()==gui.getBModificar()) {
			gui.showMessage("Modificar");
		}
		if (e.getSource()==gui.getBConsultar()) {
			gui.showMessage("Consultar");
		}
		if (e.getSource()==gui.getBEliminar()) {
			gui.showMessage("Eliminar");
		}
		
	}

}
