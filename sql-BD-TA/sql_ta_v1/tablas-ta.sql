DROP TABLE IF EXISTS Sesion;
DROP TABLE IF EXISTS TipoSesion;
DROP TABLE IF EXISTS Alumno;
DROP TABLE IF EXISTS Profesor;
DROP TABLE IF EXISTS Curso;
DROP TABLE IF EXISTS Administrador;
DROP TABLE IF EXISTS Sede;
DROP TABLE IF EXISTS Academia;

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

CREATE TABLE Administrador (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    TipoUsuario CHAR(1),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    DNI VARCHAR(50),
    Email VARCHAR(100),
    fechaNacimiento DATE
);

CREATE TABLE Alumno (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    TipoUsuario CHAR(1),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    DNI VARCHAR(50),
    Email VARCHAR(100),
    fechaNacimiento DATE,
    carrera VARCHAR(50)
);

CREATE TABLE Curso (
    idCurso INT AUTO_INCREMENT PRIMARY KEY,
    Codigo VARCHAR(50),
    Nombre VARCHAR(50),
    Nivel INT,
	horaInicio INT,
    horaFin INT
);

CREATE TABLE Profesor (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    TipoUsuario CHAR(1),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    DNI VARCHAR(50),
    Email VARCHAR(100),
    fechaNacimiento DATE,
    idCurso INT,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);

CREATE TABLE TipoSesion (
    idModalidad INT AUTO_INCREMENT PRIMARY KEY,
    Precio DOUBLE,
    Tipo VARCHAR(50)
);

CREATE TABLE Sesion (
    idSesion INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    Modalidad VARCHAR(30),
    idCurso INT,
    idAlumno INT,
    idTipoSesion INT,
    idProfesor INT,
    idSede INT,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso),
    FOREIGN KEY (idAlumno) REFERENCES Alumno(idUsuario),
    FOREIGN KEY (idTipoSesion) REFERENCES TipoSesion(idModalidad),
    FOREIGN KEY (idSede) REFERENCES Sede(idSede),
    FOREIGN KEY (idProfesor) REFERENCES Profesor(idUsuario)
);

select * from Alumno;
