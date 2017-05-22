
--============================================================================CRIAÇÃO DO BANCO
--ATUALIZADO EM 25/09/2016
-- Gerado por Oracle SQL Developer Data Modeler 4.0.2.840
--   em:        2016-09-04 19:22:07 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g

--EM UM BANDO DE DADOS ORACLE, CRIAR AS TABELAS ABAIXO, NÃO SE ESQUECER DE PASSAR 
-- AS CONFIGURAÇÕES DO SEU BANCO ORACLE NA CLASSE CONEXAO.JAVA (localizada no pacote ecommerce.core.util, do projeto ecommerce-core)

CREATE TABLE tb_cliente_fisico
  (
    id_cli_fisico NUMBER (9) NOT NULL ,
    nome          VARCHAR2 (45 CHAR) NOT NULL ,
    cpf           VARCHAR2 (11 CHAR) NOT NULL ,
    dtnascimento	date not null,
    telefone      VARCHAR2 (11 CHAR) NOT NULL ,
    id_gen        NUMBER (9) NOT NULL ,
    id_end        NUMBER (9) NOT NULL ,
    id_usu        NUMBER (9) NOT NULL ,
    ativo         NUMBER (1) NOT NULL ,
    dt_cadastro   DATE NOT NULL
  ) ;
ALTER TABLE tb_cliente_fisico ADD CONSTRAINT id_cli_fisico_PK PRIMARY KEY ( id_cli_fisico ) ;
CREATE SEQUENCE seqid_cli_fisico;
--drop sequence seqid_cli_fisico;

CREATE TABLE tb_fornecedor
  (
    id_fornecedor   NUMBER (9) NOT NULL ,
    rzsocial        VARCHAR2 (100 CHAR) NOT NULL ,
    cnpj            VARCHAR2 (14 CHAR) NOT NULL ,
    email           VARCHAR2 (255 CHAR) NOT NULL ,
    telefone        VARCHAR2 (11 CHAR) NOT NULL ,
    id_end          NUMBER (9) NOT NULL ,
    ativo           NUMBER (1) NOT NULL ,
    dt_cadastro     DATE NOT NULL
  ) ;
ALTER TABLE tb_fornecedor ADD CONSTRAINT id_fornecedor_PK PRIMARY KEY ( id_fornecedor ) ;
CREATE SEQUENCE seqid_fornecedor;
--drop sequence seqid_fornecedor;

CREATE TABLE tb_endereco
  (
    id_end      NUMBER (9) NOT NULL ,
    cidade      VARCHAR2 (255 CHAR) NOT NULL ,
    estado      VARCHAR2 (255 CHAR) NOT NULL ,
    logradouro  VARCHAR2 (255 CHAR) NOT NULL ,
    numero      VARCHAR2 (255 CHAR) NOT NULL ,
    bairro      VARCHAR2 (255 CHAR) NOT NULL ,
    cep         VARCHAR2 (255 CHAR) NOT NULL ,
    complemento VARCHAR2 (255 CHAR) ,
	  ativo       NUMBER (1) NOT NULL ,
    dt_cadastro DATE NOT NULL
  ) ;
ALTER TABLE tb_endereco ADD CONSTRAINT id_end_PK PRIMARY KEY ( id_end ) ;
CREATE SEQUENCE seqid_end;
--drop sequence seqid_end;

CREATE TABLE tb_genero
  (
    id_gen NUMBER (9) NOT NULL ,
    genero VARCHAR2 (9 CHAR) NOT NULL
  ) ;
ALTER TABLE tb_genero ADD CONSTRAINT id_gen_PK PRIMARY KEY ( id_gen ) ;
CREATE SEQUENCE seqid_gen;
--drop sequence seqid_gen;

CREATE TABLE tb_usuario
  (
    id_usu      NUMBER (9) NOT NULL ,
    email       VARCHAR2 (255 CHAR) NOT NULL ,
    senha       CHAR (9 CHAR) NOT NULL ,
    id_usu_tipo NUMBER (9) NOT NULL ,
    ativo       NUMBER (1) NOT NULL ,
    dt_cadastro DATE NOT NULL
  ) ;
ALTER TABLE tb_usuario ADD CONSTRAINT id_usu_PK PRIMARY KEY ( id_usu ) ;
CREATE SEQUENCE seqid_usu;
--drop sequence seqid_usu;

CREATE TABLE tb_usuario_tipo
  (
    id_usu_tipo NUMBER (9) NOT NULL ,
    tipo        VARCHAR2 (23 CHAR) NOT NULL ,
    dt_cadastro DATE NOT NULL
  ) ;
ALTER TABLE tb_usuario_tipo ADD CONSTRAINT id_usu_tipo_PK PRIMARY KEY ( id_usu_tipo ) ;
CREATE SEQUENCE seqid_usu_tipo;
--drop sequence seqid_usu_tipo;

