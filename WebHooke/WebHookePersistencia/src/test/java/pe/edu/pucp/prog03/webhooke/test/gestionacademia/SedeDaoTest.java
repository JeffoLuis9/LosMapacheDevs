///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pe.edu.pucp.prog03.webhooke.test.gestionacademia;
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
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
//
//import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;
//
//import pe.edu.pucp.prog03.webhooke.dao.gestionacademia.SedeDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.SedeDAOImplement;
//
////-----------
//import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Academia;
//import pe.edu.pucp.prog03.webhooke.dao.gestionacademia.AcademiaDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.gestionacademia.AcademiaDAOImplement;
//import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;
//
///**
// *
// * @author andre
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class SedeDaoTest implements CrudDaoTest {
//
//    private int testId;
//    private final int idIncorrecto = 99999;
//
//    @Test
//    @Order(1)
//    @Override
//    public void debeInsertar() {
//        AcademiaDAO acadedao = new AcademiaDAOImplement();
//        Academia aca = acadedao.buscar(1);
//
//        SedeDAO sededao = new SedeDAOImplement();
//        Sede sede = new Sede();
//        sede.setDistrito("OLIVOS");
//        sede.setDireccion("JR Tupac amaru");
//        sede.setAcademia(aca);
//        this.testId = sededao.insertar(sede);
//        assertTrue(this.testId > 0);
//    }
//
//    @Test
//    @Order(2)
//    @Override
//    public void debeModificarSiIdExiste() {
//        AcademiaDAO acadedao = new AcademiaDAOImplement();
//        Academia aca = acadedao.buscar(1);
//
//        SedeDAO sededao = new SedeDAOImplement();
//        Sede sede = new Sede();
//        sede.setId(this.testId);
//        sede.setDistrito("OLIVOS test2");
//        sede.setDireccion("JR Tupac amaru test2");
//        sede.setAcademia(aca);
//
//        boolean modificado = sededao.modificar(sede);
//
//        assertTrue(modificado);
//        Sede sedemodificado = sededao.buscar(this.testId);
//
//        assertEquals(sedemodificado.getDistrito(), "OLIVOS test2");
//        assertEquals(sedemodificado.getDireccion(), "JR Tupac amaru test2");
//        assertEquals(sedemodificado.getAcademia().getId(), 1);
//
//    }
//
//    @Test
//    @Order(3)
//    @Override
//    public void noDebeModificarSiIdNoExiste() {
//        AcademiaDAO acadedao = new AcademiaDAOImplement();
//        Academia aca = acadedao.buscar(1);
//        
//        SedeDAO sededao = new SedeDAOImplement();
//        Sede sede = new Sede();
//        sede.setId(this.idIncorrecto);
//        sede.setDistrito("OLIVOS test2");
//        sede.setDireccion("JR Tupac amaru test2");
//        sede.setAcademia(aca);
//        
//        boolean modificado= sededao.modificar(sede);
//        
//        assertFalse(modificado);
//        
//    }
//
//    @Test
//    @Order(4)
//    @Override
//    public void noDebeEliminarSiIdNoExiste() {
//        SedeDAO sedeDAO = new SedeDAOImplement();
//        boolean elimino = sedeDAO.eliminar(this.idIncorrecto);
//        
//        assertFalse(elimino);
//    }
//    
//    @Test
//    @Order(5)
//    @Override
//    public void debeEncontrarSiIdExiste() {
//        SedeDAO sedeDAO = new SedeDAOImplement();
//        Sede sede1 = sedeDAO.buscar(this.testId);
//        
//        assertNotNull(sede1);
//    }
//    
//    @Test
//    @Order(6)
//    @Override
//    public void noDebeEncontrarSiIdNoExiste() {
//        SedeDAO sedeDAO = new SedeDAOImplement();
//        Sede sede1 = sedeDAO.buscar(this.idIncorrecto);
//        
//        assertNull(sede1);
//    }
//    
//    @Test
//    @Order(7)
//    @Override
//    public void debeListar() {
//        SedeDAO sedeDAO = new SedeDAOImplement();
//        List<Sede>sede = sedeDAO.listar();
//        
//        assertNotNull(sede);
//        assertFalse(sede.isEmpty());
//    }
//
//    @Test
//    @Order(8)
//    @Override
//    public void debeEliminarSiIdExiste() {
//        SedeDAO sedeDAO = new SedeDAOImplement();
//        boolean elimino = sedeDAO.eliminar(this.testId);
//        
//        assertTrue(elimino);
//    }
//
//    
//    
//}