-- crear base de datos

show databases;

-- bases de datos

drop database if exists universidad;
create database universidad;
use universidad;
SET GLOBAL time_zone = '-3:00';

-- tablas

create table curso(
	id int,
	nombre varchar(40),
    creditos int,
    departamento varchar(20),
    primary key (id)
);

create table profesor(
	id int primary key,
    nombre varchar(30),
    apellido varchar(30),
    sueldo int check (sueldo > 0),
    departamento varchar(30),
    cuidad varchar(30)
    
);


create table estudiante(
	id int primary key,
    nombre varchar(30),
    apellido varchar(30),
    fecha_nacimiento timestamp not null,
    total_creditos int
    
);








-- ingresar datos
insert into curso(id, nombre, departamento,creditos) values (1,'Lenguajes de Programacion', "Computacion", 3);
insert into curso(id, nombre, departamento,creditos) values (2,'Biologia', 'Ciencias 1', 3);
insert into curso(id, nombre, departamento,creditos) values (3,'Quimica', 'Generica', 4);
insert into curso(id, nombre, departamento,creditos) values (4,'Ing Civil', 'Calculo', 2);
insert into curso(id, nombre, departamento,creditos) values (5,'Filosofia', 'Fisica', 3);
insert into curso(id, nombre, departamento,creditos) values (6,'Fisica', 'Genetica', 9);




-- ingresar profesores

insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(1, 'Martin', 'Flores', 55000, 'Computacion',"San Jose");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(2, 'Allan', 'Cascante', 55000, 'Computacion',"Cartago");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(3, 'Albert', 'Einstein', 75000, 'Fisica',"Limon");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(4, 'Marco', 'Calvo', 70000, 'Quimica',"Heredia");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(5, 'Jose', 'Herrera', 65000, 'Filosofia',"Cartago");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(6, 'Carolina', 'Lizano', 65000, 'Biologia',"Cartago");
insert into profesor(id, nombre, apellido, sueldo, departamento,cuidad) values(7, 'Raquel', 'Rodriguez', 65000, 'Biologia',"Cartago");


-- ingresa estudiantes

insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(1, 'Steven', 'Alvarado', "2000-08-08 09:00:00", 8);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(2, 'Lermith', 'Biarreta', "2000-08-08 09:00:00", 8);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(3, 'Maria', 'Biarreta', "2000-08-08 09:00:00", 8);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(4, 'Valeria', 'Calderon',  "2000-08-08 09:00:00", 9);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(5, 'Sebastian', 'Campos', "2000-08-08 09:00:00", 10);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(6, 'Josue', 'Castro',  "2000-08-08 09:00:00", 11);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(7, 'Susana', 'Cen', "2000-08-08 09:00:00", 16);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(8, 'Johan', 'Echeverria',  "2000-08-08 09:00:00", 3);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(9, 'Junior', 'Herrera', "2000-08-08 09:00:00", 8);
insert into estudiante(id, nombre, apellido,fecha_nacimiento, total_creditos) values(10, 'Alejandro', 'Loaiza', "2000-08-08 09:00:00", 4);





select * from curso;
select * from profesor;
select * from estudiante;





