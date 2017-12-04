/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : bocom_demo

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-12-04 21:48:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `acno` varchar(40) NOT NULL COMMENT '账号',
  `acname` varchar(60) DEFAULT NULL COMMENT '户名',
  `acaddress` varchar(60) DEFAULT NULL COMMENT '地址',
  `accurrency` varchar(3) DEFAULT NULL COMMENT '币种',
  `acbalance` decimal(14,2) DEFAULT NULL COMMENT '余额',
  `acbalance_ava` decimal(14,2) DEFAULT NULL COMMENT '可用余额',
  `acbod` varchar(12) DEFAULT NULL COMMENT '开户银行',
  `acbodname` varchar(60) DEFAULT NULL COMMENT '开户行名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('001', 'diaolao', '广工', '001', '200.00', '200.00', '001', '工商银行');
INSERT INTO `account` VALUES ('002', 'jijifan', '广工', '001', '100.00', '50.00', '001', '工商银行');

-- ----------------------------
-- Table structure for tranaction
-- ----------------------------
DROP TABLE IF EXISTS `tranaction`;
CREATE TABLE `tranaction` (
  `trid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `trstatus` varchar(1) DEFAULT NULL COMMENT '交易状态',
  `trdate` varchar(8) DEFAULT NULL COMMENT '交易日期',
  `trtime` varchar(16) DEFAULT NULL COMMENT '交易时间',
  `trtype` varchar(60) DEFAULT '' COMMENT '业务类型',
  `trserial` varchar(16) DEFAULT NULL COMMENT '流水号',
  `trserialnum` varchar(4) DEFAULT NULL COMMENT '流水序号',
  `traccount` varchar(40) DEFAULT NULL COMMENT '账号',
  `trmark` varchar(1) DEFAULT NULL COMMENT '收支标志',
  `trcurrency` varchar(3) DEFAULT NULL COMMENT '币种',
  `tramount` decimal(14,2) DEFAULT NULL COMMENT '交易金额',
  `trbalance` decimal(14,2) DEFAULT NULL COMMENT '余额',
  `trbalance_ava` decimal(14,2) DEFAULT NULL COMMENT '可用余额',
  `traccount_to` varchar(40) DEFAULT NULL COMMENT '对方账号',
  `trbill_type` varchar(3) DEFAULT NULL COMMENT '票据种类',
  `trbill_num` varchar(35) DEFAULT NULL COMMENT '票据号码',
  `trbill_name` varchar(60) DEFAULT NULL COMMENT '票据名称',
  `trbill_sign_date` varchar(8) DEFAULT NULL COMMENT '票据签发日期',
  `trpostscript` varchar(200) DEFAULT NULL COMMENT '附言',
  `trremark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`trid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tranaction
-- ----------------------------
INSERT INTO `tranaction` VALUES ('1', '0', '20171204', '180000', '3其他', '0001', '0001', '001', 'D', '001', '10.00', '190.00', '190.00', '002', '001', '001', '发票', '20171204', '借钱', '暂无');
INSERT INTO `tranaction` VALUES ('2', '0', '20171205', '180000', '3其他', '0001', '0001', '001', 'D', '002', '50.00', '140.00', '140.00', '002', '002', '002', '小票', '20171205', '还钱', '没有');
