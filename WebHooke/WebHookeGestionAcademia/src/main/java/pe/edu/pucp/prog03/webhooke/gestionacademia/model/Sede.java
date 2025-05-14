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


public class Sede {
    
    private int id;
    private String direccion;
    private String distrito;
//    private ArrayList<Usuario> usuarios;
//    private ArrayList<Curso> cursos;
    private Academia academia;

    public Sede() {
        
    }

    public Sede(int id,String direccion, String distrito, Academia academia) {
        
        this.direccion = distrito;
        this.direccion = direccion;
        this.id=id;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

////	public void IngresaUsuario(String nombre,String apellido,String DNI, Date fechaNacimiento){
////		Usuario usuario=new Usuario(nombre,apellido,DNI,fechaNacimiento);
////		usuarios.add(usuario);
////	}
//    public void IngresarCurso(String codigo, String nombre, int numeroCiclo,int id) {
//        Curso curso = new Curso(codigo, nombre, numeroCiclo, id);
//        curso.add(curso);
//    }

    /*
	public void IngresarCurso(Curso curso){
		cursos.add(curso);
	}

	public void IngresarUsuario(Usuario usuario){
		usuarios.add(usuario);
	}

	public void IngresarHorario(Horario horario){
		horarios.add(horario);
	}*/

////	public void IngresarHorario(int idHorario,int horadeInicio,int horaFin){
////		Horario horario=new Horario(idHorario,horadeInicio,horaFin);
////		horarios.add(horario);
////	}
    public void ImprimirDatosSede() {
        System.out.println("Direccion: " + direccion);
        System.out.println("Distrito: " + distrito);
//        System.out.println("Usuarios Registrados: ");
//        System.out.println("Nombre			DNI			Email				Fecha de Nacimiento");
//        for (Usuario usuario : usuarios) {
//            usuario.ImprimirDatosUsuario();
//        }
//        System.out.println("Cursos Dictados: ");
//        System.out.println("Codigo del curso	Nombre				Nro Ciclo");
//        for (Curso curso : cursos) {
//            curso.ImprimirDatosCurso();
//        }
//        System.out.println("Horarios: ");
//        System.out.println("ID		Hora de Inicio		Hora Fin");
//        for (Horario horario : horarios) {
//            horario.ImprimirDatosHorario();
//        }
    }
}
