CREATE TABLE payments (
	id INT AUTO_INCREMENT PRIMARY KEY,
	issue_date DATE NOT NULL,
	payment_date DATE NULL,
	value DECIMAL(10, 2) NULL,
	person_id INT NOT NULL
) ENGINE=InnoDB;

ALTER TABLE payments ADD CONSTRAINT payment_person_fk FOREIGN KEY (person_id) REFERENCES people(id);
CREATE INDEX payment_person_fk_i ON payments(person_id);