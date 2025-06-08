/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.ITipoSesionBO;
import pe.edu.pucp.prog03.webhooke.dao.modalidades.TipoSesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.modalidades.TipoSesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;

/**
 *
 * @author ASUS
 */
public class TipoSesionBOImpl implements ITipoSesionBO{
    private final TipoSesionDAO tipoSesionDao;
    
    public TipoSesionBOImpl(){
        tipoSesionDao = new TipoSesionDAOImplement();
    }
    
    @Override
    public List<TipoSesion> listar() {
        return this.tipoSesionDao.listar();
    }

    @Override
    public TipoSesion obtener(int id) {
        return this.tipoSesionDao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.tipoSesionDao.eliminar(id);
    }

    @Override
    public void guardar(TipoSesion modelo, Estado estado) {
        if (estado == Estado.Nuevo){
            this.tipoSesionDao.insertar(modelo);
        }
        else{
            this.tipoSesionDao.modificar(modelo);
        }
    }
    
}
