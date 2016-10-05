mysql --user=root --password=root < CreateDB.sql

DROP SCHEMA IF EXISTS internetshop;

CREATE SCHEMA `internetshop` ;

use internetshop;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `category` VALUES (1,'Tv'),(2,'Phone'),(3,'Notebook'),(4,'Photo'),(5,'Fridge'),(6,'Tabled'),(7,'Other');

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `users_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `users` VALUES (1,'b','admin','a','107615@tut.by'),(2,'y','user','t','107615@tut.by'),(3,'admin','admin','admin','107615@tut.by'),(4,' user ','user','user ','107615@tut.by');

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `characteristic1` varchar(255) DEFAULT NULL,
  `characteristic10` int(11) DEFAULT NULL,
  `characteristic11` int(11) DEFAULT NULL,
  `characteristic2` varchar(255) DEFAULT NULL,
  `characteristic3` varchar(255) DEFAULT NULL,
  `characteristic4` varchar(255) DEFAULT NULL,
  `characteristic5` varchar(255) DEFAULT NULL,
  `characteristic6` varchar(255) DEFAULT NULL,
  `characteristic7` int(11) DEFAULT NULL,
  `characteristic8` int(11) DEFAULT NULL,
  `characteristic9` int(11) DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `oldprice` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `stock_status` varchar(255) DEFAULT NULL,
  `category_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `FK_34vs0lllx9xtmq9s0nyih76so` (`category_id_FK`),
  CONSTRAINT `FK_34vs0lllx9xtmq9s0nyih76so` FOREIGN KEY (`category_id_FK`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

INSERT INTO `goods` VALUES (1,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',32,0,0,0,'UE32J6300AU','tv/UE32J6300AU.jpg','Samsung',480,420,5,'in_stock',1),(2,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40,0,0,0,'UE40J6200AU','tv/UE40J6200AU.jpg','Samsung',510,450,4,'in_stock',1),(3,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',22,0,0,0,'UE22H5600','tv/UE22H5600.jpg','Samsung',220,199,4,'in_stock',1),(4,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',32,0,0,0,'UE32J5500AU','tv/ UE32J5500AU.jpg','Samsung',440,430,4,'in_stock',1),(5,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',55,0,0,0,'UE55H6400','tv/ UE55H6400.jpg','Samsung',770,720,5,'in_stock',1),(6,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',40,0,0,0,'UE40JU6000U','tv/UE40JU6000U.jpg','Samsung',520,499,4,'in_stock',1),(7,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40,0,0,0,'UE40J620EAU','tv/UE40J6200AU.jpg','Samsung',510,450,4,'in_stock',1),(8,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',48,0,0,0,'UE48JU6000U','tv/UE48JU6000U.jpg','Samsung',610,550,5,'in_stock',1),(9,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',43,0,0,0,'UE43KU6000U','tv/UE43KU6000U.jpg','Samsung',550,499,5,'in_stock',1),(10,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',48,0,0,0,'UE48J5550AU','tv/UE48J5550AU.jpg','Samsung',730,710,5,'in_stock',1),(11,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',58,0,0,0,'UE58J5200AK','tv/ UE58J5200AK.jpg','Samsung',990,850,5,'in_stock',1),(12,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',32,0,0,0,'UE32J4500AK','tv/UE32J4500AK.jpg','Samsung',270,250,3,'in_stock',1),(13,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',65,0,0,0,'UE65JU6000U','tv/UE65JU6000U.jpg','Samsung',1810,1650,5,'in_stock',1),(14,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',48,0,0,0,'UE48J6300AU','tv/UE48J6300AU.jpg','Samsung',410,350,4,'in_stock',1),(15,'black, silver',0,0,'DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40,0,0,0,'UE40JU6610U','tv/UE40JU6610U.jpg','Samsung',910,850,3,'in_stock',1);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_status` int(11) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `users_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`orders_id`),
  KEY `FK_e339pox2sojm3is3iyb5ue2rn` (`users_id_FK`),
  CONSTRAINT `FK_e339pox2sojm3is3iyb5ue2rn` FOREIGN KEY (`users_id_FK`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `orders` VALUES (1,0,'processing',0,2),(2,0,'processing',550,2),(3,0,'processing',550,2),(4,0,'processing',398,2),(5,0,'processing',2787,2);

CREATE TABLE `goodsinorders` (
  `goodsorders_id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `goods_id_FK` int(11) DEFAULT NULL,
  `orders_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsorders_id`),
  KEY `FK_46wg99is9vxso39tv2r11gviv` (`goods_id_FK`),
  KEY `FK_iapi8aya16t6sfkuuhexlopkv` (`orders_id_FK`),
  CONSTRAINT `FK_46wg99is9vxso39tv2r11gviv` FOREIGN KEY (`goods_id_FK`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `FK_iapi8aya16t6sfkuuhexlopkv` FOREIGN KEY (`orders_id_FK`) REFERENCES `orders` (`orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `goodsinorders` VALUES (1,2,3,4),(2,3,3,5),(3,3,4,5),(4,2,2,5);
