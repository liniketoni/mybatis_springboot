/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : db_idshow

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2022-10-11 15:29:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ca_number
-- ----------------------------
DROP TABLE IF EXISTS `ca_number`;
CREATE TABLE `ca_number` (
  `Game_accounts` int NOT NULL,
  `User_no` int NOT NULL,
  `game_server` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `g_password` varchar(255) NOT NULL,
  `telephone_number` int NOT NULL,
  `game_nike` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`Game_accounts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ca_number
-- ----------------------------

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `User_no` int NOT NULL,
  `Game_accoounts` int NOT NULL,
  `Price` double(10,2) DEFAULT NULL,
  `Current` double DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `Details` varchar(255) DEFAULT NULL,
  `Game_name` varchar(255) NOT NULL,
  `d_update` datetime DEFAULT NULL,
  `d_createdate` datetime DEFAULT NULL,
  `D_no` int NOT NULL,
  `Product_no` int NOT NULL,
  PRIMARY KEY (`D_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of details
-- ----------------------------

-- ----------------------------
-- Table structure for product_image
-- ----------------------------
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE `product_image` (
  `Product_no` int NOT NULL,
  `carousel_diagram` tinyint DEFAULT NULL,
  `header_image` tinyint DEFAULT NULL,
  `p_update` datetime DEFAULT NULL,
  `p_creatdate` datetime NOT NULL,
  `Image_no` int NOT NULL,
  PRIMARY KEY (`Image_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_image
-- ----------------------------

-- ----------------------------
-- Table structure for product_variety
-- ----------------------------
DROP TABLE IF EXISTS `product_variety`;
CREATE TABLE `product_variety` (
  `product_variety` varchar(255) NOT NULL,
  `Product_no` int NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `pr_update` datetime DEFAULT NULL,
  `pr_createdate` datetime NOT NULL,
  PRIMARY KEY (`Product_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_variety
-- ----------------------------

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `Seller_no` int NOT NULL,
  `Buyers_no` int NOT NULL,
  `Game_account` int NOT NULL,
  `t_update` datetime DEFAULT NULL,
  `t_createdate` datetime NOT NULL,
  `t_status` varchar(255) NOT NULL,
  `t_amount` double(255,0) DEFAULT NULL,
  `t_results` tinyint DEFAULT NULL,
  `T_no` int NOT NULL,
  PRIMARY KEY (`T_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of trade
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_no` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_state` int NOT NULL,
  `u_update` datetime DEFAULT NULL,
  `u_createdate` datetime NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `user_Avatar` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `admin_root` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`User_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '202cb962ac59075b964b07152d234b70', '2875244502', '18696003593', '1', '2022-08-17 19:55:08', '2022-08-17 19:55:00', '0', '', '李可', '');
INSERT INTO `user` VALUES ('2', '202cb962ac59075b964b07152d234b70', '985355343', '18696003593', '1', '2022-10-05 18:30:43', '2022-08-17 19:58:13', '0', 'D:\\image\\img\\2022-10-05\\942f42cd-cff9-43e6-86e1-06c0bbdeb388.jpeg', 'like', '管理员');
