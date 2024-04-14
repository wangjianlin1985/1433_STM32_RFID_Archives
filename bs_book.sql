/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80031
Source Host           : 127.0.0.1:3306
Source Database       : bs_book

Target Server Type    : MYSQL
Target Server Version : 80031
File Encoding         : 65001

Date: 2023-05-08 14:04:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_book_address
-- ----------------------------
DROP TABLE IF EXISTS `bs_book_address`;
CREATE TABLE `bs_book_address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address_name` varchar(255) DEFAULT NULL COMMENT '地址名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 ;

-- ----------------------------
-- Records of bs_book_address
-- ----------------------------
INSERT INTO `bs_book_address` VALUES ('5', '1楼书架1');
INSERT INTO `bs_book_address` VALUES ('6', '1楼书架2');
INSERT INTO `bs_book_address` VALUES ('7', '1楼书架3');
INSERT INTO `bs_book_address` VALUES ('8', '1楼书架4');
INSERT INTO `bs_book_address` VALUES ('9', '1楼书架5');
INSERT INTO `bs_book_address` VALUES ('10', '1楼书架6');
INSERT INTO `bs_book_address` VALUES ('11', '2楼书架1');
INSERT INTO `bs_book_address` VALUES ('12', '2楼书架2');
INSERT INTO `bs_book_address` VALUES ('13', '2楼书架3');
INSERT INTO `bs_book_address` VALUES ('14', '2楼书架4');
INSERT INTO `bs_book_address` VALUES ('15', '2楼书架5');
INSERT INTO `bs_book_address` VALUES ('16', '2楼书架6');

-- ----------------------------
-- Table structure for bs_book_info
-- ----------------------------
DROP TABLE IF EXISTS `bs_book_info`;
CREATE TABLE `bs_book_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime DEFAULT NULL COMMENT '上架时间',
  `publication_date` datetime DEFAULT NULL COMMENT '出版时间',
  `author` varchar(255) DEFAULT NULL COMMENT '作者 ',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `book_name` varchar(255) DEFAULT NULL COMMENT '书籍名称',
  `sort_id` int DEFAULT NULL COMMENT '分类id',
  `address_id` int DEFAULT NULL COMMENT '地址id',
  `rfid_id` varchar(255) DEFAULT NULL COMMENT 'rfid',
  `select_number` int DEFAULT NULL COMMENT '借阅次数',
  `photo_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `book_status` varchar(255) DEFAULT NULL COMMENT '图书状态，1可借，2不可借',
  `book_count` varchar(255) DEFAULT NULL COMMENT '图书数量',
  `raters_number` int DEFAULT NULL,
  `raters` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 ;

