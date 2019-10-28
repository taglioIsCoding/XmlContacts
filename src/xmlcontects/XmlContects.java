/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontects;
import java.io.File;
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
public class XmlContects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Constrisce filepath
         String fileName = "xmlTest.xml";
		String path = "./";
        
        //fa partire la grafica
        Gui gui = new Gui();
        gui.doAll();
        
         //controllo se esiste il file
        File f = new File(path+fileName);
         if(!f.exists()){
            System.out.println("Non c'e'");
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't exist, one will be create", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             final JPanel panel = new JPanel();
             JOptionPane.showMessageDialog(panel, "The file exist, you can go!", "All okey", JOptionPane.INFORMATION_MESSAGE);
         }
               
         Document document = null;      
         SAXReader reader = new SAXReader();
         try {
		 document = reader.read(path+fileName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         
         
		Element root = document.getRootElement();
         for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
             Element element = it.next();
             System.out.println(element.elementText("Name"));
         }
        
       

   
    
    }
    
}
