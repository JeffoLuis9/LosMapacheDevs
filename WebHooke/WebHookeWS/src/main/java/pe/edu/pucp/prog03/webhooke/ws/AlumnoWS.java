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
import pe.edu.pucp.prog03.webhooke.bo.IAlumnoBO;
import pe.edu.pucp.prog03.webhooke.boimpl.AlumnoBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "AlumnoWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class AlumnoWS {

    /**
     * This is a sample web service operation
     */
    
    private final IAlumnoBO alumnoBO;
    
    public AlumnoWS(){
        alumnoBO = new AlumnoBOImpl();
    }
    
    @WebMethod(operationName = "guardarAlumno")
    public void guardarAlumno(@WebParam(name = "alumno") Alumno alumno, @WebParam(name = "estado") Estado estado) {
        this.alumnoBO.guardar(alumno, estado);
    }
    
    @WebMethod(operationName = "obtenerAlumno")
    public Alumno obtenerAlumno(@WebParam(name = "id") int id) {
        return this.alumnoBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarAlumno")
    public void eliminarAlumno (@WebParam(name = "id") int id) {
        this.alumnoBO.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarAlumnos")
    public List<Alumno> listarAlumnos () {
        return this.alumnoBO.listar();
    }
    
}
