How to Create Database DDL and DML Scripts
=============

This is a pattern that must follow to facilitate the control for the Structure and Data of the Database.

First of all, the name of the script must follow: `yyyy_MM_dd_TABLE_NAME.sql`, where:
* `yyyy` is the script's year
* `MM` is the month
* `dd` is the day
* `TABLE_NAME` is the script's destination table name 

Second, the file content must follow:

	-- SGDB_NAME
	SCRIPT

where:
* `SGDB_NAME` is the SGDB name, like MySQL or PostgreSQL.
* `SCRIPT` is the script statement, like CREATE TABLE or INSERT.

For each SGDB used is must contain a working script.
Currently, we only use MySQL.

Example:

File: `2013_06_02_PERSONS.sql`

Content:

	-- MySQL

	CREATE TABLE persons (
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(100) NOT NULL,
		age INT NOT NULL
	);
