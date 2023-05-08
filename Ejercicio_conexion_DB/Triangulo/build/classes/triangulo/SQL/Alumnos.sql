DROP DATABASE IF EXISTS alumnos_db;
DROP TABLE IF EXISTS alumnos;

CREATE DATABASE alumnos_db;
USE alumnos_db;

CREATE TABLE alumnos(

    	id_alumno int NOT NULL AUTO_INCREMENT,
    	nombre varchar(50) NOT NULL,
    	apellido varchar(100) NOT NULL,
    	telefono int(9) NOT NULL,
    	sexo ENUM('H','M') NOT NULL,
    	PRIMARY KEY (id_alumno)
);

INSERT INTO alumnos(nombre,apellido,telefono,sexo) VALUES('Marcos','Perez',678874152,'h');
INSERT INTO alumnos(nombre,apellido,telefono,sexo) VALUES('José','Gonzalez',674158230,'h');
INSERT INTO alumnos(nombre,apellido,telefono,sexo) VALUES('Ana','Fernandez',680012654,'m');
INSERT INTO alumnos(nombre,apellido,telefono,sexo) VALUES('Luisa','Sierra',620139725,'m');


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnos_sel`(id_alumnoP INT)
BEGIN
	IF(id_alumnoP=-1) THEN
		SELECT * FROM alumnos;
    ELSE
    	SELECT * FROM alumnos where alumnos.id_alumno=id_alumnoP;
    END IF;
END$$
DELIMITER ;

