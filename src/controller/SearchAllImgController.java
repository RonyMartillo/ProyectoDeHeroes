package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JESUS
 */
public class SearchAllImgController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private Button btnBuscar;
    //COMPONENTE DE LA TABLE VIEW
    @FXML
    private TableView <?> tbHeroes;
    @FXML
    private TableColumn <?,?> CLNombre;
    @FXML
    private TableColumn<?,?> CLAlias;
    @FXML
    private TableColumn<?,?> CLPublicacion;
    @FXML
    private TableColumn<?,?> CLNemesis;
    @FXML
    private TableColumn<?,?> CLImagen;

    

   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }

    //EVENTO DE BUSQUEDA POR TODOS
    @FXML
    private void onTapBuscar(ActionEvent event) {
        
    }

}
