--============================================================================INSERT NECESSARIO
--ATUALIZADO EM 25/09/2016

--insert na table tb_genero
insert into TB_GENERO values (1,'FEMININO');
insert into TB_GENERO values (2,'MASCULINO');
insert into TB_GENERO values (3,'OUTRO');

--insert na table tb_tipo_usuario
insert into tb_usuario_tipo values (1,'Administrativo', current_date);
insert into tb_usuario_tipo values (2,'Cliente', current_date);
insert into tb_usuario_tipo values (3,'Fornecedor', current_date);

--insert na table tb_categoria
insert into tb_categoria values (1, 'Smartphone', 1, current_date);
insert into tb_categoria values (2, 'Computador', 1, current_date);
insert into tb_categoria values (3, 'Tablet', 1, current_date);
insert into tb_categoria values (4, 'Video Game', 1, current_date);

--insert na table tb_formato
insert into tb_formato values (1, 'Caixa', 1, current_date);
insert into tb_formato values (2, 'Envelope', 1, current_date);