/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.AlumnoDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.modalidades.TipoSesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.SedeDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;

/**
 *
 * @author ASUS
 */
public class SesionDAOImplement extends BaseDAOImplement<Sesion> implements SesionDAO{
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Sesion sesion) throws SQLException {
        String sql = "{CALL insertarSesion(?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        //cmd.setDate("p_fechanacimiento", java.sql.Date.valueOf(usu.getFechaNacimiento()));
        cmd.setDate("p_fecha", new java.sql.Date(sesion.getFecha().getTime()));
        cmd.setString("p_modalidad",sesion.getModalidad());
        cmd.setBoolean("p_estado", sesion.isEstado());
        cmd.setInt("p_idCurso", sesion.getCurso().getId());
        cmd.setInt("p_idAlumno", sesion.getAlumno().getId());
        cmd.setInt("p_idTipoSesion", sesion.getTipoSesion().getIdModalidad());
        cmd.setInt("p_idProfesor", sesion.getProfesor().getId());
        cmd.setInt("p_idSede", sesion.getSede().getId());
        
        if (sesion.getVoucher() != null && sesion.getVoucher().getId()>0) {
            cmd.setInt("p_idVoucher", sesion.getVoucher().getId()); // p_idVoucher
        } else {
            cmd.setNull("p_idVoucher", java.sql.Types.INTEGER);     // p_idVoucher = NULL
        }
        
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }


    @Override
    protected CallableStatement comandoModificar(Connection conn, Sesion sesion) throws SQLException {
        String sql = "{CALL modificarSesion(?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        cmd.setDate("p_fecha",new java.sql.Date(sesion.getFecha().getTime()));
        cmd.setString("p_modalidad",sesion.getModalidad());
        cmd.setBoolean("p_estado", sesion.isEstado());
        cmd.setInt("p_idCurso", sesion.getCurso().getId());
        cmd.setInt("p_idAlumno", sesion.getAlumno().getId());
        cmd.setInt("p_idTipoSesion", sesion.getTipoSesion().getIdModalidad());
        cmd.setInt("p_idProfesor", sesion.getProfesor().getId());
        cmd.setInt("p_idSede", sesion.getSede().getId());
        if (sesion.getVoucher() != null && sesion.getVoucher().getId()>0) {
            cmd.setInt("p_idVoucher", sesion.getVoucher().getId()); // p_idVoucher
        } else {
            cmd.setNull("p_idVoucher", java.sql.Types.INTEGER);     // p_idVoucher = NULL
        }
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
        sesion.setEstado(rs.getBoolean("estado"));
        sesion.setCurso(new CursoDAOImplement().buscar(rs.getInt("idCurso")));
        sesion.setAlumno(new AlumnoDAOImplement().buscar(rs.getInt("idAlumno")));
        sesion.setTipoSesion(new TipoSesionDAOImplement().buscar(rs.getInt("idTipoSesion")));
        sesion.setProfesor(new ProfesorDAOImplement().buscar(rs.getInt("idProfesor")));
        
        sesion.setSede(new SedeDAOImplement().buscar(rs.getInt("idSede")));
        
        
        int idVoucher = rs.getInt("idVoucher");
        if(idVoucher >0)
            sesion.setVoucher(new VoucherDAOImplement().buscar(rs.getInt("idVoucher")));
        else
            sesion.setVoucher(null);
        
        return sesion;
    }    
    
    protected CallableStatement comandoBuscarAlumno(Connection conn) throws SQLException {
        String sql = "{CALL buscarAlumnoEnSesion( )}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }
    @Override
    public List<Integer> buscaralumnosede(){
        try (
            Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarAlumno(conn);) {
            ResultSet rs = ps.executeQuery();
            List<Integer> modelos;
            modelos = new ArrayList<>();
            while (rs.next()) {
                modelos.add(Integer.valueOf(rs.getInt("idAlumno")));
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
    
    @Override
    public List<Integer>buscarsesionesxalumno(int idAlumno){
        try (
            Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarSesionesxalumno(conn,idAlumno);) {
            ResultSet rs = ps.executeQuery();
            List<Integer> modelos;
            modelos = new ArrayList<>();
            while (rs.next()) {
                modelos.add(Integer.valueOf(rs.getInt("idSesion")));
            }   
            return modelos;    
        } catch (SQLException e) {
            System.err.println("Error SQL durante el listado: " + e.getMessage());
            throw new RuntimeException("No se pudo listar el registro.", e);
        } catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al listar los registros de sesionesxalumnos.", e);
        }
    }
    
    protected CallableStatement comandoBuscarSesionesxalumno(Connection conn,int id) throws SQLException {
        String sql = "{CALL listarSesionesporAlumnos(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }
    
    
    
}