-- ----------------------------
-- Records of bs_book_info
-- ----------------------------
INSERT INTO `bs_book_info` VALUES ('12', '2022-04-30 15:59:21', '2006-07-01 00:00:00', '李健东', '西安电子科技大学出版社', '移动通信', '16', '6', '60CD084D', '1', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/3567ac0d-7243-42a0-8a26-bf55749e2f4fydtx.jpg', '不可借', '0', '4', '4.8', '9787560614984');
INSERT INTO `bs_book_info` VALUES ('13', '2022-04-30 16:00:27', '2016-08-01 00:00:00', '门佳', '人民邮电出版社', 'Linux命令行与shell脚本编程大全', '18', '8', 'linux', '8', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/f0bb595a-0746-40ed-9e9a-21c3db0bc746linux.png', '可借', '100', '4', '3.9', '9787115429674');
INSERT INTO `bs_book_info` VALUES ('14', '2022-04-30 16:02:50', '2017-01-01 00:00:00', '谢希仁', '电子工业出版社', '计算机网络', '16', '15', 'jisuanjiwl', '3', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg', '可借', '167', '3', '3.5', '9787121302954');
INSERT INTO `bs_book_info` VALUES ('16', '2022-05-09 21:13:38', '2020-10-01 00:00:00', '袁国忠', '人民邮电出版社', 'Python编程 从入门到实践 第2版（图灵出品）', '12', '8', 'python', '0', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/2b7fcdd2-b953-477a-86f8-6be26dff830cpython.png', '可借', '20', '1', '5', '9787115546081');
INSERT INTO `bs_book_info` VALUES ('17', '2022-05-09 21:16:25', '2022-01-01 00:00:00', '霍春阳', '人民邮电出版社', 'Vue.js设计与实现', '18', '8', 'vue', '0', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/1d85a428-7312-42f6-a946-77ecd2a974a3vue.png', '可借', '1232', '1', '5', '9787115583864');
INSERT INTO `bs_book_info` VALUES ('18', '2022-05-09 21:18:12', '2021-07-01 00:00:00', '明日科技', '清华大学出版社', 'Java从入门到精通（第6版）', '18', '12', 'javarm', '0', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/facd3d62-9e6b-41c3-a63c-7be301f45b87java.png', '可借', '324', '1', '5', '9787302581260');
INSERT INTO `bs_book_info` VALUES ('19', '2022-05-09 21:20:23', '2019-01-01 00:00:00', 'Joshua Bloch', '机械工业出版社', 'Effective Java', '16', '12', 'eff', '0', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/ddd397db-2a50-4726-9623-6c5551333393eff.png', '可借', '323', '1', '5', '9787111612728');
INSERT INTO `bs_book_info` VALUES ('20', '2022-05-09 21:21:31', '2014-08-01 00:00:00', '许令波', '电子工业出版社', '深入分析Java Web技术内幕', '16', '6', 'javaweb', '0', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/efc8a277-7745-4aa9-a006-6eb33fb225bbjavaweb.png', '可借', '32', '1', '5', '9787121232930');
INSERT INTO `bs_book_info` VALUES ('21', '2022-05-10 00:03:23', '2020-05-01 00:00:00', '弗莱彻·邓恩', '清华大学出版社', '3D数学基础', '18', '14', '5092194D', '1', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/c0dc5a2e-2108-4f94-98c8-36d2084f23c23d.png', '可借', '322', '1', '5', '9787302549321');
INSERT INTO `bs_book_info` VALUES ('22', '2022-05-11 21:20:33', '2022-05-12 00:00:00', '11', '111', '111', '10', '5', 'C3086111', '1', 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bfc24509-f285-407d-8145-a87ba87f11a43d.png', '可借', '111', '2', '4.0', '111');

-- ----------------------------
-- Table structure for bs_book_sort
-- ----------------------------
DROP TABLE IF EXISTS `bs_book_sort`;
CREATE TABLE `bs_book_sort` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sort_name` varchar(255) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 ;

-- ----------------------------
-- Records of bs_book_sort
-- ----------------------------
INSERT INTO `bs_book_sort` VALUES ('9', '小说');
INSERT INTO `bs_book_sort` VALUES ('10', '儿童读物');
INSERT INTO `bs_book_sort` VALUES ('11', '专业书');
INSERT INTO `bs_book_sort` VALUES ('12', '工具书');
INSERT INTO `bs_book_sort` VALUES ('13', '手册');
INSERT INTO `bs_book_sort` VALUES ('14', '报告');
INSERT INTO `bs_book_sort` VALUES ('15', '日记');
INSERT INTO `bs_book_sort` VALUES ('16', '课本');
INSERT INTO `bs_book_sort` VALUES ('17', '摄影绘画集');
INSERT INTO `bs_book_sort` VALUES ('18', '计算机');
INSERT INTO `bs_book_sort` VALUES ('19', '物理');
INSERT INTO `bs_book_sort` VALUES ('20', '化学');
INSERT INTO `bs_book_sort` VALUES ('21', '生物');

-- ----------------------------
-- Table structure for bs_borrow
-- ----------------------------
DROP TABLE IF EXISTS `bs_borrow`;
CREATE TABLE `bs_borrow` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int DEFAULT NULL COMMENT '借阅用户id',
  `book_id` int DEFAULT NULL COMMENT '被借阅书籍id',
  `end_time` datetime DEFAULT NULL COMMENT '预计还书时间',
  `boorrw_status` varchar(255) DEFAULT NULL COMMENT '借阅状态 0- 未归还 1-已归还',
  `get_time` datetime DEFAULT NULL COMMENT '实际借书时间',
  `return_time` datetime DEFAULT NULL COMMENT '实际还书时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 ;

-- ----------------------------
-- Records of bs_borrow
-- ----------------------------
INSERT INTO `bs_borrow` VALUES ('5', '9', '12', '2022-09-28 23:48:31', '0', '2022-09-28 23:48:31', null);
INSERT INTO `bs_borrow` VALUES ('6', '9', '13', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-04-29 23:48:31');
INSERT INTO `bs_borrow` VALUES ('7', '9', '13', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-04-30 23:49:21');
INSERT INTO `bs_borrow` VALUES ('8', '10', '14', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-04-30 23:51:10');
INSERT INTO `bs_borrow` VALUES ('11', '9', '13', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-05-08 21:24:38');
INSERT INTO `bs_borrow` VALUES ('12', '9', '14', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-05-09 20:54:19');
INSERT INTO `bs_borrow` VALUES ('13', '9', '13', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-05-09 23:15:40');
INSERT INTO `bs_borrow` VALUES ('14', '9', '14', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-05-09 23:16:42');
INSERT INTO `bs_borrow` VALUES ('15', '9', '22', '2022-09-28 23:48:31', '1', '2022-09-28 23:48:31', '2022-05-11 21:24:17');

-- ----------------------------
-- Table structure for bs_mode
-- ----------------------------
DROP TABLE IF EXISTS `bs_mode`;
CREATE TABLE `bs_mode` (
  `id` int NOT NULL AUTO_INCREMENT,
  `modes` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 ;

-- ----------------------------
-- Records of bs_mode
-- ----------------------------
INSERT INTO `bs_mode` VALUES ('1', '2');

-- ----------------------------
-- Table structure for bs_phone
-- ----------------------------
DROP TABLE IF EXISTS `bs_phone`;
CREATE TABLE `bs_phone` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int DEFAULT NULL COMMENT '用户id',
  `phone` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 ;

-- ----------------------------
-- Records of bs_phone
-- ----------------------------
INSERT INTO `bs_phone` VALUES ('1', '13', '13173381157');
INSERT INTO `bs_phone` VALUES ('2', '9', '13173381157');
INSERT INTO `bs_phone` VALUES ('3', '10', '13173381157');
INSERT INTO `bs_phone` VALUES ('4', '11', '13173381157');
INSERT INTO `bs_phone` VALUES ('5', '14', '13173381157');
INSERT INTO `bs_phone` VALUES ('6', '15', '13173381155');
INSERT INTO `bs_phone` VALUES ('7', '16', '18552255620');

-- ----------------------------
-- Table structure for bs_rfid
-- ----------------------------
DROP TABLE IF EXISTS `bs_rfid`;
CREATE TABLE `bs_rfid` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rfid_id` varchar(255) DEFAULT NULL COMMENT 'ic卡id',
  `rfid_status` varchar(255) DEFAULT NULL COMMENT '是否已读0-未读 1-已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 ;

-- ----------------------------
-- Records of bs_rfid
-- ----------------------------
INSERT INTO `bs_rfid` VALUES ('1', '5092194D', '1');

-- ----------------------------
-- Table structure for bs_score
-- ----------------------------
DROP TABLE IF EXISTS `bs_score`;
CREATE TABLE `bs_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 ;

-- ----------------------------
-- Records of bs_score
-- ----------------------------
INSERT INTO `bs_score` VALUES ('1', '1', '100');
INSERT INTO `bs_score` VALUES ('2', '9', '92');
INSERT INTO `bs_score` VALUES ('3', '10', '98');
INSERT INTO `bs_score` VALUES ('4', '11', '100');
INSERT INTO `bs_score` VALUES ('5', '13', '99');
INSERT INTO `bs_score` VALUES ('6', '14', '99');
INSERT INTO `bs_score` VALUES ('7', '15', '100');
INSERT INTO `bs_score` VALUES ('8', '16', '100');

-- ----------------------------
-- Table structure for bs_token
-- ----------------------------
DROP TABLE IF EXISTS `bs_token`;
CREATE TABLE `bs_token` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int DEFAULT NULL COMMENT '用户id',
  `token` varchar(255) DEFAULT NULL COMMENT '授权信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 ;

-- ----------------------------
-- Records of bs_token
-- ----------------------------
INSERT INTO `bs_token` VALUES ('1', '1', '4cde440e-1d30-4cb9-b528-a71f3b4f7507');
INSERT INTO `bs_token` VALUES ('2', '2', null);
INSERT INTO `bs_token` VALUES ('3', '4', '845f62bc-f3b4-4ef5-89a2-5a8cb2c9312a');
INSERT INTO `bs_token` VALUES ('4', '5', 'bbca0a4d-9914-4e5c-8805-81f001bd8901');
INSERT INTO `bs_token` VALUES ('5', '6', 'c4a3e52b-5411-446f-94e9-08c281317653');
INSERT INTO `bs_token` VALUES ('6', '7', '26c5578c-6066-40d8-9abc-bc056863aab9');
INSERT INTO `bs_token` VALUES ('7', '8', 'f427f94b-c185-4d38-b1ac-a5677ddbf5ca');
INSERT INTO `bs_token` VALUES ('8', '9', '89b1e197-2043-4538-a9a6-aba0da75c316');
INSERT INTO `bs_token` VALUES ('9', '10', '4eb06d21-0bd5-4d59-b1cc-6bd3ad863717');
INSERT INTO `bs_token` VALUES ('10', '11', 'c2702139-9d2d-434a-8ee5-f83d64c9f0d9');
INSERT INTO `bs_token` VALUES ('11', '12', '842f5911-7c2b-49ce-96e8-6d2cbda43881');
INSERT INTO `bs_token` VALUES ('12', '13', '3bdd0bb9-7926-4e91-9354-df51869b208f');
INSERT INTO `bs_token` VALUES ('13', '14', '437fd162-010c-46ab-a234-d519cae969fe');
INSERT INTO `bs_token` VALUES ('14', '15', '31e9916b-c6a6-4f0d-bd9b-dbe39f3daa8a');
INSERT INTO `bs_token` VALUES ('15', '16', '10b9b648-3034-477c-be99-b3576b90a6b4');

-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(255) DEFAULT NULL COMMENT ' 密码',
  `identity` varchar(255) DEFAULT NULL COMMENT '身份 0-管理员 1-普通用户',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `grade` varchar(255) DEFAULT NULL COMMENT '年级',
  `email` varchar(255) DEFAULT NULL COMMENT '姓名',
  `book_count` int DEFAULT NULL COMMENT '借书次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 ;

-- ----------------------------
-- Records of bs_user
-- ----------------------------
INSERT INTO `bs_user` VALUES ('1', 'admin', 'admin', '0', null, null, null, null, null, null);
INSERT INTO `bs_user` VALUES ('9', '2017010001', '2017010001', '1', '18', '男', '网络工程', '2017', '林宪宇', '28');
INSERT INTO `bs_user` VALUES ('10', '2017010002', '2017010002', '1', '18', '女', '软件工程', '2017', '王天1', '52');
INSERT INTO `bs_user` VALUES ('11', '2017010003', '2017010003', '1', '18', '男', '嵌入式', '2017', '陈杨', '6');
INSERT INTO `bs_user` VALUES ('14', '2017010005', '2017010005', '1', '18', '男', '网络工程', '2017', '吴天', '1');
INSERT INTO `bs_user` VALUES ('15', '2017010006', '2017010006', '1', '18', '女', '云计算', '2017', '陈思思', '0');
INSERT INTO `bs_user` VALUES ('16', '4181154050', '4181154050', '1', '22', '男', '通信工程（嵌入式）', '18', '吴永尼', '0');

-- ----------------------------
-- Table structure for bs_verdue_record
-- ----------------------------
DROP TABLE IF EXISTS `bs_verdue_record`;
CREATE TABLE `bs_verdue_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `borrow_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 ;

-- ----------------------------
-- Records of bs_verdue_record
-- ----------------------------
INSERT INTO `bs_verdue_record` VALUES ('13', '9', '5');
INSERT INTO `bs_verdue_record` VALUES ('14', '9', '6');
INSERT INTO `bs_verdue_record` VALUES ('15', '13', '9');
INSERT INTO `bs_verdue_record` VALUES ('16', '14', '10');
INSERT INTO `bs_verdue_record` VALUES ('17', '9', '11');
INSERT INTO `bs_verdue_record` VALUES ('18', '9', '12');
INSERT INTO `bs_verdue_record` VALUES ('19', '9', '13');
INSERT INTO `bs_verdue_record` VALUES ('20', '9', '14');
INSERT INTO `bs_verdue_record` VALUES ('21', '9', '15');
INSERT INTO `bs_verdue_record` VALUES ('22', '10', '16');
INSERT INTO `bs_verdue_record` VALUES ('23', '9', '7');
INSERT INTO `bs_verdue_record` VALUES ('24', '10', '8');
