CREATE DATABASE duckyshop;

USE duckyshop;

CREATE TABLE IF NOT EXISTS `duckyshop`.`author` (
  `id`           INT(11)               AUTO_INCREMENT,
  `name`         NVARCHAR(45) NULL     DEFAULT '',
  `age`          INT          NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `duckyshop`.`book`(
  `id`           INT(11)                AUTO_INCREMENT,
  `name`         VARCHAR(255) NULL      DEFAULT '',
  `genre`        VARCHAR(255) NULL      DEFAULT '',
  `author_id`    INT(11)      NULL      DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`author_id`)
  REFERENCES `duckyshop`.`author` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  AUTO_INCREMENT = 1;
