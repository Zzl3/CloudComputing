/*
 Navicat Premium Data Transfer

 Source Server         : hive
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : 100.81.119.49:3307
 Source Schema         : hive

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 18/11/2022 22:28:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_thing
-- ----------------------------
DROP TABLE IF EXISTS `a_thing`;
CREATE TABLE `a_thing` (
  `id` int(11) NOT NULL,
  `ASIN` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL,
  `salesrank` int(11) DEFAULT NULL,
  `categories` int(11) DEFAULT NULL,
  `reviews` int(11) DEFAULT NULL,
  `downloaded` int(11) DEFAULT NULL,
  `avgrating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
