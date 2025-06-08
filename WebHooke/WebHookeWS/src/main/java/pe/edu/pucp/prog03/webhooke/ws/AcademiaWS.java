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
import pe.edu.pucp.prog03.webhooke.bo.IAcademiaBO;
import pe.edu.pucp.prog03.webhooke.boimpl.AcademiaBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Academia;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "AcademiaWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class AcademiaWS {

    /**
     * This is a sample web service operation
     */
    private final IAcademiaBO academiaBo;
    
    public AcademiaWS(){
        academiaBo = new AcademiaBOImpl();
    }
    
    @WebMethod(operationName = "guardarAcademia")
    public void guardarAcademia(@WebParam(name = "academia") Academia academia, @WebParam(name = "estado") Estado estado) {
        this.academiaBo.guardar(academia, estado);
    }
    
    @WebMethod(operationName = "obtenerAcademia")
    public Academia obtenerAcademia(@WebParam(name = "id") int id) {
        return this.academiaBo.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarAcademia")
    public void eliminarAcademia (@WebParam(name = "id") int id) {
        this.academiaBo.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarAcademias")
    public List<Academia> listarAcademias () {
        return this.academiaBo.listar();
    }
}
