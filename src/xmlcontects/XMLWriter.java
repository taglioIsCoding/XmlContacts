package xmlcontects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {
	
    public XMLWriter() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();

            //aggiunge elementi al file rubrica
            Element rootElement = document.createElementNS("taglioIsCoding", "People");
            //assegna una root
            document.appendChild(rootElement);

            //crea e assegna dei sottoelenti alla root
            rootElement.appendChild(getPerson(document,  "Prova", "rossi", "Male", "0301111111"));
            rootElement.appendChild(getPerson(document,  "Mario", "prova", "Female", "030222222222222"));

            //Metodi per la stampa
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //permette di stampare i vari elementi con una formattazone corretta(uno sotto l'altro)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            //stampa sul file e sulla console quello che ha fatto
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("./xmlTest.xml"));

            //scrive i dati
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    //metodo per generare i sottoelenti persona e per assegnargli dei valori
    private static Node getPerson(Document doc,
                                    String name, String surname,
                                    String sex,
                                    String tNumber) {

        Element person = doc.createElement("Person");
        person.appendChild(getEmployeeElements(doc, person, "name", name));
        person.appendChild(getEmployeeElements(doc, person, "surname", surname));
        person.appendChild(getEmployeeElements(doc, person, "sex", sex));
        person.appendChild(getEmployeeElements(doc, person, "tNumber", tNumber));

        return person;
    }
    //metodo per creare il nodo successivo
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
    //metodo per la creazione di una nuova rubrica
    public static void newRubrica(String filePath) {
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();

            //aggiunge elementi al file rubrica
            Element rootElement = document.createElementNS("taglioIsCoding", "People");
            //assegna una root
            document.appendChild(rootElement);

            //crea e assegna dei sottoelenti alla root
            rootElement.appendChild(getPerson(document,  "Prova", "rossi", "Male", "0301111111"));
            rootElement.appendChild(getPerson(document,  "Mario", "prova", "Female", "030222222222222"));

            //Metodi per la stampa
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //permette di stampare i vari elementi con una formattazone corretta(uno sotto l'altro)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            //stampa sul file e sulla console quello che ha fatto
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(filePath));

            //scrive i dati
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
}