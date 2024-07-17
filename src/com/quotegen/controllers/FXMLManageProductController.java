
package com.quotegen.controllers;

import com.quotegen.domain.ProductData;
import com.quotegen.domain.ProductSession;
import com.quotegen.domain.Producto;
import com.quotegen.domain.UserDataUser;
import com.quotegen.domain.UserSession;
import com.quotegen.domain.Usuario;
import com.quotegen.implement.ProductImplements;
import com.quotegen.implement.UserImplements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLManageProductController implements Initializable {
        
       private static final String URLJSONFile = "/com/quotegen/assets/productos.json";  
    
    UserImplements userfun  = new UserImplements();
    Usuario usuario = UserSession.getInstance().getUsuarioLogIn();
   
    @FXML  private FlowPane flowPaneContainer; 
     @FXML private Label NameManageUser,RolManageUser;
    @FXML Button CreateProduct;  
    
    ProductImplements productfun = new ProductImplements();
    ArrayList<Producto> producto = new ArrayList<>(); 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        OnLoadProduct(flowPaneContainer); 
          ProductData.getInstance().setDataProductos(producto);  
          
          CreateProduct.setOnAction((event)->{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLProducActionView.fxml"));
            Parent root =null; 
            try {
                root = loader.load();
                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Crear Producto");
                Scene scene = new Scene(root);
                modalStage.setScene(scene);
                modalStage.showAndWait();
                
            } catch (IOException ex) { 
                System.out.println(ex.getMessage());
            }
          });
          
        fillManage(usuario); 
        
    }   
    
        private void autorize(Usuario usuario) { 
        if(!usuario.getNameRol().equals("Admin")){
            CreateProduct.setDisable(true);
        }
        else CreateProduct.setDisable(false);
        
    }
        
    private void fillManage(Usuario usuario){
        autorize(usuario); 
        NameManageUser.setText(usuario.getUsername()); 
        RolManageUser.setText(usuario.getNameRol());
    } 
    

    private void OnLoadProduct(FlowPane flowpane) {   
        
         producto =productfun.readProduct(URLJSONFile); 
         
         if (producto.size()>0) {
             for (Producto productorecorrido : producto) {
                   try { 
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLCardProduct.fxml"));
                AnchorPane anchorPane = loader.load();
            //-------------------------------------------------------------------------------------------------------IMPORTANTE EL MANEJO DE SINGLETON
                FXMLCardProductController controller = loader.getController(); 
                controller.setProductData(productorecorrido); // esta obteniendo el valor de el ultimo elemento
                flowpane.getChildren().add(anchorPane); 
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
             }
        } else JOptionPane.showMessageDialog(null, " No hay Datos");
          
    } 
    
    
    
    
    
    
}
