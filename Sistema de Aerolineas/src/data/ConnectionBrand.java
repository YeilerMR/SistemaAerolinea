package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Brand;


public class ConnectionBrand extends FilesXML{

	private String data[][];
	public ConnectionBrand(){
		// TODO Auto-generated constructor stub
	}
	
	//Crear
//	
//	public void addObject(String fileName, String name, Object object) {
//		if(lXML.checkBrandExists(nameFile,gui.getTxtNombre().getText())) {
//			gui.showMessage("Ya existe una marca con este nombre");
//		}else {
//			brand= new Brand(gui.getTxtNombre().getText());
//			fXML.writeXML(nameFile, "Marca", brand.getDataName(), brand.getData());
//			gui.clearForm();
//			gui.showMessage("Se agrego una marca exitosamente");
//		}
//	}
//	
	//puede dar error.
	public boolean checkExists(String fileName, String name) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Marca");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String userAttribute = element.getAttribute("name");

                    if (userAttribute.equals(name)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
	//Modificar
	//Eliminar
	//ArrayList<Brand>
	public ArrayList<Brand> readBrand(ArrayList<Brand> arrayBrand, String dataTXT) {
//		System.out.println("ENTRO AL METODO [readBrand]");
//		System.out.println("DataTXT: "+dataTXT);
		ArrayList<Brand> arrayConsult=new ArrayList<Brand>();
		for (int i = 0; i < arrayBrand.size(); i++) {
			
			if (dataTXT.equalsIgnoreCase(arrayBrand.get(i).getNombre())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayBrand.get(i).getNombre()+"}");
				arrayConsult.add(arrayBrand.get(i));
			}
		}
		
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		//return arrayConsult;
		//setDataMatrixBrand(arrayBrand);
		return arrayConsult;
	}
	public void deleteBrand(ArrayList<Brand> arrayBrand, String dataTXT) {
		//String message= "No se encuentra la marca["+dataTXT+"]";;
		
		for (int i = 0; i < arrayBrand.size(); i++) {
			System.out.println("Entra al for!!"+arrayBrand.get(i).getNombre());
			//System.out.println(dataTXT);
			if (arrayBrand.get(i).getNombre().equalsIgnoreCase(dataTXT)) {
				System.out.println("\n\nSi encontro: "+arrayBrand.get(i).getNombre());
				arrayBrand.remove(i);
				//message= "Se elimino correctamente la marca["+dataTXT+"]";
				
			}
		}
		
	}
	
	public void setDataMatrixBrand(ArrayList<Brand> arrayBrand) {
		data= new String[arrayBrand.size()][1];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayBrand.get(i).getNombre();
		}
	}
	public String  getBrands(ArrayList<Brand> arrayBrand){
		String brands = "";
		for(Brand b : arrayBrand) {
			brands += b.toString();
		}
		return brands;
	} 
	
	public String [][] getDataMatrixBrand(){
		return this.data;
	}
}
