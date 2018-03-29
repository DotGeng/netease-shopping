/*
Navicat MySQL Data Transfer

Source Server         : netease-shopping
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : netease-shopping

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-29 14:52:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for booking
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` int(20) NOT NULL DEFAULT '0',
  `goods_num` int(11) NOT NULL,
  `buyed_price` double NOT NULL DEFAULT '0',
  `purchase_time` datetime NOT NULL,
  `userName` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booking
-- ----------------------------
INSERT INTO `booking` VALUES ('1', '1', '5', '100', '2018-03-24 21:39:46', 'buyer');
INSERT INTO `booking` VALUES ('12', '2', '2', '234', '2018-03-28 16:41:54', 'buyer');
INSERT INTO `booking` VALUES ('13', '5', '1', '1234', '2018-03-28 16:52:36', 'buyer');
INSERT INTO `booking` VALUES ('14', '7', '1', '12', '2018-03-28 17:02:23', 'buyer');
INSERT INTO `booking` VALUES ('15', '12', '1', '1213', '2018-03-28 17:04:43', 'buyer');
INSERT INTO `booking` VALUES ('16', '6', '1', '12', '2018-03-28 18:09:50', 'buyer');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL DEFAULT '',
  `goods_price` double(255,0) NOT NULL,
  `picture_url` varchar(255) NOT NULL DEFAULT '',
  `storage` int(11) NOT NULL DEFAULT '0',
  `title` varchar(255) DEFAULT '',
  `sold_count` int(11) NOT NULL DEFAULT '0' COMMENT '冗余字段',
  `seller_id` bigint(11) DEFAULT NULL,
  `has_seal` int(11) NOT NULL DEFAULT '0' COMMENT '0代表没有卖出，1代表卖出',
  `content` varchar(255) NOT NULL DEFAULT '',
  `goods_abstract` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '鲜花', '124', 'http://localhost:8080/myimage/Tulips.jpg', '10', '鲜花', '5', '1', '1', '这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花这是一多花', '鲜花');
INSERT INTO `goods` VALUES ('2', '商品2', '234', 'http://www.iyi8.com/uploadfile/2017/0910/20170910110015880.jpg', '20', '美女', '0', '1', '1', '这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女这是一位美女', '美女');
INSERT INTO `goods` VALUES ('5', '修后的小花', '1234', 'http://localhost:8080/myimage/Hydrangeas.jpg', '0', '修后的小花', '0', '1', '1', '通过WebX入门指南，相信大家都能开始尝试添加自己的处理页面了。基本上能够完成简单的页面设计了。我们通常说网站是B/S架构的，那这种模式只要掌握前后端的分工和交互，就能游刃有余。因此，本节就从前后端交互方式来说明如何实现高效的代码设计。', '这是一朵漂亮的小花');
INSERT INTO `goods` VALUES ('6', 'adsa', '12', 'http://localhost:8080/myimage/Chrysanthemum.jpg', '0', 'adsa', '0', '1', '1', 'adsad', 'adsadad');
INSERT INTO `goods` VALUES ('7', 'asda', '12', 'http://localhost:8080/myimage/Desert.jpg', '0', 'asda', '0', '1', '1', 'adada', 'adad');
INSERT INTO `goods` VALUES ('8', '1233dad', '12', 'http://localhost:8080/myimage/Desert.jpg', '0', '1233dad', '0', '1', '0', '12asdada', '12aasdasd');
INSERT INTO `goods` VALUES ('9', 'asda', '121', 'http://localhost:8080/myimage/Jellyfish.jpg', '0', 'asda', '0', '1', '0', 'dasa', 'asda');
INSERT INTO `goods` VALUES ('10', 'qweq', '12', 'http://localhost:8080/myimage/Chrysanthemum.jpg', '0', 'qweq', '0', '1', '0', 'qeqweq', 'qweq');
INSERT INTO `goods` VALUES ('11', 'qweqe', '121', 'http://localhost:8080/myimage/Lighthouse.jpg', '0', 'qweqe', '0', '1', '0', 'qweqeqwe', 'qweqe');
INSERT INTO `goods` VALUES ('12', 'qweqe', '1213', 'http://localhost:8080/myimage/Hydrangeas.jpg', '0', 'qweqe', '0', '1', '1', 'qweqeqweq', 'qweqweq');
INSERT INTO `goods` VALUES ('13', 'sdafa', '112', 'http://localhost:8080/myimage/Desert.jpg', '0', 'sdafa', '0', '1', '0', 'qewqeqwqeqw', 'ada');
INSERT INTO `goods` VALUES ('14', 'qewq', '12', 'http://localhost:8080/myimage/Desert.jpg', '0', 'qewq', '0', '1', '0', 'qweqeqw', 'qewqe');

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchased_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` int(20) NOT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `userName` varchar(255) NOT NULL DEFAULT '',
  `purchasePrice` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`purchased_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('6', '8', '2', '1', '12');

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `seller_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', 'seller', 'relles');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `cart_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `googs_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'buyer', 'reyub');
