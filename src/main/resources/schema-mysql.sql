CREATE TABLE IF NOT EXISTS `register1` (
  `account` varchar(20) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `active` tinyint NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account`)
);
  
