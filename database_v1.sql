CREATE DATABASE `guitardb`;
USE `guitardb`;

CREATE TABLE `guitar`(
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100) NOT NULL,
`feature` varchar(400),
`price` float DEFAULT NULL,
`photo` varchar(300) DEFAULT NULL,
`number_of_strings` int4 NOT NULL,
`material` varchar(100) NOT NULL,
`type` varchar(100) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `drum`(
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100) NOT NULL,
`feature` varchar(400),
`price` float DEFAULT NULL,
`photo` varchar(300) DEFAULT NULL,
`number_of_drums` int4 not NULL,
`color` varchar(100) NOT NULL,
`size` varchar(400) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `synthesizer`(
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100) NOT NULL,
`feature` varchar(400),
`price` float DEFAULT NULL,
`photo` varchar(300) DEFAULT NULL,
`number_of_keys` int4 NOT NULL,
`type_of_keyboard` varchar(300) NOT NULL,
`number_of_timbres` int4 NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `guitar` (`name`,`price`,`photo`, `number_of_strings`, `material`, `type`) VALUES
	('Ibanez PF2MH-OPN Open Pore Natural', 129, "ibanez-pf2mh.jpg",6, 'Nandu Wood', 'Acoustic'),
	('Yamaha F310 Tobacco Brown Sunburst', 137, "yamaha-f310.jpg", 6, 'Meranti', 'Acoustic');

INSERT INTO `drum` (`name`, `price`,`photo`, `number_of_drums`, `color`, `size`) VALUES
	('Fame Blaze Standard Set 5221', 333, "fame-blaze-standard.jpg",5, 'Red', '22"x16" Bass Drum; 12"x9" + 13"x10" Tom Tom; 16"x16" Floor Tom; 14"x5,5" Snare Drum'),
	('Mapex Tornado Drumset TND5045TZ', 499, "mapex-tornado-drumset.jpg", 9, 'Royal Blue', 'Size tom 1: 10" x 8"; Size tom 2: 12" x 9"; Size floor tom 1: 14" x 14"; Snare size: 14" x 5"; Size bassdrum: 20" x 16"; Pre-dampened Bass Drum');

INSERT INTO `synthesizer` (`name`, `price`,`photo`, `number_of_keys`, `type_of_keyboard`, `number_of_timbres`) VALUES
	('Korg SV-2 73', 1780, "korg-sv2.jpg",77, "RH3 keyboard with hammer mechanism", 3),
	('Yamaha MODX8 Synthesizer Keyboard', 1508, "yamaha-modx8.jpg", 88, 'GHS Keyboard', 3);


CREATE TABLE `orderusers` (
`id` int not null auto_increment,
  `id_user` int NOT NULL,
  `card` varchar(250) NOT NULL,
  `address` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `orderguitars` (
`id` int Not Null auto_increment,
  `id_order` int NOT NULL,
  `id_item` int NOT NULL,
  `count` int4 NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(id_order) REFERENCES orderusers(id),
FOREIGN KEY(id_item) REFERENCES guitar(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `orderdrums` (
`id` int Not Null auto_increment,
  `id_order` int NOT NULL,
  `id_item` int NOT NULL,
  `count` int4 NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(id_order) REFERENCES orderusers(id),
FOREIGN KEY(id_item) REFERENCES drum(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ordersynthesizers` (
`id` int Not Null auto_increment,
  `id_order` int NOT NULL,
  `id_item` int NOT NULL,
  `count` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(id_order) REFERENCES orderusers(id),
FOREIGN KEY(id_item) REFERENCES synthesizer(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `type_of_user`(
`id` int not null auto_increment,
`name` varchar(20) not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `type_of_user` (`name`) VALUES
	('user'),
	('admin');

CREATE TABLE `users` (
  `id` int not null AUTO_INCREMENT,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_type` int default 1,
  PRIMARY KEY (`id`),
  foreign key(id_type) references type_of_user(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `users` (`surname`, `email`, `login`, `password`, `id_type`) VALUES
	('admin', 'admin@gmail.com', 'Admin', 'admin', 2),
	('Holubenko', 'holubenko@gmail.com', 'Holubenko', '12345', 1);