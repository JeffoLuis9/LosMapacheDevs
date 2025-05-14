/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionacademia.model;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.List;

public class Academia {

    private int id;
    private String nombre;
    private String ruc;
    

    public Academia() {
        
    }

    public Academia(String nombre, String ruc, int id) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRUC() {
        return ruc;
    }

    public void setRUC(String ruc) {
        this.ruc = ruc;
    }
}
