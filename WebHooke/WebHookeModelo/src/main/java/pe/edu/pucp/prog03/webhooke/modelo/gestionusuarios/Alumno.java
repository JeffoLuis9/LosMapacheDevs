/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios;

/**
 *
 * @author ASUS
 */


public class Alumno extends Usuario{
    private String carrera;

    
    public Alumno (){
        this.setTipoUsuario('E');
    }
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}

