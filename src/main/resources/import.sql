DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'Harmeet Singh','ROLE_USER','harmeet@user.com','$2a$11$B0bQCvASQvHxQ2jihFN1EevBSgaRAvU5MWFWafeLx.CZtpWECiRmi');
UNLOCK TABLES;

DROP TABLE IF EXISTS `users_permissions`;
CREATE TABLE `users_permissions` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `url` varchar(300) NOT NULL,
  `permission` enum('ACCESS','DENIED') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_permissions_1_idx` (`user_id`),
  CONSTRAINT `fk_users_permissions_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `users_permissions` WRITE;
INSERT INTO `users_permissions` VALUES (0,1,'/section-one','ACCESS');
UNLOCK TABLES;