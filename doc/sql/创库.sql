/*
SQLyog Ultimate
MySQL - 5.7.12-log : Database - nin_workflow
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
                               `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
                               `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
                               `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `DATA_` longblob,
                               `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
                               `IS_PROCESSED_` tinyint(4) DEFAULT '0',
                               PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
                                    `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                    `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                    `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部署的文件名称',
                                    `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '来自于父表ACT_RE_DEPLOYMENT的主键',
                                    `BYTES_` longblob COMMENT '大文本类型，存储文本字节流',
                                    `GENERATED_` tinyint(4) DEFAULT NULL COMMENT '是否是引擎生成。',
                                    PRIMARY KEY (`ID_`),
                                    KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
                                    CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='通用的流程定义和流程资源';

/*Data for the table `act_ge_bytearray` */

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
                                   `NAME_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '属性名称',
                                   `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '属性值',
                                   `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                   PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values ('cfg.execution-related-entities-count','false',1),('next.dbid','1',1),('schema.history','create(7.1.0-M6)',1),('schema.version','7.1.0-M6',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流程定义ID',
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流程实例ID',
                                  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流程执行ID',
                                  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '活动ID',
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务ID',
                                  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '请求流程实例ID',
                                  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动名称',
                                  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '活动类型',
                                  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '代理人员',
                                  `START_TIME_` datetime(3) NOT NULL COMMENT '开始时间',
                                  `END_TIME_` datetime(3) DEFAULT NULL COMMENT '结束时间',
                                  `DURATION_` bigint(20) DEFAULT NULL COMMENT '时长，耗时（毫秒值）',
                                  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '删除原因',
                                  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                  PRIMARY KEY (`ID_`),
                                  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
                                  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
                                  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
                                  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
                                     `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                     `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                     `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
                                     `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
                                     `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
                                     `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
                                     `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务Id',
                                     `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                     `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '链接',
                                     `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '内容Id ACT_GE_BYTEARRAY的ID',
                                     `TIME_` datetime(3) DEFAULT NULL COMMENT '时间',
                                     PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型：event（事件）comment（意见）',
                                  `TIME_` datetime(3) NOT NULL COMMENT '记录时间',
                                  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户Id',
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务Id',
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例Id',
                                  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '行为类型。值为下列内容中的一种：AddUserLink、AddComment、DeleteUserLink、AddGroupLink、AddAttachment、DeleteAttachment',
                                  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '处理意见，用于存放流程产生的信息，比如审批意见',
                                  `FULL_MSG_` longblob COMMENT '全部消息',
                                  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
                                 `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                 `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '数据类型，表单：FormProperty,参数：VariableUpdate',
                                 `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                 `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行实例ID',
                                 `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务实例ID',
                                 `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '活动实例Id，ACT_HI_ACTINST表的ID',
                                 `NAME_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '名称',
                                 `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '变量类型',
                                 `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                 `TIME_` datetime(3) NOT NULL COMMENT '时间',
                                 `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '字节数组Id，ACT_GE_BYTEARRAY表的ID',
                                 `DOUBLE_` double DEFAULT NULL,
                                 `LONG_` bigint(20) DEFAULT NULL,
                                 `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                 `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '此处存储的是JPA持久化对象时，才会有值。此值为对象ID',
                                 PRIMARY KEY (`ID_`),
                                 KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
                                 KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
                                 KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
                                 KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
                                 KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
                                       `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                       `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户组ID',
                                       `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户组类型',
                                       `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户ID',
                                       `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务Id',
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例Id',
                                       PRIMARY KEY (`ID_`),
                                       KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
                                       KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
                                       KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
                                   `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流程实例ID',
                                   `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '业务Key',
                                   `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流程定义Id',
                                   `START_TIME_` datetime(3) NOT NULL COMMENT '开始时间',
                                   `END_TIME_` datetime(3) DEFAULT NULL COMMENT '结束时间',
                                   `DURATION_` bigint(20) DEFAULT NULL COMMENT '时长',
                                   `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发起人员Id',
                                   `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '开始节点',
                                   `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '结束节点',
                                   `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '超级流程实例Id',
                                   `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '删除理由',
                                   `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                   `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   PRIMARY KEY (`ID_`),
                                   UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
                                   KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
                                   KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
                                   `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                   `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程定义Id',
                                   `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '任务定义Key，节点定义ID',
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                   `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行ID',
                                   `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
                                   `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '父任务iD',
                                   `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
                                   `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '实际签收人 任务的拥有者（默认为空，只有在委托时才有值）',
                                   `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '代理人',
                                   `START_TIME_` datetime(3) NOT NULL COMMENT '开始时间',
                                   `CLAIM_TIME_` datetime(3) DEFAULT NULL COMMENT '提醒时间',
                                   `END_TIME_` datetime(3) DEFAULT NULL COMMENT '结束时间',
                                   `DURATION_` bigint(20) DEFAULT NULL COMMENT '时长',
                                   `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '删除理由',
                                   `PRIORITY_` int(11) DEFAULT NULL COMMENT '优先级',
                                   `DUE_DATE_` datetime(3) DEFAULT NULL COMMENT '应完成时间',
                                   `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '表单key',
                                   `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                   PRIMARY KEY (`ID_`),
                                   KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行ID',
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务Id',
                                  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '名称',
                                  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '变量类型',
                                  `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '字节数组ID，ACT_GE_BYTEARRAY表的主键',
                                  `DOUBLE_` double DEFAULT NULL,
                                  `LONG_` bigint(20) DEFAULT NULL,
                                  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `CREATE_TIME_` datetime(3) DEFAULT NULL COMMENT '创建时间',
                                  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL COMMENT '修改时间',
                                  PRIMARY KEY (`ID_`),
                                  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
                                  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
                                  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
                                    `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                    `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                    `REV_` int(11) DEFAULT NULL,
                                    `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    PRIMARY KEY (`ID_`),
                                    UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
                                    KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
                                    KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
                                    CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                    CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
                                     `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                     `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部署包的名称',
                                     `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
                                     `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部署key',
                                     `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '租户，多租户通常是在软件需要为多个不同组织服务时产生的概念',
                                     `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL COMMENT '部署时间',
                                     `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '引擎版本',
                                     `VERSION_` int(11) DEFAULT '1' COMMENT '版本号',
                                     `PROJECT_RELEASE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '工程发布版本',
                                     PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

