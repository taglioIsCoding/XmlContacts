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

            //add elements to document
            Element rootElement = document.createElementNS("taglioIsCoding", "People");
            //append root element to document
            document.appendChild(rootElement);

            //append child element to root element
            rootElement.appendChild(getPerson(document,  "Dmitry", "sfjsadjkfl", "Male", "1234"));
            rootElement.appendChild(getPerson(document,  "Rezida", "tagliani", "Female", "4321"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("./xmlTest.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

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
    //utility method to create text node
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
    
}