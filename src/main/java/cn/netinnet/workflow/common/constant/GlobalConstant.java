package cn.netinnet.workflow.common.constant;


import java.math.BigDecimal;

/**
 * 全局常量
 * @author chen.wb
 * @version V1.0
 * @date 2017-11-30
 **/
public class GlobalConstant {

    public static final String PROJECT_CODE = "workflow";

    public static final int SUCCESS = 200; // 请求成功
    public static final int FAILURE = -1; // 请求失败
    /** session 会话过期 */
    public static final int SESSION_TIMEOUT = -500;
    /** 重复提交 */
    public static final int REPEAT_SUBMIT = -502;
    /** 无效提交 */
    public static final int INVALID_SUBMIT = -503;
    
    public static final String SUCCESS_MSG = "操作成功！"; // 请求成功
    public static final String FAILURE_MSG = "操作失败！"; // 请求失败
    public static final String SESSION_TIMEOUT_MSG = "会话已过期，请重新登录";
    /** 响应的ContentType内容 */
    public static final String CONTENT_TYPE = "application/json";
    public static final String CHARACTER_ENCODING = "utf-8"; // 响应编码

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

}
