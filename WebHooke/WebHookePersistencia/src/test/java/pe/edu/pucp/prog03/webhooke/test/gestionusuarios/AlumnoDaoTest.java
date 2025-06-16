///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pe.edu.pucp.prog03.webhooke.test.gestionusuarios;
//
//import java.util.List;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
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
//
//import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.AlumnoDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.AlumnoDAOImplement;
//import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
//import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;
//
///**
// *
// * @author ASUS
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class AlumnoDaoTest implements CrudDaoTest{
//
//    private int testId;
//    private final int idIncorrecto = 99999;
//
//    @Test
//    @Order(1)
//    @Override
//    public void debeInsertar() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        Alumno alumno = new Alumno();
//        
//        alumno.setNombre("Alumno nombre 1");
//        alumno.setApellido("Alumno apellido 1");
//        alumno.setEmail("Alumnno1@prueba.test");
//        alumno.setDNI("12345678");
//        try {
//            alumno.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(AlumnoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        alumno.setCarrera("Carrera 1");
//        alumno.setPassword("pass1234");
//        
//        this.testId = alumnoDao.insertar(alumno);
//        assertTrue(this.testId>0);
//       
//    }
//
//    @Test
//    @Order(2)
//    @Override
//    public void debeModificarSiIdExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        Alumno alumno = new Alumno();
//        
//        alumno.setId(this.testId);
//        alumno.setNombre("Alumno nombre 2");
//        alumno.setApellido("Alumno apellido 2");
//        alumno.setEmail("Alumnno2@prueba.test");
//        alumno.setDNI("12345678");
//        try {
//            alumno.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(AlumnoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        alumno.setCarrera("Carrera 2");
//        alumno.setPassword("pass123456789");
//        boolean modifico = alumnoDao.modificar(alumno);
//        assertTrue(modifico);
//        
//        
//        Alumno alumnoModificado = alumnoDao.buscar(this.testId);
//        assertEquals(alumnoModificado.getDNI(),"12345678" );
//        assertEquals(alumnoModificado.getNombre(),"Alumno nombre 2" );
//        assertEquals(alumnoModificado.getApellido(),"Alumno apellido 2" );
//        assertEquals(alumnoModificado.getEmail(),"Alumnno2@prueba.test" );
//        assertEquals(alumnoModificado.getPassword(),"pass123456789" );
//    }
//
//    @Test
//    @Order(3)
//    @Override
//    public void noDebeModificarSiIdNoExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        Alumno alumno = new Alumno();
//        
//        alumno.setId(this.idIncorrecto);
//        alumno.setNombre("Alumno nombre 2");
//        alumno.setApellido("Alumno apellido 2");
//        alumno.setEmail("Alumnno2@prueba.test");
//        alumno.setDNI("12345678");
//        try {
//            alumno.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(AlumnoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        alumno.setCarrera("Carrera 2");
//        alumno.setPassword("pass1111");
//        boolean modifico = alumnoDao.modificar(alumno);
//        assertFalse(modifico);
//    }
//
//    @Test
//    @Order(4)
//    @Override
//    public void noDebeEliminarSiIdNoExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        boolean elimino = alumnoDao.eliminar(this.idIncorrecto);
//        assertFalse(elimino);
//    }
//
//    @Test
//    @Order(5)
//    @Override
//    public void debeEncontrarSiIdExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        Alumno alumno= alumnoDao.buscar(this.testId);
//        assertNotNull(alumno);
//    }
//
//    @Test
//    @Order(6)
//    @Override
//    public void noDebeEncontrarSiIdNoExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        Alumno alumno= alumnoDao.buscar(this.idIncorrecto);
//        assertNull(alumno);
//    }
//
//    @Test
//    @Order(7)
//    @Override
//    public void debeListar() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        List<Alumno> alumnos= alumnoDao.listar();
//        
//        assertNotNull(alumnos);
//        assertFalse(alumnos.isEmpty());
//    }
//
//    @Test
//    @Order(8)
//    @Override
//    public void debeEliminarSiIdExiste() {
//        AlumnoDAO alumnoDao = new AlumnoDAOImplement();
//        boolean elimino = alumnoDao.eliminar(this.testId);
//        assertTrue(elimino);
//    }
//
//}
