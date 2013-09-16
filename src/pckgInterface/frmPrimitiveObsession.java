/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgInterface;

import CoreClasses.ClassDefinition;
import CoreClasses.MethodDefinition;
import CoreClasses.SeperateFileContent;
import Smells.primitiveObsession;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class frmPrimitiveObsession extends javax.swing.JFrame {

    /**
     * Creates new form frmPrimitiveObsession
     */
    SeperateFileContent SFC = new SeperateFileContent();
    frmCodeSmellMenu CSM = new frmCodeSmellMenu();
    public Vector<Object> SFCBlocks=new Vector<Object>();
    public frmPrimitiveObsession() {
        initComponents();
    }
    public frmPrimitiveObsession(SeperateFileContent SFCTemp, frmCodeSmellMenu CSMemp, Vector SFCBlocksTemp) {
        
        SFC = SFCTemp;
        CSM = CSMemp;
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

        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblMaxParam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowPrimitveObsessionDetails = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCodeVeiw = new javax.swing.JTextArea();
        lblMaxPrim = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnProcessData = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel5.setText("Primitve Obsession Details");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("If the No. of Primitive Variables or\nthe No. of Parameter Variables exceed\nthe Max. No. of the corresponding\nvaraible value it is considered to be \na Primitive Obsession");
        jScrollPane3.setViewportView(jTextArea1);

        lblMaxParam.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblMaxParam.setText("0");

        tblShowPrimitveObsessionDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblShowPrimitveObsessionDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowPrimitveObsessionDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowPrimitveObsessionDetails);

        jLabel6.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel6.setText("*Click on a Primitive Obsession Detail to View the Code");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setText("Code View");

        txtCodeVeiw.setColumns(20);
        txtCodeVeiw.setRows(5);
        txtCodeVeiw.setText("\n\n*Click on Primitive Obsession to \n View Code");
        jScrollPane2.setViewportView(txtCodeVeiw);

        lblMaxPrim.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblMaxPrim.setText("0");

        jLabel7.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel7.setText("Max. Primitve Variables   :");

        btnProcessData.setText("Apply Smell");
        btnProcessData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessDataActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel8.setText("Max. Parameter Variables :");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("P r i m i t i v e    O b s e s s i o n    D e t e c t o r");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnProcessData, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxPrim))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxParam)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProcessData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblMaxPrim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblMaxParam)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblShowPrimitveObsessionDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowPrimitveObsessionDetailsMouseClicked
        // TODO add your handling code here:

        String selectedRowClassMethName=String.valueOf(tblShowPrimitveObsessionDetails.getModel().getValueAt(tblShowPrimitveObsessionDetails.getSelectedRow(), 0));
        String Type =String.valueOf(tblShowPrimitveObsessionDetails.getModel().getValueAt(tblShowPrimitveObsessionDetails.getSelectedRow(), 3));
        String selectedRowFileName=String.valueOf(tblShowPrimitveObsessionDetails.getModel().getValueAt(tblShowPrimitveObsessionDetails.getSelectedRow(), 1));
        int selectedRowStartLine=Integer.parseInt(String.valueOf(tblShowPrimitveObsessionDetails.getModel().getValueAt(tblShowPrimitveObsessionDetails.getSelectedRow(), 6)));
        int StartLineNo=0;
        String ClassName="";

        String fileName = selectedRowFileName;
        // String fileData="";
        for(int sf=0;sf<SFCBlocks.size();sf++)
        {
            if((((SeperateFileContent)SFCBlocks.elementAt(sf)).fileName).equals(fileName))
            {

                SeperateFileContent SFCTemp = (SeperateFileContent)SFCBlocks.elementAt(sf);

                SFC = SFCTemp;

                if(Type.equals("Class"))
                {
                
                    for(int m=0;m<SFC.ClassCodeBlocks.size();m++)
                    {
                        StartLineNo = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).startLineNo;
                        ClassName = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).class_name;

                        if((ClassName.equals(selectedRowClassMethName))&((StartLineNo==selectedRowStartLine)))
                        {
                            txtCodeVeiw.setText(((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).content.toString());

                        }
                    }
                }
                else if(Type.equals("Method"))
                {
                    for(int m=0;m<SFC.ClassCodeBlocks.size();m++)
                    {
                        //StartLineNo = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).startLineNo;
                        //ClassName = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).class_name;

                        Vector<Object> Meths = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(m)).method_names;
                        
                        for(int me=0;me<Meths.size();me++)
                        {
                            MethodDefinition met = (MethodDefinition)Meths.elementAt(me);
                            
                            if((met.method_name.equals(selectedRowClassMethName))&(met.startLineNo==selectedRowStartLine))
                            {
                                txtCodeVeiw.setText(met.content.toString());
                            }
                        }
                    }
                }

            }
        }

    }//GEN-LAST:event_tblShowPrimitveObsessionDetailsMouseClicked

    private void btnProcessDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessDataActionPerformed
        //lblSmellInfo.setText("Shown below is a list of Long Methods taking 80 Lines as the average length of a method.");
        primitiveObsession PO = new primitiveObsession();

        //DisplayTableData(LC.getLargeClasses(SFC,SFCBlocks));
        DisplayTableData(PO.getPrimitiveObsession(SFCBlocks));
        lblMaxPrim.setText(String.valueOf(PO.MAX_PRIMITIVE_VARIABLE));
        lblMaxParam.setText(String.valueOf(PO.MAX_PARAMETER_VARIABLE));
    }//GEN-LAST:event_btnProcessDataActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        CSM.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    public void DisplayTableData(DefaultTableModel model)
    {
       tblShowPrimitveObsessionDetails.setModel(model);
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
            java.util.logging.Logger.getLogger(frmPrimitiveObsession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrimitiveObsession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrimitiveObsession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrimitiveObsession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrimitiveObsession().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessData;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblMaxParam;
    private javax.swing.JLabel lblMaxPrim;
    private javax.swing.JTable tblShowPrimitveObsessionDetails;
    private javax.swing.JTextArea txtCodeVeiw;
    // End of variables declaration//GEN-END:variables
}