/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios;

/**
 *
 * @author ASUS
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.UsuarioDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;

import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Usuario;


public class UsuarioDAOImplement extends BaseDAOImplement<Usuario> implements UsuarioDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Usuario usu) throws SQLException {
        String sql = "{CALL insertarUsuario(?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", new java.sql.Date(usu.getFechaNacimiento().getTime()));
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        cmd.setString("p_password", usu.getPassword());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Usuario usu) throws SQLException {
        String sql = "{CALL modificarUsuario(?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", new java.sql.Date(usu.getFechaNacimiento().getTime()));
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        cmd.setString("p_password", usu.getPassword());
        cmd.setInt("p_id", usu.getId());
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
        String sql = "{CALL buscarUsuarioPorId(?)}";
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
    protected Usuario mapearModelo(ResultSet rs) throws SQLException {
        Usuario usu = new Usuario();
        usu.setId(rs.getInt("id"));
        usu.setNombre(rs.getString("Nombre"));
        usu.setApellido(rs.getString("Apellido"));
        usu.setDNI(rs.getString("DNI"));
        usu.setEmail(rs.getString("Email"));
        usu.setFechaNacimiento(rs.getDate("fechaNacimiento"));
        usu.setTipoUsuario(rs.getString("tipoUsuario").charAt(0));
        usu.setPassword(rs.getString("password"));
        return usu;
    }

    @Override
    public int buscarUsuarioPorCorreo(String correo) {
        try (
                Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarUsuarioPorCorreo(conn, correo);) {
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.err.println("No se encontro el registro con correo: " + correo);
                return 0;
            }
            
            return rs.getInt("idUsuario");
            
        } catch (SQLException e) {
            System.err.println("Error SQL durante la busqueda: " + e.getMessage());
            throw new RuntimeException("No se pudo buscar el registro.", e);
        } catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al buscar el registro.", e);
        }
    }
    
    protected CallableStatement comandoBuscarUsuarioPorCorreo(Connection conn, String correo) throws SQLException {
        String sql = "{CALL buscarUsuarioPorCorreo(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_email",correo);
        
        return cmd;
    }

}
