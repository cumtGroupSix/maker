/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : maker

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/01/2019 22:29:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(55) NOT NULL COMMENT '购物车ID',
  `user_id` int(55) NOT NULL COMMENT '用户ID',
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
  `cart_id` int(55) NOT NULL COMMENT '用户ID',
  `store_id` int(55) NOT NULL COMMENT '商品所在创客店ID',
  `product_id` int(55) NOT NULL COMMENT '产品ID',
  `product_quantity` int(10) NOT NULL DEFAULT 1 COMMENT '购买数量',
  PRIMARY KEY (`cart_id`, `store_id`, `product_id`) USING BTREE,
  INDEX `fk[cart_product]product_id`(`product_id`) USING BTREE,
  INDEX `fk[cart_product]store_id`(`store_id`) USING BTREE,
  CONSTRAINT `fk[cart_product]cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[cart_product]product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[cart_product]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_product
-- ----------------------------
INSERT INTO `cart_product` VALUES (1, 2, 1, 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `product_id` int(55) NOT NULL COMMENT '产品ID',
  `comment_content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '评论内容',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `star_level` int(1) NULL DEFAULT NULL COMMENT '评价星级',
  PRIMARY KEY (`user_id`, `product_id`) USING BTREE,
  INDEX `fk[product_id]`(`product_id`) USING BTREE,
  CONSTRAINT `fk[product_id]` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[user_id]` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_collections
-- ----------------------------
DROP TABLE IF EXISTS `group_collections`;
CREATE TABLE `group_collections`  (
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `collect_group_id` int(55) NOT NULL COMMENT '收藏商品ID',
  `store_id` int(55) NOT NULL COMMENT '创客店ID',
  PRIMARY KEY (`user_id`, `store_id`, `collect_group_id`) USING BTREE,
  INDEX `fk[group_collections]collect_group_id`(`collect_group_id`) USING BTREE,
  INDEX `[group_collections]store_id`(`store_id`) USING BTREE,
  CONSTRAINT `fk[group_collections]collect_group_id` FOREIGN KEY (`collect_group_id`) REFERENCES `product_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[group_collections]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `[group_collections]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_collections
-- ----------------------------
INSERT INTO `group_collections` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
  `order_id` int(55) NOT NULL COMMENT '订单ID',
  `product_id` int(55) NOT NULL COMMENT '产品ID',
  `product_price` decimal(8, 2) NOT NULL COMMENT '产品价格',
  `product_quantity` int(20) NOT NULL COMMENT '产品数量',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `order_status` int(2) NULL DEFAULT NULL COMMENT '订单状态',
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
INSERT INTO `order_detail` VALUES (1, 1, 1, 2.00, 2, '2018-12-19 20:10:07', 0);
INSERT INTO `order_detail` VALUES (2, 1, 2, 2.00, 3, '2018-12-13 20:10:11', 0);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态',
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
  `product_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `product_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品名称',
  `group_id` int(55) NOT NULL COMMENT '分组ID',
  `product_stock` int(55) NOT NULL DEFAULT 0 COMMENT '产品库存数量',
  `product_price` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '产品价格',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片URL地址',
  `product_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品描述',
  `product_status` tinyint(3) NOT NULL DEFAULT 1 COMMENT '产品是否上架，1.上架.2.下架',
  `sales` int(55) NOT NULL DEFAULT 0 COMMENT '销量',
  `model` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '型号',
  `color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '颜色',
  `size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '大小尺寸',
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
INSERT INTO `product` VALUES (1, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 15, 2.00, 'https://gd1.alicdn.com/imgextra/i1/3200146288/TB2I47ri8fH8KJjy1XbXXbLdXXa_!!3200146288.jpg_400x400.jpg', '好', 1, 0, '', '黑色', 'L', NULL, '');
INSERT INTO `product` VALUES (2, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 111, 2.00, 'https://gd4.alicdn.com/imgextra/i3/3200146288/TB2N5LdhQfb_uJjSsrbXXb6bVXa_!!3200146288.jpg_400x400.jpg', '好', 1, 0, '', '灰色', 'XL', NULL, '');
INSERT INTO `product` VALUES (3, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 21, 2.50, '//gd4.alicdn.com/imgextra/i3/3200146288/TB2N5LdhQfb_uJjSsrbXXb6bVXa_!!3200146288.jpg', '好', 1, 0, '', '白色', 'XXL', NULL, '');
INSERT INTO `product` VALUES (4, '旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ', 2, 211, 122.00, '//gw.alicdn.com/bao/uploaded/i3/276591537/O1CN011io6mn1NDzE5exQow_!!276591537.jpg_440x440q70.jpg', 'nice', 1, 0, '', '卡其色', 'L', NULL, '');
INSERT INTO `product` VALUES (5, '冬季日系工装棉服外套青年学生潮流立领宽松棉衣保暖加厚面包服男', 3, 12, 222.00, '//gd4.alicdn.com/imgextra/i2/738455795/O1CN011sg9fwhnsdWCoE6_!!738455795.jpg', 'nice', 1, 0, '', '黑色', 'XL', NULL, '');

