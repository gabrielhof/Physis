-- MySQL

CREATE TABLE people(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	born_date DATE NOT NULL,
	rg varchar(10) NOT NULL,
	cpf varchar(14) NOT NULL,
	email varchar (100),
	phone varchar(10)
) ENGINE=InnoDB;