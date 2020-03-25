DROP TABLE IF EXISTS `form_json`;

CREATE TABLE `form_json` (
     `id` bigint(18) NOT NULL COMMENT '主键',
     `json_data` text COMMENT 'json数据',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `form_material` */

DROP TABLE IF EXISTS `form_material`;

CREATE TABLE `form_material` (
     `form_id` bigint(18) NOT NULL COMMENT '主键id',
     `form_title` varchar(30) NOT NULL DEFAULT '' COMMENT '申请标题',
     `account_company` varchar(30) NOT NULL DEFAULT '' COMMENT '核算公司',
     `application` varchar(30) NOT NULL DEFAULT '' COMMENT '申请用途',
     `filler` varchar(10) NOT NULL DEFAULT '' COMMENT '填单人',
     `fill_date` date DEFAULT NULL COMMENT '填单日期',
     `applier_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '申请人用户id',
     `applier_name` varchar(10) NOT NULL DEFAULT '' COMMENT '申请人',
     `applier_tel` varchar(11) NOT NULL DEFAULT '' COMMENT '申请人电话',
     `applier_dept_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '申请人部门id',
     `applier_dept` varchar(10) NOT NULL DEFAULT '' COMMENT '申请人部门',
     `arrival_date` date DEFAULT NULL COMMENT '到货期限',
     `approver_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '审批人用户id',
     `approver_name` varchar(10) NOT NULL DEFAULT '' COMMENT '审批人',
     `approver_dept_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '审批人部门id',
     `approver_dept` varchar(10) NOT NULL DEFAULT '' COMMENT '审批人部门',
     `approve_opinion` varchar(30) NOT NULL DEFAULT '' COMMENT '审批意见',
     `approve_date` date DEFAULT NULL COMMENT '审批日期',
     PRIMARY KEY (`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `form_purchase` */

DROP TABLE IF EXISTS `form_purchase`;

CREATE TABLE `form_purchase` (
     `form_id` bigint(18) unsigned NOT NULL COMMENT '主键id',
     `form_title` varchar(30) NOT NULL DEFAULT '' COMMENT '申请标题',
     `form_no` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '申请单号',
     `fill_date` date NOT NULL COMMENT '填单日期',
     `filler` varchar(10) NOT NULL DEFAULT '' COMMENT '填单人',
     `account_company` varchar(30) NOT NULL DEFAULT '' COMMENT '核算公司',
     `currency` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '币种',
     `budget_date` date DEFAULT NULL COMMENT '预算归属日期',
     `applier_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '申请人用户id',
     `applier_name` varchar(10) NOT NULL DEFAULT '' COMMENT '申请人',
     `applier_tel` varchar(11) NOT NULL DEFAULT '' COMMENT '申请人电话',
     `applier_dept_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '申请人部门id',
     `applier_dept` varchar(10) NOT NULL COMMENT '申请人部门',
     `application` varchar(30) NOT NULL DEFAULT '' COMMENT '申请用途',
     `purchaser_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '采购人用户id',
     `purchaser_name` varchar(10) NOT NULL DEFAULT '' COMMENT '采购人',
     `purchaser_tel` varchar(11) NOT NULL DEFAULT '' COMMENT '采购人电话',
     `purchaser_dept_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '采购人部门id',
     `purchaser_dept` varchar(10) NOT NULL DEFAULT '' COMMENT '采购人部门',
     `arrival_date` date DEFAULT NULL COMMENT '到货期限',
     `approver_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '审批人用户id',
     `approver_name` varchar(10) NOT NULL DEFAULT '' COMMENT '审批人',
     `approver_dept_id` bigint(18) unsigned NOT NULL DEFAULT '0' COMMENT '审批人部门id',
     `approver_dept` varchar(10) NOT NULL DEFAULT '' COMMENT '审批人部门',
     `approve_opinion` varchar(30) NOT NULL DEFAULT '' COMMENT '审批意见',
     `approve_date` date DEFAULT NULL COMMENT '审批日期',
     PRIMARY KEY (`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `form_purchase` ADD COLUMN `form_json_id` BIGINT(18) UNSIGNED DEFAULT 0 NOT NULL COMMENT 'json_data表主键id' AFTER `approve_date`;
ALTER TABLE `form_material` ADD COLUMN `form_json_id` BIGINT(18) UNSIGNED DEFAULT 0 NOT NULL COMMENT 'json_data表主键id' AFTER `approve_date`;

insert  into `form_json`(`id`,`json_data`) values (1,'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'),(2,'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');