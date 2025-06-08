/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.ISedeBO;
import pe.edu.pucp.prog03.webhooke.dao.gestionacademia.SedeDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.SedeDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;

/**
 *
 * @author ASUS
 */
public class SedeBOImpl implements ISedeBO{
    private final SedeDAO sedeDao;
    
    public SedeBOImpl(){
        sedeDao = new SedeDAOImplement();
    }
    @Override
    public List<Sede> listar() {
        return this.sedeDao.listar();
    }

    @Override
    public Sede obtener(int id) {
        return this.sedeDao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.sedeDao.eliminar(id);
    }

    @Override
    public void guardar(Sede modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.sedeDao.insertar(modelo);
        }
        else{
            this.sedeDao.modificar(modelo);
        }

    }
    
}
