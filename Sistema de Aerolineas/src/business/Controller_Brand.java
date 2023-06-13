package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import data.FilesXML;
import data.LogicXML;
import domain.Brand;
import domain.User;
import presentation.GUI_Brand;

public class Controller_Brand implements ActionListener{

	//private Path path;
	
	private GUI_Brand gui;
	private FilesXML fXML;
	private LogicXML lXML;
	private Brand brand;
	
	private User user;
	
	//private String path= "C:\\Users\\yeile\\git\\ProyectoAerolineas\\Sistema de Aerolineas\\";
	
	public Controller_Brand(User user) {
		
		
		fXML= new FilesXML();
		fXML.createXML("Brand","Brand.xml");
		lXML= new LogicXML();
		
		gui= new GUI_Brand(user,lXML);
		
		
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
			
			//Agrega los datos a la tabla
			gui.getDTMBrand().addRow(brand.getData());
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
