/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jsons.odontoapp.view;

import com.jsons.odontoapp.controller.PatientController;
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.Patient;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author yeshualinux
 */
public class FrmAppointments extends javax.swing.JFrame {
    int patientId;
    Appointment appointment = new Appointment();
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    Patient patient = new Patient();
    /**
     * Creates new form FrmAppointments
     */
    public FrmAppointments(Patient patient) {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        //show information of patient in a rectangle
        int id = this.patientId = patient.getClinicalHistory().getId();
        this.patient = patient;
        this.appointments = appointments;
        String idString = String.valueOf(id);
        txtName.setText("ID: " + idString);
        
        String name = patient.getClinicalHistory().getName();
        txtName.setText(txtName.getText() +"\n" + "Nombre: " + name);
        
        //show services in Combobox
        cbxServices.addItem("Profilaxis (limpieza dental): $25");
        cbxServices.addItem("Profilaxis + Fluorización (especialmente para niños): $20");
        cbxServices.addItem("Restauraciones simples: $20");
        cbxServices.addItem("Restauraciones complejas: $25 (Las restauraciones pueden ser con resina o amalgama)");
        cbxServices.addItem("Restauraciones para niños (empastes para niños): $15");
        cbxServices.addItem("Extracciones (extracción de un diente): $20");
        cbxServices.addItem("Extracciones complicadas: $30");
        cbxServices.addItem("Tratamiento de un conducto (incisivos o dientes frontales): $60");
        cbxServices.addItem("Tratamiento de dos conductos (premolares): $80");
        cbxServices.addItem("Tratamiento de tres conductos (molares): $100");

        // Manejar el evento de selección del JComboBox
        cbxServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicesActionPerformed(evt);
            }
        });
    }
                
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JCAppointmetDay = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxServices = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtName = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAgend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agendamiento de CItas a pacientes");

        jLabel2.setText("Día");

        jLabel4.setText("Hora");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm" }));
        jComboBox2.setToolTipText("Seleccione la hora de la cita");

        jLabel5.setText("Tratamiento");

        cbxServices.setToolTipText("Seleccione el servicio que quiere generar");
        cbxServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicesActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setColumns(20);
        txtName.setRows(5);
        jScrollPane1.setViewportView(txtName);

        jLabel3.setText("Información del Paciente:");

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAgend.setText("Agendar Cita");
        btnAgend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JCAppointmetDay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxServices, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCAppointmetDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAgend))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxServicesActionPerformed
    
    public Appointment getAppointment() {
        return appointment;
    }
    
    private void btnAgendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendActionPerformed
       
        readAppointmentDay();
        appointment.setHour(jComboBox2.getSelectedItem().toString()); // Obtén la hora seleccionada del JComboBox

        // Obtén el servicio seleccionado del JComboBox
        String selectedService = cbxServices.getSelectedItem().toString();
        appointment.setService(selectedService);

        // Agrega la cita a la lista appointments
        appointments.add(appointment);

        // Asigna la lista appointments al paciente
        patient.setAppointments(appointments);

        // Agrega el paciente a la base de datos usando el controlador PatientController
        PatientController.update(patient.getClinicalHistory().getId(), patient);

        // Puedes mostrar un mensaje de confirmación o realizar otras acciones después de guardar la cita
        JOptionPane.showMessageDialog(this, "Cita agendada exitosamente");
        
        // Limpia el calendario
        JCAppointmetDay.setDate(null);
        
        // Llama al método para mostrar los detalles de la cita recién agendada
        showAppointmentDetails(appointment);

        // Limpia el calendario
        JCAppointmetDay.setDate(null);
    }//GEN-LAST:event_btnAgendActionPerformed
    
    private void showAppointmentDetails(Appointment appointment) {
        StringBuilder message = new StringBuilder();
        message.append("Detalles de la Cita:\n");
        message.append("Fecha: ").append(appointment.getDate()).append("\n");
        message.append("Hora: ").append(appointment.getHour()).append("\n");
        message.append("Servicio: ").append(appointment.getService()).append("\n");

        JOptionPane.showMessageDialog(this, message.toString(), "Detalles de la Cita", JOptionPane.INFORMATION_MESSAGE);
    }

    
    public void readAppointmentDay() {
        Date appointmentDay = JCAppointmetDay.getDate();
        appointment.setDate(appointmentDay);
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FrmBeforeAppointment back = new FrmBeforeAppointment();
        back.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    
    public void mostrar (){
        
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
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JCAppointmetDay;
    private javax.swing.JButton btnAgend;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbxServices;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtName;
    // End of variables declaration//GEN-END:variables
}
