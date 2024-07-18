/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.quotegen.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import com.quotegen.domain.UserDataUser;
import com.quotegen.domain.UserSession;
import com.quotegen.domain.Usuario;
import com.quotegen.implement.UserImplements;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLManageUserController implements Initializable {
    private static final String URLJSONFile = "/com/quotegen/assets/userSession.json"; 
    
    UserImplements userfun  = new UserImplements();
    Usuario usuario = UserSession.getInstance().getUsuarioLogIn();
    
    @FXML 
    private Label NameManageUser,RolManageUser;
    
    @FXML 
    private AnchorPane viewManageUser; 
    
    @FXML 
    private FlowPane flowPaneContainer; 
    
    @FXML 
    private Button createUser,buttonChangeCambios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        UserDataUser.getInstance().setDatausuario(userfun.readUser(URLJSONFile)); 
        
        onLoadUser(flowPaneContainer); //Primero obtendra el valor inicial del json
        
        fillManage(usuario);
      
        createUser.setOnAction((event) -> {  
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLUserAction.fxml"));
            Parent root =null; 
            try {
                root = loader.load();
                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Crear Usuario");
                Scene scene = new Scene(root);
                modalStage.setScene(scene);
                modalStage.showAndWait();
                
            } catch (IOException ex) { 
                System.out.println(ex.getMessage());
            }
        });  
        
        
         buttonChangeCambios.setOnAction((event) -> {      
             onChangeData(flowPaneContainer);
        }); 
        
        
    }    
    
    private void autorize(Usuario usuario) { 
        if(!usuario.getNameRol().equals("Admin")){
            createUser.setDisable(true);
        }
        else createUser.setDisable(false);
        
    }
        
    private void fillManage(Usuario usuario){
        autorize(usuario); 
        NameManageUser.setText(usuario.getUsername()); 
        RolManageUser.setText(usuario.getNameRol());
    } 
    
    private void onChangeData (FlowPane flowPane){ 
         // le hago una copia del estado de la instancia  
         flowPane.getChildren().clear();
         
        for (int i = 0; i < UserDataUser.getInstance().getDatausuario().size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLCardUser.fxml"));
                AnchorPane anchorPane = loader.load();
                FXMLCardUserController controller = loader.getController();
                controller.setUserData(UserDataUser.getInstance().getDatausuario().get(i));
                flowPane.getChildren().add(anchorPane);
            } catch (IOException ex) {
                ex.printStackTrace(); 
            }
        }
        
    }
    
    
//
    
    private  void onLoadUser(FlowPane flowPane) {
          UserDataUser.getInstance().setDatausuario(userfun.readUser(URLJSONFile)); 
        for (int i = 0; i < UserDataUser.getInstance().getDatausuario().size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLCardUser.fxml"));
                AnchorPane anchorPane = loader.load();

                FXMLCardUserController controller = loader.getController();
                controller.setUserData(UserDataUser.getInstance().getDatausuario().get(i));
                flowPane.getChildren().add(anchorPane);
            } catch (IOException ex) {
                ex.printStackTrace(); 
            }
        }
    } 
    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
