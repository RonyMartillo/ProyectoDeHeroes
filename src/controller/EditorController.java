package controller;

import java.awt.HeadlessException;
import java.io.File;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

import util.Conexion;

/**
 * FXML Controller class
 *
 * @author Shokuhou
 */
public class EditorController implements Initializable {

    @FXML
    private TextField txtNombreH;
    @FXML
    private TextField txtAlter;
    @FXML
    private TextField txtPersonaje;
    @FXML
    private TextField txtruta;
    @FXML
    private TextField txtPublicacion;
    @FXML
    private TextField tf_codigo;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private ComboBox cbMarvelOrDc;
    @FXML
    private Button btnBuscaImg;

    /**
     * Initializes the controller class.
     */

    

    @FXML
    private TableView<?> tbHeroes;
    @FXML
    private TableColumn<?,?> clID;
    @FXML
    private TableColumn<?,?> clEditorial;
    @FXML
    private TableColumn<?,?> clNombre;
    @FXML
    private TableColumn<?,?> clAlter;
    @FXML
    private TableColumn<?,?> clPubli;
    @FXML
    private TableColumn<?,?> clChara;
    @FXML
    private TableColumn<?,?> clFoto;
    //llamado de lista
    List<String> lastFile;
    
   
   

    @FXML
    private void GuardarDatos(ActionEvent event) {
        
    }

    @FXML
    private void buscarimg(ActionEvent btnBuscaImg) {
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //llenado del observable list a el componente del combo box 
       

    }

    //METODO DE ELEMINACION DEL OBJETO HEROE
    @FXML
    private void onDeleteData(ActionEvent event) {
        //VERIFICACION DEL QUE EL BOTON QUE LLAME A ESTE EVENTO SEA EL DE ELIMINAR
        
    }

    //METODO DE ACTUALIZACION DEL OBJETO HEROE 
    @FXML
    private void onUpdateData(ActionEvent event) {
       
    }

    //METODO DE INIZIALIZACION DE LISTA
    void initLista() {
        

    }

    //METODO PARA GUARDAR LA INFORMACION A LA BD
    void saveData() {
        
    }

    // METODO ACTUALIZACION DE OBJETO HEROE
   // Heroe uploadData() {
       
    //}

    //EVENTO DE ELIMINACION HACIA LA BD
    void deleteData() {
       

    }

    //METODO DE CLICK EN CADA UNA DE LAS CELDAS
    private void onClicksetCellvalue() {
       
    }

    //METODO DE LIMPIEZA DE LAS CAJAS DE TEXTO
    void clearText() {
        

}
    }
