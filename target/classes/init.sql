
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
  id INT NOT NULL AUTO_INCREMENT,
  name CHAR(20) DEFAULT NULL,
  date_of_birth DATE DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);
