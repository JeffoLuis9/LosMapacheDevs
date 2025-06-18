/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.bo;

import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;

/**
 *
 * @author ASUS
 */
public interface IVoucherBO extends IBaseBO<Voucher>{
    Voucher buscarVoucherPorIdSeion(int idSesion);
}
