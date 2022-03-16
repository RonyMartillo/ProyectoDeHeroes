package models;

public class Personajes {
    private String nombre;
    private String imgsrc;
    

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Personajes(String nombre) {
        this.nombre = nombre;
    }
    
    public Personajes(String nombre, String imgsrc) {
        this.nombre = nombre;
        this.imgsrc = imgsrc;
    }

    public Personajes( ) {
       ;
    }
    
}
