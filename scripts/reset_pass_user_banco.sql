-- para evitar do password do banco expirar rodar no sqlplus
alter profile default limit password_life_time unlimited;

--verificar as contas do banco
select username from dba_users;

-- identificado o user a ser alterado rodar
alter user <username> identified by <nova senha>;

--não exquecer de commitar
--agora, utilizar o sqldeveloper e se conectar ao banco novamente