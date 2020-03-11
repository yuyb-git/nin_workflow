package cn.netinnet.workflow.common.global;

/**
 * @author ouyang.xl
 * @version V1.0
 * @Description: 返回信息的枚举，code和msg一一对应
 * <p>
 * 统一枚举各个页面返回信息
 * 正确信息为正数，错误信息为负数，
 * @Date 2017-11-30
 **/
public enum ResultEnum {

    R_SUCC(200, "成功"),
    /**
     * 学生
     */
    //参数校验失败,
    R_STU_PARAM(411, "参数异常"),
    // 保存或更新失败
    R_STU_OPER(412, "操作失败"),
    R_FILE_ERR(413,"Excel模板错误"),
    R_IS_NOT_XLS(414, "请选择Excel文件"),
    R_OVER_STU_SIZE(415, "人数超过限制"),
    R_UPLOAD_NULL(416, "文件不能为空"),
    R_NOT_TEACH_CLASS(417,"没有教学班"),
    R_GROUP_NOT_STUDENT(418, "小组下没有选手"),
    R_USER_NOT_EXIST(444, "用户不存在"),
    R_USER_ERR(445,"用户名不存在或密码错误"),
    R_MATCH_NOT_START(446,"竞赛未开始，请在竞赛前十分钟登录"),
    R_MATCH_END(447,"竞赛已结束"),
    R_IP_NOT_SCOPE(448,"很抱歉,目前您没有访问的权限"),

    R_MISSED_REQUIRED_PARAM(301, "缺少必要参数"),
    R_PARAM_NOT_MATCH(302, "查询结果无数据"),
    /***
     * E打头的只能给正保授权用
     */
    E_SUCC(0, "成功"),
    E_PARAM(-1, "参数错误"),
    E_EXIST(-2, "已经存在"),
    E_DEFAULT(-3, "其他错误"),
    E_AUTH(-4, "认证错误"),
    E_NOTEXIST(-5, "不存在"),
    E_RANDCODE(-6, "验证码错误"),
    E_OFFLINE(-7, "用户已离线"),
    E_DOMAIN(-8, "域名错误"),
    E_GEXIST(-9, "其他网已存在"),
    E_TOOFAST(-10, "超出频率"),
    E_TIMEOUT(-11, "超时"),
    E_TOOMANYIP(-12, "超出设备数"),
    E_SPANUSER(-13, "疑似垃圾用户"),
    E_USERLOCK(-14, "登录锁定"),
    E_UEXIST(-15, "绑定时，存在该绑定名称的用户"),
    E_NEEDAUTH(-16, "需要验证码"),
    E_SESSINVALID(-17, "session过期"),
    E_INVALIDMID(-18, "非法的设备"),
    E_INVALIDSID(-19, "sid失效");

    private int code;  // 错误代码
    private String msg;// 错误信息


    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
