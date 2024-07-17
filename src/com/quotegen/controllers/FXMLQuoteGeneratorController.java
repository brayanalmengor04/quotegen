package com.quotegen.controllers;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import com.quotegen.domain.Customer;
import com.quotegen.domain.ProductSession;
import com.quotegen.domain.Producto;
import com.quotegen.domain.ProductoObservable;
import com.quotegen.domain.Reporte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.util.JRLoader; 

public class FXMLQuoteGeneratorController implements Initializable {

    Map parametro = new HashMap(); 
    FileChooser fileChooser = new FileChooser(); 
    private ObservableList<Producto> productosObservable=null;
    ArrayList<Producto> tableDataProducto =new  ArrayList<>() ; 
    Reporte reportetap =null;  
    
    @FXML private CheckBox includeItbms;
    @FXML private  ImageView imageCompanyButton;
    @FXML private TextField textNameCompany, textAddressCompany, textPhoneCompany, textEmailCompany,
            textNameCustomer, textAddressCustomer, textPhoneCustomer, textEmailCustomer,
            textDescriptionProduct, textUnitProduct, textPriceProduct;

    @FXML private Button buttonImageCompany,buttonPrintReporting,searchProductoQuote;

    @FXML Button  buttonDeleteProduct, buttonAddProduct;
    
    @FXML private TableView<Producto> tableProduct;
    @FXML private TableColumn<Producto,String> descripcionCol;
    @FXML  private TableColumn <Producto,Integer>unitcol;
    @FXML private TableColumn <Producto,Double> preciocol, totalcol; 

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
//            ProductoObservable valueTableAdd =  ProductoObservable.getInstance();   
        buttonAddProduct.setPickOnBounds(true); 
        
        
         productosObservable = FXCollections.observableArrayList();
//        if (valueTableAdd!=null) {
//            productosObservable.addAll(valueTableAdd.getProductos()); 
//            tableProduct.setItems(productosObservable);
//        }
//            
         
