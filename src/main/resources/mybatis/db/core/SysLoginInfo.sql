-- auto Generated on 2017-09-03 14:51:33
-- DROP TABLE IF EXISTS `sys_login_info`;
CREATE TABLE `sys_login_info`(
    `user_name` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '用户名',
    `pass_word` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '密码',
    `status` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '状态 1:正常 2:禁用',
    `user_id` BIGINT(15) NOT NULL DEFAULT -1 COMMENT '用户id',
    `sys_id` BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建日期',
    `create_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建时间',
    `create_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '创建用户',
    `update_date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新日期',
    `update_time` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新时间',
    `update_user` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '更新用户',
    PRIMARY KEY (`sys_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_login_info`';
