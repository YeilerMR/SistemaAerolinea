package data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.User;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class LogicXML extends FilesXML {

    public LogicXML() {
        super();
    }

    public boolean checkUserExists(String fileName, String userId) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Users");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String userAttribute = element.getAttribute("user");

                    if (userAttribute.equals(userId)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void createAdminUser() {
        User user = new User("admin", "admin", " Administrador", " Activo");

        if (!checkUserExists("Users.xml", user.getUser())) {
            writeXML("Users.xml", "Users", user.getDataName(), user.getData());
        }
    }
    
    public boolean checkTypeUser(User user) {
    	boolean valid= false;
    	if (user.getType().equals(" Administrador")) {
			valid= true;
			System.out.println("Entro al Metodo para checar el usuario");
		}
    	return valid;
    }
   

}