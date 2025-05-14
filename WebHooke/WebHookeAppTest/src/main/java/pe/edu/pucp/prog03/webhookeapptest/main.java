package pe.edu.pucp.prog03.webhookeapptest;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;
import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.AcademiaDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.AcademiaDAOImplement;

import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
import pe.edu.pucp.prog03.webhooke.programacioncursos.mysql.CursoDAOImplement;

import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Usuario;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.UsuarioDAO;
import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.UsuarioDAOImplement;

import java.sql.Date;
import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;
import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.SedeDAO;
import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.SedeDAOImplement;
/**
 * Hello world!
 */
public class main {
    public static void main(String[] args) {

          /*ACADEMIA*/
//
//        Academia academia = new Academia();
//        System.out.println("ACADEMIA");
//
//        academia.setNombre("AcademiaHooke");
//        academia.setRUC("12345678");
//
//        AcademiaDAO academiaDao = new AcademiaDAOImplement();
//        //INSERTAR
//        //int idAcademia = academiaDao.insertar(academia);
//        //System.out.println("Insertar Academia");
//        int idAcademia=1;
////        System.out.println("id: "+idAcademia);
////        //MODIFICAR
////        System.out.println("Modificar Academia con id : "+idAcademia);
////        academia.setId(idAcademia);
////        academia.setNombre("NombreBuscado");
////        academia.setRUC("12344321");
////        if(academiaDao.modificar(academia)){
////            System.out.println("Se modifico los datos de la academia con id: "+academia.getId());
////        }
//////        //BUSCAR
////        System.out.println("Buscar Academia con id : "+idAcademia);
////        Academia academia2 = academiaDao.buscar(idAcademia);
////        System.out.println("El nombre de la academia encontrada es: "+academia2.getNombre());
//        //System.out.println(academia2.getNombre());
////        //eliminar
//        System.out.println("Eliminar Academia con id : "+idAcademia);
//        if(academiaDao.eliminar(idAcademia)){
//            System.out.println("Se elimino la fila en Academia");
//        }
//
//        /*SEDE*/
//        System.out.println("SEDE");
//        Sede sede = new Sede();
//        sede.setDireccion("Av. La molina 240");
//        sede.setDistrito("La Molina");
//        sede.setNombre_Academia("AcademiaHooke");
//
//        //INSERTAR
//        SedeDAO sedeDao = new SedeDAOImplement();
//        System.out.println("Insertar Sede"
//                + "");
//        int idSede=sedeDao.insertar(sede);
//        System.out.println("id: "+idSede);
//        
//        //MODIFICAR
//        System.out.println("Modificar Sede con id : "+idSede);
//        sede.setId(idSede);
//        sede.setDireccion("Av. aviacion 240");
//        sede.setDistrito("San Borja");
//        sede.setNombre_Academia("AcademiaHooke");
//        if(sedeDao.modificar(sede)){
//            System.out.println("Se modifico los datos de la sede con id: "+sede.getId());
//        }
//        //BUSCAR
//        Sede sede2 = sedeDao.buscar(idSede);
//        System.out.println("Buscar Sede con id : "+idSede);
//        System.out.println("La direccion de la sede encontrada : "+sede2.getDireccion());
//        //ELIMINAR
//        System.out.println("Eliminar Sede con id : "+idSede);
//        if(sedeDao.eliminar(idSede)){
//          System.out.println("Se elimino la fila en Sede");
//        }
//
//        /*CURSO*/
//        
//        System.out.println("CURSO");
//        Curso curso = new Curso();
//        curso.setCodigo("1INF30");
//        curso.setNombre("Programacion 3");
//        curso.setNivel(7);
//
//        CursoDAO cursoDao = new CursoDAOImplement();
//        //INSERTAR
//        System.out.println("Insertar Curso");
//        int idCurso = cursoDao.insertar(curso);
//        System.out.println("id: "+idCurso);
//        
//        //MODIFICAR
//        System.out.println("Modificar Curso con id : "+idCurso);
//        curso.setId(idCurso);
//        curso.setCodigo("1INF20");
//        curso.setNombre("Programacion 2");
//        curso.setNivel(6);
//        if(cursoDao.modificar(curso)){
//        System.out.println("Se modifico los datos de la curso con id: "+curso.getId());
//        }
//        //BUSCAR
//        System.out.println("Buscar Curso con id : "+idCurso);
//        Curso curso2 = cursoDao.buscar(idCurso);
//        System.out.println("El nombre del curso encontrado es "+curso2.getNombre());
//        //eliminar
//        if(cursoDao.eliminar(idCurso)){
//            System.out.println("Se elimino la fila en curso");
//        }
//         /*USUARIO*/
//         
//        System.out.println("USUARIO");
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Jefferson");
//        usuario.setApellido("Robles");
//        usuario.setDNI("12345678");
//        usuario.setEmail("JRC@gmail.com");
//        usuario.setFechaNacimiento(Date.valueOf("2025-04-23"));
//
//        UsuarioDAO usuarioDao = new UsuarioDAOImplement();
//        //        //INSERTAR
//        System.out.println("Insertar Usuario:");
//        int idUsuario = usuarioDao.insertar(usuario);
//        System.out.println("id: "+idUsuario);
//        //MODIFICAR
//        System.out.println("Modificar Usuario con id :"+idUsuario);
//        usuario.setId(idUsuario);
//        usuario.setNombre("Jose");
//        usuario.setApellido("Alma");
//        usuario.setDNI("12345600");
//        usuario.setEmail("JA000@gmail.com");
//        usuario.setFechaNacimiento(Date.valueOf("2020-04-23"));
//        if(usuarioDao.modificar(usuario)){
//            System.out.println("Se modifico los datos del usuario con id: "+usuario.getId());
//        }
//        //buscar
//        System.out.println("Buscar Usuario:");
//        Usuario usuario2 = usuarioDao.buscar(idUsuario);
//        System.out.println("El nombre de usuario encontrado es :"+usuario2.getNombre());
//        //eliminar
//        if(usuarioDao.eliminar(idUsuario)){
//            System.out.println("Se elimino la fila en Usuario");
//        }
//        
  }

}
