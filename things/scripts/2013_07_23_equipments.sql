-- MySQL

CREATE TABLE equipments (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description TEXT
) ENGINE=InnoDB;