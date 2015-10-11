-- MySQL dump 10.13  Distrib 5.6.24, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: spring_security_expression
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'Admin User','ROLE_ADMIN','admin@admin.com','$2a$11$B0bQCvASQvHxQ2jihFN1EevBSgaRAvU5MWFWafeLx.CZtpWECiRmi'),(1,'Harmeet Singh','ROLE_USER','harmeet@user.com','$2a$11$B0bQCvASQvHxQ2jihFN1EevBSgaRAvU5MWFWafeLx.CZtpWECiRmi');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_permissions`
--

DROP TABLE IF EXISTS `users_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_permissions` (
  `id` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `url` varchar(300) NOT NULL,
  `permission` enum('ACCESS','DENIED') NOT NULL,
  PRIMARY KEY (`user_id`,`url`),
  KEY `fk_users_permissions_1_idx` (`user_id`),
  CONSTRAINT `fk_users_permissions_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_permissions`
--

LOCK TABLES `users_permissions` WRITE;
/*!40000 ALTER TABLE `users_permissions` DISABLE KEYS */;
INSERT INTO `users_permissions` VALUES ('fa72d264-1662-46b9-8687-6f18d2ff4ff5',1,'/section-three','ACCESS'),('be8cc57f-531c-4e5f-946b-1fe630962ef9',1,'/section-two','ACCESS');
/*!40000 ALTER TABLE `users_permissions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-11 15:35:01