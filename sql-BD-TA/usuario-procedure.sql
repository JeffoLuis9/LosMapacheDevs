drop procedure if exists insertarUsuario;
drop procedure if exists modificarUsuario;
drop procedure if exists eliminarUsuario;
drop procedure if exists buscarUsuarioPorId;
drop procedure if exists listarUsuario;
drop procedure if exists buscarUsuarioPorCorreo;
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

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarUsuarioPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Usuario
    WHERE id = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarUsuarioPorCorreo`(
    IN p_email VARCHAR(150)
)
BEGIN
    SELECT * FROM Usuario
    WHERE email = p_email;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarUsuario`(
    IN p_id INT
)
BEGIN
    DELETE FROM Usuario
    WHERE id = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarUsuario`()
BEGIN
    SELECT * FROM Usuario;
END//