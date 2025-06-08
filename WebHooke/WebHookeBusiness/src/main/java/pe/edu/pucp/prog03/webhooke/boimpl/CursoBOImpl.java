/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.ICursoBO;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;



/**
 *
 * @author ASUS
 */
public class CursoBOImpl implements ICursoBO{
    private CursoDAO cursoDAO;
    
    public CursoBOImpl(){
        cursoDAO= new CursoDAOImplement();
    }
//    
//    public int registrarCurso( String codigo,String nombre,int nivel,Profesor profesor){
//        Curso curso = new Curso();
//        
//        curso.setCodigo(codigo);
//        curso.setNombre(nombre);
//        curso.setNivel(nivel);
//        curso.setProfesor(profesor);
//        
//        return cursoDAO.insertar(curso);
//    }

    @Override
    public List<Curso> listar() {
        return this.cursoDAO.listar();
    }
    
    @Override
    public List<Curso> listarCursosPorNivel(int nivel) {
        return this.cursoDAO.buscarCursoPorNivel(nivel);
    }

    @Override
    public Curso obtener(int id) {
        return this.cursoDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.cursoDAO.eliminar(id);
    }

    @Override
    public void guardar(Curso modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.cursoDAO.insertar(modelo);
        }
        else{
            this.cursoDAO.modificar(modelo);
        }
    }
    
}