insert  into `act_re_deployment`(`ID_`,`NAME_`,`CATEGORY_`,`KEY_`,`TENANT_ID_`,`DEPLOY_TIME_`,`ENGINE_VERSION_`,`VERSION_`,`PROJECT_RELEASE_VERSION_`) values ('01108883-64f4-11ea-8de9-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 14:29:34.079',NULL,47,NULL),('05cefbbd-6430-11ea-b77f-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:06:40.682',NULL,22,NULL),('0a2567c6-636d-11ea-bc97-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:50:56.092',NULL,7,NULL),('0d9e9fec-6506-11ea-aa45-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:38:46.082',NULL,56,NULL),('105ad1b0-64ca-11ea-b187-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 09:29:20.723',NULL,44,NULL),('15214ea5-6435-11ea-9367-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:42:53.871',NULL,27,NULL),('1883d385-6374-11ea-afaa-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 16:41:26.684',NULL,8,NULL),('1a116df4-6437-11ea-8330-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:57:21.147',NULL,31,NULL),('1abb568c-6508-11ea-a164-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:53:27.073',NULL,58,NULL),('22876694-6433-11ea-9661-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:28:57.357',NULL,25,NULL),('230ca516-6425-11ea-82ed-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:48:45.276',NULL,17,NULL),('28340b6d-6506-11ea-aa45-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:39:30.685',NULL,57,NULL),('290ecde6-6418-11ea-bb71-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 12:15:51.901',NULL,10,NULL),('2b3534a6-6436-11ea-83b2-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:50:40.408',NULL,29,NULL),('35c015ce-636c-11ea-bea3-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:44:59.755',NULL,4,NULL),('37a05e95-6505-11ea-990c-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:32:47.063',NULL,51,NULL),('39360e1f-6426-11ea-b1cf-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:56:31.954',NULL,18,NULL),('3a4d91d0-6443-11ea-9c52-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 17:24:09.187',NULL,39,NULL),('3b991625-6424-11ea-acde-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:42:16.968',NULL,15,NULL),('3c3c4dad-6508-11ea-a164-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:54:23.288',NULL,59,NULL),('3ee4a6e2-6443-11ea-9787-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 17:24:16.887',NULL,40,NULL),('3f82826e-6445-11ea-a9b8-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 17:38:36.888',NULL,41,NULL),('4331332f-643a-11ea-810c-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:19:58.630',NULL,37,NULL),('450cdd2f-636c-11ea-82b4-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:45:25.428',NULL,5,NULL),('45d83839-636b-11ea-a639-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:38:17.232',NULL,1,NULL),('4893f13b-6439-11ea-8f89-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:12:58.171',NULL,34,NULL),('4a1768aa-642f-11ea-b4f2-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:01:25.743',NULL,21,NULL),('5453a3db-6509-11ea-9a8b-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 17:02:13.200',NULL,60,NULL),('571f901c-64f6-11ea-8d1d-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 14:46:17.454',NULL,49,NULL),('5a535194-6437-11ea-98b0-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:59:08.953',NULL,32,NULL),('5c26a676-6505-11ea-990c-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:33:48.344',NULL,52,NULL),('622f17e4-64f5-11ea-9fc7-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 14:39:26.513',NULL,48,NULL),('62aebe44-6428-11ea-ae50-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 14:12:00.524',NULL,20,NULL),('7314b7ac-6509-11ea-9a8b-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 17:03:04.802',NULL,61,NULL),('73a5aedf-643a-11ea-9c52-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:21:19.925',NULL,38,NULL),('76451298-64f3-11ea-bd38-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 14:25:41.219',NULL,46,NULL),('81508495-6445-11ea-8f22-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 17:40:27.311',NULL,42,NULL),('82abd4a8-64ec-11ea-9f29-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 13:35:55.520',NULL,45,NULL),('9070ff60-6435-11ea-8681-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:46:20.752',NULL,28,NULL),('98074482-6422-11ea-82b1-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:30:33.046',NULL,12,NULL),('99397854-6421-11ea-a8ec-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:23:25.556',NULL,11,NULL),('9ade83d9-6504-11ea-b0c9-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:28:24.069',NULL,50,NULL),('9c931f9d-6509-11ea-9a8b-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 17:04:14.415',NULL,62,NULL),('a599c61c-6424-11ea-a750-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:45:14.810',NULL,16,NULL),('a751e015-636c-11ea-bc97-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:48:10.297',NULL,6,NULL),('a873dc54-6439-11ea-a2e6-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:15:39.023',NULL,35,NULL),('b2238b89-6426-11ea-babc-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:59:54.838',NULL,19,NULL),('babe37cf-636b-11ea-88a4-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:41:33.385',NULL,2,NULL),('bc6e29f0-6432-11ea-a26b-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:26:06.064',NULL,23,NULL),('bece8422-6414-11ea-bce1-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 11:51:25.117',NULL,9,NULL),('c7657bf7-6505-11ea-990c-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:36:48.271',NULL,53,NULL),('ca3ebc1b-6433-11ea-b7d1-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:33:38.738',NULL,26,NULL),('ca99d746-6437-11ea-968a-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:02:17.321',NULL,33,NULL),('d40c07dd-636b-11ea-bea3-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:42:15.840',NULL,3,NULL),('d5539f0a-6436-11ea-85d0-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:55:25.816',NULL,30,NULL),('dcd7e721-6505-11ea-ba95-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:37:24.248',NULL,54,NULL),('e13742e2-6439-11ea-9b96-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 16:17:14.256',NULL,36,NULL),('e8ee0f84-6423-11ea-b27b-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:39:58.273',NULL,14,NULL),('ecf3af76-6447-11ea-8efc-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 17:57:46.645',NULL,43,NULL),('ed74d522-6505-11ea-ba95-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-13 16:37:52.125',NULL,55,NULL),('ef353a4f-6422-11ea-828e-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 13:32:59.309',NULL,13,NULL),('f3530c88-6432-11ea-89b8-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-12 15:27:38.161',NULL,24,NULL);

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
                                `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '模型的名称，比如请假单',
                                `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '模型的关键字，流程引擎用到，比如：FTOA_SWGL',
                                `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型，用户自己对流程模型的分类。',
                                `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL COMMENT '创建时间',
                                `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL COMMENT '最后修改时间',
                                `VERSION_` int(11) DEFAULT NULL COMMENT '版本，从1开始。',
                                `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '数据源信息',
                                `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '部署ID',
                                `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '编辑源值ID',
                                `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '编辑源额外值ID（外键ACT_GE_BYTEARRAY ）',
                                `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '租户',
                                PRIMARY KEY (`ID_`),
                                KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
                                KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
                                KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
                                CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
                                CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键',
                                  `REV_` int(11) DEFAULT NULL COMMENT '乐观锁版本号',
                                  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '流程命名空间，流程定义的Namespace就是类别',
                                  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '流程名称，流程文件process元素的name属性值',
                                  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '流程编号（该编号就是流程文件process元素的id属性值）',
                                  `VERSION_` int(11) NOT NULL COMMENT '流程版本号',
                                  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '部署编号，部署表ID',
                                  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '资源文件名称',
                                  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '图片资源文件名称',
                                  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
                                  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL COMMENT '是否从key启动',
                                  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
                                  `SUSPENSION_STATE_` int(11) DEFAULT NULL COMMENT '是否挂起',
                                  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '租户',
                                  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '引擎版本',
                                  `APP_VERSION_` int(11) DEFAULT NULL COMMENT '应用版本',
                                  PRIMARY KEY (`ID_`),
                                  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

