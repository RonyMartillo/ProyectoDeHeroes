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
import models.Heroe;

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

    
private ObservableList<Heroe> listaConductores;
    private final ObservableList<String> listCombc = FXCollections.observableArrayList(Utils.ListUniversos);

    @FXML
    private TableView<Heroe> tbHeroes;
    @FXML
    private TableColumn<Heroe, Integer> clID;
    @FXML
    private TableColumn<Heroe, String> clEditorial;
    @FXML
    private TableColumn<Heroe, String> clNombre;
    @FXML
    private TableColumn<Heroe, String> clAlter;
    @FXML
    private TableColumn<Heroe, String> clPubli;
    @FXML
    private TableColumn<Heroe, String> clChara;
    @FXML
    private TableColumn<Heroe, String> clFoto;
    //llamado de lista
    List<String> lastFile;
    List<Heroe> listHeroe = new ArrayList<>();
    //instancia de la conexion 
    Conexion con = new Conexion();

    @FXML
    private void GuardarDatos(ActionEvent event) {
        if (event.getSource() == btnAgregar) {
            if (!txtNombreH.getText().isEmpty() && !txtAlter.getText().isEmpty() && !txtPublicacion.getText().isEmpty()
                    && !txtPersonaje.getText().isEmpty() && !txtruta.getText().isEmpty() && cbMarvelOrDc.getValue() != null) {
                saveData();
            } else {
                JOptionPane.showMessageDialog(null, "Datos sin completar en el formulario");
            }
        }
    }

    @FXML
    private void buscarimg(ActionEvent btnBuscaImg) {
        if (btnBuscaImg.getSource() == this.btnBuscaImg) {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Solo archivos jpg", lastFile));
            File f = fc.showOpenDialog(null);
            // C:\Users\Shokuhou\Documents\NetBeansProjects\JavaFXHeroes\src\imagenheroes
            // C:\Users\User\Downloads\JavaFXHeroes\src\imagenheroes
            if (f != null) {
                txtruta.setText(f.getAbsolutePath().substring(45).replace("\\", "/"));
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //llenado del observable list a el componente del combo box 
        cbMarvelOrDc.setItems(listCombc);
        //creacion de la lista de la extensiones a elegir en el exporador de archivos 
        lastFile = new ArrayList<>();
        lastFile.add("*.jpg");
        lastFile.add("*.JPG");
        lastFile.add("*.PNG");
        lastFile.add("*.png");
        lastFile.add("*.JPEG");
        lastFile.add("*.jpeg");
        //inizializar lista de heroes consulta de la base de datos
        initLista();
        //evento de seleccion de column en el tableview para la optencion de datos
        onClicksetCellvalue();

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
