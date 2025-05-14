/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionusuarios.model;


import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author andre
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String DNI;
    private String email;
    private Date fechaNacimiento;

    
    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String DNI, String email,
            Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;

    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void ImprimirDatosUsuario() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(apellido + "," + nombre + "		" + DNI + "			" + email + "		" + format);
    }

}
