-- auto Generated on 2017-09-06 22:57:32 
-- DROP TABLE IF EXISTS `sys_dep_info`; 
CREATE TABLE `sys_dep_info`(
    `name` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '部门名称',
    `level` INT (11) NOT NULL DEFAULT -1 COMMENT '部门级别',
    `relation` VARCHAR (1000) NOT NULL DEFAULT '' COMMENT '部门关系',
    `status` VARCHAR (50) NOT NULL DEFAULT '' COMMENT ' 部门状态（1：正常，0：禁用）',
    `sys_id` BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建日期',
    `create_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建时间',
    `create_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建用户',
    `update_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新日期',
    `update_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新时间',
    `update_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新用户',
    PRIMARY KEY (`sys_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_dep_info`';
