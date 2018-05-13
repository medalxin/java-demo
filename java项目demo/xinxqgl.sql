/*
Navicat MySQL Data Transfer

Source Server         : xin
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : xinxqgl

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-05-13 15:35:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `birthday` date default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李明', 'dmx215', '2009-05-12', '1');
INSERT INTO `user` VALUES ('2', 'john', 'john', '1949-10-01', '2');
INSERT INTO `user` VALUES ('3', 'john2', 'john', '1949-10-01', null);
INSERT INTO `user` VALUES ('4', 'john', 'john', '1949-10-01', null);
INSERT INTO `user` VALUES ('5', 'john', 'john', '1949-10-01', null);
INSERT INTO `user` VALUES ('6', '1', '1', '1997-01-05', '1');
