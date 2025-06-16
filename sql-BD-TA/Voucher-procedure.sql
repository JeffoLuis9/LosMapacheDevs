drop procedure IF EXISTS insertarVoucher;
drop procedure IF EXISTS modificarVoucher;
drop procedure IF EXISTS eliminarVoucher;
drop procedure IF EXISTS buscarVoucherPorId;
drop procedure IF EXISTS listarVouchers;

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `insertarVoucher`(
    IN p_fecha DATE,
    IN p_codigoOperacion VARCHAR(50),
    IN p_monto DOUBLE,
    OUT p_id INT
)
BEGIN
    INSERT INTO Voucher(codigoOperacion,monto,fecha)
    VALUES (p_codigoOperacion,p_monto,p_fecha);
    
    SET p_id = LAST_INSERT_ID();
END//

DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `modificarVoucher`(
	IN p_fecha DATE,
    IN p_codigoOperacion VARCHAR(50),
    IN p_monto DOUBLE,
    IN p_id INT
)
BEGIN
    UPDATE Voucher
    SET fecha = p_fecha,
		codigoOperacion = p_codigoOperacion,
        monto = p_monto
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