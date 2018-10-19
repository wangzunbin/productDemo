/**
 * 创建表
 */
CREATE TABLE product(
	id BIGINT(20) PRIMARY key  NOT NULL AUTO_INCREMENT,
	productName VARCHAR(20),
	dir_id BIGINT(20),
  salePrice DECIMAL(11),
	supplier VARCHAR(20),
	brand  VARCHAR(20),
	cutoff DOUBLE,
	costPrice DECIMAL(11)
)ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;