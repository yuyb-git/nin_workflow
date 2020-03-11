package cn.netinnet.workflow.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateStrUtil {
    private static final Pattern P = Pattern.compile("^(-?\\d+)(\\d{2})(\\d{2})$");
    private static final String DEFAULT_DATE_FORMAT_STR = "yyyyMMdd";
    private static final int BASE = 50;

    /**
     * @description 判断给定dateStr是否闰年
     * @param dateStr
     * @return boolean
     * @author Xy.Lin
     * @date 2018/8/10 9:48
     */
    public static boolean isLeapYear(String dateStr) {
        return new DateStr(dateStr).isLeapYear();
    }

    /**
     * @description 动态年份日期是否闰年
     * @param startYear
     * @param dynamicYearDateStr
     * @return boolean
     * @author Xy.Lin
     * @date 2018/8/10 9:45
     */
    public static boolean isLeapYear(String startYear, String dynamicYearDateStr) {
        return new DateStr(dynamicYearDateStr, true, startYear).isLeapYear();
    }

    /**
     * 对应数据库函数 getDateStr('2018', '500620') => 20180620
     * */
    public static String get(String startYear, String dynamicYearDateStr) {
        return new DateStr(dynamicYearDateStr, true, startYear).getDateStr();
    }

    /**
     * 对应数据库函数 setDateStr('2018', '20180620') => 500620
     * */
    public static String set(String startYear, String yyyyMMdd) {
        startYear = startYear.replaceAll("\\s", "");
        yyyyMMdd = yyyyMMdd.replaceAll("\\s", "");
        return new DateStr(yyyyMMdd, false, startYear).getDynamicYearDateStr();
    }

    /**
     * 对应数据库函数 getDateStr('2018', '500620') => 20180620
     * 但是返回的是Calendar对象
     * */
    public static Calendar getCalendar(String startYear, String dynaicYearDateStr) {
        dynaicYearDateStr = dynaicYearDateStr.replaceAll("\\s", "");
        startYear = startYear.replaceAll("\\s", "");
        return new DateStr(dynaicYearDateStr, true, startYear).getCalendar();
    }

    public static Calendar initCalendar(int year, int month, int dayOfMonth,
                                         int hourOfDay, int minute, int second, int millSecond) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.MILLISECOND, millSecond);
        return c;
    }

    public static Calendar initCalendarByYyyyMmDd(String yyyyMmDd) {
        yyyyMmDd = yyyyMmDd.replaceAll("\\s", "");
        return new DateStr(yyyyMmDd).getCalendar();
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少毫秒
     * */
    public static long periodMilliseconds(String fromDateStr, String toDateStr) {
        return periodMilliseconds(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少毫秒
     * */
    public static long periodMilliseconds(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodMilliseconds(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少毫秒
     * */
    public static long periodMillisecondsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodMillisecondsDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少毫秒
     * */
    public static long periodMillisecondsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodMilliseconds(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少秒
     * */
    public static int periodSeconds(String fromDateStr, String toDateStr) {
        return periodSeconds(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少秒
     * */
    public static int periodSeconds(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodSeconds(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少秒
     * */
    public static int periodSecondsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodSecondsDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少秒
     * */
    public static int periodSecondsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodSeconds(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少分
     * */
    public static int periodMinutes(String fromDateStr, String toDateStr) {
        return periodMinutes(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少分
     * */
    public static int periodMinutes(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodMinutes(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少分
     * */
    public static int periodMinutesDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodMinutesDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少分
     * */
    public static int periodMinutesDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodMinutes(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少小时
     * */
    public static int periodHours(String fromDateStr, String toDateStr) {
        return periodHours(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少小时
     * */
    public static int periodHours(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodHours(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少小时
     * */
    public static int periodHoursDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodHoursDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少小时
     * */
    public static int periodHoursDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodHours(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少天
     * */
    public static int periodDays(String fromDateStr, String toDateStr) {
        return periodDays(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少天
     * */
    public static int periodDays(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodDays(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少天
     * */
    public static int periodDaysDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodDaysDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少天
     * */
    public static int periodDaysDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodDays(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少周
     * */
    public static int periodWeeks(String fromDateStr, String toDateStr) {
        return periodWeeks(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少周
     * */
    public static int periodWeeks(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodWeeks(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少周
     * */
    public static int periodWeeksDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodWeeksDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少周
     * */
    public static int periodWeeksDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodWeeks(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少月
     * */
    public static int periodMonths(String fromDateStr, String toDateStr) {
        return periodMonths(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少月
     * */
    public static int periodMonths(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodMonths(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少月
     * */
    public static int periodMonthsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodMonthsDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少月
     * */
    public static int periodMonthsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodMonths(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少年
     * */
    public static int periodYears(String fromDateStr, String toDateStr) {
        return periodYears(fromDateStr, toDateStr, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * fromDateStr 到 toDateStr 间隔多少年
     * */
    public static int periodYears(String fromDateStr, String toDateStr, String format) {
        return new DateStr(fromDateStr, format).periodYears(new DateStr(toDateStr, format));
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少年
     * */
    public static int periodYearsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear) {
        return periodYearsDynamic(fromDynamicDateStr, toDynamicDateStr, startYear, DEFAULT_DATE_FORMAT_STR);
    }

    /**
     * 动态年份
     * fromDateStr 到 toDateStr 间隔多少年
     * */
    public static int periodYearsDynamic(String fromDynamicDateStr, String toDynamicDateStr, String startYear, String format) {
        return new DateStr(fromDynamicDateStr, true, startYear, format).periodYears(new DateStr(toDynamicDateStr, true, startYear, format));
    }

    /**
     * 指定日期加减N天、秒、...
     * @param  field 见Calendar.get(field)
     * */
    public static DateStr add(String dateStr, String format, int field, int amount) {
        return new DateStr(dateStr, format).add(field, amount);
    }

    public static DateStr add(String dateStr, int field, int amount) {
        return add(dateStr, DEFAULT_DATE_FORMAT_STR, field, amount);
    }

    public static DateStr addDynamic(String dateStr, String startYear, String format, int field, int amount) {
        return new DateStr(dateStr, true, startYear, format).add(field, amount);
    }

    public static DateStr addDynamic(String dateStr, String startYear, int field, int amount) {
        return new DateStr(dateStr, true, startYear, DEFAULT_DATE_FORMAT_STR).add(field, amount);
    }


    /** 方法描述
     * @description type1: yyyyMMdd格式转换为yyyy-mm-dd type2: yyyy-mm-dd格式转换为yyyymmdd type3: yyyym格式转换为yyyymm
     * @param timeDate
     * @return [timeDate]
     * @author wanghy
     * @date 2018/8/15 14:05
     */
    public static String timeTypeChange(String timeDate, Integer type) {
        Date date = null;
        String nowDate = "";
        if(type == 1) {
            try {
                date = new SimpleDateFormat("yyyyMMdd").parse(timeDate);
                nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(timeDate);
                nowDate = new SimpleDateFormat("yyyyMMdd").format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return nowDate;
    }


    /**
     * 获取上一个月的最后一天的日期
     * @return
     */
    public static String getPreMonthSLastDay(String date){
        SimpleDateFormat sdf = SimpleDateFormatFactory.getInstance(DEFAULT_DATE_FORMAT_STR);
        Date d = sdf.parse(date, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 封装日期、动态年份日期
     * */
    public static class DateStr implements Comparable<DateStr> {
        /** 是否动态年份: 500601 */
        private boolean isDynamicYear;
        private String initDateStr;
        private String initDynamicYearDateStr;
        private Integer startYear;
        private String format;
        private GregorianCalendar calendar;

        public DateStr(String dateStr) {
            this(dateStr, false, null, DateStrUtil.DEFAULT_DATE_FORMAT_STR);
        }

        public DateStr(String dateStr, String format) {
            this(dateStr, false, null, format);
        }

        public DateStr(String dateStr, boolean isDynamicYear, String startYear) {
            this(dateStr, isDynamicYear, startYear, DateStrUtil.DEFAULT_DATE_FORMAT_STR);
        }

        public DateStr(String dateStr, boolean isDynamicYear, String startYear, String format) {
            this.isDynamicYear = isDynamicYear;
            this.format = format;
            calendar = new GregorianCalendar();
            calendar.clear();
            if (isDynamicYear) {
                this.startYear = Integer.valueOf(startYear);
                Matcher m = DateStrUtil.P.matcher(dateStr);
                if (m.find()) {
                    int startY = Integer.parseInt(startYear);
                    int intervalYear = Integer.parseInt(m.group(1)) - BASE;
                    int month = Integer.parseInt(m.group(2));
                    int dayOfMonth = Integer.parseInt(m.group(3));
                    Calendar c = DateStrUtil.initCalendar(startY + intervalYear, month, dayOfMonth, 0, 0, 0, 0);
                    calendar.setTimeInMillis(c.getTimeInMillis());
                }
                this.initDynamicYearDateStr = dateStr;
                this.initDateStr = getDateStr();
            } else {
                SimpleDateFormat sdf = getDateFormat();
                calendar.setTime(sdf.parse(dateStr, new ParsePosition(0)));
                this.initDateStr = dateStr;
                if (null != startYear) {
                    this.startYear = Integer.valueOf(startYear);
                    this.initDynamicYearDateStr = getDynamicYearDateStr();
                }
            }

        }

        public SimpleDateFormat getDateFormat() {
            return SimpleDateFormatFactory.getInstance(format);
        }

        public GregorianCalendar getCalendar() {
            return calendar;
        }

        public boolean isLeapYear() {
            return calendar.isLeapYear(calendar.get(Calendar.YEAR));
        }

        public String getDateStr() {
            SimpleDateFormat sdf = getDateFormat();
            return sdf.format(calendar.getTime());
        }

        public String getDynamicYearDateStr() {
            int intervalYear = calendar.get(Calendar.YEAR) - startYear + DateStrUtil.BASE;
            StringBuilder dynamicYearDateStrBuilder = new StringBuilder(String.valueOf(intervalYear));
            dynamicYearDateStrBuilder.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
            dynamicYearDateStrBuilder.append(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));
            return dynamicYearDateStrBuilder.toString();
        }

        public String getInitDateStr() {
            return initDateStr;
        }

        public String getInitDynamicYearDateStr() {
            return initDynamicYearDateStr;
        }

        public Integer getStartYear() {
            return startYear;
        }

        public DateStr add(int field, int amount) {
            calendar.add(field, amount);
            return this;
        }

        public int get(int field) {
            return calendar.get(field);
        }

        public long periodMilliseconds(DateStr target) {
            long from = calendar.getTimeInMillis();
            long to = target.calendar.getTimeInMillis();
            return to - from;
        }

        public int periodSeconds(DateStr target) {
            return (int) (periodMilliseconds(target) / 1000L);
        }

        public int periodMinutes(DateStr target) {
            return (int) (periodMilliseconds(target) / 60000L);
        }

        public int periodHours(DateStr target) {
            return (int) (periodMilliseconds(target) / 3600000L);
        }

        public int periodDays(DateStr target) {
            return (int) (periodMilliseconds(target) / 86400000L);
        }

        public int periodWeeks(DateStr target) {
            return (int) (periodMilliseconds(target) / 604800000L);
        }

        public Period period(DateStr target) {
            LocalDate localDateFrom = LocalDate.of(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DAY_OF_MONTH));
            LocalDate localDateTo = LocalDate.of(target.calendar.get(Calendar.YEAR),
                    target.calendar.get(Calendar.MONTH) + 1,
                    target.calendar.get(Calendar.DAY_OF_MONTH));
            return Period.between(localDateFrom, localDateTo);
        }

        public int periodMonths(DateStr target) {
            Period period = period(target);
            return period.getMonths() + 12 * period.getYears();
        }

        public int periodYears(DateStr target) {
            Period period = period(target);
            return period.getYears();
        }

        public String format(String formatPattern) {
            return SimpleDateFormatFactory.getInstance(formatPattern).format(calendar.getTimeInMillis());
        }

        @Override
        public int compareTo(DateStr o) {
            return calendar.compareTo(o.calendar);
        }
    }

    public static String getThisMonthLastDay(String date){
        SimpleDateFormat sdf = SimpleDateFormatFactory.getInstance(DEFAULT_DATE_FORMAT_STR);
        Date d = sdf.parse(date, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(d);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return sdf.format(calendar.getTime());
    }

    /**
     * 功能描述: 获取当前月季度
     * * @param month
     * @return: int
     * @auther: osp
     * @date: 2018/8/15
     */
    public static int getSeason(String month){
        if(month.length() < 2){
            month = "0" + month;
        }
        if("010203".indexOf(month) >= 0){
            return 1;
        }
        if("040506".indexOf(month) >= 0){
            return 2;
        }
        if("070809".indexOf(month) >= 0){
            return 3;
        }
        if("101112".indexOf(month) >= 0){
            return 4;
        }
        return 0;
    }
    /** 方法描述
     * @description  获取某年第一天
     * @param year
     * @return java.util.Date
     * @author Caicm
     * @date 2019/4/9 20:14
     */
    
    public static Date getYearFirstDay(Integer year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        return  calendar.getTime();
    }

    /** 方法描述
     * @description  获取某年最后一天
     * @param year
     * @return java.util.Date
     * @author Caicm
     * @date 2019/4/9 20:14
     */
    public static Date getYearLastDay(Integer year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
        return  calendar.getTime();
    }

	/**
	 * 方法描述
	 *
	 * @param year
	 * @param month
	 * @return java.util.Date
	 * @description 获取某月的第一天
	 * @author Caicm
	 * @date 2019/5/27 18:19
	 */


	public static Date firstDayofMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month > 11 ? 11 : (month < 0 ? 0 : month - 1));
		return cal.getTime();
	}

	/**
	 * 方法描述
	 *
	 * @param year
	 * @param month
	 * @return java.util.Date
	 * @description 获取某月的最后一天
	 * @author Caicm
	 * @date 2019/5/27 18:19
	 */

	public static Date lastDayofMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}


    /**
     * 获取某月的最后一天
     * @param year
     * @param month
     * @return int
     */
    public static int getLastDayOfMonth(int year, int month) {
        String lastDayOfMonthStr = getThisMonthLastDay(year + String.format("%02d", month) + "01");
        return Integer.parseInt(lastDayOfMonthStr.substring(6));
    }


    public static String yyyy_mm_ddhh_13(Date rightNow) {
        return DateFormatUtils.format(rightNow, "yyyy-MM-dd HH");
    }


    public static List<String> getDateList(String startTime, String endTime) {
        String patern = "yyyy-MM-dd";
        DateFormat dateformat = new SimpleDateFormat(patern);
        Date startTimeDate = new Date();
        Date endTimeDate = new Date();
        try {
            startTimeDate = dateformat.parse(startTime);
            endTimeDate = dateformat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //设置开始时间
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(startTimeDate);
        //设置结束时间
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endTimeDate);
        List<String> Datelist = new ArrayList<String>();
        // 每次循环给calBegin日期加一天，直到calBegin.getTime()时间等于dEnd
        Datelist.add(dateformat.format(calBegin.getTime()));
        Integer changeField = Calendar.DAY_OF_MONTH;
        while (endTimeDate.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(changeField, 1);
            Datelist.add(dateformat.format(calBegin.getTime()));
        }
        return Datelist;
    }
}
