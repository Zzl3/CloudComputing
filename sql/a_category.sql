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

 Date: 18/11/2022 22:28:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_category
-- ----------------------------
DROP TABLE IF EXISTS `a_category`;
CREATE TABLE `a_category` (
  `id` int(11) DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