-- ----------------------------
-- Table structure for product_group
-- ----------------------------
DROP TABLE IF EXISTS `product_group`;
CREATE TABLE `product_group`  (
  `group_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '分组ID',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品名称',
  `category` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品目录',
  `representative_product_id` int(55) NOT NULL COMMENT '代表产品ID',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_group
-- ----------------------------
INSERT INTO `product_group` VALUES (1, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', '男装', 1);
INSERT INTO `product_group` VALUES (2, '旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ', '男装', 4);
INSERT INTO `product_group` VALUES (3, '冬季日系工装棉服外套青年学生潮流立领宽松棉衣保暖加厚面包服男', '男装', 5);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `resource_id` int(10) NOT NULL COMMENT '权限ID',
  `resource_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限名称',
  `maker_login` bit(1) NULL DEFAULT NULL COMMENT '作为创客身份登录权限',
  `user_login` bit(1) NULL DEFAULT NULL COMMENT '作为用户身份登录权限',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, 'user', b'0', b'1');
INSERT INTO `resource` VALUES (2, 'maker', b'1', b'0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `role_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型(名称)',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'USER');
INSERT INTO `role` VALUES (2, 'MAKER');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(10) NOT NULL COMMENT '角色拥有权限ID',
  PRIMARY KEY (`role_id`, `resource_id`) USING BTREE,
  INDEX `fk[role_resource]resource_id`(`resource_id`) USING BTREE,
  CONSTRAINT `fk[role_resource]resource_id` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[role_resource]role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (1, 1);
INSERT INTO `role_resource` VALUES (2, 2);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '创客店ID',
  `store_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创客店名称',
  `store_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创客店介绍',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片URL',
  `browse_times` int(255) NOT NULL DEFAULT 0 COMMENT '浏览次数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创立时间',
  PRIMARY KEY (`store_id`) USING BTREE,
  UNIQUE INDEX `ui[store]store_id`(`store_id`) USING BTREE,
  INDEX `store_name`(`store_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '优品阁', '优品阁创立于yyyy年mm月dd日，绝对正品，童叟无欺', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544608736759&di=2b4dd592145830f2c1bd58b19b37cf95&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4a36acaf2edda3ccc3e322bd0be93901213f922c.jpg', 666, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (2, '小淘气童鞋店', '该品牌创立于yyyy年', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2456054635,3769338752&fm=26&gp=0.jpg', 0, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (9, '凡奈诗韩版女鞋店', '该品牌创立于yyyy年', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2456054635,3769338752&fm=26&gp=0.jpg', 222, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (10, '兄弟西服', '该品牌创立于yyyy年', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2135299834,1746253257&fm=26&gp=0.jpg', 0, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (11, '矿大一号店', '百年老店', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2135299834,1746253257&fm=26&gp=0.jpg', 78, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (13, '男人帮', '该品牌创立于yyyy年', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2135299834,1746253257&fm=26&gp=0.jpg', 2, '2018-12-05 18:57:37');
INSERT INTO `store` VALUES (14, '好运来', '该品牌创立于yyyy年', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2135299834,1746253257&fm=26&gp=0.jpg', 2, '2018-12-05 18:57:37');

-- ----------------------------
-- Table structure for store_collections
-- ----------------------------
DROP TABLE IF EXISTS `store_collections`;
CREATE TABLE `store_collections`  (
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `collect_store_id` int(55) NOT NULL COMMENT '收藏店铺ID',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `fk[store_collections]collect_store_id`(`collect_store_id`) USING BTREE,
  CONSTRAINT `fk[store_collections]collect_store_id` FOREIGN KEY (`collect_store_id`) REFERENCES `store` (`store_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk[store_collections]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_collections
-- ----------------------------
INSERT INTO `store_collections` VALUES (1, 9);

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product`  (
  `store_id` int(55) NOT NULL COMMENT '所属创客店ID',
  `group_id` int(55) NOT NULL COMMENT '分组ID',
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
  `user_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `enable` bit(1) NULL DEFAULT NULL COMMENT '是否可用',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `registration_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `school` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校名称',
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
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
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
