CREATE SCHEMA IF NOT EXISTS `primesoft` DEFAULT CHARACTER SET utf8;
USE `primesoft`;

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nick` varchar(32) NOT NULL,
  `login` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS `vehicles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_login` varchar(32) NOT NULL,
  `brand` varchar(32) NOT NULL,
  `model` varchar(32) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `vehicles_users_fk_idx` (`user_login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS `insurance_offers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_id` bigint NOT NULL,
  `insurer` varchar(32) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `insurance_offers_vehicles_fk_idx` (`vehicle_id`),
  CONSTRAINT `insurance_offers_vehicles_fk` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO users (nick, login, password) VALUES ('user', 'userLogin', 'user1234');
INSERT INTO users (nick, login, password) VALUES ('admin', 'adminLogin', 'admin1234');

INSERT INTO vehicles (user_login, brand, model) VALUES ('userLogin', 'Volkswagen ', 'Gol');
INSERT INTO vehicles (user_login, brand, model) VALUES ('userLogin', 'Volkswagen', 'Golf');
INSERT INTO vehicles (user_login, brand, model) VALUES ('adminLogin', 'Volkswagen', 'Lavida');
INSERT INTO vehicles (user_login, brand, model) VALUES ('adminLogin', 'Volkswagen', 'Santana');
INSERT INTO vehicles (user_login, brand, model) VALUES ('adminLogin', 'Volkswagen', 'Polo');

INSERT INTO insurance_offers (vehicle_id, insurer, price) VALUES ('12', 'Adrianas Insurance', '500');
INSERT INTO insurance_offers (vehicle_id, insurer, price) VALUES ('12', 'Allied', '1000');
INSERT INTO insurance_offers (vehicle_id, insurer, price) VALUES ('13', 'CURE Insurance', '1500');
INSERT INTO insurance_offers (vehicle_id, insurer, price) VALUES ('14', 'Direct Auto', '2000');
INSERT INTO insurance_offers (vehicle_id, insurer, price) VALUES ('15', 'Elephant Insurance', '2500');
