CREATE TABLE `t_success_choose` (
	`course_id` BIGINT(20) NOT NULL COMMENT '所选课程ID',
	`student_id` BIGINT(20) NOT NULL COMMENT '学号',
	`state` TINYINT(4) NOT NULL DEFAULT '',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`course_id`, `student_id`),
	INDEX `idx_create_time` (`create_time`)
)
COMMENT='选课结果明细表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;