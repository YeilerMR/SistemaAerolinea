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

import domain.Airplane;

public class FilesXMLAirplane extends FilesXMLGlobal{

	private Airplane airplane;
	private String data[][];
	private ArrayList<String> arrayAirplanes= new ArrayList<String>();
	public FilesXMLAirplane() {}
	
	public void deleteFromXMLAirplane(String filePath, String elementType, String data) {
		
		try {
			File file= new File(filePath);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(file);
	        
	        NodeList nodes= doc.getElementsByTagName(elementType);
	        for (int i = 0; i < nodes.getLength(); i++) {
				Node node= nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String userAttribute= element.getAttribute("registration");
					if(userAttribute.equalsIgnoreCase(data)) {
						element.getParentNode().removeChild(element);
						
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
	                    Transformer transformer = transformerFactory.newTransformer();
	                    DOMSource source = new DOMSource(doc);
	                    StreamResult result = new StreamResult(file);
	                    transformer.transform(source, result);
	                    
	                    //return true;
					}
				}
			}
	        //return false;
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
			//return false;
		}
	}//fin de deleteModel
	
	public boolean checkExistsAirplane(String fileName,String elementType ,String name) {
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
                    String userAttribute = element.getAttribute("registration");

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
	
	public void updateAirplane(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
					String userAttribute= element.getAttribute("registration");
					System.out.println("\nupdateBrand: "+data[0]+"\nuserAttribute: "+userAttribute);
					if (userAttribute.equalsIgnoreCase(nameChange)) {
						//System.out.println("Si es igual a::"+data[0]);
						element.setAttribute("registration", data[0]);
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
	
	public ArrayList<Airplane> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Airplane> arrayAirplanes;
		arrayAirplanes = new ArrayList<Airplane>();
	
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

					airplane= new Airplane(eElement.getAttribute("registration"),
							eElement.getElementsByTagName("airlines").item(0).getTextContent(),
							eElement.getElementsByTagName("models").item(0).getTextContent(),
							eElement.getElementsByTagName("year").item(0).getTextContent());
					
					arrayAirplanes.add(airplane);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayAirplanes;
	}//fin de readXMLToArrayList
	
	public void setDataMatrixAirplane(ArrayList<Airplane> arrayAirplanes) {
		data= new String[arrayAirplanes.size()][4];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayAirplanes.get(i).getRegistration();
			data[i][1]= arrayAirplanes.get(i).getArrayAirlines();
			data[i][2]= arrayAirplanes.get(i).getArrayModels();
			data[i][3]= arrayAirplanes.get(i).getYear();
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setAirplane(ArrayList<Airplane> arrayAirplane) {
		for (int i = 0; i < arrayAirplane.size(); i++) {
			this.arrayAirplanes.add(arrayAirplane.get(i).getRegistration());
		}
	}
	public ArrayList<String> getArrayAirplanes(){
		return this.arrayAirplanes;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String getAirplanes(ArrayList<Airplane> arrayAirplanes) {
		String airplanes="";
		for (Airplane air : arrayAirplanes) {
			airplanes+= air.toString();
		}
		return airplanes;
	}

	public String[][] getDataMatrixAirplane(){
		return this.data;
	}
	
	public ArrayList<Airplane> readAirplane(ArrayList<Airplane> arrayAirplane, String dataTXT){
		ArrayList<Airplane> arrayConsult= new ArrayList<Airplane>();
		
		for (int i = 0; i < arrayAirplane.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayAirplane.get(i).getRegistration())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayAirplane.get(i).getRegistration()+"}");
				arrayConsult.add(arrayAirplane.get(i));
			}
		}
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}
	
}//fin de FilesXMLAirplane
