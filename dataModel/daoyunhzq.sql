/*
 Navicat Premium Data Transfer

 Source Server         : daoyun
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : daoyun

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 26/06/2020 11:04:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_type
-- ----------------------------
DROP TABLE IF EXISTS `activity_type`;
CREATE TABLE `activity_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_type_code` bigint(20) NOT NULL,
  `activity_type_order` int(11) NOT NULL,
  `activity_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `activity_type_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `annc_content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `publihser` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `publisher_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for authorization
-- ----------------------------
DROP TABLE IF EXISTS `authorization`;
CREATE TABLE `authorization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auz_type_id` bigint(20) NOT NULL,
  `auz_code` bigint(20) NOT NULL,
  `parent_auz_id` bigint(20) DEFAULT NULL,
  `auz_level` int(11) DEFAULT NULL,
  `auz_order` int(11) NOT NULL,
  `auz_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `auz_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `auz_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `auz_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for auz_type
-- ----------------------------
DROP TABLE IF EXISTS `auz_type`;
CREATE TABLE `auz_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auz_type_code` bigint(20) NOT NULL,
  `auz_type_order` int(11) NOT NULL,
  `auz_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `auz_type_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for colleges
-- ----------------------------
DROP TABLE IF EXISTS `colleges`;
CREATE TABLE `colleges`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school_id` bigint(20) NOT NULL,
  `college_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `college_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_school_id`(`school_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL,
  `discussion_id` bigint(20) NOT NULL,
  `reply_id` bigint(20) DEFAULT NULL,
  `quote_id` bigint(20) DEFAULT NULL,
  `rich_text` bigint(20) NOT NULL,
  `author_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comment_level` int(11) NOT NULL,
  `comment_order` int(11) NOT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_discussion_id`(`discussion_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for data_dictionary_key
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary_key`;
CREATE TABLE `data_dictionary_key`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_code` bigint(20) DEFAULT NULL,
  `dict_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `dict_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dict_code`(`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for data_dictionary_value
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary_value`;
CREATE TABLE `data_dictionary_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_id` bigint(20) NOT NULL,
  `data_code` bigint(20) DEFAULT NULL,
  `data_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `data_order` int(11) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dict_code`(`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for discussion
-- ----------------------------
DROP TABLE IF EXISTS `discussion`;
CREATE TABLE `discussion`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `discussion_type_code` bigint(20) DEFAULT NULL,
  `discussion_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `discussion_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE,
  INDEX `idx_task_id`(`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for discussion_file
-- ----------------------------
DROP TABLE IF EXISTS `discussion_file`;
CREATE TABLE `discussion_file`  (
  `id` bigint(20) NOT NULL,
  `file_type_id` bigint(20) NOT NULL,
  `file_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `file_binary` mediumblob,
  `file_hash` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `uploader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `download_count` int(11) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for file_type
-- ----------------------------
DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type`  (
  `id` bigint(20) NOT NULL,
  `file_type_code` bigint(20) NOT NULL,
  `file_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_type_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for group_plan
-- ----------------------------
DROP TABLE IF EXISTS `group_plan`;
CREATE TABLE `group_plan`  (
  `id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `group_plan_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `group_plan_order` int(11) NOT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for majors
-- ----------------------------
DROP TABLE IF EXISTS `majors`;
CREATE TABLE `majors`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college_id` bigint(20) NOT NULL,
  `major_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `major_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_college_id`(`college_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '�˵�ID',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '�˵�����',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '���˵�ID',
  `order_num` int(4) DEFAULT 0 COMMENT '��ʾ˳��',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '·�ɵ�ַ',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '���·��',
  `is_frame` int(1) DEFAULT 1 COMMENT '�Ƿ�Ϊ������0�� 1��',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '�˵����ͣ�MĿ¼ C�˵� F��ť��',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '�˵�״̬��0��ʾ 1���أ�',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '�˵�״̬��0���� 1ͣ�ã�',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Ȩ�ޱ�ʶ',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '#' COMMENT '�˵�ͼ��',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '������',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '������',
  `update_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '��ע',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '�˵�Ȩ�ޱ�' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, 1, 'M', '0', '0', '', 'system', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, 1, 'M', '0', '0', '', 'monitor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, 1, 'M', '0', '0', '', 'tool', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `menu` VALUES (4, '若依官网', 0, 4, 'http://ruoyi.vip', NULL, 0, 'M', '0', '0', '', 'guide', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '若依官网地址');
INSERT INTO `menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', 1, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', 1, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', 1, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', 1, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', 1, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', 1, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', 1, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `menu` VALUES (108, '日志管理', 1, 9, 'log', 'system/log/index', 1, 'M', '0', '0', '', 'log', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', 1, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', 1, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', 1, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', 1, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `menu` VALUES (113, '表单构建', 3, 1, 'build', 'tool/build/index', 1, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `menu` VALUES (114, '代码生成', 3, 2, 'gen', 'tool/gen/index', 1, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `menu` VALUES (115, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', 1, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `menu` VALUES (116, '用用管理管理', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-25 16:02:39', '', NULL, NULL);

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_code` bigint(20) NOT NULL,
  `parent_org_id` bigint(20) DEFAULT NULL,
  `school_id` bigint(20) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  `major_id` bigint(20) DEFAULT NULL,
  `is_root` tinyint(1) DEFAULT NULL,
  `org_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `org_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_org_code`(`org_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for org_file
-- ----------------------------
DROP TABLE IF EXISTS `org_file`;
CREATE TABLE `org_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_type_id` bigint(20) NOT NULL,
  `parent_file_id` bigint(20) DEFAULT NULL,
  `file_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `file_binary` mediumblob,
  `file_level` int(11) DEFAULT NULL,
  `file_hash` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `uploader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `download_count` int(11) NOT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for org_group
-- ----------------------------
DROP TABLE IF EXISTS `org_group`;
CREATE TABLE `org_group`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `group_plan_id` bigint(20) DEFAULT NULL,
  `group_code` bigint(20) NOT NULL,
  `parent_group_id` bigint(20) DEFAULT NULL,
  `is_root` tinyint(1) DEFAULT NULL,
  `group_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `group_type_code` bigint(20) DEFAULT NULL,
  `group_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `group_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_group_plan_id`(`group_plan_id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for org_msg
-- ----------------------------
DROP TABLE IF EXISTS `org_msg`;
CREATE TABLE `org_msg`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `msg_content` bigint(20) NOT NULL,
  `sender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for org_params
-- ----------------------------
DROP TABLE IF EXISTS `org_params`;
CREATE TABLE `org_params`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `param_code` bigint(20) NOT NULL,
  `param_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `param_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for org_role
-- ----------------------------
DROP TABLE IF EXISTS `org_role`;
CREATE TABLE `org_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_role_template_id` bigint(20) DEFAULT NULL,
  `is_template` tinyint(1) NOT NULL,
  `org_role_template_order` int(11) DEFAULT NULL,
  `org_role_code` bigint(20) NOT NULL,
  `org_role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `org_role_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for participate_in_activity
-- ----------------------------
DROP TABLE IF EXISTS `participate_in_activity`;
CREATE TABLE `participate_in_activity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `submit_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `edit_times` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_activity_id`(`activity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for published_activity
-- ----------------------------
DROP TABLE IF EXISTS `published_activity`;
CREATE TABLE `published_activity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_type_id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `group_plan_id` bigint(20) DEFAULT NULL,
  `activity_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `activity_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `activity_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `maxscore` int(11) DEFAULT NULL,
  `max_dist` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1275399421441376259 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of published_activity
-- ----------------------------
INSERT INTO `published_activity` VALUES (1275399421441376258, 10, 10, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-23 20:04:52', NULL, NULL, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for published_task
-- ----------------------------
DROP TABLE IF EXISTS `published_task`;
CREATE TABLE `published_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `task_type_id` bigint(20) NOT NULL,
  `group_plan_id` bigint(20) DEFAULT NULL,
  `task_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `publisher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `maxscore` int(11) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_org__file
-- ----------------------------
DROP TABLE IF EXISTS `r_org__file`;
CREATE TABLE `r_org__file`  (
  `org_id` bigint(20) NOT NULL,
  `org_file_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`org_id`, `org_file_id`) USING BTREE,
  INDEX `idx_org_file_id`(`org_file_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_org_role__auz
-- ----------------------------
DROP TABLE IF EXISTS `r_org_role__auz`;
CREATE TABLE `r_org_role__auz`  (
  `org_role_id` bigint(20) NOT NULL,
  `authorization_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`org_role_id`, `authorization_id`) USING BTREE,
  INDEX `idx_auz_id`(`authorization_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_org_role__menu
-- ----------------------------
DROP TABLE IF EXISTS `r_org_role__menu`;
CREATE TABLE `r_org_role__menu`  (
  `org_role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`org_role_id`, `menu_id`) USING BTREE,
  INDEX `idx_menu_id`(`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_role__auz
-- ----------------------------
DROP TABLE IF EXISTS `r_role__auz`;
CREATE TABLE `r_role__auz`  (
  `role_id` bigint(20) NOT NULL,
  `authorization_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`, `authorization_id`) USING BTREE,
  INDEX `idx_auz_id`(`authorization_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_role__menu
-- ----------------------------
DROP TABLE IF EXISTS `r_role__menu`;
CREATE TABLE `r_role__menu`  (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE,
  INDEX `idx_menu_id`(`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_role__menu
-- ----------------------------
INSERT INTO `r_role__menu` VALUES (1, 1, 0, NULL);
INSERT INTO `r_role__menu` VALUES (1, 2, 0, NULL);
INSERT INTO `r_role__menu` VALUES (1, 3, 0, NULL);
INSERT INTO `r_role__menu` VALUES (1, 4, 0, NULL);
INSERT INTO `r_role__menu` VALUES (1, 100, 0, NULL);
INSERT INTO `r_role__menu` VALUES (1, 101, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 1, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 2, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 3, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 4, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 100, 0, NULL);
INSERT INTO `r_role__menu` VALUES (3, 116, 0, NULL);

-- ----------------------------
-- Table structure for r_user__group
-- ----------------------------
DROP TABLE IF EXISTS `r_user__group`;
CREATE TABLE `r_user__group`  (
  `user_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `group_id`) USING BTREE,
  INDEX `idx_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_user__org
-- ----------------------------
DROP TABLE IF EXISTS `r_user__org`;
CREATE TABLE `r_user__org`  (
  `user_id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `org_id`) USING BTREE,
  INDEX `Index_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_user__org_role
-- ----------------------------
DROP TABLE IF EXISTS `r_user__org_role`;
CREATE TABLE `r_user__org_role`  (
  `user_id` bigint(20) NOT NULL,
  `org_role_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `org_role_id`) USING BTREE,
  INDEX `idx_org_role_id`(`org_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for r_user__user_msg
-- ----------------------------
DROP TABLE IF EXISTS `r_user__user_msg`;
CREATE TABLE `r_user__user_msg`  (
  `user_id` bigint(20) NOT NULL,
  `umsg_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `umsg_id`) USING BTREE,
  INDEX `idx_umsg_id`(`umsg_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rich_text
-- ----------------------------
DROP TABLE IF EXISTS `rich_text`;
CREATE TABLE `rich_text`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rich_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `rich_text_type_code` bigint(20) DEFAULT NULL,
  `rich_text_type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_template_id` bigint(20) DEFAULT NULL,
  `is_template` tinyint(1) NOT NULL,
  `role_template_order` int(11) DEFAULT NULL,
  `role_code` bigint(20) NOT NULL,
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, NULL, 0, NULL, 1, 'ADMIN', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `role` VALUES (2, NULL, 0, NULL, 2, 'USER', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for schools
-- ----------------------------
DROP TABLE IF EXISTS `schools`;
CREATE TABLE `schools`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `school_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for signin_history
-- ----------------------------
DROP TABLE IF EXISTS `signin_history`;
CREATE TABLE `signin_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `signin_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `signin_date` datetime NOT NULL,
  `signout_date` datetime DEFAULT NULL,
  `device_type` int(11) NOT NULL,
  `device_mac` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for submit_task
-- ----------------------------
DROP TABLE IF EXISTS `submit_task`;
CREATE TABLE `submit_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `submit_content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `submit_type` int(11) NOT NULL,
  `uploader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `edit_times` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_task_id`(`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `op_type` int(11) NOT NULL,
  `op_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `op_time` datetime NOT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for task_file
-- ----------------------------
DROP TABLE IF EXISTS `task_file`;
CREATE TABLE `task_file`  (
  `id` bigint(20) NOT NULL,
  `file_type_id` bigint(20) NOT NULL,
  `submit_task_id` bigint(20) NOT NULL,
  `file_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `file_binary` mediumblob,
  `file_hash` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `uploader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `download_count` int(11) DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_submit_task_id`(`submit_task_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_type_code` bigint(20) NOT NULL,
  `task_type_order` int(11) NOT NULL,
  `task_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `task_type_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for temp_file
-- ----------------------------
DROP TABLE IF EXISTS `temp_file`;
CREATE TABLE `temp_file`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `file_type_id` bigint(20) NOT NULL,
  `file_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `file_binary` mediumblob,
  `file_hash` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `salt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐值',
  `state` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '状态:NORMAL正常  PROHIBIT禁用',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `college` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birth_date` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `profile_photo` mediumblob,
  `profile_photo_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `coin` int(11) DEFAULT NULL,
  `signin_date` datetime DEFAULT NULL,
  `signup_date` datetime DEFAULT NULL,
  `last_signin_date` datetime DEFAULT NULL,
  `sign_count` int(11) DEFAULT NULL,
  `continue_signin_count` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `unlock_date` datetime DEFAULT NULL,
  `is_signin` tinyint(1) DEFAULT NULL,
  `mobile_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mobile_token_create_date` datetime DEFAULT NULL,
  `mobile_token_end_date` datetime DEFAULT NULL,
  `web_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `web_token_create_date` datetime DEFAULT NULL,
  `web_token_end_date` datetime DEFAULT NULL,
  `pc_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pc_token_create_date` datetime DEFAULT NULL,
  `pc_token_end_date` datetime DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 'admin', '1f9be2d951667ed9036710384795ae32a95a4a76f495eefa45ab5eaf33c92611', 'sclsjV3WvT8CJbly9tTw', 'NORMAL', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-24 16:18:04', 'admin', 0, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 3, 'hzqhzq', 'bdb4b1dc860559c0b70fb43821c82974d983f5afc716d1c65dece401b2bd1e6d', '8ckEV0hA0ZRQ1gaDbnHR', 'NORMAL', NULL, NULL, NULL, '993352270@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-24 15:23:58', NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 3, 'hzqhzq111', '80b7d4a9ca7f0dbdd1893712fc7d7eae38584037315d52625597a9c7b6371d73', '0M5AgacgcWIKVEGcbQ1q', 'NORMAL', NULL, NULL, NULL, '993352270@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-24 15:31:16', NULL, NULL, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_msg
-- ----------------------------
DROP TABLE IF EXISTS `user_msg`;
CREATE TABLE `user_msg`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `msg_content` bigint(20) NOT NULL,
  `sender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `receiver` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `receiver_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_org_info
-- ----------------------------
DROP TABLE IF EXISTS `user_org_info`;
CREATE TABLE `user_org_info`  (
  `user_id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `user_org_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_org_exp` int(11) DEFAULT NULL,
  `use_org_coin` int(11) DEFAULT NULL,
  `user_org_score` int(11) DEFAULT NULL,
  `user_org_signin_score` int(11) DEFAULT NULL,
  `user_org_school` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_org_college` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_org_major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_org_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_org_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extend_json` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_modification_date` datetime DEFAULT NULL,
  `last_modifier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `deleter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `org_id`) USING BTREE,
  INDEX `idx_org_id`(`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
