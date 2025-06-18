DROP TABLE IF EXISTS Sesion;
DROP TABLE IF EXISTS TipoSesion;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Curso;
DROP TABLE IF EXISTS Sede;
DROP TABLE IF EXISTS Academia;
DROP TABLE IF EXISTS Voucher;

CREATE TABLE Academia (
    idAcademia INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    RUC VARCHAR(50)
);

CREATE TABLE Sede (
    idSede INT AUTO_INCREMENT PRIMARY KEY,
    Direccion VARCHAR(50),
    Distrito VARCHAR(50),
    idAcademia INT,
    FOREIGN KEY (idAcademia) REFERENCES Academia(idAcademia)
);

CREATE TABLE Curso (
    idCurso INT AUTO_INCREMENT PRIMARY KEY,
    Codigo VARCHAR(50),
    Nombre VARCHAR(50),
    Nivel INT,
	horaInicio INT,
    horaFin INT
);



CREATE TABLE Usuario(
	idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    TipoUsuario CHAR(1),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    DNI VARCHAR(50),
    Email VARCHAR(100),
    password VARCHAR(100),
    carrera VARCHAR (50),
    fechaNacimiento DATE,
    idCurso INT,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);

CREATE TABLE TipoSesion (
    idModalidad INT AUTO_INCREMENT PRIMARY KEY,
    Precio DOUBLE,
    Tipo VARCHAR(50)
);

CREATE TABLE Voucher (
	idVoucher INT AUTO_INCREMENT PRIMARY KEY,
    codigoOperacion VARCHAR (50),
    monto DOUBLE,
    fecha DATE,
    idSesion int
);

CREATE TABLE Sesion (
    idSesion INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    Modalidad VARCHAR(30),
    estado boolean default false,
    idCurso INT,
    idAlumno INT,
    idTipoSesion INT,
    idProfesor INT,
    idSede INT,
    idVoucher INT,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso),
    FOREIGN KEY (idAlumno) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idTipoSesion) REFERENCES TipoSesion(idModalidad),
    FOREIGN KEY (idSede) REFERENCES Sede(idSede),
    FOREIGN KEY (idProfesor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idVoucher) REFERENCES Voucher(idVoucher)
);