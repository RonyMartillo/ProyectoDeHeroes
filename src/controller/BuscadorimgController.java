
package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import util.Conexion;


public class BuscadorimgController implements Initializable {

    @FXML
    private Button btnBuscar;
    @FXML
    private ComboBox<String> comboBox;

   

    @FXML
    private ImageView ImgView;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private Label lblAlia;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblEnemigo;
    @FXML
    private Label lblNombre;

    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicio de la lista estatica de universos disponible para los heroes
      
    }

   //EVENTO DE BUSQUEDA
    @FXML
    private void handleButton(ActionEvent event) {
        

    }
}
