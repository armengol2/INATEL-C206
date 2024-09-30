DROP DATABASE IF EXISTS DADOS;
CREATE DATABASE DADOS;
USE DADOS;

CREATE TABLE sobrevivente(
idSobrevivente int not null auto_increment primary key,
nome varchar(45) not null,
idade int not null,
descricao varchar(100) not null,
forca int not null,
agilidade int not null,
resistencia int not null,
inteligencia int not null,
nivelDeHablidade int not null
);

CREATE TABLE arma(
idArma int not null auto_increment primary key,
nome varchar(45) not null,
estilo varchar(45) not null,
descricao varchar(45) not null,
ataque int not null
);