package controller;

import java.io.IOException;

import models.Personajes;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {

    @FXML
    private ImageView img;

    private Personajes personaje;

    @FXML
    private void click(MouseEvent event) throws IOException {
        //MainVista mv = new MainVista();
        //mv.checkLogin("/Vista/frmEditor.fxml");

    }

    public void setData(Personajes personaje){
        Image image = new Image (getClass().getResourceAsStream(personaje.getImgsrc()));
        img.setImage(image); 

    }

}
