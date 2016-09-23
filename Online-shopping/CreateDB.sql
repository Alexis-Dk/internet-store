CREATE SCHEMA `internetshop` DEFAULT CHARACTER SET utf8 ;

USE internetshop;

CREATE TABLE `internetshop`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `categoryname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `categoryname_UNIQUE` (`categoryname` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO category (categoryname) VALUES ('Tv');
INSERT INTO category (categoryname) VALUES ('Phone');
INSERT INTO category (categoryname) VALUES ('Notebook');
INSERT INTO category (categoryname) VALUES ('Photo');
INSERT INTO category (categoryname) VALUES ('Fridge');
INSERT INTO category (categoryname) VALUES ('Tabled');
INSERT INTO category (categoryname) VALUES ('Other');

CREATE TABLE `internetshop`.`goods` (
  `goods_id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `image_path` VARCHAR(101) NOT NULL,
  `price` INT NOT NULL,
`oldprice` INT NULL,
  `description` VARCHAR(201) NOT NULL,
  `characteristic1` VARCHAR(101)NOT NULL,
  `characteristic2` VARCHAR(101)NOT NULL,
  `characteristic3` VARCHAR(101) NOT NULL,
  `characteristic4` VARCHAR(201) NOT NULL,
  `characteristic5` VARCHAR(201)NOT NULL,
  `characteristic6` VARCHAR(201)NOT NULL,
  `characteristic7` INT NOT NULL,
  `characteristic8` INT NOT NULL,
  `characteristic9` INT NOT NULL,
  `characteristic10` INT NOT NULL,
  `characteristic11` INT NOT NULL,
  `delete_status` INT NOT NULL,
  `stock_status` ENUM('in_stock', 'custom') NOT NULL,
`rating` INT NOT NULL,
UNIQUE INDEX `description_UNIQUE` (`description` ASC),
 PRIMARY KEY (`goods_id`),
  INDEX `category_id_idx` (`category_id` ASC),
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `internetshop`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE32J6300AU.jpg', 420, 480,'UE32J6300AU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','', '16:9',32, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE40J6200AU.jpg', 450, 510,'UE40J6200AU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE22H5600.jpg', 199, 220,'UE22H5600','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',22, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11, delete_status, stock_status, rating) VALUES (1,'Samsung','tv/ UE32J5500AU.jpg', 430, 440,'UE32J5500AU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','', '16:9' ,32, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/ UE55H6400.jpg', 720, 770,'UE55H6400','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',55, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE40JU6000U.jpg', 499, 520,'UE40JU6000U','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',40, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE40J6200AU.jpg', 450, 510,'UE40J620EAU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE48JU6000U.jpg', 550, 610,'UE48JU6000U','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',48, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE43KU6000U.jpg', 499, 550,'UE43KU6000U','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',43, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE48J5550AU.jpg', 710, 730,'UE48J5550AU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',48, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/ UE58J5200AK.jpg', 850, 990,'UE58J5200AK','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',58, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE32J4500AK.jpg', 250, 270,'UE32J4500AK','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',32, 0,0,0,0,0,'in_stock',3);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE65JU6000U.jpg', 1650, 1810,'UE65JU6000U','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','3840x2160','','16:9',65, 0,0,0,0,0,'in_stock',5);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE48J6300AU.jpg', 350, 410,'UE48J6300AU','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080', '','16:9',48, 0,0,0,0,0,'in_stock',4);
INSERT INTO goods (category_id, name, image_path, price, oldprice ,description, characteristic1, characteristic2, characteristic3, characteristic4, characteristic5, characteristic6, characteristic7, characteristic8, characteristic9, characteristic10, characteristic11,delete_status, stock_status, rating) VALUES (1,'Samsung','tv/UE40JU6610U.jpg', 850, 910,'UE40JU6610U','black, silver','DVB-C, DVB-T2, DVB-S2','Tizen','1920x1080','','16:9',40, 0,0,0,0,0,'in_stock',3);


CREATE TABLE `internetshop`.`users` (
  `users_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(251) NOT NULL,
  `role` VARCHAR(251) NOT NULL,
  PRIMARY KEY (`users_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO users (username, password, role) VALUES ( 'a', 'b', 'admin');
INSERT INTO users (username, password, role) VALUES ('t', 'y', 'user');
INSERT INTO users (username, password, role) VALUES ('admin', 'admin', 'admin');
INSERT INTO users (username, password, role) VALUES ('user ', ' user ', 'user');


CREATE TABLE `internetshop`.`orders` (
  `orders_id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT NOT NULL,
  `payment` ENUM('processing', 'reject', 'payed') NOT NULL,
  `delete_status` INT NOT NULL,
  `totalcost` INT NOT NULL,
  PRIMARY KEY (`orders_id`),
  INDEX `users_id_idx` (`users_id` ASC),
  CONSTRAINT `users_id`
    FOREIGN KEY (`users_id`)
    REFERENCES `internetshop`.`users` (`users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;





CREATE TABLE `internetshop`.`goods_in_orders` (
  `orders_id` INT NOT NULL,
  `goods_id` INT NOT NULL,
  `count` INT NOT NULL,
  INDEX `orders_id_idx` (`orders_id` ASC),
  INDEX `goods_id_idx` (`goods_id` ASC),
  CONSTRAINT `orders_idk`
    FOREIGN KEY (`orders_id`)
    REFERENCES `internetshop`.`orders` (`orders_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `goods_idk`
    FOREIGN KEY (`goods_id`)
    REFERENCES `internetshop`.`goods` (`goods_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
