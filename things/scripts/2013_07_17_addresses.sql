-- MySQL

CREATE TABLE addresses (
	id INT AUTO_INCREMENT PRIMARY KEY,
	cep VARCHAR(9) NOT NULL,
	address VARCHAR(100) NOT NULL,
	number INT NOT NULL,
	complement VARCHAR(20),
	district VARCHAR(100),
	city VARCHAR(100),
	state VARCHAR(3),
	country VARCHAR(3),
	person_id INT NOT NULL
) ENGINE=InnoDB;

ALTER TABLE addresses ADD CONSTRAINT addr_peop_fk FOREIGN KEY (person_id) REFERENCES people(id);
CREATE INDEX addr_peop_fk_i ON addresses(person_id);