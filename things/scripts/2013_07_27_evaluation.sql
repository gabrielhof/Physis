-- MySQL

CREATE TABLE evaluation (
	id INT AUTO_INCREMENT PRIMARY KEY,
	`date` DATE NOT NULL,
	weight DECIMAL(5, 2) NOT NULL,
	height INT NOT NULL,
	percentualLeanMass DECIMAL(4, 1) NOT NULL,
	percentualFatMass DECIMAL(4, 1) NOT NULL,
	professor_id INT NOT NULL,
	user_id INT NOT NULL,
	training_id INT
) ENGINE=InnoDB;

ALTER TABLE evaluation ADD CONSTRAINT eval_prof_fk FOREIGN KEY (professor_id) REFERENCES people(id);
CREATE INDEX eval_prof_fk_i ON evaluation(professor_id);

ALTER TABLE evaluation ADD CONSTRAINT eval_user_fk FOREIGN KEY (user_id) REFERENCES people(id);
CREATE INDEX eval_user_fk_i ON evaluation(user_id);

ALTER TABLE evaluation ADD CONSTRAINT eval_trai_fk FOREIGN KEY (training_id) REFERENCES training(id);
CREATE INDEX eval_trai_fk_i ON evaluation(training_id);