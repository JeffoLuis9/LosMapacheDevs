/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.VoucherDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;

/**
 *
 * @author ASUS
 */
public class VoucherDAOImplement extends BaseDAOImplement<Voucher> implements VoucherDAO{

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Voucher voucher) throws SQLException {
        String sql = "{CALL insertarVoucher(?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_codigoOperacion", voucher.getCodigoOperacion());
        cmd.setDate("p_fecha", new java.sql.Date(voucher.getFecha().getTime()));
        cmd.setDouble("p_monto", voucher.getMonto());
        cmd.setInt("p_idsesion",voucher.getIdSesion());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Voucher voucher) throws SQLException {
        String sql = "{CALL modificarVoucher(?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_codigoOperacion", voucher.getCodigoOperacion());
        cmd.setDate("p_fecha", new java.sql.Date(voucher.getFecha().getTime()));
        cmd.setDouble("p_monto", voucher.getMonto());
        cmd.setInt("p_idsesion",voucher.getIdSesion());
        cmd.setInt("p_id", voucher.getId());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarVoucher(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarVoucherPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarVouchers()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Voucher mapearModelo(ResultSet rs) throws SQLException {
        Voucher voucher = new Voucher();
        
        voucher.setId(rs.getInt("idVoucher"));
        voucher.setCodigoOperacion(rs.getString("codigoOperacion"));
        voucher.setMonto(rs.getDouble("monto"));
        voucher.setFecha(rs.getDate("fecha"));
        voucher.setIdSesion(rs.getInt("idSesion"));
        return voucher;
    }
    
    protected CallableStatement comandoBuscarVoucherPorIdSesion(Connection conn,int id)throws SQLException{
        String sql = "{CALL buscarVoucherPorIdSesion(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    public Voucher buscarVoucherPorIdSesion(int idSesion) {
               try (
            Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarVoucherPorIdSesion(conn,idSesion);) {
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.err.println("No se encontro el registro con id: " + idSesion);
                return null;
            }

            return this.mapearModelo(rs);
        } catch (SQLException e) {
            System.err.println("Error SQL durante el listado: " + e.getMessage());
            throw new RuntimeException("No se pudo listar el registro.", e);
        } catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al listar los registros.", e);
        }
    }


    
}
