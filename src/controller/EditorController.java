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
import util.Utils;
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
            if (f != null) {
                txtruta.setText(f.getAbsolutePath().substring(61).replace("\\", "/"));
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
        if (event.getSource() == btnEliminar) {
            //VERIFICACION SI LA LISTA ES VACIA O NO
            if (!listHeroe.isEmpty()) {
                //ELIMINACION HACIA LA BASE DE DATOS
                deleteData();
                //ELIMINACION DEL OBJETO EN EL COMPONENTE TABLEVIEW 
                tbHeroes.getItems().remove(tbHeroes.getSelectionModel().getSelectedItems().get(0));
                //LIMPIEZA DE LAS CAJAS DE TEXTO
                clearText();
                //MENSAJE
                JOptionPane.showMessageDialog(null, "Se elimino item seleccionado con exito");
            } else {
                //MENSAJE
                JOptionPane.showMessageDialog(null, "No hay ningun elemento seleccionado");
            }
        }
    }

    //METODO DE ACTUALIZACION DEL OBJETO HEROE 
    @FXML
    private void onUpdateData(ActionEvent event) {
        //VERIFICACION DEL QUE EL BOTON QUE LLAME A ESTE EVENTO SEA EL DE ACTUALIZAR
        if (event.getSource() == btnModificar) {
            //VERIFICACION QUE NINGUNA CAJA DE TEXTO ESSTE VACIA 
            if (!txtNombreH.getText().isEmpty() && !txtAlter.getText().isEmpty() && !txtPublicacion.getText().isEmpty()
                    && !txtPersonaje.getText().isEmpty() && !txtruta.getText().isEmpty() && cbMarvelOrDc.getValue() != null) {
                //VERIFICACION SI LA LISTA ES VACIA O NO
                if (!listHeroe.isEmpty()) {
                    //ACTUALIZACION A LA BASE DE DATOS Y EL METODO DEVUELVE EL OBJETO ACTUALIZADO PARA HACER EL REMPLAZO 
                    //EN EL TABLEVIWE DEL DICHO OBJETO
                    Heroe h = uploadData();
                    //VERIFICACION SI HUBO  UN ERROR LO RETORNA VACIO EN CASO DE QUE NO RETORNA EL OBJETO ACTUALIZADO 

                    if (h != null) {
                        //REMPLAZA EL OBJETO ACTUALIZADO AL TABLEVIEW PARA MAYOR COMPRENCION
                        listaConductores.set(tbHeroes.getSelectionModel().getSelectedIndex(), h);
                        //LIMPIEZA DE LAS CAJAS DE TEXTO
                        clearText();
                        JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en el update");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No hay ningun elemento seleccionado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Datos sin completar en el formulario");
            }

        }
    }

    //METODO DE INIZIALIZACION DE LISTA
    void initLista() {
        //SENTENCIA SQL A EJECUTAR EN LA BD
        String sql = "SELECT* FROM heroes ORDER BY id";
        //IMPRECION POR CONSOLA PARA SABER QUE SQL SE ESTA EJECUTANDO
        System.out.println(sql);
        try {
            // EJECUCUCION DEL QUERY
            ResultSet rs = con.ejecutarSQLSelect(sql);
            //RECORRER RESPUESTA DEL SQL Y AGREGAR CADA UNO D ELOS REGISTROS COMO OBJETO EN LA LISTA
            while (rs.next()) {
                listHeroe.add(new Heroe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }

            //VERIFICACION QUE NO ESTE VACIO LA LISTA TIENE QUE SER MAYOR A UNO 
            if (listHeroe.isEmpty()) {
                tbHeroes.setPlaceholder(new Label("No hay registros!!"));
            } else {
                //LLENADO DE LA INFORMACION DEL OBSERVABLE Y DEFINICION DEL NOMBRE DE CADA UNO DE LAS COLUMNAS LOS MISMOS NOMBRES
                // DE LAS COLUMNAS TIENEN QUE SER LOS MISMO NOMBRES DE LA CLASE PARA HACER REFERENCIA A LA ASIGNACION DE CADA OBJETO
                listaConductores = FXCollections.observableArrayList(listHeroe);
                tbHeroes.setItems(listaConductores);
                clID.setCellValueFactory(new PropertyValueFactory<>("id"));
                clEditorial.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                clNombre.setCellValueFactory(new PropertyValueFactory<>("alia"));
                clAlter.setCellValueFactory(new PropertyValueFactory<>("fecha"));
                clPubli.setCellValueFactory(new PropertyValueFactory<>("enemigo"));
                clChara.setCellValueFactory(new PropertyValueFactory<>("universo"));
                clFoto.setCellValueFactory(new PropertyValueFactory<>("urlImg"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "exception: " + ex);
        }

    }

    //METODO PARA GUARDAR LA INFORMACION A LA BD
    void saveData() {
        try {
            //DEFINICION DE SENTENCIA SQL CON PARAMETROS
            String sql = "INSERT INTO public.heroes(nombre, alia, fecha, enemigo, universo, img) VALUES (?, ?, ?, ?, ?, ?)";
            //EJCUCION DE SENTENCIA
            PreparedStatement ps = con.getConexion().prepareStatement(sql);
            // PARAMETROS ASIGNADOS 
            ps.setString(1, txtNombreH.getText());
            ps.setString(2, txtAlter.getText());
            ps.setString(3, txtPublicacion.getText());
            ps.setString(4, txtPersonaje.getText());
            ps.setString(5, cbMarvelOrDc.getValue().toString());
            ps.setString(6, txtruta.getText());

            ps.execute();
            ps.close();
            //AGREGAMIENTO DEL OBJETO GUARDADO EN EL TABLEVIEW
            listaConductores.add(new Heroe(listHeroe.isEmpty()?1:listHeroe.get(listHeroe.size() - 1).getId() + 1, txtNombreH.getText(), txtAlter.getText(), txtPublicacion.getText(), txtPersonaje.getText(), cbMarvelOrDc.getValue().toString(), txtruta.getText()));
            //LIMPIEZA DE LA VAJAS DE TEXTO
            clearText();

            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException | NumberFormatException | HeadlessException x) {
            JOptionPane.showMessageDialog(null, "exception 2 " + x);
        }
    }

    // METODO ACTUALIZACION DE OBJETO HEROE
    Heroe uploadData() {
        //DEFINICION DE SENTENCIA SQL CON PARAMETROS
        String sql = "UPDATE public.heroes SET  nombre=?, alia=?, fecha=?, enemigo=?, universo=?, img=? WHERE id= ?";
        Heroe heroe = null;
        try {
            //EJECUCUION DE LA SENTENCIA SQL
            PreparedStatement ps = con.getConexion().prepareStatement(sql);
            // PARAMETROS ASIGNADOS 
            ps.setString(1, txtNombreH.getText());
            ps.setString(2, txtAlter.getText());
            ps.setString(3, txtPublicacion.getText());
            ps.setString(4, txtPersonaje.getText());
            ps.setString(5, cbMarvelOrDc.getValue().toString());
            ps.setString(6, txtruta.getText());
            ps.setInt(7, Integer.valueOf(tf_codigo.getText()));
            heroe = new Heroe(Integer.valueOf(tf_codigo.getText()), txtNombreH.getText(), txtAlter.getText(), txtPublicacion.getText(), txtPersonaje.getText(), cbMarvelOrDc.getValue().toString(), txtruta.getText());
            ps.execute();
            ps.close();
        } catch (NumberFormatException | SQLException x) {
            JOptionPane.showMessageDialog(null, "exception 2 " + x);
        }

        return heroe;
    }

    //EVENTO DE ELIMINACION HACIA LA BD
    void deleteData() {
        //DEFINICION DE SENTENCIA SQL CON PARAMETROS
        String sql = "DELETE FROM public.heroes WHERE id= ?";

        try {
            //EJECUCUION DE LA SENTENCIA SQL
            PreparedStatement ps = con.getConexion().prepareStatement(sql);
            // PARAMETROS ASIGNADOS 
            ps.setInt(1, Integer.valueOf(tf_codigo.getText()));

            ps.execute();
            ps.close();
        } catch (NumberFormatException | SQLException x) {
            JOptionPane.showMessageDialog(null, "exception 2 " + x);
        }

    }

    //METODO DE CLICK EN CADA UNA DE LAS CELDAS
    private void onClicksetCellvalue() {
        tbHeroes.setOnMouseClicked((MouseEvent event) -> {
            Heroe e = tbHeroes.getItems().get(tbHeroes.getSelectionModel().getSelectedIndex());
            tf_codigo.setText("" + e.getId());
            txtNombreH.setText(e.getNombre());
            txtAlter.setText(e.getAlia());
            txtPublicacion.setText(e.getFecha());
            txtPersonaje.setText(e.getEnemigo());
            txtruta.setText(e.getUrlImg());
            cbMarvelOrDc.setValue(e.getUniverso());
        });
    }

    //METODO DE LIMPIEZA DE LAS CAJAS DE TEXTO
    void clearText() {
        tf_codigo.setText("");
        txtNombreH.setText("");
        txtAlter.setText("");
        txtPublicacion.setText("");
        txtPersonaje.setText("");
        txtruta.setText("");
    }

}
