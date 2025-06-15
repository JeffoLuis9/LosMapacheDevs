/*PROCEDURES INSERTAR*/
drop procedure insertarAcademia;
drop procedure insertarAdministrador;
drop procedure insertarAlumno;
drop procedure insertarCurso;
drop procedure insertarProfesor;
drop procedure insertarSede;
drop procedure insertarSesion;
drop procedure insertarTipoSesion;
drop procedure insertarUsuario;
/*PROCEDURES MODIFICAR*/
drop procedure modificarAcademia;
drop procedure modificarAdministrador;
drop procedure modificarAlumno;
drop procedure modificarCurso;
drop procedure modificarProfesor;
drop procedure modificarSede;
drop procedure modificarSesion;
drop procedure modificarTipoSesion;
drop procedure modificarUsuario;
/*PROCEDURES BUSCAR*/
drop procedure buscarAcademiaPorId;
drop procedure buscarAdministradorPorId;
drop procedure buscarAlumnoPorId;
drop procedure buscarCursoPorId;
drop procedure buscarProfesorPorId;
drop procedure buscarSedePorId;
drop procedure buscarSesionPorId;
drop procedure buscarUsuarioPorId;

/*PROCEDURES ELIMINAR*/
drop procedure eliminarAcademia;
drop procedure eliminarAdministrador;
drop procedure eliminarAlumno;
drop procedure eliminarCurso;
drop procedure eliminarProfesor;
drop procedure eliminarSede;
drop procedure eliminarSesion;
drop procedure eliminarTipoSesion;
drop procedure eliminarUsuario;

/*PROCEDURES LISTAR*/

