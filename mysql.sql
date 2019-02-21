USE `test`;

DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `provincecode` varchar(255) DEFAULT NULL COMMENT '代码',
  `provincename` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省级信息';

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cityname` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `p_id` int(11) NOT NULL COMMENT '省份id',
  PRIMARY KEY (`id`),
  FOREIGN KEY fk_province(`p_id`)
  REFERENCES province(`id`)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市级信息';

-- 省级信息
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(1, 'SD', '山东');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(2, 'SX', '山西');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(3, 'HN', '河南');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(4, 'HB', '河北');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(5, 'GD', '广东');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(6, 'GX', '广西');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(7, 'JS', '江苏');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(8, 'JX', '江西');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(9, 'SC', '四川');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(10, 'FJ', '福建');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(11, 'GS', '甘肃');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(12, 'JL', '吉林');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(13, 'LN', '辽宁');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(14, 'NX', '宁夏');
INSERT INTO province(`id`, `provincecode`, `provincename`) VALUES(15, 'QH', '青海');

-- 市级信息
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(1, '济南', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(2, '青岛', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(3, '烟台', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(4, '威海', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(5, '济宁', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(6, '潍坊', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(7, '淄博', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(8, '聊城', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(9, '临沂', 1);
INSERT INTO city(`id`, `cityname`, `p_id`) VALUES(10, '菏泽', 1);