/*
Navicat MySQL Data Transfer

Source Server         : ssm-learning
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : ssm-learning

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-14 18:01:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `sex` int(2) NOT NULL DEFAULT '0' COMMENT '性别 0.男 1.女',
  `birthday` varchar(255) NOT NULL COMMENT '出生日期',
  `translate` varchar(255) NOT NULL COMMENT '籍贯',
  `email` varchar(255) NOT NULL COMMENT '邮件',
  `create_time` date DEFAULT '0000-00-00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_account
-- ----------------------------
INSERT INTO `tbl_account` VALUES ('35', 'zmd', '123', '0', '1992-2-12', '', '326550324@qq.com', '2018-07-14');
INSERT INTO `tbl_account` VALUES ('36', 'xx', '123', '0', '1992-2-12', '和', '724344579@qq.com', '2018-07-14');
INSERT INTO `tbl_account` VALUES ('37', 'xx', '123', '0', '1992-2-12', '和', '724344579@qq.com', '2018-07-14');

-- ----------------------------
-- Table structure for tbl_leaving_message
-- ----------------------------
DROP TABLE IF EXISTS `tbl_leaving_message`;
CREATE TABLE `tbl_leaving_message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `content` varchar(300) DEFAULT NULL COMMENT '内容',
  `leaving_time` datetime DEFAULT NULL COMMENT '留言时间',
  `leaving_man` varchar(255) DEFAULT NULL COMMENT '留言人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_leaving_message
-- ----------------------------
INSERT INTO `tbl_leaving_message` VALUES ('1', 'dfd', 'dfsd', '1992-12-12 00:00:00', 'sdfsd');
INSERT INTO `tbl_leaving_message` VALUES ('2', '不v', '不v', '2018-07-14 16:23:21', null);
INSERT INTO `tbl_leaving_message` VALUES ('3', '不v', '不v', '2018-07-14 16:23:31', null);
INSERT INTO `tbl_leaving_message` VALUES ('4', 'VB女', '橙V吧橙V', '2018-07-14 16:34:18', null);
INSERT INTO `tbl_leaving_message` VALUES ('5', '版本', '不v', '2018-07-14 16:35:18', null);
INSERT INTO `tbl_leaving_message` VALUES ('6', '橙V吧橙V', '吃不吃VB', '2018-07-14 16:36:36', null);
INSERT INTO `tbl_leaving_message` VALUES ('7', '下次V型从v', '秩序许昌', '2018-07-14 16:40:02', null);
INSERT INTO `tbl_leaving_message` VALUES ('8', '持续形成', '持续形成', '2018-07-14 16:40:09', null);
INSERT INTO `tbl_leaving_message` VALUES ('9', '持续形成', '秩序初学者v', '2018-07-14 16:41:29', null);

-- ----------------------------
-- Table structure for tbl_reply_message
-- ----------------------------
DROP TABLE IF EXISTS `tbl_reply_message`;
CREATE TABLE `tbl_reply_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `leaving_id` bigint(20) NOT NULL COMMENT '留言id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `reply_content` varchar(200) NOT NULL COMMENT '回复内容',
  `reply_time` datetime NOT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_reply_message
-- ----------------------------
INSERT INTO `tbl_reply_message` VALUES ('15', '0', '2', 'sdkhskjdg', '2012-12-12 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('16', '0', '3', 'sdkhskjdg', '2012-12-12 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('33', '1', '32', 'dfsadgadfga', '2018-07-14 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('34', '1', '32', 'zdbxzcbxcbxzc', '2018-07-14 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('35', '1', '32', 'svxzcbzxcbzcx', '2018-07-14 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('36', '1', '35', 'szbxzcbczvbczvbcvzb', '2018-07-14 00:00:00');
INSERT INTO `tbl_reply_message` VALUES ('37', '1', '35', '才下班宣传部宣传', '2018-07-14 15:27:06');
INSERT INTO `tbl_reply_message` VALUES ('38', '1', '35', '今年初', '2018-07-14 15:39:30');
INSERT INTO `tbl_reply_message` VALUES ('39', '1', '35', '大厦法定', '2018-07-14 16:18:10');

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', 'xxxdd', '123', '12');
INSERT INTO `user_t` VALUES ('2', 'dsfsdf', 'werfwe', '32');
