/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontects;
import java.awt.Desktop;
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
	
	//variabili per indicare ilpercorso della nostra rubrica
	public static String fileName;
	public static String path;
	
    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        //Costruisce filepath
        fileName = "xmlTest.xml";
		path = "./";
        
        //fa partire la grafica
        Gui gui = new Gui();
        gui.doAll();
        
         //controllo se esiste il file
        File f = new File(path+fileName);
         if(!f.exists()){
            //se il file non c'e' genera una finestra di errore 
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't exist, one will be create", "Error", JOptionPane.ERROR_MESSAGE);
            
            //in caso il file non esistesse ne crea immediatamente uno
            XMLWriter writer = new XMLWriter();
         
         }else{
        	 
        	 //se il file esiste avvisa l'utente che va tutto bene e che puo continuare l'esecuzione
             final JPanel panel = new JPanel();
             JOptionPane.showMessageDialog(panel, "The file exist, you can go!", "All okey", JOptionPane.INFORMATION_MESSAGE);
         }
         
        /*
        XMLWriter.newRubrica();
         
        */
         
         /*
         
          File file = new File("./xmlTest");
            
          Desktop.getDesktop().open(file);
         */
    
    }
    
}
