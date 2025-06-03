
package pe.edu.pucp.prog03.webhooke.business;

import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.SesionDAOImplement;

import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;

import java.util.Date;
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
