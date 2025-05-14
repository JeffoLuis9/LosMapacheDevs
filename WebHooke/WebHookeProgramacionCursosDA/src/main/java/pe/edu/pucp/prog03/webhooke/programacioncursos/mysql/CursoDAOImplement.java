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
import java.sql.Types;


import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.ProfesorDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;
//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;

/**
 *
 * @author andre
 */



public class CursoDAOImplement extends BaseDAOImplement<Curso> implements CursoDAO{
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL insertarCurso(?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_codigo", curso.getCodigo());
        cmd.setString("p_nombre", curso.getNombre());
        cmd.setInt("p_nivel", curso.getNivel());
        cmd.setInt("p_idProfesor",curso.getProfesor().getId());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }


    @Override
    protected CallableStatement comandoModificar(Connection conn, Curso curso) throws SQLException {
        String sql = "{CALL modificarCurso(?,?,?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);

        cmd.setString("p_codigo", curso.getCodigo());
        cmd.setString("p_nombre", curso.getNombre());
        cmd.setInt("p_nivel", curso.getNivel());
        cmd.setInt("p_idProfesor",curso.getProfesor().getId());
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
        String sql = "{CALL listarCurso()}";
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
        usu.setProfesor(new ProfesorDAOImplement().buscar(rs.getInt("idProfesor")));


        return usu;
    }    
    
}
