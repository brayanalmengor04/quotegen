package com.quotegen.controllers;

import com.quotegen.domain.ProductSession;
import com.quotegen.domain.Producto;
import com.quotegen.domain.ProductoObservable;
import com.quotegen.implement.ProductImplements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FXMLListProductQuoteController implements Initializable { 
    Producto product = new Producto();  
    ProductImplements producfun = new ProductImplements();
    ArrayList<Producto > productolist = producfun.readProduct("/com/quotegen/assets/productos.json") ; 
       ObservableList<Producto> data = FXCollections.observableArrayList(productolist);  
//        ProductoObservable valueTableAdd =  ProductoObservable.getInstance(); 
                
      Stage stage  = new Stage();  
      
        // Referencia al Stage
    @FXML private TableView<Producto> tableProduct;
    @FXML private TableColumn<Producto,String> descripcionCol;
    @FXML  private TableColumn <Producto,Integer>unitcol;
    @FXML private TableColumn <Producto,Double> preciocol, totalcol;  
    @FXML TableColumn<Producto, Void> actionColum ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        configColumn(); 
        selectedTable(); 
    }     
    
     private void configColumn() {
        descripcionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        unitcol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        preciocol.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));   
        
       
    Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>> cellFactory = new Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>>() {
        @Override
        public TableCell<Producto, Void> call(final TableColumn<Producto, Void> param) {
            final TableCell<Producto, Void> cell = new TableCell<Producto, Void>() {
                private final Button btn = new Button("Acción");

                {
                    btn.setOnAction(event -> {
                        // Volver a cargar otro controlador ?  
//                         valueTableAdd.addProducto(product);

                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        }
    }; 
    
    actionColum.setCellFactory(cellFactory);
        
        tableProduct.setItems(data);
    }  

    private void selectedTable() { 
           tableProduct.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producto>() {
            @Override
            public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
                if (newValue != null) {
                                ProductSession.getInstance().setProducto(newValue); 
                                // Cerrrar Aqui---------------------------- 
                                
                    }
            }
        }); 

    } 
    

}
