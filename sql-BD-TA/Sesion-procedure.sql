drop procedure if exists insertarSesion;
drop procedure if exists modificarSesion;
drop procedure if exists eliminarSesion;
drop procedure if exists buscarSesionPorId;
drop procedure if exists listarSesionesporAlumnos;
drop procedure if exists buscarAlumnoEnSesion;
drop procedure if exists listarSesiones;


DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarSesion`(
    IN p_fecha DATE,
    IN p_modalidad VARCHAR(20),
    IN p_estado boolean,
    IN p_idCurso INT,
    IN p_idAlumno INT,
    IN p_idTipoSesion INT,
    IN p_idProfesor INT,
    IN p_idSede INT,
    IN p_idVoucher INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Sesion(fecha, modalidad,estado,idCurso, idAlumno, idTipoSesion,idProfesor, idSede, idVoucher)
    VALUES (p_fecha, p_modalidad, p_estado,p_idCurso, p_idAlumno, p_idTipoSesion, p_idProfesor,p_idSede,p_idvoucher);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarSesion`(
    IN p_fecha DATE,
    IN p_modalidad VARCHAR(20),
    IN p_estado boolean,
    IN p_idCurso INT,
    IN p_idAlumno INT,
    IN p_idTipoSesion INT,
    IN p_idProfesor INT,
    IN p_idSede INT,
    IN p_idVoucher INT,
    IN p_id INT
)
BEGIN
    UPDATE Sesion
    SET fecha = p_fecha,
        modalidad = p_modalidad,
        estado = p_estado,
        idCurso = p_idCurso,
        idAlumno = p_idAlumno,
        idTipoSesion = p_idTipoSesion,
        idProfesor = p_idProfesor,
        idSede = p_idSede,
        idVoucher= p_idVoucher
    WHERE idSesion = p_id;
END//


DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarSesionPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Sesion
    WHERE idSesion = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarSesionesporAlumnos`(
    IN p_id INT
)
BEGIN
	SELECT idSesion FROM Sesion
    WHERE idAlumno=p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAlumnoEnSesion`()
BEGIN
    SELECT DISTINCT idAlumno
	FROM Sesion;

END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarSesion`(
    IN p_id INT
)
BEGIN
    DELETE FROM Sesion
    WHERE idSesion = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarSesiones`()
BEGIN
    SELECT * FROM Sesion;
END//