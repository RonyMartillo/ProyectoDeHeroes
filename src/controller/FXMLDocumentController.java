
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.Conexion;

/**
 *
 * @author Shokuhou
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;


    @FXML
    private Label lblStatus;

    Conexion con = new Conexion();
    @FXML
    private VBox containerLeft;
    @FXML
    private VBox containerRight;

    @FXML
    private void eventKey(KeyEvent event) {
    }
    

    @FXML
    private void eventAction(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == btnLogin) {

            String sql = "SELECT * FROM usuarios WHERE usuario = '" + txtUser.getText() + "' AND pass = '" + txtPassword.getText() + "'";
            String nombre = "";
            String pass = "";
            Parent root;

            try {
                System.out.println(sql);
                ResultSet rs = con.ejecutarSQLSelect(sql);
                while (rs.next()) {
                    nombre = rs.getString(3);
                    pass = rs.getString(4);
                }

                if (!nombre.equals("") && !pass.equals("")) {

                    Stage stage = (Stage) this.btnLogin.getScene().getWindow();
                    stage.close();

                    if (nombre.equals("admin")) {
                        root = FXMLLoader.load(getClass().getResource("/loginheroess/ViewSelector.fxml"));
                    } else {
                        root = FXMLLoader.load(getClass().getResource("/loginheroess/ViewUser.fxml"));
                    }

                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    lblStatus.setText("Contraseña Correcta");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "exception: " + ex);
            }

        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

    @FXML
    private void onRegister(MouseEvent event) {
        //iniziliar la siguiente pantalla registro
        
    }
}
