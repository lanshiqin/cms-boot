-- auto Generated on 2017-09-03 14:59:10 
-- DROP TABLE IF EXISTS `sys_user_role`; 
CREATE TABLE `sys_user_role`(
    `user_id` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户id',
    `role_id` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '角色id',
    `sys_id` BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建日期',
    `create_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建时间',
    `create_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建用户',
    `update_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新日期',
    `update_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新时间',
    `update_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新用户',
    PRIMARY KEY (`sys_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_user_role`';
