create database if not exists client_db;
use client_db;

create table if not exists clients(id_cl int not null, Nom varchar(100) not null, Prenom varchar(100) not null, Email varchar(100) not null, Telephone varchar(50) not null, primary key (id_cl)); 
create table if not exists operations(id_op int not null, Libelle varchar(50) not null, primary key(id_op));
create table if not exists ligneOperations(id_lp int not null, id_operation int not null, id_client int not null, statut varchar(50) not null, assignation varchar(50), primary key(id_lp), 
	constraint fk_client foreign key (id_client) references clients(id_cl) on delete cascade, constraint fk_operation foreign key (id_operation) references operations(id_op) ON delete cascade);
