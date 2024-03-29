/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jsons.odontoapp.view;

import com.jsons.odontoapp.controller.ServiceController;
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.ClinicalHistory;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
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
public class FrmBuyServices extends javax.swing.JFrame {

    ServiceController serviceController = new ServiceController();
    
    DefaultTableModel tableServices = new DefaultTableModel();
    DefaultTableModel tableCart = new DefaultTableModel();

    Patient patient;
    
    ArrayList<Service> services = new ArrayList<Service>();

    boolean availableDiscount = false;
    
    private void setTableServicesModel(){
        
        String[] header = {"Servicio"};
        tableServices.setColumnIdentifiers(header);
        
        tblServices.setModel(tableServices);
        
        Object firstService[] = new Object[1];
        String profilaxis = "Profilaxis (limpieza dental): $25";
        firstService[0] = profilaxis;
        Object secondService[] = new Object[1];
        secondService[0] = "Profilaxis + Fluorización (especialmente para niños): $20";
        Object thirdService[] = new Object[1];
        thirdService[0] = "Restauraciones simples: $20";
        Object fourthService[] = new Object[1];
        fourthService[0] = "Restauraciones complejas (Las restauraciones pueden ser con resina o amalgama): $25";
        Object fifthService[] = new Object[1];
        fifthService[0] = "Restauraciones para niños (empastes para niños): $15";
        Object sixthService[] = new Object[1];
        sixthService[0] = "Extracciones (extracción de un diente): $20";
        Object seventhService[] = new Object[1];
        seventhService[0] = "Extracciones complicadas: $30";
        Object eighthService[] = new Object[1];
        eighthService[0] = "Tratamiento de un conducto (incisivos o dientes frontales): $60";
        Object ninthService[] = new Object[1];
        ninthService[0] = "Tratamiento de dos conductos (premolares): $80";
        Object tenthService[] = new Object[1];
        tenthService[0] = "Tratamiento de tres conductos (molares): $100";
        
        tableServices.addRow(firstService);
        tableServices.addRow(secondService);
        tableServices.addRow(thirdService);
        tableServices.addRow(fourthService);
        tableServices.addRow(fifthService);
        tableServices.addRow(sixthService);
        tableServices.addRow(seventhService);
        tableServices.addRow(eighthService);
        tableServices.addRow(ninthService);
        tableServices.addRow(tenthService);
        
    }
    
    private void setCartModel(){
        
        String[] header = {"Servicio", "Precio"};
        tableCart.setColumnIdentifiers(header);
        
        tblCart.setModel(tableCart);
        
        Object data[] = new Object[tblCart.getColumnCount()];
        
        if(services.size()  == 1){
            data[0] = services.get(0).getType();
            data[1] = services.get(0).getValue();
            tableCart.addRow(data);
        }else{
            if(services.size() >= tblCart.getSelectedRow()){
                data[0] = services.get(services.size()-1).getType();
                data[1] = services.get(services.size()-1).getValue();
                tableCart.addRow(data);
            }else{
                data[0] = services.get(tblCart.getSelectedRow() - (tblCart.getSelectedRow() - services.size())).getType();
                data[1] = services.get(tblCart.getSelectedRow() - (tblCart.getSelectedRow() - services.size())).getValue();
                tableCart.addRow(data);
            }
        }
        
    }
    
