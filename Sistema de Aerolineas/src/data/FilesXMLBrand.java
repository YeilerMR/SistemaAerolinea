package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
import domain.User;

public class FilesXMLBrand {

	private Brand brand;
	private String data[][];
	public FilesXMLBrand() {}
	
	
	
	//Buscar
	
	public void createXML(String objectName,String fileName) {

		File file = new File(fileName);

		if(!file.exists()) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.newDocument();

				Element rootElement = doc.createElement(objectName);
				doc.appendChild(rootElement);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//fin de CreateXML
	
//	public Brand searchBrand(String path, String elementType, String data) {
//		//brand= new Brand();
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
//	                   // Brand brand = new Brand(userAttribute);
//	                	brand = new Brand(userAttribute);
//	                	
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

	public void writeXML(String FileName, String elementType, String[] dataName, String[] data) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(FileName));
			doc.getDocumentElement().normalize();

			Element rootElement  =  doc.getDocumentElement();

			Element ele = doc.createElement(elementType);
			rootElement.appendChild(ele);

			Attr attr = doc.createAttribute(dataName[0]);
			attr.setValue(data[0]);
			ele.setAttributeNode(attr);

			for(int i = 1; i < data.length; i++){

				Element dato = doc.createElement(dataName[i]);
				
				//Agregue el if para saber cuando hay un valor y cuando no.
				
				dato.appendChild(doc.createTextNode(data[i]));
				ele.appendChild(dato);
				
			}

			//escribirmos el contenido en un archivo xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);

		}catch(ParserConfigurationException pce) {

			pce.printStackTrace();

		}catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {

			e.printStackTrace();
		} catch (TransformerException e) {

			e.printStackTrace();
		}
	}//Fin de writeXML
	
	public void deleteBrand(String filePath, String elementType, String data) {
		
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
					String userAttribute= element.getAttribute("name");
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
	}
	
	public void updateBrand(String fileName, String elementType, String[] dataName, String[] data, String nameChange) {
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
//						for (int j = 1; j < dataName.length; j++) {
//							NodeList childNodes= element.getElementsByTagName(dataName[j]);
//							Element childElement= (Element)childNodes.item(0); 
//							childElement.setTextContent(data[j]);
//						}//for
						
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
	
	public boolean checkExists(String fileName, String name) {
        try {
        	System.out.println("Entro al metodo checkExists");
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Marca");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	System.out.println("Entro al if del for");
                    Element element = (Element) node;
                    String userAttribute = element.getAttribute("name");

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
	public ArrayList<Brand> readXMLToArrayList(String address, String elementType, String data) {
		
			ArrayList<Brand> arrayBrands;
			arrayBrands = new ArrayList<Brand>();
		
			//Brand brand = new Brand();
		
			try {
				File inputFile = new File(address);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputFile);
				doc.getDocumentElement().normalize();
		
				NodeList nList = doc.getElementsByTagName(elementType);
				
				for (int indice = 0; indice < nList.getLength(); indice++) {
					Node nNode = nList.item(indice);
					//System.out.println("\nDatos de las Facturas: " + nNode.getNodeName());
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
		
						
						brand= new Brand(eElement.getAttribute("name"));
						arrayBrands.add(brand);
		
						
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return arrayBrands;
	}//fin de readXMLToArrayList
	
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
}//fin de FilesXMLBrand
