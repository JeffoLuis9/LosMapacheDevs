package pe.edu.pucp.prog03.webhooke.business;
import java.util.Date;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Alumno;
import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;
import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.SesionDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Sesion;
import pe.edu.pucp.prog03.webhooke.programacioncursos.mysql.SesionDAOImplement;

/**
 * Hello world!
 */
public class SesionBO {
    private SesionDAO sesionDAO;
    
    public SesionBO(){
        this.sesionDAO= new SesionDAOImplement();
    }
    
    public int registrarSesion(int horaInicio,int horaFin,Date fecha,String modalidad,Curso curso, Alumno alumno, TipoSesion tipoSesion, Sede sede){
        Sesion sesion = new Sesion();
        sesion.setHoraInicio(horaInicio);
        sesion.setHoraFin(horaFin);
        sesion.setFecha(fecha);
        sesion.setModalidad(modalidad);
        sesion.setCurso(curso);
        sesion.setAlumno(alumno);
        sesion.setTipoSesion(tipoSesion);
        sesion.setSede(sede);
        
        return sesionDAO.insertar(sesion);
    }
}
