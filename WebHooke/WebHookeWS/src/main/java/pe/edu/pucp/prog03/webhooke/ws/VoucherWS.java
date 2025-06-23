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
import pe.edu.pucp.prog03.webhooke.bo.IVoucherBO;
import pe.edu.pucp.prog03.webhooke.boimpl.VoucherBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;


/**
 *
 * @author ASUS
 */
@WebService(serviceName = "VoucherWS",targetNamespace = "http://services.webhooke.pucp.edu.pe/")
public class VoucherWS {

    /**
     * This is a sample web service operation
     */
    private final IVoucherBO voucherBo;
    
    public VoucherWS(){
        voucherBo = new VoucherBOImpl();
    }
    
    @WebMethod(operationName = "guardarVoucher")
    public void guardarVoucher(@WebParam(name = "voucher") Voucher voucher, @WebParam(name = "estado") Estado estado) {
        this.voucherBo.guardar(voucher, estado);
    }
    
    @WebMethod(operationName = "obtenerVoucher")
    public Voucher obtenerVoucher(@WebParam(name = "id") int id) {
        return this.voucherBo.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarVoucher")
    public void eliminarVoucher (@WebParam(name = "id") int id) {
        this.voucherBo.eliminar(id);
    }
    
    
    @WebMethod(operationName = "listarVouchers")
    public List<Voucher> listarVouchers () {
        return this.voucherBo.listar();
    }
    
    @WebMethod(operationName = "obtenerVoucherDeSesion")
    public Voucher obtenerVoucherDeSesion(@WebParam(name = "idSesion") int idSesion) {
        return this.voucherBo.buscarVoucherPorIdSeion(idSesion);
    }
}
