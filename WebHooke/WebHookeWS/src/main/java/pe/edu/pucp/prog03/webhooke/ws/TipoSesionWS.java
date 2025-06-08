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
import pe.edu.pucp.prog03.webhooke.bo.ITipoSesionBO;
import pe.edu.pucp.prog03.webhooke.boimpl.TipoSesionBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "TipoSesionWS", targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class TipoSesionWS {

    /**
     * This is a sample web service operation
     */
    private final ITipoSesionBO tipoSesionBO;
    
    public TipoSesionWS (){
        tipoSesionBO = new TipoSesionBOImpl();
    }
    
    @WebMethod(operationName = "guardarTipoSesion")
    public void guardarTipoSesion(@WebParam(name = "tipoSesion") TipoSesion tipoSesion, @WebParam(name = "estado") Estado estado) {
        this.tipoSesionBO.guardar(tipoSesion, estado);
    }
    
    @WebMethod(operationName = "obtenerTipoSesion")
    public TipoSesion obtenerTipoSesion(@WebParam(name = "id") int id) {
        return this.tipoSesionBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarTipoSesion")
    public void eliminarTipoSesion (@WebParam(name = "id") int id) {
        this.tipoSesionBO.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarTipoSesiones")
    public List<TipoSesion> listarTipoSesiones () {
        return this.tipoSesionBO.listar();
    }
}