        configColumn();
        configActionButton();
        configTextField(textPriceProduct,textUnitProduct);  
        selectedTable();   
       
        
        
        
    }

    private void configColumn() {
        descripcionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        unitcol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        preciocol.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));
    } 
    
    @FXML
    private void fillDataProduct() {
        if (!areFieldsEmptyProduct()) { 
            
            
            // Guardamos el producto
            Producto productoAdd = new Producto(
                    textDescriptionProduct.getText(),
                    Integer.parseInt(textUnitProduct.getText()),
                    Double.parseDouble(textPriceProduct.getText())
            );
            productoAdd.setTotal(SubTotalProduct(productoAdd)); 
            
            productosObservable.add(productoAdd);
            tableProduct.setItems(productosObservable);
        //    TotalAllProduct(tableDataProducto);
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacíos de productos!");
        }
    }

    private Reporte fillDataQuoteClientsAndCompany() {
        if (!areFieldsEmpty()) {
            // Datos cliente y empresa
            String nameCompany = textNameCompany.getText();
            String addressCompany = textAddressCompany.getText();
            String phoneCompany = textPhoneCompany.getText();
            String emailCompany = textEmailCompany.getText();
            String nameCustomer = textNameCustomer.getText();
            String addressCustomer = textAddressCustomer.getText();
            String phoneCustomer = textPhoneCustomer.getText();
            String emailCustomer = textEmailCustomer.getText();

            Customer customer = new Customer(nameCustomer, addressCustomer, phoneCustomer, emailCustomer);
            return new Reporte(nameCompany, addressCompany, phoneCompany, emailCompany, customer);
        } else {
            JOptionPane.showMessageDialog(null, "Le falta algún dato de cliente o empresa!");
            return null;
        }
    }

    private boolean areFieldsEmpty() {
        TextField[] textFields = {
                textNameCompany, textAddressCompany, textPhoneCompany, textEmailCompany,
                
        };
       // textNameCustomer, textAddressCustomer, textPhoneCustomer, textEmailCustomer no es obligatorio
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true; // Si encuentra un campo vacío, retorna true
            }
        }
        return false; // Si todos los campos están llenos, retorna false
    }

    private boolean areFieldsEmptyProduct() {
        TextField[] textFields = {
                textDescriptionProduct, textUnitProduct, textPriceProduct
        };

        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true; // Si encuentra un campo vacío, retorna true
            }
        }
        return false; // Si todos los campos están llenos, retorna false
    }

    private double SubTotalProduct(Producto productoAdd) { 
        double subTotal = productoAdd.getPrice() * productoAdd.getUnit();

        return subTotal = Math.floor(subTotal * 100) / 100;
    }

    private double TotalAllProduct(ArrayList<Producto> tableDataProducto) {
        double valuetotalFinal = 0;
        for (Producto producto : tableDataProducto) {
            valuetotalFinal += producto.getTotal();
        }
        return valuetotalFinal= Math.floor(valuetotalFinal * 100) / 100;
    } 
    
    private double totalUnitProduct(ArrayList<Producto> tableDataProducto){
          double valuetotalFinal = 0;
        for (Producto producto : tableDataProducto) {
            valuetotalFinal += producto.getUnit();
        }
        return valuetotalFinal;
    }
    
    private double TotalAllProductItmbs(ArrayList<Producto> tableDataProducto) {
        double valuetotalFinal = 0;
        for (Producto producto : tableDataProducto) {
            double totalProducto = producto.getTotal();
            double itbms = totalProducto * 0.07;  // Calcula el 7% del total del producto
            valuetotalFinal += totalProducto + itbms;  // Suma el total del producto más el 7%
        }
        valuetotalFinal = Math.round(valuetotalFinal * 100.0) / 100.0;  // Redondea al segundo decimal

        return valuetotalFinal;
    }  
    
     private double Itmbs(ArrayList<Producto> tableDataProducto) {
         double valuetotalFinal = 0;
         for (Producto producto : tableDataProducto) {
             valuetotalFinal += producto.getTotal() * 0.07;
         }
         valuetotalFinal = Math.round(valuetotalFinal * 100.0) / 100.0;  // Redondea al segundo decimal
         return valuetotalFinal;
    } 

    private void configActionButton() {  
        
        searchProductoQuote.setOnAction((event)->{
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quotegen/views/FXMLListProductQuote.fxml"));
            Parent root =null; 
            try {
                root = loader.load();
                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Buscar Producto");
                Scene scene = new Scene(root);
                modalStage.setScene(scene);
                modalStage.showAndWait();
                
            } catch (IOException ex) { 
                System.out.println(ex.getMessage());
            }
        
            
        });
        
        
        
          buttonImageCompany.setOnAction((event)->{  
            
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(extFilter); 
        
        Stage stage = new Stage();
        // Mostrar el diálogo de selección de archivos
        File selectedFile = fileChooser.showOpenDialog(stage);
        
        if (selectedFile != null) {
            String imagePath = selectedFile.getAbsolutePath();  
             Image image = new Image(new File(imagePath).toURI().toString()); 
            imageCompanyButton.setImage(image); 
            
            parametro.put("imagecompany", imagePath);
            
            System.out.println("Ruta de la imagen seleccionada: " + imagePath);
        }

        });
        
        buttonPrintReporting.setOnAction((event) -> {   
            reportetap  = new Reporte(); 
            reportetap = fillDataQuoteClientsAndCompany(); 
            
            if (reportetap!=null && !areFieldsEmptyProduct()) { 
                
                
                for (Producto item : tableProduct.getItems()) {

                    Producto producto = new Producto(
                            item.getDescription(),
                             item.getUnit(), item.getPrice(), item.getTotal());

                    tableDataProducto.add(producto); // Agrego las personas 
                }
                try { 
                    
                    // Llenar Parametros Jasper 
                    
                    parametro.put("namecompany", reportetap.getNamecompany());
                    parametro.put("addresscompany", reportetap.getAddresscompany());
                    parametro.put("phonecompany", reportetap.getPhonecompany());
                    parametro.put("emailcompany", reportetap.getEmailcompany());
                    parametro.put("namecustommer", reportetap.getCustomer().getNamecustommer());
                    parametro.put("addresscustommer", reportetap.getCustomer().getAddresscustommer());
                    parametro.put("phonecustommer", reportetap.getCustomer().getPhonecustommer());
                    parametro.put("emailcustommer", reportetap.getCustomer().getEmailcustommer()); 
                    
                     parametro.put("totalproducto", totalUnitProduct(tableDataProducto));  
                    parametro.put("subtotal",TotalAllProduct(tableDataProducto)); 
                    parametro.put("silueta", getClass().getResource("/com/quotegen/resources/silueta.png")); 
                    
                     if (includeItbms.isSelected()) {
                             parametro.put("subtotal", TotalAllProduct(tableDataProducto));   
                           parametro.put("itbms", Itmbs(tableDataProducto)); 
                           parametro.put("preciofinalproducto", TotalAllProductItmbs(tableDataProducto)); 
                    }else{
                           parametro.put("subtotal", TotalAllProduct(tableDataProducto));   
                           parametro.put("itbms", 0.00); 
                           parametro.put("preciofinalproducto", TotalAllProduct(tableDataProducto));
                     }
                     
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/com/quotegen/reporting/quote.jasper"));
                    JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, new JRBeanCollectionDataSource(tableDataProducto));
                    JasperViewer showJasper = new JasperViewer(print, false);
                    showJasper.setTitle("Quote GEN");
                    showJasper.setVisible(true); 
                } catch (Exception e) {
                    System.out.println(e.getCause());
                }
            }
            
        }); 
        
        buttonAddProduct.setOnAction((event) ->{ 
                 fillDataProduct();  
                System.out.println("Presionado");
        });
    }

    private void configTextField(TextField textfieldprice , TextField textfieldunit) { 
        textfieldprice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*\\.?\\d{0,2}")) {
                    textfieldprice.setText(oldValue);
                } else if (newValue.chars().filter(ch -> ch == '.').count() > 1) {
                    textfieldprice.setText(oldValue);
                }
            }
        });  
        
         textfieldunit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,3}")) {
                   textfieldunit.setText(oldValue);
                }
            }
        });
    } 

    private void selectedTable() {  
        
        
                  tableProduct.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producto>() {
            @Override
            public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
                if (newValue != null) {
              
                // Eliminar el producto de la tabla
                  buttonDeleteProduct.setOnAction( (eveent) ->{
                        tableProduct.getItems().remove(tableProduct.getSelectionModel().getSelectedIndex());
            
                    });
        
                }
            }
        });
    }


    
    }
    

