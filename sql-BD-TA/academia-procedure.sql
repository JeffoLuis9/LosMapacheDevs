drop procedure insertarAcademia;
drop procedure modificarAcademia;
drop procedure eliminarAcademia;
drop procedure buscarAcademiaPorId;
drop procedure listarAcademia;

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

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarAcademiaPorId`(IN p_id INT)
BEGIN
    SELECT * FROM Academia WHERE idAcademia = p_id;
END//

DELIMITER ;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarAcademia`(IN p_id INT)
BEGIN
    DELETE FROM Academia WHERE idAcademia = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarAcademia`()
BEGIN
    SELECT * FROM Academia;
END//
