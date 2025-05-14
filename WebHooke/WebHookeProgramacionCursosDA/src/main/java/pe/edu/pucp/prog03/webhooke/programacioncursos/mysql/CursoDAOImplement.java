/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.programacioncursos.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;
//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;

/**
 *
 * @author andre
 */



public class CursoDAOImplement extends BaseDAOImplement<Curso> implements CursoDAO{
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL insertarTipoSesion values(?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
//        cmd.setString("p_nombre", usu.getNombre());
//        cmd.setString("p_apellido", usu.getApellido());
//        cmd.setString("p_dni", usu.getDNI());
//        cmd.setString("p_email", usu.getEmail());
//        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
//        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }


    @Override
    protected CallableStatement comandoModificar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL modificarUsuario(?,?,?,?,?,?}";
        CallableStatement cmd = conn.prepareCall(sql);
//        cmd.setString("p_nombre", usu.getNombre());
//        cmd.setString("p_apellido", usu.getApellido());
//        cmd.setString("p_dni", usu.getDNI());
//        cmd.setString("p_email", usu.getEmail());
//        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
//        cmd.setInt("p_id", usu.getId());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarUsuario(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarUsuarioPorId}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarUsuario()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Curso mapearModelo(ResultSet rs) throws SQLException {
        Curso usu = new Curso();
//        usu.setId(rs.getInt("id"));
//        usu.setNombre(rs.getString("Nombre"));
//        usu.setApellido(rs.getString("Apellido"));
//        usu.setDNI(rs.getString("DNI"));
//        usu.setEmail(rs.getString("Email"));
//        usu.setFechaNacimiento(rs.getDate("FechaNacimiento"));

        //usuario.setId(rs.getInt("IdUsuario"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setEmail(rs.getString("Email"));
//            usuario.setFechaNacimiento(rs.getDate("FechaNacimiento"));
        return usu;
    }    
    
}
