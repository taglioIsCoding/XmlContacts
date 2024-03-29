/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontects;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 72873486
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        findLabel = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        nameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        surnameFld = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFema = new javax.swing.JRadioButton();
        numberLbl = new javax.swing.JLabel();
        numberFld = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        PrintBtn = new javax.swing.JButton();
        NewBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("Contacts XML");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					searchBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        nameLbl.setText("Name:");

        jLabel1.setText("Surname:");

        buttonGroup1.add(rdbMale);
        rdbMale.setText("Male");

        buttonGroup1.add(rdbFema);
        rdbFema.setText("Female");
        

        numberLbl.setText("T Number:");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addBtnActionPerformed(evt);
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException
						| XMLStreamException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					removeBtnActionPerformed(evt);
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        
        
        PrintBtn.setText("Print");
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        NewBtn.setText("New File");
        NewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbMale)
                            .addComponent(numberLbl))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(rdbFema))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numberFld, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLbl)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(133, 133, 133))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PrintBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn)
                        .addGap(154, 154, 154))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(findLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)
                        .addGap(18, 18, 18)
                        .addComponent(removeBtn)
                        .addGap(0, 103, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(removeBtn))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbMale)
                    .addComponent(rdbFema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLbl)
                    .addComponent(numberFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(PrintBtn)
                    .addComponent(NewBtn))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //metodo per eliminare un elemento
    protected void removeBtnActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
    	//prende il nome dell'elemento da eliminare
    	String nameToFind = findLabel.getText();
		System.out.println(nameToFind);
		
		//crea l'oggetto mod e poi applica il metodo deletePerson
		XMLModifyer mod = new XMLModifyer();
		mod.deletePerson(nameToFind);
		
		
		findLabel.setText("");
		
		
	}

    //metodo per cercare un elemento
	private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_searchBtnActionPerformed
        
    	if(findLabel.getText().isEmpty()){
            final JPanel panel = new JPanel();
            //genera messaggio di errore se il campo non è completo
            JOptionPane.showMessageDialog(panel, "You must inert a name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String nameToFind = findLabel.getText();
        
        
        //faccio il parse del documento      
         Document document = null;      
         SAXReader reader = new SAXReader();
         try {
 		 document = reader.read(XmlContacts.path + XmlContacts.fileName);
          } catch (DocumentException e) {
 			
 			e.printStackTrace();
          }
         
          
         //leggo l'attributo name dello studente 
        int i = 0;
 		Element root = document.getRootElement();
 		
 		//cicli per cercare l'elemento per nome e per cognome
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
              Element element = it.next();
              String contact = element.elementText("name");
              
               if(nameToFind.equalsIgnoreCase(contact)) {
            	  
            	  
            	  String surname = element.elementText("surname");
            	  String number = element.elementText("tNumber");
            	  
            	  
            	  i++;
            	  final JPanel panel = new JPanel();
                  JOptionPane.showMessageDialog(panel, contact+" "+surname+" " + number, "I found:", JOptionPane.INFORMATION_MESSAGE);
              }
          }
          
      //leggo l'attributo cognome dello studente 
        	  for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                  Element element = it.next();
                  
                  String contact = element.elementText("surname");
                   if(nameToFind.equalsIgnoreCase(contact)) {
                	  
                	  
                	  String name = element.elementText("name");
                	  String number = element.elementText("tNumber");
                	  
                	  
                	  i++;
                	  final JPanel panel = new JPanel();
                      JOptionPane.showMessageDialog(panel, contact+" "+name+" " + number, "I found:", JOptionPane.INFORMATION_MESSAGE);
                  }
              
          }
          
        //se l'elemento non e' stato trovato genera un pannello di errore
          if (i==0) {
        	  final JPanel panel = new JPanel();
              JOptionPane.showMessageDialog(panel, "The contats file doesen't contain this element", "Error", JOptionPane.ERROR_MESSAGE);
          }
          
          
          findLabel.setText("");
         
    }//GEN-LAST:event_searchBtnActionPerformed

    //metodo per visualizzare il file xml
    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        java.io.File file = new java.io.File("./xmlTest.xml");
        try {
            java.awt.Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          findLabel.setText("");
    }//GEN-LAST:event_PrintBtnActionPerformed

    //metodo per creare un nuovo file
    private void NewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBtnActionPerformed
        
    	//crea una nuova rubrica tramite filechooseer
    	
    	String resp = "Insert the file name";

    	String name = JOptionPane.showInputDialog(null, resp);   
    	
    	//dichiaro il filechooser e lo ostro
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose a directory to save your file: ");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//se la cartella selezionata e' esatta crea il file
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				System.out.println("You selected the directory: " + jfc.getSelectedFile());
				XMLWriter.newRubrica(jfc.getSelectedFile()+ name +".xml");
			}
		}
        
        
        
    }//GEN-LAST:event_NewBtnActionPerformed

    //bottone per aggiungere un elemento
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {                                       
    	
    	//controllo dei dati inseriti dall'utente
        if(nameFld.getText().isEmpty()||numberFld.getText().isEmpty()||surnameFld.getText().isEmpty()||(!rdbMale.isSelected() && !rdbFema.isSelected())) {
        	
        	final JPanel panel = new JPanel();
        	System.out.println("Non va bene!");
        	JOptionPane.showMessageDialog(panel, "You must insert all the parameter", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
        	
        }else{
        
        	for(int i =0; i<numberFld.getText().length(); i++) {
        		
        		if(numberFld.getText().charAt(i)!= '0'&&
        				numberFld.getText().charAt(i)!= '1'&&
        				numberFld.getText().charAt(i)!= '2'&&
        				numberFld.getText().charAt(i)!= '3'&&
        				numberFld.getText().charAt(i)!= '4'&&
        				numberFld.getText().charAt(i)!= '5'&&
        				numberFld.getText().charAt(i)!= '6'&&
        				numberFld.getText().charAt(i)!= '7'&&
        				numberFld.getText().charAt(i)!= '8'&&
        				numberFld.getText().charAt(i)!= '9'&&
        				numberFld.getText().charAt(i)!= '+') {
        			
        			final JPanel panel = new JPanel();
                	
                	JOptionPane.showMessageDialog(panel, "You must inser true telephone number", "Error", JOptionPane.ERROR_MESSAGE);
                	return;
        			
        		}
        
        	}
       
        
        	String sex;
        	if(rdbMale.isSelected()){
        		sex = "Male";
        	}else {
        		sex = "Female";
        	}
        	//creo il modifyer e gli fornisco i dati
        	XMLModifyer mod = new XMLModifyer();
        	mod.addPerson(nameFld.getText(), surnameFld.getText(), sex, numberFld.getText() );
        	final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "New Person: "+"\r\n"+
            			"Name: "+nameFld.getText()+"\r\n"+
            			"Surname: "+surnameFld.getText()+"\r\n"+
            			"Sex: "+sex+"\r\n"+
            			"T Number: "+numberFld.getText()
            			, "Succes", JOptionPane.INFORMATION_MESSAGE);
        }
    
           nameFld.setText("");
           surnameFld.setText("");
           numberFld.setText("");
           rdbMale.setSelected(true);
           rdbFema.setSelected(false);
        
}



    
    public static void doAll() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
         
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewBtn;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField findLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameFld;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField numberFld;
    private javax.swing.JLabel numberLbl;
    private javax.swing.JRadioButton rdbFema;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField surnameFld;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
