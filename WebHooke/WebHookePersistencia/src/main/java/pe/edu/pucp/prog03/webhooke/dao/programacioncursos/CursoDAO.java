/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.dao.programacioncursos;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
import pe.edu.pucp.prog03.webhooke.dao.ICrud;

/**
 *
 * @author ASUS
 */
public interface CursoDAO extends ICrud<Curso>{
    List<Curso> buscarCursoPorNivel(int nivel);
}
