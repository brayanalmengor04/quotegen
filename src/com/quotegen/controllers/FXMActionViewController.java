package com.quotegen.controllers;

import com.quotegen.domain.ProductSession;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMActionViewController implements Initializable { 
    
    
    @FXML Label textCantidad,textDescription,textPrecio; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        OnloadData();
        
    }    
    
    private void OnloadData() {  
        try {
            
            textDescription.setText(ProductSession.getInstance().getProducto().getDescription());
            textPrecio.setText(String.valueOf(ProductSession.getInstance().getProducto().getPrice())); 
            textCantidad.setText(String.valueOf(ProductSession.getInstance().getProducto().getUnit())); 
            
        } catch (Exception e) { 
            e.printStackTrace();
        } 
    }
}
