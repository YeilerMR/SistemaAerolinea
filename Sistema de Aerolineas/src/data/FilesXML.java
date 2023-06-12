package data;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.User;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FilesXML {

	public FilesXML() {}
 
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
	}

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
	}

public boolean deleteUser(String filePath, String elementType, String userId) {
    try {
        // Load the XML file
        File inputFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);

        // Find the user node with the given ID
        NodeList nodes = doc.getElementsByTagName(elementType);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String userAttribute = element.getAttribute("user");

                if (userAttribute.equals(userId)) {
                    // Remove the user element
                    element.getParentNode().removeChild(element);

                    // Save the modified XML file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(inputFile);
                    transformer.transform(source, result);

                    return true;
                }
            }
        }

        return false;

    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
        e.printStackTrace();
        return false;
    }
}


public boolean updateUser(String FileName, String elementType, String[] dataName, String[] data) {
    try {
        // Load the XML file
        File inputFile = new File(FileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);

        // Find the user node with the given ID
        NodeList nodes = doc.getElementsByTagName(elementType);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String userAttribute = element.getAttribute("user");

                if (userAttribute.equals(data[0])) {
                    // Update the user element with new values
                    for (int j = 1; j < dataName.length; j++) {
                        NodeList childNodes = element.getElementsByTagName(dataName[j]);
                        Element childElement = (Element) childNodes.item(0);
                        childElement.setTextContent(data[j]);
                    }

                    // Save the modified XML file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(inputFile);
                    transformer.transform(source, result);

                    return true;
                }
            }
        }

        return false;

    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
        e.printStackTrace();
        return false;
    }
}

public User getUserInfo(String FileName, String elementType, String userId) {
    try {
        // Load the XML file
        File inputFile = new File(FileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);

        // Find the user node with the given ID
        NodeList nodes = doc.getElementsByTagName(elementType);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String userAttribute = element.getAttribute("user");

                if (userAttribute.equals(userId)) {
                    // Retrieve the user information
                    String password = element.getElementsByTagName("password").item(0).getTextContent();
                    String type = element.getElementsByTagName("type").item(0).getTextContent();
                    String state = element.getElementsByTagName("state").item(0).getTextContent();

                    // Create and return the user object
                    User user = new User(userId, password, type, state);
                    return user;
                }
            }
        }

        return null;

    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
        return null;
    }
}






}