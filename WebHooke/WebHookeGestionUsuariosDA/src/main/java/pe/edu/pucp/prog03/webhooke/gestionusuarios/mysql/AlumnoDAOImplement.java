/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql;

/**
 *
 * @author andre
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

import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.AlumnoDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Alumno;
import pe.edu.pucp.prog03.webhooke.config.DBManager;




public class AlumnoDAOImplement extends BaseDAOImplement<Alumno> implements AlumnoDAO {
    
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Alumno usu) throws SQLException {
        String sql = "{CALL insertarAlumno(?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
        cmd.setString("p_carrera", usu.getCarrera());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }
    
    
    @Override
    protected CallableStatement comandoModificar(Connection conn, Alumno usu) throws SQLException {
        String sql = "{CALL modificarAlumno(?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", usu.getNombre());
        cmd.setString("p_apellido", usu.getApellido());
        cmd.setString("p_dni", usu.getDNI());
        cmd.setString("p_email", usu.getEmail());
        cmd.setDate("p_fechanacimiento", usu.getFechaNacimiento());
        cmd.setString("p_carrera", usu.getCarrera());
        cmd.setInt("p_id", usu.getId());
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
        usu.setId(rs.getInt("id"));
        usu.setNombre(rs.getString("nombre"));
        usu.setApellido(rs.getString("apellido"));
        usu.setDNI(rs.getString("DNI"));
        usu.setEmail(rs.getString("email"));
        usu.setFechaNacimiento(rs.getDate("fechaNacimiento"));
        usu.setCarrera(rs.getString("carrera"));
        return usu;
    }
    
}
