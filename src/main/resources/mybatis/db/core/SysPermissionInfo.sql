-- auto Generated on 2017-09-03 15:00:36 
-- DROP TABLE IF EXISTS `sys_permission_info`; 
CREATE TABLE `sys_permission_info`(
    `func` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '授权地址',
    `name` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '授权名称',
    `sys_id` BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建日期',
    `create_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建时间',
    `create_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建用户',
    `update_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新日期',
    `update_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新时间',
    `update_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新用户',
    PRIMARY KEY (`sys_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_permission_info`';
