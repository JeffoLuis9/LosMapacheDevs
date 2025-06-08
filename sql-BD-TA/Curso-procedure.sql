drop procedure IF EXISTS insertarCurso;
drop procedure IF EXISTS modificarCurso;
drop procedure IF EXISTS eliminarCurso;
drop procedure IF EXISTS buscarCursoPorId;
drop procedure IF EXISTS buscarCursoPorNivel;
drop procedure IF EXISTS listarCursos;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarCurso`(
    IN p_codigo VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_nivel VARCHAR(50),
    IN p_hinicio INT,
    IN p_hfin INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Curso(Codigo, Nombre, Nivel, horaInicio,horaFin)
    VALUES (p_codigo, p_nombre, p_nivel, p_hinicio,p_hfin);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarCurso`(
    IN p_codigo VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_nivel VARCHAR(50),
    IN p_hinicio INT,
    IN p_hfin INT,
    IN p_id INT
)
BEGIN
    UPDATE Curso
    SET Codigo = p_codigo,
        Nombre = p_nombre,
        Nivel = p_nivel,
        horaInicio = p_hinicio,
        horaFin = p_hfin
    WHERE idCurso = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarCurso`(
    IN p_id INT
)
BEGIN
    DELETE FROM Curso
    WHERE idCurso = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarCursoPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Curso
    WHERE idCurso = p_id;
END//

CREATE DEFINER=`admin`@`%` PROCEDURE `buscarCursoPorNivel`(
    IN p_nivel INT
)
BEGIN
    SELECT * FROM Curso
    WHERE Nivel = p_nivel;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarCursos`()
BEGIN
    SELECT * FROM Curso;
END//
