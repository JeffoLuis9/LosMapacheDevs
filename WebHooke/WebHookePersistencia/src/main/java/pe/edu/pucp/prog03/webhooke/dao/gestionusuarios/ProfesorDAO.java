/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.dao.gestionusuarios;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
import pe.edu.pucp.prog03.webhooke.dao.ICrud;
/**
 *
 * @author andre
 */
public interface ProfesorDAO extends ICrud<Profesor>{
    
    List<Profesor> buscarProfesorPorCurso(int idCurso);
}

