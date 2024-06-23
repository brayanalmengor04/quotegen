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


public class FXMLManageUserController implements Initializable {

    @FXML 
    private AnchorPane viewManageUser; 
    
    @FXML 
    private FlowPane flowPaneContainer; 
    
    @FXML 
    private Button buttonPrueba;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
     
        buttonPrueba.setOnAction((event) -> {  
            
            generateAnchorPane(flowPaneContainer);
        });
    }    
        
    
     private void generateAnchorPane(FlowPane flowPane) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(190, 185);
        anchorPane.setStyle("-fx-background-color: red;");
        flowPane.getChildren().add(anchorPane);
    }

    
    
}
