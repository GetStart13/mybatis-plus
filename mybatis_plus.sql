/*
 Navicat Premium Data Transfer

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 21/04/2023 14:58:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '键盘', 1);
INSERT INTO `product` VALUES (2, '电脑', 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `del_status` int NULL DEFAULT 0,
  `gender` int NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '李小龙', NULL, 0, 0, '2021-11-28 14:57:19', '2021-11-28 14:57:19');
INSERT INTO `sys_user` VALUES (6, '李云龙', NULL, 0, 0, '2021-11-28 15:01:21', '2023-04-07 14:48:06');
INSERT INTO `sys_user` VALUES (7, '周杰伦', 24, 0, 0, '2021-11-28 19:21:56', '2021-11-28 19:21:56');
INSERT INTO `sys_user` VALUES (8, '谢洪', 24, 0, 0, '2021-11-28 19:22:08', '2021-11-28 19:22:08');
INSERT INTO `sys_user` VALUES (9, '周明', 24, 0, 0, '2021-11-29 12:24:32', '2023-04-10 10:43:10');
INSERT INTO `sys_user` VALUES (10, 'drift-bottle', 24, 0, 0, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
