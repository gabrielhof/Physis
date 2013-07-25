-- MySQL

CREATE TABLE foods (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	protein_percentual DECIMAL(4, 1) NOT NULL,
	carbohydrate_percentual DECIMAL(4, 1) NOT NULL,
	fat_percentual DECIMAL(4, 1) NOT NULL
) ENGINE=InnoDB;