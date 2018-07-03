CREATE TABLE `t_course` (
	`course_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '课程id',
	`course_name` VARCHAR(120) NOT NULL COMMENT '课程名',
	`course_number` INT(11) NOT NULL COMMENT '课程数量',
	`start_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`end_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`course_id`),
	INDEX `idx_start_time` (`start_time`),
	INDEX `idx_end_time` (`end_time`),
	INDEX `idx_create_time` (`create_time`)
)
COMMENT='课程信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1004
;
