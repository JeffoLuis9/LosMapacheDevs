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


import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.SedeDAO;
//import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;
import pe.edu.pucp.prog03.webhooke.config.DBManager;

import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;



/**
 *
 * @author andre
 */
public class SedeDAOImplement implements SedeDAO{
    
    @Override
    public int insertar(Sede sed){
        String sql ="Insert Sede (Direccion,Distrito,Nombre_Academia) values(?,?,?)";
        
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            ps.setString(1, sed.getDireccion());
            ps.setString(2, sed.getDistrito());
            ps.setString(3, sed.getNombre_Academia());
            
            if (ps.executeUpdate()==0){
                throw new SQLException("ERROR EN LA INSERCION DE SEDES");
            }
            try (ResultSet rs =ps.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getInt(1);
                }else{
                    throw new SQLException("FALLO LA INSERCION EN SEDES1 EN SEDESDAO");
                }
            }
            
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se pudo insertar el cosodeSEDE.");
        }
    }
    
    
    @Override
    public boolean modificar(Sede sed){
        String sql = "UPDATE Sede SET Direccion = ?, Distrito = ? ,Nombre_Academia = ? WHERE IdSede = ?";
        
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement cs = conn.prepareCall(sql)){
            
            cs.setString(1, sed.getDireccion());
            cs.setString(2, sed.getDistrito());
            cs.setString(3,sed.getNombre_Academia());
            cs.setInt(4, sed.getId());
            return cs.executeUpdate() > 0;
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se puede modificar la ACADEMIA");
        }
    }
    
    @Override
    public boolean eliminar(int id){
        String sql = "DELETE FROM Sede WHERE IdSede= ?";
        try (Connection conn =DBManager.getInstance().getConnection();
                PreparedStatement pd = conn.prepareStatement(sql)){
            pd.setInt(1,id);
            return pd.executeUpdate()>0;
        }
        catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("No se pudo eliminar la academia xd");
        }
    
    }
    
    
    @Override
    public Sede buscar (int id){
        String sql = "SELECT * FROM Sede WHERE IdSede = ?";
        
        try (Connection conn =DBManager.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            if(!rs.next()){
                System.err.println("No se encontro el area en sede con id: " + id);
                return null;
            }
            
            Sede sed=new Sede();
            sed.setId(rs.getInt("IdSede"));
            sed.setDireccion(rs.getString("Direccion"));
            sed.setDistrito(rs.getString("Distrito"));
            sed.setNombre_Academia(rs.getString("Nombre_Academia"));
            return sed;  
        }
        catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException("No se pudo listar las sede");
        }
    }
    
    
}
