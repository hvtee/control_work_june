#1
CREATE DATABASE `humanFriends`;
use humanFriends;

#2
CREATE TABLE `Animal` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50),
  `ability` VARCHAR(50),
  `birthDate` DATE
);

CREATE TABLE `homePets` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `Animal` (`id`)
);

CREATE TABLE `workPets` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `Animal` (`id`)
);

CREATE TABLE `dogs` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `homePets` (`id`)
);

CREATE TABLE `cats` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `homePets` (`id`)
);

CREATE TABLE `hamsters` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `homePets` (`id`)
);

CREATE TABLE `horses` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `workPets` (`id`)
);

CREATE TABLE `camels` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `workPets` (`id`)
);

CREATE TABLE `donkeys` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `workPets` (`id`)
);

#3
INSERT INTO `Animal` (`name`, `ability`, `birthDate`) VALUES
  ('Рэкс', 'Сидеть', '2010-05-15'),
  ('Мурка', 'Ловить мышей', '2015-02-28'),
  ('Чип', 'Бегать по колесу', '2019-08-10'),
  ('Булка', 'Тянуть плуг', '2012-07-22'),
  ('Гром', 'Нести груз', '2014-11-05'),
  ('Марго', 'Доставать воду', '2017-04-12');
  
#4
DROP TABLE camels;

#5
CREATE TABLE `horsesAndDonkeys` (
  `id` INT PRIMARY KEY,
  FOREIGN KEY (`id`) REFERENCES `workPets` (`id`)
);

INSERT INTO `horsesAndDonkeys` (`id`) SELECT `id` FROM `horses`;
INSERT INTO `horsesAndDonkeys` (`id`) SELECT `id` FROM `donkeys`;

#6
CREATE TABLE `youngPets` (
  `id` INT PRIMARY KEY,
  `age` INT,
  FOREIGN KEY (`id`) REFERENCES `Animal` (`id`)
);

INSERT INTO `youngPets` (`id`, `age`)
SELECT `id`, TIMESTAMPDIFF(MONTH, `birthDate`, CURDATE()) AS `age`
FROM `animal`
WHERE `birthDate` >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND `birthDate` <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

#7
CREATE TABLE `allPets` (
  `id` INT PRIMARY KEY,
  `type` VARCHAR(50),
  `name` VARCHAR(50),
  `ability` VARCHAR(50),
  `birthDate` DATE
);

INSERT INTO `allPets` (`id`, `type`, `name`, `ability`, `birthDate`)
SELECT `id`, 'animal' AS `type`, `name`, `ability`, `birthDate` FROM `animal`
UNION
SELECT `id`, 'homepets', NULL, NULL, NULL FROM `homepets`
UNION
SELECT `id`, 'workpets', NULL, NULL, NULL FROM `workpets`
UNION
SELECT `id`, 'dogs', NULL, NULL, NULL FROM `dogs`
UNION
SELECT `id`, 'cats', NULL, NULL, NULL FROM `cats`
UNION
SELECT `id`, 'hamsters', NULL, NULL, NULL FROM `hamsters`
UNION
SELECT `id`, 'horses', NULL, NULL, NULL FROM `horsesAndDonkeys`
UNION
SELECT `id`, 'donkeys', NULL, NULL, NULL FROM `horsesAndDonkeys`;

