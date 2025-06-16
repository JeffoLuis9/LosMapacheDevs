///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pe.edu.pucp.prog03.webhooke.test.gestionusuarios;
//
//import java.util.List;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestInstance;
//import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.ProfesorDAO;
//import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.ProfesorDAOImplement;
//import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
//
//import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
//import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;
//
///**
// *
// * @author ASUS
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ProfesorDaoTest implements CrudDaoTest{
//    
//    private int testId;
//    private final int idIncorrecto = 99999;
//    private int idCurso =1;
//
//    @Test
//    @Order(1)
//    @Override
//    public void debeInsertar() {
//        
//        CursoDAO cursoDao = new CursoDAOImplement();
//        Curso curso = cursoDao.buscar(idCurso);
//        
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        Profesor profesor = new Profesor();
//        profesor.setDNI("12345678");
//        profesor.setNombre("Profesor nombre 1");
//        profesor.setApellido("Profesor Apellido 1");
//        profesor.setEmail("profesor1@prueba.test");
//        try {
//            profesor.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(ProfesorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        profesor.setCurso(curso);
//        profesor.setPassword("pass1234");
//        this.testId=profesorDao.insertar(profesor);
//        
//        assertTrue(this.testId>0);
//    }
//
//    @Test
//    @Order(2)
//    @Override
//    public void debeModificarSiIdExiste() {
//        
//        CursoDAO cursoDao = new CursoDAOImplement();
//        Curso curso = cursoDao.buscar(idCurso);
//        
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        Profesor profesor = new Profesor();
//        profesor.setId(this.testId);
//        profesor.setDNI("11111111");
//        profesor.setNombre("Profesor nombre 2");
//        profesor.setApellido("Profesor Apellido 2");
//        profesor.setEmail("profesor2@prueba.test");
//        try {
//            profesor.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(ProfesorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        profesor.setCurso(curso);
//        profesor.setPassword("pass1111");
//        boolean modificado = profesorDao.modificar(profesor);
//        
//        assertTrue(modificado);
//        
//        Profesor profesorModificado = profesorDao.buscar(this.testId);
//        
//        
//        assertEquals(profesorModificado.getDNI(),"11111111" );
//        assertEquals(profesorModificado.getNombre(),"Profesor nombre 2" );
//        assertEquals(profesorModificado.getApellido(),"Profesor Apellido 2" );
//        assertEquals(profesorModificado.getEmail(),"profesor2@prueba.test" );
//        assertEquals(profesorModificado.getCurso().getId(), curso.getId());
//        assertEquals(profesorModificado.getPassword(), "pass1111");
//    }
//
//    @Test
//    @Order(3)
//    @Override
//    public void noDebeModificarSiIdNoExiste() {
//        
//        CursoDAO cursoDao = new CursoDAOImplement();
//        Curso curso = cursoDao.buscar(idCurso);
//        
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        Profesor profesor = new Profesor();
//        profesor.setId(this.idIncorrecto);
//        profesor.setDNI("11111111");
//        profesor.setNombre("Profesor nombre 2");
//        profesor.setApellido("Profesor Apellido 2");
//        profesor.setEmail("profesor2@prueba.test");
//        try {
//            profesor.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(ProfesorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        profesor.setPassword("pass123456789");
//        profesor.setCurso(curso);
//        
//        boolean modificado = profesorDao.modificar(profesor);
//        
//        assertFalse(modificado);
//    }
//
//    @Test
//    @Order(4)
//    @Override
//    public void noDebeEliminarSiIdNoExiste() {
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        boolean elimino = profesorDao.eliminar(this.idIncorrecto);
//        
//        assertFalse(elimino);
//    }
//
//    @Test
//    @Order(5)
//    @Override
//    public void debeEncontrarSiIdExiste() {
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        Profesor profesor = profesorDao.buscar(this.testId);
//        
//        assertNotNull(profesor);
//    }
//
//    @Test
//    @Order(6)
//    @Override
//    public void noDebeEncontrarSiIdNoExiste() {
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        Profesor profesor = profesorDao.buscar(this.idIncorrecto);
//        
//        assertNull(profesor);
//    }
//
//    @Test
//    @Order(7)
//    @Override
//    public void debeListar() {
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        List<Profesor>profesores = profesorDao.listar();
//        
//        assertNotNull(profesores);
//        assertFalse(profesores.isEmpty());
//    }
//
//    @Test
//    @Order(8)
//    @Override
//    public void debeEliminarSiIdExiste() {
//        ProfesorDAO profesorDao = new ProfesorDAOImplement();
//        boolean elimino = profesorDao.eliminar(this.testId);
//        
//        assertTrue(elimino);
//    }
//
//}
