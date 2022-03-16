
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

    

   
   Conexion con = new Conexion();
    ObservableList<String> list = FXCollections.observableArrayList(Utils.ListUniversos);

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicio de la lista estatica de universos disponible para los heroes
        comboBox.setItems(list);
    }

    @FXML
    private void handleButton(ActionEvent event) {
        //VERIFICACION DE QUE EL LLAMAMIENTO DEL EVENTO SEA EL DE BUSCAR
        if (event.getSource() == btnBuscar) {
            //VERIFICACION DE QUE NO ESTEN VACIO NINGUN ELEMENTO EN EL FORMULARIO
            if (!txtBusqueda.getText().isEmpty() && comboBox.getValue() != null) {
                //DIFINICION DEL SQL
                String sql = "SELECT* FROM heroes WHERE alia = '" + txtBusqueda.getText().trim().toLowerCase() + "' AND universo = '" + comboBox.getValue() + "'";
                System.out.println(sql);
                try {
                    //ejecucuion del sql
                    ResultSet rs = con.ejecutarSQLSelect(sql);
                    while (rs.next()) {
                        //asignacion del objeto que devuelve
                        lblNombre.setText(rs.getString(2));
                        lblAlia.setText(rs.getString(3));
                        lblFecha.setText(rs.getString(4));
                        lblEnemigo.setText(rs.getString(5));
                        ImgView.setImage(new Image(getClass().getResourceAsStream(rs.getString(7))));

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "exception: " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se a completado el criterio de busqueda!");
            }
        }

    }
}
