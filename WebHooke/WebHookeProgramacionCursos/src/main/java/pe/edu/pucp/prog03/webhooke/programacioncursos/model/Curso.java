/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.programacioncursos.model;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
/**
 *
 * @author ASUS
 */
/*
import java.util.ArrayList;
import java.util.List;
*/
public class Curso{


    private int id;
    private String codigo;
    private String nombre;
    private int nivel;
    private Profesor profesor;
    public Curso(){

    }

    public Curso(String codigo,String nombre, int numeroCiclo,Profesor profesor){
            this.codigo=codigo;
            this.nombre=nombre;
            this.nivel=numeroCiclo;
            this.profesor.setId(profesor.getId());
            this.profesor.setDNI(profesor.getDNI());
            this.profesor.setNombre(profesor.getNombre());
            this.profesor.setApellido(profesor.getApellido());
            this.profesor.setEmail(profesor.getEmail());
            this.profesor.setFechaNacimiento(profesor.getFechaNacimiento());
    }
	
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
	
	public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int numeroCiclo) {
        this.nivel = numeroCiclo;
    }
	
    public void ImprimirDatosCurso(){
            System.out.println(codigo+"			"+nombre+"				"+nivel);	
    }
    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
