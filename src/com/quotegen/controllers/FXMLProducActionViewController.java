
package com.quotegen.controllers;

import com.quotegen.domain.ProductSession;
import com.quotegen.domain.Producto;
import com.quotegen.implement.ProductImplements;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
public class FXMLProducActionViewController implements Initializable {

    @FXML TextField textnewProduct,textunit,textPrice; 
    
    @FXML Button buttonProductAction; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        ProductImplements productfun = new ProductImplements(); 
//        OnloadDataUpdate(); 

/**
        buttonProductAction.setOnAction((event)->{ 
            
            try {
                if (!areFieldsEmptyForNewProduct()) {
                    Producto producto = new Producto(textnewProduct.getText(), Integer.parseInt(textunit.getText()),
                            Double.parseDouble(textPrice.getText()),
                            (Double.parseDouble(textPrice.getText())*(Integer.parseInt(textunit.getText())))); 
                    
                    productfun.updateProduct(producto);
                    System.out.println("editado");
                } else {
                    JOptionPane.showMessageDialog(null, "Campos sin llenar!");
                }

            } catch (Exception e) {
            }
        
        }); // No se puede actualizar  
        
        **/
        buttonProductAction.setOnAction((event)->{
                try {
                    if (!areFieldsEmptyForNewProduct()) {
                           Producto producto = new Producto(textnewProduct.getText(), Integer.parseInt(textunit.getText()),
                            Double.parseDouble(textPrice.getText()),
                            (Double.parseDouble(textPrice.getText())*(Integer.parseInt(textunit.getText()))));  
                           productfun.insertProduct(producto); 
                           JOptionPane.showMessageDialog(null, "Producto Agregado");
                    }
                            
                    
            } catch (Exception e) { 
                e.printStackTrace();
            }
        });
        
    }     
    
    private boolean areFieldsEmptyForNewProduct() {
    TextField[] textFields = {
            textnewProduct, textunit, textPrice
    };

    for (TextField textField : textFields) {
        if (textField.getText().isEmpty()) {
            return true; // Si encuentra un campo vacío, retorna true
        }
    }
    return false; // Si todos los campos están llenos, retorna false
}

    private void OnloadDataUpdate() {  
        try {
            
            textnewProduct.setText(ProductSession.getInstance().getProducto().getDescription());
            textPrice.setText(String.valueOf(ProductSession.getInstance().getProducto().getPrice())); 
            textunit.setText(String.valueOf(ProductSession.getInstance().getProducto().getUnit())); 
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
        
    } 
}