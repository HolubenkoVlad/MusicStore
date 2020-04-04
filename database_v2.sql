CREATE DATABASE `guitardb`;
USE `guitardb`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `feature` varchar(400) NOT NULL,
  `price` float(2) DEFAULT NULL,
  `photo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `guitar`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`id_product` int(11) NOT NULL,
`numberOfStrings` int(11) NOT NULL,
`material` varchar(100) NOT NULL,
`type` varchar(100) NOT NULL,
FOREIGN KEY(id_product) REFERENCES product(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `drum`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`id_product` int(11) NOT NULL,
`numberOfDrums` int(11) NOT NULL,
`material` varchar(100) NOT NULL,
`type` varchar(100) NOT NULL,
FOREIGN KEY(id_product) REFERENCES product(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `guitars` (`name`, `feature`, `price`,`photo`) VALUES
	('Гитара акустическая Ibanez PF15', 'Количество струн: 6,Наличие звукоснимателя: Нет, Размер: Полноразмерные', 5620, "ibanezpf15.jpg"),
	('Электрогитара Gibson 2018 Les Paul Studio T', 'Корпус Махагони/Клен,Количество струн 6,Мензура 24.75",Гриф Красное дерево (Махагони)', 43555, "‪gibson.jpg");



CREATE TABLE `orderusers` (
`id` int(11) not null auto_increment,
  `id_user` int(11) NOT NULL,
  `card` varchar(250) NOT NULL,
  `address` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




CREATE TABLE `orderitems` (
`id` int(11) Not Null auto_increment,
  `id_order` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(id_order) REFERENCES orderusers(id),
FOREIGN KEY(id_item) REFERENCES guitars(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `users` (
  `id` int(11) not null AUTO_INCREMENT,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `users` (`surname`, `email`, `login`, `password`) VALUES
	('admin', 'admin@gmail.com', 'Admin', 'admin'),
	('Petrov', 'petrov@gmail.com', 'Petr', '1122');

