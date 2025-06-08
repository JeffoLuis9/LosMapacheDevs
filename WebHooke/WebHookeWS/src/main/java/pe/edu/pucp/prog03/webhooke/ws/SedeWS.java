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
import pe.edu.pucp.prog03.webhooke.bo.ISedeBO;
import pe.edu.pucp.prog03.webhooke.boimpl.SedeBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "SedeWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class SedeWS {

    /**
     * This is a sample web service operation
     */
    private final ISedeBO sedeBO;
    
    public SedeWS(){
        sedeBO = new SedeBOImpl();
    }
    
    @WebMethod(operationName = "guardarSede")
    public void guardarSede(@WebParam(name = "sede") Sede sede, @WebParam(name = "estado") Estado estado) {
        this.sedeBO.guardar(sede, estado);
    }
    
    @WebMethod(operationName = "obtenerSede")
    public Sede obtenerSede(@WebParam(name = "id") int id) {
        return this.sedeBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarSede")
    public void eliminarSede (@WebParam(name = "id") int id) {
        this.sedeBO.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarSedes")
    public List<Sede> listarSedes () {
        return this.sedeBO.listar();
    }
}
