/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.BaseDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;

//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;

/**
 *
 * @author andre
 */



public class CursoDAOImplement extends BaseDAOImplement<Curso> implements CursoDAO{
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL insertarCurso(?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_codigo", curso.getCodigo());
        cmd.setString("p_nombre", curso.getNombre());
        cmd.setInt("p_nivel", curso.getNivel());
        cmd.setInt("p_hinicio",curso.getHoraInicio());
        cmd.setInt("p_hfin",curso.getHoraFin());
        //cmd.setInt("p_idProfesor",curso.getProfesor().getId());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }


    @Override
    protected CallableStatement comandoModificar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL modificarCurso(?,?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);

        cmd.setString("p_codigo", curso.getCodigo());
        cmd.setString("p_nombre", curso.getNombre());
        cmd.setInt("p_nivel", curso.getNivel());
        cmd.setInt("p_hinicio",curso.getHoraInicio());
        cmd.setInt("p_hfin",curso.getHoraFin());
//cmd.setInt("p_idProfesor",curso.getProfesor().getId());
        cmd.setInt("p_id", curso.getId());


        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarCurso(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarCursoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }


    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarCursos()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Curso mapearModelo(ResultSet rs) throws SQLException {
        Curso usu = new Curso();
        
        usu.setId(rs.getInt("idCurso"));
        usu.setCodigo(rs.getString("codigo"));
        usu.setNombre(rs.getString("nombre"));
        usu.setNivel(rs.getInt("nivel"));
        usu.setHoraInicio(rs.getInt("horaInicio"));
        usu.setHoraFin(rs.getInt("horaFin"));
        
        return usu;
    }    
    
    @Override
    public List<Curso> buscarCursoPorNivel(int nivel){
        try (
            Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = this.comandoBuscarCursoPorNivel(conn, nivel);) {
            ResultSet rs = ps.executeQuery();

            List<Curso> modelos = new ArrayList<>();
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
    protected CallableStatement comandoBuscarCursoPorNivel(Connection conn, int nivel) throws SQLException {
        String sql = "{CALL buscarCursoPorNivel(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_nivel", nivel);
        return cmd;
    }
}
