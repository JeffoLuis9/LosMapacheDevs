/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.modalidades.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.sql.Types;

import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;
import pe.edu.pucp.prog03.webhooke.modalidades.dao.TipoSesionDAO;
import pe.edu.pucp.prog03.webhooke.config.DBManager;

/**
 *
 * @author ASUS
 */
public class TipoSesionDAOImplement extends BaseDAOImplement<TipoSesion> implements TipoSesionDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, TipoSesion tipoSesion) throws SQLException {
        String sql = "{CALL insertarTipoSesion(?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        //cmd.setInt("p_idmodalidad", tipoSesion.getIdModalidad());
        cmd.setDouble("p_precio", tipoSesion.getPrecio());
        cmd.setString("p_tipo", tipoSesion.getTipo());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, TipoSesion tipoSesion) throws SQLException {
        String sql = "{CALL modificarTipoSesion(?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);

        cmd.setDouble("p_precio", tipoSesion.getPrecio());
        cmd.setString("p_tipo", tipoSesion.getTipo());
        cmd.setInt("p_id", tipoSesion.getIdModalidad());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarTipoSesion(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarTipoSesionPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarTipoSesion()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected TipoSesion mapearModelo(ResultSet rs) throws SQLException {
        TipoSesion usu = new TipoSesion();
        /*private int idModalidad;
    private double precio;
    private String tipo;*/
        usu.setIdModalidad(rs.getInt("idModalidad"));
        usu.setPrecio(rs.getDouble("precio"));
        usu.setTipo(rs.getString("tipo"));

        return usu;
    }
}
