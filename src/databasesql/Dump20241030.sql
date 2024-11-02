-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlybansua
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietchuongtrinhkhuyenmai`
--

DROP TABLE IF EXISTS `chitietchuongtrinhkhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietchuongtrinhkhuyenmai` (
  `MaKM` varchar(10) NOT NULL,
  `MaSua` varchar(10) NOT NULL,
  `TiLeKM` decimal(5,2) NOT NULL,
  PRIMARY KEY (`MaKM`,`MaSua`),
  KEY `FKMaSua_idx` (`MaSua`),
  CONSTRAINT `FKMaKMCTKM` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`),
  CONSTRAINT `FKMaSuaCTKM` FOREIGN KEY (`MaSua`) REFERENCES `sua` (`MaSua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietchuongtrinhkhuyenmai`
--

LOCK TABLES `chitietchuongtrinhkhuyenmai` WRITE;
/*!40000 ALTER TABLE `chitietchuongtrinhkhuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietchuongtrinhkhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `MaSua` varchar(10) NOT NULL,
  `MaHD` varchar(10) NOT NULL,
  `SoLuong` varchar(45) NOT NULL,
  `GiaBan` double NOT NULL,
  PRIMARY KEY (`MaSua`,`MaHD`),
  KEY `FKMaHDCTHD_idx` (`MaHD`),
  CONSTRAINT `FKMaHDCTHD` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaNV`),
  CONSTRAINT `FKMaSuaCTHD` FOREIGN KEY (`MaSua`) REFERENCES `sua` (`MaSua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `MaSua` varchar(10) NOT NULL,
  `MaPN` varchar(10) NOT NULL,
  `SoLuong` int NOT NULL,
  `GiaNhap` double NOT NULL,
  PRIMARY KEY (`MaSua`,`MaPN`),
  KEY `FKMaPNCTPN_idx` (`MaPN`),
  CONSTRAINT `FKMaPNCTPN` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`),
  CONSTRAINT `FKMaSuaCTPN` FOREIGN KEY (`MaSua`) REFERENCES `sua` (`MaSua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
INSERT INTO `chitietphieunhap` VALUES ('S1','PN11',2,10),('S1','PN6',1,10),('S1','PN7',2,10),('S1','PN8',2,10),('S1','PN9',1,10),('S2','PN10',2,10),('S2','PN8',2,10);
/*!40000 ALTER TABLE `chitietphieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaKH` varchar(10) DEFAULT NULL,
  `NgayBan` timestamp NOT NULL,
  `TongTien` double NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `MaNV_idx` (`MaNV`),
  CONSTRAINT `FKMaNVHD` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('HD1','111','Kh1','2024-10-30 08:10:47',0);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` varchar(10) NOT NULL,
  `TongChiTieu` double DEFAULT NULL,
  `ten` varchar(45) NOT NULL,
  `GioiTInh` varchar(10) NOT NULL,
  `DiaChi` varchar(20) NOT NULL,
  `SoDT` varchar(10) NOT NULL,
  `Diem` double DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('KH1',1000000,'nguyễn văn a','Nam','Hà Nội','2134658709',1000),('KH3',3,'t','Nam','Ha noi','2143658790',0),('KH4',12233,'nguyen van toan','Nam','Ha noi','2134568790',12.233);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `TenCT` varchar(45) NOT NULL,
  `DieuKien` varchar(45) NOT NULL,
  PRIMARY KEY (`MaKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCCl` varchar(45) NOT NULL,
  `SoDT` int NOT NULL,
  `DiaCHi` varchar(200) NOT NULL,
  PRIMARY KEY (`MaNCC`),
  UNIQUE KEY `TenNCCl_UNIQUE` (`TenNCCl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('112','van toan',1243568790,'ha noi'),('1120','van toan3',2147483647,'ha noi'),('113','THtrueMilks',2143567890,'hà nội'),('114','milo',1243568790,'ha noi'),('115','hà lan',2143567890,'hà nội');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) NOT NULL,
  `ChucVu` varchar(45) NOT NULL,
  `Ten` varchar(45) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `DiaChi` varchar(20) NOT NULL,
  `SoDT` varchar(10) NOT NULL,
  `Luong` double NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `matkhau` varchar(45) NOT NULL,
  `duongdan` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('111','Nhân viên','Nguyễn Văn Trung1','Nam','Hà Nội','222',0,'2004-04-27','123',NULL),('11111','Nhân viên','Nguyễn ','Nữ','hà nội','1234567890',0,'0002-02-02','11',NULL),('1115','Nhân viên','hiền','Nữ','Hà Nội','1234567890',0,'2004-02-02','12','C:\\Users\\Toan\\Pictures\\suy\\Không Có Tiêu Đề20.jpg'),('11151','Nhân viên','3','Nam','GHÀ ','1234567788',0,'2004-02-02','123','C:\\Users\\Toan\\Pictures\\suy\\Không Có Tiêu Đề20.jpg'),('117','Nhân viên','ngy','Nữ','Hà Nội','1243568793',0,'0002-02-02','123',NULL),('118','Nhân viên','TOAN','Nữ','hÀ NỘI','1234566789',0,'2004-02-02','123',NULL),('123','Nhân viên','Nguyễn Văn Trỗi','Nam','hà Nội','1234567890',0,'2024-10-03','123',NULL),('admin','Nhân viên','Toàn','Nam','Hà Nội','1111',0,'2004-04-27','123',NULL),('NV1','Nhân viên','nguyen','Nữ','ha noi','2143568709',0,'2024-10-10','123','D:\\hdt\\baocaojava\\src\\picture\\images.png');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `MaPN` varchar(10) NOT NULL,
  `thoigiannhap` timestamp NULL DEFAULT NULL,
  `TongTien` double NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `TenNhaCungCap` varchar(45) NOT NULL,
  PRIMARY KEY (`MaPN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES ('PN1','2024-10-27 12:14:46',100,'toan','hà lan'),('PN10','2024-10-28 12:15:39',20,'toan','hà lan'),('PN11','2024-10-28 12:19:03',20,'toan','hà lan'),('PN2','2024-10-27 13:05:19',100,'toan','hà lan'),('PN3','2024-10-27 13:07:07',200,'toan','hà lan'),('PN4','2024-10-27 13:10:20',100,'toan','hà lan'),('PN5','2024-10-27 13:11:29',100,'toan','hà lan'),('PN6','2024-10-27 13:15:13',100,'toan','hà lan'),('PN7','2024-10-27 13:24:37',200,'toan','hà lan'),('PN8','2024-10-27 13:27:26',400,'toan','hà lan'),('PN9','2024-10-28 12:10:01',100,'toan','hà lan');
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sua`
--

DROP TABLE IF EXISTS `sua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sua` (
  `MaSua` varchar(10) NOT NULL,
  `TenSua` varchar(45) NOT NULL,
  `Soluong` int NOT NULL,
  `Size` varchar(45) NOT NULL,
  `anh` varchar(200) DEFAULT NULL,
  `KhoiLuong` varchar(45) NOT NULL,
  `HanSuDung` date NOT NULL,
  `DonGia` double NOT NULL,
  PRIMARY KEY (`MaSua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sua`
--

LOCK TABLES `sua` WRITE;
/*!40000 ALTER TABLE `sua` DISABLE KEYS */;
INSERT INTO `sua` VALUES ('S1','milo',11,'Hộp','D:\\hdt\\baocaojava\\src\\picture\\images.png','100ml','2024-10-17',10),('S2','kun',7,'Hộp','D:\\hdt\\baocaojava\\src\\picture\\images.png','100ml','2024-10-12',10),('S3','sua caca',2,'Hộp','C:\\Users\\Toan\\Pictures\\404639462_869769411273870_3367524605822329933_n.jpg','100ml','2024-10-05',1000);
/*!40000 ALTER TABLE `sua` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-30 23:28:23
