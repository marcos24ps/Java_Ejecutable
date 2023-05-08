drop database if EXISTS bd_geometria;
create database bd_geometria;

use bd_geometria;


create table triangulo(

    id int not null auto_increment,
    base double not null,
    altura double not null,
    primary key(id)
);


insert into triangulo(base,altura) values(13.4,5.1);
insert into triangulo(base,altura) values(8.1,6.2);
insert into triangulo(base,altura) values(7.3,2.2);


DROP PROCEDURE IF EXISTS insertar; -- Si existe procedimiento, lo borro.

DELIMITER / -- Esto es para que no de el coñazo con los puntos y comas.
CREATE PROCEDURE insertar(baseP DOUBLE,alturaP DOUBLE) -- Procedimiento almacenado, es como una función, le paso la Base y la Altura.
BEGIN
	INSERT INTO triangulo(base,altura) values(baseP,alturaP); -- Inserto la base y la altura pasadas por parámetro.
	SELECT * FROM triangulo; -- Devuelvo todos los registros de la tabla.
END;