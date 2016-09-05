/*
SQLyog Community v12.2.4 (64 bit)
MySQL - 5.7.14-log : Database - sceonblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sceonblog` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `sceonblog`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(10) NOT NULL,
  `categoryId` int(10) NOT NULL DEFAULT '0',
  `title` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `subtitle` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `like` int(10) NOT NULL DEFAULT '0',
  `unlike` int(10) NOT NULL DEFAULT '0',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article` */

/*Table structure for table `article_category` */

DROP TABLE IF EXISTS `article_category`;

CREATE TABLE `article_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(10) NOT NULL,
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article_category` */

/*Table structure for table `article_series` */

DROP TABLE IF EXISTS `article_series`;

CREATE TABLE `article_series` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(10) NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `articleUpdateTime` timestamp NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article_series` */

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(10) NOT NULL,
  `name` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `alias` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parentId` int(10) NOT NULL DEFAULT '0',
  `pageId` int(10) NOT NULL DEFAULT '0',
  `ordinal` int(2) NOT NULL DEFAULT '0',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `menu` */

insert  into `menu`(`id`,`guid`,`userId`,`name`,`alias`,`parentId`,`pageId`,`ordinal`,`updateTime`,`status`) values
(1,'c437e218760742e8aff7ab6736e1379e',1,'首页','首页',0,0,1,'2016-09-03 11:20:22',2);

/*Table structure for table `page` */

DROP TABLE IF EXISTS `page`;

CREATE TABLE `page` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(10) NOT NULL,
  `alias` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `page` */

/*Table structure for table `user_log` */

DROP TABLE IF EXISTS `user_log`;

CREATE TABLE `user_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `username` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `src` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dst` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `opResult` int(1) NOT NULL,
  `opTime` timestamp NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_log` */

/*Table structure for table `visitor_log` */

DROP TABLE IF EXISTS `visitor_log`;

CREATE TABLE `visitor_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL DEFAULT '0',
  `ip` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(2) NOT NULL,
  `dstId` int(10) NOT NULL,
  `opDesc` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opTime` timestamp NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `visitor_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
