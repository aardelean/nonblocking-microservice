CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `country` varchar(255) DEFAULT NULL,
  `city`  varchar(255) DEFAULT NULL,
  `plz` varchar(6) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `streetNo` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `age` int(11) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) NOT NULL REFERENCES `address`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
