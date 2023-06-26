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

import domain.Ticket;

public class FilesXMLTicket extends FilesXMLGlobal{

	private Ticket ticket;
	private String data[][];
	private ArrayList<String> arrayTickets= new ArrayList<String>();	
	public FilesXMLTicket() {}
	
	public void updateTickets(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
					String userAttribute= element.getAttribute("nTicket");
					System.out.println("\nupdateBrand: "+data[0]+"\nuserAttribute: "+userAttribute);
					if (userAttribute.equalsIgnoreCase(nameChange)) {
						//System.out.println("Si es igual a::"+data[0]);
						element.setAttribute("nTicket", data[0]);
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
	
public ArrayList<Ticket> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Ticket> arrayTickets;
		arrayTickets = new ArrayList<Ticket>();
	
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

					ticket= new Ticket(eElement.getAttribute("nTicket"),
							eElement.getElementsByTagName("passport").item(0).getTextContent(),
							eElement.getElementsByTagName("nFlight").item(0).getTextContent(),
							eElement.getElementsByTagName("sType").item(0).getTextContent());
//					airplane= new Airplane(,
//							eElement.getElementsByTagName("airlines").item(0).getTextContent(),
//							eElement.getElementsByTagName("models").item(0).getTextContent(),
//							eElement.getElementsByTagName("year").item(0).getTextContent());
//					
					arrayTickets.add(ticket);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayTickets;
	}//fin de readXMLToArrayList

	public boolean checkExistsTicket(String fileName,String elementType ,String name) {
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
	                String userAttribute = element.getAttribute("nTicket");
	
	                if (userAttribute.equalsIgnoreCase(name)) {
	                	System.out.println("Si es igual a["+name+"]");
	                    return true;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	    return false;
	}//Fin checkExist

	public void setDataMatrixTicket(ArrayList<Ticket> arrayTickets) {
		data= new String[arrayTickets.size()][4];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayTickets.get(i).getnTicket();
			data[i][1]= arrayTickets.get(i).getPassport();
			data[i][2]= arrayTickets.get(i).getnFlight();
			data[i][3]= arrayTickets.get(i).getsType();
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTicket(ArrayList<Ticket> arrayTicket) {
		for (int i = 0; i < arrayTicket.size(); i++) {
			this.arrayTickets.add(arrayTicket.get(i).getnTicket());
		}
	}
	public ArrayList<String> getArrayTickets(){
		return this.arrayTickets;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String getTickets(ArrayList<Ticket> arrayTickets) {
		String tickets="";
		for (Ticket tick : arrayTickets) {
			tickets+= tick.toString();
		}
		return tickets;
	}

	public String[][] getDataMatrixticket(){
		return this.data;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public ArrayList<Ticket> readTicket(ArrayList<Ticket> arrayTicket, String dataTXT){
		ArrayList<Ticket> arrayConsult= new ArrayList<Ticket>();
		
		for (int i = 0; i < arrayTicket.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayTicket.get(i).getnTicket())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayTicket.get(i).getnTicket()+"}");
				arrayConsult.add(arrayTicket.get(i));
			}
		}
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}
	
}//fin de FilesXMLTicket
