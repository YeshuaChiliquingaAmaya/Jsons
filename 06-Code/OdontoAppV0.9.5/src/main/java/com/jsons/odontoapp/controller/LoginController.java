package com.jsons.odontoapp.controller;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.bson.Document;

/**
 *
 * @author yeshualinux
 */
public class LoginController extends ConnectionController{
    
    private static LoginController uniqueInstance;
    private MongoCollection<Document> collection = super.getDatabase().getCollection("Password");
    private Document selectedDocument;
    private String selectedJson;
    private JTextField txtPassword;
    private JTextField txtUsername;

    public static LoginController getInstance(JTextField txtUsername, JTextField txtPassword){
        if(uniqueInstance == null){
            uniqueInstance = new LoginController(txtUsername, txtPassword);
        }
        return uniqueInstance;
    }
    
    private LoginController(JTextField txtUsername, JTextField txtPassword) {
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
    }

    public void PasswordController() {
        
        System.out.println("ingreso a la base de datos");
        
        FindIterable<Document> documentos = collection.find();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Document documento : documentos) {
            String json = documento.toJson();
            listModel.addElement(json);   
        }
        System.out.println(listModel);
    }
    
    public boolean VerificatePassword() {
        String enteredPassword = txtPassword.getText();
        Document query = new Document("password", CesarCipherController.encrypt(enteredPassword, 3)); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
        FindIterable<Document> result = collection.find(query);
        boolean found = false;
        for (Document document : result) {
            found = true;
            break;
        }

        if (found) {
            System.out.println("Contraseña válida.");
            String decryptedPassword = CesarCipherController.decrypt(enteredPassword, 0); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
            System.out.println("Contraseña desencriptada: " + decryptedPassword);
            if (decryptedPassword.equals(enteredPassword)) {
                System.out.println("La contraseña ingresada es correcta.");
                return true;
            } 
        } else {
            System.out.println("Contraseña inválida.");
            JOptionPane.showMessageDialog(txtPassword, "Contraseña Inválida"
                    + "\n Intente otra vez");
        }
        return false;
    }
    
    public boolean VerificateUsername(){
        String enteredUsername = txtUsername.getText();
        Document query = new Document("username", CesarCipherController.encrypt(enteredUsername, 3)); 
        FindIterable<Document> result = collection.find(query);
        boolean found = false;
        for (Document document : result) {
            found = true;
            break;
        }

        if (found) {
            System.out.println("Username válida.");
            String decryptedUsername = CesarCipherController.decrypt(enteredUsername, 0); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
            System.out.println("Username desencriptada: " + decryptedUsername);
            if (decryptedUsername.equals(enteredUsername)) {
                System.out.println("El username ingresado es correcto.");
                return true;
            }
        } else {
            System.out.println("Username inválida.");
            JOptionPane.showMessageDialog(txtUsername, "Nombre de Usuario Inválido"
                    + "\n Intente otra vez");
        }
        return false;
    }
}
