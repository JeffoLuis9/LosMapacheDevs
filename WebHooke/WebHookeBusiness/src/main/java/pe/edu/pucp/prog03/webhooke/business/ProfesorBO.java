/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.business;

import java.sql.Date;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.ProfesorDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
//import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.ProfesorDAO;
//import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
//import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.ProfesorDAOImplement;

/**
 *
 * @author ASUS
 */
public class ProfesorBO {
    private ProfesorDAO profesorDAO;
    
    public ProfesorBO(){
        profesorDAO = new ProfesorDAOImplement();
    }
    
    public int registrarProfesor(String nombre, String apellido, String dni, String email, Date fechaNacimiento){
        Profesor profesor= new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setDNI(dni);
        profesor.setEmail(email);
        profesor.setFechaNacimiento(fechaNacimiento);
        
        return profesorDAO.insertar(profesor);
    }
    
    public Profesor buscarProfesor(int id){
        Profesor profesor= profesorDAO.buscar(id);
        return profesor;
    }
    
    public boolean actualizarProfesor(Profesor profesor){
         return profesorDAO.modificar(profesor);
    }
}
