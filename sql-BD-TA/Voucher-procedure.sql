drop procedure IF EXISTS insertarVoucher;
drop procedure IF EXISTS modificarVoucher;
drop procedure IF EXISTS eliminarVoucher;
drop procedure IF EXISTS buscarVoucherPorId;
drop procedure IF EXISTS buscarVoucherPorIdSesion;
drop procedure IF EXISTS listarVouchers;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarVoucher`(
    IN p_fecha DATE,
    IN p_codigoOperacion VARCHAR(50),
    IN p_monto DOUBLE,
    IN p_idsesion INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO Voucher(codigoOperacion,monto,fecha,idSesion)
    VALUES (p_codigoOperacion,p_monto,p_fecha,p_idsesion);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarVoucher`(
	IN p_fecha DATE,
    IN p_codigoOperacion VARCHAR(50),
    IN p_monto DOUBLE,
    IN p_idsesion INT,
    IN p_id INT
)
BEGIN
    UPDATE Voucher
    SET fecha = p_fecha,
		codigoOperacion = p_codigoOperacion,
        monto = p_monto,
        idSesion  = p_idsesion
    WHERE idVoucher = p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarVoucherPorId`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Voucher
    WHERE idVoucher= p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `buscarVoucherPorIdSesion`(
    IN p_id INT
)
BEGIN
    SELECT * FROM Voucher
    WHERE idSesion= p_id;
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `eliminarVoucher`(
    IN p_id INT
)
BEGIN
    DELETE FROM Voucher
    WHERE idVoucher= p_id;
END//


DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `listarVouchers`()
BEGIN
    SELECT * FROM Voucher;
END//