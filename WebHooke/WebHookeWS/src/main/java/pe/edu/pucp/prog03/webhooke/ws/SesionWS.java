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
import pe.edu.pucp.prog03.webhooke.bo.ISesionBO;
import pe.edu.pucp.prog03.webhooke.boimpl.SesionBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "SesionWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class SesionWS {
    
    private final ISesionBO sesionBO;
    
    public SesionWS(){
        sesionBO = new SesionBOImpl();
    }
//    
    @WebMethod(operationName = "guardarSesion")
    public void guardarSesion(@WebParam(name = "sesion") Sesion sesion, @WebParam(name = "estado") Estado estado) {
        this.sesionBO.guardar(sesion, estado);
    }
    
//    @WebMethod(operationName = "guardarSesionVersion2")
//    public void guardarSesionVersion2(@WebParam(name = "sesion") Sesion sesion, @WebParam(name = "estado") Estado estado) {
//        
//    }
    
    
    @WebMethod(operationName = "obtenerSesion")
    public Sesion obtenerSesion(@WebParam(name = "id") int id) {
        return this.sesionBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarSesion")
    public void eliminarSesion (@WebParam(name = "id") int id) {
        this.sesionBO.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarSesiones")
    public List<Sesion> listarSesiones () {
        return this.sesionBO.listar();
    }
    
    @WebMethod(operationName = "listarAlumnosporSesiones")
    public List<Alumno> listarAlumnosporSesiones () {
        return this.sesionBO.buscaralumnoporsesion();
    }
    
    //prueba
    //boca
    @WebMethod(operationName = "listarSesionesporAlumnos")
    public List<Sesion> listarSesionesporAlumnos (@WebParam(name = "id") int id) {
        
        return this.sesionBO.buscarSesionesxalumno(id);
    }
    
    
    
}
