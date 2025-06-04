/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.ws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.ICursoBO;
import pe.edu.pucp.prog03.webhooke.boimpl.CursoBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;



/**
 *
 * @author ASUS
 */
@WebService(
        serviceName = "CursoWS",
        targetNamespace = "http://services.webhooke.pucp.edu.pe/")

public class CursoWS {

    /**
     * This is a sample web service operation
     */
    
    private final ICursoBO cursoBO;
    
    public CursoWS(){
        cursoBO = new CursoBOImpl();
    }
    
    @WebMethod(operationName = "guardarCurso")
    public void guardarCurso (
            @WebParam(name  = "curso") Curso curso,
            @WebParam(name = "estado") Estado estado
    )
    {
        this.cursoBO.guardar(curso, estado);
    }
    
    @WebMethod(operationName = "obtenerCurso")
    public Curso obtenerCurso (
            @WebParam(name  = "id") int id
    )
    {
        return this.cursoBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarCurso")
    public void eliminarCurso (
            @WebParam(name  = "id") int id
    )
    {
        this.cursoBO.eliminar(id);
    }
    
    @WebMethod(operationName = "listarCursos")
    public List<Curso> listarCursos (){
    
        return this.cursoBO.listar();
    }
    
    @WebMethod(operationName = "listarCursosPorNivel")
    public List<Curso> listarCursosPorNivel ( @WebParam(name  = "nivel") int nivel ){
        return this.cursoBO.listarCursosPorNivel(nivel);
    }
    
}
