/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Shokuhou
 */
public class registro {
    private static String id;
    private static String correo;
    private static String usuario;
    private static String pass;
    private static String confcontra;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        registro.id = id;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        registro.correo = correo;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        registro.usuario = usuario;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        registro.pass = pass;
    }

    public static String getConfcontra() {
        return confcontra;
    }

    public static void setConfcontra(String confcontra) {
        registro.confcontra = confcontra;
    }

    
}
