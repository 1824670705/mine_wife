/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2022 19:07:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oa_customer
-- ----------------------------
DROP TABLE IF EXISTS `oa_customer`;
CREATE TABLE `oa_customer`  (
  `cus_id` bigint NOT NULL,
  `cus_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cus_gender` int NOT NULL,
  `cus_mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cus_tag_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户标签',
  `whether_black` int NOT NULL COMMENT '十分是黑名单',
  `cus_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户地址',
  `remake` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户备注',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `logic_del` int NOT NULL COMMENT '0删除。1正常使用',
  PRIMARY KEY (`cus_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oa_customer
-- ----------------------------
INSERT INTO `oa_customer` VALUES (1, '张三丰', 1, '18833056986', '1531912269766828033', 1, '1', '1', '2022-05-26 15:25:59', '2022-05-26 15:26:01', 1);
INSERT INTO `oa_customer` VALUES (1531231784950431746, '阿萨', 0, '123123', '1531912651989557250', 0, '213', '123', '2022-05-30 19:11:21', '2022-05-30 19:11:21', 1);
INSERT INTO `oa_customer` VALUES (1531233289875095554, '张帆', 1, '213', '1531912905963053058', 0, '123', '大客户', '2022-05-30 19:17:20', '2022-05-30 19:17:20', 1);
INSERT INTO `oa_customer` VALUES (1531941842571214850, '五', 1, '我去饿', '1531912200141381634,1531912349060145154', 0, '我去饿', '撒', '2022-06-01 18:12:52', '2022-06-01 18:12:52', 1);

-- ----------------------------
-- Table structure for oa_express
-- ----------------------------
DROP TABLE IF EXISTS `oa_express`;
CREATE TABLE `oa_express`  (
  `express_id` bigint NOT NULL,
  `express_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递公司名字',
  `remake` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注',
  `express_mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递公司电话',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `logic_del` int NOT NULL COMMENT '逻辑删除[0删除1没有删除]',
  PRIMARY KEY (`express_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oa_express
-- ----------------------------

-- ----------------------------
-- Table structure for oa_menu
-- ----------------------------
DROP TABLE IF EXISTS `oa_menu`;
CREATE TABLE `oa_menu`  (
  `menu_id` bigint NOT NULL COMMENT '主键Id',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名字',
  `parent_menu_id` bigint NOT NULL COMMENT '菜单父类Id，没有为0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `logic_del` int NOT NULL COMMENT '0删除，1没删除',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oa_menu
-- ----------------------------
INSERT INTO `oa_menu` VALUES (1531841866432217089, '客户标签', 0, '2022-06-01 11:35:36', '2022-06-01 11:35:36', 1);
INSERT INTO `oa_menu` VALUES (1531845875188596738, '供应商标签', 0, '2022-06-01 11:51:32', '2022-06-01 11:51:32', 1);
INSERT INTO `oa_menu` VALUES (1531846539092393985, '优质客户', 1531841866432217089, '2022-06-01 11:54:10', '2022-06-01 11:54:10', 1);
INSERT INTO `oa_menu` VALUES (1531846771251314690, '优质供应商', 1531845875188596738, '2022-06-01 11:55:05', '2022-06-01 11:55:05', 1);
INSERT INTO `oa_menu` VALUES (1531912200141381634, '钱多人傻', 1531841866432217089, '2022-06-01 16:15:05', '2022-06-01 16:15:05', 1);
INSERT INTO `oa_menu` VALUES (1531912269766828033, '新疆地区', 1531841866432217089, '2022-06-01 16:15:21', '2022-06-01 16:15:21', 1);
INSERT INTO `oa_menu` VALUES (1531912321646174209, '外国用户', 1531841866432217089, '2022-06-01 16:15:34', '2022-06-01 16:15:34', 1);
INSERT INTO `oa_menu` VALUES (1531912349060145154, '女性用户', 1531841866432217089, '2022-06-01 16:15:40', '2022-06-01 16:15:40', 1);
INSERT INTO `oa_menu` VALUES (1531912378348969985, '男性用户', 1531841866432217089, '2022-06-01 16:15:47', '2022-06-01 16:15:47', 1);
INSERT INTO `oa_menu` VALUES (1531912437740314625, '大陆用户', 1531841866432217089, '2022-06-01 16:16:01', '2022-06-01 16:16:01', 1);
INSERT INTO `oa_menu` VALUES (1531912474511777794, '台湾用户', 1531841866432217089, '2022-06-01 16:16:10', '2022-06-01 16:16:10', 1);
INSERT INTO `oa_menu` VALUES (1531912538269392898, '信用度低', 1531841866432217089, '2022-06-01 16:16:25', '2022-06-01 16:16:25', 1);
INSERT INTO `oa_menu` VALUES (1531912590215847937, '新开发用户', 1531841866432217089, '2022-06-01 16:16:38', '2022-06-01 16:16:38', 1);
INSERT INTO `oa_menu` VALUES (1531912651989557250, '抖音用户', 1531841866432217089, '2022-06-01 16:16:52', '2022-06-01 16:16:52', 1);
INSERT INTO `oa_menu` VALUES (1531912683295842306, 'pdd用户', 1531841866432217089, '2022-06-01 16:17:00', '2022-06-01 16:17:00', 1);
INSERT INTO `oa_menu` VALUES (1531912716309209090, '1688用户', 1531841866432217089, '2022-06-01 16:17:08', '2022-06-01 16:17:08', 1);
INSERT INTO `oa_menu` VALUES (1531912842847166466, '海贼王爱好者', 1531841866432217089, '2022-06-01 16:17:38', '2022-06-01 16:17:38', 1);
INSERT INTO `oa_menu` VALUES (1531912872635113473, '路飞爱好者', 1531841866432217089, '2022-06-01 16:17:45', '2022-06-01 16:17:45', 1);
INSERT INTO `oa_menu` VALUES (1531912905963053058, '火影用户', 1531841866432217089, '2022-06-01 16:17:53', '2022-06-01 16:17:53', 1);
INSERT INTO `oa_menu` VALUES (1531912955220959233, '鸣人用户', 1531841866432217089, '2022-06-01 16:18:05', '2022-06-01 16:18:05', 1);
INSERT INTO `oa_menu` VALUES (1532161852057042946, '我去饿', 0, '2022-06-02 08:47:06', '2022-06-02 08:47:06', 1);
INSERT INTO `oa_menu` VALUES (1532164188678635522, '撒旦', 1532161852057042946, '2022-06-02 08:56:23', '2022-06-02 08:56:23', 1);
INSERT INTO `oa_menu` VALUES (1532164213311782914, '大萨达萨达萨达萨达 ', 1532161852057042946, '2022-06-02 08:56:29', '2022-06-02 08:56:29', 1);
INSERT INTO `oa_menu` VALUES (1532164242571247617, '的撒🐖', 1532161852057042946, '2022-06-02 08:56:36', '2022-06-02 08:56:36', 1);

-- ----------------------------
-- Table structure for oa_order
-- ----------------------------
DROP TABLE IF EXISTS `oa_order`;
CREATE TABLE `oa_order`  (
  `order_id` bigint NOT NULL,
  `shop_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单名称',
  `ord_consumer_id` bigint NOT NULL COMMENT '客户Id',
  `ord_supplier` bigint NOT NULL COMMENT '供应商Id',
  `ord_price` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单价格',
  `shop_id` bigint NOT NULL COMMENT '商品id',
  `ord_express_no` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递单号',
  `express_id` bigint NOT NULL COMMENT '快递公司id',
  `ord_status` int NOT NULL COMMENT '订单状态',
  `ord_remake` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注',
  `locale_id` int NOT NULL COMMENT '订单地址Id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `logic_del` int NOT NULL COMMENT '逻辑删除[0删除1没有删除]',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oa_order
-- ----------------------------
INSERT INTO `oa_order` VALUES (1531909801662214145, '12', 12, 12, '12', 12, '12', 12, 12, '12', 12, '2022-06-01 16:05:33', '2022-06-01 16:05:33', 1);
INSERT INTO `oa_order` VALUES (1531910012941889537, '12', 12, 12, '12', 12, '12', 12, 12, '12', 12, '2022-06-01 16:06:23', '2022-06-01 16:06:23', 1);
INSERT INTO `oa_order` VALUES (1532161756162670594, '火锅底料', 1, 1, '12', 12, '12', 12, 12, '12', 12, '2022-06-02 08:46:44', '2022-06-02 08:46:44', 1);

-- ----------------------------
-- Table structure for oa_supplier
-- ----------------------------
DROP TABLE IF EXISTS `oa_supplier`;
CREATE TABLE `oa_supplier`  (
  `supplier_id` bigint NOT NULL COMMENT '供应商主键',
  `supplier_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供应商名字',
  `supplier_mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `supplier_remake` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供应商备注',
  `supplier_locale` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供应商地址',
  `supplier_tag_id` bigint NOT NULL COMMENT '供应商标签',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `logic_del` int NOT NULL COMMENT '逻辑删除[0删除1没有删除]',
  `create_by` bigint NOT NULL COMMENT '供应商开发人',
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oa_supplier
-- ----------------------------
INSERT INTO `oa_supplier` VALUES (1531819752526348289, '超级开发员', '18833040474', '阿斯顿', '商家大家😜', 1, '2022-06-01 10:07:43', '2022-06-01 10:07:43', 1, 1);
INSERT INTO `oa_supplier` VALUES (1531862996371079170, '南街北部超级市场', '12452268', '撒旦', '123', 213, '2022-06-01 12:59:34', '2022-06-01 12:59:34', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