/*Table structure for table `act_ru_deadletter_job` */

DROP TABLE IF EXISTS `act_ru_deadletter_job`;

CREATE TABLE `act_ru_deadletter_job` (
                                         `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                         `REV_` int(11) DEFAULT NULL,
                                         `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                         `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
                                         `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                         `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                         `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                         `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                         `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                         `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
                                         `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                         `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                         `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                         `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                         PRIMARY KEY (`ID_`),
                                         KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
                                         KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
                                         KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
                                         KEY `ACT_FK_DEADLETTER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
                                         CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                         CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                         CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                         CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_deadletter_job` */

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
                                       `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                       `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                       `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '事件类型',
                                       `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '事件名称',
                                       `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程执行ID',
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                       `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '活动ID',
                                       `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '配置信息',
                                       `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
                                       `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                       PRIMARY KEY (`ID_`),
                                       KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
                                       KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
                                       CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
                                    `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                    `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                    `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例编号',
                                    `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '业务编号',
                                    `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '父执行流程',
                                    `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程定义Id',
                                    `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '实例id',
                                    `IS_ACTIVE_` tinyint(4) DEFAULT NULL COMMENT '激活状态',
                                    `IS_CONCURRENT_` tinyint(4) DEFAULT NULL COMMENT '并发状态',
                                    `IS_SCOPE_` tinyint(4) DEFAULT NULL,
                                    `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
                                    `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
                                    `SUSPENSION_STATE_` int(11) DEFAULT NULL COMMENT '暂停状态_',
                                    `CACHED_ENT_STATE_` int(11) DEFAULT NULL COMMENT '缓存结束状态_',
                                    `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                    `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `START_TIME_` datetime(3) DEFAULT NULL,
                                    `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
                                    `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
                                    `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
                                    `TASK_COUNT_` int(11) DEFAULT NULL,
                                    `JOB_COUNT_` int(11) DEFAULT NULL,
                                    `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
                                    `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
                                    `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
                                    `VAR_COUNT_` int(11) DEFAULT NULL,
                                    `ID_LINK_COUNT_` int(11) DEFAULT NULL,
                                    `APP_VERSION_` int(11) DEFAULT NULL,
                                    PRIMARY KEY (`ID_`),
                                    KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
                                    KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
                                    KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
                                    KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
                                    KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
                                    KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
                                    CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
                                    CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
                                    CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
                                    CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运行时流程执行实例，核心，我的代办任务查询表';

/*Data for the table `act_ru_execution` */

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
                                       `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                       `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                       `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户组ＩＤ',
                                       `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户组类型',
                                       `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户ID',
                                       `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务Id',
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                                       `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程定义Id',
                                       PRIMARY KEY (`ID_`),
                                       KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
                                       KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
                                       KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
                                       KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
                                       KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
                                       CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
                                       CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                       CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='身份联系，主要存储当前节点参与者的信息,任务参与者数据表';

/*Data for the table `act_ru_identitylink` */

/*Table structure for table `act_ru_integration` */

DROP TABLE IF EXISTS `act_ru_integration`;

CREATE TABLE `act_ru_integration` (
                                      `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                      `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                      `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                      `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                      `FLOW_NODE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                      `CREATED_DATE_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
                                      PRIMARY KEY (`ID_`),
                                      KEY `ACT_FK_INT_EXECUTION` (`EXECUTION_ID_`),
                                      KEY `ACT_FK_INT_PROC_INST` (`PROCESS_INSTANCE_ID_`),
                                      KEY `ACT_FK_INT_PROC_DEF` (`PROC_DEF_ID_`),
                                      CONSTRAINT `ACT_FK_INT_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
                                      CONSTRAINT `ACT_FK_INT_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
                                      CONSTRAINT `ACT_FK_INT_PROC_INST` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_integration` */

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
                              `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                              `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                              `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '类型',
                              `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL COMMENT '锁定释放时间',
                              `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '挂起者',
                              `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
                              `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行实例ID',
                              `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                              `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程定义ID',
                              `RETRIES_` int(11) DEFAULT NULL,
                              `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '异常信息ID',
                              `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '异常信息',
                              `DUEDATE_` timestamp(3) NULL DEFAULT NULL COMMENT '到期时间',
                              `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '重复',
                              `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '处理类型',
                              `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '标识',
                              `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                              PRIMARY KEY (`ID_`),
                              KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
                              KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
                              KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
                              KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
                              CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运行中的任务，运行时定时任务数据表';

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_suspended_job` */

DROP TABLE IF EXISTS `act_ru_suspended_job`;

CREATE TABLE `act_ru_suspended_job` (
                                        `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                        `REV_` int(11) DEFAULT NULL,
                                        `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                        `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
                                        `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                        `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                        `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                        `RETRIES_` int(11) DEFAULT NULL,
                                        `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                        `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                        `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
                                        `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                        `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                        `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                        `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                        PRIMARY KEY (`ID_`),
                                        KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
                                        KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
                                        KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
                                        KEY `ACT_FK_SUSPENDED_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
                                        CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                        CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                        CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                        CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_suspended_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
                               `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                               `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                               `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行实例ID',
                               `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例ID',
                               `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程定义ID',
                               `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '节点定义名称',
                               `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '父节点实例ID',
                               `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '节点定义描述',
                               `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '任务定义的ID',
                               `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '拥有者（一般情况下为空，只有在委托时才有值）',
                               `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '签收人或委托人',
                               `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '委托类型，DelegationState分为两种：PENDING，RESOLVED。如无委托则为空',
                               `PRIORITY_` int(11) DEFAULT NULL COMMENT '优先级别，默认为：50',
                               `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL COMMENT '创建时间',
                               `DUE_DATE_` datetime(3) DEFAULT NULL COMMENT '耗时',
                               `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `SUSPENSION_STATE_` int(11) DEFAULT NULL COMMENT '1代表激活 2代表挂起',
                               `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                               `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `CLAIM_TIME_` datetime(3) DEFAULT NULL,
                               `APP_VERSION_` int(11) DEFAULT NULL,
                               PRIMARY KEY (`ID_`),
                               KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
                               KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
                               KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
                               KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
                               CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                               CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
                               CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运行时任务数据表，执行中实时任务';

/*Data for the table `act_ru_task` */

/*Table structure for table `act_ru_timer_job` */

DROP TABLE IF EXISTS `act_ru_timer_job`;

CREATE TABLE `act_ru_timer_job` (
                                    `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                    `REV_` int(11) DEFAULT NULL,
                                    `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                    `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
                                    `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
                                    `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `RETRIES_` int(11) DEFAULT NULL,
                                    `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                    `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
                                    `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                    `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                    PRIMARY KEY (`ID_`),
                                    KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
                                    KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
                                    KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
                                    KEY `ACT_FK_TIMER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
                                    CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                    CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                    CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                    CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_timer_job` */

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
                                   `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `REV_` int(11) DEFAULT NULL COMMENT '版本号',
                                   `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '编码类型',
                                   `NAME_` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '变量名称',
                                   `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行实例ID',
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '流程实例Id',
                                   `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '任务id',
                                   `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '字节表的ID（ACT_GE_BYTEARRAY）',
                                   `DOUBLE_` double DEFAULT NULL,
                                   `LONG_` bigint(20) DEFAULT NULL,
                                   `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                   `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                   PRIMARY KEY (`ID_`),
                                   KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
                                   KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
                                   KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
                                   KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
                                   CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                                   CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                   CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运行时流程变量数据表';

/*Data for the table `act_ru_variable` */

/*Table structure for table `workflow_bpmn_model` */

DROP TABLE IF EXISTS `workflow_bpmn_model`;

CREATE TABLE `workflow_bpmn_model` (
                                       `model_id` bigint(18) unsigned NOT NULL COMMENT '模型id，主键',
                                       `model_name` varchar(100) NOT NULL COMMENT '模型名称',
                                       `activiti_model_id` varchar(64) NOT NULL COMMENT 'act_re_model的主键id',
                                       `bpmn_imgae` varchar(150) NOT NULL COMMENT 'bpmn流程图路径',
                                       `bpmn_xml` varchar(150) NOT NULL COMMENT 'bpmn模板路径',
                                       `create_user_id` bigint(18) NOT NULL COMMENT '创建人',
                                       `create_time` datetime NOT NULL COMMENT '创建时间',
                                       PRIMARY KEY (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workflow_bpmn_model` */

/*Table structure for table `workflow_permission` */

DROP TABLE IF EXISTS `workflow_permission`;

CREATE TABLE `workflow_permission` (
                                       `permission_id` bigint(18) unsigned NOT NULL COMMENT '权限id',
                                       `permission_name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名称',
                                       `resource_type` varchar(10) NOT NULL DEFAULT 'menu' COMMENT '资源类型，[menu|button]',
                                       `permission` varchar(30) NOT NULL DEFAULT '' COMMENT '权限字符串',
                                       `parent_id` bigint(18) NOT NULL COMMENT '父菜单id',
                                       PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workflow_permission` */

/*Table structure for table `workflow_role` */

DROP TABLE IF EXISTS `workflow_role`;

CREATE TABLE `workflow_role` (
                                 `role_id` bigint(18) unsigned NOT NULL,
                                 `role_code` varchar(10) NOT NULL DEFAULT '',
                                 `role_name` varchar(10) NOT NULL DEFAULT '',
                                 PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workflow_role` */

/*Table structure for table `workflow_user` */

DROP TABLE IF EXISTS `workflow_user`;

CREATE TABLE `workflow_user` (
                                 `id` bigint(18) unsigned NOT NULL,
                                 `username` varchar(255) NOT NULL,
                                 `password` varchar(255) NOT NULL,
                                 `email` varchar(255) NOT NULL,
                                 `role_code` varchar(255) NOT NULL,
                                 `role_name` varchar(255) NOT NULL,
                                 `create_user_id` bigint(18) NOT NULL,
                                 `create_time` datetime NOT NULL,
                                 `modify_time` datetime NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workflow_user` */

insert  into `workflow_user`(`id`,`username`,`password`,`email`,`role_code`,`role_name`,`create_user_id`,`create_time`,`modify_time`) values (1,'admin','23f90100463d27633c61a711a8bf8ea5072710952454d509','345849402@qq.com','admin','管理员',1,'2019-03-21 14:30:57','2019-03-21 14:30:57'),(2,'yuyb','23f90100463d27633c61a711a8bf8ea5072710952454d509','1111','user','普通用户',1,'2020-03-12 15:59:50','2020-03-12 15:59:52');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
