/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.AlumnoDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.modalidades.TipoSesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.SedeDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;


/**
 *
 * @author ASUS
 */
public class SesionDAOImplement extends BaseDAOImplement<Sesion> implements SesionDAO{
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Sesion sesion) throws SQLException {
        String sql = "{CALL insertarSesion(?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
       
        cmd.setDate("p_fecha", (Date) sesion.getFecha());
        cmd.setString("p_modalidad",sesion.getModalidad());
        cmd.setInt("p_idCurso", sesion.getCurso().getId());
        cmd.setInt("p_idAlumno", sesion.getAlumno().getId());
        cmd.setInt("p_idTipoSesion", sesion.getTipoSesion().getIdModalidad());
        cmd.setInt("p_idProfesor", sesion.getProfesor().getId());
        cmd.setInt("p_idSede", sesion.getSede().getId());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }


    @Override
    protected CallableStatement comandoModificar(Connection conn, Sesion sesion) throws SQLException {
        String sql = "{CALL modificarSesion(?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        cmd.setDate("p_fecha", (Date) sesion.getFecha());
        cmd.setString("p_modalidad",sesion.getModalidad());
        cmd.setInt("p_idCurso", sesion.getCurso().getId());
        cmd.setInt("p_idAlumno", sesion.getAlumno().getId());
        cmd.setInt("p_idTipoSesion", sesion.getTipoSesion().getIdModalidad());
        cmd.setInt("p_idProfesor", sesion.getProfesor().getId());
        cmd.setInt("p_idSede", sesion.getSede().getId());
        cmd.setInt("p_id", sesion.getIdHorario());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarSesion(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarSesionPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarSesiones()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Sesion mapearModelo(ResultSet rs) throws SQLException {
        Sesion sesion = new Sesion();
        sesion.setIdHorario(rs.getInt("idSesion"));
        sesion.setFecha(rs.getDate("fecha"));
        sesion.setModalidad(rs.getString("Modalidad"));
        sesion.setCurso(new CursoDAOImplement().buscar(rs.getInt("idCurso")));
        sesion.setAlumno(new AlumnoDAOImplement().buscar(rs.getInt("idAlumno")));
        sesion.setTipoSesion(new TipoSesionDAOImplement().buscar(rs.getInt("idTipoSesion")));
        sesion.setProfesor(new ProfesorDAOImplement().buscar(rs.getInt("idProfesor")));
        
        sesion.setSede(new SedeDAOImplement().buscar(rs.getInt("idSede")));
        
        return sesion;
    }    
    
}
