package com.quotegen.controllers;

import com.quotegen.domain.ProductSession;
import com.quotegen.domain.Producto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLCardProductController implements Initializable {
        private Producto producto; 
        
        
      @FXML Label cardName;
      @FXML Button  buttonDelete,buttonView,buttonEdit; 
    // Hacer un String que haga un patron de diseño 
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
    }     
     public void setProductData(Producto producto) {
        this.producto = producto;

        // Asigna los datos a los elementos de la interfaz gráfica aquí
        if (this.producto != null) {
            cardName.setText(producto.getDescription());
        }

        buttonEdit.setOnAction(event -> {
            ProductSession.getInstance().setProducto(this.producto);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLProducActionView.fxml"));
            Parent root = null;

            try {
                root = loader.load();
                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Actualizar Producto");
                Scene scene = new Scene(root);
                modalStage.setScene(scene);
                modalStage.showAndWait();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }); 
        
        buttonView.setOnAction((event)->{
                  ProductSession.getInstance().setProducto(this.producto);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLActionView.fxml"));
            Parent root = null;  
            
              try {
                root = loader.load();
                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Ver Data  Producto");
                Scene scene = new Scene(root);
                modalStage.setScene(scene);
                modalStage.showAndWait();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        });
        
    
     }  
    
    
    
    public String getFiltrerData (){
        return cardName.getText();
    }
    
}
