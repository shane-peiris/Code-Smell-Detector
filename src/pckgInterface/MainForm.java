/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgInterface;

import CoreClasses.SeperateFileContent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCodeDisplay = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaClassPreview = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        but_Choose_File.setText("Choose File");
        but_Choose_File.setToolTipText("");
        but_Choose_File.setActionCommand("but_Choose_File");
        but_Choose_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Choose_FileActionPerformed(evt);
            }
        });

        txtFileURL.setText("jTextField1");

        btnProcess.setText("Process File");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        txtAreaCodeDisplay.setColumns(20);
        txtAreaCodeDisplay.setLineWrap(true);
        txtAreaCodeDisplay.setRows(5);
        jScrollPane1.setViewportView(txtAreaCodeDisplay);

        txtAreaClassPreview.setColumns(20);
        txtAreaClassPreview.setRows(5);
        jScrollPane2.setViewportView(txtAreaClassPreview);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFileURL, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_Choose_File)
                        .addGap(18, 18, 18)
                        .addComponent(btnProcess)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFileURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_Choose_File)
                    .addComponent(btnProcess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
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
        
        String path="";        
        FileReader fileRead=null;
        String fileData="";
        String line="";
        try 
        {
                path = txtFileURL.getText();
                fileRead = new FileReader(path);
                BufferedReader bufferRead = new BufferedReader(fileRead);                
                
                //Create New Instance of Duplicate Classes
                SeperateFileContent SFC = new SeperateFileContent();    
                
                while ((line=bufferRead.readLine()) != null)   
                {
                    SFC.FileContentLineByLine.add(line);
                }              
                bufferRead.close();
                SFC.ScanContent();
                for(int i=0;i<SFC.FileContentLineByLineWithoutComments.size();i++)
                {
                    fileData = fileData + SFC.getVectorLineDetailsWithoutComments(i) + "\n";
                }
                
                txtAreaCodeDisplay.setText(fileData.toString());
                
                String classList="";
                
                for(int i=0;i<SFC.ClassCodeBlocks.size();i++)
                {
                    classList = classList + SFC.getClassList(i) + "\n";
                }
                
                txtAreaClassPreview.setText(classList);
    }//GEN-LAST:event_btnProcessActionPerformed
        catch (Exception ex) 
        {
               Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
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
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton but_Choose_File;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaClassPreview;
    private javax.swing.JTextArea txtAreaCodeDisplay;
    private javax.swing.JTextField txtFileURL;
    // End of variables declaration//GEN-END:variables
}
