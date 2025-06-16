drop procedure IF EXISTS insertarProfesor;
drop procedure IF EXISTS modificarProfesor;
drop procedure IF EXISTS eliminarProfesor;
drop procedure IF EXISTS buscarProfesorPorId;
drop procedure IF EXISTS buscarProfesorPorCurso;
drop procedure IF EXISTS listarProfesor;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarProfesor`(
    IN p_tipoUsuario CHAR(1),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_password VARCHAR (100),
    IN p_fechanacimiento DATE,
    IN p_curso INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Usuario (TipoUsuario,Nombre, Apellido, DNI, Email,Password, fechaNacimiento, idCurso)
    VALUES (p_tipoUsuario,p_nombre, p_apellido, p_dni, p_email,p_password, p_fechanacimiento, p_curso);

    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarProfesor`(
	IN p_tipoUsuario CHAR(1),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_password VARCHAR (100),
    IN p_fechanacimiento DATE,
    IN p_curso INT,
    IN p_id INT
)
BEGIN
    UPDATE Usuario
    SET TipoUsuario = p_tipoUsuario,
		nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        password = p_password,
        fechaNacimiento = p_fechanacimiento,
        idCurso = p_curso
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarProfesorPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Usuario
    WHERE idUsuario= p_id and TipoUsuario = 'P';
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarProfesorPorCurso`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Usuario
    WHERE idCurso= p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarProfesor`(
    IN p_id INT
)
BEGIN
    DELETE FROM Usuario
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarProfesor`()
BEGIN
    SELECT * FROM Usuario where TipoUsuario="P";
END//