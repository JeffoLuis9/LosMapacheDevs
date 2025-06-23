
import com.google.protobuf.TextFormat;
import java.text.ParseException;
import java.util.List;
import pe.edu.pucp.prog03.webhooke.bo.ISesionBO;
import pe.edu.pucp.prog03.webhooke.boimpl.SesionBOImpl;
import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;

//package pe.edu.pucp.prog03.webhookeapptest;
////import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Academia;
////import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.AcademiaDAO;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.List;
//import pe.edu.pucp.prog03.webhooke.bo.Estado;
//import pe.edu.pucp.prog03.webhooke.bo.IAlumnoBO;
//import pe.edu.pucp.prog03.webhooke.bo.ICursoBO;
//import pe.edu.pucp.prog03.webhooke.bo.IProfesorBO;
//import pe.edu.pucp.prog03.webhooke.bo.ISedeBO;
//import pe.edu.pucp.prog03.webhooke.bo.ISesionBO;
//import pe.edu.pucp.prog03.webhooke.bo.ITipoSesionBO;
//import pe.edu.pucp.prog03.webhooke.boimpl.AlumnoBOImpl;
//import pe.edu.pucp.prog03.webhooke.boimpl.CursoBOImpl;
//import pe.edu.pucp.prog03.webhooke.boimpl.ProfesorBOImpl;
//import pe.edu.pucp.prog03.webhooke.boimpl.SedeBOImpl;
//import pe.edu.pucp.prog03.webhooke.boimpl.SesionBOImpl;
//import pe.edu.pucp.prog03.webhooke.boimpl.TipoSesionBOImpl;
//import pe.edu.pucp.prog03.webhooke.dao.programacioncursos.CursoDAO;
//import pe.edu.pucp.prog03.webhooke.daoimpl.programacioncursos.CursoDAOImplement;
//import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;
//import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
//import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
//import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;
//import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Sesion;
//
//
////import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.AcademiaDAOImplement;
////
////import pe.edu.pucp.prog03.webhooke.programacioncursos.model.Curso;
////import pe.edu.pucp.prog03.webhooke.programacioncursos.dao.CursoDAO;
////import pe.edu.pucp.prog03.webhooke.programacioncursos.mysql.CursoDAOImplement;
////
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Usuario;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.UsuarioDAO;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.UsuarioDAOImplement;
////
////import java.sql.Date;
////import pe.edu.pucp.prog03.webhooke.gestionacademia.model.Sede;
////import pe.edu.pucp.prog03.webhooke.gestionacademia.dao.SedeDAO;
////import pe.edu.pucp.prog03.webhooke.gestionacademia.mysql.SedeDAOImplement;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.dao.ProfesorDAO;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Profesor;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.mysql.ProfesorDAOImplement;
////import pe.edu.pucp.prog03.webhooke.modalidades.model.TipoSesion;
////
////import pe.edu.pucp.prog03.webhooke.business.AlumnoBO;
////import pe.edu.pucp.prog03.webhooke.gestionusuarios.model.Alumno;
////import pe.edu.pucp.prog03.webhooke.business.CursoBO;
////import pe.edu.pucp.prog03.webhooke.business.ProfesorBO;
////import pe.edu.pucp.prog03.webhooke.business.SesionBO;
////import pe.edu.pucp.prog03.webhooke.modalidades.dao.TipoSesionDAO;
////import pe.edu.pucp.prog03.webhooke.modalidades.mysql.TipoSesionDAOImplement;
///**
// * Hello world!
// */
public class main {
    public static void main(String[] args) throws ParseException {
        ISesionBO sesionBo = new SesionBOImpl();
        List<Sesion>sesiones = sesionBo.buscarSesionesxalumno(21);


//    //INSERTAR DATOS ALEATORIOS DE PROFESOR
//    
////    for(int i=0;i<10;i++){
////        String nombre = "profesor nombre "+ i;
////        String apellido = "profesor apellido "+ i;
////        int numeroDNI = 10000000+i;
////        String dni = String.valueOf(numeroDNI);
////        String email = "Profesor"+i+"@prueba.com";
////        Date fechaNacimiento = Date.valueOf("2000-01-01");
////        idProfesor = profesorBO.registrarProfesor(nombre,apellido, dni, email, fechaNacimiento);
////        System.out.println("El id del profesor ingresado es : "+ idProfesor);
////    }
//    System.out.println("///////////////////////////////////////////////////////////////////////////////");
//    //INSERTAR CURSOS 
//    //CREAR UN PROFESOR
//
////    int idCurso;
////    CursoBO cursoBO = new CursoBO();
////    for(int i=0;i<1;i++){
////        String codigo = "Curso codigo "+(i+1);
////        String nombre = "Curso nombre "+(i+1);
////        idCurso = cursoBO.registrarCurso(codigo, nombre, 5, profesor);
////        System.out.println("El id del curso ingresado es : "+ idCurso);
////    }
//    
//    //PRUEBAS DE MODIFICAR 
////
////    Profesor profesor = profesorBO.b(15);
////    profesor.setEmail("profesor13@prueba.com");
////    profesorBO.actualizarProfesor(profesor);
//    //prueba de registrar Alumno
////    AlumnoBO alumnoBO = new AlumnoBO();
////    
////    int idAlumno = alumnoBO.registrarAlumno("Jefferson", "Robles", "123456","correo@prueba.com",Date.valueOf("2020-04-23") , "Ingenieria Informatica");
////    System.out.println("El id del alumno ingresado es : "+ idAlumno);
////    
////    //prueba de registrar Curso
////    Profesor profesor = new Profesor();
////    profesor.setId(1);
////    profesor.setNombre("Alejandro");
////    profesor.setApellido("Barrantes");
////    profesor.setDNI("1234");
////    profesor.setEmail("QWERTy@correo.com");
////    profesor.setFechaNacimiento(Date.valueOf("1995-04-23"));    
////    ProfesorDAO profesorDao = new ProfesorDAOImplement();
////    profesorDao.insertar(profesor);
////    
////    CursoBO cursoBO = new CursoBO();
////    int idCurso = cursoBO.registrarCurso("1INF30","CURSO", 7,profesor );
////    System.out.println("El id del curso ingresado es : "+ idAlumno);
////    
////    /*Registro de sesion*/
////    CursoDAO cursoDao = new CursoDAOImplement();
////    Curso curso = cursoDao.buscar(idCurso);
////
//////    Curso curso = new Curso();
//////    curso.setCodigo("1INF30");
//////    curso.setNombre("Programacion 3");
//////    curso.setNivel(7);
//////    curso.setProfesor(profesor); 
////    
////    
////    
////    Alumno alumno = new Alumno();
////    alumno.setId(1);
////    alumno.setNombre("Renato");
////    alumno.setApellido("Tapia");
////    alumno.setDNI("123456789");
////    alumno.setEmail("alumno2@correo.com");
////    alumno.setFechaNacimiento(Date.valueOf("2008-04-23"));  
////    
////    TipoSesion tipoSesion = new TipoSesion();
////    tipoSesion.setIdModalidad(1);
////    tipoSesion.setPrecio(250);
////    tipoSesion.setTipo("Grupal");
////    
////    TipoSesionDAO tipoSesionDAO = new TipoSesionDAOImplement();
////    int idTipoSesion = tipoSesionDAO.insertar(tipoSesion);
////
////    Academia academia = new Academia();
////    academia.setNombre("AcademiaHooke");
////    academia.setRUC("12345678");
////    academia.setId(1);
////    
////    
////    
////    SedeDAO sedeDao = new SedeDAOImplement();
////    Sede sede = sedeDao.buscar(2);
////    SesionBO sesionBO = new SesionBO();
////        System.out.println("id de la sede: "+ sede.getId());
////        
////    int idSesion = sesionBO.registrarSesion(7, 10, Date.valueOf("2025-05-15"), "Virtual",curso, alumno, tipoSesion, sede);
////    System.out.println("El id de la sesion ingresada es : "+ idSesion);      
////    
//        CursoDAO cursoDao = new CursoDAOImplement();
//        List<Curso> cursos = cursoDao.buscarCursoPorNivel(1);
//        
//        ISesionBO sesionBo = new SesionBOImpl();
//        Estado estado = Estado.Nuevo;
//        
//        IAlumnoBO alumnoBo = new AlumnoBOImpl();
//        Alumno alumno = alumnoBo.obtener(1);
//        
//        ICursoBO cursoBo = new CursoBOImpl();
//        Curso curso = cursoBo.obtener(1);
//        
//        ISedeBO sedeBo = new SedeBOImpl();
//        Sede sede = sedeBo.obtener(1);
//        
//        ITipoSesionBO tipoSesionBo = new TipoSesionBOImpl();
//        TipoSesion tipoSesion = tipoSesionBo.obtener(1);
//        
//        IProfesorBO profesorBo = new ProfesorBOImpl();
//        Profesor profesor = profesorBo.obtener(1);
//        
//        Sesion sesion = new Sesion();
//        
//        sesion.setAlumno(alumno);
//        sesion.setCurso(curso);
//        sesion.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2025"));
//        sesion.setModalidad("Presencial");
//        sesion.setProfesor(profesor);
//        sesion.setSede(sede);
//        sesion.setTipoSesion(tipoSesion);
//        
//        sesionBo.guardar(sesion, estado);
//        
//        
  }
//
}
