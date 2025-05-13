/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionacademia.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.AcademiaDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;
import pe.edu.pucp.prog03.webhooke.config.DBManager;
//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;

/**
 *
 * @author andre
 */




public class AcademiaDAOImplement implements AcademiaDAO{
    @Override
    public int insertar(Academia aca){
        String sql ="Insert Academia (Nombre,RUC) values(?,?)";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            //ps.setInt(1, aca.getId());
            ps.setString(1, aca.getNombre());
            ps.setString(2, aca.getRUC());
            
            if (ps.executeUpdate()==0){
                throw new SQLException("ERROR EN LA INSERCION DE ACADEMIAS");
            }
            try (ResultSet rs =ps.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getInt(1);
                }else{
                    throw new SQLException("FALLO LA INSERCION EN ACADEMIAPARTE1 EN ACADEMIADAO");
                }
            }
            
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se pudo insertar el cosodeAREA.");
        }
    }
    
    @Override
    public boolean modificar(Academia aca){
        String sql = "UPDATE Academia SET nombre = ?, ruc = ? WHERE id = ?";
        
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement cs = conn.prepareCall(sql)){
            
            
            cs.setString(1, aca.getNombre());
            cs.setString(2, aca.getRUC());
            cs.setInt(3, aca.getId());
            
            
            return cs.executeUpdate() > 0;
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se puede modificar la ACADEMIA");
        }
    }
    
    @Override
    //se hizo el cambio de int id a string id
    public boolean eliminar(int id){
        String sql = "DELETE FROM Academia WHERE id= ?";
        try (Connection conn =DBManager.getInstance().getConnection();
                PreparedStatement pd = conn.prepareStatement(sql)){
            pd.setInt(1, id);
            //pd.setString(1,id);
            return pd.executeUpdate()>0;
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se pudo eliminar la academia xd");
        }
    
    }
    
    @Override
    public Academia buscar(int id){
        String sql = "SELECT * FROM Academia WHERE id = ?";
        
        try (Connection conn =DBManager.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            if(!rs.next()){
                System.err.println("No se encontro el area en academia con id: " + id);
                return null;
            }
            
            Academia aca=new Academia();
            //aca.(rs.getInt("id"));
            aca.setId(rs.getInt("id"));
            aca.setNombre(rs.getString("nombre"));
            aca.setRUC(rs.getString("ruc"));
            
            return aca;  
        }
        catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException("No se pudo listar las academias 3.");
        }
    }
    
    
    
}
