create table usuario
(
  idusuario int auto_increment,
  nome varchar (255) not null,
  email varchar (255) not null,
  telefone varchar (11) not null,
  senha varchar (15) not null
  primary key (idusuario)
);