ALTER TABLE tb_cliente_fisico ADD CONSTRAINT tbcf_end_id_fk FOREIGN KEY ( id_end ) REFERENCES tb_endereco ( id_end ) ;
--alter table tb_cliente_fisico drop constraint tbcf_end_id_fk;
ALTER TABLE tb_cliente_fisico ADD CONSTRAINT tbcf_gen_id_fk FOREIGN KEY ( id_gen ) REFERENCES tb_genero ( id_gen ) ;
--alter table tb_cliente_fisico drop constraint tbcf_gen_id_fk;
ALTER TABLE tb_cliente_fisico ADD CONSTRAINT tbcf_usu_id_fk FOREIGN KEY ( id_usu ) REFERENCES tb_usuario ( id_usu ) ;
--alter table tb_cliente_fisico drop constraint tbcf_usu_id_fk;

ALTER TABLE tb_fornecedor ADD CONSTRAINT tbcj_end_id_fk FOREIGN KEY ( id_end ) REFERENCES tb_endereco ( id_end ) ;
--alter table tb_fornecedor drop constraint tbcj_end_id_fk;
--ALTER TABLE tb_fornecedor ADD CONSTRAINT tbcj_usu_id_fk FOREIGN KEY ( id_usu ) REFERENCES tb_usuario ( id_usu ) ;
--alter table tb_fornecedor drop constraint tbcj_usu_id_fk;

ALTER TABLE tb_usuario ADD CONSTRAINT tbu_usu_tipo_id_fk FOREIGN KEY ( id_usu_tipo ) REFERENCES tb_usuario_tipo ( id_usu_tipo ) ;
--alter table tb_cliente_fisico drop constraint tbu_usu_tipo_id_fk;




--PARA TABELA DE PRODUTOS

CREATE TABLE tb_produto
  (
    id_prod			NUMBER (9) NOT NULL ,
    nome			VARCHAR2 (45 CHAR) NOT NULL ,
    descricao		VARCHAR2 (45 CHAR) NOT NULL ,
    preco			NUMBER(9,2) NOT NULL ,
    qtde			NUMBER (9) NOT NULL,
    id_categoria	NUMBER (9) NOT NULL ,
    id_fornecedor 	NUMBER (9) NOT NULL ,
    peso        	NUMBER(9,2) NOT NULL ,
    comprimento     NUMBER(9,2) NOT NULL ,
    altura			NUMBER(9,2) NOT NULL ,
    largura			NUMBER(9,2) NOT NULL ,
    diametro		NUMBER(9,2) NOT NULL ,
    id_formato		NUMBER (9) NOT NULL ,
    ativo         NUMBER (1) NOT NULL ,
    dt_cadastro   DATE NOT NULL
  ) ;
ALTER TABLE tb_produto ADD CONSTRAINT tb_produto_PK PRIMARY KEY ( id_prod ) ;
CREATE SEQUENCE seqid_prod;
--drop sequence seqid_prod;

CREATE TABLE tb_categoria
  (
  	id_categoria	NUMBER (9) NOT NULL ,
  	categoria 		VARCHAR2 (45 CHAR) NOT NULL ,
  	ativo        	NUMBER (1) NOT NULL ,
    dt_cadastro  	DATE NOT NULL
  ) ;
ALTER TABLE tb_categoria ADD CONSTRAINT tb_categoria_PK PRIMARY KEY ( id_categoria ) ;
CREATE SEQUENCE seqid_categoria;
--drop sequence seqid_categoria;

CREATE TABLE tb_formato
  (
  	id_formato		NUMBER (9) NOT NULL ,
  	formato 		VARCHAR2 (45 CHAR) NOT NULL ,
  	ativo        	NUMBER (1) NOT NULL ,
    dt_cadastro  	DATE NOT NULL
  ) ;
ALTER TABLE tb_formato ADD CONSTRAINT tb_formato_PK PRIMARY KEY ( id_formato ) ;
CREATE SEQUENCE seqid_formato;
--drop sequence seqid_formato;

ALTER TABLE tb_produto ADD CONSTRAINT tbprod_for_id_fk FOREIGN KEY ( id_fornecedor ) REFERENCES tb_fornecedor ( id_fornecedor ) ;
--alter table tb_fornecedor drop constraint tbprod_for_id_fk;
ALTER TABLE tb_produto ADD CONSTRAINT tbprod_cat_id_fk FOREIGN KEY ( id_categoria ) REFERENCES tb_categoria ( id_categoria ) ;
--alter table tb_fornecedor drop constraint tbprod_cat_id_fk;
ALTER TABLE tb_produto ADD CONSTRAINT tbprod_formato_id_fk FOREIGN KEY ( id_formato ) REFERENCES tb_formato ( id_formato ) ;
--alter table tb_fornecedor drop constraint tbprod_formato_id_fk;