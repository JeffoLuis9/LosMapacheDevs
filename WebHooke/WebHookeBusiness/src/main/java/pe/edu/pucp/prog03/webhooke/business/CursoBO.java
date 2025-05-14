/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.business;

import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.programacioncursos.mysql.CursoDAOImplement;

/**
 *
 * @author ASUS
 */
public class CursoBO {
    private CursoDAO cursoDAO;
    
    public CursoBO(){
        cursoDAO= new CursoDAOImplement();
    }
    
    public int registrarCurso( String codigo,String nombre,int nivel,Profesor profesor){
        Curso curso = new Curso();
        
        curso.setCodigo(codigo);
        curso.setNombre(nombre);
        curso.setNivel(nivel);
        curso.setProfesor(profesor);
        
        return cursoDAO.insertar(curso);
    }
}
