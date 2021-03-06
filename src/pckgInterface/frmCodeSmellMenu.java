/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgInterface;

import CoreClasses.SeperateFileContent;
import java.util.Vector;

/**
 *
 * @author Shane
 */
public class frmCodeSmellMenu extends javax.swing.JFrame {

    /**
     * Creates new form frmCodeSmellMenu
     */
    SeperateFileContent SFC = new SeperateFileContent();
    MainForm MF = new MainForm();
    public Vector<Object> SFCBlocks=new Vector<Object>();
    public frmCodeSmellMenu() 
    {
        initComponents();
    }
    public frmCodeSmellMenu(SeperateFileContent SFCTemp, MainForm MFTemp, Vector SFCBlocksTemp) 
    {
        
        SFC = SFCTemp;
        MF = MFTemp;
        SFCBlocks = SFCBlocksTemp;
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

        btnLazyClassDetector = new javax.swing.JButton();
        btnBloatedCodes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDuplicateCodeDetector = new javax.swing.JButton();
        btnBloatedCodes1 = new javax.swing.JButton();
        btnFeatureEnvy = new javax.swing.JButton();
        btnTooManyLiteral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Code Smell List");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnLazyClassDetector.setText("Lazy Class Detector");
        btnLazyClassDetector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLazyClassDetectorActionPerformed(evt);
            }
        });

        btnBloatedCodes.setText("Bloated Code Detector");
        btnBloatedCodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloatedCodesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C o d e    S m e l l    L i s t");

        btnDuplicateCodeDetector.setText("Duplicate Code Detector");
        btnDuplicateCodeDetector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuplicateCodeDetectorActionPerformed(evt);
            }
        });

        btnBloatedCodes1.setText("Primitve Obsession Detector");
        btnBloatedCodes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloatedCodes1ActionPerformed(evt);
            }
        });

        btnFeatureEnvy.setText("Feature Envy Detector");
        btnFeatureEnvy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeatureEnvyActionPerformed(evt);
            }
        });

        btnTooManyLiteral.setText("Too Many Literal Detector");
        btnTooManyLiteral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTooManyLiteralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFeatureEnvy, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTooManyLiteral, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBloatedCodes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBloatedCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLazyClassDetector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDuplicateCodeDetector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBloatedCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLazyClassDetector, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBloatedCodes1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuplicateCodeDetector, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeatureEnvy, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTooManyLiteral, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
         MF.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnLazyClassDetectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLazyClassDetectorActionPerformed
        // TODO add your handling code here:
        frmLazyClass LC = new frmLazyClass(SFC,this,SFCBlocks);
        LC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLazyClassDetectorActionPerformed

    private void btnBloatedCodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloatedCodesActionPerformed
        // TODO add your handling code here:
        
        frmDetectBloatedCodes DBC = new frmDetectBloatedCodes(SFC,this,SFCBlocks);
        DBC.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnBloatedCodesActionPerformed

    private void btnDuplicateCodeDetectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuplicateCodeDetectorActionPerformed
        // TODO add your handling code here:
        frmDuplicatedCode DC = new frmDuplicatedCode(SFC,this,SFCBlocks);
        DC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDuplicateCodeDetectorActionPerformed

    private void btnBloatedCodes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloatedCodes1ActionPerformed
        // TODO add your handling code here:
        frmPrimitiveObsession PO = new frmPrimitiveObsession(SFC,this,SFCBlocks);
        PO.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBloatedCodes1ActionPerformed

    private void btnFeatureEnvyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureEnvyActionPerformed
        // TODO add your handling code here:
        frmFeatureEnvy FE = new frmFeatureEnvy(SFC,this,SFCBlocks);
        FE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFeatureEnvyActionPerformed

    private void btnTooManyLiteralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTooManyLiteralActionPerformed
        // TODO add your handling code here:
        frmTooManyLiterals TML = new frmTooManyLiterals(SFC,this,SFCBlocks);
        TML.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTooManyLiteralActionPerformed

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
            java.util.logging.Logger.getLogger(frmCodeSmellMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCodeSmellMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCodeSmellMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCodeSmellMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCodeSmellMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloatedCodes;
    private javax.swing.JButton btnBloatedCodes1;
    private javax.swing.JButton btnDuplicateCodeDetector;
    private javax.swing.JButton btnFeatureEnvy;
    private javax.swing.JButton btnLazyClassDetector;
    private javax.swing.JButton btnTooManyLiteral;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
