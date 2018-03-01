CREATE database douban; ##数据库名

create user autism IDENTIFIED by '970816'; ##设置用户

GRANT SELECT,UPDATE,INSERT,DELETE ON douban.* TO autism; ##颁发用户查询，更新，插入，删除权限


CREATE TABLE `eBook_info`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书主键',
  `no` varchar(20) NOT NULL COMMENT '豆瓣图书编号,url中数字',
  `title` VARCHAR(30) DEFAULT NULL COMMENT '书名',
  `subtitle` VARCHAR(50) DEFAULT NULL COMMENT '子标题',
  `author_name` varchar(30) DEFAULT NULL COMMENT '作者姓名',
  `translator` varchar(30) DEFAULT NULL COMMENT '译者',
  `label` VARCHAR(20) DEFAULT NULL COMMENT '类别',
  `press` varchar(20) DEFAULT NULL COMMENT '出版社',
  `provider` VARCHAR(20) DEFAULT NULL COMMENT '提供方',
  `word_count` INT(11) DEFAULT NULL COMMENT '字数',
  `rating` double(11,1) DEFAULT NULL COMMENT '豆瓣评分',
  `comments` int(11) DEFAULT NULL COMMENT '评价人数',
  `current_price` double DEFAULT NULL COMMENT '定价',
  `description` varchar(2000) DEFAULT NULL COMMENT '导言',
  `popular_annotations` varchar(2000) DEFAULT NULL COMMENT '热门划线',
  `key_words` varchar(50) DEFAULT NULL COMMENT '作品标签',
   `pubTime` date DEFAULT NULL COMMENT '出版年份',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
)ENGINE =InnoDB DEFAULT CHARSET =utf8 COMMENT '电子书';

CREATE TABLE `publisher`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '提供方主键',
  `no` VARCHAR(20) DEFAULT NULL COMMENT '豆瓣提供方url中编号',
  `introduce` VARCHAR(500) DEFAULT NULL COMMENT '供应商简介',
  PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT CHARSET utf8 COMMENT '电子书提供方';


ALTER TABLE `user_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `book_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `eBook_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `publisher` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `eBook_info` ADD COLUMN `pubTime` date DEFAULT NULL COMMENT '出版年份';

ALTER TABLE `eBook_info` MODIFY translator VARCHAR(50) DEFAULT NULL COMMENT '译者';
ALTER TABLE `eBook_info` MODIFY author_name VARCHAR(50)DEFAULT NULL COMMENT '作者姓名';

ALTER TABLE `eBook_info` MODIFY key_words VARCHAR(70) DEFAULT NULL COMMENT '作品标签';

ALTER TABLE  `eBook_info` MODIFY description VARCHAR(4000) DEFAULT NULL COMMENT '导言';
ALTER TABLE  `eBook_info` MODIFY popular_annotations VARCHAR(4000) DEFAULT NULL COMMENT '热门划线';

ALTER TABLE `eBook_info` MODIFY title  VARCHAR(50) DEFAULT NULL COMMENT '书名';
ALTER TABLE `eBook_info` MODIFY subtitle  VARCHAR(70) DEFAULT NULL COMMENT '书名';
ALTER TABLE `eBook_info` MODIFY `press` varchar(40) DEFAULT NULL COMMENT '出版社';

ALTER TABLE `eBook_info` MODIFY `no` INT(10) NOT NULL COMMENT '豆瓣图书编号,url中数字';

create table press_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `press` varchar(20) NOT NULL COMMENT '出版社',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '出版商临时表';

create table provider_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `provider` VARCHAR(20) DEFAULT NULL COMMENT '提供方',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '提供方临时表';

create table label_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label` VARCHAR(20) DEFAULT NULL COMMENT '类别',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '类别临时表';

create table author_address_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `author_address` varchar(30) DEFAULT NULL COMMENT '作者地域',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '作者地域临时表';

create table pubTime_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pubTime` VARCHAR(20) DEFAULT NULL COMMENT '出版年份',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '出版年份临时表';

create table rating_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rating` VARCHAR(10) DEFAULT NULL COMMENT '豆瓣评分',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '豆瓣评分临时表';

create table key_temp(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key_words` varchar(50) DEFAULT NULL COMMENT '作品标签',
  `num` int(10) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE = MEMORY DEFAULT CHARSET=utf8 COMMENT '作品标签临时表';


## -----------------------------------------------------------
## 测试

CREATE TABLE `test`(
  `now` DATE
);
INSERT INTO `test`(
  now
)VALUES ('2017-7-1');
select * from test;

CREATE TABLE `mytesttable` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '测试时间戳';
##----------------------------------------------------------------