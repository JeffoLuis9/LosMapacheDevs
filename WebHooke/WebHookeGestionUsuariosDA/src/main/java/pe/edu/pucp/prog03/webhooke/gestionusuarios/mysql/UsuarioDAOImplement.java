/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql;

/**
 *
 * @author ASUS
 */
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

import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.UsuarioDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Usuario;
import pe.edu.pucp.prog03.webhooke.config.DBManager;

public class UsuarioDAOImplement extends BaseDAOImplement<Usuario> implements UsuarioDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Usuario usu) throws SQLException {
        String sql = "{CALL insertarUsuario values(?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

//    @Override
//    public int insertar(Usuario usuario){
//        String sql ="Insert Usuario (Nombre,Apellido,DNI,Email,FechaNacimiento) values(?,?,?,?,?)";
//        try (Connection conn = DBManager.getInstance().getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
//            
//            //ps.setInt(1, aca.getId());
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getApellido());
//            ps.setString(3, usuario.getDNI());
//            ps.setString(4, usuario.getEmail());
//            ps.setDate(5, usuario.getFechaNacimiento());
//            
//            if (ps.executeUpdate()==0){
//                throw new SQLException("ERROR EN LA INSERCION DE ACADEMIAS");
//            }
//            try (ResultSet rs =ps.getGeneratedKeys()){
//                if(rs.next()){
//                    return rs.getInt(1);
//                }else{
//                    throw new SQLException("FALLO LA INSERCION EN ACADEMIAPARTE1 EN ACADEMIADAO");
//                }
//            }
//            
//        }
//        catch (Exception e){
//            System.err.println(e);
//            throw new RuntimeException("No se pudo insertar el cosodeAREA.");
//        }
//    }
    @Override
    protected CallableStatement comandoModificar(Connection conn, Usuario usu) throws SQLException {
        String sql = "{CALL modificarUsuario(?,?,?,?,?,?}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
        cmd.setInt("p_id", usu.getId());
        return cmd;
    }

//    @Override
//    public boolean modificar(Usuario usuario){
//        String sql = "UPDATE Usuario SET Nombre = ?,Apellido = ? ,DNI = ?,Email = ?,FechaNacimiento = ? WHERE IdUsuario = ?";
//        
//        try (Connection conn = DBManager.getInstance().getConnection();
//            PreparedStatement cs = conn.prepareCall(sql)){
// 
//            cs.setString(1, usuario.getNombre());
//            cs.setString(2, usuario.getApellido());
//            cs.setString(3, usuario.getDNI());
//            cs.setString(4, usuario.getEmail());
//            cs.setDate(5, usuario.getFechaNacimiento());
//            cs.setInt(6, usuario.getId());
//            
//            
//            return cs.executeUpdate() > 0;
//        }
//        catch (Exception e){
//            System.err.println(e);
//            throw new RuntimeException("No se puede modificar la ACADEMIA");
//        }
//    }
    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarUsuario(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

//    @Override
//    //se hizo el cambio de int id a string id
//    public boolean eliminar(int id){
//        String sql = "DELETE FROM Usuario WHERE IdUsuario= ?";
//        try (Connection conn =DBManager.getInstance().getConnection();
//                PreparedStatement pd = conn.prepareStatement(sql)){
//            pd.setInt(1, id);
//            //pd.setString(1,id);
//            return pd.executeUpdate()>0;
//        }
//        catch (Exception e){
//            System.err.println(e);
//            throw new RuntimeException("No se pudo eliminar la academia xd");
//        }
//    
//    }
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
    protected Usuario mapearModelo(ResultSet rs) throws SQLException {
        Usuario usu = new Usuario();
        usu.setId(rs.getInt("id"));
        usu.setNombre(rs.getString("nombre"));
        usu.setApellido(rs.getString("apellido"));
        usu.setDNI(rs.getString("DNI"));
        usu.setEmail(rs.getString("email"));
        usu.setFechaNacimiento(rs.getDate("fechaNacimiento"));

        //usuario.setId(rs.getInt("IdUsuario"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setEmail(rs.getString("Email"));
//            usuario.setFechaNacimiento(rs.getDate("FechaNacimiento"));
        return usu;
    }

}
