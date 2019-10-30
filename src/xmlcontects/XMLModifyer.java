package xmlcontects;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLModifyer {
	
	public XMLModifyer() {
		
	}
	
	
	
    public void deletePerson(String nameToFind) throws ParserConfigurationException, SAXException, IOException, TransformerException{
    	
    	String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        //faccio il parse del documento
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
    	
        Element root = doc.getDocumentElement();
        NodeList people = doc.getElementsByTagName("Person");
        Element person;
        int j = 0;
        //cicla per ogni persona
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            String name = person.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
            System.out.println(name);
            
            if(name.equalsIgnoreCase(nameToFind)) {
            	System.out.println("l'ho trovato");
            	root.removeChild(person);
            	j++;
            }
            
        }
        
        
       
       
        
        
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("./xmlTest.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        
        System.out.println("XML file updated successfully");
        
        if(j > 0) {
        	final JPanel panel = new JPanel();
        	JOptionPane.showMessageDialog(panel, "Deleted "+j+" elements" ,"Delete", JOptionPane.INFORMATION_MESSAGE);
        }else {
        	final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't contain this element", "Error", JOptionPane.ERROR_MESSAGE);
        	
        }
        
            	
     }

        
        
       
        

    public void addPerson(String name, String surname, String sex, String tNumber) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {
    	String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        //faccio il parse del documento
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        //creo il novo elemento
        Element root = doc.getDocumentElement();
        Element person = doc.createElement("Person");
        person.appendChild(getEmployeeElements(doc, person, "name", name));
		person.appendChild(getEmployeeElements(doc, person, "surname", surname));
		person.appendChild(getEmployeeElements(doc, person, "sex", sex));
		person.appendChild(getEmployeeElements(doc, person, "tNumber", tNumber));
        root.appendChild(person);
    
        


        
        //riscivo e formatto l'elemento inserito
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("./xmlTest.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        
        System.out.println("XML file updated successfully");
    }
    
    
    
    		//utility method to create text node
	private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
	    node.appendChild(doc.createTextNode(value));
		return node;
		}
	
	
      
	
    		
    
}