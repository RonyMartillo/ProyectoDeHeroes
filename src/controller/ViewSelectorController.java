
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

     
    }

    @FXML
    private void buscar(ActionEvent event) throws Exception {

        

    }

    @FXML
    private void mostrardc(ActionEvent event) throws IOException {
      
    }

    @FXML
    private void editor(ActionEvent event) throws IOException {
       }
    

    @FXML
    private void onSeachFill(ActionEvent event) throws IOException {
       

}
}
