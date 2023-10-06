CREATE TABLE `flights` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company` varchar(100) COLLATE armscii8_bin DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  `availableSeats` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin