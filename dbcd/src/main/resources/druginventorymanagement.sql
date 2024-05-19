SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customerinformation
-- ----------------------------
DROP TABLE IF EXISTS `customerinformation`;
CREATE TABLE `customerinformation`  (
  `CustomerID` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ContactInfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `PurchaseDate` date NULL DEFAULT NULL,
  `PurchaseDrugID` int NULL DEFAULT NULL,
  `PurchaseDrugName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `PurchaseQuantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`CustomerID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customerinformation
-- ----------------------------
INSERT INTO `customerinformation` VALUES (1, '夏雄霖', '13462490968', '2005-09-05', 1, '头孢克洛', 100);
INSERT INTO `customerinformation` VALUES (2, '陆添昊', '19197885417', '2019-04-30', 2, '青霉素', 12);
INSERT INTO `customerinformation` VALUES (3, '郑忠林', '16668385199', '2013-02-14', 4, '盐酸氟西汀', 1);
INSERT INTO `customerinformation` VALUES (4, '刘芳', '19185869763', '2008-06-24', 2, '布洛芬', 3);
INSERT INTO `customerinformation` VALUES (5, '蔡尚', '16672012607', '2023-08-09', 8, '甲钴胺', 15);
INSERT INTO `customerinformation` VALUES (6, '钱晨茜', '15783396872', '2002-06-18', 7, '头孢克洛', 20);
INSERT INTO `customerinformation` VALUES (7, '锺夫子', '19182713011', '2022-04-29', 7, '青霉素', 11);
INSERT INTO `customerinformation` VALUES (8, '文一鸣', '13537680896', '2009-09-01', 5, '对乙酰氨基酚', 4);
INSERT INTO `customerinformation` VALUES (9, '陆诗悦', '18529750561', '2009-01-23', 5, '维生素C', 8);
INSERT INTO `customerinformation` VALUES (10, '郝润丽', '18735098793', '2003-04-24', 10, '氨茶碱', 2);
INSERT INTO `customerinformation` VALUES (11, 'Song Jialun', 'tq6RFeNiFp', '2004-02-28', 958, 'Song Jialun', 375);
INSERT INTO `customerinformation` VALUES (12, 'Denise Richardson', 'dojLSTNs2u', '2000-12-07', 345, 'Denise Richardson', 578);
INSERT INTO `customerinformation` VALUES (13, 'Sara Hayes', 'lnMfGl0E9q', '2008-09-19', 160, 'Sara Hayes', 562);

-- ----------------------------
-- Table structure for druginformation
-- ----------------------------
DROP TABLE IF EXISTS `druginformation`;
CREATE TABLE `druginformation`  (
  `drugId` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `drugName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productionDate` date NULL DEFAULT NULL,
  `shelfLife` int NULL DEFAULT NULL,
  `drugUsage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `handler` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`drugId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1653338115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druginformation
-- ----------------------------
INSERT INTO `druginformation` VALUES (1, '阿司匹林', '拜耳  ', '2003-06-10', 423, '阿司匹林常用于缓解疼痛、退烧、消炎和抗血小板聚集，常作为抗血栓药物使用。            ', 330.38, 890, '李天昊');
INSERT INTO `druginformation` VALUES (2, '对乙酰氨基酚', '杨森制药', '2008-09-20', 852, '对乙酰氨基酚是一种退热镇痛药，常用于缓解轻度到中度的疼痛和退烧。                ', 642.18, 676, '赖勇');
INSERT INTO `druginformation` VALUES (3, '维生素C', '罗氏  ', '2005-01-12', 182, '维生素C是一种重要的营养素，常用于增强免疫力、促进伤口愈合、抗氧化和促进铁的吸收。       ', 848.99, 176, '锺慧嘉');
INSERT INTO `druginformation` VALUES (4, '氨茶碱', '辉瑞  ', '2004-08-11', 595, '氨茶碱是一种支气管扩张剂，常用于治疗支气管哮喘、慢性阻塞性肺疾病（COPD）等呼吸系统疾病。  ', 331.68, 795, '赵雅涵');
INSERT INTO `druginformation` VALUES (7, '青霉素', '辉瑞  ', '2018-06-24', 57, '青霉素是一类广谱抗生素，常用于治疗细菌感染，特别是对革兰阳性细菌的感染。            ', 977.02, 169, '范翔');
INSERT INTO `druginformation` VALUES (8, '盐酸氟西汀', '伊莉莎 ', '2000-10-07', 546, '盐酸氟西汀是一种抗抑郁药，常用于治疗抑郁症、焦虑症和强迫症等精神疾病。             ', 979.57, 126, '黎凌晶');
INSERT INTO `druginformation` VALUES (9, '布洛芬', '拜耳  ', '2010-12-12', 508, '布洛芬是一种非处方的非甾体抗炎药，常用于缓解轻度到中度的疼痛和消炎，如头痛、关节炎和肌肉疼痛。 ', 919.96, 81, '江苒溪');
INSERT INTO `druginformation` VALUES (10, '双氯芬酸钠', '赛诺菲 ', '2009-03-03', 886, '双氯芬酸钠是一种非处方的非甾体抗炎药，常用于缓解疼痛和消炎，如关节炎、肌肉疼痛和痛经。     ', 359.96, 221, '陈欣慧');
INSERT INTO `druginformation` VALUES (12, '甲苯', 'wY4GqKv6cc', '2009-06-06', 239, '08RKMX8pK1', 440.19, 362, 'FIqqAXK8X9');
INSERT INTO `druginformation` VALUES (13, '甲醛', 'LMxOu4E7hh', '2001-04-18', 352, 'tKmkx6e8Le', 353.73, 61, 'XmroiCKzfe');

-- ----------------------------
-- Table structure for employeeinformation
-- ----------------------------
DROP TABLE IF EXISTS `employeeinformation`;
CREATE TABLE `employeeinformation`  (
  `employeeId` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `education` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`employeeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeeinformation
-- ----------------------------
INSERT INTO `employeeinformation` VALUES (2, '姚晶莹', 'F', 52, '本科学位', '软件工程师');
INSERT INTO `employeeinformation` VALUES (3, '姚榕润', 'F', 19, '高中毕业', '项目经理');
INSERT INTO `employeeinformation` VALUES (4, '袁欣慧', 'F', 35, '博士学位', '客户服务代表');
INSERT INTO `employeeinformation` VALUES (5, '龚欣宜', 'F', 63, '中专毕业', '数据分析师');
INSERT INTO `employeeinformation` VALUES (6, '常浩晨', 'M', 41, '硕士学位', '市场营销专员');
INSERT INTO `employeeinformation` VALUES (7, '雷新建', 'F', 30, '高中毕业', '人力资源助理');
INSERT INTO `employeeinformation` VALUES (8, '吴东东', 'F', 56, '本科学位', '财务分析师');
INSERT INTO `employeeinformation` VALUES (9, '傅秀兰', 'M', 24, '博士学位', '行政助理');
INSERT INTO `employeeinformation` VALUES (10, '金忠林', 'M', 48, '中专毕业', '网络运维工程师');
INSERT INTO `employeeinformation` VALUES (11, 'Ono Daichi', 'M', 580, '8mZJ8dVvo7', 'qJ2bDhirhx');
INSERT INTO `employeeinformation` VALUES (12, 'Yung Ching Wan', 'M', 374, 'Wor8ou9Cfi', 'RpxDGwunUu');

-- ----------------------------
-- Table structure for incominginformation
-- ----------------------------
DROP TABLE IF EXISTS `incominginformation`;
CREATE TABLE `incominginformation`  (
  `incomingId` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `drugId` int NULL DEFAULT NULL,
  `incomingDate` date NULL DEFAULT NULL,
  `incomingQuantity` int NULL DEFAULT NULL,
  `storageLocation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`incomingId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1862934530 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of incominginformation
-- ----------------------------
INSERT INTO `incominginformation` VALUES (1, 3, '2019-04-01', 400, '仓库2');
INSERT INTO `incominginformation` VALUES (2, 3, '2019-03-28', 160, '仓库1');
INSERT INTO `incominginformation` VALUES (3, 4, '2006-05-03', 200, '仓库3');
INSERT INTO `incominginformation` VALUES (4, 8, '2003-11-19', 822, '仓库3');
INSERT INTO `incominginformation` VALUES (5, 5, '2017-07-31', 410, '仓库2');
INSERT INTO `incominginformation` VALUES (6, 5, '2002-11-18', 360, '仓库1');
INSERT INTO `incominginformation` VALUES (7, 5, '2009-12-15', 200, '仓库1');
INSERT INTO `incominginformation` VALUES (8, 2, '2001-03-23', 230, '仓库3');
INSERT INTO `incominginformation` VALUES (1862934530, 21, '2023-12-05', 211, 'ee');

-- ----------------------------
-- Table structure for outgoinginformation
-- ----------------------------
DROP TABLE IF EXISTS `outgoinginformation`;
CREATE TABLE `outgoinginformation`  (
  `outgoingId` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `drugId` int NULL DEFAULT NULL,
  `outgoingDate` date NULL DEFAULT NULL,
  `outgoingQuantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`outgoingId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outgoinginformation
-- ----------------------------
INSERT INTO `outgoinginformation` VALUES (1, 3, '2022-03-08', 90);
INSERT INTO `outgoinginformation` VALUES (2, 4, '2023-11-13', 100);
INSERT INTO `outgoinginformation` VALUES (3, 2, '2013-04-16', 130);
INSERT INTO `outgoinginformation` VALUES (4, 10, '2013-07-11', 120);
INSERT INTO `outgoinginformation` VALUES (5, 2, '2005-02-05', 50);
INSERT INTO `outgoinginformation` VALUES (6, 8, '2008-04-01', 110);
INSERT INTO `outgoinginformation` VALUES (7, 8, '2010-09-25', 100);
INSERT INTO `outgoinginformation` VALUES (8, 3, '2020-10-30', 130);
INSERT INTO `outgoinginformation` VALUES (9, 1111, '2023-11-21', 100);

SET FOREIGN_KEY_CHECKS = 1;
