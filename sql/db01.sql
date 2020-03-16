/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云MySQL
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 47.100.230.188:3306
 Source Schema         : db01

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/03/2020 16:58:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '员工姓名',
  `db` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当前数据库名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '开发部', 'DB01');
INSERT INTO `dept` VALUES (2, '人事部', 'DB01');
INSERT INTO `dept` VALUES (3, '财务部', 'DB01');
INSERT INTO `dept` VALUES (4, '市场部', 'DB01');
INSERT INTO `dept` VALUES (5, '运维部', 'DB01');
INSERT INTO `dept` VALUES (6, '产品部', 'DB01');
INSERT INTO `dept` VALUES (7, '小卖部', 'DB01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
