/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.Date;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.IAlumnoBO;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.AlumnoDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.AlumnoDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;

/**
 *
 * @author ASUS
 */
public class AlumnoBOImpl implements IAlumnoBO{
    private AlumnoDAO alumnoDAO;
    
    
    public AlumnoBOImpl(){
        alumnoDAO = new AlumnoDAOImplement();
    }
  /*  
    public int registrarAlumno(String nombre,String apellido,String DNI,String Email,Date fechaNacimiento,String carrera){
        Alumno alumno = new Alumno();
        
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDNI(DNI);
        alumno.setEmail(Email);
        alumno.setFechaNacimiento((java.sql.Date) fechaNacimiento);
        alumno.setCarrera(carrera);
        
        return alumnoDAO.insertar(alumno);
    }
*/
    @Override
    public List<Alumno> listar() {
        return this.alumnoDAO.listar();
    }

    @Override
    public Alumno obtener(int id) {
        return this.alumnoDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.alumnoDAO.eliminar(id);
    }

    @Override
    public void guardar(Alumno modelo, Estado estado) {
        if (estado == Estado.Nuevo){
            this.alumnoDAO.insertar(modelo);
        }
        else{
            this.alumnoDAO.modificar(modelo);
        }
    }
}


