/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : quanlythuvien

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 27/12/2021 15:42:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaDG` int NOT NULL,
  PRIMARY KEY (`UserName`, `MaDG`) USING BTREE,
  INDEX `fk_Account_DocGia`(`MaDG`) USING BTREE,
  CONSTRAINT `fk_Account_DocGia` FOREIGN KEY (`MaDG`) REFERENCES `thedocgia` (`MaDG`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('Duyen', '674f3c2c1a8a6f90461e8a66fb5550ba', 5);
INSERT INTO `account` VALUES ('My1', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO `account` VALUES ('My2', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO `account` VALUES ('Nhi1', 'a5e00132373a7031000fd987a3c9f87b', 2);
INSERT INTO `account` VALUES ('Nhi2', '86109d400f0ed29e840b47ed72777c84', 2);
INSERT INTO `account` VALUES ('Thien', '289dff07669d7a23de0ef88d2f7129e7', 3);
INSERT INTO `account` VALUES ('Tuan', '1728efbda81692282ba642aafd57be3a', 4);

-- ----------------------------
-- Table structure for danhmucsach
-- ----------------------------
DROP TABLE IF EXISTS `danhmucsach`;
CREATE TABLE `danhmucsach`  (
  `MaDanhMuc` int NOT NULL AUTO_INCREMENT,
  `TenDanhMuc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaDanhMuc`) USING BTREE,
  UNIQUE INDEX `UNIQ_TENDM`(`TenDanhMuc`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of danhmucsach
-- ----------------------------
INSERT INTO `danhmucsach` VALUES (4, 'Khoa học');
INSERT INTO `danhmucsach` VALUES (3, 'Kinh dị');
INSERT INTO `danhmucsach` VALUES (1, 'Thiếu nhi');
INSERT INTO `danhmucsach` VALUES (2, 'Trinh thám');
INSERT INTO `danhmucsach` VALUES (5, 'Văn học');

-- ----------------------------
-- Table structure for muonsach
-- ----------------------------
DROP TABLE IF EXISTS `muonsach`;
CREATE TABLE `muonsach`  (
  `MaDG` int NOT NULL,
  `MaSach` int NOT NULL,
  `NgayMuon` datetime(0) NOT NULL,
  `NgayTra` datetime(0) NULL DEFAULT NULL,
  `TienPhat` int NULL DEFAULT NULL,
  PRIMARY KEY (`MaDG`, `MaSach`, `NgayMuon`) USING BTREE,
  INDEX `fk_Muon_Sach`(`MaSach`) USING BTREE,
  CONSTRAINT `fk_Muon_DG` FOREIGN KEY (`MaDG`) REFERENCES `thedocgia` (`MaDG`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_Muon_Sach` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of muonsach
-- ----------------------------
INSERT INTO `muonsach` VALUES (5, 2, '2021-12-05 16:28:45', '2022-01-19 16:28:52', NULL);
INSERT INTO `muonsach` VALUES (5, 3, '2021-12-28 16:28:11', '2021-12-31 16:28:20', NULL);

-- ----------------------------
-- Table structure for sach
-- ----------------------------
DROP TABLE IF EXISTS `sach`;
CREATE TABLE `sach`  (
  `MaSach` int NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TacGia` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `MoTa` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `NamXB` datetime(0) NULL DEFAULT NULL,
  `NoiXB` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `MaDanhMuc` int NULL DEFAULT NULL,
  `NgayNhap` datetime(0) NULL DEFAULT NULL,
  `ViTri` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaSach`) USING BTREE,
  UNIQUE INDEX `UNIQ_Name`(`TenSach`) USING BTREE,
  INDEX `fk_Sach_DanhMuc`(`MaDanhMuc`) USING BTREE,
  CONSTRAINT `fk_Sach_DanhMuc` FOREIGN KEY (`MaDanhMuc`) REFERENCES `danhmucsach` (`MaDanhMuc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sach
-- ----------------------------
INSERT INTO `sach` VALUES (1, 'Túp lều bác Tom', 'Harriet Beecher Stowe', 'Tác phẩm kinh điển', '1852-03-21 07:47:59', 'Mỹ', 5, '2019-06-26 16:10:33', 'Khu văn học');
INSERT INTO `sach` VALUES (2, 'Nanh Trắng', 'Jack London', 'Tác phẩm kinh điển', '1906-05-08 16:15:45', 'Mỹ', 5, '2021-12-13 16:16:27', 'Khu văn học');
INSERT INTO `sach` VALUES (3, 'Hoàng tử bé', '	Antoine de Saint-Exupéry', 'Tác phẩm kinh điển', '1943-06-23 16:18:01', 'Pháp', 1, '2021-06-06 16:18:25', 'Khu thiếu nhi');
INSERT INTO `sach` VALUES (4, 'Sherlock Holmes ', 'Conan Doyle', 'Tác phẩm kinh điển', '1927-12-09 16:20:58', 'Anh', 2, '2021-09-21 16:20:43', 'Khu trinh thám');
INSERT INTO `sach` VALUES (5, 'Nguồn gốc các loài', 'Charles Darwin', 'Tác phẩm kinh điển', '1859-10-02 07:35:50', 'Anh', 4, '2021-11-09 16:24:49', 'Khu khoa học');
INSERT INTO `sach` VALUES (6, 'It', '	Stephen King', 'Tác phẩm kinh điển', '1986-05-15 16:26:06', 'Mỹ', 3, '2021-10-03 16:26:30', 'Khu kinh dị');
INSERT INTO `sach` VALUES (7, 'Tiếng gọi nơi hoang dã', 'Jack London', 'Tác phẩm kinh điển', '1903-06-25 12:02:44', 'Anh', 5, '2021-12-21 12:03:13', 'Khu văn học');

-- ----------------------------
-- Table structure for thedocgia
-- ----------------------------
DROP TABLE IF EXISTS `thedocgia`;
CREATE TABLE `thedocgia`  (
  `MaDG` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` datetime(0) NULL DEFAULT NULL,
  `DoiTuong` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `HanThe` datetime(0) NOT NULL,
  PRIMARY KEY (`MaDG`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thedocgia
-- ----------------------------
INSERT INTO `thedocgia` VALUES (1, 'Nguyễn Trà My', 'Nữ', '2001-06-30 15:51:23', 'Sinh Viên', '2021-12-31 15:52:08');
INSERT INTO `thedocgia` VALUES (2, 'Liên Tú Nhi', 'Nữ', '2001-12-20 15:57:57', 'Sinh Viên', '2022-01-04 15:53:46');
INSERT INTO `thedocgia` VALUES (3, 'Nguyễn Võ Văn Thiện', 'Nam', '2001-05-09 15:58:18', 'Sinh Viên', '2022-01-28 15:54:26');
INSERT INTO `thedocgia` VALUES (4, 'Trần Anh Tuấn', 'Nam', '1989-10-24 15:58:44', 'Giảng viên', '2022-10-29 15:55:50');
INSERT INTO `thedocgia` VALUES (5, 'Võ Thị Kim Duyên', 'Nữ', '1990-12-09 15:59:05', 'Nhân viên', '2022-02-03 15:57:36');

SET FOREIGN_KEY_CHECKS = 1;
