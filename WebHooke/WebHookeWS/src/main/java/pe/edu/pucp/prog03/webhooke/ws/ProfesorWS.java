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
import pe.edu.pucp.prog03.webhooke.bo.IProfesorBO;
import pe.edu.pucp.prog03.webhooke.boimpl.ProfesorBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "ProfesorWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class ProfesorWS {

    /**
     * This is a sample web service operation
     */
    private final IProfesorBO profesorBO;
    
    public ProfesorWS(){
        profesorBO = new ProfesorBOImpl();
    }
    
    @WebMethod(operationName = "guardarProfesor")
    public void guardarProfesor(@WebParam(name = "profesor") Profesor profesor, @WebParam(name = "estado") Estado estado) {
        this.profesorBO.guardar(profesor, estado);
    }
    
    @WebMethod(operationName = "obtenerProfesor")
    public Profesor obtenerProfesor(@WebParam(name = "id") int id) {
        return this.profesorBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarProfesor")
    public void eliminarProfesor (@WebParam(name = "id") int id) {
        this.profesorBO.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarProfesores")
    public List<Profesor> listarProfesores () {
        return this.profesorBO.listar();
    }
    
    @WebMethod(operationName = "listarProfesoresPorCurso")
    public List<Profesor> listarProfesoresPorCurso (@WebParam (name = "idCurso")int idCurso ){
        return this.profesorBO.buscarProfesorPorCurso(idCurso);
    }
}
