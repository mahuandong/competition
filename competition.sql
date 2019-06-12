/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : competition

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 06/06/2019 15:14:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `role` int(11) NOT NULL COMMENT '0管理员1裁判',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员', 'admin', '123456', 0);
INSERT INTO `admin` VALUES (2, '裁判1', 'referee', '123456', 1);
INSERT INTO `admin` VALUES (3, '裁判2', 'referee2', '123456', 1);
INSERT INTO `admin` VALUES (4, '裁判3', 'referee3', '123456', 1);
INSERT INTO `admin` VALUES (5, '裁判4', 'referee4', '123456', 1);

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '比赛名称',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '比赛详情',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, '歌唱比赛', '2019-06-04 16:00:00', '2019-06-05 16:00:00', 'asd ');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `grade_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_id` int(10) NULL DEFAULT NULL COMMENT '比赛id',
  `player_id` int(10) NULL DEFAULT NULL COMMENT '选手id',
  `admin_id` int(10) NULL DEFAULT NULL COMMENT '裁判id',
  `grade` double(10, 2) NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`grade_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, 1, 1, 2, 5.60);
INSERT INTO `grade` VALUES (2, 1, 1, 3, 8.00);
INSERT INTO `grade` VALUES (3, 1, 1, 4, 7.00);
INSERT INTO `grade` VALUES (4, 1, 1, 5, 8.00);
INSERT INTO `grade` VALUES (5, 1, 1, 6, 9.00);
INSERT INTO `grade` VALUES (6, 1, 1, 7, 6.00);
INSERT INTO `grade` VALUES (7, 1, 1, 8, 9.90);
INSERT INTO `grade` VALUES (8, 1, 1, 9, 9.60);
INSERT INTO `grade` VALUES (9, 1, 1, 10, 9.80);
INSERT INTO `grade` VALUES (10, 1, 1, 11, 9.70);
INSERT INTO `grade` VALUES (13, 1, 1, 2, 9.00);

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `player_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`player_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (1, '比熊犬', 23, '13543211234');
INSERT INTO `player` VALUES (2, '中型犬', 10, '13543211234');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `schedule_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_id` int(10) NULL DEFAULT NULL COMMENT '比赛编码',
  `player_id` int(10) NULL DEFAULT NULL COMMENT '选手编码',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属组别',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`schedule_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (1, 1, 1, '第一组', '侠客行');

SET FOREIGN_KEY_CHECKS = 1;
