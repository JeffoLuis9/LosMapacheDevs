/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.IAcademiaBO;
import pe.edu.pucp.prog03.webhooke.dao.gestionacademia.AcademiaDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.AcademiaDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Academia;

/**
 *
 * @author ASUS
 */
public class AcademiaBOImpl implements IAcademiaBO{
    
    private final AcademiaDAO academiaDao;
    
    public AcademiaBOImpl(){
        academiaDao = new AcademiaDAOImplement();
    }

    @Override
    public List<Academia> listar() {
        return this.academiaDao.listar();
    }

    @Override
    public Academia obtener(int id) {
        return this.academiaDao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.academiaDao.eliminar(id);
    }

    @Override
    public void guardar(Academia modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.academiaDao.insertar(modelo);
        }
        else{
            this.academiaDao.modificar(modelo);
        }
    }
    
}
