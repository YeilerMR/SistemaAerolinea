package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import data.FileXMLModel;
//import data.ConnectionBrand;
import data.FilesXML;
import data.FilesXMLBrand;
import data.LogicXML;
import domain.Brand;
import domain.User;
import presentation.GUI_Brand;

public class Controller_Brand implements ActionListener{

	//private Path path;
	
	private GUI_Brand gui;
	
	private FilesXMLBrand fXMLBrand;
	private FileXMLModel fXMLModel;
	
	private Brand brand;
	String dataTXT;

	
	final String nameFile= "Brand.xml";
	final String nameFModel= "Model.xml";
	private ArrayList<Brand> arrayBrands;
	
	
	public Controller_Brand(User user, FilesXMLBrand filesXMLBrand, FileXMLModel fileXMLModel) {
		
		this.fXMLBrand= filesXMLBrand;
		this.fXMLModel= fileXMLModel;
//		fXMLBrand= new FilesXMLBrand();
//		fXMLBrand.createXML("Brand", nameFile);
		
//		connectBrand= new ConnectionBrand();
		
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
			addBrand();
		}
		if (e.getSource()==gui.getBModificar()) {
			//LISTO EL MODULO MODIFICAR
			updateBrand();
			
		}
		if (e.getSource()==gui.getBConsultar()) {
			//LISTO EL MODULO CONSULTAR
			consultBrands();
		}
		if (e.getSource()==gui.getBEliminar()) {
			//LISTO EL MODULO ELIMINAR!!!
			deleteBrand();
		}
		
	}
	//Verifica si el jtext esta vacio
	public boolean isEmpty(String text) {
		boolean valid;
		
		if (text.equalsIgnoreCase("")) {
			valid= true;
		}else {
			valid= false;
		}
		return valid;
	}//fin de isEmpty
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//imprime la lista de marcas del xml
	public void array(ArrayList<Brand> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println("\n"+array.get(i).getNombre());
		}
	}//fin de array
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Agrega una marca al xml
	private void addBrand() {
		String dataTXT= gui.getTxtNombre().getText();
		if (isEmpty(dataTXT)) {
			gui.showMessage("No puede dejar el espacio 'Nombre' en blanco");
		}else {
			//Hasta Aqui todo bien.
			
			if(fXMLBrand.checkExists(nameFile,dataTXT)) {
				gui.showMessage("Ya existe una marca con este nombre");
			}else {
				
					brand= new Brand(gui.getTxtNombre().getText());
					fXMLBrand.writeXML(nameFile, "Marca", brand.getDataName(), brand.getData());
					gui.clearForm();
					gui.showMessage("Se agrego una marca exitosamente");
			}
		}
	}//fin de addBrand
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void updateBrand() {
		String dataTXT= gui.getTxtNombre().getText();
		String dataNew= gui.getTxtNew().getText();
		System.out.println("\n\nEntro al metodo modificar");
		if (isEmpty(dataTXT) || isEmpty(dataNew)) {
			gui.showMessage("No puede dejar el espacio 'Nombre' en blanco y el espacio 'Nuevo'");
		}else {
			if (fXMLBrand.checkExists(nameFile, dataTXT)) {
				//System.out.println("Entra al if y no hay datos en el brand"+brand.getNombre());
				brand= new Brand(dataNew);
				System.out.println("Desde el vector: "+brand.getData()[0]);
				fXMLBrand.updateBrand(nameFile, "Marca", brand.getDataName(), brand.getData(), dataTXT);
				gui.clearForm();
			}else {
				gui.showMessage("No hay una marca ["+dataTXT+"] registrada");
			}
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Imprime las marcas en una tabla
	private void consultBrands() {
		String dataTXT=gui.getTxtNombre().getText();
		arrayBrands= fXMLBrand.readXMLToArrayList(nameFile, "Marca", dataTXT);
		
		fXMLBrand.setDataMatrixBrand(arrayBrands);
		if (isEmpty(dataTXT)) {
			
			gui.getDTMBrand().setDataVector(fXMLBrand.getDataMatrixBrand(), gui.columnName);
		}else {
			
			arrayBrands= fXMLBrand.readBrand(arrayBrands, dataTXT);
			fXMLBrand.setDataMatrixBrand(arrayBrands);
			gui.getDTMBrand().setDataVector(fXMLBrand.getDataMatrixBrand(), gui.columnName);
			gui.clearForm();
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Elimina una marca del xml
	private void deleteBrand() {
		String dataTXT= gui.getTxtNombre().getText();
		if (fXMLBrand.checkExists(nameFile, dataTXT)) {
			fXMLBrand.deleteBrand(nameFile, "Marca", dataTXT);
			gui.showMessage("Se elimino la marca ["+dataTXT+"] Correctamente");
			gui.clearForm();
		}else {
			gui.showMessage("No se encontro la marca ["+dataTXT+"]");
		}
		
	}
}
