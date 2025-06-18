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

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.AlumnoDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;

import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;




public class AlumnoDAOImplement extends BaseDAOImplement<Alumno> implements AlumnoDAO {
    
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Alumno usu) throws SQLException {
        String sql = "{CALL insertarAlumno(?,?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
//        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
        if (usu.getFechaNacimiento() != null) {
            cmd.setDate("p_fechanacimiento", new java.sql.Date(usu.getFechaNacimiento().getTime()));
        } else {
            cmd.setNull("p_fechanacimiento", java.sql.Types.DATE);
        }
        cmd.setString("p_carrera", usu.getCarrera());
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        cmd.setString("p_password", usu.getPassword());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }
    
    
    @Override
    protected CallableStatement comandoModificar(Connection conn, Alumno usu) throws SQLException {
        String sql = "{CALL modificarAlumno(?,?,?,?,?,?,?,?,?)}";
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
        cmd.setString("p_carrera", usu.getCarrera());
        cmd.setInt("p_id", usu.getId());
        cmd.setString("p_password", usu.getPassword());
        cmd.setString("p_tipoUsuario", String.valueOf(usu.getTipoUsuario()));
        return cmd;
    }
    
    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarAlumno(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }
    
    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarAlumnoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }
    
    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarAlumno()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }
    
    @Override
    protected Alumno mapearModelo(ResultSet rs) throws SQLException {
        Alumno usu = new Alumno();
        usu.setId(rs.getInt("idUsuario"));
        usu.setNombre(rs.getString("nombre"));
        usu.setApellido(rs.getString("apellido"));
        usu.setDNI(rs.getString("DNI"));
        usu.setEmail(rs.getString("email"));
        usu.setFechaNacimiento(rs.getDate("fechaNacimiento"));
        usu.setCarrera(rs.getString("carrera"));
        usu.setTipoUsuario(rs.getString("tipoUsuario").charAt(0));
        usu.setPassword(rs.getString("password"));
        return usu;
    }
    
}
