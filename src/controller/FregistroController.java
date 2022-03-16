/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import util.Conexion;


/**
 * FXML Controller class
 *
 * @author Shokuhou
 */

public class FregistroController implements Initializable {
   Conexion con = new Conexion();
    
    @FXML
    private Button regist;
    @FXML
    private TextField txtcorreo;
    @FXML
    private TextField txtusuario;
    @FXML
    private PasswordField txtcontraa;
    @FXML
    private PasswordField txtconfcontra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regid(ActionEvent event) {
             //METODO PARA GUARDAR LA INFORMACION A LA BD

        try {
            //DEFINICION DE SENTENCIA SQL CON PARAMETROS
            String sql = "INSERT INTO public.usuarios(correo, usuario, pass, confcontra) VALUES (?, ?, ?, ?)";
            //EJCUCION DE SENTENCIA
            PreparedStatement ps = con.getConexion().prepareStatement(sql);
            // PARAMETROS ASIGNADOS 
            ps.setString(1, txtcorreo.getText());
            ps.setString(2, txtusuario.getText());
            ps.setString(3, txtcontraa.getText());
            ps.setString(4, txtconfcontra.getText());      

            ps.execute();
            ps.close();
            //AGREGAMIENTO DEL OBJETO GUARDADO EN EL TABLEVIEW
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException | NumberFormatException | HeadlessException x) {
            JOptionPane.showMessageDialog(null, "exception 2 " + x);
        }
        
    } 
    
    
  }