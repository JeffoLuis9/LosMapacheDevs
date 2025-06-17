/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.bo;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;

/**
 *
 * @author ASUS
 */
public interface ISesionBO  extends IBaseBO<Sesion>{
    List<Alumno>buscaralumnoporsesion();
    List<Sesion>buscarSesionesxalumno(int id);
}
