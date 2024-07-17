
package com.quotegen.controllers;

import com.quotegen.domain.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class FXMLCardUserController implements Initializable {

    
    @FXML Button  buttonDelete,buttonView,buttonEdit; 
    @FXML Label cardNameUser; 
    @FXML ImageView validateIniciarUsername,validateIniciarEmail,validateIniciarPassword,validateRepeatPassword; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
         buttonDelete.setOnAction((event) -> {  
             System.out.println("Eliminando usuario"+buttonDelete.getText() +" ?");
        }); 
          buttonEdit.setOnAction((event) -> {  
             System.out.println("Editando usuario"+buttonEdit.getText() +" ?");
        });
           buttonView.setOnAction((event) -> {  
             System.out.println("Viendo usuario"+buttonView.getText() +" ?");
        });
    }    
    
    
    public void setUserData(Usuario user) {
        cardNameUser.setText(user.getUsername()); 
        buttonDelete.setText(user.getUsername()); 
        buttonEdit.setText(user.getUsername()); 
        buttonView.setText(user.getUsername());
    }
    
    
    
    
    
    
    
}
