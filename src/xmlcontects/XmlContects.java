/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontects;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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
        File f = new File(fileName+path);
         if(!f.exists()){
            System.out.println("Non c'e'");
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "The contats file doesen't exist, one will be create", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             final JPanel panel = new JPanel();
             JOptionPane.showMessageDialog(panel, "The file exist, you can go!", "All okey", JOptionPane.INFORMATION_MESSAGE);
         }
               
               
                
                
   
        
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author")
            .addAttribute("name", "James")
            .addAttribute("location", "UK")
            .addText("James Strachan");

        Element author2 = root.addElement("author")
            .addAttribute("name", "Bob")
            .addAttribute("location", "US")
            .addText("Bob McWhirter");

   
    
    }
    
}
