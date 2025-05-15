/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.business;

import java.util.Date;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.AlumnoDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Alumno;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.AlumnoDAOImplement;

/**
 *
 * @author ASUS
 */
public class AlumnoBO {
    /*vamos a probar los cambios a ver que tal*/
    private AlumnoDAO alumnoDAO;
    
    public AlumnoBO(){
        alumnoDAO = new AlumnoDAOImplement();
    }
    
    public int registrarAlumno(String nombre,String apellido,String DNI,String Email,Date fechaNacimiento,String carrera){
        Alumno alumno = new Alumno();
        Alumno alumno2 = new Alumno();
        
        alumno2.setNombre(nombre);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDNI(DNI);
        alumno.setFechaNacimiento((java.sql.Date) fechaNacimiento);
        alumno.setCarrera(carrera);
        alumno.setEmail(Email);
        
        
        return alumnoDAO.insertar(alumno);
    }
}
