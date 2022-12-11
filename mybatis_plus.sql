/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : mybatis_plus

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2022-04-24 18:47:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(100) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '键盘', '1');
INSERT INTO `product` VALUES ('2', '电脑', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `del_status` int(1) DEFAULT '1',
  `gender` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '李小龙', '0', '0', '2021-11-28 14:57:19', '2021-11-28 14:57:19');
INSERT INTO `sys_user` VALUES ('6', '李云龙', '0', '0', '2021-11-28 15:01:21', null);
INSERT INTO `sys_user` VALUES ('7', '周杰伦', '0', '0', '2021-11-28 19:21:56', '2021-11-28 19:21:56');
INSERT INTO `sys_user` VALUES ('8', '谢洪', '0', '0', '2021-11-28 19:22:08', '2021-11-28 19:22:08');
INSERT INTO `sys_user` VALUES ('9', '谢洪', '0', '0', '2021-11-29 12:24:32', '2021-11-29 12:24:32');
INSERT INTO `sys_user` VALUES ('10', '王五', '0', '0', '2021-11-30 12:01:33', null);
INSERT INTO `sys_user` VALUES ('11', '王五', '0', '0', '2021-11-30 12:25:23', '2021-11-30 12:25:23');
INSERT INTO `sys_user` VALUES ('12', '王五', '0', '0', '2021-11-30 14:52:00', '2021-11-30 14:52:00');
INSERT INTO `sys_user` VALUES ('13', '王五', '0', '0', '2021-11-30 14:53:57', '2021-11-30 14:53:57');
INSERT INTO `sys_user` VALUES ('14', '王五', '0', '1', '2021-12-03 17:50:56', '2021-12-03 17:50:56');
INSERT INTO `sys_user` VALUES ('15', '王五', '0', '0', '2021-12-03 17:51:23', '2021-12-03 17:51:23');
