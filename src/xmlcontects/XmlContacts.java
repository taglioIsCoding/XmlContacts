/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontects;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 *
 * @author 72873486
 */
public class XmlContacts {
	
	public static String fileName;
	public static String path;
    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        //Constrisce filepath
        fileName = "xmlTest.xml";
		path = "./";
        
        //fa partire la grafica
        Gui gui = new Gui();
        gui.doAll();
        
         //controllo se esiste il file
        File f = new File(path+fileName);
         if(!f.exists()){
            System.out.println("Non c'e'");
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't exist, one will be create", "Error", JOptionPane.ERROR_MESSAGE);
            XMLWriter writer = new XMLWriter();
         
         }else{
             final JPanel panel = new JPanel();
             JOptionPane.showMessageDialog(panel, "The file exist, you can go!", "All okey", JOptionPane.INFORMATION_MESSAGE);
         }
         
         //***********************TEST************************
         XMLWriter writer = new XMLWriter();
         
        // XMLModifyer modify = new XMLModifyer();
         
         
         
         
         

         
         
         /* AREA TEST
         //faccio il parse del documento      
         Document document = null;      
         SAXReader reader = new SAXReader();
         try {
		 document = reader.read(path+fileName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         
        //leggo l'attributo name dello studente 
		Element root = document.getRootElement();
         for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
             Element element = it.next();
             System.out.println(element.elementText("Name"));
         }
        
       */

   
    
    }
    
}
