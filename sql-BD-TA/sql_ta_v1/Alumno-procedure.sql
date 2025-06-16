drop procedure insertarAlumno;
drop procedure modificarAlumno;
drop procedure buscarAlumnoPorId;
drop procedure eliminarAlumno;
drop procedure listarAlumno;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarAlumno`(
    IN p_tipoUsuario CHAR(1),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_carrera VARCHAR(100),
    OUT p_id INT
)
BEGIN
    INSERT INTO Alumno (TipoUsuario,Nombre, Apellido, DNI, Email, fechanacimiento, carrera)
    VALUES (p_tipoUsuario,p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento, p_carrera);

    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarAlumno`(
	IN p_tipoUsuario CHAR(1),
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
    SET TipoUsuario=p_tipoUsuario,
		nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento,
        carrera = p_carrera
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAlumnoPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Alumno
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAlumno`(
    IN p_id INT
)
BEGIN
    DELETE FROM Alumno
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarAlumno`()
BEGIN
    SELECT * FROM Alumno;
END//
