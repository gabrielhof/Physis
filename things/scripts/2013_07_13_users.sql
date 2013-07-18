-- MySQL

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(32) NOT NULL,
	role VARCHAR(15) NOT NULL,
	person_id INT NOT NULL
) ENGINE=InnoDB;

ALTER TABLE users ADD CONSTRAINT user_peop_fk FOREIGN KEY (person_id) REFERENCES people(id);
CREATE INDEX user_peop_fk_i ON users(person_id);