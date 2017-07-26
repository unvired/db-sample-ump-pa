-- --------------------------------------------------------
-- Host:                         192.168.98.201
-- Server version:               5.6.34-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for unvired_sample
CREATE DATABASE IF NOT EXISTS `unvired_sample` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `unvired_sample`;


-- Dumping structure for table unvired_sample.contact
CREATE TABLE IF NOT EXISTS `contact` (
  `ContactId` int(20) NOT NULL,
  `ContactName` varchar(50) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ContactId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Contact';

-- Dumping data for table unvired_sample.contact: ~2 rows (approximately)
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` (`ContactId`, `ContactName`, `Phone`, `Email`) VALUES
	(165, 'Stark', '9246812688', 'stark.watney@gmail.com'),
	(521, 'John Davis', '9852352148', 'john.davis@hotmail.com');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
