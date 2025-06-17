
package pe.edu.pucp.prog03.webhooke.boimpl;

import java.util.ArrayList;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.SesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.Estado;
import pe.edu.pucp.prog03.webhooke.bo.IAlumnoBO;

import pe.edu.pucp.prog03.webhooke.bo.ISesionBO;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
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
    @Override
    public List<Alumno>buscaralumnoporsesion(){
       // return this.sesionDAO.buscaralumnosede();
        IAlumnoBO alumnoBO=new AlumnoBOImpl();
        List<Alumno>datafinal=new ArrayList<Alumno>();
        List<Integer>bandera=sesionDAO.buscaralumnosede();
        
        for(Integer bande :bandera){
            int aa=bande.intValue();
            Alumno al= alumnoBO.obtener(aa);
            datafinal.add(al);
        }
        return datafinal;
                
                
    }
    
    @Override
    public List<Sesion>buscarSesionesxalumno(int idAlumno){
       ISesionBO sesionBO=new SesionBOImpl();
       List<Integer>bandera=sesionDAO.buscarsesionesxalumno(idAlumno);
       List<Sesion>datafinal=new ArrayList<Sesion>();
       for(Integer bande :bandera){
           int aa=bande.intValue();
           Sesion se=sesionBO.obtener(aa);
           datafinal.add(se);
       }
       return datafinal;
       
    }
    
    
}
