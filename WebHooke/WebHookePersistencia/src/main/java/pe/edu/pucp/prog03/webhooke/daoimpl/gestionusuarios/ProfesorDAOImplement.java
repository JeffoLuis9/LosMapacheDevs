/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios;



/**
 *
 * @author andre
 */



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.ProfesorDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;


import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;




public class ProfesorDAOImplement extends BaseDAOImplement<Profesor> implements ProfesorDAO{
    
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Profesor usu) throws SQLException {
        String sql = "{CALL insertarProfesor(?,?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        if (usu.getFechaNacimiento() != null) {
            cmd.setDate("p_fechanacimiento", new java.sql.Date(usu.getFechaNacimiento().getTime()));
        } else {
            cmd.setNull("p_fechanacimiento", java.sql.Types.DATE);
        }
        cmd.setInt("p_curso", usu.getCurso().getId());
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        cmd.setString("p_password", usu.getPassword());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Profesor usu) throws SQLException {
        String sql = "{CALL modificarProfesor(?,?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        if (usu.getFechaNacimiento() != null) {
            cmd.setDate("p_fechanacimiento", new java.sql.Date(usu.getFechaNacimiento().getTime()));
        } else {
            cmd.setNull("p_fechanacimiento", java.sql.Types.DATE);
        }
        cmd.setInt("p_curso",usu.getCurso().getId());
        cmd.setInt("p_id", usu.getId());
        cmd.setString("p_password", usu.getPassword());
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        return cmd;
    }


    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarProfesor(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarProfesorPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarProfesor()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Profesor mapearModelo(ResultSet rs) throws SQLException {
        Profesor usu = new Profesor();
        usu.setId(rs.getInt("idUsuario"));
        usu.setNombre(rs.getString("nombre"));
        usu.setApellido(rs.getString("apellido"));
        usu.setDNI(rs.getString("DNI"));
        usu.setEmail(rs.getString("email"));
        usu.setFechaNacimiento(rs.getDate("fechaNacimiento"));
        usu.setCurso(new CursoDAOImplement().buscar(rs.getInt("idCurso")));
        usu.setTipoUsuario(rs.getString("tipoUsuario").charAt(0));
        usu.setPassword(rs.getString("password"));
        return usu;
    }
    
    
    @Override
    public List<Profesor>buscarProfesorPorCurso (int idCurso){
       try (
            Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarProfesorPorCurso(conn,idCurso);) {
            ResultSet rs = ps.executeQuery();

            List<Profesor> modelos = new ArrayList<>();
            while (rs.next()) {
                modelos.add(this.mapearModelo(rs));
            }

            return modelos;
        } catch (SQLException e) {
            System.err.println("Error SQL durante el listado: " + e.getMessage());
            throw new RuntimeException("No se pudo listar el registro.", e);
        } catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al listar los registros.", e);
        }
    }
    
    protected CallableStatement comandoBuscarProfesorPorCurso(Connection conn, int idCurso) throws SQLException {
        String sql = "{CALL buscarProfesorPorCurso(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", idCurso);
        return cmd;
    }
}
