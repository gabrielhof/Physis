-- MySQL

CREATE TABLE payments (
	id INT AUTO_INCREMENT PRIMARY KEY,
	issue_date VARCHAR(08) NOT NULL,
	payment_date VARCHAR(08) NULL,
	value DECIMAL(10, 2) NULL,
	user_id INT NOT NULL
) ENGINE=InnoDB;

ALTER TABLE payments ADD CONSTRAINT payment_user_fk FOREIGN KEY (user_id) REFERENCES users(id);
CREATE INDEX payment_user_fk_i ON payments(user_id);