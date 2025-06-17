/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.dao.programacioncursos;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
import pe.edu.pucp.prog03.webhooke.dao.ICrud;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
/**
 *
 * @author ASUS
 */
public interface SesionDAO extends ICrud<Sesion>{
    List<Integer>buscaralumnosede();
    List<Integer>buscarsesionesxalumno(int idAlumno);    
}
