mysql --user=root --password=root < patch_0000001.sql

DROP SCHEMA IF EXISTS internetshop;

CREATE SCHEMA `internetshop` ;

USE internetshop;

-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: internetshop
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'TV'),(2,'CONSOLE'),(3,'Tablet');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_characteristic`
--

DROP TABLE IF EXISTS `category_characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_characteristic` (
  `categoryCharacteristic_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryCharacteristicEnable_name` bit(1) NOT NULL,
  `categoryCharacteristic_name` varchar(255) DEFAULT NULL,
  `categoryCharacteristicLanguageOne_name` varchar(255) DEFAULT NULL,
  `categoryCharacteristicLanguageThree_name` varchar(255) DEFAULT NULL,
  `categoryCharacteristicLanguageTwo_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryCharacteristic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_characteristic`
--

LOCK TABLES `category_characteristic` WRITE;
/*!40000 ALTER TABLE `category_characteristic` DISABLE KEYS */;
INSERT INTO `category_characteristic` VALUES (1,'','TV_INT_1','Price','Цена','Prix'),(2,'','TV_INT_2','Width','Ширина','Largeur'),(3,'','TV_INT_3','Height','Высота','Taile'),(4,'','TV_INT_4','Weight','Вес','Poids'),(5,'','TV_INT_5','Year','Год','An'),(6,'','TV_STR_1','Manufacturer','Производитель','Fabricant'),(7,'','TV_STR_2','Diagonal','Диагональ','Diagonale'),(8,'','TV_STR_3','Matrix','Матрица','Matrice'),(9,'','TV_STR_4','Resolution','Разрешение','Résolution'),(10,'','TV_STR_5','SmartTv','СмартТв','SmartTv'),(11,'\0','TV_STR_6','Characteristic_6','Characteristic_6','Characteristic_6'),(12,'\0','TV_STR_7','Characteristic_7','Characteristic_7','Characteristic_7'),(13,'','TV_BOOL_1','3D','3D','3D'),(14,'','TV_BOOL_2','VoiceControl','УправлениеГолосом','CommandeVocale'),(15,'','TV_BOOL_3','Subwoofer','Саббуфер','Subwoofer'),(16,'','TV_BOOL_4','CurvedScreen','Изогнутый','CurvedScreen'),(17,'','TV_BOOL_5','DisplayPort','DisplayPort','DisplayPort'),(18,'','CONSOLE_INT_1','Price','Цена','Price'),(19,'\0','CONSOLE_INT_2','Characteristic_2','Characteristic_2','Characteristic_2'),(20,'\0','CONSOLE_INT_3','Characteristic_3','Characteristic_3','Characteristic_3'),(21,'\0','CONSOLE_INT_4','Characteristic_4','Characteristic_4','Characteristic_4'),(22,'','CONSOLE_INT_5','Year','Год','An'),(23,'','CONSOLE_STR_1','Manufacturer','Производитель','Fabricant'),(24,'','CONSOLE_STR_2','Resolution','Разрешение','Résolution'),(25,'','CONSOLE_STR_3','Processor','Процессор','Processor'),(26,'','CONSOLE_STR_4','HDD','Винчестер','HDD'),(27,'','CONSOLE_STR_5','RAM','Память','RAM'),(28,'\0','CONSOLE_STR_6','Characteristic_6','Characteristic_6','Characteristic_6'),(29,'\0','CONSOLE_STR_7','Characteristic_7','Characteristic_7','Characteristic_7'),(30,'','CONSOLE_BOOL_1','HDR','HDR','HDR'),(31,'','CONSOLE_BOOL_2','Wi-Fi','Wi-Fi','Wi-Fi'),(32,'','CONSOLE_BOOL_3','HDMI','HDMI','HDMI'),(33,'','CONSOLE_BOOL_4','Ethernet','Ethernet','Ethernet'),(34,'\0','CONSOLE_BOOL_5','Characteristic_5','Characteristic_5','Characteristic_5'),(35,'','Tablet_INT_1','Price','Цена','Price'),(36,'','Tablet_INT_2','Battery','Аккумулятор','Battery'),(37,'','Tablet_INT_3','Diagonal','Диагональ','Diagonale'),(38,'','Tablet_INT_4','HDD','Накопитель','HDD'),(39,'','Tablet_INT_5','Year','Год','An'),(40,'','Tablet_STR_1','Manufacturer','Производитель','Fabricant'),(41,'','Tablet_STR_2','Resolution','Разрешение','Résolution'),(42,'','Tablet_STR_3','Color','Цвет','Couleur'),(43,'','Tablet_STR_4','RAM','Память','RAM'),(44,'\0','Tablet_STR_5','Characteristic_5','Characteristic_5','Characteristic_5'),(45,'\0','Tablet_STR_6','Characteristic_6','Characteristic_6','Characteristic_6'),(46,'\0','Tablet_STR_7','Characteristic_7','Characteristic_7','Characteristic_7'),(47,'','Tablet_BOOL_1','Jack','Jack','Jack'),(48,'','Tablet_BOOL_2','Accelerometer','Accelerometer','Accelerometer'),(49,'','Tablet_BOOL_3','GPS','GPS','GPS'),(50,'\0','Tablet_BOOL_4','Characteristic_4','Characteristic_4','Characteristic_4'),(51,'\0','Tablet_BOOL_5','Characteristic_5','Characteristic_5','Characteristic_5');
/*!40000 ALTER TABLE `category_characteristic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characteristic`
--

DROP TABLE IF EXISTS `characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `characteristic` (
  `characteristic_id` int(11) NOT NULL AUTO_INCREMENT,
  `characteristicName` varchar(255) DEFAULT NULL,
  `categoryCharacteristic_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`characteristic_id`),
  KEY `FK_biud5er3m4mpji8jlsi0ohgda` (`categoryCharacteristic_id_FK`),
  CONSTRAINT `FK_biud5er3m4mpji8jlsi0ohgda` FOREIGN KEY (`categoryCharacteristic_id_FK`) REFERENCES `category_characteristic` (`categoryCharacteristic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characteristic`
--

LOCK TABLES `characteristic` WRITE;
/*!40000 ALTER TABLE `characteristic` DISABLE KEYS */;
INSERT INTO `characteristic` VALUES (1,'LG',6),(2,'Samsung',6),(3,'Philips',6),(4,'Sony',6),(5,'32',7),(6,'37',7),(7,'43',7),(8,'47',7),(9,'57',7),(10,'65',7),(11,'LED',8),(12,'OLED',8),(13,'Plasma',8),(14,'HD',9),(15,'HdReady',9),(16,'FullHd',9),(17,'4K',9),(18,'LgWebOS',10),(19,'Tizen',10),(20,'Android',10),(22,'q',11),(23,'w',12),(24,'Q',28),(25,'R',29),(26,'Sony',23),(27,'Microsoft',23),(28,'Nintando',23),(29,'Dandy',23),(30,'HD',24),(31,'HdReady',24),(32,'FullHd',24),(33,'4K',24),(34,'AMDx86Jaguar',25),(35,'Intel',25),(36,'250Gb',26),(37,'500Gb',26),(38,'1Tb',26),(39,'2Gb',27),(40,'4Gb',27),(41,'8Gb',27),(42,'Lenovo',40),(43,'Samsung',40),(44,'Prestigio',40),(45,'Apple',40),(46,'Huawei',40),(47,'720p',41),(48,'HD',41),(49,'FullHd',41),(50,'Black',42),(51,'Gold',42),(52,'White',42),(53,'Silver',42),(54,'2Gb',43),(55,'4Gb',43),(56,'8Gb',43),(57,'u',45),(58,'o',46),(59,'p',44);
/*!40000 ALTER TABLE `characteristic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_products`
--

DROP TABLE IF EXISTS `ordered_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordered_products` (
  `ordered_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `order_id_FK` int(11) DEFAULT NULL,
  `product_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ordered_product_id`),
  KEY `FK_pw482wv8sw4nseoifqf08cxew` (`order_id_FK`),
  KEY `FK_dolc1ny2bn7w6cy3pwdmbw33c` (`product_id_FK`),
  CONSTRAINT `FK_dolc1ny2bn7w6cy3pwdmbw33c` FOREIGN KEY (`product_id_FK`) REFERENCES `products` (`product_id`),
  CONSTRAINT `FK_pw482wv8sw4nseoifqf08cxew` FOREIGN KEY (`order_id_FK`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_products`
--

LOCK TABLES `ordered_products` WRITE;
/*!40000 ALTER TABLE `ordered_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordered_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_status` int(11) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `user_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_lgmtkf7gg4bfb9p98h9qdpofm` (`user_id_FK`),
  CONSTRAINT `FK_lgmtkf7gg4bfb9p98h9qdpofm` FOREIGN KEY (`user_id_FK`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `boolCharacteristic1` bit(1) NOT NULL,
  `boolCharacteristic2` bit(1) NOT NULL,
  `boolCharacteristic3` bit(1) NOT NULL,
  `boolCharacteristic4` bit(1) NOT NULL,
  `boolCharacteristic5` bit(1) NOT NULL,
  `characteristic1` varchar(255) DEFAULT NULL,
  `characteristic10` int(11) DEFAULT NULL,
  `characteristic11` int(11) DEFAULT NULL,
  `characteristic2` varchar(255) DEFAULT NULL,
  `characteristic3` varchar(255) DEFAULT NULL,
  `characteristic4` varchar(255) DEFAULT NULL,
  `characteristic5` varchar(255) DEFAULT NULL,
  `characteristic6` varchar(255) DEFAULT NULL,
  `characteristic7` varchar(255) DEFAULT NULL,
  `characteristic8` int(11) DEFAULT NULL,
  `characteristic9` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image1_path` varchar(255) DEFAULT NULL,
  `image2_path` varchar(255) DEFAULT NULL,
  `image3_path` varchar(255) DEFAULT NULL,
  `image4_path` varchar(255) DEFAULT NULL,
  `image5_path` varchar(255) DEFAULT NULL,
  `image6_path` varchar(255) DEFAULT NULL,
  `intCharacteristic1` double DEFAULT NULL,
  `intCharacteristic2` double DEFAULT NULL,
  `intCharacteristic3` double DEFAULT NULL,
  `intCharacteristic4` double DEFAULT NULL,
  `intCharacteristic5` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `oldprice` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `stock_status` varchar(255) DEFAULT NULL,
  `category_id_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_5evtvgdjd8b26g8fuourkvdck` (`category_id_FK`),
  CONSTRAINT `FK_5evtvgdjd8b26g8fuourkvdck` FOREIGN KEY (`category_id_FK`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'','\0','\0','\0','','LG',0,0,'43','OLED','HD','LgWebOS','Disabled','Disabled',0,0,'',0,'NX43GT-FS7','1/NX43GT-FS7_1_1.jpg','1/NX43GT-FS7_1_2.jpg','1/NX43GT-FS7_1_3.jpg','1/NX43GT-FS7_1_4.jpg','1/NX43GT-FS7_1_5.jpg','1/NX43GT-FS7_1_6.jpg',599,541,379,5.6,2016,NULL,0,599,0,NULL,1),(2,'\0','\0','\0','\0','\0','LG',0,0,'32','LED','HD','LgWebOS','Disabled','Disabled',0,0,'',0,'ST32-XBJZ4','1/ST32-XBJZ4_2_1.jpg','1/ST32-XBJZ4_2_2.jpg','1/ST32-XBJZ4_2_3.jpg','1/ST32-XBJZ4_2_4.jpg','1/ST32-XBJZ4_2_5.jpg','1/ST32-XBJZ4_2_6.jpg',299,323,210,3.7,2016,NULL,0,299,0,NULL,1),(3,'','','','','','Sony',0,0,'65','Plasma','4K','Android','Disabled','Disabled',0,0,'',0,'Bravia-656TR','1/Bravia-656TR_3_1.jpg','1/Bravia-656TR_3_2.jpg','1/Bravia-656TR_3_3.jpg','1/Bravia-656TR_3_4.jpg','1/Bravia-656TR_3_5.jpg','1/Bravia-656TR_3_6.jpg',999,679,521,10.7,2015,NULL,0,999,0,NULL,1),(4,'\0','\0','','\0','\0','Philips',0,0,'37','OLED','HdReady','Android','Disabled','Disabled',0,0,'',0,'TR37-GXB007','1/TR37-GXB007_4_1.jpg','1/TR37-GXB007_4_2.jpg','1/TR37-GXB007_4_3.jpg','1/TR37-GXB007_4_4.jpg','1/TR37-GXB007_4_5.jpg','1/TR37-GXB007_4_6.jpg',455,467,345,7.8,2015,NULL,0,455,0,NULL,1),(5,'','','\0','\0','','Samsung',0,0,'43','OLED','FullHd','Tizen','Disabled','Disabled',0,0,'',0,'UE43J5205AK','1/UE43J5205AK_5_1.jpg','1/UE43J5205AK_5_2.jpg','1/UE43J5205AK_5_3.jpg','1/UE43J5205AK_5_4.jpg','1/UE43J5205AK_5_5.jpg','1/UE43J5205AK_5_6.jpg',325,567,345,6.8,2017,NULL,0,325,0,NULL,1),(6,'','','','\0','\0','Apple',0,0,'FullHd','White','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'iPad4','3/iPad4_6_1.jpg','3/iPad4_6_2.jpg','3/iPad4_6_3.jpg','3/iPad4_6_4.jpg','3/iPad4_6_5.jpg','3/iPad4_6_6.jpg',599.9,6400,10.1,128,2016,NULL,0,599.9,0,NULL,3),(7,'','','','','','LG',0,0,'43','OLED','FullHd','LgWebOS','Disabled','Disabled',0,0,'',0,'43UH610V','1/43UH610V_7_1.jpg','1/43UH610V_7_2.jpg','1/43UH610V_7_3.jpg','1/43UH610V_7_4.jpg','1/43UH610V_7_5.jpg','1/43UH610V_7_6.jpg',470,456,345,4.8,2017,NULL,0,470,0,NULL,1),(8,'','','\0','','','LG',0,0,'57','LED','HdReady','LgWebOS','Disabled','Disabled',0,0,'',0,'55UH605V','1/55UH605V_8_1.jpg','1/55UH605V_8_2.jpg','1/55UH605V_8_3.jpg','1/55UH605V_8_4.jpg','1/55UH605V_8_5.jpg','1/55UH605V_8_6.jpg',589,789,567,9.9,2016,NULL,0,589,0,NULL,1),(9,'\0','\0','\0','\0','\0','LG',0,0,'32','OLED','HdReady','LgWebOS','Disabled','Disabled',0,0,'',0,'32LH604V','1/32LH604V_9_1.jpg','1/32LH604V_9_2.jpg','1/32LH604V_9_3.jpg','1/32LH604V_9_4.jpg','1/32LH604V_9_5.jpg','1/32LH604V_9_6.jpg',290,456,345,5.9,2016,NULL,0,290,0,NULL,1),(10,'\0','','\0','\0','','Sony',0,0,'32','OLED','HD','Android','Disabled','Disabled',0,0,'',0,'KDL-32WD603','1/KDL-32WD603_10_1.jpg','1/KDL-32WD603_10_2.jpg','1/KDL-32WD603_10_3.jpg','1/KDL-32WD603_10_4.jpg','1/KDL-32WD603_10_5.jpg','1/KDL-32WD603_10_6.jpg',350,567,345,8.9,2017,NULL,0,350,0,NULL,1),(11,'\0','\0','\0','\0','\0','Philips',0,0,'37','Plasma','HdReady','Tizen','Disabled','Disabled',0,0,'',0,'UE37J4710AK','1/UE37J4710AK_11_1.jpg','1/UE37J4710AK_11_2.jpg','1/UE37J4710AK_11_3.jpg','1/UE37J4710AK_11_4.jpg','1/UE37J4710AK_11_5.jpg','1/UE37J4710AK_11_6.jpg',310,456,345,6.8,2015,NULL,0,310,0,NULL,1),(12,'','\0','\0','','\0','Sony',0,0,'32','Plasma','HD','Android','Disabled','Disabled',0,0,'',0,'KDL-32RD301','1/KDL-32RD301_12_1.jpg','1/KDL-32RD301_12_2.jpg','1/KDL-32RD301_12_3.jpg','1/KDL-32RD301_12_4.jpg','1/KDL-32RD301_12_5.jpg','1/KDL-32RD301_12_6.jpg',300,456,345,5.9,2016,NULL,0,300,0,NULL,1),(13,'\0','\0','\0','\0','\0','LG',0,0,'47','OLED','4K','LgWebOS','Disabled','Disabled',0,0,'',0,'47LJ622V','1/47LJ622V_13_1.jpg','1/47LJ622V_13_2.jpg','1/47LJ622V_13_3.jpg','1/47LJ622V_13_4.jpg','1/47LJ622V_13_5.jpg','1/47LJ622V_13_6.jpg',650,678,567,7.9,2017,NULL,0,650,0,NULL,1),(14,'\0','\0','\0','\0','\0','LG',0,0,'47','OLED','FullHd','Tizen','Disabled','Disabled',0,0,'',0,'43UH671V','1/43UH671V_14_1.jpg','1/43UH671V_14_2.jpg','1/43UH671V_14_3.jpg','1/43UH671V_14_4.jpg','1/43UH671V_14_5.jpg','1/43UH671V_14_6.jpg',455,456,345,6,2015,NULL,0,455,0,NULL,1),(15,'\0','','\0','','\0','Philips',0,0,'32','OLED','HdReady','Android','Disabled','Disabled',0,0,'',0,'32PHT4001','1/32PHT4001_15_1.jpg','1/32PHT4001_15_2.jpg','1/32PHT4001_15_3.jpg','1/32PHT4001_15_4.jpg','1/32PHT4001_15_5.jpg','1/32PHT4001_15_6.jpg',235,579,456,6,2017,NULL,0,235,0,NULL,1),(16,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','250Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4Slim','2/PS4Slim_16_1.jpg','2/PS4Slim_16_2.jpg','2/PS4Slim_16_3.jpg','2/PS4Slim_16_4.jpg','2/PS4Slim_16_5.jpg','2/PS4Slim_16_6.jpg',220,1,1,1,2017,NULL,0,220,0,NULL,2),(17,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','1Tb','8Gb','Disabled','Disabled',0,0,'',0,'PS4','2/PS4_17_1.jpg','2/PS4_17_2.jpg','2/PS4_17_3.jpg','2/PS4_17_4.jpg','2/PS4_17_5.jpg','2/PS4_17_6.jpg',299,1,1,1,2016,NULL,0,299,0,NULL,2),(18,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','500Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4','2/PS4_18_1.jpg','2/PS4_18_2.jpg','2/PS4_18_3.jpg','2/PS4_18_4.jpg','2/PS4_18_5.jpg','2/PS4_18_6.jpg',280,1,1,1,2016,NULL,0,280,0,NULL,2),(19,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','250Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4-250GB','2/PS4-250GB_19_1.jpg','2/PS4-250GB_19_2.jpg','2/PS4-250GB_19_3.jpg','2/PS4-250GB_19_4.jpg','2/PS4-250GB_19_5.jpg','2/PS4-250GB_19_6.jpg',260,1,1,1,2017,NULL,0,260,0,NULL,2),(20,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','250Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4-SLIM-250','2/PS4-SLIM-250_20_1.jpg','2/PS4-SLIM-250_20_2.jpg','2/PS4-SLIM-250_20_3.jpg','2/PS4-SLIM-250_20_4.jpg','2/PS4-SLIM-250_20_5.jpg','2/PS4-SLIM-250_20_6.jpg',350,1,1,1,2017,NULL,0,350,0,NULL,2),(21,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','500Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4-SLIM-500','2/PS4-SLIM-500_21_1.jpg','2/PS4-SLIM-500_21_2.jpg','2/PS4-SLIM-500_21_3.jpg','2/PS4-SLIM-500_21_4.jpg','2/PS4-SLIM-500_21_5.jpg','2/PS4-SLIM-500_21_6.jpg',330,1,1,1,2017,NULL,0,330,0,NULL,2),(22,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','500Gb','8Gb','Disabled','Disabled',0,0,'',0,'PS4-SLIM-500','2/PS4-SLIM-500_22_1.jpg','2/PS4-SLIM-500_22_2.jpg','2/PS4-SLIM-500_22_3.jpg','2/PS4-SLIM-500_22_4.jpg','2/PS4-SLIM-500_22_5.jpg','2/PS4-SLIM-500_22_6.jpg',360,1,1,1,2017,NULL,0,360,0,NULL,2),(23,'','','','','\0','Sony',0,0,'HD','AMDx86Jaguar','1Tb','8Gb','Disabled','Disabled',0,0,'',0,'PS4-SLIM-1TB','2/PS4-SLIM-1TB_23_1.jpg','2/PS4-SLIM-1TB_23_2.jpg','2/PS4-SLIM-1TB_23_3.jpg','2/PS4-SLIM-1TB_23_4.jpg','2/PS4-SLIM-1TB_23_5.jpg','2/PS4-SLIM-1TB_23_6.jpg',380,1,1,1,2017,NULL,0,380,0,NULL,2),(24,'','','','','\0','Microsoft',0,0,'HD','AMDx86Jaguar','250Gb','8Gb','Disabled','Disabled',0,0,'',0,'XBOX360-250GB','2/XBOX360-250GB_24_1.jpg','2/XBOX360-250GB_24_2.jpg','2/XBOX360-250GB_24_3.jpg','2/XBOX360-250GB_24_4.jpg','2/XBOX360-250GB_24_5.jpg','2/XBOX360-250GB_24_6.jpg',299,1,1,1,2017,NULL,0,299,0,NULL,2),(25,'','','','','\0','Microsoft',0,0,'HD','AMDx86Jaguar','500Gb','8Gb','Disabled','Disabled',0,0,'',0,'XBOX360-500GB','2/XBOX360-500GB_25_1.jpg','2/XBOX360-500GB_25_2.jpg','2/XBOX360-500GB_25_3.jpg','2/XBOX360-500GB_25_4.jpg','2/XBOX360-500GB_25_5.jpg','2/XBOX360-500GB_25_6.jpg',320,1,1,1,2017,NULL,0,320,0,NULL,2),(26,'','','','','\0','Microsoft',0,0,'HD','AMDx86Jaguar','500Gb','8Gb','Disabled','Disabled',0,0,'',0,'XBOX360-500GB','2/XBOX360-500GB_26_1.jpg','2/XBOX360-500GB_26_2.jpg','2/XBOX360-500GB_26_3.jpg','2/XBOX360-500GB_26_4.jpg','2/XBOX360-500GB_26_5.jpg','2/XBOX360-500GB_26_6.jpg',360,1,1,1,2017,NULL,0,360,0,NULL,2),(27,'','','','','\0','Microsoft',0,0,'HD','AMDx86Jaguar','1Tb','8Gb','Disabled','Disabled',0,0,'',0,'XBOX360-1TB','2/XBOX360-1TB_27_1.jpg','2/XBOX360-1TB_27_2.jpg','2/XBOX360-1TB_27_3.jpg','2/XBOX360-1TB_27_4.jpg','2/XBOX360-1TB_27_5.jpg','2/XBOX360-1TB_27_6.jpg',370,1,1,1,2017,NULL,0,370,0,NULL,2),(28,'\0','\0','','\0','\0','Nintando',0,0,'HdReady','Intel','250Gb','2Gb','Disabled','Disabled',0,0,'',0,'PRO-V1','2/PRO-V1_28_1.jpg','2/PRO-V1_28_2.jpg','2/PRO-V1_28_3.jpg','2/PRO-V1_28_4.jpg','2/PRO-V1_28_5.jpg','2/PRO-V1_28_6.jpg',99,1,1,1,2015,NULL,0,99,0,NULL,2),(29,'','','','\0','\0','Lenovo',0,0,'HD','Black','4Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-2-A10','3/TAB-2-A10_29_1.jpg','3/TAB-2-A10_29_2.jpg','3/TAB-2-A10_29_3.jpg','3/TAB-2-A10_29_4.jpg','3/TAB-2-A10_29_5.jpg','3/TAB-2-A10_29_6.jpg',160,4400,10.2,16,2016,NULL,0,160,0,NULL,3),(30,'','','','\0','\0','Lenovo',0,0,'HD','Black','2Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-8A','3/TAB-3-8A_30_1.jpg','3/TAB-3-8A_30_2.jpg','3/TAB-3-8A_30_3.jpg','3/TAB-3-8A_30_4.jpg','3/TAB-3-8A_30_5.jpg','3/TAB-3-8A_30_6.jpg',140,4200,8,16,2016,NULL,0,140,0,NULL,3),(31,'','','','\0','\0','Lenovo',0,0,'720p','Black','2Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-7A','3/TAB-3-7A_31_1.jpg','3/TAB-3-7A_31_2.jpg','3/TAB-3-7A_31_3.jpg','3/TAB-3-7A_31_4.jpg','3/TAB-3-7A_31_5.jpg','3/TAB-3-7A_31_6.jpg',130,4100,7.1,8,2016,NULL,0,130,0,NULL,3),(32,'','','','\0','\0','Lenovo',0,0,'720p','Black','2Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-71A','3/TAB-3-71A_32_1.jpg','3/TAB-3-71A_32_2.jpg','3/TAB-3-71A_32_3.jpg','3/TAB-3-71A_32_4.jpg','3/TAB-3-71A_32_5.jpg','3/TAB-3-71A_32_6.jpg',130,4100,7.1,8,2016,NULL,0,130,0,NULL,3),(33,'','','\0','\0','\0','Lenovo',0,0,'720p','Black','2Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-6A','3/TAB-3-6A_33_1.jpg','3/TAB-3-6A_33_2.jpg','3/TAB-3-6A_33_3.jpg','3/TAB-3-6A_33_4.jpg','3/TAB-3-6A_33_5.jpg','3/TAB-3-6A_33_6.jpg',110,3700,7.1,8,2016,NULL,0,110,0,NULL,3),(34,'','','','\0','\0','Samsung',0,0,'HD','Black','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'Galaxy-Tab3','3/Galaxy-Tab3_34_1.jpg','3/Galaxy-Tab3_34_2.jpg','3/Galaxy-Tab3_34_3.jpg','3/Galaxy-Tab3_34_4.jpg','3/Galaxy-Tab3_34_5.jpg','3/Galaxy-Tab3_34_6.jpg',210,4400,10.1,64,2017,NULL,0,210,0,NULL,3),(35,'','','','\0','\0','Samsung',0,0,'HD','White','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-7A','3/TAB-3-7A_35_1.jpg','3/TAB-3-7A_35_2.jpg','3/TAB-3-7A_35_3.jpg','3/TAB-3-7A_35_4.jpg','3/TAB-3-7A_35_5.jpg','3/TAB-3-7A_35_6.jpg',320,3900,7.3,128,2017,NULL,0,320,0,NULL,3),(36,'','','','\0','\0','Samsung',0,0,'HD','Silver','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-7A','3/TAB-3-7A_36_1.jpg','3/TAB-3-7A_36_2.jpg','3/TAB-3-7A_36_3.jpg','3/TAB-3-7A_36_4.jpg','3/TAB-3-7A_36_5.jpg','3/TAB-3-7A_36_6.jpg',210,3600,7.1,64,2017,NULL,0,210,0,NULL,3),(37,'','','','\0','\0','Samsung',0,0,'FullHd','Black','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'TAB-3-11A','3/TAB-3-11A_37_1.jpg','3/TAB-3-11A_37_2.jpg','3/TAB-3-11A_37_3.jpg','3/TAB-3-11A_37_4.jpg','3/TAB-3-11A_37_5.jpg','3/TAB-3-11A_37_6.jpg',270,5400,12.1,256,2017,NULL,0,270,0,NULL,3),(38,'','','','\0','\0','Apple',0,0,'HD','White','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'iPad4','3/iPad4_38_1.jpg','3/iPad4_38_2.jpg','3/iPad4_38_3.jpg','3/iPad4_38_4.jpg','3/iPad4_38_5.jpg','3/iPad4_38_6.jpg',320,4400,8.1,64,2016,NULL,0,320,0,NULL,3),(39,'','','','\0','\0','Apple',0,0,'HD','Black','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'iPad-mini','3/iPad-mini_39_1.jpg','3/iPad-mini_39_2.jpg','3/iPad-mini_39_3.jpg','3/iPad-mini_39_4.jpg','3/iPad-mini_39_5.jpg','3/iPad-mini_39_6.jpg',310,4600,8.1,64,2017,NULL,0,310,0,NULL,3),(40,'','','','\0','\0','Apple',0,0,'HD','Black','8Gb','Disabled','Disabled','Disabled',0,0,'',0,'iPad3','3/iPad3_40_1.jpg','3/iPad3_40_2.jpg','3/iPad3_40_3.jpg','3/iPad3_40_4.jpg','3/iPad3_40_5.jpg','3/iPad3_40_6.jpg',280,4000,8,64,2016,NULL,0,280,0,NULL,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'b','admin','a','107615@tut.by'),(2,'y','user','t','107615@tut.by'),(3,'admin','admin','admin','admin'),(4,' user ','user','user ','107615@tut.by');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-27 19:52:27
