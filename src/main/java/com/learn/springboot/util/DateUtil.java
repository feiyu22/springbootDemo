package com.learn.springboot.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 *
 * 日期操作对象，对日期进行格式化,判断期合法性等
 * Created by reus on 2017/5/9.
 */
public abstract class DateUtil {
    /**
     * 短日期格式
     */
    public final static int SHORT_DATEFORMAT = 1; // 短日期格式
    /**
     * 短日期格式（但有前导0,如：2004-08-08 形式)
     */
    public final static int SHORT_DATEFORMAT_FULL = 5;
    /**
     * 长日期格式
     */
    public final static int LONG_DATEFORMAT = 2; // 长日期格式
    /**
     * 短日期格式,2000年01月01日
     */
    public final static int SHORT_DATEFORMAT_CN = 3; // 短日期格式,2000年01月01日
    /**
     * 长日期格式,2000年01月01日01:01:01
     */
    public final static int LONG_DATEFORMAT_CN = 4; // 长日期格式,2000年01月01日01:01:01
    public final static int LONG_DATEFORMAT_MIN = 5;
    
    public final static int LONG_DATEFORMAT_MIN_MIN = 6; //不带年和月格式,13日19时23分

    public final static int LONG_DATEFORMAT_HOURS = 7; //最小颗粒为小时：2000年01月01日08时
    
