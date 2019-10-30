package xmlcontects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLModifyer {
	
	public XMLModifyer() {
		
	}
	
    public void docu(){
        String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            //update attribute value
            updateAttributeValue(doc);

            //update Element value
            updateElementValue(doc);

            //delete element
            deleteElement(doc);

            //add new element
            addElement(doc);

            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("./xmlTest.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void updateAttributeValue(Document doc) {
        NodeList people = doc.getElementsByTagName("People");
        Element person;
        //loop for each employee
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            String gender = person.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue();
            if(gender.equalsIgnoreCase("male")){
                //prefix id attribute with M
                person.setAttribute("id", "M"+person.getAttribute("id"));
            }else{
                //prefix id attribute with F
                person.setAttribute("id", "F"+person.getAttribute("id"));
            }
        }
    }


    private static void updateElementValue(Document doc){
        NodeList people = doc.getElementsByTagName("People");
        Element person;
        //loop for each employee
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            Node name = person.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }
    
    

    private static void deleteElement(Document doc){
        NodeList people = doc.getElementsByTagName("Person");
        Element person;
        //loop for each employee
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            Node genderNode = person.getElementsByTagName("sex").item(0);
            person.removeChild(genderNode);
        }
    }
    	
    private static void addElement(Document doc){
        NodeList people = doc.getElementsByTagName("People");
        Element person = null;

        //loop for each employee
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            Element salaryElement = doc.createElement("tNumber");
            salaryElement.appendChild(doc.createTextNode("1111111111111111"));
            person.appendChild(salaryElement);
        }
    }
    
    public void addPerson(String name, String surname, String sex, String tNumber) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {
    	String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        
        Element root = doc.getDocumentElement();
        Element person = doc.createElement("Person");
        person.appendChild(getEmployeeElements(doc, person, "name", name));
		person.appendChild(getEmployeeElements(doc, person, "surname", surname));
		person.appendChild(getEmployeeElements(doc, person, "sex", sex));
		person.appendChild(getEmployeeElements(doc, person, "tNumber", tNumber));
        root.appendChild(person);
    
        


        
        
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("./xmlTest.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");
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