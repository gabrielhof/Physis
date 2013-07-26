-- MySQL

CREATE TABLE training (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE training_exercises (
	id INT AUTO_INCREMENT PRIMARY KEY,
	series INT NOT NULL,
	repetitions INT NOT NULL,
	weight INT NOT NULL,
	training_id INT NOT NULL,
	exercise_id INT NOT NULL
) ENGINE=InnoDB;

ALTER TABLE training_exercises ADD CONSTRAINT trex_trai_fk FOREIGN KEY (training_id) REFERENCES training(id);
CREATE INDEX trex_trai_fk_i ON training_exercises(training_id);

ALTER TABLE training_exercises ADD CONSTRAINT trex_exer_fk FOREIGN KEY (exercise_id) REFERENCES exercises(id);
CREATE INDEX trex_exer_fk_i ON training_exercises(exercise_id);