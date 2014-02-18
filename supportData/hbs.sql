/*
SQLyog Ultimate v10.42 
MySQL - 5.6.10 : Database - hbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hbs`;

/*Table structure for table `hbs_city` */

DROP TABLE IF EXISTS `hbs_city`;

CREATE TABLE `hbs_city` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(20) NOT NULL,
  `CITY_CODE` varchar(20) NOT NULL,
  `PROVINCE_ID` int(10) NOT NULL,
  `PROVINCE_CODE` varchar(20) NOT NULL,
  `CITY_KEY` varchar(20) DEFAULT NULL,
  `CITY_SPELLING` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_city` */

insert  into `hbs_city`(`ID`,`CITY_NAME`,`CITY_CODE`,`PROVINCE_ID`,`PROVINCE_CODE`,`CITY_KEY`,`CITY_SPELLING`) values (1,'珠海','0756',7,'GuangDong','z','zhuhai'),(2,'菏泽','123456',1,'SHD',NULL,NULL),(3,'广州','020',7,'GUD',NULL,NULL),(4,'梅州','0753',7,'GUD',NULL,NULL),(8,'11111','11111',7,'GUD',NULL,NULL),(9,'333333','555555',1,'SHD',NULL,NULL),(10,'青岛','33456',1,'SHD',NULL,NULL),(11,'55555','55555',2,'JSU',NULL,NULL),(12,'7777','8888',1,'SHD',NULL,NULL),(13,'烟台','2222',1,'SHD',NULL,NULL),(14,'7777','8888',1,'SHD',NULL,NULL),(15,'深圳','0765',7,'GUD',NULL,NULL),(16,'上海','020',6,'SHA',NULL,NULL);

/*Table structure for table `hbs_consumer_info` */

DROP TABLE IF EXISTS `hbs_consumer_info`;

CREATE TABLE `hbs_consumer_info` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LOGIN_ACCOUNT` varchar(50) NOT NULL COMMENT '登录名字',
  `LOGIN_PASSWORD` varchar(50) NOT NULL COMMENT '登录密码',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '真实名字',
  `SEX` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1-男，0-女',
  `LBC_CODE` varchar(20) DEFAULT NULL,
  `CITY_CODE` varchar(20) DEFAULT NULL,
  `DISTRICT_CODE` varchar(20) DEFAULT NULL,
  `ZIP_CODE` varchar(10) DEFAULT NULL,
  `ADDRESS_LINE` varchar(100) DEFAULT NULL,
  `CONTRACT_NAME` varchar(20) DEFAULT NULL,
  `CONTRACT_PHONE` varchar(20) DEFAULT NULL,
  `EMAIL_ADDR` varchar(50) DEFAULT NULL,
  `QQ_NUMBER` varchar(20) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  `COMMUNITY_CODE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_UK1` (`LOGIN_ACCOUNT`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_consumer_info` */

insert  into `hbs_consumer_info`(`ID`,`LOGIN_ACCOUNT`,`LOGIN_PASSWORD`,`USER_NAME`,`SEX`,`LBC_CODE`,`CITY_CODE`,`DISTRICT_CODE`,`ZIP_CODE`,`ADDRESS_LINE`,`CONTRACT_NAME`,`CONTRACT_PHONE`,`EMAIL_ADDR`,`QQ_NUMBER`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`,`COMMUNITY_CODE`) values (7,'xuzhike','pwd',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-02-18 23:39:32',NULL,NULL,NULL);

/*Table structure for table `hbs_consumer_service_favorite` */

DROP TABLE IF EXISTS `hbs_consumer_service_favorite`;

CREATE TABLE `hbs_consumer_service_favorite` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `SERVICE_PROVIDER_CODE` varchar(20) NOT NULL,
  `SERVICE_FAVORITE_DESC` varchar(2000) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_consumer_service_favorite` */

insert  into `hbs_consumer_service_favorite`(`ID`,`USER_ID`,`SERVICE_PROVIDER_CODE`,`SERVICE_FAVORITE_DESC`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (3,2,'spCode1','desc',NULL,NULL,NULL,NULL),(4,2,'spCode2','desc',NULL,NULL,NULL,NULL),(5,3,'spCode1','desc',NULL,'2013-10-10 22:56:24',NULL,NULL),(6,3,'spCode2','desc',NULL,'2013-10-10 22:56:24',NULL,NULL);

/*Table structure for table `hbs_consumer_service_order` */

DROP TABLE IF EXISTS `hbs_consumer_service_order`;

CREATE TABLE `hbs_consumer_service_order` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `ORDER_NUM` varchar(50) NOT NULL,
  `SERVICE_PROVIDER_CODE` varchar(50) NOT NULL,
  `ORDER_DESC` varchar(100) DEFAULT NULL,
  `PRICE` double NOT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`,`PRICE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_consumer_service_order` */

insert  into `hbs_consumer_service_order`(`ID`,`USER_ID`,`ORDER_NUM`,`SERVICE_PROVIDER_CODE`,`ORDER_DESC`,`PRICE`,`STATUS`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (0000000001,2,'order-1','spCode1',NULL,12,'0',NULL,NULL,NULL,NULL),(0000000002,2,'order-2','spCode2',NULL,567,'0',NULL,NULL,NULL,NULL),(0000000003,3,'order-1','spCode1',NULL,12,'0',NULL,'2013-10-10 22:56:24',NULL,NULL),(0000000004,3,'order-2','spCode2',NULL,567,'0',NULL,'2013-10-10 22:56:24',NULL,NULL);

/*Table structure for table `hbs_contact_method` */

DROP TABLE IF EXISTS `hbs_contact_method`;

CREATE TABLE `hbs_contact_method` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `DISCRIMINATOR` char(1) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `VALUE` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_contact_method` */

insert  into `hbs_contact_method`(`ID`,`DISCRIMINATOR`,`USER_ID`,`TYPE`,`VALUE`,`DESCRIPTION`) values (1,'C',7,'QQ','111111111',NULL),(2,'C',7,'Email','abc@163.com',NULL),(3,'P',5,'QQ','2222222',NULL),(4,'P',5,'Email','abc@qq.com',NULL);

/*Table structure for table `hbs_district` */

DROP TABLE IF EXISTS `hbs_district`;

CREATE TABLE `hbs_district` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DISTRICT_NAME` varchar(20) NOT NULL,
  `DISCTRICT_CODE` varchar(20) NOT NULL,
  `CITY_ID` int(10) NOT NULL,
  `CITY_CODE` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `KEYWORDS` varchar(500) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_MODIFIED_BY` varchar(50) DEFAULT NULL,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DISTRICT_UK1` (`DISCTRICT_CODE`,`CITY_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_district` */

insert  into `hbs_district`(`ID`,`DISTRICT_NAME`,`DISCTRICT_CODE`,`CITY_ID`,`CITY_CODE`,`DESCRIPTION`,`KEYWORDS`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (2,'高新区','highTechZone',1,'zhuhai',NULL,'gaoxin',NULL,'2014-01-23 22:10:09',NULL,'2013-10-09 22:29:21'),(3,'香洲区','xiangzhou',1,'0756',NULL,NULL,NULL,'2014-01-30 14:00:12',NULL,'2014-01-30 14:00:13'),(8,'西区','xiqu',1,'0756','西区介绍',NULL,NULL,'2014-01-30 14:14:45',NULL,'2014-01-30 14:14:45'),(9,'测试','ceshi',1,'0756','测试说明',NULL,NULL,'2014-01-30 14:15:25',NULL,'2014-01-30 14:15:25'),(10,'青岛','0099999',10,'33456','',NULL,NULL,'2014-02-16 22:24:15',NULL,'2014-02-16 22:24:15');

/*Table structure for table `hbs_lbc_association` */

DROP TABLE IF EXISTS `hbs_lbc_association`;

CREATE TABLE `hbs_lbc_association` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MASTER_LBC_CODE` varchar(100) NOT NULL,
  `NEIGHBOUR_LBC_CODE` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LBC_ASSO_UK1` (`MASTER_LBC_CODE`,`NEIGHBOUR_LBC_CODE`),
  KEY `LBC_ASSO_FK2` (`NEIGHBOUR_LBC_CODE`),
  CONSTRAINT `LBC_ASSO_FK1` FOREIGN KEY (`MASTER_LBC_CODE`) REFERENCES `hbs_life_business_circle` (`CIRCLE_CODE`),
  CONSTRAINT `LBC_ASSO_FK2` FOREIGN KEY (`NEIGHBOUR_LBC_CODE`) REFERENCES `hbs_life_business_circle` (`CIRCLE_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_lbc_association` */

insert  into `hbs_lbc_association`(`ID`,`MASTER_LBC_CODE`,`NEIGHBOUR_LBC_CODE`) values (4,'jinding','tangjia'),(1,'tangjia','jinding');

/*Table structure for table `hbs_life_business_circle` */

DROP TABLE IF EXISTS `hbs_life_business_circle`;

CREATE TABLE `hbs_life_business_circle` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CIRCLE_NAME` varchar(100) NOT NULL,
  `CIRCLE_CODE` varchar(100) NOT NULL,
  `DISTRICT_CODE` varchar(50) NOT NULL,
  `DISTRICT_ID` int(10) NOT NULL,
  `KEYWORDS` varchar(500) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_MODIFIED_BY` varchar(50) DEFAULT NULL,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LBC_UK1` (`CIRCLE_CODE`,`DISTRICT_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_life_business_circle` */

insert  into `hbs_life_business_circle`(`ID`,`CIRCLE_NAME`,`CIRCLE_CODE`,`DISTRICT_CODE`,`DISTRICT_ID`,`KEYWORDS`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`,`DESCRIPTION`) values (1,'唐家镇','tangjia','highTechZone',2,NULL,NULL,'2013-10-09 22:29:21',NULL,'2013-10-09 22:29:21',NULL),(2,'金鼎','jinding','highTechZone',2,NULL,NULL,'2013-10-09 22:29:21',NULL,'2013-10-09 22:29:21',NULL),(3,'唐家生活圈','tangjiashenghuo','highTechZone',2,NULL,NULL,'2014-01-31 15:44:51',NULL,'2014-01-31 15:44:51','唐家生活圈说明'),(4,'凤凰北','fenghuangbei','xiangzhou',3,NULL,NULL,'2014-01-31 15:48:25',NULL,'2014-01-31 15:48:25','凤凰北商业圈'),(5,'3333','4444','ceshi',9,NULL,NULL,'2014-01-31 16:02:17',NULL,'2014-01-31 16:02:17','5555'),(6,'4444444','5555555','ceshi',9,NULL,NULL,'2014-01-31 16:02:45',NULL,'2014-01-31 16:02:45','666666'),(7,'55555','55555','ceshi',9,NULL,NULL,'2014-01-31 16:06:30',NULL,'2014-01-31 16:06:30','55555'),(8,'青岛圈','11111111','0099999',10,NULL,NULL,'2014-02-16 22:25:06',NULL,'2014-02-16 22:25:06','');

/*Table structure for table `hbs_news` */

DROP TABLE IF EXISTS `hbs_news`;

CREATE TABLE `hbs_news` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NEWS_TITLE` varchar(200) NOT NULL,
  `NEWS_CONTENTS` text NOT NULL,
  `NEWS_FROM_DATE` datetime DEFAULT NULL,
  `NEWS_TO_DATE` datetime DEFAULT NULL,
  `NEWS_AUTHOR` varchar(20) DEFAULT NULL,
  `NEWS_SOURCE` varchar(10) DEFAULT NULL,
  `NEWS_TYPE` varchar(10) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hbs_news` */

/*Table structure for table `hbs_province` */

DROP TABLE IF EXISTS `hbs_province`;

CREATE TABLE `hbs_province` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PROVIDER_NAME` varchar(20) NOT NULL,
  `PROVIDER_CODE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PRO_CODE_UK` (`PROVIDER_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_province` */

insert  into `hbs_province`(`ID`,`PROVIDER_NAME`,`PROVIDER_CODE`) values (1,'山东','SHD'),(2,'江苏','JSU'),(3,'安徽','ANH'),(4,'浙江','ZHJ'),(5,'福建','FUJ'),(6,'上海','SHA'),(7,'广东','GUD'),(8,'广西','GUX'),(9,'海南','HAN'),(10,'湖北','HUB'),(11,'湖南','HUN'),(12,'河南','HEN'),(13,'江西','JIX'),(14,'北京','BJI'),(15,'天津','TIJ'),(16,'河北','HEB'),(17,'山西','SHX'),(18,'内蒙古','NMG'),(19,'宁夏','NIX'),(20,'新疆','XIN'),(21,'青海','QIH'),(22,'陕西','SXI'),(23,'甘肃','GAS'),(24,'四川','SIC'),(25,'云南','YUN'),(26,'贵州','GZH'),(27,'西藏','XZA'),(28,'重庆','CHQ'),(29,'辽宁','LIN'),(30,'吉林','JIL'),(31,'黑龙江','HLJ'),(32,'台湾','TWA'),(33,'香港','HKG'),(34,'澳门','AOM');

/*Table structure for table `hbs_service_category` */

DROP TABLE IF EXISTS `hbs_service_category`;

CREATE TABLE `hbs_service_category` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(50) NOT NULL,
  `CATEGORY_CODE` varchar(50) NOT NULL,
  `CATEGORY_PARENT_CODE` varchar(50) DEFAULT NULL,
  `CATEGORY_REMARKS` text,
  `DISP_SEQUENCE` int(10) DEFAULT '0',
  `ACTIVE` tinyint(1) DEFAULT '1',
  `AMOUNT_ON_SIDE_BAR` int(10) NOT NULL DEFAULT '6',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` timestamp NULL DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`,`CATEGORY_CODE`),
  UNIQUE KEY `CATEGORY_UK` (`CATEGORY_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_service_category` */

insert  into `hbs_service_category`(`ID`,`CATEGORY_NAME`,`CATEGORY_CODE`,`CATEGORY_PARENT_CODE`,`CATEGORY_REMARKS`,`DISP_SEQUENCE`,`ACTIVE`,`AMOUNT_ON_SIDE_BAR`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (5,'餐饮美食','1000',NULL,NULL,1,1,9,NULL,NULL,NULL,NULL),(6,'休闲娱乐','1500',NULL,NULL,9,1,6,NULL,NULL,NULL,NULL),(7,'购物商店','2000',NULL,NULL,4,1,6,NULL,NULL,NULL,NULL),(8,'维修服务','2300',NULL,NULL,2,1,6,NULL,NULL,NULL,NULL),(9,'银行服务','2500',NULL,NULL,5,1,6,NULL,NULL,NULL,NULL),(10,'水电部门','2800',NULL,NULL,70,1,6,NULL,NULL,NULL,NULL),(11,'医疗健康','3000',NULL,NULL,3,1,6,NULL,NULL,NULL,NULL),(12,'便民服务','3300',NULL,NULL,6,1,6,NULL,NULL,NULL,NULL),(13,'果蔬服务','3600',NULL,NULL,7,1,6,NULL,NULL,NULL,NULL);

/*Table structure for table `hbs_service_item` */

DROP TABLE IF EXISTS `hbs_service_item`;

CREATE TABLE `hbs_service_item` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SERVICE_NAME` varchar(50) NOT NULL,
  `SERVICE_CODE` varchar(50) NOT NULL,
  `SERVICE_CATEGORY_ID` int(11) NOT NULL,
  `SERVICE_REMARKS` text,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `PRIORITY_WEIGHT` int(10) NOT NULL DEFAULT '0',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` timestamp NULL DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_service_item` */

insert  into `hbs_service_item`(`ID`,`SERVICE_NAME`,`SERVICE_CODE`,`SERVICE_CATEGORY_ID`,`SERVICE_REMARKS`,`ACTIVE`,`PRIORITY_WEIGHT`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (7,'小吃快餐','1000100',5,NULL,1,10,NULL,NULL,NULL,NULL),(8,'川菜','1000101',5,NULL,1,5,NULL,NULL,NULL,NULL),(9,'湘菜','1000102',5,NULL,1,5,NULL,NULL,NULL,NULL),(10,'西餐','1000103',5,NULL,1,0,NULL,NULL,NULL,NULL),(11,'火锅','1000104',5,NULL,1,0,NULL,NULL,NULL,NULL),(12,'面包蛋糕','1000105',5,NULL,1,0,NULL,NULL,NULL,NULL),(13,'粤菜','1000106',5,NULL,1,5,NULL,NULL,NULL,NULL),(14,'甜品饮品','1000107',5,NULL,1,0,NULL,NULL,NULL,NULL),(15,'海鲜','1000108',5,NULL,1,0,NULL,NULL,NULL,NULL),(16,'KTV','1500100',6,NULL,1,0,NULL,NULL,NULL,NULL),(17,'咖啡与茶','1500102',6,NULL,1,0,NULL,NULL,NULL,NULL),(18,'酒吧','1500103',6,NULL,1,0,NULL,NULL,NULL,NULL),(19,'运动健身','1500104',6,NULL,1,0,NULL,NULL,NULL,NULL),(20,'足浴洗浴','1500105',6,NULL,1,0,NULL,NULL,NULL,NULL),(21,'电影院','1500106',6,NULL,1,0,NULL,NULL,NULL,NULL),(22,'演出场所','1500107',6,NULL,1,0,NULL,NULL,NULL,NULL),(23,'美容美体','1500108',6,NULL,1,0,NULL,NULL,NULL,NULL),(24,'电玩游戏厅','1500109',6,NULL,1,0,NULL,NULL,NULL,NULL),(25,'书店图书馆','1500110',6,NULL,1,0,NULL,NULL,NULL,NULL),(26,'公园景点','1500111',6,NULL,1,0,NULL,NULL,NULL,NULL),(27,'超市便利店','2000100',7,NULL,1,0,NULL,NULL,NULL,NULL),(28,'服装饰品店','2000101',7,NULL,1,0,NULL,NULL,NULL,NULL),(29,'鞋帽箱皮包具','2000102',7,NULL,1,0,NULL,NULL,NULL,NULL),(30,'家具装潢','2000103',7,NULL,1,0,NULL,NULL,NULL,NULL),(31,'运动/户外用品','2000104',7,NULL,1,0,NULL,NULL,NULL,NULL),(32,'通讯\\数码产品','2000105',7,NULL,1,0,NULL,NULL,NULL,NULL),(33,'食品/零食店','2000106',7,NULL,1,0,NULL,NULL,NULL,NULL),(34,'婴童用品店','2000107',7,NULL,1,0,NULL,NULL,NULL,NULL),(35,'茶叶店','2000108',7,NULL,1,0,NULL,NULL,NULL,NULL),(36,'化妆品店','2000109',7,NULL,1,0,NULL,NULL,NULL,NULL),(37,'特产店','2000110',7,NULL,1,0,NULL,NULL,NULL,NULL),(38,'烟酒专卖店','2000111',7,NULL,1,0,NULL,NULL,NULL,NULL),(39,'钟表眼镜店','2000112',7,NULL,1,0,NULL,NULL,NULL,NULL),(40,'花店','2000113',7,NULL,1,0,NULL,NULL,NULL,NULL),(41,'珠宝首饰店','2000114',7,NULL,1,0,NULL,NULL,NULL,NULL),(42,'专柜/摊位','2000115',7,NULL,1,0,NULL,NULL,NULL,NULL),(43,'家私城','2000116',7,NULL,1,0,NULL,NULL,NULL,NULL),(44,'二手市场','2000117',7,NULL,1,0,NULL,NULL,NULL,NULL),(45,'电器专卖店','2000118',7,NULL,1,0,NULL,NULL,NULL,NULL),(46,'自行车维修','2300100',8,NULL,1,10,NULL,NULL,NULL,NULL),(47,'家电维修','2300101',8,NULL,1,8,NULL,NULL,NULL,NULL),(48,'汽车维修','2300102',8,NULL,1,5,NULL,NULL,NULL,NULL),(49,'电脑维修','2300103',8,NULL,1,1,NULL,NULL,NULL,NULL),(50,'中国银行','2500100',9,NULL,1,0,NULL,NULL,NULL,NULL),(51,'工商银行','2500101',9,NULL,1,0,NULL,NULL,NULL,NULL),(52,'建设银行','2500102',9,NULL,1,0,NULL,NULL,NULL,NULL),(53,'农业银行','2500103',9,NULL,1,0,NULL,NULL,NULL,NULL),(54,'招商银行','2500104',9,NULL,1,0,NULL,NULL,NULL,NULL),(55,'交通银行','2500105',9,NULL,1,0,NULL,NULL,NULL,NULL),(56,'供电局','2800100',10,NULL,1,0,NULL,NULL,NULL,NULL),(57,'供水公司','2800101',10,NULL,1,0,NULL,NULL,NULL,NULL),(58,'医院诊所','3000100',11,NULL,1,0,NULL,NULL,NULL,NULL),(59,'药店','3000101',11,NULL,1,0,NULL,NULL,NULL,NULL),(60,'保洁','3300100',12,NULL,1,0,NULL,NULL,NULL,NULL),(61,'洗衣店','3300101',12,NULL,1,0,NULL,NULL,NULL,NULL),(62,'家政保姆','3300102',12,NULL,1,0,NULL,NULL,NULL,NULL),(63,'母婴','3300103',12,NULL,1,0,NULL,NULL,NULL,NULL),(64,'宠物店','3300104',12,NULL,1,0,NULL,NULL,NULL,NULL),(65,'菜市场','3600100',13,NULL,1,0,NULL,NULL,NULL,NULL),(66,'水果店','3600101',13,NULL,1,0,NULL,NULL,NULL,NULL);

/*Table structure for table `hbs_service_provider` */

DROP TABLE IF EXISTS `hbs_service_provider`;

CREATE TABLE `hbs_service_provider` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PROVIDER_NAME` varchar(100) NOT NULL,
  `PROVIDER_CODE` varchar(50) NOT NULL,
  `LOGIN_ACCOUNT` varchar(20) NOT NULL,
  `LOGIN_PASSWORD` varchar(20) NOT NULL,
  `PROVIDER_DESCRIPTION` longtext,
  `ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  `SERVICE_KEYWORD` text,
  `PLACE_KEYWORD` text,
  `CITY_CODE` varchar(50) DEFAULT NULL,
  `DISTRICT_CODE` varchar(20) DEFAULT NULL,
  `LBC_CODE` varchar(20) DEFAULT NULL,
  `ZIP_CODE` varchar(10) DEFAULT NULL,
  `ADDRESS_LINE` varchar(100) DEFAULT NULL,
  `CONTRACT_NAME` varchar(50) DEFAULT NULL,
  `CONTRACT_PHONE` varchar(50) DEFAULT NULL,
  `EMAIL_ADDR` varchar(50) DEFAULT NULL,
  `QQ_NUMBER` varchar(50) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_service_provider` */

insert  into `hbs_service_provider`(`ID`,`PROVIDER_NAME`,`PROVIDER_CODE`,`LOGIN_ACCOUNT`,`LOGIN_PASSWORD`,`PROVIDER_DESCRIPTION`,`ACTIVE`,`SERVICE_KEYWORD`,`PLACE_KEYWORD`,`CITY_CODE`,`DISTRICT_CODE`,`LBC_CODE`,`ZIP_CODE`,`ADDRESS_LINE`,`CONTRACT_NAME`,`CONTRACT_PHONE`,`EMAIL_ADDR`,`QQ_NUMBER`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (1,'唐家康美来药店','kangMeiLai','account','pwd',NULL,1,NULL,'tangjia kangmeilai yaodian','0753',NULL,'075301001','514245',NULL,'contactPerson','phone','email','qq','system','2013-10-08 22:35:48',NULL,NULL),(3,'唐家康美来药店5','kangMeiLai5','account','pwd',NULL,1,NULL,'tangjia kangmeilai yaodian','0753',NULL,'075301001','514245',NULL,'contactPerson','phone','email','qq','system','2013-10-08 22:40:51',NULL,NULL),(4,'唐家康美来药店57','kangMeiLai57','account','pwd',NULL,1,NULL,'tangjia kangmeilai yaodian','0753',NULL,'075301001','514245',NULL,'contactPerson','phone','email','qq','system','2013-10-08 22:44:17',NULL,NULL),(5,'name','code','account','pwd',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-02-18 23:48:52',NULL,NULL);

/*Table structure for table `hbs_sp_product_pic` */

DROP TABLE IF EXISTS `hbs_sp_product_pic`;

CREATE TABLE `hbs_sp_product_pic` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PIC_STORED_NAME` varchar(300) NOT NULL,
  `PIC_ORIGINAL_NAME` varchar(100) NOT NULL,
  `PICTURE_DESC` varchar(200) DEFAULT NULL,
  `SERVICE_PROVIDER_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hbs_sp_product_pic` */

/*Table structure for table `hbs_sp_service` */

DROP TABLE IF EXISTS `hbs_sp_service`;

CREATE TABLE `hbs_sp_service` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SP_SERVICE_CODE` varchar(50) NOT NULL,
  `REMARKS` varchar(100) DEFAULT NULL,
  `DISPLAY_ORDER` int(10) unsigned NOT NULL DEFAULT '1',
  `SERVICE_PROVIDER_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `hbs_sp_service` */

insert  into `hbs_sp_service`(`ID`,`SP_SERVICE_CODE`,`REMARKS`,`DISPLAY_ORDER`,`SERVICE_PROVIDER_ID`,`CREATED_BY`,`CREATED_DATE`,`LAST_MODIFIED_BY`,`LAST_MODIFIED_DATE`) values (1,'serviceItemCode',NULL,0,3,NULL,NULL,NULL,NULL),(2,'serviceItemCode2',NULL,0,4,NULL,NULL,NULL,NULL);

/*Table structure for table `hbs_tag` */

DROP TABLE IF EXISTS `hbs_tag`;

CREATE TABLE `hbs_tag` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TAG_NAME` varchar(20) CHARACTER SET cp1250 NOT NULL,
  `TAG_DESC` varchar(100) CHARACTER SET cp1250 DEFAULT NULL,
  `TAG_SOURCE` varchar(20) CHARACTER SET cp1250 NOT NULL,
  `TAG_OWNER` varchar(20) CHARACTER SET cp1250 NOT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET cp1250 DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(20) CHARACTER SET cp1250 DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hbs_tag` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
