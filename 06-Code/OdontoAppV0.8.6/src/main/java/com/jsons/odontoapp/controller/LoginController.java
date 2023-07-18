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
public class LoginController {
    private static final String CONNECTION_STRING = "mongodb+srv://RBenavides:RBenavides@cluster0.js2ve9m.mongodb.net/";
        
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private Document selectedDocument;
    private String selectedJson;
    private JTextField txtPassword;
    private JTextField txtUsername;
    
    public LoginController(JTextField txtUsername, JTextField txtPassword) {
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
}

    
    public void PasswordController() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("OdontoApp");
        collection = database.getCollection("Password");
        System.out.println("ingreso a la base de datos");
        
        FindIterable<Document> documentos = collection.find();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Document documento : documentos) {
            // Convertir el documento a JSON y mostrarlo en la consola
            String json = documento.toJson();
            listModel.addElement(json); 
            
        }
        // Establecer el modelo de la lista en jList1
        System.out.println(listModel);
    }
    
    public boolean VerificatePassword() {
        // Obtener el valor del campo de contraseña del componente txtPassword
        String enteredPassword = txtPassword.getText();

        // Construir la consulta para buscar el documento con la contraseña encriptada correspondiente
        Document query = new Document("password", CesarCipherController.encrypt(enteredPassword, 3)); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar

        // Realizar la consulta en la colección de la base de datos
        FindIterable<Document> result = collection.find(query);

        // Verificar si se encontró algún documento con la contraseña encriptada igual al valor ingresado
        boolean found = false;
        for (Document document : result) {
            found = true;
            break;
        }

        if (found) {
            System.out.println("Contraseña válida.");

            // Desencriptar la contraseña almacenada en LoginController
            String decryptedPassword = CesarCipherController.decrypt(enteredPassword, 0); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
            System.out.println("Contraseña desencriptada: " + decryptedPassword);

            // Comparar la contraseña desencriptada con el valor ingresado
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

        // Construir la consulta para buscar el documento con el nombre de usuario encriptado correspondiente
        Document query = new Document("username", CesarCipherController.encrypt(enteredUsername, 3)); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
        
        // Realizar la consulta en la colección de la base de datos
        FindIterable<Document> result = collection.find(query);

        // Verificar si se encontró algún documento con el nombre de usuario encriptado igual al valor ingresado
        boolean found = false;
        for (Document document : result) {
            found = true;
            break;
        }

        if (found) {
            System.out.println("Username válida.");

            // Desencriptar el nombre de usuario almacenado en LoginController
            String decryptedUsername = CesarCipherController.decrypt(enteredUsername, 0); // Asegúrate de utilizar el mismo desplazamiento que se usó al encriptar
            System.out.println("Username desencriptada: " + decryptedUsername);

            // Comparar el nombre de usuario desencriptado con el valor ingresado
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
