insert into usuario (nome, email, telefone, senha)
values('Maria', 'maria@gmail.com', '67998975625', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');
insert into usuario (nome, email, telefone, senha)
values('Jennifer', 'jennifer@gmail.com', '67992254787', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');
insert into usuario (nome, email, telefone, senha)
values('Cezar', 'cezar@gmail.com', '67999283545', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');
insert into usuario (nome, email, telefone, senha)
values('Renato', 'renato@gmail.com', '67988471221', '$2a$11$rVOZ69lfdFU49oPdgDtGnOb0I9XJ6StWv3XmEN0RajNq1MTpIkFOa');

insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Aluguel', 'Comercial', 'Campo Grande', 'MS', 'Av. Afonso Pena', 'Royal Park', 20000, 15000, 'Apartamento com ótima localização em Campo Grande', 560000, 1);
insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Venda', 'Residencial', 'Campo Grande', 'MS', 'Rua da Libra', 'TV Morena', 108000, 100000, 'Compacta e completa', 1000000, 2);
insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Venda', 'Residencial', 'Campo Grande', 'MS', 'Rua Ataulfo Alves', 'TV Morena', 480000, 320000, 'Casa com excelente varanda', 700000, 3);
insert into anuncio (tipoanuncio, tipoimovel, cidade, estado, rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario)
values('Venda', 'Rural', 'Campo Grande', 'MS', 'Rua Bom Retiro', 'Chácara das Mansões', 261000, 200000, 'Chácara ideal para família', 750000, 4);