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

 Date: 18/11/2022 22:28:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_review
-- ----------------------------
DROP TABLE IF EXISTS `a_review`;
CREATE TABLE `a_review` (
  `id` int(11) DEFAULT NULL,
  `thingid` int(11) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `votes` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `helpful` int(11) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
