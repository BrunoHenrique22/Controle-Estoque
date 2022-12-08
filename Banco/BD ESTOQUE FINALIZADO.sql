/**
*PROJETO DE UM SISTEMA PARA GESTÃO DE ESTOQUE
*@author Bruno Henrique 
*@version 1.3
*/ 

create database dbestoque;

use dbestoque;


-- unique não permite valores duplicados


create table usuarios (
id int primary key auto_increment,
usuario varchar (50) not null,
login varchar (20) not null unique,
senha varchar (250) not null ,
perfil varchar(50) not null
);

describe usuarios;
drop table usuarios;

/******************** CRUD**************/

-- CREATE (inserir 5 usuarios)
insert into usuarios (usuario,login,senha,perfil)
values ('Hayashii','haya',md5('123@senac'),'user');

insert into usuarios (usuario,login,senha,perfil)
values ('BrunoSO7','sO7',md5('123@senac'),'user');

insert into usuarios (usuario,login,senha,perfil)
values ('Stolen','stolen','123@senac');

insert into usuarios (usuario,login,senha,perfil)
values ('Colono','colono','123@senac');

insert into usuarios (usuario,login,senha,perfil)
values ('GabeMoura','gabe','123@senac');

-- inserindo uma senha criptografada
insert into usuarios (usuario,login,senha,perfil)
values ('Indio','indio',md5('123@senac'), 'admin');




-- Read1 (Selecionar todos os usuários)
select * from usuarios;

-- Read 2 (Selecionar um usuário específico por id)
select * from usuarios where login = 'indio';

-- login (usuario e senha correspondente)
select * from usuarios where login='haya' and senha= md5('123@senac'); 

