/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : maker

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/12/2018 19:40:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(55) NOT NULL,
  `user_id` int(55) NOT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `fk[cart]user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk[cart]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 1);

-- ----------------------------
-- Table structure for cart_product
-- ----------------------------
DROP TABLE IF EXISTS `cart_product`;
CREATE TABLE `cart_product`  (
  `cart_id` int(55) NOT NULL,
  `product_id` int(55) NOT NULL,
  PRIMARY KEY (`cart_id`, `product_id`) USING BTREE,
  INDEX `fk[cart_product]product_id`(`product_id`) USING BTREE,
  CONSTRAINT `fk[cart_product]cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[cart_product]product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_product
-- ----------------------------
INSERT INTO `cart_product` VALUES (1, 1);
INSERT INTO `cart_product` VALUES (1, 2);

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` int(55) NOT NULL AUTO_INCREMENT,
  `order_id` int(55) NOT NULL,
  `product_id` int(55) NOT NULL,
  `product_price` decimal(8, 2) NOT NULL,
  `product_quantity` int(20) NOT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `fk[order_detail]order_id`(`order_id`) USING BTREE,
  INDEX `fk[order_detail]product_id`(`product_id`) USING BTREE,
  INDEX `fk[order_detail]product_price`(`product_price`) USING BTREE,
  CONSTRAINT `fk[order_detail]order_id` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`order_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[order_detail]product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[order_detail]product_price` FOREIGN KEY (`product_price`) REFERENCES `product` (`product_price`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1, 1, 1, 2.00, 2);
INSERT INTO `order_detail` VALUES (2, 1, 2, 2.00, 3);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int(55) NOT NULL AUTO_INCREMENT,
  `user_id` int(55) NOT NULL,
  `pay_status` tinyint(3) NOT NULL DEFAULT 0,
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `fk[order]user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk[order]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES (1, 1, 1, 21.00);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(55) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `group_id` int(55) NOT NULL,
  `product_stock` int(55) NOT NULL DEFAULT 0,
  `product_price` decimal(8, 2) NOT NULL DEFAULT 0.00,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `product_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `product_status` tinyint(3) NOT NULL DEFAULT 1 COMMENT '产品是否上架，1.上架.2.下架',
  `sales` int(55) NOT NULL DEFAULT 0 COMMENT '销量',
  `model` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '型号',
  `color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `date_manufacture` timestamp(0) NULL DEFAULT NULL COMMENT '生产日期',
  `manufacturer` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '生产厂家',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `product_price`(`product_price`) USING BTREE,
  INDEX `fk[product]group_id`(`group_id`) USING BTREE,
  CONSTRAINT `fk[product]group_id` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`group_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 15, 2.00, '', '好', 1, 0, '', '卡其色', 'L', NULL, '');
INSERT INTO `product` VALUES (2, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 111, 2.00, '', '好', 1, 0, '', '灰色', 'XL', NULL, '');
INSERT INTO `product` VALUES (3, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 21, 2.50, '', '好', 1, 0, '', '白色', 'XXL', NULL, '');
INSERT INTO `product` VALUES (4, '棉衣男士冬季青少年帅气韩版潮 新款短款外套港风学生银色ins棉服', 2, 211, 122.00, '', 'nice', 1, 0, '', '卡其色', 'L', NULL, '');
INSERT INTO `product` VALUES (5, '冬季复古工装棉衣男士外套韩版潮流加厚棉袄子chic多口袋连帽棉服', 3, 12, 222.00, '', 'nice', 1, 0, '', '', '', NULL, '');

-- ----------------------------
-- Table structure for product_group
-- ----------------------------
DROP TABLE IF EXISTS `product_group`;
CREATE TABLE `product_group`  (
  `group_id` int(55) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `category` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `representative_product_id` int(55) NOT NULL,
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_group
-- ----------------------------
INSERT INTO `product_group` VALUES (1, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', '男装', 1);
INSERT INTO `product_group` VALUES (2, '棉衣男士冬季青少年帅气韩版潮 新款短款外套港风学生银色ins棉服', '男装', 4);
INSERT INTO `product_group` VALUES (3, '冬季复古工装棉衣男士外套韩版潮流加厚棉袄子chic多口袋连帽棉服', '男装', 5);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL,
  `role_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'USER');
INSERT INTO `role` VALUES (2, 'MAKER');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` int(55) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `store_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `browse_times` int(255) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`store_id`) USING BTREE,
  UNIQUE INDEX `ui[store]store_id`(`store_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '优品阁', '优品阁创立于yyyy年mm月dd日，绝对正品，童叟无欺', '', 666, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (2, '小淘气童鞋店', '该品牌创立于yyyy年', '', 0, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (9, '凡奈诗韩版女鞋店', '该品牌创立于yyyy年', '', 222, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (10, '兄弟西服', '该品牌创立于yyyy年', '', 0, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (11, '矿大一号店', '百年老店', '', 78, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (13, '男人帮', '该品牌创立于yyyy年', '', 2, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (14, '好运来', '该品牌创立于yyyy年', '', 2, '2018-12-05 18:57:37');

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product`  (
  `store_id` int(55) NOT NULL,
  `group_id` int(55) NOT NULL,
  PRIMARY KEY (`store_id`, `group_id`) USING BTREE,
  INDEX `fk[store_product]group_id`(`group_id`) USING BTREE,
  CONSTRAINT `fk[store_product]group_id` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`group_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[store_product]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES (1, 1);
INSERT INTO `store_product` VALUES (1, 2);
INSERT INTO `store_product` VALUES (2, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(55) NOT NULL AUTO_INCREMENT,
  `username` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `registration_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `school` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'username', '$2a$10$F8DJhuyZF.xt2elWxkZ0TezCjjQQA.DcOLReN9bGvc80Zu88OnGca', 'Tom', b'1', '11122223333', '中国矿业大学松苑', '2018-12-05 18:50:00', '中国矿业大学');
INSERT INTO `user` VALUES (2, 'maker', '$2a$10$sT0tVlaWN/rZ5feB1jtRCef0FJLB0dDmK2c6ZmZONYhiAx35UzR3K', 'Jason', b'1', '44455556666', '中国矿业大学桃苑', '2018-12-05 18:47:15', '中国矿业大学（北京）');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(55) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `fk[user_role]role_id`(`role_id`) USING BTREE,
  CONSTRAINT `fk[user_role]role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[user_role]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 1);
INSERT INTO `user_role` VALUES (2, 2);

-- ----------------------------
-- Procedure structure for sp_select_store_by_store_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_select_store_by_store_id`;
delimiter ;;
CREATE PROCEDURE `sp_select_store_by_store_id`(IN `in_store_id` INTEGER(55))
BEGIN
	#Routine body goes here...
	SELECT * FROM store WHERE store_id=in_store_id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
