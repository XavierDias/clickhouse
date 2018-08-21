create table usuario
(
  idusuario integer primary key auto_increment,
  nome varchar (32) not null,
  email varchar (32) not null,
  telefone varchar (11) not null,
  senha varchar (32) not null
);

create table anuncio
(
  idanuncio int primary key auto_increment,
  tipoanuncio varchar (32) not null,
  cidade varchar (32) not null,
  estado char (2) not null,
  rua varchar (32) not null,
  bairro varchar (32) not null,
  areatotal double not null,
  areaconstruida double not null,
  descricao varchar (255) not null,
  valor double not null,
  fk_idusuario int not null,
  foreign key (fk_idusuario) references usuario(idusuario) on update cascade
);