-- Updtade (alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Admin', login = 'indio', senha =md5('123@senac') where id=1;

-- Delete (excluir em usuário especifífico)
delete from usuarios where id = 3;

-- Gerar a documentação - Modelo ER (engeharia reversa) 



create table fornecedores (
idFor int primary key auto_increment,
razãoSocial varchar(50) not null,
fantasia varchar(50) not null,
cnpj varchar(20) unique, 
ie varchar(20) unique,
cep varchar(10) not null,
endereco varchar(50) not null,
numero varchar (6) not null,
complemento varchar (50) ,
bairro varchar (50) not null,
cidade varchar (50) not null,
uf char(2) not null, -- char é uma string de caracteres de comprimento fixo, ou seja que nunca vai variar são apenas aquelas letras ou numeros
nomecontato varchar(30) not null,
fone varchar (15) not null,
whatsapp varchar (15),
email varchar (50) not null,
site varchar (50),
obs varchar (250) 
);

-- CREATE (inserir 5 usuarios)
insert into fornecedores (razãoSocial,fantasia,cnpj,ie,cep,endereco,numero,complemento,bairro,cidade,uf,nomecontato,fone,whatsapp,email,site,obs)
values ('Instictindustries','InstictInc','21374342301','12848463451209','03308020','Av.Martinopolis','22','perto da igreja','chile','São Paulo','SP','Hayashii','119489-12441','119489-12441','instict@gmail.com','www.sitedaif.com.br','salve carai');

insert into fornecedores (razãoSocial,fantasia,cep,endereco,numero,bairro,cidade,uf,nomecontato,fone,email)
values ('Indio Company','IndioLTDA','03308020','Av.Amazonas','063','Mata','Manaus','AM','Cacique','117089-12441','indio@gmail.com');

insert into fornecedores (razãoSocial,fantasia,cep,endereco,numero,bairro,cidade,uf,nomecontato,fone,email)
values ('Imperial Fabric ','ImperialLTD','03308020','Av.Martinopolis','567','Colombo','Colombia','CB','Hayashii','11948912443331','imperial@gmail.com');

insert into fornecedores (razãoSocial,fantasia,cep,endereco,numero,bairro,cidade,uf,nomecontato,fone,email)
values ('Sony Playstation jogos','Playstation','03308020','Av.	Japão','111','Japa','Japatown','JP','Kishimoto','119489-12441','playstation@gmail.com');

insert into fornecedores (razãoSocial,fantasia,cep,endereco,numero,bairro,cidade,uf,nomecontato,fone,email)
values ('Microsoft Distribuição Eletronica','03308020','Microsoft','Av.Estados Unidos','999','USA','NovaYork','CA','Gates','119489-12441','microsoft@gmail.com');

insert into fornecedores (razãoSocial,fantasia,cep,endereco,numero,bairro,cidade,uf,nomecontato,fone,email)
values ('Microsoft Distribuição Eletronica','03308020','MaACCO','Av.Estados Unidos','999','USA','NovaYork','CA','Gates','119489-12441','microsoft@gmail.com');

select * from fornecedores;

-- pesquisa avançcada filtrando letras de uma tablea pra pegar todos os nomes que começam com letras iguas
select idFor as ID, fantasia as Fornecedor, fone, nomeContato as contato from fornecedores where fantasia like ('i%'); 

drop table fornecedores;

select * from fornecedores;

describe fornecedores;

alter table fornecedores add column cep varchar(10) not null;

update fornecedores set fantasia = 'Windows' where idFor=6;

delete from fornecedores where idFor = 10;


create table clientes (
id int primary key auto_increment,
nome varchar(30) not null,
cpf varchar(20) unique, 
fone varchar (15) not null,
whatsapp varchar (15),
cep varchar(10) not null,
email varchar (50) not null,
endereco varchar(50) not null,
numero varchar (6) not null,
complemento varchar (50) ,
bairro varchar (50) not null,
cidade varchar (50) not null,
uf char(2) not null,
obs varchar (250) 
);


-- CREATE (inserir 5 usuarios)
insert into clientes (nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf,obs)
values ('Hayashii','8492910','22224444','03308020','76814138','instict@gmail.com','Av.Martinopolis','22','perto da igreja','chile','São Paulo','SP','salve carai');

insert into clientes ( nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf,obs)
values ('Bruninho','35462734','22226666','480179295','76814138','dpp2@gmail.com','Av.Kino Der Toten','2222','perto do Teatro','Alemanha','Amsterdan','AL','Zombies');

insert into clientes ( nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf,obs)
values ('Colono','1985138','22228888','7501924566','76814138','colono@gmail.com','Av.Chimarrão','30','perto do Sul','Sul','Santa Catarina','SC','Futebolllllllllllllllll');

insert into clientes ( nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf,obs)
values ('Stolen ','189476623','99999999','99999999','76814138','stolen@gmail.com','Av.Monstro','9','perto do Wolrd','Moon','Mooncity','MN','El Monstro');

insert into clientes ( nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf,obs)
values ('FunkyBlackCat ','7025547','10727015','35790184','138905678','funkyn@gmail.com','Av.Josney','4','perto do Gato preto Bar','Orlando','Canada','CN','Itenssssssss');



select * from clientes;

describe clientes;

delete from clientes where id = 4;


/*
Relacionamento de tabelas 1 - N  (um para muitos)
Chave Estrangeira (FK) - (PK)
*/ 


-- timestamp default current_timestamp (obtém automaticamente a data e hora)
-- date (tipo de dados relacionados a data) 
-- decimal (10,2) (tipo de dados relacionados a números não inteiros)
-- decimal (10,2) (10 digitos com 2 casas decimais) 
-- IdFor( have estrangeira) usar msm nome e tipo de dados da chave primaria (PK) da tabela pai
-- Em numero que forem colocados na tabela por aq não vai aspas simples ('') 
-- PK pai FK filho

create table produtos (
codigo int primary key auto_increment,
barcode varchar (255) unique,
produto varchar(50) not null,
Descricao varchar(255),
fabricante varchar (50) not null,
datacad timestamp default current_timestamp,
dataval date,
estoque int not null,
estoquemin int not null,
unidade char(2),
localizacao varchar(50) not null, 
custo decimal (10,2) not null, 
lucro decimal (10,2),
idFor int not null, -- é pra trazer os forneceodores q já uma tabela pronta, para trazer suas informações que já estão lá e não precisar recadastrar os fornecedores
foreign key(idFor) references fornecedores (idFor) -- essa linha  relaciona a tabela anterior que no caso é os forncedores para que ele traga os dados que está lá para cá, aq que rola o link entre as tabelas.
); 

describe produtos;

drop table produtos;

select * from produtos;
delete from produtos where codigo = 9;

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor) 
values ('111111','Caneta BIC azul','Caneta BIC azul,ponta fina CX 50','BIC','20231122',20,5,'CX','Prateleira 2',38.50,20,1);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('222222','Lápis Fabric Castel',' Caixa de lápis de cores padrão da Fabric Castel','Fabric Castel','20340809',50,1,'PX','Prateleira 3',45,100,1);
 
 insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('333333','Notebook Gamer Dell G15',' Notebook Gamer Dell G15 com RGB','Dell','21500124',15,5,'GG','Setor 22',6000,75,2);

 insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('444444','PC Gamer Dell ',' PC Gamer Dell AlienWare com RGB','Dell','20931225',5,5,'GG','Setor 21',8000,85,2);

 insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('555555','Album Hail to The King  ','Album "Hail to The King" Do Avenged Sevenfold','Warner Records','20250101',100,80,'MM','Stand 1',40,100,3);

 insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('666666','Album Fear Of The Dark ','Album "Fear Of The Dark" Do Iron Maiden','Sony Records','20240303',70,40,'MM','Stand 2',35,66.6,3);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('777777','Moletom JapanDragon ','Moletom Preto com detalhes de dragões na manga em vermelho ','BrutalKill','20260918',15,30,'PP','Conjuto 4',180,65,4);


insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor)
values ('888888','Corta Vento Rexpeita preto Simples ','Corta Vento preto simples com detalhes da marca Rexpeita ','Rexpeita','20210527',25,50,'PP','Conjuto 5',300,96.4,4);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,idFor) 
values ('32902','Teclado Positivo','Teclado Positivo MODELOK2801','Positivo','20230804',10,7,'UN','Prateleira 5',22.35,10,2);

/*
Relatórios (Select Especial)
data_format ('%d/%m/%Y) (dd/mm/aaaa) serve para formatar a data e deixar no padrão do brasil sendo o Y grande são 4 digitos
datediff() ele serve pra calcular a difereça da datas com a data de hoje ou do dia e serve pra fazer o calculo com a data de validade
curdate()) ele pega a data que está o banco de dados, ou seja a data do servidor
*/

-- relatório 1 ( unificar produtos com fornecedores)
-- produtos.idFor (FK) fornecedores.idFor (PK)
 select * from produtos inner join fornecedores on produtos.idFor = fornecedores.idFor;
 
 -- relatório 2 ( fornecedor relacionado ao produto)
 select produtos.codigo ,produtos.produto,fornecedores.fantasia from produtos inner join fornecedores on produtos.idFor = fornecedores.idFor;
 
 -- relatório 3 (Inventário do estoque)
 select sum(estoque * custo) from produtos; 
 
 -- relatório 4 (Calcular o preço de vendas)
 select codigo, produto, custo,(custo + (custo * lucro)/100) as venda from produtos;
 
 -- relatório 5 (reposição de estoque)
 select codigo as Código, produto, 
 date_format(dataval,'%d/%m/%y') as data_validade, estoque, estoquemin as estoque_mínimo from produtos where estoque < estoquemin;
 
 -- Relatório 5.1 (versão impressa)
 select codigo as Código, produto, 
 date_format(dataval,'%d/%m/%y'), estoque, estoquemin from produtos where estoque < estoquemin;
 
 -- relatório 6 (produtos vencidos)
 select codigo, produto, localizacao, date_format(dataval,'%d/%m/%y'), datediff(dataval,curdate()) from produtos where datediff(dataval,curdate()) < 0;