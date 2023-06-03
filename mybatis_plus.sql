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

 Date: 03/06/2023 19:29:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `id` bigint NOT NULL,
                            `user_id` bigint NULL DEFAULT NULL,
                            `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 1, '键盘');
INSERT INTO `product` VALUES (2, 2, '电脑');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                             `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             `age` int NULL DEFAULT NULL,
                             `gender` int NULL DEFAULT 0,
                             `create_time` datetime NULL DEFAULT NULL,
                             `update_time` datetime NULL DEFAULT NULL,
                             `is_deleted` int NULL DEFAULT 0 COMMENT '逻辑删除标识',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '李小龙', NULL, 0, '2021-11-28 14:57:19', '2021-11-28 14:57:19', 0);
INSERT INTO `sys_user` VALUES (6, '李云龙', NULL, 0, '2021-11-28 15:01:21', '2023-04-07 14:48:06', 0);
INSERT INTO `sys_user` VALUES (7, '周杰伦', 24, 0, '2021-11-28 19:21:56', '2021-11-28 19:21:56', 0);
INSERT INTO `sys_user` VALUES (8, '谢洪', 24, 0, '2021-11-28 19:22:08', '2021-11-28 19:22:08', 0);
INSERT INTO `sys_user` VALUES (9, '周明', 24, 0, '2021-11-29 12:24:32', '2023-04-25 03:11:55', 0);
INSERT INTO `sys_user` VALUES (10, 'drift-bottle', 24, 0, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (26, 'name', NULL, 0, '2023-05-19 17:01:44', '2023-05-19 17:01:44', 0);
INSERT INTO `sys_user` VALUES (27, 'name', NULL, 0, '2023-05-19 17:02:27', '2023-05-19 17:02:27', 0);

SET FOREIGN_KEY_CHECKS = 1;
