/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.ws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.prog03.webhooke.bo.IUsuarioBO;
import pe.edu.pucp.prog03.webhooke.boimpl.UsuarioBOImpl;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "UsuarioWS",targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class UsuarioWS {
    private IUsuarioBO usuarioBo;
    
    public UsuarioWS(){
        usuarioBo = new UsuarioBOImpl();
    }
    
    @WebMethod(operationName = "verificarCorreo")
    public int verificarCorreo(@WebParam(name = "correo") String correo) {
        return this.usuarioBo.buscarCorreoPorUsuario(correo);
    }
}
