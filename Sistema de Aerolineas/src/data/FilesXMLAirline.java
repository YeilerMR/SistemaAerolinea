package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Airline;

public class FilesXMLAirline extends FilesXMLGlobal{

	private Airline airline;
	private String data[][];
	private ArrayList<String> arrayAirlines= new ArrayList<String>();
	public FilesXMLAirline() {}
	

	public void updateAirline(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
		try {
			File file= new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(file);
	        
	        NodeList nodes = doc.getElementsByTagName(elementType);
	        for (int i = 0; i < nodes.getLength(); i++) {
				Node node= nodes.item(i);
				if (node.getNodeType()==Node.ELEMENT_NODE) {
					Element element= (Element) node;
					String userAttribute= element.getAttribute("name");
					System.out.println("\nupdateBrand: "+data[0]+"\nuserAttribute: "+userAttribute);
					if (userAttribute.equalsIgnoreCase(nameChange)) {
						//System.out.println("Si es igual a::"+data[0]);
						element.setAttribute("name", data[0]);
						for (int j = 1; j < dataName.length; j++) {
							NodeList childNodes= element.getElementsByTagName(dataName[j]);
							Element childElement= (Element)childNodes.item(0); 
							childElement.setTextContent(data[j]);
							
						}//for
						
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
	                    Transformer transformer = transformerFactory.newTransformer();
	                    DOMSource source = new DOMSource(doc);
	                    StreamResult result = new StreamResult(file);
	                    transformer.transform(source, result);
	                    
	                    break;
					}//if
				}//if
			}//for
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}//fin de updateBrand
	

	public ArrayList<Airline> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Airline> arrayModels;
		arrayModels = new ArrayList<Airline>();
	
		try {
			File inputFile = new File(address);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName(elementType);
			
			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;

					airline= new Airline(eElement.getAttribute("name"),
							eElement.getElementsByTagName("operationC")
							.item(0).getTextContent());
					
					arrayModels.add(airline);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayModels;
	}//fin de readXMLToArrayList
	
	public void setDataMatrixAirline(ArrayList<Airline> arrayAirlines) {
		data= new String[arrayAirlines.size()][2];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayAirlines.get(i).getName();
			data[i][1]= arrayAirlines.get(i).getOperationCenter();
		}
	}//fin de setDataMatrixAirline
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setAirlines(ArrayList<Airline> arrayAirline) {
		for (int i = 0; i < arrayAirline.size(); i++) {
			this.arrayAirlines.add(arrayAirline.get(i).getName());
		}
	}
	public ArrayList<String> getArrayAirlines(){
		return this.arrayAirlines;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String getAirlines(ArrayList<Airline> arrayAirline) {
		String airlines= "";
		for (Airline a : arrayAirline) {
			airlines+= airlines.toString();
		}
		return airlines;
	}//fin de getAirlines
	public String [][] getDataMatrixAirline(){
		return this.data;
	}
	
	//FALTA READAIRLINE
	public ArrayList<Airline> readAirline(ArrayList<Airline> arrayAirline, String dataTXT){
		
		ArrayList<Airline> arrayConsult= new ArrayList<Airline>();
		for (int i = 0; i < arrayAirline.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayAirline.get(i).getName())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayAirline.get(i).getName()+"}");
				arrayConsult.add(arrayAirline.get(i));
			}
		}
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}
}//fin de FilesXMLAirline
