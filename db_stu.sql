/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2016-10-11 14:06:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ad_id` varchar(11) NOT NULL COMMENT 'admin',
  `ad_password` varchar(50) NOT NULL COMMENT 'admin',
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_key` varchar(50) NOT NULL COMMENT '登陆密码',
  `role` enum('3','2','0','1') NOT NULL DEFAULT '3' COMMENT '角色：管理员：0；老师：1；家长：2；学生：3。默认学生',
  PRIMARY KEY (`user_name`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('杨星星', '123456', '3');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL,
  `score_test_id` int(20) DEFAULT NULL COMMENT '卷子编号',
  `score_stu_id` int(20) NOT NULL COMMENT '学生编号',
  `scores` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `score_stu_id` (`score_stu_id`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`score_stu_id`) REFERENCES `stu_info` (`stu_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `stu_id` int(20) NOT NULL COMMENT '学生编号',
  `stu_tp_id` int(20) DEFAULT NULL COMMENT '老师家长编号',
  `stu_user_name` varchar(50) NOT NULL COMMENT '注册时的用户名',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stu_sex` varchar(11) DEFAULT NULL COMMENT '学生性别',
  `stu_test_id` varchar(20) DEFAULT NULL COMMENT '考试编号',
  PRIMARY KEY (`stu_id`),
  KEY `stu_tp_id` (`stu_tp_id`),
  KEY `stu_info_ibfk_1` (`stu_user_name`),
  CONSTRAINT `stu_info_ibfk_1` FOREIGN KEY (`stu_user_name`) REFERENCES `login` (`user_name`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `stu_info_ibfk_2` FOREIGN KEY (`stu_tp_id`) REFERENCES `tp_info` (`tp_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------

-- ----------------------------
-- Table structure for tp_info
-- ----------------------------
DROP TABLE IF EXISTS `tp_info`;
CREATE TABLE `tp_info` (
  `tp_id` int(11) NOT NULL,
  `tp_name` varchar(20) DEFAULT NULL COMMENT '老师姓名',
  `tp_user_name` varchar(20) NOT NULL COMMENT '用户名',
  `tp_role` varchar(11) DEFAULT NULL COMMENT '角色：t代表老师；p代表家长',
  `tp_tel` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `tp_sex` varchar(11) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`tp_id`),
  KEY `tp_info_ibfk_1` (`tp_user_name`),
  CONSTRAINT `tp_info_ibfk_1` FOREIGN KEY (`tp_user_name`) REFERENCES `login` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_info
-- ----------------------------
