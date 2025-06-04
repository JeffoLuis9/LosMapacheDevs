
package pe.edu.pucp.prog03.webhooke.boimpl;

import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.SesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;

import pe.edu.pucp.prog03.webhooke.bo.ISesionBO;
/**
 * Hello world!
 */
public class SesionBOImpl implements ISesionBO{
    private SesionDAO sesionDAO;
    
    public SesionBOImpl(){
        this.sesionDAO= new SesionDAOImplement();
    }

    @Override
    public List<Sesion> listar() {
        return this.sesionDAO.listar();
    }

    @Override
    public Sesion obtener(int id) {
        return this.sesionDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.sesionDAO.eliminar(id);
    }

    @Override
    public void guardar(Sesion modelo, Estado estado) {
        if(estado == Estado.Nuevo){
            this.sesionDAO.insertar(modelo);
        }
        else{
            this.sesionDAO.modificar(modelo);
        }
    }
}
