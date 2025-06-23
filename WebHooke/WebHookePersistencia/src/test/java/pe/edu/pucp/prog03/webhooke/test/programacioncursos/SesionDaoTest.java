/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.test.programacioncursos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import pe.edu.pucp.prog03.webhooke.dao.gestionacademia.SedeDAO;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.AlumnoDAO;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.ProfesorDAO;
import pe.edu.pucp.prog03.webhooke.dao.modalidades.TipoSesionDAO;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.SesionDAO;
import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.VoucherDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.SedeDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.AlumnoDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.ProfesorDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.modalidades.TipoSesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.SesionDAOImplement;
import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.VoucherDAOImplement;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;
import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;

/**
 *
 * @author ASUS
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SesionDaoTest implements CrudDaoTest{

    private int testId;
    private final int idIncorrecto = 99999;
    private int idCurso=1;
    private int idProfesor=1;
    private int idAlumno = 2;
    private int idSede=1;
    private int idTipoSesion=1;
    private int idVoucher=1;
    @Test
    @Override
    @Order(1)    
    public void debeInsertar() {
        //tipo de sesion
        TipoSesionDAO tipoSesionDao = new TipoSesionDAOImplement();
        TipoSesion tipoSesion = tipoSesionDao.buscar(idTipoSesion);
                
        //sede
        SedeDAO sedeDao = new SedeDAOImplement();
        Sede sede = sedeDao.buscar(idSede);
        //alumno
        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
        Alumno alumno = alumnoDao.buscar(idAlumno);
        //curso
        CursoDAO cursoDao = new CursoDAOImplement();
        Curso curso = cursoDao.buscar(idCurso);
        //profesor 
        ProfesorDAO profesorDao = new ProfesorDAOImplement();
        Profesor profesor = profesorDao.buscar(idProfesor);
        
       
        
        SesionDAO sesionDao = new SesionDAOImplement();
        Sesion sesion = new Sesion();
        
        try {
            sesion.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2025"));
        } catch (ParseException ex) {
            Logger.getLogger(SesionDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        sesion.setModalidad("Virtual");
        sesion.setCurso(curso);
        sesion.setAlumno(alumno);
        sesion.setTipoSesion(tipoSesion);
        sesion.setSede(sede);
        sesion.setProfesor(profesor);
        
        
        this.testId = sesionDao.insertar(sesion);
        
        assertTrue(this.testId>0);
    }

    @Test
    @Override
    @Order(2)
    public void debeModificarSiIdExiste() {
          //tipo de sesion
        TipoSesionDAO tipoSesionDao = new TipoSesionDAOImplement();
        TipoSesion tipoSesion = tipoSesionDao.buscar(idTipoSesion);
                
        //sede
        SedeDAO sedeDao = new SedeDAOImplement();
        Sede sede = sedeDao.buscar(idSede);
        //alumno
        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
        Alumno alumno = alumnoDao.buscar(idAlumno);
        //curso
        CursoDAO cursoDao = new CursoDAOImplement();
        Curso curso = cursoDao.buscar(idCurso);
        //profesor 
        ProfesorDAO profesorDao = new ProfesorDAOImplement();
        Profesor profesor = profesorDao.buscar(idProfesor);
        
        VoucherDAO voucherDao= new VoucherDAOImplement();
        Voucher voucher = voucherDao.buscar(idVoucher);
        
       
        SesionDAO sesionDao = new SesionDAOImplement();
        Sesion sesion = new Sesion();
        
        
        sesion.setIdHorario(this.testId);
        try {
            sesion.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2025"));
        } catch (ParseException ex) {
            Logger.getLogger(SesionDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        sesion.setModalidad("Presencial");
        sesion.setEstado(true);
        sesion.setCurso(curso);
        sesion.setAlumno(alumno);
        sesion.setTipoSesion(tipoSesion);
        sesion.setSede(sede);
        sesion.setProfesor(profesor);
        sesion.setVoucher(voucher);
        
        boolean modifico = sesionDao.modificar(sesion);
        assertTrue(modifico);
        
        Sesion sesionModificado = sesionDao.buscar(testId);
        //assertEquals(sesionModificado.getFecha(),LocalDate.parse("2025-06-10"));
        assertEquals(sesionModificado.getModalidad(),"Presencial");
        assertEquals(sesionModificado.getCurso().getId(),idCurso);
        assertEquals(sesionModificado.getAlumno().getId(),idAlumno);
        assertEquals(sesionModificado.getSede().getId(),idSede);
        assertEquals(sesionModificado.getTipoSesion().getIdModalidad(),idTipoSesion);
        assertEquals(sesionModificado.getProfesor().getId(),idProfesor);
        assertEquals(sesionModificado.getVoucher().getId(),idVoucher);
    }

    @Test
    @Override
    @Order(3)
    public void noDebeModificarSiIdNoExiste() {
        TipoSesionDAO tipoSesionDao = new TipoSesionDAOImplement();
        TipoSesion tipoSesion = tipoSesionDao.buscar(idTipoSesion);
                
        //sede
        SedeDAO sedeDao = new SedeDAOImplement();
        Sede sede = sedeDao.buscar(idSede);
        //alumno
        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
        Alumno alumno = alumnoDao.buscar(idAlumno);
        //curso
        CursoDAO cursoDao = new CursoDAOImplement();
        Curso curso = cursoDao.buscar(idCurso);
        //profesor 
        ProfesorDAO profesorDao = new ProfesorDAOImplement();
        Profesor profesor = profesorDao.buscar(idProfesor);
        
        VoucherDAO voucherDao= new VoucherDAOImplement();
        Voucher voucher = voucherDao.buscar(idVoucher);
        
       
        SesionDAO sesionDao = new SesionDAOImplement();
        Sesion sesion = new Sesion();
        
        sesion.setIdHorario(this.idIncorrecto);
        try {
            sesion.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2025"));
        } catch (ParseException ex) {
            Logger.getLogger(SesionDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        sesion.setModalidad("Presencial");
        sesion.setEstado(true);
        sesion.setCurso(curso);
        sesion.setAlumno(alumno);
        sesion.setTipoSesion(tipoSesion);
        sesion.setSede(sede);
        sesion.setProfesor(profesor);
        sesion.setVoucher(voucher);
        
        boolean modifico = sesionDao.modificar(sesion);
        assertFalse(modifico);
    }

    @Test
    @Override
    @Order(4)
    public void noDebeEliminarSiIdNoExiste() {
        SesionDAO sesionDao = new SesionDAOImplement();
        boolean elimino = sesionDao.eliminar(this.idIncorrecto);
        
        assertFalse(elimino);
    }

    @Test
    @Override
    @Order(5)
    public void debeEncontrarSiIdExiste() {
        SesionDAO sesionDao = new SesionDAOImplement();
        Sesion sesion = sesionDao.buscar(this.testId);
        
        assertNotNull(sesion);
    }

    @Test
    @Override
    @Order(6)
    public void noDebeEncontrarSiIdNoExiste() {
        SesionDAO sesionDao = new SesionDAOImplement();
        Sesion sesion = sesionDao.buscar(this.idIncorrecto);
        
        assertNull(sesion);
    }

    @Test
    @Override
    @Order(7)
    public void debeListar() {
        SesionDAO sesionDao = new SesionDAOImplement();
        List<Sesion> sesiones = sesionDao.listar();
        
        assertNotNull(sesiones);
        assertFalse(sesiones.isEmpty());
    }

    @Test
    @Override
    @Order(8)
    public void debeEliminarSiIdExiste() {
        SesionDAO sesionDao = new SesionDAOImplement();
        boolean elimino = sesionDao.eliminar(this.testId);
        
        assertTrue(elimino);
    }
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
