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
public class TipoSesionDAOImplement extends BaseDAOImplement<TipoSesion> implements TipoSesionDAO{
    @Override
    protected CallableStatement comandoInsertar(Connection conn, TipoSesion tipoSesion) throws SQLException {
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
    protected CallableStatement comandoModificar(Connection conn, TipoSesion tipoSesion) throws SQLException {
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

//    @Override
//    public Usuario buscar(int id){
//        String sql = "SELECT * FROM Usuario WHERE IdUsuario = ?";
//        
//        try (Connection conn =DBManager.getInstance().getConnection();
//                PreparedStatement ps = conn.prepareStatement(sql)){
//            
//            ps.setInt(1, id);
//            ResultSet rs=ps.executeQuery();
//            
//            if(!rs.next()){
//                System.err.println("No se encontro el area en academia con id: " + id);
//                return null;
//            }
//            
//            
//            Usuario usuario = new Usuario() ;
//            //aca.(rs.getInt("id"));
//            usuario.setId(rs.getInt("IdUsuario"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setEmail(rs.getString("Email"));
//            usuario.setFechaNacimiento(rs.getDate("FechaNacimiento"));
//            
//            return usuario;  
//        }
//        catch (Exception e) {
//            System.err.println(e);
//            throw new RuntimeException("No se pudo listar las academias 3.");
//        }
//    }
    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarUsuario()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected TipoSesion mapearModelo(ResultSet rs) throws SQLException {
        TipoSesion usu = new TipoSesion();
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
