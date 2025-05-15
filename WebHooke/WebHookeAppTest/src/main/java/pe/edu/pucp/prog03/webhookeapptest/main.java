package pe.edu.pucp.prog03.webhookeapptest;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;
import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.AcademiaDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.AcademiaDAOImplement;

import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.mysql.CursoDAOImplement;

import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Usuario;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.UsuarioDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.UsuarioDAOImplement;

import java.sql.Date;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;
import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.SedeDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.SedeDAOImplement;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.ProfesorDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;

import pe.edu.pucp.prog03.webhooke.business.AlumnoBO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Alumno;
import pe.edu.pucp.prog03.webhooke.business.CursoBO;
import pe.edu.pucp.prog03.webhooke.business.SesionBO;
import pe.edu.pucp.prog03.webhooke.modalidades.dao.TipoSesionDAO;
import pe.edu.pucp.prog03.webhooke.modalidades.mysql.TipoSesionDAOImplement;
/**
 * Hello world!
 */
public class main {
    public static void main(String[] args) {
    //prueba de registrar Alumno
    AlumnoBO alumnoBO = new AlumnoBO();
    
    int idAlumno = alumnoBO.registrarAlumno("Jefferson", "Robles", "123456","correo@prueba.com",Date.valueOf("2020-04-23") , "Ingenieria Informatica");
    System.out.println("El id del alumno ingresado es : "+ idAlumno);
    
    //prueba de registrar Curso
    Profesor profesor = new Profesor();
    profesor.setId(1);
    profesor.setNombre("Alejandro");
    profesor.setApellido("Barrantes");
    profesor.setDNI("1234");
    profesor.setEmail("QWERTy@correo.com");
    profesor.setFechaNacimiento(Date.valueOf("1995-04-23"));    
    
    CursoBO cursoBO = new CursoBO();
    int idCurso = cursoBO.registrarCurso("1INF30","CURSO", 7,profesor );
    System.out.println("El id del curso ingresado es : "+ idAlumno);
    
    /*Registro de sesion*/
    CursoDAO cursoDao = new CursoDAOImplement();
    Curso curso = cursoDao.buscar(idCurso);

//    Curso curso = new Curso();
//    curso.setCodigo("1INF30");
//    curso.setNombre("Programacion 3");
//    curso.setNivel(7);
//    curso.setProfesor(profesor); 
    
    
    
    Alumno alumno = new Alumno();
    alumno.setId(1);
    alumno.setNombre("Renato");
    alumno.setApellido("Tapia");
    alumno.setDNI("123456789");
    alumno.setEmail("alumno2@correo.com");
    alumno.setFechaNacimiento(Date.valueOf("2008-04-23"));  
    
    TipoSesion tipoSesion = new TipoSesion();
    tipoSesion.setIdModalidad(1);
    tipoSesion.setPrecio(250);
    tipoSesion.setTipo("Grupal");
    
    TipoSesionDAO tipoSesionDAO = new TipoSesionDAOImplement();
    int idTipoSesion = tipoSesionDAO.insertar(tipoSesion);

//    Academia academia = new Academia();
//    academia.setNombre("AcademiaHooke");
//    academia.setRUC("12345678");
//    academia.setId(1);
    
    
    
    SedeDAO sedeDao = new SedeDAOImplement();
    Sede sede = sedeDao.buscar(2);
    SesionBO sesionBO = new SesionBO();
        System.out.println("id de la sede: "+ sede.getId());
        
    int idSesion = sesionBO.registrarSesion(7, 10, Date.valueOf("2025-05-15"), "Virtual",curso, alumno, tipoSesion, sede);
    System.out.println("El id de la sesion ingresada es : "+ idSesion);      
    
  }

}
