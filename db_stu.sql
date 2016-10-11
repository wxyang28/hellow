/*
Navicat MySQL Data Transfer

Source Server         : xu
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : db_stu

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-10-11 20:30:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ad_id` varchar(50) NOT NULL,
  `ad_password` varchar(50) NOT NULL,
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色设定\r\n管理员 0\r\n老师    1\r\n家长    2\r\n学生    3';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('supera', 'c76257bcc7d4ffac4e37273d5bb0f6ed');
INSERT INTO `admin` VALUES ('superb', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_role` enum('1','2','3') NOT NULL DEFAULT '3' COMMENT '角色设定：管理员：0，老师：1，家长：2:，学生：3',
  PRIMARY KEY (`user_name`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('Liugs', '592228741377b9f3607488d50085dd6f', '1');
INSERT INTO `login` VALUES ('Yangxx', '06215c6ab4d7f64feb881481fbcf84ab', '3');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(255) NOT NULL,
  `score_test_id` varchar(255) NOT NULL,
  `score_stu_id` varchar(255) NOT NULL,
  `score` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '未完成的试卷，成绩为-1',
  KEY `score_test_id` (`score_test_id`),
  KEY `stu_id` (`score_stu_id`),
  CONSTRAINT `stu_id` FOREIGN KEY (`score_stu_id`) REFERENCES `stu_info` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `stu_id` varchar(20) NOT NULL,
  `stu_name` varchar(50) DEFAULT NULL,
  `stu_user_name` varchar(20) NOT NULL,
  `stu_tp_id` varchar(20) DEFAULT NULL,
  `stu_sex` enum('0','1') DEFAULT '0' COMMENT '0表示男生1表示女生',
  PRIMARY KEY (`stu_id`),
  KEY `user_name` (`stu_user_name`),
  KEY `tp_id` (`stu_tp_id`),
  CONSTRAINT `tp_id` FOREIGN KEY (`stu_tp_id`) REFERENCES `tp_info` (`tp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_name` FOREIGN KEY (`stu_user_name`) REFERENCES `login` (`user_name`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('000001', '杨星星', 'Yangxx', '000001', '1');

-- ----------------------------
-- Table structure for tp_info
-- ----------------------------
DROP TABLE IF EXISTS `tp_info`;
CREATE TABLE `tp_info` (
  `tp_id` varchar(20) NOT NULL,
  `tp_name` varchar(50) DEFAULT NULL,
  `tp_user_name` varchar(20) NOT NULL,
  `tp_sex` enum('0','1') DEFAULT '0' COMMENT '0表示男生1表示女生',
  `tp_tel` int(11) DEFAULT NULL,
  `tp_role` enum('1','2') NOT NULL DEFAULT '1' COMMENT '角色设定：管理员：0，老师：1，家长：2:，学生：3',
  PRIMARY KEY (`tp_id`),
  KEY `tp_user_name` (`tp_user_name`),
  CONSTRAINT `tp_user_name` FOREIGN KEY (`tp_user_name`) REFERENCES `login` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_info
-- ----------------------------
INSERT INTO `tp_info` VALUES ('000001', '刘高生', 'Liugs', '0', '1234567890', '1');
SET FOREIGN_KEY_CHECKS=1;
