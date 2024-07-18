/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.quotegen.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLLoginController implements Initializable {
        
    @FXML 
    private Button buttonIniciar;
    
    @FXML 
    private ImageView imageLogin,imageHome,validateIniciarUsername,
    validateIniciarEmail,validateIniciarPassword; 
    
    @FXML 
    private Label textTitle,textRegister; 
    
    @FXML 
    private TextField textUser,textEmail;
     
    @FXML 
    private PasswordField textPassword; 
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
            
         validateLoginSignUp();
    }    
    
    @FXML 
    private void actionSignUp (ActionEvent event){
        try {  
            
            // Condicion de inicio de sesion 
            
            
            
            
            ////////////////////////////////////
            
           Parent root = FXMLLoader.load(getClass().getResource("/com/quotegen/views/FXMLDasboard.fxml"));
            Scene scene = new Scene(root);
           Stage stage = new Stage(); 
           stage.initStyle(StageStyle.UNDECORATED); 
           stage.setScene(scene); 
           stage.show();     
         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         currentStage.close(); 
         
        } catch (IOException ex) { 
            System.out.println(ex.getMessage());
        }
       
    }
    
    private void onEmailChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        validateEmail(newValue);
    }
    
    
      private void validateEmail(String email) { 
          
          
          
          
          
        if (!email.isEmpty() && email.length() >= 11 && email.endsWith("@gmail.com")) {
            
              String beforeAt = email.substring(0, email.indexOf("@"));
               // Verificar si tiene al menos 7 caracteres antes de @gmail.com
               if (beforeAt.length() >= 7) { 
                      Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/disponible.png"));
                      validateIniciarEmail.setImage(newImage);
                   System.out.println("El correo electrónico es válido.");
                   // Aquí va el código que deseas ejecutar si la condición es verdadera
               } else { 
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
                      validateIniciarEmail.setImage(newImage);
                   System.out.println("El correo electrónico no cumple con los criterios (menos de 7 caracteres antes de '@gmail.com').");
                   // Aquí va el código que deseas ejecutar si no cumple la condición de longitud antes de @gmail.com
               }
           
         
        } else {
           Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
            validateIniciarEmail.setImage(newImage);
        }
    }

      public void validateLoginSignUp (){
        textEmail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                validateEmail(newValue);
                
                // ObtenerValor
            }
        }); 
            textPassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 9) {
                  
                    textPassword.setText(oldValue); 
                    
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/disponible.png"));
                     validateIniciarPassword.setImage(newImage);  
                     textUser.setText(newValue.substring(0, 9));
                     // Obtener valor
                    
                }
                else{
                    Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
                     validateIniciarPassword.setImage(newImage); 
                     
                }
            }
        });   
         textUser.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 9) {
                    textUser.setText(newValue.substring(0, 9)); 
                    
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/disponible.png"));
                     validateIniciarUsername.setImage(newImage);  
                     // Obtener valor
                    
                }
                else{
                    Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
                     validateIniciarUsername.setImage(newImage); 
                     
                }
            }
        }); 
         
         // No Pemitir Mas @ 
          textEmail.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String currentText = textEmail.getText();
            String character = event.getCharacter();
            
            // Verificar si el carácter que se está ingresando es el símbolo '@'
            if ("@".equals(character)) {
                // Verificar si ya hay un '@' en el texto actual
                if (currentText.contains("@")) {
                    // Mostrar un mensaje de advertencia
                    event.consume();
                }
            }
        });
          
      }
      
      
      
}
