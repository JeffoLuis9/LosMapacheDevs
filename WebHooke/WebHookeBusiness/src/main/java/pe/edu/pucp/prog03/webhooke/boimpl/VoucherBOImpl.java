/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.IVoucherBO;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.VoucherDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.VoucherDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;

/**
 *
 * @author ASUS
 */
public class VoucherBOImpl implements IVoucherBO{
    private VoucherDAO voucherDAO;
    
    public VoucherBOImpl(){
        voucherDAO= new VoucherDAOImplement();
    }
    
    @Override
    public List<Voucher> listar() {
        return this.voucherDAO.listar();
    }

    @Override
    public Voucher obtener(int id) {
        return this.voucherDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.voucherDAO.eliminar(id);
    }

    @Override
    public void guardar(Voucher modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.voucherDAO.insertar(modelo);
        }
        else{
            this.voucherDAO.modificar(modelo);
        }
    }

    @Override
    public Voucher buscarVoucherPorIdSeion(int idSesion) {
        return this.voucherDAO.buscarVoucherPorIdSesion(idSesion);
    }
    
}
