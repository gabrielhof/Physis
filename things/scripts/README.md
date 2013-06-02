Como Criar Scripts DDL e DML para o Banco de Dados
=============

Esse padrão deve ser seguido para facilitar o controle da Estrutura e dos Dados do Banco de Dados.

Primeiramente, o nome do script deve ser: `yyyy_MM_dd_TABLE_NAME.sql`, aonde:
* `yyyy` é o ano de criação do script
* `MM` é o mês
* `dd` é o dia
* `TABLE_NAME` é o nome da table de destino do script

Após, o conteúdo do arquivo deve ser:
	-- SGDB_NAME
	SCRIPT

aonde:
* `SGDB_NAME` é o nome do SGDB, como por exemplo: MySQL, PostgreSQL.
* `SCRIPT` é script a ser executado, como CREATE TABLE ou INSERT.

Para cada SGDB utilizado deve conter um script funcional.
Atualimente, nós estamos utilizando apenas o MySQL.

Exemplo:

Arquivo: `2013_06_02_PERSONS.sql`

Conteúdo:

	-- MySQL

	CREATE TABLE persons (
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(100) NOT NULL,
		age INT NOT NULL
	);
