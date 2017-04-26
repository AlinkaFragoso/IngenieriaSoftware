/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open thid_usuarioe template in the editor.
 */
/**
 * Author:  alinka
 * Created: 2/04/2017
 */
drop database if exists QualiFood;

CREATE DATABASE QualiFood;
USE QualiFood;

create table if not exists Usuario_Ciencias(
	id_usuario serial primary key,
	nombre varchar(64) not null,
	apellido varchar(64) not null,
	nombre_usuario varchar(64) not null,
	correo varchar(64) not null,
	contrasenia varchar(64) not null
	) engine=InnoDB default charset=utf8;

create table if not exists Comentario(
	id_comentario serial primary key,
	comentario varchar(255) not null,
	fecha date not null,
	hora time not null,
	id_usuario bigint(10) unsigned not null,
	id_puesto bigint(10) unsigned not null
	) engine=InnoDB default charset=utf8;

create table if not exists Puesto(
	id_puesto serial primary key,
	nombre varchar(64) not null,
	numero int(2) not null,
	descripcion varchar(255) not null,
	latitud float (10),
	longitud float (10)
	) engine=InnoDB default charset=utf8;

create table if not exists Categoria(
	id_categoria serial primary key,
	nombre varchar(64) not null
	) engine=InnoDB default charset=utf8;

create table if not exists Calificacion(
	id_calificacion serial primary key,
	calificacion int(2) not null,
	id_usuario bigint(10) unsigned not null,
	id_puesto bigint(10) unsigned not null
	) engine=InnoDB default charset=utf8;

create table if not exists Puesto_Categoria(
	id_puesto_categoria serial primary key,
	id_puesto bigint(10) unsigned not null,
	id_categoria bigint(10) unsigned not null
	) engine=InnoDB default charset=utf8;



-- Definición de llaves foráneas.

ALTER TABLE Comentario ADD FOREIGN KEY (id_usuario) REFERENCES Usuario_Ciencias(id_usuario);
ALTER TABLE Comentario ADD FOREIGN KEY (id_puesto) REFERENCES Puesto(id_puesto);
ALTER TABLE Calificacion ADD FOREIGN KEY (id_usuario) REFERENCES Usuario_Ciencias(id_usuario);
ALTER TABLE Calificacion ADD FOREIGN KEY (id_puesto) REFERENCES Puesto(id_puesto);
ALTER TABLE Puesto_Categoria ADD FOREIGN KEY (id_puesto) REFERENCES Puesto(id_puesto);
ALTER TABLE Puesto_Categoria ADD FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria);
