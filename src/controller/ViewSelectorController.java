
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Conexion;

/**
 * FXML Controller class
 *
 * @author Shokuhou
 */
public class ViewSelectorController implements Initializable {

    @FXML
    private Button btnMarvel;
    @FXML
    private Button btnDC;
    @FXML
    private Button btnEditor;
    @FXML
    private Button btnBuscar;

    Conexion con = new Conexion();
    @FXML
    private Button btnSearchFill;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mostrarMarvel(ActionEvent event) throws Exception {
 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginheroess/heroesimg3.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            Heroesimg3Controller controlador = loader.getController();

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
     
    }

    @FXML
    private void buscar(ActionEvent event) throws Exception {

        

    }

    @FXML
    private void mostrardc(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/loginheroess/heroesimg2.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
      
    }

    @FXML
    private void editor(ActionEvent event) throws IOException {
       }
    

    @FXML
    private void onSeachFill(ActionEvent event) throws IOException {
       

}
}
