package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import data.ConnectionBrand;
import data.FilesXML;
import data.LogicXML;
import domain.Brand;
import domain.User;
import presentation.GUI_Brand;

public class Controller_Brand implements ActionListener{

	//private Path path;
	
	private GUI_Brand gui;
	private FilesXML fXML;
	private ConnectionBrand connectBrand;
	private Brand brand;
	String dataTXT;
	//private User user;
	
	final String nameFile= "Brand.xml";
	private ArrayList<Brand> arrayBrands;
	//private ArrayList<Brand> arrayAuxi;
	
	public Controller_Brand(User user) {
		
		
		fXML= new FilesXML();
		fXML.createXML("Brand",nameFile);
		connectBrand= new ConnectionBrand();
		
		
		gui= new GUI_Brand(user);
		brand= new Brand(gui.getTxtNombre().getText());
		
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
			
			//LISTO EL MODULO AGREGAR
			String dataTXT= gui.getTxtNombre().getText();
			if (isEmpty(dataTXT)) {
				gui.showMessage("No puede dejar el espacio 'Nombre' en blanco");
			}else {
				
				if(connectBrand.checkExists(nameFile,dataTXT)) {
					gui.showMessage("Ya existe una marca con este nombre");
				}else {
						brand= new Brand(gui.getTxtNombre().getText());
						fXML.writeXML(nameFile, "Marca", brand.getDataName(), brand.getData());
						gui.clearForm();
						gui.showMessage("Se agrego una marca exitosamente");
					
					
				}
			}
		}
		if (e.getSource()==gui.getBModificar()) {
			//EN PROCESO
			gui.showMessage("Modificar");
		}
		if (e.getSource()==gui.getBConsultar()) {
			
			//LISTO EL MODULO CONSULTAR
			String dataTXT=gui.getTxtNombre().getText();
			arrayBrands= fXML.readXMLToArrayList(nameFile, "Marca", dataTXT);
			
			connectBrand.setDataMatrixBrand(arrayBrands);
			if (isEmpty(dataTXT)) {
				
				gui.getDTMBrand().setDataVector(connectBrand.getDataMatrixBrand(), gui.columnName);
			}else {
				//System.out.println("Data en el if del boton"+dataTXT);
				arrayBrands= connectBrand.readBrand(arrayBrands, dataTXT);
				connectBrand.setDataMatrixBrand(arrayBrands);
				gui.getDTMBrand().setDataVector(connectBrand.getDataMatrixBrand(), gui.columnName);
				gui.clearForm();
			}
	
		}
		if (e.getSource()==gui.getBEliminar()) {
			
			//EN PROCESO
			String dataTXT=gui.getTxtNombre().getText();
			arrayBrands= fXML.readXMLToArrayList(nameFile, "Marca", dataTXT);

			connectBrand.deleteBrand(arrayBrands, dataTXT);
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			String dataTXT=gui.getTxtNombre().getText();
//			arrayBrands= fXML.readXMLToArrayList(nameFile, "Marca", dataTXT);
//			
//			gui.showMessage(connectBrand.deleteBrand(arrayBrands, dataTXT));
//			
//			fXML.createXML("Brand",nameFile);
//			
//			
//			gui.getDTMBrand().setDataVector(connectBrand.getDataMatrixBrand(), gui.columnName);
			
		}
		
	}
	
	public boolean isEmpty(String text) {
		boolean valid;
		
		if (text.equalsIgnoreCase("")) {
			valid= true;
		}else {
			valid= false;
		}
		return valid;
	}
	public void array(ArrayList<Brand> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println("\n"+array.get(i).getNombre());
		}
	}

}
