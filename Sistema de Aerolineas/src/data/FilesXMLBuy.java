package data;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Buy;
import domain.Ticket;


public class FilesXMLBuy extends FilesXMLGlobal{

	private Buy buy;
	private String data[][];
	private ArrayList<String> arrayBuys= new ArrayList<String>();
		
	public FilesXMLBuy() {}
	
public ArrayList<Buy> readXMLToArrayList(String address, String elementType) {
		
		ArrayList<Buy> arrayBuys;
		arrayBuys = new ArrayList<Buy>();
	
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

					buy= new Buy(eElement.getAttribute("nTicket"),
							eElement.getElementsByTagName("hourB").item(0).getTextContent(),
							eElement.getElementsByTagName("dateB").item(0).getTextContent());

					arrayBuys.add(buy);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayBuys;
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

	public void setDataMatrixTicket(ArrayList<Buy> arrayBuys) {
		data= new String[arrayBuys.size()][1];
		for (int i = 0; i < this.data.length; i++) {
			data[i][0]= arrayBuys.get(i).getnBuyTicket();
		}
	}
	public void setBuy(ArrayList<Buy> arrayBuy) {
		for (int i = 0; i < arrayBuy.size(); i++) {
			this.arrayBuys.add(arrayBuy.get(i).getnBuyTicket());
		}
	}
	public ArrayList<String> getArrayBuys(){
		return this.arrayBuys;
	}
	public String getBuys(ArrayList<Buy> arrayBuys) {
		String buyString="";
		for (Buy buy : arrayBuys) {
			buyString+= buy.toString();
		}
		return buyString;
	}
	public String[][] getDataMatrixBuy(){
		return this.data;
	}
	public ArrayList<Buy> readBuy(ArrayList<Buy> arrayBuy, String dataTXT){
		ArrayList<Buy> arrayConsult= new ArrayList<Buy>();
		
		for (int i = 0; i < arrayBuy.size(); i++) {
			if (dataTXT.equalsIgnoreCase(arrayBuy.get(i).getnBuyTicket())) {
				System.out.println("Si son iguales["+dataTXT+"] y {"+arrayBuy.get(i).getnBuyTicket()+"}");
				arrayConsult.add(arrayBuy.get(i));
			}
		}
		System.out.println("Tamaño de arrayConsult"+arrayConsult.size());
		return arrayConsult;
	}
}//fin de FilesXMLBuy