    /**
     * Creates new form FrmBuyServices
     */
    public FrmBuyServices(Patient patient) {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        setTableServicesModel();
        ClinicalHistory clinicalHistory = new ClinicalHistory();
        clinicalHistory = patient.getClinicalHistory();
        ArrayList<Service> patientServices = new ArrayList<Service>();
        patientServices = patient.getAcquiredServices();
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        appointments = patient.getAppointments();
        this.patient = new Patient();
        this.patient.setClinicalHistory(clinicalHistory);
        this.patient.setAcquiredServices(patientServices);
        this.patient.setAppointments(appointments);
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
        tblServices = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblAddCart = new javax.swing.JLabel();
        btnAddCart = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnDeleteFromCart = new javax.swing.JButton();
        lblDeleteFromCart = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuyServices = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        lblDiscountAvailable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        tblServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblServices.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblServices.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tblServicesComponentRemoved(evt);
            }
        });
        tblServices.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tblServicesAncestorRemoved(evt);
            }
        });
        tblServices.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tblServicesComponentMoved(evt);
            }
        });
        tblServices.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblServicesPropertyChange(evt);
            }
        });
        tblServices.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblServicesVetoableChange(evt);
            }
        });
        JScrollPanelPatientsTable.setViewportView(tblServices);

        btnAddCart.setText("Añadir al carrito");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAddCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 534, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddCart)
                    .addComponent(lblAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCart);

        btnDeleteFromCart.setText("Eliminar del carrito");
        btnDeleteFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFromCartActionPerformed(evt);
            }
        });

        btnBuyServices.setText("Comprar");
        btnBuyServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyServicesActionPerformed(evt);
            }
        });

        btnGoBack.setText("Regresar");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPanelPatientsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnDeleteFromCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDeleteFromCart, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBuyServices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiscountAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGoBack))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JScrollPanelPatientsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteFromCart)
                    .addComponent(lblDeleteFromCart, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiscountAvailable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuyServices)
                        .addComponent(btnGoBack)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblServicesComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblServicesComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblServicesComponentRemoved

    private void tblServicesAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblServicesAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblServicesAncestorRemoved

    private void tblServicesComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblServicesComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblServicesComponentMoved

    private void tblServicesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblServicesPropertyChange
        
    }//GEN-LAST:event_tblServicesPropertyChange

    private void tblServicesVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblServicesVetoableChange

    }//GEN-LAST:event_tblServicesVetoableChange

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        FrmChoosePatient frmChoosePatient = new FrmChoosePatient();
        frmChoosePatient.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        if(tblServices.getSelectedRow() == -1){
            lblAddCart.setText("Selecciona un servicio.");
            lblAddCart.setForeground(Color.RED);
        }else{
            lblDeleteFromCart.setVisible(false);
            lblAddCart.setVisible(false);
            switch (tblServices.getSelectedRow()) {
                case 0:
                    Service fisrtService = new Service();
                    fisrtService.setType("Profilaxis");
                    fisrtService.setValue(25);
                    services.add(fisrtService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 1:
                    Service secondService = new Service();
                    secondService.setType("Profilaxis + Fluorización");
                    secondService.setValue(20);
                    services.add(secondService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 2:
                    Service thirdService = new Service();
                    thirdService.setType("Restauraciones simples");
                    thirdService.setValue(20);
                    services.add(thirdService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 3:
                    Service fourthService = new Service();
                    fourthService.setType("Restauraciones complejas");
                    fourthService.setValue(25);
                    services.add(fourthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 4:
                    Service fifthService = new Service();
                    fifthService.setType("Restauraciones para niños");
                    fifthService.setValue(15);
                    services.add(fifthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 5:
                    Service sixthService = new Service();
                    sixthService.setType("Extracciones (extracción de un diente)");
                    sixthService.setValue(20);
                    services.add(sixthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 6:
                    Service seventhService = new Service();
                    seventhService.setType("Extracciones complicadas ");
                    seventhService.setValue(30);
                    services.add(seventhService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 7:
                    Service eighthService = new Service();
                    eighthService.setType("Tratamiento de un conducto (incisivos o dientes frontales)");
                    eighthService.setValue(60);
                    services.add(eighthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 8:
                    Service ninthService = new Service();
                    ninthService.setType("Tratamiento de dos conductos (premolares)");
                    ninthService.setValue(80);
                    services.add(ninthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                case 9:
                    Service tenthService = new Service();
                    tenthService.setType("Tratamiento de tres conductos (molares)");
                    tenthService.setValue(100);
                    services.add(tenthService);
                    lblAddCart.setText("Añadido al carrito.");
                    lblAddCart.setForeground(Color.BLACK);
                    lblAddCart.setVisible(true);
                    setCartModel();
                    break;
                default:
                    throw new AssertionError();
            }
            
            lblDiscountAvailable.setVisible(false);
            availableDiscount = false;
            double total = 0;
            for(Service service:services){
                total = total + service.getValue();
            }
            if(total > 200){
                lblDiscountAvailable.setText("Descuento de 20% Disponible!");
                lblDiscountAvailable.setForeground(Color.BLACK);
                lblDiscountAvailable.setVisible(true);
                availableDiscount = true;
            }
        }
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnDeleteFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFromCartActionPerformed
        if(tblCart.getSelectedRow() == -1){
            lblDeleteFromCart.setVisible(true);
            lblDeleteFromCart.setText("Selecciona un servicio.");
            lblDeleteFromCart.setForeground(Color.RED);
        }else{
            lblAddCart.setVisible(false);
            lblDeleteFromCart.setVisible(false);
            if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Profilaxis"){
                services.removeIf(service -> service.getType().equals("Profilaxis"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Profilaxis + Fluorización"){
                services.removeIf(service -> service.getType().equals("Profilaxis + Fluorización"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Restauraciones simples"){
                services.removeIf(service -> service.getType().equals("Restauraciones simples"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Restauraciones complejas"){
                services.removeIf(service -> service.getType().equals("Restauraciones complejas"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Restauraciones para niños"){
                services.removeIf(service -> service.getType().equals("Restauraciones para niños"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Extracciones (extracción de un diente)"){
                services.removeIf(service -> service.getType().equals("Extracciones (extracción de un diente)"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Extracciones complicadas "){
                services.removeIf(service -> service.getType().equals("Extracciones complicadas "));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Tratamiento de un conducto (incisivos o dientes frontales)"){
                services.removeIf(service -> service.getType().equals("Tratamiento de un conducto (incisivos o dientes frontales)"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Tratamiento de dos conductos (premolares)"){
                services.removeIf(service -> service.getType().equals("Tratamiento de dos conductos (premolares)"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            else if(tableCart.getValueAt(tblCart.getSelectedRow(), 0) == "Tratamiento de tres conductos (molares)"){
                services.removeIf(service -> service.getType().equals("Tratamiento de tres conductos (molares)"));
                lblDeleteFromCart.setText("Eliminado del carrito.");
                lblDeleteFromCart.setForeground(Color.BLACK);
                lblDeleteFromCart.setVisible(true);
            }
            tableCart.removeRow(tblCart.getSelectedRow());
            
            lblDiscountAvailable.setVisible(false);
            availableDiscount = false;
            double total = 0;
            for(Service service:services){
                total = total + service.getValue();
            }
            if(total > 200){
                lblDiscountAvailable.setText("Descuento de 20% Disponible!");
                lblDiscountAvailable.setForeground(Color.BLACK);
                lblDiscountAvailable.setVisible(true);
                availableDiscount = true;
            }
        }
    }//GEN-LAST:event_btnDeleteFromCartActionPerformed

    private void btnBuyServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyServicesActionPerformed
        if(services.size() == 0){
            JOptionPane.showMessageDialog(rootPane,"No hay nada en el carrito.");
        }else{
            StringBuilder message = new StringBuilder();
            for (Service service : services) {
                message.append("Servicio: ").append(service.getType()).append(", Valor: ").append(service.getValue()).append("\n");
            }
            
            if(availableDiscount){
                int option = JOptionPane.showConfirmDialog(this,"Está segura de que el paciente " + 
                patient.getClinicalHistory().getName() + " desea comprar estos servicios: \n" + message + "+DESCUENTO DEL 20% AL TOTAL DE LAS COMPRAS", "Advertencia de compra",1);
                if(option == 0){
                    JOptionPane.showMessageDialog(rootPane, "Comprado.");
                    int i = patient.getAcquiredServices().size();
                    for (Service service : services) {
                        patient.getAcquiredServices().add(i, service);
                        i++;
                    }
                    serviceController.add(patient);
                    FrmBill bill = new FrmBill(services, patient, availableDiscount);
                    bill.setVisible(true);
                    this.setVisible(false);
                }
                if(option == 1){
                    JOptionPane.showMessageDialog(rootPane, "No comprado.");
                }
                if(option == 2){
                    JOptionPane.showMessageDialog(rootPane, "Cancelado.");
                }
            }else{
                int option = JOptionPane.showConfirmDialog(this,"Está segura de que el paciente " + 
                patient.getClinicalHistory().getName() + " desea comprar estos servicios: \n" + message, "Advertencia de compra",1);
                if(option == 0){
                    JOptionPane.showMessageDialog(rootPane, "Comprado.");
                    int i = patient.getAcquiredServices().size();
                    for (Service service : services) {
                        patient.getAcquiredServices().add(i, service);
                        i++;
                    }
                    serviceController.add(patient);
                    FrmBill bill = new FrmBill(services, patient, availableDiscount);
                    bill.setVisible(true);
                    this.setVisible(false);
                }
                if(option == 1){
                    JOptionPane.showMessageDialog(rootPane, "No comprado.");
                }
                if(option == 2){
                    JOptionPane.showMessageDialog(rootPane, "Cancelado.");
                }
            }
        }
    }//GEN-LAST:event_btnBuyServicesActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        
    }//GEN-LAST:event_formPropertyChange

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
            java.util.logging.Logger.getLogger(FrmBuyServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuyServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuyServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuyServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanelPatientsTable;
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnBuyServices;
    private javax.swing.JButton btnDeleteFromCart;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAddCart;
    private javax.swing.JLabel lblDeleteFromCart;
    private javax.swing.JLabel lblDiscountAvailable;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblServices;
    // End of variables declaration//GEN-END:variables
}
