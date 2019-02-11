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

 Date: 11/02/2019 19:40:08
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
  CONSTRAINT `fk[cart]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 1);
INSERT INTO `cart` VALUES (3, 3);

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
  CONSTRAINT `fk[cart_product]cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[cart_product]product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[cart_product]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_product
-- ----------------------------
INSERT INTO `cart_product` VALUES (1, 1, 1, 1);
INSERT INTO `cart_product` VALUES (1, 1, 2, 1);
INSERT INTO `cart_product` VALUES (1, 1, 3, 1);
INSERT INTO `cart_product` VALUES (1, 2, 1, 1);
INSERT INTO `cart_product` VALUES (1, 2, 2, 1);
INSERT INTO `cart_product` VALUES (3, 1, 1, 1);
INSERT INTO `cart_product` VALUES (3, 2, 1, 1);

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
  `store_id` int(55) NOT NULL COMMENT '创客店ID',
  `collect_group_id` int(55) NOT NULL COMMENT '收藏商品ID',
  PRIMARY KEY (`user_id`, `store_id`, `collect_group_id`) USING BTREE,
  INDEX `fk[group_collections]collect_group_id`(`collect_group_id`) USING BTREE,
  INDEX `[group_collections]store_id`(`store_id`) USING BTREE,
  CONSTRAINT `[group_collections]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[group_collections]collect_group_id` FOREIGN KEY (`collect_group_id`) REFERENCES `product_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[group_collections]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for maker_info
-- ----------------------------
DROP TABLE IF EXISTS `maker_info`;
CREATE TABLE `maker_info`  (
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `store_id` int(55) NOT NULL COMMENT '店铺ID',
  `store_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺名称',
  `mobile_number` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱地址',
  `school` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名称',
  `real_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `student_id` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  `registration_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `fk[maker_info]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maker_info
-- ----------------------------
INSERT INTO `maker_info` VALUES (2, 2, 'makertest', '151', 'a@qq.com', '中国矿业大学', 'test', '5', '2019-02-02 13:57:22');
INSERT INTO `maker_info` VALUES (3, 3, '店铺名', '1', 'a@qq.com', '中国矿业大学', 'test1', '1', '2019-02-02 05:52:29');

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
  `order_status` int(2) NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `fk[order_detail]order_id`(`order_id`) USING BTREE,
  INDEX `fk[order_detail]product_id`(`product_id`) USING BTREE,
  INDEX `fk[order_detail]product_price`(`product_price`) USING BTREE,
  CONSTRAINT `fk[order_detail]order_id` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[order_detail]product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[order_detail]product_price` FOREIGN KEY (`product_price`) REFERENCES `product` (`product_price`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int(55) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态(1代表已支付，0代表未支付)',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `fk[order]user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk[order]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  CONSTRAINT `fk[product]group_id` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 15, 2.00, 'https://group-6-1257626148.cos.ap-beijing.myqcloud.com/img/clothes.jpg', '好', 1, 0, '', '黑色', 'L', NULL, '');
INSERT INTO `product` VALUES (2, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 111, 2.00, 'https://group-6-1257626148.cos.ap-beijing.myqcloud.com/img/clothes2.jpg', '好', 1, 0, '', '灰色', 'XL', NULL, '');
INSERT INTO `product` VALUES (3, '港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ', 1, 21, 2.50, '	https://group-6-1257626148.cos.ap-beijing.myqcloud.com/img/clothes.jpg', '好', 1, 0, '', '白色', 'XXL', NULL, '');
INSERT INTO `product` VALUES (4, '旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ', 2, 211, 122.00, 'https://group-6-1257626148.cos.ap-beijing.myqcloud.com/img/clothes2.jpg', 'nice', 1, 0, '', '卡其色', 'L', NULL, '');
INSERT INTO `product` VALUES (5, '冬季日系工装棉服外套青年学生潮流立领宽松棉衣保暖加厚面包服男', 3, 12, 222.00, 'https://group-6-1257626148.cos.ap-beijing.myqcloud.com/img/clothes.jpg', 'nice', 1, 0, '', '黑色', 'XL', NULL, '');

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
  `role_id` int(10) NOT NULL COMMENT '角色ID',
  `role_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色类型(名称)',
  PRIMARY KEY (`role_type`) USING BTREE,
  INDEX `role_type`(`role_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (3, 'ADMIN');
INSERT INTO `role` VALUES (1, 'MAKER');
INSERT INTO `role` VALUES (2, 'USER');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色类型',
  `resource_id` int(10) NOT NULL COMMENT '角色拥有权限ID',
  PRIMARY KEY (`role_type`, `resource_id`) USING BTREE,
  INDEX `fk[role_resource]resource_id`(`resource_id`) USING BTREE,
  CONSTRAINT `[role_resource]resource_id` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `[role_resource]role_type` FOREIGN KEY (`role_type`) REFERENCES `role` (`role_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('USER', 1);
INSERT INTO `role_resource` VALUES ('MAKER', 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  CONSTRAINT `fk[store_collections]collect_store_id` FOREIGN KEY (`collect_store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[store_collections]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product`  (
  `store_id` int(55) NOT NULL COMMENT '所属创客店ID',
  `group_id` int(55) NOT NULL COMMENT '分组ID',
  PRIMARY KEY (`store_id`, `group_id`) USING BTREE,
  INDEX `fk[store_product]group_id`(`group_id`) USING BTREE,
  CONSTRAINT `fk[store_product]group_id` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[store_product]store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `username` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `fk[user]role`(`role`) USING BTREE,
  CONSTRAINT `fk[user]role` FOREIGN KEY (`role`) REFERENCES `role` (`role_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'USER', 'test', '$2a$10$Sx7CAIXKJ/ZzZyMgwpflt.W8OPDFT5GzMSHmuV7RiwJdtN.nL3CXm');
INSERT INTO `user` VALUES (2, 'MAKER', 'makertest', '$2a$10$Sx7CAIXKJ/ZzZyMgwpflt.W8OPDFT5GzMSHmuV7RiwJdtN.nL3CXm');
INSERT INTO `user` VALUES (3, 'USER', 'test1', '$2a$10$Sx7CAIXKJ/ZzZyMgwpflt.W8OPDFT5GzMSHmuV7RiwJdtN.nL3CXm');
INSERT INTO `user` VALUES (4, 'ADMIN', 'admin', '$2a$10$Sx7CAIXKJ/ZzZyMgwpflt.W8OPDFT5GzMSHmuV7RiwJdtN.nL3CXm');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(55) NOT NULL COMMENT '用户ID',
  `nickname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `enable` bit(1) NULL DEFAULT NULL COMMENT '是否可用',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `registration_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `school` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校名称',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `fk[user_info]user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'test', b'1', '151', 'abcdefg@qq.com', '中国矿业大学', '2019-02-02 05:28:27', '中国矿业大学');

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
