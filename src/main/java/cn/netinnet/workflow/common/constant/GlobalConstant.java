package cn.netinnet.workflow.common.constant;


import java.math.BigDecimal;

/**
 * 全局常量
 * @author chen.wb
 * @version V1.0
 * @date 2017-11-30
 **/
public class GlobalConstant {
    public static final String PROJECT_CODE = "fssc";

    public static final int SUCCESS = 200; // 请求成功
    public static final int FAILURE = -1; // 请求失败
    /** session 会话过期 */
    public static final int SESSION_TIMEOUT = -500;
    /** 重复提交 */
    public static final int REPEAT_SUBMIT = -502;
    /** 无效提交 */
    public static final int INVALID_SUBMIT = -503;
    
    /** ocr识别状态：识别成功，未生成凭证 */
    public static final Integer OCR_IDENTIFY_RESULT_NOVOUCHER = 210;
    /** ocr识别状态：识别失败 */
    public static final Integer OCR_IDENTIFY_RESULT_NONE = -511;
    /** ocr识别状态：无法识别 */
    public static final Integer OCR_IDENTIFY_RESULT_Fail = -512;
    /** ocr识别状态：识别次数不足或关闭 */
    public static final Integer OCR_IDENTIFY_RESULT_OFF = -513;

    public static final String SUCCESS_MSG = "操作成功！"; // 请求成功
    public static final String FAILURE_MSG = "操作失败！"; // 请求失败
    public static final String SESSION_TIMEOUT_MSG = "会话已过期，请重新登录";
    /** 重复提交 */
    public static final String REPEAT_SUBMIT_MSG = "该动作正在执行中，请勿重复提交!";
    /** 无效提交 */
    public static final String INVALID_SUBMIT_MSG = "存在无效数据，请刷新页面!";
    public static final String GXYTH_FAILED_MSG = "跳转错误，请检查参数！";
    public static final String  TIME_OUT = "请求超时！";

    public static final String CONTENT_TYPE = "application/json"; // 响应的ContentType内容
    public static final String CHARACTER_ENCODING = "utf-8"; // 响应编码

    //小规模纳税人
    public static final String XGM = "xgm";

    public static final String QY = "qy";
    public static final String XQY = "xqy";

    public static final String STANDARD = "standard";
    public static final String USER = "user";
    public static final String INIT = "init";

    //余额方向 1：借；0：平；-1：贷
    public static final int BALANCE_DIRECT_DEBIT = 1;
    public static final int BALANCE_DIRECT_BALANCE = 0;
    public static final int BALANCE_DIRECT_LEND = -1;

    //月初第一天
    public static final int FIRST_DAY_OF_MONTH = 1;
    //全年最后一个月
    public static final int LAST_MONTH_OF_YEAR = 12;
    //12月初后一天
    public static final int LAST_DAY_OF_DECMBER = 31;

    //默认税率
    public static final BigDecimal DEFAULT_TAX_RATE = new BigDecimal(16);

    //图片类型
    public static final String IMAGE_TYPE = "png,jpeg,jpg,bmp";
    //生成缩略图的默认前缀
    public static final String DEFAULT_PREVFIX = "thumb_";
    
    /**  票据tab标签页名称  */
    //所有、全部
    public static final String ALL = "all";
    //未保存、未整理
    public static final String UNDO = "undo";
    //已保存
    public static final String DONE = "done";
    
    //字符串1
  	public static final String ONE_STRING = "1";
  	//字符串0
  	public static final String ZERO_STRING = "0";
  	//整数1
  	public static final int ONE = 1;
  	//整数0
  	public static final int ZERO = 0;
  	//整数-1
  	public static final int NEGATIVE_ONE = -1;

    /*费用摊销跨期费用凭证businessId  用于查找跨期费用产生的凭证*/
  	public static final Long INTER_PERIOD_COST = 100000000000000000L;
    /*费用摊销固定资产费用凭证businessId 用于查找固定资产费用产生的凭证*/
    public static final Long FIXED_PROPERTY = 200000000000000000L;
    /*费用摊销无形资产费用凭证businessId 用于查找无形资产费用产生的凭证*/
    public static final Long INVISIBLE_PROPERTY = 300000000000000000L;

    //运算符号
    public static final String SYMBOL_ADD = "+";
    public static final String SYMBOL_SUB = "-";

    public static final String CONTENT_TYPE_JSON_WITH_CHARACTER_ENCODING = String.format("%s; charset=%s", CONTENT_TYPE, CHARACTER_ENCODING);

    public final static String REPORT_ZCFZB = "asset_liability";
    public final static String REPORT_LRB = "profit";

    //凭证摘要替换标志
    public final static String MEMO_MARK = "@@";

	//密码最大长度和最小长度
	public static final int PASSWORD_MAX_LENGTH = 10;
	public static final int PASSWORD_MIN_LENGTH = 6;

	//账套创建者角色类型
	public static final Integer CREATE_USER_TYPE_SUPER_ADMIN = 1;
	public static final Integer CREATE_USER_TYPE_TEACHER_ADMIN = 2;
    public static final Integer CREATE_USER_TYPE_TEACHER = 3;
	public static final Integer CREATE_USER_TYPE_STUDENT = 4;

    //拼接票据名称时截取billId的长度
    public static final int BILLNAME_CUT_LENGTH_FROM_BILLID = 8;

    public static final String FILE_UPLOAD_STATUS = "FILE_UPLOAD_STATUS";
}
