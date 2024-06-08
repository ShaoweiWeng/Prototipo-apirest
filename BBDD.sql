CREATE USER 'admin'@'localhost' IDENTIFIED BY 'asdf1234';
GRANT ALL ON alumnos_matriculados.* TO 'admin'@'localhost';

create database alumnos_matriculados;
use alumnos_matriculados;

CREATE TABLE Alumno (
  id_alumno INT UNIQUE NOT NULL,
  nombre VARCHAR(100),
  apellido1 VARCHAR(100),
  apellido2 VARCHAR(100),
  email VARCHAR(100),
  PRIMARY KEY (id_empleado));
  
  