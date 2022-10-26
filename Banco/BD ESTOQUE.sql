/**
*PROJETO DE UM SISTEMA PARA GESTÃO DE ESTOQUE
*@author Bruno Henrique 
*@version 1.0
*/ 

create database dbestoque;

use dbestoque;

create table usuarios (
id int primary key auto_increment,
usuario varchar (50) not null,
login varchar (20) not null,
senha varchar (250) not null 
);

describe usuarios;

/******************** CRUD**************/

-- CREATE (inserir 5 usuarios)
insert into usuarios (usuario,login,senha)
values ('Hayashii','haya','123@senac');

insert into usuarios (usuario,login,senha)
values ('BrunoSO7','sO7','123@senac');

insert into usuarios (usuario,login,senha)
values ('Stolen','stolen','123@senac');

insert into usuarios (usuario,login,senha)
values ('Colono','colono','123@senac');

insert into usuarios (usuario,login,senha)
values ('GabeMoura','gabe','123@senac');

-- Read1 (Selecionar todos os usuários)
select * from usuarios;

-- Read 2 (Selecionar um usuário específico por id)
select * from usuarios where id = 1;

-- Updtade (alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Stolen', login = 'stolen', senha = '123@senac' where id=3;

-- Delete (excluir em usuário especifífico)
delete from usuarios where id = 3;

-- Gerar a documentação - Modelo ER (engeharia reversa) 

 