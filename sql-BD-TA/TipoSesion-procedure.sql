drop procedure insertarTipoSesion;
drop procedure modificarTipoSesion;
drop procedure eliminarTipoSesion;
drop procedure buscarTipoSesionPorId;
drop procedure listarTipoSesion;   

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



DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarTipoSesion`(
    IN p_id INT
)
BEGIN
    DELETE FROM TipoSesion
    WHERE idModalidad = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarTipoSesionPorId`(IN p_id INT)
BEGIN
    SELECT * FROM TipoSesion WHERE idModalidad = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarTipoSesion`()
BEGIN
    SELECT * FROM TipoSesion;
END//