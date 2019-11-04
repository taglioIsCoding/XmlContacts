package xmlcontects;

import java.awt.Desktop;
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
	
	//medoto costruttore vuoto usato solo per accedere ai metodi della classe
	public XMLModifyer() {
		
	}
	
	
	//metodo per eliminare un elemento dal file
    public void deletePerson(String nameToFind) throws ParserConfigurationException, SAXException, IOException, TransformerException{
    	
    	//metodi per la lettura del documeto 
    	String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        //faccio il parse del documento
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
    	
        //dichiaro e trovo la root del documento, creo una NodeList degli elementi presenti nel documento 
        // e creo l'elemento persona
        Element root = doc.getDocumentElement();
        NodeList people = doc.getElementsByTagName("Person");
        Element person;
        int j = 0;
        
        
        //cicla per ogni elemento "Person" all'interno del file  
        for(int i=0; i<people.getLength();i++){
            person = (Element) people.item(i);
            String name = person.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
            System.out.println(name);
            
            //se trova una corrispondenza tra il nome dell'elemento e
            //l'elemento che si vuole eliminare, elimina l'elemenento dalla root
            if(name.equalsIgnoreCase(nameToFind)) {
            	System.out.println("l'ho trovato");
            	root.removeChild(person);
            	i--; //diminuisce il contatore perche ora c'e' un elemento in meno all'interno della rott
            	j++;
            }
            
        }
        
        	//ciclo for identico al precedente ma svolge la ricerca per cognome
        	for(int i=0; i<people.getLength();i++){
                person = (Element) people.item(i);
                String surname = person.getElementsByTagName("surname").item(0).getFirstChild().getNodeValue();
                System.out.println(surname);
                
                if(surname.equalsIgnoreCase(nameToFind)) {
                	System.out.println("l'ho trovato");
                	root.removeChild(person);
                	i--;
                	j++;
                
                }	
                
            
        	}	
        
        
       
     
        
        //metodi per la stampa del documeto (gia' illustrati nella classe XMLWriter)
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("./xmlTest.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        
        System.out.println("XML file updated successfully");
        
        
        //se il contatore j e' maggiore di zero crea un panel che comunica all'utente quanti elementi sono stati eliminati
        if(j > 0) {
        	final JPanel panel = new JPanel();
        	JOptionPane.showMessageDialog(panel, "Deleted "+j+" elements" ,"Delete", JOptionPane.INFORMATION_MESSAGE);
        }else {
        	//altimenti comunica all'utente che non ha trovato elementi da eliminare
        	final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't contain this element", "Error", JOptionPane.ERROR_MESSAGE);
        	
        }
        
            	
     }  

    //medoto per aggiungere una persona all'interno della rubrica
    public void addPerson(String name, String surname, String sex, String tNumber) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {
    	String filePath = "./xmlTest.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        //faccio il parse del documento
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        //creo il nuovo elemento
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
    
    
    
  
	private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
	    node.appendChild(doc.createTextNode(value));
		return node;
		}
	
	
      
	
    		
    
}