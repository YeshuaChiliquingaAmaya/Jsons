/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jsons.odontoapp.view;

import com.jsons.odontoapp.controller.DentistController;
import com.jsons.odontoapp.controller.PatientController;
import com.jsons.odontoapp.controller.ServiceController;
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.Bill;
import com.jsons.odontoapp.model.Dentist;
import com.jsons.odontoapp.model.Patient;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeshualinux
 */
public class FrmRevenues extends javax.swing.JFrame {
    Dentist dentist = new Dentist();
    /**
     * Creates new form FrmRevenues
     */
    public FrmRevenues() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        try {
            this.dentist = DentistController.get();
        } catch (ParseException ex) {
            Logger.getLogger(FrmRevenues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 153, 255));

        jPanel3.setBackground(new java.awt.Color(204, 153, 255));

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setText("Ganancias al Día");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel2)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));

        jCalendar2.setEnabled(false);

        jCalendar3.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Activar Ganancias al Mes");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Factura de gancias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Calculadora de Ganancia");

        jButton2.setText("<-- Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addGap(161, 161, 161))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmOdontoApp odontoapp = new FrmOdontoApp();
        odontoapp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        boolean isChecked = jCheckBox1.isSelected();
        jCalendar2.setEnabled(isChecked);
        jCalendar3.setEnabled(isChecked);
        if(isChecked == true){
            jCalendar1.setEnabled(false);
        }else {
            jCalendar1.setEnabled(true);
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isChecked = jCheckBox1.isSelected();
        if (isChecked == false) {
            CalculateforDay();
        } else {
            CalculateforMonth();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void CalculateforDay(){
        // Obtener la fecha seleccionada en el JCalendar2
        Date selectedDate = jCalendar1.getDate();

        // Formatear la fecha al formato "MMM dd, yyyy, hh:mm:ss a"
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String selectedDateString = dateFormat.format(selectedDate);

        // Obtener la instancia del dentista desde la base de datos
        Dentist dentist;
        try {
            dentist = DentistController.get();
        } catch (ParseException ex) {
            // Manejar el error si ocurre una excepción al obtener el dentista
            ex.printStackTrace();
            return;
        }

        // Calcular las ganancias del día seleccionado
        double totalGanancias = 0;
        for (Bill bill : dentist.getFactures()) {
            String billDateString = dateFormat.format(bill.getDate());
            // Formatear la fecha sin incluir la hora, minutos y segundos
            String formattedBillDate = billDateString.substring(0, 12);
            String formattedSelectedDate = selectedDateString.substring(0, 12);

            if (formattedBillDate.equals(formattedSelectedDate)) {
                totalGanancias += bill.getValue();
            }
        }

        // Mostrar la factura de ganancias en el JTextPane1
        String factura = "<html><body>";
        factura += "<h1 style='text-align: center;'>Factura de ganancias del día " + selectedDateString + "</h1>";
        factura += "<hr>";
        factura += "<table style='width:100%; font-size:14px;'>";
        factura += "<tr><th>Servicio</th><th>Monto</th></tr>";

        // Aquí debes agregar cada servicio y su valor a la factura
        for (Bill bill : dentist.getFactures()) {
            String billDateString = dateFormat.format(bill.getDate());
            if (billDateString.equals(selectedDateString)) {
                factura += "<tr><td>" + "Servicio" + "</td><td>$" + bill.getValue() + "</td></tr>";
                // Puedes ajustar el texto "Servicio" para que muestre la información adecuada
            }
        }

        factura += "</table>";
        factura += "<hr>";
        factura += "<p style='text-align: right; font-size:16px;'>Total ganancias: $" + totalGanancias + "</p>";
        factura += "</body></html>";

        jTextPane1.setContentType("text/html");
        jTextPane1.setText(factura);
    }
    
    public void CalculateforMonth() {
        // Obtener la fecha de inicio seleccionada en el JCalendar2
        Date startDate = jCalendar2.getDate();

        // Obtener la fecha de fin seleccionada en el JCalendar3
        Date endDate = jCalendar3.getDate();

        // Formatear las fechas al formato "MMM dd, yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String startDateString = dateFormat.format(startDate);
        String endDateString = dateFormat.format(endDate);

        // Obtener la instancia del dentista desde la base de datos
        Dentist dentist;
        try {
            dentist = DentistController.get();
        } catch (ParseException ex) {
            // Manejar el error si ocurre una excepción al obtener el dentista
            ex.printStackTrace();
            return;
        }

        // Calcular las ganancias para el rango de fechas seleccionado
        double totalGanancias = 0;
        for (Bill bill : dentist.getFactures()) {
            Date billDate = bill.getDate();
            // Formatear la fecha sin incluir la hora, minutos y segundos
            String formattedBillDate = dateFormat.format(billDate);

            // Verificar si la fecha de la factura está dentro del rango seleccionado
            if (billDate.compareTo(startDate) >= 0 && billDate.compareTo(endDate) <= 0) {
                totalGanancias += bill.getValue();
            }
        }

        // Mostrar la factura de ganancias en el JTextPane1
        String factura = "<html><body>";
        factura += "<h1 style='text-align: center;'>Factura de ganancias del " + startDateString + " al " + endDateString + "</h1>";
        factura += "<hr>";
        factura += "<table style='width:100%; font-size:14px;'>";
        factura += "<tr><th>Servicio</th><th>Monto</th></tr>";

        // Aquí debes agregar cada servicio y su valor a la factura
        for (Bill bill : dentist.getFactures()) {
            String billDateString = dateFormat.format(bill.getDate());
            // Formatear la fecha sin incluir la hora, minutos y segundos
            String formattedBillDate = billDateString.substring(0, 12);

            if (formattedBillDate.compareTo(startDateString) >= 0 && formattedBillDate.compareTo(endDateString) <= 0) {
                factura += "<tr><td>" + "Servicio" + "</td><td>$" + bill.getValue() + "</td></tr>";
                // Puedes ajustar el texto "Servicio" para que muestre la información adecuada
            }
        }

        factura += "</table>";
        factura += "<hr>";
        factura += "<p style='text-align: right; font-size:16px;'>Total ganancias: $" + totalGanancias + "</p>";
        factura += "</body></html>";

        jTextPane1.setContentType("text/html");
        jTextPane1.setText(factura);
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
            java.util.logging.Logger.getLogger(FrmRevenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRevenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRevenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRevenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRevenues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
