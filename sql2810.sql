/*
SQLyog Ultimate v9.33 GA
MySQL - 5.5.27 : Database - quanlycanbo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quanlycanbo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quanlycanbo`;

/*Table structure for table `baibao` */

DROP TABLE IF EXISTS `baibao`;

CREATE TABLE `baibao` (
  `maBaiBao` varchar(20) NOT NULL,
  `tenBaiBao` varchar(50) NOT NULL,
  `namXuatBan` date NOT NULL,
  `soXuatBan` varchar(20) NOT NULL,
  `tenTapChiDang` varchar(50) NOT NULL,
  `chiSoIssn` float NOT NULL,
  PRIMARY KEY (`maBaiBao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `baibao` */

insert  into `baibao`(`maBaiBao`,`tenBaiBao`,`namXuatBan`,`soXuatBan`,`tenTapChiDang`,`chiSoIssn`) values ('baibao1','Báo Tiền Phong','1991-11-11','3','Wall',3),('baibao2','Tuổi Trẻ','1991-11-11','3','Wall',3),('baibao3','Pháp Luât','1991-11-11','3','Wall',3),('baibao4','Giới Tính','1991-11-11','3','Wall',3),('baibao5','Ẩm Thực','1991-11-11','3','Wall',3),('baibao6','English','1991-11-11','3','Wall',5);

/*Table structure for table `canbo` */

DROP TABLE IF EXISTS `canbo`;

CREATE TABLE `canbo` (
  `maCanBo` varchar(20) NOT NULL,
  `tenCanBo` varchar(50) NOT NULL,
  `ngaySinh` date NOT NULL,
  `gioiTinh` int(1) NOT NULL,
  `diaChi` varchar(100) NOT NULL,
  `soDienThoai` varchar(20) DEFAULT NULL,
  `soTaiKhoan` varchar(20) DEFAULT NULL,
  `email` varbinary(50) DEFAULT NULL,
  `chucVu` varchar(20) DEFAULT NULL,
  `chucDanh` varchar(20) DEFAULT NULL,
  `heSoLuong` float DEFAULT NULL,
  `phuCapGiangDay` float DEFAULT NULL,
  `phuCapChucVu` float DEFAULT NULL,
  `maSoThue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`maCanBo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `canbo` */

insert  into `canbo`(`maCanBo`,`tenCanBo`,`ngaySinh`,`gioiTinh`,`diaChi`,`soDienThoai`,`soTaiKhoan`,`email`,`chucVu`,`chucDanh`,`heSoLuong`,`phuCapGiangDay`,`phuCapChucVu`,`maSoThue`) values ('CanBo1','XuanTruong','1992-11-25',1,'ThaiBinh','01644095347','711A44166112','tranxuantruong1992@gmail.com','truongphong','tiensi',2,2,2,'12345'),('CanBo10','QuangDung','1992-12-26',1,'HaNoi','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo11','PhamTruong','1992-12-26',1,'ThaiBinh','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo12','PhamTruong','1992-12-26',1,'TuyenQuang','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo13','Phú Hoàn','1992-12-26',1,'Hà Nam','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo2','MinhTuan','1992-12-26',1,'HaTay','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo3','HongQuan','1991-12-26',1,'SonTay','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo4','NgocThuyen','1992-12-26',1,'ThanhHoa','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo5','VanDung','1992-12-26',1,'BacGiang','01644095347','711A44166112','Minhtuan.techno','truongphong','tiensi',2,2,2,'12345'),('CanBo6','XuanThuy','1992-12-26',1,'HaNam','01644095347','711A44166112','Minhtuan.techno','truongphong','cbsc',4,2,2,'CanBo6');

/*Table structure for table `chamthi` */

DROP TABLE IF EXISTS `chamthi`;

CREATE TABLE `chamthi` (
  `maCanBo` varchar(20) NOT NULL,
  `maMonHoc` varchar(20) NOT NULL,
  `maLopHoc` varchar(20) NOT NULL,
  `soBaiThi` int(10) NOT NULL,
  `ngayLopBaiCham` date NOT NULL,
  `ngayNhanBaiCham` date NOT NULL,
  `lanThi` int(10) DEFAULT NULL,
  PRIMARY KEY (`maCanBo`,`maMonHoc`,`maLopHoc`),
  KEY `FK_chamthi_monhoc` (`maMonHoc`),
  KEY `FK_chamthi_lophoc` (`maLopHoc`),
  CONSTRAINT `FK_chamthi_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_chamthi_lophoc` FOREIGN KEY (`maLopHoc`) REFERENCES `lophoc` (`maLopHoc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_chamthi_monhoc` FOREIGN KEY (`maMonHoc`) REFERENCES `monhoc` (`maMonHoc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chamthi` */

insert  into `chamthi`(`maCanBo`,`maMonHoc`,`maLopHoc`,`soBaiThi`,`ngayLopBaiCham`,`ngayNhanBaiCham`,`lanThi`) values ('canbo1','monhoc1','lop1',1,'1991-11-11','1992-11-12',3),('canbo2','monhoc2','lop1',2,'1999-11-11','2000-11-12',3),('canbo3','monhoc3','lop2',2,'1999-11-11','2000-11-12',4),('canbo5','monhoc4','lop4',4,'1999-11-11','1998-11-11',4);

/*Table structure for table `detaikhoahoc` */

DROP TABLE IF EXISTS `detaikhoahoc`;

CREATE TABLE `detaikhoahoc` (
  `madeTai` varchar(20) NOT NULL,
  `tenDeTai` varchar(100) NOT NULL,
  `cap` varchar(50) NOT NULL,
  `kinhPhi` float NOT NULL,
  `thoiGianBatDau` date NOT NULL,
  `thoiGianKetThuc` date DEFAULT NULL,
  `tinhTrang` varchar(100) DEFAULT NULL,
  `ketQua` varchar(100) DEFAULT NULL,
  `chuTri` varchar(10) NOT NULL,
  PRIMARY KEY (`madeTai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detaikhoahoc` */

insert  into `detaikhoahoc`(`madeTai`,`tenDeTai`,`cap`,`kinhPhi`,`thoiGianBatDau`,`thoiGianKetThuc`,`tinhTrang`,`ketQua`,`chuTri`) values ('ma1','Toanhoa','cao',16,'2012-11-21','2012-11-29','ổn','tốt','hiệutruon'),('ma2','xxxx','xxxx',12,'1992-11-11','2000-11-11','ma2','tot','xxxx'),('ma3','Hoahoac','cao',18,'2012-11-12','2012-11-28','Trưởng nhó','chuản','fuck');

/*Table structure for table `giangday` */

DROP TABLE IF EXISTS `giangday`;

CREATE TABLE `giangday` (
  `maCanBo` varchar(20) NOT NULL,
  `maMonHoc` varchar(20) NOT NULL,
  `maLopHoc` varchar(20) NOT NULL,
  `thu` int(10) DEFAULT NULL,
  `tietBatDau` int(10) DEFAULT NULL,
  `soTietDay` int(10) DEFAULT NULL,
  `namHoc` varchar(20) DEFAULT NULL,
  `soSinhVien` int(100) DEFAULT NULL,
  PRIMARY KEY (`maCanBo`,`maMonHoc`,`maLopHoc`),
  KEY `FK_giangday_monhoc` (`maMonHoc`),
  KEY `FK_giangday_lophoc` (`maLopHoc`),
  CONSTRAINT `FK_giangday_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_giangday_lophoc` FOREIGN KEY (`maLopHoc`) REFERENCES `lophoc` (`maLopHoc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_giangday_monhoc` FOREIGN KEY (`maMonHoc`) REFERENCES `monhoc` (`maMonHoc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `giangday` */

insert  into `giangday`(`maCanBo`,`maMonHoc`,`maLopHoc`,`thu`,`tietBatDau`,`soTietDay`,`namHoc`,`soSinhVien`) values ('canbo3','monhoc3','lop3',7,4,2,'2010-11-11',40),('canbo4','monhoc3','lop4',7,4,2,'2010-11-11',40),('canbo5','monhoc4','lop5',6,4,3,'1991-11-9',32);

/*Table structure for table `lophoc` */

DROP TABLE IF EXISTS `lophoc`;

CREATE TABLE `lophoc` (
  `maLopHoc` varchar(20) NOT NULL,
  `siSo` int(10) NOT NULL,
  `soGhe` int(10) NOT NULL,
  PRIMARY KEY (`maLopHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lophoc` */

insert  into `lophoc`(`maLopHoc`,`siSo`,`soGhe`) values ('lop1',15,15),('lop2',15,15),('lop3',15,15),('lop4',15,15),('lop5',15,15),('lop6',16,17),('lop7',18,19),('lop8',9,20),('lop9',12,13);

/*Table structure for table `lopsv` */

DROP TABLE IF EXISTS `lopsv`;

CREATE TABLE `lopsv` (
  `maLopSv` varchar(20) NOT NULL,
  `tenLopSV` varchar(20) NOT NULL,
  `khoa` varchar(20) NOT NULL,
  `phanNganh` varchar(20) NOT NULL,
  PRIMARY KEY (`maLopSv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lopsv` */

/*Table structure for table `monhoc` */

DROP TABLE IF EXISTS `monhoc`;

CREATE TABLE `monhoc` (
  `maMonHoc` varchar(20) NOT NULL,
  `tenMonHoc` varchar(50) NOT NULL,
  `soTinChi` int(20) NOT NULL,
  `hocPhanSongHanh` varchar(20) NOT NULL,
  `hocPhanTienQuyet` varchar(20) NOT NULL,
  PRIMARY KEY (`maMonHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monhoc` */

insert  into `monhoc`(`maMonHoc`,`tenMonHoc`,`soTinChi`,`hocPhanSongHanh`,`hocPhanTienQuyet`) values ('monhoc1','GiaiTich',3,'DaiSo','Toan1'),('monhoc10','Project3',5,'NhapMon','Toan3'),('monhoc2','Dai So',3,'GiaiTich','Toan2'),('monhoc3','XacSuat',4,'NhapMon','Toan3'),('monhoc4','CSDL',4,'NhapMon','Toan3'),('monhoc5','CTDLGT',4,'NhapMon','Toan3'),('monhoc6','ToanRoiRac',4,'NhapMon','Toan3'),('monhoc7','Project1',4,'NhapMon','Toan3'),('monhoc8','Project2',4,'NhapMon','Toan3'),('monhoc9','Project3',5,'NhapMon','Toan3');

/*Table structure for table `nguoithan` */

DROP TABLE IF EXISTS `nguoithan`;

CREATE TABLE `nguoithan` (
  `hoVaTen` varchar(20) NOT NULL,
  `quanHe` varchar(20) NOT NULL,
  `namSinh` date NOT NULL,
  `thanhTich` varchar(20) DEFAULT NULL,
  `maCanBo` varchar(20) NOT NULL,
  PRIMARY KEY (`hoVaTen`),
  KEY `FK_nguoithan_canbo` (`maCanBo`),
  CONSTRAINT `FK_nguoithan_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nguoithan` */

insert  into `nguoithan`(`hoVaTen`,`quanHe`,`namSinh`,`thanhTich`,`maCanBo`) values ('Bong','Chau','2009-11-25','Kha','canbo6'),('Buoi','Chau','2009-11-25','Kha','canbo6'),('Dung','Chau','2001-11-25','gioi','canbo4'),('Hoa','Chau','2003-11-25','trungbinh','canbo6'),('Quan','Con','2000-11-25','gioi','canbo3'),('Thuy','Chau','2003-11-25','kha','canbo5'),('Thuyen','Chau','2003-11-25','gioi','canbo5'),('Truong','Con','1992-11-25','gioi','canbo1'),('Tuan','Con','1999-11-25','gioi','canbo2');

/*Table structure for table `sach` */

DROP TABLE IF EXISTS `sach`;

CREATE TABLE `sach` (
  `maSach` varchar(20) NOT NULL,
  `tenSach` varchar(50) NOT NULL,
  `namXuatban` date NOT NULL,
  `nhaXuatBan` varchar(50) NOT NULL,
  PRIMARY KEY (`maSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sach` */

insert  into `sach`(`maSach`,`tenSach`,`namXuatban`,`nhaXuatBan`) values ('1','1','1111-01-01','3'),('2','2','2101-11-11','KimDong');

/*Table structure for table `sinhvien` */

DROP TABLE IF EXISTS `sinhvien`;

CREATE TABLE `sinhvien` (
  `maSinhVien` varchar(20) NOT NULL,
  `tenSinhVien` varchar(50) NOT NULL,
  `diaChi` varchar(100) NOT NULL,
  `namSinh` date NOT NULL,
  `maLopSV` varchar(20) NOT NULL,
  PRIMARY KEY (`maSinhVien`),
  KEY `FK_sinhvien_lopsv` (`maLopSV`),
  CONSTRAINT `FK_sinhvien_lopsv` FOREIGN KEY (`maLopSV`) REFERENCES `lopsv` (`maLopSv`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sinhvien` */

/*Table structure for table `sinhviendangkilophoc` */

DROP TABLE IF EXISTS `sinhviendangkilophoc`;

CREATE TABLE `sinhviendangkilophoc` (
  `maLopHoc` varchar(20) NOT NULL,
  `maSinhVien` varchar(20) NOT NULL,
  PRIMARY KEY (`maLopHoc`,`maSinhVien`),
  KEY `FK_sinhviendangkilophoc_sinhvien` (`maSinhVien`),
  CONSTRAINT `FK_sinhviendangkilophoc_lophoc` FOREIGN KEY (`maLopHoc`) REFERENCES `lophoc` (`maLopHoc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_sinhviendangkilophoc_sinhvien` FOREIGN KEY (`maSinhVien`) REFERENCES `sinhvien` (`maSinhVien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sinhviendangkilophoc` */

/*Table structure for table `thamgiabaibao` */

DROP TABLE IF EXISTS `thamgiabaibao`;

CREATE TABLE `thamgiabaibao` (
  `maBaiBao` varchar(20) NOT NULL,
  `maCanBo` varchar(20) NOT NULL,
  `vaiTro` varchar(50) NOT NULL,
  PRIMARY KEY (`maBaiBao`,`maCanBo`),
  KEY `FK_thamgiabaibao_canbo` (`maCanBo`),
  CONSTRAINT `FK_thamgiabaibao_baibao` FOREIGN KEY (`maBaiBao`) REFERENCES `baibao` (`maBaiBao`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_thamgiabaibao_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `thamgiabaibao` */

/*Table structure for table `thamgianghiencuu` */

DROP TABLE IF EXISTS `thamgianghiencuu`;

CREATE TABLE `thamgianghiencuu` (
  `maCanBo` varchar(20) NOT NULL,
  `maDeTai` varchar(20) NOT NULL,
  `vaiTro` varchar(50) NOT NULL,
  PRIMARY KEY (`maCanBo`,`maDeTai`),
  KEY `FK_thamgianghiencuu_detai` (`maDeTai`),
  CONSTRAINT `FK_thamgianghiencuu_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_thamgianghiencuu_detai` FOREIGN KEY (`maDeTai`) REFERENCES `detaikhoahoc` (`madeTai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `thamgianghiencuu` */

/*Table structure for table `thamgiavietsach` */

DROP TABLE IF EXISTS `thamgiavietsach`;

CREATE TABLE `thamgiavietsach` (
  `maSach` varchar(20) NOT NULL,
  `maCanBo` varchar(20) NOT NULL,
  `vaiTro` varchar(50) NOT NULL,
  PRIMARY KEY (`maSach`,`maCanBo`),
  KEY `FK_thamgiavietsach_canbo` (`maCanBo`),
  CONSTRAINT `FK_thamgiavietsach_canbo` FOREIGN KEY (`maCanBo`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_thamgiavietsach_sach` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `thamgiavietsach` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
