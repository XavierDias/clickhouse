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

create table role
(
  idrole int primary key auto_increment,
  name varchar (32) not null
);

create table privilege
(
  idprivilege int primary key auto_increment,
  name varchar (32) not null
);

create table users_roles
(
  idusersroles int primary key auto_increment,
  fk_idusuario int null,
  fk_role int null,
  foreign key (fk_idusuario) references usuario(idusuario),
  foreign key (fk_role) references role(idrole)
);

create table roles_privileges
(
  idrolesprivileges int primary key auto_increment,
  fk_role int null,
  fk_privilege int null,
  foreign key (fk_role) references role(idrole),
  foreign key (fk_privilege) references privilege(idprivilege)
);

create table usuario_anuncio
(
  idusuarioanuncio int primary key auto_increment,
  fk_idusuario int null,
  fk_idanuncio int null,
  foreign key (fk_idusuario) references usuario(idusuario),
  foreign key (fk_idanuncio) references anuncio(idanuncio)
);
