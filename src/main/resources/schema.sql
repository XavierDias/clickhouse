create table usuario
(
  idusuario int primary key auto_increment,
  nome varchar (32) not null,
  email varchar (32) not null unique,
  telefone varchar (11) not null,
  senha varchar (255) not null
);

create table anuncio
(
  idanuncio int primary key auto_increment,
  tipoanuncio varchar (32) not null,
  tipoimovel varchar (32) not null,
  cidade varchar (32) not null,
  estado char (2) not null,
  rua varchar (32) not null,
  bairro varchar (32) not null,
  areatotal double not null,
  areaconstruida double not null,
  descricao varchar (255) not null,
  valor double not null,
  fk_idusuario int null,
  foreign key (fk_idusuario) references usuario(idusuario)
);

create table usuario_anuncio
(
  idusuarioanuncio int primary key auto_increment,
  fk_idusuario int null,
  fk_idanuncio int null,
  foreign key (fk_idusuario) references usuario(idusuario),
  foreign key (fk_idanuncio) references anuncio(idanuncio)
);

