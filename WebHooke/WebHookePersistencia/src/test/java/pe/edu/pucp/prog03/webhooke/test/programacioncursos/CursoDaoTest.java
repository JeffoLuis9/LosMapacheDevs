///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pe.edu.pucp.prog03.webhooke.test.programacioncursos;
//
//import java.util.List;
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
//import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
//
//import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;
//
///**
// *
// * @author ASUS
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class CursoDaoTest implements CrudDaoTest{
//    
//    private int testId;
//    private final int idIncorrecto = 99999;
//    
//    @Test
//    @Order(1)
//    @Override
//    public void debeInsertar() {
//        
//        CursoDAO cursoDao= new CursoDAOImplement();
//        Curso curso = new Curso();
//        curso.setCodigo("CT1");
//        curso.setNivel(5);
//        curso.setNombre("Curso test 1");
//        curso.setHoraFin(10);
//        curso.setHoraFin(12);
//        
//        this.testId = cursoDao.insertar(curso);
//        assertTrue(this.testId > 0);
//    }
//    
//    @Test
//    @Order(2)
//    @Override
//    public void debeModificarSiIdExiste() {
//        
//        
//        CursoDAO cursoDao= new CursoDAOImplement();
//        Curso curso = new Curso();
//        curso.setId(this.testId);
//        curso.setCodigo("CT2");
//        curso.setNivel(4);
//        curso.setNombre("Curso test 2");
//        curso.setHoraFin(10);
//        curso.setHoraFin(12);
//        
//        boolean modifico = cursoDao.modificar(curso);
//        assertTrue(modifico);
//        
//        Curso cursoModificado = cursoDao.buscar(this.testId);
//        assertEquals(cursoModificado.getNombre(), "Curso test 2");
//        assertEquals(cursoModificado.getCodigo(), "CT2");
//        assertEquals(cursoModificado.getNivel(), 4);
//        assertEquals(cursoModificado.getHoraFin(),12);
//    }
//    
//    @Test
//    @Order(3)
//    @Override
//    public void noDebeModificarSiIdNoExiste() {
//        
//        CursoDAO cursoDao= new CursoDAOImplement();
//        Curso curso = new Curso();
//        curso.setId(this.idIncorrecto);
//        curso.setCodigo("CT2");
//        curso.setNivel(4);
//        curso.setNombre("Curso test 2");
//        curso.setHoraFin(10);
//        curso.setHoraFin(12);
//        
//        boolean modifico = cursoDao.modificar(curso);
//        assertFalse(modifico);
//    }
//    
//    @Test
//    @Order(4)
//    @Override
//    public void noDebeEliminarSiIdNoExiste() {
//        
//        CursoDAO cursoDao= new CursoDAOImplement();
//        boolean elimino = cursoDao.eliminar(this.idIncorrecto);
//        assertFalse(elimino);
//    }
//    
//    @Test
//    @Order(5)
//    @Override
//    public void debeEncontrarSiIdExiste() {
//        CursoDAO cursoDao= new CursoDAOImplement();
//        Curso curso = cursoDao.buscar(this.testId);
//        
//        assertNotNull(curso);
//    }
//    
//    @Test
//    @Order(6)
//    @Override
//    public void noDebeEncontrarSiIdNoExiste() {
//        
//        
//        CursoDAO cursoDao= new CursoDAOImplement();
//        Curso curso = cursoDao.buscar(this.idIncorrecto);
//        
//        assertNull(curso);
//    }
//    
//    @Test
//    @Order(7)
//    @Override
//    public void debeListar() {
//        
//        CursoDAO cursoDao = new CursoDAOImplement();
//        List<Curso> cursos = cursoDao.listar();
//        
//        assertNotNull(cursos);
//        assertFalse(cursos.isEmpty());
//    }
//    
//    @Test
//    @Order(8)
//    @Override
//    public void debeEliminarSiIdExiste() {
//        
//        CursoDAO cursoDao = new CursoDAOImplement();
//        boolean elimino = cursoDao.eliminar(this.testId);
//        assertTrue(elimino);
//    }
//}
