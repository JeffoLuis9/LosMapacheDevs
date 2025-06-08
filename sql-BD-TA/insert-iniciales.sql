/*INSERT INTO Sesion () VALUES ();*/

/*Tipo sesion*/
INSERT INTO TipoSesion(Precio,Tipo) VALUES (29.90 , "Individual");
INSERT INTO TipoSesion(Precio,Tipo) VALUES (9.90 , "Grupal");
INSERT INTO TipoSesion(Precio,Tipo) VALUES (5.90 , "Marathon");

/*Id alumno*/
INSERT INTO Alumno (Nombre,Apellido,DNI,Email,fechaNacimiento,carrera)VALUES ("David","Cutisaca","12345678","davidCutisaca2000@gmail.com",'2000-01-01',"Ingenieria Informatica" );

INSERT INTO Alumno (Nombre,Apellido,DNI,Email,fechaNacimiento,carrera)VALUES ("Marcelo","Hernandez","87654321","marcelo2000@gmail.com",'2000-01-01',"Ingenieria Industrial" );

INSERT INTO Alumno (Nombre,Apellido,DNI,Email,fechaNacimiento,carrera)VALUES ("Lucia","Onetto","12344321","lucia1234@gmail.com",'2000-01-01',"Ingenieria Civil" );

/*Curso*/
INSERT INTO Curso(Codigo, Nombre, Nivel, horaInicio,horaFin) VALUES ("CT1","Curso 1 SQL",1,10,12);
INSERT INTO Curso(Codigo, Nombre, Nivel, horaInicio,horaFin) VALUES ("CT2","Curso 2 SQL",1,8,10);
INSERT INTO Curso(Codigo, Nombre, Nivel, horaInicio,horaFin) VALUES ("CT3","Curso 3 SQL",2,12,14);


/*Profesor*/
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("Jorge", "Robles", "11111111", "JorgeRa@prueba.com", '2000-01-01', 1);
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("Carlos", "Guerrero", "22222222", "Carlos@prueba.com", '2000-01-01', 2);
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("Rafael", "Martinez", "33333333", "Rafael@prueba.com", '2000-01-01', 2);
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("Enrique", "Vilchez", "44444444", "Enrique@prueba.com", '2000-01-01', 3);
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("William", "Riveros", "55555555", "William@prueba.com", '2000-01-01', 3);
INSERT INTO Profesor (Nombre, Apellido, DNI, Email, fechaNacimiento, idCurso)
    VALUES ("Ana", "Ramirez", "66666666", "Ana@prueba.com", '2000-01-01', 3);


/*Id academia 1*/
INSERT INTO Academia(Nombre,RUC) VALUES ("HOOKE","12345678912");

/*Id sede 1*/
INSERT INTO Sede(Direccion,Distrito,idAcademia) VALUES ("Av.PruebaTest1","Distrito prueba 1",1);
INSERT INTO Sede(Direccion,Distrito,idAcademia) VALUES ("Av.PruebaTest2","Distrito prueba 2",1);
INSERT INTO Sede(Direccion,Distrito,idAcademia) VALUES ("Av.PruebaTest3","Distrito prueba 3",1); 
