-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: examsdatabase
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `composit`
--

DROP TABLE IF EXISTS `composit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `composit` (
  `Cid` int NOT NULL,
  `Subid` int DEFAULT NULL,
  `subject_Eid` int DEFAULT NULL,
  `subject_Sid` int DEFAULT NULL,
  PRIMARY KEY (`Cid`),
  KEY `Subid` (`Subid`),
  KEY `subject_Eid` (`subject_Eid`),
  KEY `subject_Sid` (`subject_Sid`),
  CONSTRAINT `composit_ibfk_1` FOREIGN KEY (`Subid`) REFERENCES `subject` (`Subid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `composit_ibfk_2` FOREIGN KEY (`subject_Eid`) REFERENCES `exam` (`Eid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `composit_ibfk_3` FOREIGN KEY (`subject_Sid`) REFERENCES `student` (`Sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composit`
--

LOCK TABLES `composit` WRITE;
/*!40000 ALTER TABLE `composit` DISABLE KEYS */;
/*!40000 ALTER TABLE `composit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16 22:47:04
