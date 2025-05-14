/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionacademia.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.AcademiaDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;


//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;

/**
 *
 * @author andre
 */
//nota el academiaDAO es le IacademiaDAO
public class AcademiaDAOImplement extends BaseDAOImplement<Academia> implements AcademiaDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Academia aca) throws SQLException {
        String sql = "{CALL insertarAcademia values(?,?,?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", aca.getNombre());
        cmd.setString("p_RUC", aca.getRUC());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }
//    public int insertar(Academia aca){
//        String sql ="Insert Academia (Nombre,RUC) values(?,?)";
//        try (Connection conn = DBManager.getInstance().getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
//            
//            //ps.setInt(1, aca.getId());
//            ps.setString(1, aca.getNombre());
//            ps.setString(2, aca.getRUC());
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
    protected CallableStatement comandoModificar(Connection conn, Academia aca) throws SQLException {
        String sql = "{CALL modificarAcademia(?,?,?}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", aca.getNombre());
        cmd.setString("p_RUC", aca.getRUC());
        cmd.setInt("p_id", aca.getId());
        return cmd;
    }

//    public boolean modificar(Academia aca) {
//        String sql = "UPDATE Academia SET nombre = ?, ruc = ? WHERE id = ?";
//
//        try (Connection conn = DBManager.getInstance().getConnection(); PreparedStatement cs = conn.prepareCall(sql)) {
//
//            cs.setString(1, aca.getNombre());
//            cs.setString(2, aca.getRUC());
//            cs.setInt(3, aca.getId());
//
//            return cs.executeUpdate() > 0;
//        } catch (Exception e) {
//            System.err.println(e);
//            throw new RuntimeException("No se puede modificar la ACADEMIA");
//        }
//    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarAcademia(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;             
    }
    
    
    
//    //se hizo el cambio de int id a string id
//    public boolean eliminar(int id) {
//        String sql = "DELETE FROM Academia WHERE id= ?";
//        try (Connection conn = DBManager.getInstance().getConnection(); PreparedStatement pd = conn.prepareStatement(sql)) {
//            pd.setInt(1, id);
//            //pd.setString(1,id);
//            return pd.executeUpdate() > 0;
//        } catch (Exception e) {
//            System.err.println(e);
//            throw new RuntimeException("No se pudo eliminar la academia xd");
//        }
//
//    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException{
        String sql= "{CALL buscarAcademiaPorId}";
        CallableStatement cmd=conn.prepareCall(sql);
        cmd.setInt("p_id",id);
        return cmd;
    }
    
//    public Academia buscar(int id) {
//        String sql = "SELECT * FROM Academia WHERE id = ?";
//
//        try (Connection conn = DBManager.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (!rs.next()) {
//                System.err.println("No se encontro el area en academia con id: " + id);
//                return null;
//            }
//
//            Academia aca = new Academia();
//            //aca.(rs.getInt("id"));
//            aca.setId(rs.getInt("id"));
//            aca.setNombre(rs.getString("nombre"));
//            aca.setRUC(rs.getString("ruc"));
//
//            return aca;
//        } catch (Exception e) {
//            System.err.println(e);
//            throw new RuntimeException("No se pudo listar las academias 3.");
//        }
//    }
    @Override
    protected CallableStatement comandoListar (Connection conn) throws SQLException{
        String sql= "{CALL listarAcademia()}";
        CallableStatement cmd=conn.prepareCall(sql);
        return cmd;
    }
    
    @Override
    protected Academia mapearModelo(ResultSet rs) throws SQLException{
        Academia aca= new Academia();
        aca.setId(rs.getInt("id"));
        aca.setNombre(rs.getString("Nombre"));
        aca.setRUC(rs.getString("RUC"));
        return aca;
    }
}
