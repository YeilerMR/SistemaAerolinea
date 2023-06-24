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

import domain.Flight;

public class FilesXMLFlight extends FilesXMLGlobal{

	private Flight flight;
	private String data[][];
	public FilesXMLFlight() {}
	
	public void updateFlight(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
					String userAttribute= element.getAttribute("nFlight");
					System.out.println("\nupdateBrand: "+data[0]+"\nuserAttribute: "+userAttribute);
					if (userAttribute.equalsIgnoreCase(nameChange)) {
						//System.out.println("Si es igual a::"+data[0]);
						element.setAttribute("nFlight", data[0]);
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

public ArrayList<Flight> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Flight> arrayFlights;
		arrayFlights = new ArrayList<Flight>();
	
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

					flight= new Flight(eElement.getAttribute("nFlight"),
							eElement.getElementsByTagName("cityE").item(0).getTextContent(), 
							eElement.getElementsByTagName("hourE").item(0).getTextContent(), 
							eElement.getElementsByTagName("dateE").item(0).getTextContent(), 
							eElement.getElementsByTagName("airplane").item(0).getTextContent(), 
							eElement.getElementsByTagName("cityA").item(0).getTextContent(),
							eElement.getElementsByTagName("hourA").item(0).getTextContent(), 
							eElement.getElementsByTagName("dateA").item(0).getTextContent(), 
							Integer.parseInt(eElement.getElementsByTagName("pClassB").item(0).getTextContent()), 
							Integer.parseInt(eElement.getElementsByTagName("pClassT").item(0).getTextContent()), 
							Integer.parseInt(eElement.getElementsByTagName("pClassE").item(0).getTextContent()));
//				
//							eElement.getElementsByTagName("airlines").item(0).getTextContent(),
//							eElement.getElementsByTagName("models").item(0).getTextContent(),
//							eElement.getElementsByTagName("year").item(0).getTextContent());
//					
					arrayFlights.add(flight);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayFlights;
	}//fin de readXMLToArrayList

	public void setDataMatrixFlight(ArrayList<Flight> arrayFlights) {
		data= new String[arrayFlights.size()][11];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayFlights.get(i).getnFlight();
			data[i][1]= arrayFlights.get(i).getCityE();
			data[i][2]= arrayFlights.get(i).getHourE();
			data[i][3]= arrayFlights.get(i).getDateE();
			data[i][4]= arrayFlights.get(i).getAirplane();
			data[i][5]= arrayFlights.get(i).getCityA();
			data[i][6]= arrayFlights.get(i).getHourA();
			data[i][7]= arrayFlights.get(i).getDateA();
			//puede cambiar en el futuro
			data[i][8]= ""+arrayFlights.get(i).getpClassB();
			data[i][9]= ""+arrayFlights.get(i).getpClassT();
			data[i][10]= ""+arrayFlights.get(i).getpClassE();
		}
	}
	public String getFlights(ArrayList<Flight> arrayFlights) {
		String flights= "";
		for (Flight f : arrayFlights) {
			flights+= f.toString();
		}
		return flights;
	}
	public String[][] getDataMatrixFligh(){
		return this.data;
	}
	
	public ArrayList<Flight> readFlight(ArrayList<Flight> arrayFlight,String dataTXT){
		ArrayList<Flight> arrayConsult= new ArrayList<Flight>();	
	
		for (int i = 0; i < arrayFlight.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayFlight.get(i).getnFlight())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayFlight.get(i).getnFlight()+"}");
				arrayConsult.add(arrayFlight.get(i));
			}
		}
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}
}
