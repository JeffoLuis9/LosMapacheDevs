/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.programacioncursos.model;

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
	
	public Curso(){
		
	}
	
	public Curso(String codigo,String nombre, int numeroCiclo){
		this.codigo=codigo;
		this.nombre=nombre;
		this.nivel=numeroCiclo;
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
}
