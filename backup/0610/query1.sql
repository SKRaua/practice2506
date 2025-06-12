-- 使用数据库
USE cqupt;

-- 创建表格
CREATE TABLE cqupt_user(
	id INT PRIMARY KEY COMMENT '唯一标识',
	username VARCHAR(20) COMMENT '用户名',
	`name` VARCHAR(10) COMMENT '姓名',
	age INT COMMENT '年龄',
	gender CHAR(1) COMMENT '性别'
)COMMENT '用户表';

-- 插入数据
INSERT INTO cqupt_user (id,username,`name`,age,gender) VALUES (1,'zhangsan','张三',25,'M');
INSERT INTO cqupt_user (id,username,`name`,age,gender) VALUES (2,'lisi','李四',30,'M');
INSERT INTO cqupt_user (id,username,`name`,age,gender) VALUES (3,'wangwu','王五',28,'M');
INSERT INTO cqupt_user (id,username,`name`,age,gender) VALUES (4,'lihua','李华',22,'F');
INSERT INTO cqupt_user (id,username,`name`,age,gender) VALUES (5,'xiaoli','小丽',26,'F');

-- 查询语句
SELECT * FROM cqupt_user;
-- 查询年龄25岁的人的名字和年龄
SELECT `name`,age FROM cqupt_user WHERE age=25;
-- 查询所有的男性并返回前两行
SELECT * FROM cqupt_user WHERE gender='M' LIMIT 0,2;

-- 删除
-- 删除表中年龄大于29岁的人
DELETE FROM cqupt_user WHERE age>29;

-- 改数据
-- 将id为5的人的年龄改为25
UPDATE cqupt_user SET age=25 WHERE id=5;
