/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.dao.programacioncursos;

import pe.edu.pucp.prog03.webhooke.dao.ICrud;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;

/**
 *
 * @author ASUS
 */
public interface VoucherDAO extends ICrud<Voucher>{
    Voucher buscarVoucherPorIdSesion (int idSesion);
}
