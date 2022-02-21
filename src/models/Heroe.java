package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author JESUS
 */
public class Heroe {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty alia;
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty enemigo;
    private final SimpleStringProperty universo;
    private final SimpleStringProperty urlImg;

    public Heroe(Integer id, String nombre, String alia, String fecha, String enemigo, String universo, String urlImg) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.alia = new SimpleStringProperty(alia);
        this.fecha = new SimpleStringProperty(fecha);
        this.enemigo = new SimpleStringProperty(enemigo);
        this.universo = new SimpleStringProperty(universo);
        this.urlImg = new SimpleStringProperty(urlImg);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getAlia() {
        return alia.get();
    }

    public String getFecha() {
        return fecha.get();
    }

    public String getEnemigo() {
        return enemigo.get();
    }

    public String getUniverso() {
        return universo.get();
    }

    public String getUrlImg() {
        return urlImg.get();
    }

    @Override
    public String toString() {
        return "Heroe{" + "id=" + id + ", nombre=" + nombre + ", alia=" + alia + ", fecha=" + fecha + ", enemigo=" + enemigo + ", universo=" + universo + ", urlImg=" + urlImg + '}';
    }

}
