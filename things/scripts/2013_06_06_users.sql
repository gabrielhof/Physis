-- MySQL

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(32) NOT NULL,
	role VARCHAR(15) NOT NULL
) ENGINE=InnoDB;