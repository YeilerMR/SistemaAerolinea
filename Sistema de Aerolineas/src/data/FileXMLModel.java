package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Brand;
import domain.Model;

public class FileXMLModel extends FilesXMLGlobal{

	private Model model;
	private Object data[][];
	public FileXMLModel() {}

//	public void createXML(String objectName,String fileName) {
//
//		File file = new File(fileName);
//
//		if(!file.exists()) {
//			try {
//				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//
//				Document doc = dBuilder.newDocument();
//
//				Element rootElement = doc.createElement(objectName);
//				doc.appendChild(rootElement);
//
//				TransformerFactory transformerFactory = TransformerFactory.newInstance();
//				Transformer transformer = transformerFactory.newTransformer();
//
//				DOMSource source = new DOMSource(doc);
//
//				StreamResult result = new StreamResult(file);
//				transformer.transform(source, result);
//
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}//fin de CreateXML
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	public Model searchBrand(String path, String elementType, String data) {
//		//model= new Model();
//		
//		try {
//	        // Load the XML file
//	        File inputFile = new File(path);
//	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder builder = factory.newDocumentBuilder();
//	        Document doc = builder.parse(inputFile);
//
//	        // Find the user node with the given ID
//	        NodeList nodes = doc.getElementsByTagName(elementType);
//	        for (int i = 0; i < nodes.getLength(); i++) {
//	            Node node = nodes.item(i);
//	            if (node.getNodeType() == Node.ELEMENT_NODE) {
//	                Element element = (Element) node;
//	                String userAttribute = element.getAttribute("name");
//
//	                if (userAttribute.equalsIgnoreCase(data)) {
//	                	
//	                    // Retrieve the user information
//	                	
////	                    String name = element.getElementsByTagName("name").item(0).getTextContent();
////	                    String type = element.getElementsByTagName("type").item(0).getTextContent();
////	                    String state = element.getElementsByTagName("state").item(0).getTextContent();
//
//	                    // Create and return the user object
//	                	
//	                    Brand brand = new Brand(userAttribute);
//	                    return brand;
//	                }
//	            }
//	        }
//
//	        return null;
//
//	    } catch (ParserConfigurationException | SAXException | IOException e) {
//	        e.printStackTrace();
//	        return null;
//	    }
//	}//fin de SearchBrand
	
//	public void writeXML(String FileName, String elementType, String[] dataName, String[] data) {
//
//		try {
//
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = dbf.newDocumentBuilder();
//
//			Document doc = db.parse(new File(FileName));
//			doc.getDocumentElement().normalize();
//
//			Element rootElement  =  doc.getDocumentElement();
//
//			Element ele = doc.createElement(elementType);
//			rootElement.appendChild(ele);
//
//			Attr attr = doc.createAttribute(dataName[0]);
//			attr.setValue(data[0]);
//			ele.setAttributeNode(attr);
//
//			for(int i = 1; i < data.length; i++){
//
//				Element dato = doc.createElement(dataName[i]);
//				
//				//Agregue el if para saber cuando hay un valor y cuando no.
//				
//				dato.appendChild(doc.createTextNode(data[i]));
//				ele.appendChild(dato);
//				
//			}
//
//			//escribirmos el contenido en un archivo xml
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//
//			DOMSource source = new DOMSource(doc);
//
//			StreamResult result = new StreamResult(new File(FileName));
//			transformer.transform(source, result);
//
//		}catch(ParserConfigurationException pce) {
//
//			pce.printStackTrace();
//
//		}catch (SAXException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		} catch (TransformerConfigurationException e) {
//
//			e.printStackTrace();
//		} catch (TransformerException e) {
//
//			e.printStackTrace();
//		}
//	}//Fin de writeXML
	
//	public void deleteFromXML(String filePath, String elementType, String data) {
//		
//		try {
//			File file= new File(filePath);
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder builder = factory.newDocumentBuilder();
//	        Document doc = builder.parse(file);
//	        
//	        NodeList nodes= doc.getElementsByTagName(elementType);
//	        for (int i = 0; i < nodes.getLength(); i++) {
//				Node node= nodes.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					Element element = (Element) node;
//					String userAttribute= element.getAttribute("name");
//					if(userAttribute.equalsIgnoreCase(data)) {
//						element.getParentNode().removeChild(element);
//						
//						TransformerFactory transformerFactory = TransformerFactory.newInstance();
//	                    Transformer transformer = transformerFactory.newTransformer();
//	                    DOMSource source = new DOMSource(doc);
//	                    StreamResult result = new StreamResult(file);
//	                    transformer.transform(source, result);
//	                    
//	                    //return true;
//					}
//				}
//			}
//	        //return false;
//		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
//			e.printStackTrace();
//			//return false;
//		}
//	}//fin de deleteModel
//	
	public void updateModel(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
	
//	public boolean checkExists(String fileName,String elementType ,String name) {
//        try {
//        	System.out.println("Entro al metodo checkExists");
//            File inputFile = new File(fileName);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            
//            
//            doc.getDocumentElement().normalize();
//
//            NodeList nodeList = doc.getElementsByTagName(elementType);
//
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                	System.out.println("Entro al if del for");
//                    Element element = (Element) node;
//                    String userAttribute = element.getAttribute("name");
//
//                    if (userAttribute.equalsIgnoreCase(name)) {
//                    	System.out.println("Si es igual a["+name+"]");
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }//Fin checkExist
//	
//	public boolean checkExistsBrand(String fileName, String name) {
//		try {
//			System.out.println("Entro al metodo checkExists");
//			File inputFile = new File(fileName);
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			Document doc = dBuilder.parse(inputFile);
//			
//			
//			doc.getDocumentElement().normalize();
//			
//			NodeList nodeList = doc.getElementsByTagName("Modelo");
//			
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Node node = nodeList.item(i);
//				
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					System.out.println("Entro al if del for");
//					Element element = (Element) node;
//					String userAttribute = element.getAttribute("name");
//					
//					if (userAttribute.equalsIgnoreCase(name)) {
//						System.out.println("Si es igual a["+name+"]");
//						return true;
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}//Fin checkExist
	
	public ArrayList<Model> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Model> arrayModels;
		arrayModels = new ArrayList<Model>();
	
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

					model= new Model(eElement.getAttribute("name"),
							eElement.getElementsByTagName("brand").item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName("bClass").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("tClass").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("eClass").item(0).getTextContent()));
					
					arrayModels.add(model);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayModels;
	}//fin de readXMLToArrayList
	
	public void setDataMatrixModel(ArrayList<Model> arrayModel) {
		data= new Object[arrayModel.size()][5];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayModel.get(i).getName();
			data[i][1]= arrayModel.get(i).getArrayBrands();
			data[i][2]= arrayModel.get(i).getSeatsBClass();
			data[i][3]= arrayModel.get(i).getSeatsTClass();
			data[i][4]= arrayModel.get(i).getSeatsEconomics();
			
		}
	}//fin setDataMatrixModel
	
	public String  getModels(ArrayList<Model> arrayModel){
		String models = "";
		for(Model m  : arrayModel) {
			models += m.toString();
		}
		return models;
	}//fin getModels
	
	public Object [][] getDataMatrixModel(){
		return this.data;
	}//fin getDataMatrixModel
	
	
	public ArrayList<Model> readModel(ArrayList<Model> arrayModel, String dataTXT) {
//		System.out.println("ENTRO AL METODO [readBrand]");
//		System.out.println("DataTXT: "+dataTXT);
		ArrayList<Model> arrayConsult=new ArrayList<Model>();
		for (int i = 0; i < arrayModel.size(); i++) {
			
			if (dataTXT.equalsIgnoreCase(arrayModel.get(i).getName())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayModel.get(i).getName()+"}");
				arrayConsult.add(arrayModel.get(i));
			}
		}
		
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}//fin de readModel
	
}
