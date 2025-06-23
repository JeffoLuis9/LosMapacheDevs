///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pe.edu.pucp.prog03.webhooke.test.programacioncursos;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.List;
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
//import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
//import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.VoucherDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
//import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.VoucherDAOImplement;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Voucher;
//
//import pe.edu.pucp.prog03.webhooke.test.CrudDaoTest;
//
///**
// *
// * @author ASUS
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class VoucherDaoTest implements CrudDaoTest{
//    
//    private int testId;
//    private final int idIncorrecto = 99999;
//    
//    @Test
//    @Order(1)
//    @Override
//    public void debeInsertar() {
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        Voucher voucher = new Voucher();
//        voucher.setCodigoOperacion("123456789");
//        try {
//            voucher.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2025"));
//        } catch (ParseException ex) {
//            Logger.getLogger(VoucherDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        voucher.setMonto(30);
//        voucher.setIdSesion(1);
//        this.testId = voucherDao.insertar(voucher);
//        assertTrue(this.testId > 0);
//    }
//    
//    @Test
//    @Order(2)
//    @Override
//    public void debeModificarSiIdExiste() {
//        
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        Voucher voucher = new Voucher();
//        
//        voucher.setId(this.testId);
//        voucher.setCodigoOperacion("111111111111");
//        try {
//            voucher.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("16-06-2025"));
//        } catch (ParseException ex) {
//            Logger.getLogger(VoucherDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        voucher.setMonto(30);
//        
//        boolean modifico = voucherDao.modificar(voucher);
//        assertTrue(modifico);
//        
//        Voucher voucherModificado = voucherDao.buscar(this.testId);
//        assertEquals(voucherModificado.getCodigoOperacion(), "111111111111");
//        //assertEquals(voucher.getFecha(), LocalDate.parse("2025-06-16"));
//        assertEquals(voucherModificado.getMonto(), 30);
//    }
//    
//    @Test
//    @Order(3)
//    @Override
//    public void noDebeModificarSiIdNoExiste() {
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        Voucher voucher = new Voucher();
//        voucher.setId(this.idIncorrecto);
//        voucher.setCodigoOperacion("111111111111");
//        try {
//            voucher.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("16-06-2025"));
//        } catch (ParseException ex) {
//            Logger.getLogger(VoucherDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        voucher.setMonto(30);
//        
//        
//        
//        boolean modifico = voucherDao.modificar(voucher);
//        assertFalse(modifico);
//    }
//    
//    @Test
//    @Order(4)
//    @Override
//    public void noDebeEliminarSiIdNoExiste() {
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        boolean elimino = voucherDao.eliminar(this.idIncorrecto);
//        assertFalse(elimino);
//    }
//    
//    @Test
//    @Order(5)
//    @Override
//    public void debeEncontrarSiIdExiste() {
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        Voucher voucher = voucherDao.buscar(this.testId);
//        
//        assertNotNull(voucher);
//    }
//    
//    @Test
//    @Order(6)
//    @Override
//    public void noDebeEncontrarSiIdNoExiste() {
//        
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        Voucher voucher = voucherDao.buscar(this.idIncorrecto);
//        
//        assertNull(voucher);
//    }
//    
//    @Test
//    @Order(7)
//    @Override
//    public void debeListar() {
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        List<Voucher> vouchers = voucherDao.listar();
//        
//        assertNotNull(vouchers);
//        assertFalse(vouchers.isEmpty());
//    }
//    
//    @Test
//    @Order(8)
//    @Override
//    public void debeEliminarSiIdExiste() {
//        
//        VoucherDAO voucherDao= new VoucherDAOImplement();
//        boolean elimino = voucherDao.eliminar(this.testId);
//        assertTrue(elimino);
//    }
//}
