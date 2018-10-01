insert into usuario (nome, email, telefone, senha)
values('Roothery', 'roothery@gmail.com', '67992651815', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');

insert into usuario (nome, email, telefone, senha)
values('Everton', 'everton19.xavier@gmail.com', '67999131972', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');

insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Venda', 'Residencial', 'Campo Grande', 'MS', 'Rua Ataulfo Alves', 'TV Morena', 200000, 150000, 'Casa com bastante espaço', 1000000, 1);

insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Venda', 'Residencial', 'Campo Grande', 'MS', 'Rua João Ramalho', 'Vila Nossa Senhora das Graças', 150000, 150000, 'Casa com bastante espaço e quintal bonito', 1000000, 2);