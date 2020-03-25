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
