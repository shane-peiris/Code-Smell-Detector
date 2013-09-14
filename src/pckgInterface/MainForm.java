/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgInterface;

import CoreClasses.ClassDefinition;
import CoreClasses.MethodDefinition;
import CoreClasses.SeperateFileContent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Shane
 */
public class MainForm extends javax.swing.JFrame {

/**
     * Creates new form MainForm
*/  
    SeperateFileContent SFC;
    public Vector<Object> SFCBlocks=new Vector<Object>();
    public MainForm() {
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

        but_Choose_File = new javax.swing.JButton();
        txtFileURL = new javax.swing.JTextField();
        btnProcess = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClassCount = new javax.swing.JTextField();
        txtMethodCount = new javax.swing.JTextField();
        txtTotalLineCountWithComments = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVariableCount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtConstructorCount = new javax.swing.JTextField();
        txtFileSize = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalLineCountWithoutComments = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnDetectSmells = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtClassCount1 = new javax.swing.JTextField();
        btnFileDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        but_Choose_File.setText("Choose File/Directory");
        but_Choose_File.setToolTipText("");
        but_Choose_File.setActionCommand("but_Choose_File");
        but_Choose_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Choose_FileActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel1.setText("Class Count : ");

        jLabel2.setText("Method Count :");

        jLabel3.setText("Total Line Count (With Comments) :");

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Summary");

        jLabel5.setText("Variable Count :");

        jLabel6.setText("Constructor Count :");

        jLabel7.setText("Total Size :");

        jLabel8.setText("Total Line Count (Without Comments & Spaces) :");

        btnDetectSmells.setText("Detect Smells");
        btnDetectSmells.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetectSmellsActionPerformed(evt);
            }
        });

        jLabel9.setText("File Count : ");

        btnFileDetails.setText("File Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMethodCount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtClassCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtConstructorCount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotalLineCountWithComments, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtVariableCount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalLineCountWithoutComments, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFileSize, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtClassCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDetectSmells, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFileDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFileURL, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_Choose_File)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFileURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_Choose_File)
                    .addComponent(btnProcess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClassCount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClassCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMethodCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConstructorCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVariableCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalLineCountWithComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalLineCountWithoutComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFileSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetectSmells, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFileDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_Choose_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Choose_FileActionPerformed
        // TODO add your handling code here:

        String wd = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(wd);
        int rc = fc.showDialog(null, "Select Data File");
        if (rc == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();            
            String filename = file.getAbsolutePath().toString();
            txtFileURL.setText(filename.toString());
            // call your function here
        } else {
            //System.out.println("File chooser cancel button clicked");
        }
        return;
    }//GEN-LAST:event_but_Choose_FileActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        
        String[] path; 
        FileReader fileRead=null;
        String fileData="";
        String line="";
        
        int TotClassCount=0;
        int TotMethodCount=0;
        int TotLineCountWithComments=0;
        int TotLineCountWithoutCommnets=0;
        int TotConstructorCount=0;
        int TotFileSizeCount = 0;
        int TotFileCount = 0;
        
        
        try 
        {
            
            
                if(txtFileURL.getText().endsWith(".java"))
                {
                    path= new String[1];
                    path[0] = txtFileURL.getText();
                    TotFileCount = 1;                    
                }
                else
                {
                    File folder = new File(txtFileURL.getText());
                    File[] listOfFiles = folder.listFiles();
                    path = new String[listOfFiles.length];
                   
                    for (int i = 0; i < listOfFiles.length; i++) {
                      File file = listOfFiles[i];
                      if (file.isFile() && file.getName().endsWith(".java")) {
                            path[i] = file.getPath();
                            TotFileCount++;
                        /* do somthing with content */
                      } 
                    }
                }
                
                
                
                for(int fc=0;fc<path.length;fc++)
                {
                
                    File f = new File(path[fc]);
                    fileRead = new FileReader(path[fc]);
                    BufferedReader bufferRead = new BufferedReader(fileRead);                

                    //Create New Instance of Duplicate Classes
                    SFC = new SeperateFileContent();    

                    while ((line=bufferRead.readLine()) != null)   
                    {
                        SFC.FileContentLineByLine.add(line);
                    }              
                    bufferRead.close();
                    SFC.ScanContent();
                    SFCBlocks.add(SFC);
    //                for(int i=0;i<SFC.FileContentLineByLine.size();i++)
    //                {
    //                    fileData = fileData + (i+1)+ "  " +  SFC.getVectorLineDetailsOrg(i) + "\n";
    //                }
    //                
    //                txtAreaCodeDisplay.setText(fileData.toString());

                    txtClassCount.setText(String.valueOf(SFC.ClassCodeBlocks.size()));

                    int mCount=0;//Method Count
                    int cCount=0;//Constructor Count

                    for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
                    {
                            if(((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).return_type.equals(""))
                            {
                                cCount++;
                            }
                            else
                            {
                                mCount++;
                            }
                    }

                    txtMethodCount.setText(String.valueOf(mCount));
                    txtConstructorCount.setText(String.valueOf(cCount));




                    txtFileSize.setText(String.valueOf(f.length())+" bytes");
                    txtTotalLineCountWithComments.setText(String.valueOf(SFC.FileContentLineByLine.size()));
                    txtTotalLineCountWithoutComments.setText(String.valueOf(SFC.FileContentLineByLineWithoutComments.size()));

                    int vCount = 0; //variable Count
                    for (int c=0;c<SFC.ClassCodeBlocks.size();c++)
                    {
                        vCount = vCount + ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).variableCount;
                    }




                    txtVariableCount.setText(String.valueOf(vCount));

                    System.out.println(SFC.MethodCodeBlocks);
                    System.out.println(SFC.ClassCodeBlocks);
                }
    }   
            catch (Exception ex) 
        {
               Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnDetectSmellsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetectSmellsActionPerformed
        // TODO add your handling code here:
        
        frmCodeSmellMenu CSM = new frmCodeSmellMenu(SFC,this);
        CSM.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnDetectSmellsActionPerformed
        
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetectSmells;
    private javax.swing.JButton btnFileDetails;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton but_Choose_File;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtClassCount;
    private javax.swing.JTextField txtClassCount1;
    private javax.swing.JTextField txtConstructorCount;
    private javax.swing.JTextField txtFileSize;
    private javax.swing.JTextField txtFileURL;
    private javax.swing.JTextField txtMethodCount;
    private javax.swing.JTextField txtTotalLineCountWithComments;
    private javax.swing.JTextField txtTotalLineCountWithoutComments;
    private javax.swing.JTextField txtVariableCount;
    // End of variables declaration//GEN-END:variables
}
