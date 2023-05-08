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

select * from triangulo;