package cn.netinnet.workflow.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 厦门网中网软件有限公司.
 *
 * @author Xy.Lin
 * @version 1.0
 * @description 获取SimpleDateFormat的工厂类,
 *      避免频繁的new SimpleDateFormat对象,
 *      并且SimpleDateFormat对象是线程不安全的, 不宜直接定义为static
 * @date 2018/8/15 15:07
 */
public class SimpleDateFormatFactory {

    /** 默认的时间格式 */
    public static String DEFAULT_DATE_FORMAT_STR = "yyyyMMdd";

    /**
     * @description 获取默认时间格式的SimpleDateFormat对象
     * @return java.text.SimpleDateFormat
     * @author Xy.Lin
     * @date 2018/8/15 15:15
     */
    public static SimpleDateFormat getInstance() {
        return getInstance(DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * @description 获取指定时间格式的SimpleDateFormat对象
     * @param format
     * @return java.text.SimpleDateFormat
     * @author Xy.Lin
     * @date 2018/8/15 15:16
     */
    public static SimpleDateFormat getInstance(String format) {
        Map<String, SimpleDateFormat> simpleDateFormatMap = SimpleDateFormatHolder.DATE_FORMAT_THREAD_LOCAL.get();
        SimpleDateFormat sdf = simpleDateFormatMap.get(format);
        if (null == sdf) {
            sdf = new SimpleDateFormat(format);
            simpleDateFormatMap.put(format, sdf);
        }
        return sdf;
    }


    private static class SimpleDateFormatHolder {
        static final ThreadLocal<Map<String, SimpleDateFormat>> DATE_FORMAT_THREAD_LOCAL;
        static {
            DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new HashMap<>());
        }
    }

}
