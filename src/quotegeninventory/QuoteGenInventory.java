
package quotegeninventory;

import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class QuoteGenInventory extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/quotegen/views/FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);  
        stage.initStyle(StageStyle.UNDECORATED); 
     
        stage.show();    
        
        // Esto hace que con el boton de escape se cierre la app 
         scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                confirmCloseApp(stage);
            }
        });      
    }

    public static void main(String[] args) {
        launch(args);
    } 
    
    public void confirmCloseApp (Stage stage){
           // Crear el AlertDialog
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
             stage.close();
        }
    }
   
    
}
