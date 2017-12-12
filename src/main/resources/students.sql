/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7 3307
Source Server Version : 50719
Source Host           : localhost:3307
Source Database       : jpm_171113_mybatis_demo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-21 14:55:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `STUD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `BIO` longtext,
  `PIC` blob,
  `ADDR_ID` int(11) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  PRIMARY KEY (`STUD_ID`)
);

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', 'Timothy', 'timothy@gmail.com', '123-123-1234', '1988-04-25', null, null, '3', '1');
INSERT INTO `students` VALUES ('2', 'Douglas', 'douglas@gmail.com', '789-456-1234', '1990-08-15', null, null, '4', '1');
INSERT INTO `students` VALUES ('3', 'student3', 'student_3gmail.com', '789-456-1234', '2017-11-17', null, null, null, '0');
INSERT INTO `students` VALUES ('4', 'student4', 'student_4@gmail.com', '123-456-7890', '2017-11-17', null, null, null, '1');
INSERT INTO `students` VALUES ('5', 'student5', 'student_5@gmail.com', null, '2017-11-18', null, null, null, '0');
INSERT INTO `students` VALUES ('8', 'dde', '33@e.com', null, null, null, null, null, '0');
INSERT INTO `students` VALUES ('14', 'Raiden12', 'a@b.com', null, '2017-11-21', null, null, null, '1');
