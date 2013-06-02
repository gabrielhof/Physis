Como Criar Scripts DDL e DML para o Banco de Dados
=============

Esse padr�o deve ser seguido para facilitar o controle da Estrutura e dos Dados do Banco de Dados.

Primeiramente, o nome do script deve ser: `yyyy_MM_dd_TABLE_NAME.sql`, aonde:
* `yyyy` � o ano de cria��o do script
* `MM` � o m�s
* `dd` � o dia
* `TABLE_NAME` � o nome da table de destino do script

Ap�s, o conte�do do arquivo deve ser:
	-- SGDB_NAME
	SCRIPT

aonde:
* `SGDB_NAME` � o nome do SGDB, como por exemplo: MySQL, PostgreSQL.
* `SCRIPT` � script a ser executado, como CREATE TABLE ou INSERT.

Para cada SGDB utilizado deve conter um script funcional.
Atualimente, n�s estamos utilizando apenas o MySQL.

Exemplo:

Arquivo: `2013_06_02_PERSONS.sql`

Conte�do:

	-- MySQL

	CREATE TABLE persons (
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(100) NOT NULL,
		age INT NOT NULL
	);
