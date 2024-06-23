
package com.quotegen.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class FXMLDasboardController implements Initializable {

   @FXML 
   private  AnchorPane viewChangeDashboard,anchorDasboardMain;
    
   @FXML 
   private Label buttonNavUser,buttonNavProduct,buttonNavQuote,buttonNavDasboard
           ,buttonNavExit;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
    
        changeNavDasboard(); 
    }    

    
    public void changeNavDasboard(){
        buttonNavUser.setOnMouseClicked(this::actionNavUser); 
        buttonNavProduct.setOnMouseClicked(this::actionNavProduct);
        buttonNavQuote.setOnMouseClicked(this::actionNavQuote); 
        buttonNavDasboard.setOnMouseClicked(this::actionNavDasboard); 
        buttonNavExit.setOnMouseClicked(this::actionNavExit);
    }
    
    private void actionNavUser(MouseEvent event) { 
       try {
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/com/quotegen/views/FXMLManageUser.fxml"));
           setContent(pane);     
       } catch (IOException ex) { 
           System.out.println(ex.getMessage());
       }
        
    } 
    private void actionNavProduct(MouseEvent event) { 
       try {
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/com/quotegen/views/FXMLManageProduct.fxml"));
           setContent(pane);     
       } catch (IOException ex) { 
           System.out.println(ex.getMessage());
       }
        
    }
    private void actionNavQuote(MouseEvent event) { 
       try {
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/com/quotegen/views/FXMLQuoteGenerator.fxml"));
           setContent(pane);     
       } catch (IOException ex) { 
           System.out.println(ex.getMessage());
       }
        
    }
  
    private void actionNavDasboard(MouseEvent event) { 
       try {
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/com/quotegen/views/FXMLWelcomeDasboard.fxml"));
           setContent(pane);     
       } catch (IOException ex) { 
           System.out.println(ex.getMessage());
       }
        
    } 

   
    
     private void setContent(AnchorPane pane) {
        viewChangeDashboard.getChildren().clear();
        viewChangeDashboard.getChildren().add(pane);
        // Anchor the loaded content to the edges of the contentPane
        AnchorPane.setTopAnchor(pane, 0.0);
        AnchorPane.setBottomAnchor(pane, 0.0);
        AnchorPane.setLeftAnchor(pane, 0.0);
        AnchorPane.setRightAnchor(pane, 0.0);
    }

    private void actionNavExit(MouseEvent event) {  
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Estás seguro de continuar?");
        alert.setContentText("Presiona Yes para continuar o No para cancelar.");

        // Configurar los botones del AlertDialog
        ButtonType buttonTypeYes = new ButtonType("Sí");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Mostrar el AlertDialog y esperar la respuesta del usuario
        Optional<ButtonType> result = alert.showAndWait();
        // Procesar la respuesta del usuario
        if (result.isPresent() && result.get() == buttonTypeYes) {
            System.out.println("Nada");
        } else {
          Platform.exit();
          
        }
    }

  
    

  
}
