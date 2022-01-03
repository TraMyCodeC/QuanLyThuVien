/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : quanlythuvien

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 03/01/2022 17:41:49
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('Duyen', '202cb962ac59075b964b07152d234b70', 5);
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of danhmucsach
-- ----------------------------
INSERT INTO `danhmucsach` VALUES (6, 'Huyền bí - Giả tưởng');
INSERT INTO `danhmucsach` VALUES (4, 'Khoa học');
INSERT INTO `danhmucsach` VALUES (3, 'Kinh dị');
INSERT INTO `danhmucsach` VALUES (1, 'Thiếu nhi');
INSERT INTO `danhmucsach` VALUES (7, 'Tiểu thuyết');
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of muonsach
-- ----------------------------
INSERT INTO `muonsach` VALUES (2, 1, '2022-01-03 14:47:53', NULL, NULL);
INSERT INTO `muonsach` VALUES (2, 2, '2022-01-03 14:47:53', '2022-01-03 17:10:22', NULL);
INSERT INTO `muonsach` VALUES (2, 3, '2022-01-03 14:47:53', NULL, NULL);
INSERT INTO `muonsach` VALUES (2, 4, '2022-01-03 14:47:53', NULL, NULL);
INSERT INTO `muonsach` VALUES (2, 5, '2021-11-03 14:47:53', NULL, NULL);
INSERT INTO `muonsach` VALUES (3, 3, '2021-03-03 14:52:11', '2022-01-03 17:28:44', NULL);
INSERT INTO `muonsach` VALUES (3, 4, '2022-01-03 14:52:11', '2022-01-03 16:50:23', NULL);
INSERT INTO `muonsach` VALUES (3, 5, '2022-01-03 14:52:11', '2022-01-03 14:55:56', NULL);
INSERT INTO `muonsach` VALUES (3, 6, '2022-01-03 14:52:11', '2022-01-03 14:55:56', NULL);
INSERT INTO `muonsach` VALUES (3, 7, '2022-01-03 14:52:11', '2022-01-03 16:50:23', NULL);
INSERT INTO `muonsach` VALUES (4, 6, '2022-01-03 16:39:36', NULL, NULL);
INSERT INTO `muonsach` VALUES (4, 8, '2022-01-03 16:39:36', '2022-01-03 17:14:03', NULL);
INSERT INTO `muonsach` VALUES (5, 2, '2021-12-05 16:28:45', '2022-01-19 16:28:52', NULL);
INSERT INTO `muonsach` VALUES (5, 3, '2021-12-28 16:28:11', '2021-12-31 16:28:20', NULL);
INSERT INTO `muonsach` VALUES (5, 4, '2022-01-03 16:28:51', NULL, NULL);
INSERT INTO `muonsach` VALUES (6, 4, '2022-01-03 16:39:36', NULL, NULL);
INSERT INTO `muonsach` VALUES (6, 6, '2022-01-03 16:39:36', NULL, NULL);
INSERT INTO `muonsach` VALUES (6, 8, '2022-01-03 16:39:36', NULL, NULL);
INSERT INTO `muonsach` VALUES (6, 10, '2022-01-03 16:39:36', NULL, NULL);
INSERT INTO `muonsach` VALUES (6, 11, '2022-01-03 16:39:36', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sach
-- ----------------------------
INSERT INTO `sach` VALUES (1, 'Túp lều bác Tom', 'Harriet Beecher Stowe', 'Tác phẩm kinh điển', '1852-03-21 07:47:59', 'Mỹ', 5, '2019-06-26 16:10:33', 'Khu văn học');
INSERT INTO `sach` VALUES (2, 'Nanh Trắng', 'Jack London', 'Tác phẩm kinh điển', '1906-05-08 16:15:45', 'Mỹ', 5, '2021-12-13 16:16:27', 'Khu văn học');
INSERT INTO `sach` VALUES (3, 'Hoàng tử bé', 'Antoine de Saint-Exupéry', 'Tác phẩm kinh điển', '1943-06-23 16:18:01', 'Pháp', 1, '2021-06-06 16:18:25', 'Khu thiếu nhi');
INSERT INTO `sach` VALUES (4, 'Sherlock Holmes ', 'Conan Doyle', 'Tác phẩm kinh điển', '1927-12-09 16:20:58', 'Anh', 2, '2021-09-21 16:20:43', 'Khu trinh thám');
INSERT INTO `sach` VALUES (5, 'Nguồn gốc các loài', 'Charles Darwin', 'Tác phẩm kinh điển', '1859-10-02 07:35:50', 'Anh', 4, '2021-11-09 16:24:49', 'Khu khoa học');
INSERT INTO `sach` VALUES (6, 'It', 'Stephen King', 'Tác phẩm kinh điển', '1986-05-15 16:26:06', 'Mỹ', 3, '2021-10-03 16:26:30', 'Khu kinh dị');
INSERT INTO `sach` VALUES (7, 'Tiếng gọi nơi hoang dã', 'Jack London', 'Tác phẩm kinh điển', '1903-06-25 12:02:44', 'Anh', 5, '2021-12-21 12:03:13', 'Khu văn học');
INSERT INTO `sach` VALUES (8, 'Harry Potter Và Hòn Đá Phù Thuỷ', 'J.K.Rowling', 'Top 100 sản phẩm Huyền Bí - Giả Tưởng - Kinh Dị', '2017-08-05 12:00:12', 'Anh', 6, '2022-01-03 15:14:00', 'Khu kinh dị');
INSERT INTO `sach` VALUES (9, 'Harry Potter Và Phòng Chứa Bí Mật', 'J.K.Rowling', 'Top 100 sản phẩm Huyền Bí - Giả Tưởng - Kinh Dị', '2017-08-05 12:00:12', 'Anh', 6, '2022-01-03 15:16:00', 'Khu kinh dị');
INSERT INTO `sach` VALUES (10, 'Harry Potter Và Tên Tù Nhân Ngục Azkaban', 'J.K.Rowling', 'Top 100 sản phẩm Huyền Bí - Giả Tưởng - Kinh Dị', '2017-08-05 12:00:12', 'Anh', 6, '2022-01-03 15:17:00', 'Khu kinh dị');
INSERT INTO `sach` VALUES (11, 'Harry Potter Và Chiếc Cốc Lửa', 'J.K.Rowling', 'Top 100 sản phẩm Huyền Bí - Giả Tưởng - Kinh Dị', '2017-08-05 12:00:12', 'Anh', 6, '2022-01-03 15:19:00', 'Khu kinh dị');
INSERT INTO `sach` VALUES (12, 'Tôi thấy hoa vàng trên cỏ xanh', 'Nguyễn Nhật Ánh', 'Là một trong những quyển sách Việt Nam bán chạy nhất năm 2010', '2010-12-09 08:00:00', 'Việt Nam', 1, '2022-01-03 15:23:00', 'Khu thiếu nhi');
INSERT INTO `sach` VALUES (13, 'Nhà giả kim', 'Paulo Coelho', 'Tác phẩm bán chạy mọi thời đại', '2013-10-30 00:00:00', 'Brazil', 5, '2022-01-03 15:30:00', 'Khu văn học');
INSERT INTO `sach` VALUES (14, 'Tắt đèn', 'Ngô Tất Tố', 'Tác phẩm bán chạy mọi thời đại', '1939-03-25 00:00:00', 'Việt Nam', 5, '2022-01-03 15:35:00', 'Khu văn học');
INSERT INTO `sach` VALUES (15, 'Số đỏ', 'Vũ Trọng Phụng', 'Tác phẩm bán chạy mọi thời đại', '1936-04-10 00:00:00', 'Việt Nam', 7, '2022-01-03 15:38:00', 'Khu tiểu thuyết');
INSERT INTO `sach` VALUES (16, 'Những ngày thơ ấu', 'Nguyên Hồng', 'Tác phẩm bán chạy mọi thời đại', '1940-06-12 00:00:00', 'Việt Nam', 7, '2022-01-03 15:39:00', 'Khu tiểu thuyết');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of thedocgia
-- ----------------------------
INSERT INTO `thedocgia` VALUES (1, 'Nguyễn Trà My', 'Nữ', '2001-06-30 15:51:23', 'Sinh Viên', '2021-12-31 15:52:08');
INSERT INTO `thedocgia` VALUES (2, 'Liên Tú Nhi', 'Nữ', '2001-12-20 15:57:57', 'Sinh Viên', '2022-01-04 15:53:46');
INSERT INTO `thedocgia` VALUES (3, 'Nguyễn Võ Văn Thiện', 'Nam', '2001-05-09 15:58:18', 'Sinh Viên', '2022-01-28 15:54:26');
INSERT INTO `thedocgia` VALUES (4, 'Trần Anh Tuấn', 'Nam', '1989-10-24 15:58:44', 'Giảng viên', '2022-10-29 15:55:50');
INSERT INTO `thedocgia` VALUES (5, 'Võ Thị Kim Duyên', 'Nữ', '1990-12-09 15:59:05', 'Nhân viên', '2022-02-03 15:57:36');
INSERT INTO `thedocgia` VALUES (6, 'Phan Nguyễn Hồng Hân', 'Nữ', '2001-11-16 09:10:23', 'Sinh Viên', '2022-05-07 20:23:26');

SET FOREIGN_KEY_CHECKS = 1;
