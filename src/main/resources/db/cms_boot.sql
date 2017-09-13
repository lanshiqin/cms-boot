-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: cms_boot
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cms_boot`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cms_boot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cms_boot`;

--
-- Table structure for table `sys_dep_info`
--

DROP TABLE IF EXISTS `sys_dep_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dep_info` (
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '部门名称',
  `level` int(11) NOT NULL DEFAULT '-1' COMMENT '部门级别',
  `relation` varchar(1000) NOT NULL DEFAULT '' COMMENT '部门关系',
  `status` varchar(50) NOT NULL DEFAULT '' COMMENT ' 部门状态（1：正常，0：禁用）',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='`sys_dep_info`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dep_info`
--

LOCK TABLES `sys_dep_info` WRITE;
/*!40000 ALTER TABLE `sys_dep_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dep_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_login_info`
--

DROP TABLE IF EXISTS `sys_login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login_info` (
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `pass_word` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `status` varchar(50) NOT NULL DEFAULT '' COMMENT '状态 1:正常 2:禁用',
  `user_id` bigint(15) NOT NULL DEFAULT '-1' COMMENT '用户id',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='`sys_login_info`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_info`
--

LOCK TABLES `sys_login_info` WRITE;
/*!40000 ALTER TABLE `sys_login_info` DISABLE KEYS */;
INSERT INTO `sys_login_info` VALUES ('lanshiqin','adminc','1',1,1,'2017-09-03','16:00','admin','2017-09-03','16:00','admin'),('lanshiqin2','adminc','1',20,19,'','','','','',''),('lanshiqin3','adminc','1',30,29,'','','','','','');
/*!40000 ALTER TABLE `sys_login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission_info`
--

DROP TABLE IF EXISTS `sys_permission_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission_info` (
  `func` varchar(255) NOT NULL DEFAULT '' COMMENT '授权地址',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '授权名称',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='`sys_permission_info`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission_info`
--

LOCK TABLES `sys_permission_info` WRITE;
/*!40000 ALTER TABLE `sys_permission_info` DISABLE KEYS */;
INSERT INTO `sys_permission_info` VALUES ('core:manage:layout','后台管理',1,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('core:sysinfo:layout','系统信息维护',2,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('core:userinfo:layout','用户信息维护',3,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('core:roleinfo:layout','角色信息维护',4,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('core:perinfo:layout','权限信息维护',5,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('core:depinfo:layout','部门信息维护',6,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员');
/*!40000 ALTER TABLE `sys_permission_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_info`
--

DROP TABLE IF EXISTS `sys_role_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_info` (
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '角色类型',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='`sys_role_info`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_info`
--

LOCK TABLES `sys_role_info` WRITE;
/*!40000 ALTER TABLE `sys_role_info` DISABLE KEYS */;
INSERT INTO `sys_role_info` VALUES ('管理员','admin',1,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('编辑员','editor',2,'','','','','',''),('审核者','auditor',4,'','','','','','');
/*!40000 ALTER TABLE `sys_role_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `role_id` varchar(50) NOT NULL DEFAULT '' COMMENT '角色id',
  `perm_id` varchar(50) NOT NULL DEFAULT '' COMMENT '权限id',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='`sys_role_permission`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES ('1','1',1,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','2',2,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','3',3,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','4',4,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','5',5,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','6',6,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','7',7,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','8',8,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','9',9,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','10',10,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','11',11,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','12',12,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员'),('1','13',13,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员');
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_info`
--

DROP TABLE IF EXISTS `sys_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_info` (
  `nick` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  `sex` varchar(50) NOT NULL DEFAULT '' COMMENT '性别',
  `birthday` varchar(50) NOT NULL DEFAULT '' COMMENT '生日',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='`sys_user_info`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_info`
--

LOCK TABLES `sys_user_info` WRITE;
/*!40000 ALTER TABLE `sys_user_info` DISABLE KEYS */;
INSERT INTO `sys_user_info` VALUES ('蓝士钦','男','2017年09月12日',1,'2017-09-03','16:00','admin','2017-09-03','16:00','admin'),('蓝士钦2','男','2017年09月13日',20,'','','','','',''),('蓝士钦3','男','2017年09月10日',30,'','','','','','');
/*!40000 ALTER TABLE `sys_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户id',
  `role_id` varchar(50) NOT NULL DEFAULT '' COMMENT '角色id',
  `sys_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建用户',
  `update_date` varchar(50) NOT NULL DEFAULT '' COMMENT '更新日期',
  `update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '更新时间',
  `update_user` varchar(50) NOT NULL DEFAULT '' COMMENT '更新用户',
  PRIMARY KEY (`sys_id`),
  UNIQUE KEY `sys_id` (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='`sys_user_role`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','1',1,'2017-09-04','20:00','管理员','2017-09-04','20:00','管理员');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-13 22:26:34
