drop procedure insertarAdministrador;
drop procedure modificarAdministrador;
drop procedure buscarAdministradorPorId;
drop procedure eliminarAdministrador;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarAdministrador`(
	IN p_tipoUsuario CHAR(1),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO Administrador (TipoUsuario,nombre, apellido, dni, email, dechaNacimiento)
    VALUES (p_tipoUsuario,p_nombre, p_apellido, p_dni, p_email, p_fechanacimiento);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarAdministrador`(
	IN p_tipoUsuario CHAR(1),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_dni CHAR(8),
    IN p_email VARCHAR(150),
    IN p_fechanacimiento DATE,
    IN p_id INT
)
BEGIN
    UPDATE Administrador
    SET TipoUsuario = p_tipoUsuario,
		nombre = p_nombre,
        apellido = p_apellido,
        dni = p_dni,
        email = p_email,
        fechaNacimiento = p_fechanacimiento
    WHERE idUsuario = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAdministradorPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Administrador
    WHERE idUsuario = p_id;
END//

CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAdministrador`(
    IN p_id INT
)
BEGIN
    DELETE FROM Administrador
    WHERE idUsuario = p_id;
END//