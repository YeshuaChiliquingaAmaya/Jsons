/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jsons.odontoapp.view;

import com.jsons.odontoapp.controller.PatientController;
import com.jsons.odontoapp.model.Patient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class FrmDeletePatients extends javax.swing.JFrame {

    DefaultTableModel tablePatients = new DefaultTableModel();
    ArrayList<Patient> patients = new ArrayList<Patient>();
    Patient patient;
    
    private void fillPatients(){
         patients = PatientController.show();
    }
     
    private void setModel(){
        String[] header = {"ID", "Nombre", "Edad", "Peso", "Altura", "Síntomas de Enfermedad", "Número de contacto",
                            "Enfermedades Sistémicas", "Tratamiento del Paciente", "Fecha de Inicio de Tratamiento",
                            "Fecha de Finalización de Tratamiento"};
        tablePatients.setColumnIdentifiers(header);
        tblPatients.setModel(tablePatients);
        Object datos[] = new Object[tblPatients.getColumnCount()];
        for(Patient patient:patients){
            datos[0] = patient.getClinicalHistory().getId();
            datos[1] = patient.getClinicalHistory().getName();
            datos[2] = patient.getClinicalHistory().getAge();
            datos[3] = patient.getClinicalHistory().getWeight();
            datos[4] = patient.getClinicalHistory().getHeight();
            datos[5] = patient.getClinicalHistory().getDiseaseSymptoms();
            datos[6] = patient.getClinicalHistory().getCellphone();
            datos[7] = patient.getClinicalHistory().getSystemicDiseases();
            datos[8] = patient.getClinicalHistory().getPatientTreatment();
            datos[9] = patient.getClinicalHistory().getTreatmentDateStart();
            datos[10] = patient.getClinicalHistory().getTreatmentEndDate();
            tablePatients.addRow(datos);
        }
    }
    
    /**
     * Creates new form FrmDeletePatients
     */
    public FrmDeletePatients() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        fillPatients();
        setModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JScrollPanelPatientsTable = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lblEditWarning = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPatients.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPatients.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tblPatientsComponentRemoved(evt);
            }
        });
        tblPatients.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tblPatientsAncestorRemoved(evt);
            }
        });
        tblPatients.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tblPatientsComponentMoved(evt);
            }
        });
        tblPatients.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblPatientsPropertyChange(evt);
            }
        });
        tblPatients.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblPatientsVetoableChange(evt);
            }
        });
        JScrollPanelPatientsTable.setViewportView(tblPatients);

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton2.setText("Siguiente Página");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JScrollPanelPatientsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEditWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPanelPatientsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPatientsComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblPatientsComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsComponentRemoved

    private void tblPatientsAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblPatientsAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsAncestorRemoved

    private void tblPatientsComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblPatientsComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsComponentMoved

    private void tblPatientsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblPatientsPropertyChange

    }//GEN-LAST:event_tblPatientsPropertyChange

    private void tblPatientsVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblPatientsVetoableChange

    }//GEN-LAST:event_tblPatientsVetoableChange

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(tblPatients.getSelectedRow() == -1){
            lblEditWarning.setText("Selecciona un paciente.");
            lblEditWarning.setForeground(Color.RED);
        }else{
            lblEditWarning.setVisible(false);
            patient = patients.get(tblPatients.getSelectedRow());
            int option = JOptionPane.showConfirmDialog(this,"Está segura de que desea eliminar a " + patient.getClinicalHistory().getName() + "?", "saving warning",1);
            if(option == 0){
                JOptionPane.showMessageDialog(rootPane, "Paciente Eliminado.");
                PatientController.delete(patient.getClinicalHistory().getId());
            }
            if(option == 1){
                JOptionPane.showMessageDialog(rootPane, "Acción Negada.");
            }
            if(option == 2){
                JOptionPane.showMessageDialog(rootPane, "Acción Cancelada.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        FrmPatients frmPatients = new FrmPatients();
        frmPatients.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDeletePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDeletePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDeletePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDeletePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDeletePatients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanelPatientsTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEditWarning;
    private javax.swing.JTable tblPatients;
    // End of variables declaration//GEN-END:variables
}
