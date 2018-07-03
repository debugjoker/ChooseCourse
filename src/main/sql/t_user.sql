CREATE TABLE `t_user` (
	`user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
	`student_id` BIGINT(20) NOT NULL COMMENT '学号',
	`student_name` VARCHAR(50) NOT NULL COMMENT '姓名',
	`student_passWord` VARCHAR(50) NOT NULL COMMENT '密码',
	`student_className` VARCHAR(50) NOT NULL COMMENT '班级名',
	PRIMARY KEY (`user_id`),
	UNIQUE INDEX `student_id` (`student_id`)
)
COMMENT='用户信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1016
;
