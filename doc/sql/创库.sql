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
                                    `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                    `REV_` int(11) DEFAULT NULL,
                                    `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `BYTES_` longblob,
                                    `GENERATED_` tinyint(4) DEFAULT NULL,
                                    PRIMARY KEY (`ID_`),
                                    KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
                                    CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
                                   `NAME_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
                                   `REV_` int(11) DEFAULT NULL,
                                   PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values ('cfg.execution-related-entities-count','false',1),('next.dbid','1',1),('schema.history','create(7.1.0-M6)',1),('schema.version','7.1.0-M6',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `START_TIME_` datetime(3) NOT NULL,
                                  `END_TIME_` datetime(3) DEFAULT NULL,
                                  `DURATION_` bigint(20) DEFAULT NULL,
                                  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
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
                                     `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                     `REV_` int(11) DEFAULT NULL,
                                     `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                     `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                     `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                     `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                     `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                     `TIME_` datetime(3) DEFAULT NULL,
                                     PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `TIME_` datetime(3) NOT NULL,
                                  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `FULL_MSG_` longblob,
                                  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
                                 `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                 `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                 `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                 `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                 `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                 `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                 `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
                                 `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                 `REV_` int(11) DEFAULT NULL,
                                 `TIME_` datetime(3) NOT NULL,
                                 `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                 `DOUBLE_` double DEFAULT NULL,
                                 `LONG_` bigint(20) DEFAULT NULL,
                                 `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                 `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
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
                                       `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                       `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
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
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `START_TIME_` datetime(3) NOT NULL,
                                   `END_TIME_` datetime(3) DEFAULT NULL,
                                   `DURATION_` bigint(20) DEFAULT NULL,
                                   `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
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
                                   `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                   `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                   `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                   `START_TIME_` datetime(3) NOT NULL,
                                   `CLAIM_TIME_` datetime(3) DEFAULT NULL,
                                   `END_TIME_` datetime(3) DEFAULT NULL,
                                   `DURATION_` bigint(20) DEFAULT NULL,
                                   `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                   `PRIORITY_` int(11) DEFAULT NULL,
                                   `DUE_DATE_` datetime(3) DEFAULT NULL,
                                   `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
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
                                  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
                                  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
                                  `REV_` int(11) DEFAULT NULL,
                                  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `DOUBLE_` double DEFAULT NULL,
                                  `LONG_` bigint(20) DEFAULT NULL,
                                  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `CREATE_TIME_` datetime(3) DEFAULT NULL,
                                  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
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
                                     `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                     `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                     `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
                                     `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     `VERSION_` int(11) DEFAULT '1',
                                     `PROJECT_RELEASE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                     PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

insert  into `act_re_deployment`(`ID_`,`NAME_`,`CATEGORY_`,`KEY_`,`TENANT_ID_`,`DEPLOY_TIME_`,`ENGINE_VERSION_`,`VERSION_`,`PROJECT_RELEASE_VERSION_`) values ('0a2567c6-636d-11ea-bc97-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:50:56.092',NULL,7,NULL),('1883d385-6374-11ea-afaa-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 16:41:26.684',NULL,8,NULL),('35c015ce-636c-11ea-bea3-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:44:59.755',NULL,4,NULL),('450cdd2f-636c-11ea-82b4-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:45:25.428',NULL,5,NULL),('45d83839-636b-11ea-a639-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:38:17.232',NULL,1,NULL),('a751e015-636c-11ea-bc97-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:48:10.297',NULL,6,NULL),('babe37cf-636b-11ea-88a4-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:41:33.385',NULL,2,NULL),('d40c07dd-636b-11ea-bea3-18dbf2291890','SpringAutoDeployment',NULL,NULL,'','2020-03-11 15:42:15.840',NULL,3,NULL);

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
                                `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                `REV_` int(11) DEFAULT NULL,
                                `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
                                `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
                                `VERSION_` int(11) DEFAULT NULL,
                                `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
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
                                  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                  `REV_` int(11) DEFAULT NULL,
                                  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
                                  `VERSION_` int(11) NOT NULL,
                                  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                                  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
                                  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
                                  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
                                  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
                                  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                  `APP_VERSION_` int(11) DEFAULT NULL,
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
                                       `REV_` int(11) DEFAULT NULL,
                                       `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                       `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
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
                                    `REV_` int(11) DEFAULT NULL,
                                    `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                    `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                    `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
                                    `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
                                    `IS_SCOPE_` tinyint(4) DEFAULT NULL,
                                    `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
                                    `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
                                    `SUSPENSION_STATE_` int(11) DEFAULT NULL,
                                    `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
                                       `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
                                       `REV_` int(11) DEFAULT NULL,
                                       `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                                       `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                       PRIMARY KEY (`ID_`),
                                       KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
                                       KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
                                       KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
                                       KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
                                       KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
                                       CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
                                       CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                                       CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
                              KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
                              KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
                              KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
                              KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
                              CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
                              CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
                               `REV_` int(11) DEFAULT NULL,
                               `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
                               `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                               `PRIORITY_` int(11) DEFAULT NULL,
                               `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
                               `DUE_DATE_` datetime(3) DEFAULT NULL,
                               `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                               `SUSPENSION_STATE_` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
                                   `REV_` int(11) DEFAULT NULL,
                                   `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
                                   `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
                                   `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
                                   `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

/*Table structure for table `bpmn_model` */

DROP TABLE IF EXISTS `bpmn_model`;

CREATE TABLE `bpmn_model` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `bpmn_imgae` text,
                              `bpmn_xml` text,
                              `gmt_create` datetime DEFAULT NULL,
                              `gmt_update` datetime DEFAULT NULL,
                              `model_key` varchar(255) DEFAULT NULL,
                              `model_name` varchar(255) DEFAULT NULL,
                              `user_create` int(11) DEFAULT NULL,
                              `username` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `bpmn_model` */

insert  into `bpmn_model`(`id`,`bpmn_imgae`,`bpmn_xml`,`gmt_create`,`gmt_update`,`model_key`,`model_name`,`user_create`,`username`) values (1,'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABOsAAAJYCAYAAAAzEmKlAAAgAElEQVR4Xu3dC5CddZkn4Ldzv3IZLhHUDCCBQVMj6CgRBFZIKFASwPFG4W3dUUEJsisCqyAwDHLzSlgBZ5hZGKtWxYkGBOUyAkOErOI6okEGCPcFVggIuXeS7q2P6rba0JA+6dPnvOf7P6cqFSXnfN/7Pe+vutO/nEtXuBEgQIAAAQIECBAgQIAAAQIECBAgkEKgK8UUhiBAgAABAgQIECBAgAABAgQIECBAIJR1QkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAAECBAgQIECAAAECBAgQIEAgiYCyLskijEGAAAECBAgQIECAAAECBAgQIEBAWScDBAgQIECAAAECBAgQIECAAAECBJIIKOuSLMIYBAgQIECAAAECBAgQIECAAAECBJR1MkCAAIF8AtMj4siIODgiZkTELhExOd+YHTXRCxHxWETcGxG3RcSiiHi0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vANKlaFqyNVQpVpwvxrl6v8O/JCJSy+9dO1xxx3X0pfCXnbZZWOPP/74gS+BfXLgTC1Yp1MQIECAAAECBFoioKxrCbOTEKiFQPXppV87+uijNyxcuLAtL3866qijJi5atKh6+VM1yzdqoKpUSbTEGpUqciVXIyFwaUQc13/gadOm9T766KMrx40bNxLneskx165dG9OnT5/y9NNPD/y76yURMb8lAzgJAQIECBAgQKCFAsq6FmI7FYEOF6h+InsgIl57ww03rD700ENb+uy6Ac+qezwidut7mWmHk4ZSJdEGlXWJllGjUWqUq+qtB34bEX/8u+MFF1yw7pRTTvmT16SO1OrOO++8cZ///OcHvu62+h70F33fl0bqtI5LgAABAgQIEGiLgLKuLexOSqBjBf4mIv7+ta99be+vfvWrldttt11LLmT58uWx9957T3n88cerr1n/JSL+sSUnHvmTKOtG3njIZ6hRqSJXQ976yN+xRrmqsP7k2XXVe9ctXrx41d57790zkpK//OUvRx100EGT+96vtP9U34yIT4/keR2bAAECBAgQINAuAWVdu+Sdl0BnCoyOiPuqZ7a9/e1v33jrrbeuHj26+k8jd6s+VOLAAw+cdMcdd1Qn+o++D5YY0R8MR+5qXnJkpUoLsTd3qhqVKnK1uWW38M9rlKtKbduIeCQipvYTVi+H/cUvfrGq+keckWB95JFHut70pjdNfvbZZwf+nXVF3/uWPjcS53RMAgQIECBAgEC7BZR17d6A8xPoPIG/6vuU04knnHBC94IFC9aN5CVUbyZeval4RKyNiP0j4v+M5PlafGylSovBX+l0NSpV5EquRlLg3RHxLwNPsPvuu/dUb4+w2267NbWwe/DBB7uqDxV68MEHR21yQUdHxA9H8iIdmwABAgQIECDQTgFlXTv1nZtA5wocERHXVO9dNH/+/O6vf/3r60aN2vRnqeFdXPWMupNOOmn8JZdcUr1XXvVMurkRcf3wjpru0UqVRCtR1iVaRo1GqVGuBm7lwoj43MD/sO2228Y111yzunrWdTPW99Of/nT0e97znknPPfeSJ89dEBGnNeMcjkGAAAECBAgQyCqgrMu6GXMRyC/wyYio3jNo1MEHH7xx4cKFq7feeuumTP3888/H3LlzJ91+++3VS1+rou4TEXFFUw6e6yDKukT7qFGpIldyNdIC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s0/XzuPJVQv1C8pVC1WdigABAgQIECBQpoCyrsy9u2oCBPIJvCYibo6IPavRZs6c2TNnzpwNs2bN2njQQQdtnDZtWm++kTtnoscee6zrzjvvHL1kyZLRN9xww5h77rmnvwldGhGzI+KpzrmahiaVq4a4GrtzwblqDMq9CRAgQIAAAQIEGhJQ1jXE5c4ECBAYUYHqgwHOjohPRUT1Mka3kRPojohLI+KLNfhAic0pydXmhJr35yXlqnlqjkSAAAECBAgQIPAnAso6gSBAgEA+gekRcWREHBwRMyJil4iYnG/Mjpqo+oTXxyLi3oi4LSJ+2Pf/O+oihjmsXA0TcJCHy1XzTR2RAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECbfyr7gAAETlJREFUBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQso64qPAAACBAgQIECAAAECBAgQIECAAIEsAsq6LJswBwECBAgQIECAAAECBAgQIECAQPECyrriIwCAAAECBAgQIECAAAECBAgQIEAgi4CyLssmzEGAAAECBAgQIECAAAECBAgQIFC8gLKu+AgAIECAAAECBAgQIECAAAECBAgQyCKgrMuyCXMQIECAAAECBAgQIECAAAECBAgUL6CsKz4CAAgQIECAAAECBAgQIECAAAECBLIIKOuybMIcBAgQIECAAAECBAgQIECAAAECxQv8f05eYNH6ALHaAAAAAElFTkSuQmCC','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn2:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"sample-diagram\" targetNamespace=\"http://bpmn.io/schema/bpmn\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">\n  <bpmn2:process id=\"Process_1\">\n    <bpmn2:startEvent id=\"StartEvent_1\">\n      <bpmn2:outgoing>SequenceFlow_1xkya5m</bpmn2:outgoing>\n    </bpmn2:startEvent>\n    <bpmn2:task id=\"Task_0w2dcps\">\n      <bpmn2:incoming>SequenceFlow_1xkya5m</bpmn2:incoming>\n      <bpmn2:outgoing>SequenceFlow_1e57k8u</bpmn2:outgoing>\n    </bpmn2:task>\n    <bpmn2:sequenceFlow id=\"SequenceFlow_1xkya5m\" sourceRef=\"StartEvent_1\" targetRef=\"Task_0w2dcps\" />\n    <bpmn2:task id=\"Task_1yapgfz\">\n      <bpmn2:incoming>SequenceFlow_1e57k8u</bpmn2:incoming>\n      <bpmn2:outgoing>SequenceFlow_01bdttu</bpmn2:outgoing>\n    </bpmn2:task>\n    <bpmn2:sequenceFlow id=\"SequenceFlow_1e57k8u\" sourceRef=\"Task_0w2dcps\" targetRef=\"Task_1yapgfz\" />\n    <bpmn2:endEvent id=\"EndEvent_005n2ra\">\n      <bpmn2:incoming>SequenceFlow_01bdttu</bpmn2:incoming>\n    </bpmn2:endEvent>\n    <bpmn2:sequenceFlow id=\"SequenceFlow_01bdttu\" sourceRef=\"Task_1yapgfz\" targetRef=\"EndEvent_005n2ra\" />\n  </bpmn2:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_1\">\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\">\n        <dc:Bounds x=\"267\" y=\"233\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Task_0w2dcps_di\" bpmnElement=\"Task_0w2dcps\">\n        <dc:Bounds x=\"353\" y=\"211\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge id=\"SequenceFlow_1xkya5m_di\" bpmnElement=\"SequenceFlow_1xkya5m\">\n        <di:waypoint x=\"303\" y=\"251\" />\n        <di:waypoint x=\"353\" y=\"251\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"Task_1yapgfz_di\" bpmnElement=\"Task_1yapgfz\">\n        <dc:Bounds x=\"503\" y=\"211\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge id=\"SequenceFlow_1e57k8u_di\" bpmnElement=\"SequenceFlow_1e57k8u\">\n        <di:waypoint x=\"453\" y=\"251\" />\n        <di:waypoint x=\"503\" y=\"251\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"EndEvent_005n2ra_di\" bpmnElement=\"EndEvent_005n2ra\">\n        <dc:Bounds x=\"653\" y=\"233\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge id=\"SequenceFlow_01bdttu_di\" bpmnElement=\"SequenceFlow_01bdttu\">\n        <di:waypoint x=\"603\" y=\"251\" />\n        <di:waypoint x=\"653\" y=\"251\" />\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn2:definitions>\n','2019-05-25 10:49:56','2019-05-25 10:49:56','哈哈哈哈或','哈哈哈哈或',1,'admin'),(2,'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABnwAAAJYCAYAAABICUj0AAAgAElEQVR4Xuzdf4xW9Z0v8M8ww4CCMhCkWu8S0wVtbdbehhCR5Sa7BmsEBY3avX9Q0IoCupst6KobFbuorZoF3GwVCLoV6x/bGqNQwWgge+/GClvUJjShXbWJ616rq1QGFOXHDHNz2JmWUmBmmOeZ8fv9vp7EmDjnOef7eb2/Zezz9pynIbwIECBAgAABAgQIECBAgAABAgQIECBAgAABAgSSFmhIevUWT4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgEAofm4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgAABAgQIECBAgAABAgQIECCQuIDCJ/EALZ8AAQIECBAgQIAAAQIECBAgQIAAAQIECBAgoPCxBwgQIECAAAECBAgQIECAAAECBAgQIECAAAECiQsofBIP0PIJECBAgAABAgQIECBAgAABAgQIECBAgAABAgofe4AAAQIECBAgQIAAAQIECBAgQIAAAQIECBAgkLiAwifxAC2fAAECBAgQIECAAAECBAgQIECAAAECBAgQIKDwsQcIECBAgAABAgQIECBAgAABAgQIECBAgAABAokLKHwSD9DyCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQIKH3uAAAECBAgQIECAAAECBAgQIECAAAECBAgQIJC4gMIn8QAtnwABAgQIECBAgAABAgQIECBAgAABAgQIECCg8LEHCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAAQKJCyh8Eg/Q8gkQIECAAAECBAgQIECAAAECBAgQIECAAAECCh97gAABAgQIECBAgACBSuBLETEtIs6PiDMi4vTOv1c/ezci3uv8+79FxIaI+AU2AgQIECBAgAABAgQIEPjsCCh8PjtZWAkBAgQI/L7A2M4PHv+8mw8e/6Xzg8e3ARLoB4GvRsQ5EfH5iDil83ofRcSvI+LfI+Jn/bAGlyBQS4Gq1PnriJgeEX/SyxP/PCLWR8Q/dJZBvXy7wwkQIECAAAECBAgQIECglgIKn1pqOhcBAgQI1EJgYUR8PSIm9fJkWyLiRxGxvJfvcziB7gT+96hRo76xZ8+ePxs9evSBiRMnDhs7duzBU0899dD7du/eHW+//fagrVu37tmxY8fgYcOG/d8PP/zwiYj45+5O7OcEBlDgpIi4LSJuj4ghfVzHvoi4PyIeiIhP+3gubydAgAABAgQIECBAgACBExRQ+JwgnLcRIECAQM0Fvtn5weP46sxDhgyJiy++uG369Olt48aNO3jGGWd0VH9VP3v33Xcbqr/efPPNQevXr2964YUXmvbtqz5vPPR6o/ODx3+q+QqdsDSBm4cPH377ueeeO+j6668/eebMmW2nnXbaoT14rNcHH3zQsHbt2qbVq1fv2b59e8fHH39cfQi+tDQ4837mBb4REX8fEWNqvNL3I+KWiPhBjc/rdAQIECBAgAABAgQIECDQAwGFTw+QHECevisAACAASURBVEKAAAECdRX444io7oaYXF1lwoQJ7bfffvv+K664oq2xsbFHF25vb49nnnmm6f77729+9dVXu970ckTMjohf9egkDiLwO4FpLS0tD0+ZMmXM4sWLY+LEie1dP3rjjTcGbdu2bdBbb701qLW19dA/bmlpibPOOuvgeeedd3D8+PEHu47dunVr45IlS+Kll176oLW19abOR19xJjDQAt+OiLuPtYipU6e2TZs2rf28885rP1rRvm3btsYNGzY0bty4sek4gyw53jUGGsD1CRAgQIAAAQIECBAgkKuAwifXZM1FgACBNAS+1ln2fK66i+e2227bP3fu3AN9Wfqjjz46+IEHHmiu7v6JiP/qLH1e7Ms5vbcogbtHjBjxN6tXrx509dVXt1WTV3tpzZo1g5999tmm9957r6EqJb/whS8cHDVqVDQ0NMTOnTsPHVOVjaeffnrH5ZdffmD27NltXeXPU0891XT99dcf3LVrV3VHRfVhuxeBgRKo7ryZdeTFx4wZ03Hrrbfuv+666w60tLQc9y62rve2trY2PPbYY4MffPDB5vfff/9o/5/iyYio7iTyIkCAAAECBAgQIECAAIF+ElD49BO0yxAgQIDAHwjMj4gV1T+dMWNG25NPPrn3lFNO6dEHjd1ZfvTRRw2zZs0aum7duq7/An1BRKzs7n1+XrbAqaee+uS555576bp16xqrR7ft2LGjYcmSJc0rVqxonjdv3v5Zs2a1TZo06bd3+xxNa8uWLY1PPPFE9Ui35gULFuxfvHjx/tGjR3dUj3qbMWNG+/bt25/bvXv3H3zgXra86ftJ4Khlz5133rnvzjvv3F89RvNEXtXjNO+7777me+6552gnUPqcCKr3ECBAgAABAgQIECBA4AQFFD4nCOdtBAgQINAngerOnheqMyxcuHD/smXLfvsFPH066xFvXrRo0ZDly5c3d/7jiyPCnT61BM7oXFXZc/7551/y4osvDq7Gevrpp5sWLlw45NJLL22777779o8cObJXZWR198Odd97ZXH2fz0MPPbTvyiuvPHS30Ne+9rUDW7du3dDa2urOh4z2TwKj/F1ELD58ndVdPY8//vjeSy655NDe7Ovr+eefb7rmmmuGHuVun+ra7mzrK7D3EyBAgAABAgQIECBAoAcCCp8eIDmEAAECBGoqUH1nz08i4nP1LHu6VnxY6VM93u1PfadPTbPM5WR3T5o0aeHmzZurxwDGsmXLmr/zne80Vx+GV4VPX4Z87rnnmq699tqh1fdS3Xzzzfurc11wwQUHt2zZsjwiqg/CvQjUW6AqF6vvSfvt64ILLmhfs2bN3sO/c6oWi6i+42rOnDlDN2/efOQXsFXfp1bdYeRFgAABAgQIECBAgAABAnUUUPjUEdepCRAgQOCoAlXZM7l6jNvatWs/7Q+jmTNnntT5eLeXO0uf/risa6QhMH3EiBE/fOONNzqqx7gtXbq0eoTb4A0bNnx69tlnH6zFCNWH4NOmTTtpwYIFBxYtWrS/ugPi7LPPbti1a9fXI2JDLa7hHASOIXBSRLwVEWO6fl7d2fPSSy99Uuuyp+v81X6fMmXKyUfc6fN+RJwVEf3yZ77dQIAAAQIECBAgQIAAgVIFFD6lJm9uAgQIDIzANyPisXHjxh187bXXPqnVd/Z0N8rOnTsbzjnnnGHV96hExM6IGNn5nnci4mcRsb5aV0Qc6O5cfv6ZEKgeu3ZdREyPiK9GxJnd5HnM45uamkbOmTNn8MqVK/dWj1+bP3/+0JdffrnmH4ZXH4JPnjz55Oo6M2fObKuus2bNmgNtbW3Vfuxu/Z8JdIvod4Fa7fPfW3hVZtbqMW7HEqke71aVnEf83KPd+n0LuSABAgQIECBAgAABAqUJKHxKS9y8BAgQGFiB1yNi/OrVq/fOnTu3X8qVVatWDV68ePGQo3yvxJES1SPf7oyIRweWyNW7EZgbEfdWjwTs5riuPKvDuj1+9OjRHQcPHozqMVd9fYzbsdZVPd5t9uzZQxsbG2PHjh3d/TuY/Vj2/xTqss+HDRtW3cW2b968eXX/8/euu+5qvvfee4ccFmP1XW3VXT7vlR2t6QkQIECAAAECBAgQIFA/ge4+bKjflZ2ZAAECBEoTWFh9PcqECRPaX3nllU/6Y/gFCxYMXblyZfVfyffm9b2I+KvevMGx/SbwjxHxl/W82vz58w+sWLFibz2uYT/WQzXLcya9z7sS2bdvX4wdO3b4EWX7/RHxt1mmZigCBAgQIECAAAECBAh8BgQUPp+BECyBAAEChQhsjohJTz311KdXXXVVW71nPsEP17uWpfSpd0C9P3/dPwTvWlI9Sh/7sfeBF/qOpPf5kZlV34l1yy23HH6Xz88j4rxCszU2AQIECBAgQIAAAQIE6i6g8Kk7sQsQIECAQESMjYj/GDJkSOzZs+ej6pFW9XxVj3GrviOlj9e43uPd+ihYu7dXj7daXbvTdX+m6rt2avXYK/uxe29HHBJIep8fLcPW1taGkSNHDj/iZ+dGxC9kToAAAQIECBAgQIAAAQK1F1D41N7UGQkQIEDgDwXmR8SKGTNmtK1du/bTegK1tbXFmWeeeeRjhE7kktV3qPxRRNT9uy5OZHHHeM/JEXFrDc9XnerBiOiXR/AdY93VI/n+swff2VPTsceMGdPxzjvvfNzU1NSn8xa+H3tjl+Pe7c38Se/z4w160UUXnbRx48bD/4d0S0Qs7Q2OYwkQIECAAAECBAgQIECgZwIKn545OYoAAQIE+ibww4j4+qpVq/becMMNdS1QHnnkkcE33XRTX+/u6Zp2QUSs7Nvo/f7ujhpfcaD/XeFQWVjjmXp0uocffnjvjTfe2Kf9aj/2iLrroNz2bm+GT3qfH2/Q5cuXNy9atOjwx7o9Vf0+6A2OYwkQIECAAAECBAgQIECgZwID/SFOz1bpKAIECBBIXeBfI+J/bdq06ZMLL7ywvZ7DTJ8+/aQNGzb07baM3y3wuYi4rJ7rrcO5c/vQ/McRcWkdnLo95bRp09rWr1/fpzvS7MdumQ8/ILe925vhk97nxxt006ZNjVOnTq3u4Op6vVT9PugNjmMJECBAgAABAgQIECBAoGcCCp+eOTmKAAECBPom8HpEjN++ffueL33pSwf7dqrjv/vzn//88HfffbdWv9/eiYj/Uc/11uHcuX1o/v8i4sw6OHV7yjPOOKPj17/+9cfdHnicA+zHXunltnd7M3zS+/x4g27fvn3Ql7/85WGHHfNm9fugNziOJUCAAAECBAgQIECAAIGeCdTqA7GeXc1RBAgQIFCqwEcRMXznzp0ft7S01PpD3d8zbWhoOKVUZHPXXqCjo6Pauyf8sh9PmM4b+1Ggr/v8eEvduXNnw6hRo4Yfdsye6vdBP47nUgQIECBAgAABAgQIEChGQOFTTNQGJUCAwIAKKHwGlN/FT1Sgrx+EK3xOVN77+lOgr/tc4dOfabkWAQIECBAgQIAAAQIEji2g8LE7CBAgQKA/BDzSrT+U//satb6DaqD/XSHpR115pFuvNn5ue7c3wye9z483qEe69WYbOJYAAQIECBAgQIAAAQJ9ExjoD3H6tnrvJkCAAIFUBP61+pLuTZs2fXLhhRe213PR06dPP2nDhg1NNbrGcxFxWY3O1V+nye1D86S/zN5+7NW2z23v9mb4pPf58QbdtGlT49SpU08+7JiXqt8HvcFxLAECBAgQIECAAAECBAj0TEDh0zMnRxEgQIBA3wR+GBFfX7Vq1d4bbrjhQN9Odfx3P/LII4NvuummoTW6xoKIWFmjc/XXaXL70Hx+RKzoL7zDr/Pwww/vvfHGG/u0X+3HXiWX297tzfBJ7/PjDbp8+fLmRYsWDTnsmKeq3we9wXEsAQIECBAgQIAAAQIECPRMQOHTMydHESBAgEDfBA59mDljxoy2tWvXftq3Ux3/3W1tbXHmmWcOf//99/v6O+6/IuKPIqJPH/jXc9ZjnPvbNb5mrc/X2+UNjoj/jIjP9faNfTl+zJgxHe+8887HTU19u1nMfuxVCrXea7U+X6+G6eXBSe/z48160UUXnbRx48bD/4d0S0Qs7aWPwwkQIECAAAECBAgQIECgBwJ9/TCsB5dwCAECBAgQiLER8R9DhgyJPXv2fNTY2FhXklWrVg2eP39+X+/yuT4iHq3rQp28pwJzI2J1Tw+uxXErV67cO2/evJqUffZjLRIp4hxJ7/OjJdTa2towcuTI4Uf87NyI+EURiRqSAAECBAgQIECAAAEC/Syg8OlncJcjQIBAwQKbI2LSU0899elVV13VVm+HBQsWDF25cmX1X82fyOt7EfFXJ/JG76mbwD9GxF/W7eyHnXj+/PkHVqxYsbeW17Ifa6mZ9bmS3udHJrN06dLmW2655fDHuf08Is7LOkHDESBAgAABAgQIECBAYAAFFD4DiO/SBAgQKExgYUQsmzBhQvsrr7zySX/MfoIfsit7+iOcE7tG3T8Mr0fZ0zWq/XhioRf4rqT3eVde+/bti7Fjxx75eM37I+JvC8zUyAQIECBAgAABAgQIEOgXAYVPvzC7CAECBAh0CrweEeNXr169d+7cuTV5XFZ3stXjtBYvXjykB9/pU31nz50e49ad6ID/vHrs1b09+E6frjyrBXd7/OjRozva29vjiSee2HvppZfW5Q605557rmn27NlDq0ca7tixo7t/B7MfB3yrDegC6rLPhw0b1rF06dJ9tXpc4fGEFi9e3HzPPfccfnfPvog4KyLeG1BZFydAgAABAgQIECBAgEDGAt192JDx6EYjQIAAgQEQ+GZEPDZu3LiDr7322iennHJKR3+sYefOnQ3nnHPOsA8++KD6vbczIkZ2XvediPhZRKyv1hUR/VJC9cfMmV+jelTfdRExPSK+GhFndpPnMY9vamoaOWfOnMHVd/asXbu2qfrup5dffvmT8ePHH6yl4RtvvDFo8uTJJ1fXmTlzZlt1nTVr1rS1tbV92IP113IpzpWOQK32+e9NvGHDhk8vueSSupSaXRd6/vnnm6ZNm3bSEdR/FxHfToffSgkQIECAAAECBAgQIJCegMInvcysmAABAqkL/CQiJs+YMaNt7dq1n/bHMDNnzjxp3bp1TRHxckT8aX9c0zWSEZg2YsSIH73++usdY8aM6Vi2bFnzihUrBlcfiteq9KnKnurD7wULFhxYtGjR/qp4HD9+fMOuXbv+orNsTAbLQpMTqEqXtyJiTNfKq33+0ksv1bzU7Dp/td+nTJly8hF3Vb7feXdPv/yZn1xKFkyAAAECBAgQIECAAIEaCSh8agTpNAQIECDQY4E/joiq9PncwoUL9y9btqx6zE/dXosWLRqyfPny5oioHpFVlT2/qtvFnDhVgbsnTZq0cPPmzYOqAarS57vf/W7z97///T4/3q16jNu111479Pbbb99/880376/OP3ny5IObN29+yN0OqW6X5Nb9jYh44vBVX3DBBe1r1qzZW6tSs+vcVdkzZ86coZs3b248Qml2RPwgOTkLJkCAAAECBAgQIECAQGICCp/EArNcAgQIZCLwtYh4oZqlnqXPYWVPdamLI+LFTPyMUWOBlpaWH0ycOHHaiy++WD1GK55++ummb33rW0Muu+yytvvuu2//yJEje/X4weoxgnfccUfzj3/846aHHnpo35VXXnnoEVoXX3zxgS1btjy/e/fuWTUewekIHE+gepTa3YcfUN3p8/jjj++t1ePdqse4XXPNNUOP8n1pS468tqgIECBAgAABAgQIECBAoD4CCp/6uDorAQIECHQvMD8iVlSHVY93e/LJJ/fW6jt9Pvroo4ZZs2YN7XyMW3WJBRGxsvslOaJkgZaWlie/+MUvXrpu3brG0047rWPHjh0NS5YsqR7x1jxv3rz9s2bNaps0aVL78Yy2bNnS+MQTTzStXr26ecGCBfsXL168f/To0R3Vh+AzZ85s/+Uvf/nj1tbW6o4LLwL9LVDdYfMHReNdd92174477tg/ZMiQE1rPvn374t57722+9957j3aCJyPCfj8hWW8iQIAAAQIECBAgQIBA7wUUPr038w4CBAgQqJ1AdadP9aihz40bN+7gbbfdtn/u3LkH+nL6Rx99dPADDzzQ/Oabb1aP56oe41Y9SsidPX1BLeu9d48YMeJvVq9ePejqq68+dFdOtZfWrFkz+Nlnn2167733GiZMmNBe7deRI0cekvnNb34Tv/rVrwa99tprjaeffnrHFVdccWD27Nlt1THVz3/0ox813XDDDR27du16MCKqL673IjBQAkctfaq7fW699db911133YGWlpYe3c3W2tra8Nhjjw1+8MEHm49yV081n7JnoFJ2XQIECBAgQIAAAQIEihVQ+BQbvcEJECDwmRGovtOnKn0mVyuqPkyvvu/kiiuuaGtsPPJrII6+5vb29njmmWea7r///uZXX321600vd5Y9vrPnMxN1MguZ3tLS8r0pU6aMWbx4cUycOPG3d/VU31Gybdu2QW+99dag1tbWQwO1tLTEWWeddfArX/nKwa6Sp/rnP/3pTxuXLFkSP/nJT95vbW29KSI2JCNgoTkLVKXj4mMNOHXq1LZp06a1n3feee1nnHFGR/VXdey7777bUP21bdu2xg0bNjRu3Lix6ThI1TWqx8h5ESBAgAABAgQIECBAgEA/Cih8+hHbpQgQIEDguALfjIjbI2J8dVT1eKGLL764bfr06YfulDjaB4/VnRfr169veuGFF5qqxwp1vt6IiPsj4p94E+ijwM3Dhw+//dxzzx00d+7cky+//PK26lFvxzvnBx980LB27drqkW57tm/ffvDjjz+u9uKyPq7D2wnUWqB6zNrfR8SYGp/4/Yi4JSKqO4m8CBAgQIAAAQIECBAgQKCfBRQ+/QzucgQIECDQrcDCiPh6REzq9sjfP2BL9fSsiFjey/c5nEB3An8xatSo2Xv27PmzUaNGHTj//POHjR079uCpp5566H27d++Ot99+e9DWrVv37NixY/CwYcP+z4cfflh94P3P3Z3YzwkMoMBJEXFbZ9F+Yl/g87vFV417VW4+EBGfDuBMLk2AAAECBAgQIECAAIGiBRQ+RcdveAIECHymBcZGxLSI+POIOCMiTu/8e7XodyPivc6//0vno7Le/kxPY3G5CPzPiPhiRHw+Iv678YnYHRG/joh/j4if5TKoOYoRqP5s/euImB4Rf9LLqX8eEesj4h86/0zu5dsdToAAAQIECBAgQIAAAQK1FFD41FLTuQgQIECAAAECBAikK/ClzqL9/G6K9n/rLNp/ke6oVk6AAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAAB7sj1GQAAHl1JREFUAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQKAwAYVPYYEblwABAgQIECBAgAABAgQIECBAgAABAgQIEMhPQOGTX6YmIkCAAAECBAgQIECAAAECBAgQIECAAAECBAoTUPgUFrhxCRAgQIAAAQIECBAgQIAAAQIECBAgQIAAgfwEFD75ZWoiAgQIECBAgAABAgQIECBAgAABAgQIECBAoDABhU9hgRuXAAECBAgQIECAAAECBAgQIECAAAECBAgQyE9A4ZNfpiYiQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEChNQ+BQWuHEJECBAgAABAgQIECBAgAABAgQIECBAgACB/AQUPvllaiICBAgQIECAAAECBAgQIECAAAECBAgQIECgMAGFT2GBG5cAAQIECBAgQIAAAQIECBAgQIAAAQIECBDIT0Dhk1+mJiJAgAABAgQIECBAgAABAgQIECBAgAABAgQKE1D4FBa4cQkQIECAAAECBAgQIECAAAECBAgQIECAAIH8BBQ++WVqIgIECBAgQIAAgf/fnh0TAAAAIAjr39oesgjOEwIECBAgQIAAAQIECBAgQCAmIPjEDjeXAAECBAgQIECAAAECBAgQIECAAAECBAgQ+BMQfP4+tYgAAQIECBAgQIAAAQIECBAgQIAAAQIECBCICQg+scPNJUCAAAECBAgQIECAAAECBAgQIECAAAECBP4EBJ+/Ty0iQIAAAQIECBAgQIAAAQIECBAgQIAAAQIEYgKCT+xwcwkQIECAAAECBAgQIECAAAECBAgQIECAAIE/AcHn71OLCBAgQIAAAQIECBAgQIAAAQIECBAgQIAAgZiA4BM73FwCBAgQIECAAAECBAgQIECAAAECBAgQIEDgT0Dw+fvUIgIECBAgQIAAAQIECBAgQIAAAQIECBAgQCAmIPjEDjeXAAECBAgQIECAAAECBAgQIECAAAECBAgQ+BMQfP4+tYgAAQIECBAgQIAAAQIECBAgQIAAAQIECBCICQg+scPNJUCAAAECBAgQIECAAAECBAgQIECAAAEC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','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn2:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"sample-diagram\" targetNamespace=\"http://bpmn.io/schema/bpmn\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">\n  <bpmn2:process id=\"Process_1\">\n    <bpmn2:startEvent id=\"StartEvent_1\">\n      <bpmn2:outgoing>SequenceFlow_1acdqji</bpmn2:outgoing>\n    </bpmn2:startEvent>\n    <bpmn2:intermediateThrowEvent id=\"IntermediateThrowEvent_181k755\">\n      <bpmn2:incoming>SequenceFlow_1acdqji</bpmn2:incoming>\n      <bpmn2:outgoing>SequenceFlow_0xa8adm</bpmn2:outgoing>\n    </bpmn2:intermediateThrowEvent>\n    <bpmn2:sequenceFlow id=\"SequenceFlow_1acdqji\" sourceRef=\"StartEvent_1\" targetRef=\"IntermediateThrowEvent_181k755\" />\n    <bpmn2:endEvent id=\"EndEvent_0jz0q46\">\n      <bpmn2:incoming>SequenceFlow_0xa8adm</bpmn2:incoming>\n    </bpmn2:endEvent>\n    <bpmn2:sequenceFlow id=\"SequenceFlow_0xa8adm\" sourceRef=\"IntermediateThrowEvent_181k755\" targetRef=\"EndEvent_0jz0q46\" />\n  </bpmn2:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_1\">\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\">\n        <dc:Bounds x=\"412\" y=\"240\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"IntermediateThrowEvent_181k755_di\" bpmnElement=\"IntermediateThrowEvent_181k755\">\n        <dc:Bounds x=\"576\" y=\"240\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge id=\"SequenceFlow_1acdqji_di\" bpmnElement=\"SequenceFlow_1acdqji\">\n        <di:waypoint x=\"448\" y=\"258\" />\n        <di:waypoint x=\"576\" y=\"258\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"EndEvent_0jz0q46_di\" bpmnElement=\"EndEvent_0jz0q46\">\n        <dc:Bounds x=\"762\" y=\"240\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge id=\"SequenceFlow_0xa8adm_di\" bpmnElement=\"SequenceFlow_0xa8adm\">\n        <di:waypoint x=\"612\" y=\"258\" />\n        <di:waypoint x=\"762\" y=\"258\" />\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn2:definitions>\n','2020-03-05 10:25:35','2020-03-05 10:25:35','1','1',1,'admin');

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

insert  into `workflow_user`(`id`,`username`,`password`,`email`,`role_code`,`role_name`,`create_user_id`,`create_time`,`modify_time`) values (1,'admin','23f90100463d27633c61a711a8bf8ea5072710952454d509','345849402@qq.com','admin','管理员',1,'2019-03-21 14:30:57','2019-03-21 14:30:57');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
