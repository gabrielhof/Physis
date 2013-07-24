-- MySQL

CREATE TABLE exercises (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	equipment_id INT
) ENGINE=InnoDB;

ALTER TABLE exercises ADD CONSTRAINT exer_equi_fk FOREIGN KEY (equipment_id) REFERENCES equipments(id);
CREATE INDEX exer_equi_fk_i ON exercises(equipment_id);