drop procedure listarAcademia;
drop procedure listarAlumno;
drop procedure listarCursos;
drop procedure listarProfesor;
drop procedure listarSede;
drop procedure listarSesiones;
drop procedure listarUsuario;

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAcademiaPorId`(IN p_id INT)
BEGIN
    SELECT * FROM Academia WHERE idAcademia = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAdministradorPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Administrador
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAlumnoPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Alumno
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarCursoPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Curso
    WHERE idCurso = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarProfesorPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Profesor
    WHERE idUsuario= p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarSedePorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Sede
    WHERE idSede = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarSesionPorId`(
    IN p_idSesion INT
)
BEGIN
    SELECT * FROM Sesion
    WHERE idSesion = p_idSesion;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarUsuarioPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Usuario
    WHERE id = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAcademia`(IN p_id INT)
BEGIN
    DELETE FROM Academia WHERE idAcademia = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAdministrador`(
    IN p_id INT
)
BEGIN
    DELETE FROM Administrador
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAlumno`(
    IN p_id INT
)
BEGIN
    DELETE FROM Alumno
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarCurso`(
    IN p_id INT
)
BEGIN
    DELETE FROM Curso
    WHERE idCurso = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarProfesor`(
    IN p_id INT
)
BEGIN
    DELETE FROM Profesor
    WHERE id = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarSede`(
    IN p_id INT
)
BEGIN
    DELETE FROM Sede
    WHERE idSede = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarSesion`(
    IN p_idSesion INT
)
BEGIN
    DELETE FROM Sesion
    WHERE idSesion = p_idSesion;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarTipoSesion`(
    IN p_id INT
)
BEGIN
    DELETE FROM TipoSesion
    WHERE idModalidad = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarUsuario`(
    IN p_id INT
)
BEGIN
    DELETE FROM Usuario
    WHERE id = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarAcademia`(
    IN p_nombre VARCHAR(100),
    IN p_RUC CHAR(11),
    OUT p_id INT
)
BEGIN
    INSERT INTO Academia (nombre, ruc) VALUES (p_nombre, p_RUC);
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarAdministrador`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO Administrador (nombre, apellido, dni, email, dechaNacimiento)
    VALUES (p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarAlumno`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_carrera VARCHAR(100),
    OUT p_id INT
)
BEGIN
    INSERT INTO Alumno (Nombre, Apellido, DNI, Email, dechanacimiento, carrera)
    VALUES (p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento, p_carrera);

    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarCurso`(
    IN p_codigo VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_nivel VARCHAR(50),
    IN p_idProfesor INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Curso(Codigo, Nombre, Nivel, idProfesor)
    VALUES (p_codigo, p_nombre, p_nivel, p_idProfesor);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarProfesor`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO Profesor (nombre, apellido, dni, email, fechaNacimiento)
    VALUES (p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento);

    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarSede`(
    IN p_direccion VARCHAR(200),
    IN p_distrito VARCHAR(100),
    IN p_idAcademia INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Sede (Direccion, Distrito, idAcademia)
    VALUES (p_direccion, p_distrito, p_idAcademia);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarSesion`(
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_fecha DATE,
    IN p_modalidad VARCHAR(20),
    IN p_idCurso INT,
    IN p_idAlumno INT,
    IN p_idTipoSesion INT,
    IN p_idSede INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Sesion(horaInicio, horaFin, fecha, modalidad, idCurso, idAlumno, idTipoSesion, idSede)
    VALUES (p_horaInicio, p_horaFin, p_fecha, p_modalidad, p_idCurso, p_idAlumno, p_idTipoSesion, p_idSede);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarTipoSesion`(
    IN p_precio DECIMAL(10,2),
    IN p_tipo VARCHAR(100),
    OUT p_id INT
)
BEGIN
    INSERT INTO TipoSesion(Precio, Tipo)
    VALUES (p_precio, p_tipo);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarUsuario`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO Usuario (nombre, apellido, dni, email, fechaNacimiento)
    VALUES (p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento);

    SET p_id = LAST_INSERT_ID();
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarAcademia`()
BEGIN
    SELECT * FROM Academia;
END//


DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarAlumno`()
BEGIN
    SELECT * FROM Alumno;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarCursos`()
BEGIN
    SELECT * FROM Curso;
END//



DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarProfesor`()
BEGIN
    SELECT * FROM Profesor;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarSede`()
BEGIN
    SELECT * FROM Sede;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarSesiones`()
BEGIN
    SELECT * FROM Sesion;
END//


DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarUsuario`()
BEGIN
    SELECT * FROM Usuario;
END//


DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarAcademia`(
    IN p_nombre VARCHAR(100),
    IN p_RUC CHAR(11),
    IN p_id INT
)
BEGIN
    UPDATE Academia SET nombre = p_nombre, ruc = p_RUC
    WHERE idAcademia = p_id;
END//


DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarAdministrador`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_id INT
)
BEGIN
    UPDATE Administrador
    SET nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento
    WHERE idUsuario = p_id;
END//


DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarAlumno`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_carrera VARCHAR(100),
    IN p_id INT
)
BEGIN
    UPDATE Alumno
    SET nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento,
        carrera = p_carrera
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarCurso`(
    IN p_codigo VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_nivel VARCHAR(50),
    IN p_idProfesor INT,
    IN p_id INT
)
BEGIN
    UPDATE Curso
    SET Codigo = p_codigo,
        Nombre = p_nombre,
        Nivel = p_nivel,
        idProfesor = p_idProfesor
    WHERE idCurso = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarProfesor`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_id INT
)
BEGIN
    UPDATE Profesor
    SET nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento
    WHERE idUsuario = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarSede`(
    IN p_direccion VARCHAR(200),
    IN p_distrito VARCHAR(100),
    IN p_idAcademia INT,
    IN p_id INT
)
BEGIN
    UPDATE Sede
    SET direccion = p_direccion,
        distrito = p_distrito,
        idAcademia = p_idAcademia
    WHERE idSede = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarSesion`(
    IN p_idSesion INT,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_fecha DATE,
    IN p_modalidad VARCHAR(20),
    IN p_idCurso INT,
    IN p_idAlumno INT,
    IN p_idTipoSesion INT,
    IN p_idSede INT
)
BEGIN
    UPDATE Sesion
    SET horaInicio = p_horaInicio,
        horaFin = p_horaFin,
        fecha = p_fecha,
        modalidad = p_modalidad,
        idCurso = p_idCurso,
        idAlumno = p_idAlumno,
        idTipoSesion = p_idTipoSesion,
        idSede = p_idSede
    WHERE idSesion = p_idSesion;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarTipoSesion`(
    IN p_id INT,
    IN p_precio DECIMAL(10,2),
    IN p_tipo VARCHAR(100)
)
BEGIN
    UPDATE TipoSesion
    SET Precio = p_precio,
        Tipo = p_tipo
    WHERE idModalidad = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarUsuario`(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_id INT
)
BEGIN
    UPDATE Usuario
    SET nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento
    WHERE id = p_id;
END//
