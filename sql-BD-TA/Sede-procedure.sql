drop procedure insertarSede;
drop procedure modificarSede;
drop procedure eliminarSede;
drop procedure buscarSedePorId;
drop procedure listarSede;

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


DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarSedePorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Sede
    WHERE idSede = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarSede`(
    IN p_id INT
)
BEGIN
    DELETE FROM Sede
    WHERE idSede = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarSede`()
BEGIN
    SELECT * FROM Sede;
END//