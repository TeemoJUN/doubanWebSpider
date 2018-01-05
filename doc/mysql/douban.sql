CREATE database douban; ##数据库名

create user autism IDENTIFIED by '970816'; ##设置用户

GRANT SELECT,UPDATE,INSERT,DELETE ON douban.* TO autism; ##颁发用户查询，更新，插入，删除权限


CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(40) DEFAULT NULL COMMENT '用户编号',
  `name` varchar(40) DEFAULT NULL COMMENT '用户昵称',
  `signature` varchar(100) DEFAULT NULL COMMENT '签名',
  `location` varchar(100) DEFAULT NULL COMMENT '长居地',
  `time` date DEFAULT NULL COMMENT '注册豆瓣时间',
  `introduction` varchar(2000) DEFAULT NULL COMMENT '个人简介',
  `reading` int(11) DEFAULT NULL COMMENT '正在读',
  `has_read` int(11) DEFAULT NULL COMMENT '读过',
  `want_read` int(11) DEFAULT NULL COMMENT '想读',
  `concern` int(11) DEFAULT NULL COMMENT '关注了',
  `followers` int(11) DEFAULT NULL COMMENT '关注者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_no` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '豆瓣用户';



CREATE TABLE `book_info`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书主键',
  `no` varchar(20) NOT NULL COMMENT '豆瓣图书编号,url中数字',
  `title` varchar(30) DEFAULT NULL COMMENT '书名',
  `author_name` varchar(30) DEFAULT NULL COMMENT '作者姓名',
  `press` varchar(20) DEFAULT NULL COMMENT '出版社',
  `original_title` varchar(30) DEFAULT NULL COMMENT '图书原名',
  `translator` varchar(30) DEFAULT NULL COMMENT '译者',
  `pubTime` date DEFAULT NULL COMMENT '出版年份',
  `pages` int(11) DEFAULT NULL COMMENT '页数',
  `price` double DEFAULT NULL COMMENT '定价',
  `binding` varchar(20) DEFAULT NULL COMMENT '装帧',
  `series` varchar(20) DEFAULT NULL COMMENT '丛书',
  `isbn` varchar(60) DEFAULT NULL COMMENT 'ISBN',
  `rating` double(11,1) DEFAULT NULL COMMENT '豆瓣评分',
  `comments` int(11) DEFAULT NULL COMMENT '评价人数',
  `content_info` varchar(2000) DEFAULT NULL COMMENT '内容简介',
  `author_info` varchar(2000) DEFAULT NULL COMMENT '作者简介',
  `user_tags` varchar(200) DEFAULT NULL COMMENT '豆瓣成员常用标签',
  `also_like_eBook` varchar(400) DEFAULT NULL COMMENT '喜欢这本书的人也喜欢的电子书',
  `also_like_book` varchar(400) DEFAULT NULL COMMENT '喜欢这本书的人也喜欢读',
  `short_comments_num` int(11) DEFAULT NULL COMMENT '短评数',
  `book_comments_num` int(11) DEFAULT NULL COMMENT '书评数',
  `reading_notes_num` int(11) DEFAULT NULL COMMENT '读书笔记数',
  `readings_num` int(11) DEFAULT NULL COMMENT '正在读书人数',
  `has_read_num` int(11) DEFAULT NULL COMMENT '读过人数',
  `want_read_num` int(11) DEFAULT NULL COMMENT '想读人数',
  `other_versions` VARCHAR(1000) DEFAULT NULL COMMENT '其它版本,可以用关联no',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
)ENGINE =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8 COMMENT '实体书';

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
)ENGINE =InnoDB DEFAULT CHARSET =utf8 COMMENT '电子书';

CREATE TABLE `publisher`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '提供方主键',
  `no` VARCHAR(20) DEFAULT NULL COMMENT '豆瓣提供方url中编号',
  `introduce` VARCHAR(500) DEFAULT NULL COMMENT '供应商简介',
  PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT CHARSET utf8 COMMENT '电子书提供方';


## 测试
CREATE TABLE `test`(
  `now` DATE
);
INSERT INTO `test`(
now
)VALUES ('2017-7-1');
select * from test;


ALTER TABLE `user_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `book_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `eBook_info` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `publisher` ADD COLUMN  `url` VARCHAR(200) NOT NULL COMMENT 'url';
ALTER TABLE `eBook_info` ADD COLUMN `pubTime` date DEFAULT NULL COMMENT '出版年份';

SHOW CREATE TABLE eBook_info;