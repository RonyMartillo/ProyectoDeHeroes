package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import models.HeroResponse;
import models.Heroe;
import util.Conexion;

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
    private TableView<HeroResponse> tbHeroes;
    @FXML
    private TableColumn<Heroe, String> CLNombre;
    @FXML
    private TableColumn<Heroe, String> CLAlias;
    @FXML
    private TableColumn<Heroe, String> CLPublicacion;
    @FXML
    private TableColumn<Heroe, String> CLNemesis;
    @FXML
    private TableColumn<Heroe, String> CLImagen;

    //ObservableList
    private final ObservableList<String> listCombo = FXCollections.observableArrayList("MARVEL", "DC.COMIC");
    private ObservableList<HeroResponse> listData = FXCollections.observableArrayList();

    //Conexion a la base de datos
    Conexion con = new Conexion();

    //LISTA DE BUSQUEDA
    List<HeroResponse> listHeroesResponse = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inizializar columnas y cambio en el ancho del componente de imagen
        CLImagen.setPrefWidth(100);
        CLNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        CLAlias.setCellValueFactory(new PropertyValueFactory<>("alia"));
        CLPublicacion.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        CLNemesis.setCellValueFactory(new PropertyValueFactory<>("enemigo"));
        CLImagen.setCellValueFactory(new PropertyValueFactory<>("urlImg"));
        //llenado del combobox 
        comboBox.setItems(listCombo);

    }

    //EVENTO DE BUSQUEDA POR TODOS
    @FXML
    private void onTapBuscar(ActionEvent event) {
        if (event.getSource() == btnBuscar) {
            //VERIFICACION QUE LOS CRITERIOS DE BUSQUEDA NO ENTREN VACIOS
            if (!txtBusqueda.getText().isEmpty() && comboBox.getValue() != null) {
                String sql = "SELECT * FROM heroes where alia like '%" + txtBusqueda.getText().trim().toLowerCase() + "%' AND universo = '" + comboBox.getValue() + "'";
                System.out.println(sql);
                try {
                    ResultSet rs = con.ejecutarSQLSelect(sql);
                    while (rs.next()) {
                        HeroResponse e = new HeroResponse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), new ImageView(new Image(this.getClass().getResourceAsStream(rs.getString(7)))));

                        listHeroesResponse.add(e);

                    }
                    listData.addAll(listHeroesResponse);
                    tbHeroes.setItems(listData);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "exception: " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se a completado el criterio de busqueda!");
            }
        }
    }

    
}

