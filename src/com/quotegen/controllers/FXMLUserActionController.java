package com.quotegen.controllers;

import com.quotegen.domain.UserDataUser;
import com.quotegen.domain.Usuario;
import com.quotegen.implement.UserImplements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLUserActionController implements Initializable { 
     
   private static final String URLJSONFile ="/com/quotegen/assets/userSession.json";
    
   
    UserImplements userfun = new UserImplements(); 
    Usuario usuarioNew =new Usuario();
     ArrayList<Usuario> listDataUsers  = UserDataUser.getInstance().getDatausuario() ;// valor actual
     
    @FXML TextField textnewUser,textEmail,textPassword,textRepeatPassword;  
    
    @FXML ImageView validateIniciarUsername,validateIniciarEmail,validateIniciarPassword,validateRepeatPassword; 
    
            
    @FXML Button buttonCreate;
    @FXML CheckBox checkPermission  ;
    
    @FXML Label textAction ;       
    
    private Stage stage; 

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
      UserDataUser.getInstance().setDatausuario(userfun.readUser(URLJSONFile)); 
      
        validateCreateUser(); 
        
         buttonCreate.setOnAction((event) -> { 
             if (usuarioNew!=null) {   
                 
                 permission();
                 userfun.insertUser(usuarioNew);  // agrega al json 
                 
                 // Esta ventana se cierre  y vuelva cargar los datos  
                 listDataUsers.add(usuarioNew);  //lista copia agrega un nuevo update
                 UserDataUser.getInstance().setDatausuario(listDataUsers);
             }
             else{
                 System.out.println(" nada");
             }
             
        });
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
                   usuarioNew.setEmail(textEmail.getText());
                   
                   
                   
               } else { 
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
                      validateIniciarEmail.setImage(newImage);
                   System.out.println("El correo electrónico no cumple con los criterios (menos de 7 caracteres antes de '@gmail.com').");
               }
           
         
        } else {
           Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
            validateIniciarEmail.setImage(newImage);
        }
    }

      public void validateCreateUser (){
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
                  
                    
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/disponible.png"));
                     validateIniciarPassword.setImage(newImage);  
                     textPassword.setText(newValue.substring(0, 9));
                     // Obtener valor 
                     usuarioNew.setPassword(textPassword.getText());
                    
                }
                else{
                    Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/nodisponible.png"));
                     validateIniciarPassword.setImage(newImage); 
                     
                }
            }
        });   
         textnewUser.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 9) {
                    textnewUser.setText(newValue.substring(0, 9)); 
                    
                     Image newImage = new Image(getClass().getResourceAsStream("/com/quotegen/resources/disponible.png"));
                     validateIniciarUsername.setImage(newImage);  
                     // Obtener valor 
                     usuarioNew.setUsername(textnewUser.getText());
                    
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

    private void permission() { 
        if (checkPermission.isSelected()) {
            usuarioNew.setPermission(true); 
            usuarioNew.setNameRol("Admin");
        }else{
            usuarioNew.setPermission(false); 
            usuarioNew.setNameRol("Consommer");
        }
    }

}