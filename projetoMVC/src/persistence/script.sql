#javascript (node) ->  mongodb
mysql -u root -pcoti
create database BDJSF;
use BDJSF;
#da morte
drop table usuario;
create table usuario(idUsuario int primary key auto_increment,
 nome varchar (50),
 email varchar (50) unique,
 senha varchar (250)
);
set @chave="cotiinformatica.com.br@mysecret1=1+1";

 insert into usuario values (null, 'glauce',
  'glauce@gmail.com', md5(concat('123',@chave)));
#123cotiinformatica.com.br@mysecret1=1+1
delete from usuario;
 insert into usuario values (null, 'glauce',
  'glauce@gmail.com',
    concat( md5(concat('java',@chave)),
             md5(concat('senha',@chave)),
            md5(concat('abc',@chave)),
            md5(concat('fechou',@chave))
      ) 
 );
 
 
 delete from usuario;
  insert into usuario values (null, 'glauce',
  'glauce@gmail.com', md5(concat('123',@chave))  
 );
 
 
 
 
 
 
 

















