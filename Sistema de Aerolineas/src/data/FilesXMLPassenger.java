package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

import domain.Airplane;
import domain.Passenger;

public class FilesXMLPassenger extends FilesXMLGlobal{

	private Passenger passenger;
	private String data[][];
	private ArrayList<String> arrayPassengers= new ArrayList<String>();
	
	public FilesXMLPassenger() {}
	
	
	public boolean checkExistsPassenger(String fileName,String elementType ,String passport) {
        try {
        	System.out.println("Entro al metodo checkExists");
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(elementType);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	System.out.println("Entro al if del for");
                    Element element = (Element) node;
                    String userAttribute = element.getAttribute("nPassport");

                    if (userAttribute.equalsIgnoreCase(passport)) {
                    	System.out.println("Si es igual a["+passport+"]");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }//Fin checkExist
	
	
	public void updatePassenger(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
					String userAttribute= element.getAttribute("nPassport");
					System.out.println("\nupdateBrand: "+data[0]+"\nuserAttribute: "+userAttribute);
					if (userAttribute.equalsIgnoreCase(nameChange)) {
						//System.out.println("Si es igual a::"+data[0]);
						//element.setAttribute("nPassport", data[0]);
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

	public ArrayList<Passenger> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Passenger> arrayPassengers;
		arrayPassengers = new ArrayList<Passenger>();
	
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
					
					//String[] dataName= {"nPassport","name","lastName","dateBirth","email","phone"};

					passenger= new Passenger(eElement.getAttribute("nPassport"), 
							eElement.getElementsByTagName("name").item(0).getTextContent(), 
							eElement.getElementsByTagName("lastName").item(0).getTextContent(), 
							eElement.getElementsByTagName("dateBirth").item(0).getTextContent(), 
							eElement.getElementsByTagName("email").item(0).getTextContent(), 
							eElement.getElementsByTagName("phone").item(0).getTextContent());
					
					arrayPassengers.add(passenger);
					//arrayAirplanes.add(airplane);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayPassengers;
	}//fin de readXMLToArrayList
	
	public void setDataMatrixPassenger(ArrayList<Passenger> arrayPassengers) {
		data=new String[arrayPassengers.size()][6];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayPassengers.get(i).getnPassport();
			data[i][1]= arrayPassengers.get(i).getName();
			data[i][2]= arrayPassengers.get(i).getLastName();
			data[i][3]= arrayPassengers.get(i).getDateBirth();
			data[i][4]= arrayPassengers.get(i).getEmail();
			data[i][5]= arrayPassengers.get(i).getPhone();
		}
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setPassengers(ArrayList<Passenger> arrayPassenger) {
		for (int i = 0; i < arrayPassenger.size(); i++) {
			this.arrayPassengers.add(arrayPassenger.get(i).getnPassport());
		}
	}
	public ArrayList<String> getArrayPassengers(){
		return this.arrayPassengers;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String getPassengers(ArrayList<Passenger> arrayPassengers) {
		String passengers="";
		for (Passenger p : arrayPassengers) {
			passengers+=p.toString();
		}
		return passengers;
	}//fin de getPassengers
	public String[][] getDataMatrixPassenger(){
		return this.data;
	}
	
	public ArrayList<Passenger> readPassenger(ArrayList<Passenger> arrayPassenger, String dataTXT){
		ArrayList<Passenger> arrayConsult= new ArrayList<Passenger>();
		for (int i = 0; i < arrayPassenger.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayPassenger.get(i).getnPassport())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayPassenger.get(i).getnPassport()+"}");
				arrayConsult.add(arrayPassenger.get(i));
			}
		}
		return arrayConsult;
	}//fin de readPassenger
	
}