    public final static int LONG_DATEFORMAT_HOURS_8 = 8; //最小颗粒为小时：01月01日
    /**
     * 判断日期是否正确
     * 
     * @param checkDate 日期字符串
     * @return true/false 合法返回true
     */
    public static boolean checkDateFormat(String checkDate) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            dateFormat.parse(checkDate); // 把日期强制转换成日期格式
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    /**
     * 提取当前时间,并进行格式化显示
     * @param dateFormat 日期格式，参考日期格式常量
     */
    public static String getDateWithFormat(int dateFormat) {
        String stringDate = "";

        if (dateFormat == 0)
            dateFormat = DateUtil.SHORT_DATEFORMAT;

        Calendar date = Calendar.getInstance();
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) + 1;
        int day = date.get(Calendar.DATE);
        int hours = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);
        int seconds = date.get(Calendar.SECOND);

        if (dateFormat == DateUtil.SHORT_DATEFORMAT)
            stringDate = year + "-" + month + "-" + day;
        if (dateFormat == DateUtil.SHORT_DATEFORMAT_FULL) {
            String monthStr = "", dayStr = "";
            if (month < 10)
                monthStr = "0";
            if (day < 10)
                dayStr = "0";
            stringDate = year + "-" + monthStr + month + "-" + dayStr + day;
        }
        if (dateFormat == DateUtil.LONG_DATEFORMAT)
            stringDate = year + "-" + month + "-" + day + " " + hours + ":" + minute + ":" + seconds;
        if (dateFormat == DateUtil.SHORT_DATEFORMAT_CN)
            stringDate = year + "年" + month + "月" + day + "日";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_CN)
            stringDate = year + "年" + month + "月" + day + "日" + hours + "时" + minute + "时" + seconds;
        if (dateFormat == DateUtil.LONG_DATEFORMAT_MIN)
            stringDate = year + "年" + month + "月" + day + "日" + hours + "时" + minute + "分";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_MIN_MIN)
        	stringDate = day + "日" + hours + "时" + minute + "分";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_HOURS)
        	stringDate = day + "日" + hours + "时";
        if(dateFormat == DateUtil.LONG_DATEFORMAT_HOURS_8)
        	stringDate = month + "月" + day + "日";
        	
        return stringDate;
    }

    /**
     * 对指定日期进行格式化输出
     * 
     * @param date 原指定日期
     * @param dateFormat 日期格式
     * @return 日期字符串
     */
    public static String getDateWithFormat(Date date, int dateFormat) {
        String stringDate = "";
        if (date == null)
            return stringDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (dateFormat == 0)
            dateFormat = DateUtil.SHORT_DATEFORMAT;

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        if (dateFormat == DateUtil.SHORT_DATEFORMAT)
            stringDate = year + "-" + month + "-" + day;
        if (dateFormat == DateUtil.LONG_DATEFORMAT)
            stringDate = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
        if (dateFormat == DateUtil.SHORT_DATEFORMAT_CN)
            stringDate = year + "年" + month + "月" + day + "日";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_CN)
            stringDate = year + "年" + month + "月" + day + "日" + hours + ":" + minutes + ":" + seconds;
        if (dateFormat == DateUtil.LONG_DATEFORMAT_MIN)
            stringDate = year + "年" + month + "月" + day + "日" + hours + "时" + minutes + "分";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_MIN_MIN)
        	stringDate = day + "日" + hours + "时" + minutes + "分";
        if (dateFormat == DateUtil.LONG_DATEFORMAT_HOURS)
        	stringDate = year + "年" + month + "月" + day + "日" + hours + "时";
        if(dateFormat == DateUtil.LONG_DATEFORMAT_HOURS_8)
        	stringDate = month + "月" + day + "日";
        return stringDate;
    }

    /**
     * 字符串转换成时间
     * 
     * @param dateString 日期字符串
     * @return Date 日期对象
     */
    public static Date convertStringToDate(String dateString) {
        Date date = new Date();
        if (dateString == null) {
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            return date;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        if (dateString.indexOf(":") != -1)
            dateFormat.applyPattern("yyyy-MM-dd hh:mm:ss");
        else
            dateFormat.applyPattern("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateString);
        } catch (Exception ex) {
        }

        return date;
    }

    /**
     * 字符串转换成时间
     * 
     * @param dateString 日期字符串
     * @return Date 日期对象
     */
    public static Date convertStringToDate(String dateString, String formatStr) {
        Date date = new Date();
        if (dateString == null) {
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            return date;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat();

        dateFormat.applyPattern(formatStr);

        try {
            date = dateFormat.parse(dateString);
        } catch (Exception ex) {

        }

        return date;
    }

    /**
     * 把指定日期转换成sql.Date格式
     * 
     * @param date 要转换的日期对象
     * @return sql 日期对象
     */
    public static java.sql.Date convertDateToSqlDate(Date date) {
        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        // com.yysoft.util.Debug.println("year=" + year);
        int month = calendar.get(Calendar.MONTH) + 1;
        // com.yysoft.util.Debug.println("month=" + month);
        int day = calendar.get(Calendar.DATE);
        // com.yysoft.util.Debug.println("day=" + day);

        return new java.sql.Date(year, month, day);
    }

    /**
     * 取得当前时间的星期数
     * 
     * @return 周数值。星期数:星期日=7;星期一=1;星期二=2;星期三=3;星期四=4;星期五=5;星期六=6;
     */
    public static int getCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = week - 1;
        if (week == 0)
            week = 7;

        return week;
    }

    /**
     * 提取当前年
     * 
     * @return 当前年
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static String getYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return Integer.toString(year);

    }

    /**
     * 提取当前月份
     * 
     * @return 月份
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static String getMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.MONTH) + 1;
        if (year < 10) {
            String strYear = "0" + year;
            return strYear;
        } else {
            return Integer.toString(year);
        }
    }

    /**
     * 提取当前日期
     * 
     * @return 当前日期
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        if (day < 10) {
            String strDay = "0" + day;
            day = new Integer(strDay).intValue();
        }
        return day;
    }

    public static String getDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        if (day < 10) {
            String strDay = "0" + day;
            return strDay;
        } else {
            return Integer.toString(day);
        }
    }

    /**
     * 取得当前时间
     * 
     * @return 当前时间，如:23点,0点,1点等
     */
    public static int getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        return hour;
    }

    /**
     * 比较两面个日期对象,年份是否相等,如果相等则返回0, 如果date1年份大于date2年份,返回1,否则返回-1
     * 
     * @parma date1 日期对象
     * @param date2 日期对象
     * @return 0：两个年相等；1：date1年份大于date2年份；-1：date1年份小于date2年份
     */
    public static int compareYear(Date date1, Date date2) {
        int compare = 0;

        /* 创建日历对象 */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        /* 提取年份 */
        int year1 = calendar.get(Calendar.YEAR);
        calendar.setTime(date2);
        /* 提取年份 */
        int year2 = calendar.get(Calendar.YEAR);

        /* 进行比较 */
        if (year1 == year2) // 相等
            compare = 0;
        else if (year1 > year2) // date1比date2前
            compare = 1;
        else if (year1 < year2) // date1比date2后
            compare = -1;
        else
            // 比较出错
            compare = -2;

        return compare;
    }

    /**
     * 比较两面个日期对象,月份是否相等,如果相等则返回0, 如果date1月份大于date2月份,返回1,否则返回-1
     * 
     * @parma date1 日期对象
     * @param date2 日期对象
     * @return 0：两个月相等；1：date1月份大于date2年份；-1：date1月份小于date2月份
     */
    public static int compareMonth(Date date1, Date date2) {
        int compare = 0;
        /* 先比较年份,如果年份相等则比较月份 */
        int year = compareYear(date1, date2);
        if (year == 0) {
            /* 创建日历 */
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            /* 提取月份 */
            int month1 = calendar.get(Calendar.MONTH);
            calendar.setTime(date2);
            /* 提取月份 */
            int month2 = calendar.get(Calendar.MONTH);

            /* 进行比较 */
            if (month1 == month2) // 相等
                compare = 0;
            else if (month1 > month2) // date1比date2先
                compare = 1;
            else if (month1 < month2) // date1比date2后
                compare = -1;
            else
                compare = -2; // 比较出错
        } else {
            return year;
        }

        return compare;
    }

    /**
     * 比较两面个日期对象,日期是否相等,如果相等则返回0, 如果date1日期大于date2日期,返回1,否则返回-1
     * 
     * @parma date1 日期对象
     * @param date2 日期对象
     * @return 0：两个日期相等；1：date1日期大于date2日期；-1：date1日期小于date2日期
     */
    public static int compareDay(Date date1, Date date2) {
        int compare = 0;
        /* 先比较月分是否相等 */
        int month = compareMonth(date1, date2);
        if (month == 0) {
            /* 创建日历 */
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            /* 提取日期 */
            int day1 = calendar.get(Calendar.DATE);
            calendar.setTime(date2);
            /* 提取日期 */
            int day2 = calendar.get(Calendar.DATE);
            /* 进行比较 */
            if (day1 == day2)
                compare = 0;
            else if (day1 > day2)
                compare = 1;
            else if (day1 < day2)
                compare = -1;
            else
                compare = -2;
        } else {
            return month;
        }

        return compare;
    }

    /**
     * 比较两面个日期对象,时间是否相等,如果相等则返回0, 如果date1时间大于date2时间,返回1,否则返回-1
     * 
     * @parma date1 日期对象
     * @param date2 日期对象
     * @return 0：两个时间相等；1：date1时间大于date2时间；-1：date1时间小于date2时间
     */
    public static int compareHour(Date date1, Date date2) {
        int hour = 0;

        /* 先比较日期是否相同 */
        int day = compareDay(date1, date2);
        if (day == 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(date2);
            int hour2 = calendar.get(Calendar.HOUR_OF_DAY);

            if (hour1 == hour2)
                hour = 0;
            else if (hour1 > hour2)
                hour = 1;
            else if (hour1 < hour2)
                hour = -1;
            else
                hour = -2;
        } else {
            hour = -2;
        }

        return hour;
    }

    /**
     * 取得两个日期对象的天差数
     * 
     * @param date1 日期对象
     * @param date2 日期对象
     * @return int 天差数
     */
    public static int getDateDispersion(Date date1, Date date2) {
        /* 如果其中一为空,则返回 */
        if (date1 == null || date2 == null)
            return 0;

        /* 提取毫秒 */
        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long dispersion = time1 - time2;

        /* 转化成天数 */
        Long longValue = new Long(dispersion / (60 * 1000 * 60 * 24));
        /* 返回整数值 */
        return longValue.intValue();
    }

    /**
     * 取得两个日期对象相差的分钟数
     * 
     * @param date1 日期对象
     * @param date2 日期对象
     * @return int 相差分钟数
     */
    public static int getMinuteDispersion(Date date1, Date date2) {
        /* 如果其中一为空,则返回 */
        if (date1 == null || date2 == null)
            return 0;

        /* 提取毫秒 */
        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long dispersion = time1 - time2;

        /* 转化成分钟 */
        Long longValue = new Long(dispersion / (60 * 1000));
        /* 返回整数值 */
        return longValue.intValue();
    }
    
    /**
     * 取得两个日期对象相差的秒数
     * 
     * @param date1 日期对象
     * @param date2 日期对象
     * @return int 相差秒数
     */
    public static int getSecondDispersion(Date date1, Date date2) {
        /* 如果其中一为空,则返回 */
        if (date1 == null || date2 == null)
            return 0;

        /* 提取毫秒 */
        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long dispersion = time1 - time2;

        /* 转化成秒 */
        Long longValue = new Long(dispersion / (1000));
        /* 返回整数值 */
        return longValue.intValue();
    }

    /**
     * 提取当前时间的前一天或数天的年、月、日，并以数组形式还回。 数组0为年；1为月；2为日.
     * 
     * @param year 当前年
     * @param month 当前月
     * @param day 当前日期
     * @param days 相差天数
     * @return 年、月、日数组
     */
    public static int[] getPreviewDay(int year, int month, int day, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        long longDate = (calendar.getTime()).getTime() - (60 * 1000 * 60 * 24 * days);
        Date date = new Date(longDate);
        calendar.setTime(date);

        int[] rtn = new int[3];
        rtn[0] = calendar.get(Calendar.YEAR);
        rtn[1] = calendar.get(Calendar.MONTH) + 1;
        rtn[2] = calendar.get(Calendar.DATE);

        return rtn;
    }

    /**
     * 提取当前时间的后一天或数天的年、月、日，并以数组形式还回。 数组0为年；1为月；2为日.
     * 
     * @param year 当前年
     * @param month 当前月
     * @param day 当前日期
     * @param days 相差天数
     * @return 年、月、日数组
     */
    public static int[] getNextDay(int year, int month, int day, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        long longDate = (calendar.getTime()).getTime() + (60 * 1000 * 60 * 24 * days);
        Date date = new Date(longDate);
        calendar.setTime(date);

        int[] rtn = new int[3];
        rtn[0] = calendar.get(Calendar.YEAR);
        rtn[1] = calendar.get(Calendar.MONTH) + 1;
        rtn[2] = calendar.get(Calendar.DATE);

        return rtn;
    }

    /**
     * 提取指定时间所在周的第一天的时间
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 年、月、日数组
     */
    public static int[] getDayOfWeek(int year, int month, int day) {
        int[] rtn = new int[6];
        int week = 0;
        long longDate = 0;

        Date date = null;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);

        week = calendar.get(Calendar.DAY_OF_WEEK);
        longDate = (calendar.getTime()).getTime() - (60 * 1000 * 60 * 24 * (week - 1));
        date = new Date(longDate);
        calendar1.setTime(date);

        rtn[0] = calendar1.get(Calendar.YEAR);
        rtn[1] = calendar1.get(Calendar.MONTH) + 1;
        rtn[2] = calendar1.get(Calendar.DATE);

        longDate = (calendar.getTime()).getTime() + (60 * 1000 * 60 * 24 * (7 - week));
        date = new Date(longDate);
        calendar2.setTime(date);
        rtn[3] = calendar2.get(Calendar.YEAR);
        rtn[4] = calendar2.get(Calendar.MONTH) + 1;
        rtn[5] = calendar2.get(Calendar.DATE);

        return rtn;
    }

    public static String getQuartzTime(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);

            int month = calendar.get(Calendar.MONTH) + 1;

            int day = calendar.get(Calendar.DATE);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            int minute = calendar.get(Calendar.MINUTE);

            // int week = calendar.get(Calendar.WEEK_OF_MONTH);

            int second = calendar.get(Calendar.SECOND);

            return second + " " + minute + " " + hour + " " + day + " " + month + " " + "?" + " " + year;
        } else
            return null;
    }

    /**
     * 指定的时间运算，h的值为正整数表示加，h的值为负整数表示减
     * 
     * @param day 日期时间 如：2009-09-03 14:29:00
     * @param h
     * @return
     */
    public static String addDate(String day, int h) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
        // hh:mm:ss");//12小时制
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, h);// 24小时制
        // cal.add(Calendar.HOUR, x);12小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    /**
     * 获取系统指定格式当前日期
     * 
     * @param formate 日期格式(比如：yyyy-MM-dd)
     * @return 返回字符串型的日期 String
     * @author tzk
     * @since 2010-04-29
     */
    public static String getCurrentDate(String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(new Date());
    }

    /**
     * 获得当天偏移天数的日期
     * 
     * @param offsetDay 偏移天数
     * @param format 日期格式
     * @return String
     * @since 2013-7-1
     */
    public static String getOffsetDate(int offsetDay, String format) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, offsetDay);
        return format(c.getTime(), format);
    }

    /**
     * 获得当天偏移天数的日期：格式yyyyMMdd
     * 
     * @param offsetDay 偏移天数
     * @return String yyyyMMdd
     * @since 2013-7-1
     */
    public static String getOffsetDate(int offsetDay) {
        return getOffsetDate(offsetDay, "yyyyMMdd");
    }

    /**
     * 获得当天偏移天数的月份：格式yyyyMM
     * 
     * @param offsetDay 偏移天数
     * @return String yyyyMM
     * @since 2013-7-1
     */
    public static String getOffsetDateMonth(int offsetDay) {
        return getOffsetDate(offsetDay, "yyyyMM");
    }

    /**
     * 获取当月偏移月份的日期
     * 
     * @param offsetMonth 偏移月份
     * @param format 日期格式
     * @return String
     * @since 2013-7-1
     */
    public static String getOffsetMonth(int offsetMonth, String format) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, offsetMonth);
        return format(c.getTime(), format);
    }

    /**
     * 获取当月偏移月份的日期：格式yyyyMM
     * 
     * @param offsetMonth 偏移月份
     * @return String yyyyMM
     * @since 2013-7-1
     */
    public static String getOffsetMonth(int offsetMonth) {
        return getOffsetMonth(offsetMonth, "yyyyMM");
    }
    
    /**
     * 获取当年偏移年份的日期：格式yyyy
     * 
     * @param offsetYear 偏移年份
     * @return String yyyy
     * @since 2013-7-1
     */
    public static String getOffsetYear(int offsetYear) {
    	Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, offsetYear);
        return format(c.getTime(), "yyyy");
    }

    /**
     * 获得指定追加天数日期的格式化日期
     *
     * @param date 原始日期
     * @return Date
     * @author tzk
     * @since 2009-3-30
     */
    public static Date getEndDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int d = c.get(Calendar.DATE);
        c.set(Calendar.DATE, d + day);
        Date result = c.getTime();
        return result;
    }

    /**
     * 将date类型转换为指定的格式string类型
     * 
     * @param date
     * @param format
     * @return *
     * @author tzk
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将string转换为DATE
     * 
     * @param date
     * @param format
     * @return
     */
    public static Date getDate(String date, String format) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            d = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 获得指定追加分钟日期的格式化日期
     * 
     * @param date 原始日期
     * @return Date
     * @author tzk
     * @since 2009-3-30
     */
    public static Date dateAddMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int d = c.get(Calendar.MINUTE);
        c.set(Calendar.MINUTE, d + minute);
        Date result = c.getTime();
        return DateUtil.getDate(DateUtil.format(result, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date dateAddMinute(int minute) {
        Calendar c = Calendar.getInstance();
        int d = c.get(Calendar.MINUTE);
        c.set(Calendar.MINUTE, d + minute);
        Date result = c.getTime();
        return DateUtil.getDate(DateUtil.format(result, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获得指定追加月数日期的格式化日期
     * 
     * @param date 原始日期
     * @return Date
     * @author tzk
     * @since 2009-3-30
     */
    public static Date getEndMoth(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int d = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, d + num);
        Date result = c.getTime();
        return result;
    }

    /**
     * 将字符串转为时间，再加一个月，再转回为字符串格式返回
     * 
     * @return YYYYMMDD
     */
    public static String monthAdd(String time, int i) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            Date date = simpleDateFormat.parse(time);
            Calendar calender = Calendar.getInstance();
            calender.setTime(date);
            calender.add(Calendar.MONTH, i);
            simpleDateFormat.format(calender.getTime());
            return (simpleDateFormat.format(calender.getTime()).toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return time;
        }
    }

    /**
     * 判断日期是否合法 <功能详细描述>
     * 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean checkDate(String str) {
        SimpleDateFormat dateForma = new SimpleDateFormat("yyyyMM");
        dateForma.setLenient(false);
        try {
            dateForma.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取指定日期所在的月份的最后一天
     * 
     * @author lmq0382
     * @date 2012-4-24
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 本月最大天数
        int dayCount = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, dayCount);
        return c.getTime();
    }

    /**
     * 判断当前时间是否在时间date2之前
     * 
     * @param date2
     * @return
     */
    public static boolean isDateBefore(String date2) {
        try {        	
        	String date = "";
        	if(!date2.contains("-")){
        		date = date2.substring(0, 4) + "-" + date2.substring(4, 6) + "-" + date2.substring(6, 8) + " " + date2.substring(8, 10) + ":" + date2.substring(10, 12) + ":"
        				+ date2.substring(12, 14);        		
        	}else{
        		date = date2;
        	}
            Date date1 = new Date();            
            Date date3 = getDate(date2, "yyyy-MM-dd HH:mm:ss");

            if(date1.getTime()<date3.getTime()){
            	return true;
            }else{
            	return false;
            }
//            return date1.before(df.parse(date));
        } catch (Exception e) {
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }

    /**
     * 获取日期1和日期2之间的月份差
     * 
     * @author lmq0382
     * @date 2012-10-24
     * @param date1
     * @param date2
     * @return 如果日期1大于日期2,返回结果大于0,否则小于或等于0,如201201和201111的结果为2
     */
    public static int getCountMonthBetweenDate(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        int year1 = calendar1.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int year2 = calendar2.get(Calendar.YEAR);
        int month2 = calendar2.get(Calendar.MONTH);
        return (year1 - year2) * 12 + (month1 - month2);
    }

    /**
     * 取得当前月份前的N个月并返回
     * 
     * @author xinghongxin
     * @date 2013-4-1
     * @return
     */
    public static String[] getMonthsBeforeCurrentMonth(int n) {
        String[] months = new String[n];

        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        int j = 0;
        if (currentMonth < n) {
            int lastMonthLength = n - currentMonth;
            for (int i = lastMonthLength; i >= 0; i--) {
                int month = 12 - i;
                months[j] = (currentYear - 1) + "" + (month < 10 ? ("0" + month) : month);
                j++;
            }
            for (int i = 0; i < currentMonth-1; i++) {
            	int month = i + 1;
            	months[j] = currentYear + "" + (month < 10 ? ("0" + month) : month);
            	j++;
            }
        }else{
        	for (int i = currentMonth-n; i < currentMonth; i++) {
            	int month = i;
            	months[j] = currentYear + "" + (month < 10 ? ("0" + month) : month);
            	j++;
            }
        }

        return months;
    }
    
    /**
     * 取得当前月份前的N个月并返回
     * 
     * @author xinghongxin
     * @date 2013-4-1
     * @param n
     * @param orderBy 排序 desc:倒序；asc:升序（默认）
     * @return
     */
    public static String[] getChineseMonthsBeforeCurrentMonth(int n,String orderBy) {
        String[] months = new String[n];

        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH) + 1;
//        int currentMonth = 4;
        int j = 0;
        if (currentMonth < n) {
        	if(orderBy!=null && orderBy.equalsIgnoreCase("desc")){
        		int lastMonthLength = n - currentMonth;
        		for (int i = currentMonth-1; i >0; i--) {
        			int month = i;
        			months[j] = currentYear + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}
        		for (int i = 0; i <= lastMonthLength; i++) {
        			int month = 12 - i;
        			months[j] = (currentYear - 1) + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}
        	}else if(orderBy==null || orderBy.equals("") || orderBy.equalsIgnoreCase("asc")){
        		int lastMonthLength = n - currentMonth;
        		for (int i = lastMonthLength; i >= 0; i--) {
        			int month = 12 - i;
        			months[j] = (currentYear - 1) + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}
        		for (int i = 0; i < currentMonth-1; i++) {
        			int month = i + 1;
        			months[j] = currentYear + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}
        	}
        }else{
        	if(orderBy!=null && orderBy.equalsIgnoreCase("desc")){
        		for (int i = currentMonth-1; i >= currentMonth-n; i--) {
        			int month = i;
        			months[j] = currentYear + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}  
        	}else if(orderBy==null || orderBy.equals("") || orderBy.equalsIgnoreCase("asc")){
        		for (int i = currentMonth-n; i < currentMonth; i++) {
        			int month = i;
        			months[j] = currentYear + "年" + (month < 10 ? ("0" + month) : month) + "月";
        			j++;
        		}        		
        	}
        }

        return months;
    }

    /**
     * 取得指定日期偏移量的月份 <br/>
     * 例如201305：
     * <ul>
     * <li>偏移量为-1，结果为4</li>
     * <li>偏移量为 0，结果为5</li>
     * <li>偏移量为 1，结果为6</li>
     * <ul>
     * 
     * @param date 日期
     * @param format 日期格式
     * @param offset 偏移月份
     * @return String 返回便宜的月份
     * @since 2013-6-24
     */
    public static int getYearOfMonth(String date, String format, int offset) {
        Date d = DateUtil.getDate(date, format);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, offset);
        int mon = c.get(Calendar.MONTH) + 1;
        return mon;
    }
    
	/**
	 * 获取上个星期一的日期 yyyy-MM-dd
	 * @return
	 */
	public static String getLastWeekMonday() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 日子设为星期一
		return format(date.getTime(), "yyyy-MM-dd");
	}
    
	/**
	 * 获取上个星期天的日期 yyyy-MM-dd
	 * @return
	 */
	public static String getLastWeekSunday() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 日子设为星期天
		return format(date.getTime(), "yyyy-MM-dd");
	}
	
	/**
	 * 获取上个星期一的日期 
	 * @return
	 */
	public static String getLastWeekMonday(String format) {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 日子设为星期一
		return format(date.getTime(), format);
	}
    
	/**
	 * 获取上个星期天的日期
	 * @return
	 */
	public static String getLastWeekSunday(String format) {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 日子设为星期天
		return format(date.getTime(), format);
	}

    public static void main(String[] args) {
//    	System.out.println(getCurrentDate("yyyy-MM-dd HH:mm:ss"));    	
//    	Date timestampD = DateUtil.getDate("20130713200000", "yyyyMMddHHmmss");
//    	System.out.println(DateUtil.getMinuteDispersion(DateUtil.getDate(getCurrentDate("yyyyMMddHHmmss"), "yyyyMMddHHmmss"),timestampD));
    	
//    	Date date = DateUtil.convertStringToDate("2013年11月","yyyy年MM月");
//    	
//    	String[] dates = DateUtil.getChineseMonthsBeforeCurrentMonth(6,"desc");
//    	
//    	for (String str : dates) {
//    		System.out.println(str);			
//		}
    	
//    	System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd HH"));
//    	
//    	System.out.println(getDate(getCurrentDate("yyyyMMdd")+"13", "yyyyMMddHH"));
    	
//    	Date getTokenTime = DateUtil.getDate("2014-1-2 08:38:00", "yyyy-MM-dd HH:mm:ss");
//		long l=new Date().getTime()-getTokenTime.getTime();   
//		long day=l/(24*60*60*1000);
//		long hour=(l/(60*60*1000)); 
//		System.out.println(l);
//		System.out.println(getLastWeekMonday());
//		System.out.println(getLastWeekSunday());
//		
//		System.out.println(getOffsetDate(-1,"yyyy-MM-dd"));
		
		System.out.println(getCurrentDate("yyyyMMddHHmmss"));
    	
//    	System.out.println(DateUtil.getOffsetDate(-1,"MM月dd日"));
    }
}
