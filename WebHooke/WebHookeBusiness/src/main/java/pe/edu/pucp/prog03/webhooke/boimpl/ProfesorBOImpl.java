/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.sql.Date;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.IProfesorBO;
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
public class ProfesorBOImpl implements IProfesorBO{
    private ProfesorDAO profesorDAO;
    
    public ProfesorBOImpl(){
        profesorDAO = new ProfesorDAOImplement();
    }
    
//    public int registrarProfesor(String nombre, String apellido, String dni, String email, Date fechaNacimiento){
//        Profesor profesor= new Profesor();
//        profesor.setNombre(nombre);
//        profesor.setApellido(apellido);
//        profesor.setDNI(dni);
//        profesor.setEmail(email);
//        profesor.setFechaNacimiento(fechaNacimiento);
//        
//        return profesorDAO.insertar(profesor);
//    }
//    
//    public Profesor buscarProfesor(int id){
//        Profesor profesor= profesorDAO.buscar(id);
//        return profesor;
//    }
//    
//    public boolean actualizarProfesor(Profesor profesor){
//         return profesorDAO.modificar(profesor);
//    }

    @Override
    public List<Profesor> listar() {
        return this.profesorDAO.listar();
    }

    @Override
    public Profesor obtener(int id) {
        return this.profesorDAO.buscar(id);
    }

    @Override
    public List<Profesor> buscarProfesorPorCurso(int idCurso) {
        return this.profesorDAO.buscarProfesorPorCurso(idCurso);
    }
    
    @Override
    public void eliminar(int id) {
        this.profesorDAO.eliminar(id);
    }

    @Override
    public void guardar(Profesor modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.profesorDAO.insertar(modelo);
        }
        else{
            this.profesorDAO.modificar(modelo);
        }
    }
}
