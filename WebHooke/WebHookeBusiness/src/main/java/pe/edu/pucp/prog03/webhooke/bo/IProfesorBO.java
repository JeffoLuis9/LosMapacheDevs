/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.bo;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;

/**
 *
 * @author ASUS
 */
public interface IProfesorBO  extends IBaseBO<Profesor>{
    List<Profesor> buscarProfesorPorCurso(int idCurso) ;
}
