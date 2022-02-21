
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author JESUS
 * CLASE HERO RESPONSE ES UN CLASE HECHA PARA LA CONSULTA CON LA IMAGEN EN PRESENTACION SE PUEDE UTILIZAR 
 * TANTO ESTA COMO LA OTRA CLASE LA CREACION DE LAS DOS CLASES FUE CON EL FIN DE DEMOSTRAR QUE SE PUED PERESENTAR
 * COMO RUTA LA IMAGEN O COMO EL MISMO COMPONENTE QUE UN IMAGENVIEW
 */
public class HeroResponse {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty alia;
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty enemigo;
    private final SimpleStringProperty universo;
    private ImageView urlImg;

    public HeroResponse(Integer id, String nombre, String alia, String fecha, String enemigo, String universo, ImageView urlImg) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.alia = new SimpleStringProperty(alia);
        this.fecha = new SimpleStringProperty(fecha);
        this.enemigo = new SimpleStringProperty(enemigo);
        this.universo = new SimpleStringProperty(universo);
        this.urlImg = urlImg;
        this.urlImg.setFitHeight(100);
        this.urlImg.setFitWidth(100);
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

    public ImageView getUrlImg() {
        return urlImg;
    }

    @Override
    public String toString() {
        return "Heroe{" + "id=" + id + ", nombre=" + nombre + ", alia=" + alia + ", fecha=" + fecha + ", enemigo=" + enemigo + ", universo=" + universo + '}';
    }

}
