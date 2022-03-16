/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import models.Personajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Shokuhou
 */
public class FiltroController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private Button btnBuscar;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ScrollPane scrollpane;
        
    /**
     * Initializes the controller class.
     */
    
    private void actCerrar(ActionEvent event) {
         System.exit(0);
    }


    @FXML
    private GridPane gridpane;

    private Image image;

    private List<Personajes> personajes = new ArrayList<>();


    private List<Personajes> getdata() {
        List<Personajes> personajes = new ArrayList<>();
        Personajes personaje;
     
            personaje = new Personajes();
            personaje.setNombre("nightwing");
            personaje.setImgsrc("/imagenheroes/nightwing.jpg");
            personajes.add(personaje);

            personaje = new Personajes();
            personaje.setNombre("spiderman");
            personaje.setImgsrc("/imagenheroes/spiderman.jpg");
            personajes.add(personaje);

            personaje = new Personajes();
            personaje.setNombre("superman");
            personaje.setImgsrc("/imagenheroes/superman.jpg");
            personajes.add(personaje);
            
            personaje = new Personajes();
            personaje.setNombre("flash");
            personaje.setImgsrc("/imagenheroes/flash.jpg");
            personajes.add(personaje);
            
            personaje = new Personajes();
            personaje.setNombre("thor");
            personaje.setImgsrc("/imagenheroes/thor.jpg");
            personajes.add(personaje);
 
            personaje = new Personajes();
            personaje.setNombre("wonderwoman");
            personaje.setImgsrc("/imagenheroes/wonder_woman.jpg");
            personajes.add(personaje);

	    personaje = new Personajes();
            personaje.setNombre("flecha verde");
            personaje.setImgsrc("/imagenheroes/flecha_verde.jpg");
            personajes.add(personaje);
											
	    personaje = new Personajes();
            personaje.setNombre("hulk");
            personaje.setImgsrc("/imagenheroes/hulk.jpg");
            personajes.add(personaje);
		
	    personaje = new Personajes();
            personaje.setNombre("ironman");
            personaje.setImgsrc("/imagenheroes/ironman.jpg");
            personajes.add(personaje);
									
	    personaje = new Personajes();
            personaje.setNombre("linterna verde");
            personaje.setImgsrc("/imagenheroes/linterna-verde.jpg");
            personajes.add(personaje);
			
	    personaje = new Personajes();
            personaje.setNombre("wolverine");
            personaje.setImgsrc("/imagenheroes/wolverine.jpg");
            personajes.add(personaje);
			
	    personaje = new Personajes();
            personaje.setNombre("martian manhunter");
            personaje.setImgsrc("/imagenheroes/martian_manhunter.jpg");
            personajes.add(personaje);
				                     
            personaje = new Personajes();
            personaje.setNombre("batman");
            personaje.setImgsrc("/imagenheroes/batman.jpg");
            personajes.add(personaje);
          
            personaje = new Personajes();
            personaje.setNombre("black canary");
            personaje.setImgsrc("/imagenheroes/black_canary.jpg");
            personajes.add(personaje);

            personaje = new Personajes();
            personaje.setNombre("blue beetle");
            personaje.setImgsrc("/imagenheroes/blue_beetle.jpg");
            personajes.add(personaje);

            personaje = new Personajes();
            personaje.setNombre("capitan america");
            personaje.setImgsrc("/imagenheroes/capitan_america.jpg");
            personajes.add(personaje);
           
            personaje = new Personajes();
            personaje.setNombre("ciclope");
            personaje.setImgsrc("/imagenheroes/ciclope.jpg");
            personajes.add(personaje);
                       
            personaje = new Personajes();
            personaje.setNombre("daredevil");
            personaje.setImgsrc("/imagenheroes/daredevil.jpg");
            personajes.add(personaje);
            
            personaje = new Personajes();
            personaje.setNombre("hawkeye");
            personaje.setImgsrc("/imagenheroes/hawkeye.jpg");
            personajes.add(personaje);
                       
            personaje = new Personajes();
            personaje.setNombre("silver");
            personaje.setImgsrc("/imagenheroes/silver.jpg");
            personajes.add(personaje);
            
                       
            return personajes;
    }
    

    @FXML
    private void actBuscar(ActionEvent event) {
    }
    
     private void elegirPersonaje(Personajes personaje){
        image = new Image(getClass().getResourceAsStream(personaje.getImgsrc()));
    }

    private void imagenes(String filter) {
        int  columna=0;
        int  fila=1;     
        try {   
            gridpane.getChildren().clear();
            for (int i = 0; i < personajes.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/loginheroess/frmItems.fxml"));
    
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();

                if (personajes.get(i).getNombre().contains(filter)) {
                    itemController.setData(personajes.get(i));
                    if (i>0) {
                        columna++;
                    }
                } else {
                    if (filter.isEmpty
                    ()) {
                        itemController.setData(personajes.get(i));
                        if (i>0) {
                            columna++;
                        }
                    }
                }   

                if (columna==4){
                    columna=0;
                    fila++;
                }
               
                gridpane.add(anchorPane,columna,fila);
                GridPane.setMargin(anchorPane, new Insets(10));
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        txtUser.textProperty().addListener((observable, oldtxt, newtext)->{
            imagenes(newtext);
         });
         
        personajes.addAll(getdata());

       /*  if(personajes.size()>0){
            elegirPersonaje(personajes.get(0));
        } */

        imagenes("");

    }

}


    

