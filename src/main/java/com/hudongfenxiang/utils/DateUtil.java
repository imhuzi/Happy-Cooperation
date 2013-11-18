/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.utils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @FileName : DateUtil.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.cms.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-8-13, 5:31:27
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *
 */
public class DateUtil {

    private Calendar calendar;
    private final DateFormat df_date = DateFormat.getDateInstance();
    private final DateFormat df_time = DateFormat.getTimeInstance();
    private final String[] WEEKNAME_CHINESE = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private final String[] WEEKNAME_ENGLISH_LONG = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private final String[] WEEKNAME_ENGLISH_SHORT = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private final String[] MONTHNAME_ENGLISH_LONG = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final String[] MONTHNAME_ENGLISH_SHORT = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public final static int YEAR = Calendar.YEAR;
    public final static int MONTH = Calendar.MONTH;
    public final static int DAY = Calendar.DAY_OF_MONTH;
    public final static int HOUR = Calendar.HOUR_OF_DAY;
    public final static int MINUTE = Calendar.MINUTE;
    public final static int SECOND = Calendar.SECOND;

    /**
     * 构造函数.
     */
    public DateUtil() {
        calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    }

    /**
     * 构造函数.
     *
     * @param calendar Calendar 实例.
     */
    public DateUtil(Calendar calendar) {
        this.calendar = calendar;
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    }

    /**
     * 构造函数.
     *
     * @param strDate 字符串形式的日期.
     */
    public DateUtil(String strDate) {
        try {
            this.calendar = Calendar.getInstance();
            this.calendar.setTime(DateFormat.getDateTimeInstance().parse(strDate));
            calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        } catch (Exception e) {
            System.out.println("转换日期出错!");
        }

    }

    /**
     * 设置 Calendar 实例.
     *
     * @param calendar Calendar 实例.
     */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    }

    /**
     * 获得日期.
     *
     * @return 日期. 格式 "2005-4-11"
     */
    public String getDate() {
        String theResult = "";
        theResult = getDate(false);
        return theResult;
    }

    /**
     * 获得日期. fixupLength 为 true 时,日期格式为: 2005-03-01 fixupLength 为 false 时,日期格式为:
     * 2005-3-1
     *
     * @param fixupLength 日期格式. fixupLength 为 true 时,日期格式为: 2005-03-01
     * fixupLength 为 false 时,日期格式为: 2005-3-1
     * @return 日期. 格式 "2005-04-11"
     */
    public String getDate(boolean fixLength) {
        String theResult = "";
        if (fixLength) {
            String strMonth = String.valueOf(this.getMonth());
            String strDay = String.valueOf(this.getDay());
            theResult = this.getYear()
                    + "-"
                    + (strMonth.length() < 2 ? ("0" + strMonth) : strMonth)
                    + "-"
                    + (strDay.length() < 2 ? ("0" + strDay) : strDay);
        } else {
            theResult = df_date.format(calendar.getTime());
        }
        return theResult;
    }

    /**
     * 年.
     *
     * @return 年.
     */
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 月.
     *
     * @return 月.
     */
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 月份的英语完整表述.
     *
     * @return 月份.
     */
    public String getMonthForEnglishLong() {
        return MONTHNAME_ENGLISH_LONG[this.getMonth() - 1];
    }

    /**
     * 月份的英语简短表述.
     *
     * @return 月份.
     */
    public String getMonthForEnglishShort() {
        return MONTHNAME_ENGLISH_SHORT[this.getMonth() - 1];
    }

    /**
     * 月份的第几天.
     *
     * @return 月份的第几天.
     */
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 星期几, 数字表述.
     *
     * @return 星期几.
     */
    public int getWeek() {
        int theResult;
        theResult = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        theResult = theResult == 0 ? 7 : theResult;
        return theResult;
    }

    /**
     * 星期几, 中文表述.
     *
     * @return 星期几, 中文表述.
     */
    public String getWeekForChinese() {
        return WEEKNAME_CHINESE[this.getWeek() - 1];
    }

    /**
     * 星期几, 英语的完整表述.
     *
     * @return 星期几, 英语的完整表述.
     */
    public String getWeekForEnglishLong() {
        return WEEKNAME_ENGLISH_LONG[this.getWeek() - 1];
    }

    /**
     * 星期几, 英语的简短表述.
     *
     * @return 星期几, 英语的简短表述.
     */
    public String getWeekForEnglishShort() {
        return WEEKNAME_ENGLISH_SHORT[this.getWeek() - 1];
    }

    /**
     * 时间. 格式: 8:23:25.
     *
     * @return 时间.
     */
    public String getTime() {
        //String theResult = "";
        //theResult = df_time.format(calendar.getTime());
        return getTime(false);
    }

    /**
     * 时间. 格式:08:23:25.
     *
     * @param fixLength
     * @return
     */
    public String getTime(boolean fixLength) {
        String theResult = "";
        if (fixLength) {
            String strHour = String.valueOf(this.getHour());
            String strMinute = String.valueOf(this.getMinute());
            String strSecond = String.valueOf(this.getSecond());
            theResult = (strHour.length() < 2 ? ("0" + strHour) : strHour)
                    + ":"
                    + (strMinute.length() < 2 ? ("0" + strMinute) : strMinute)
                    + ":"
                    + (strSecond.length() < 2 ? ("0" + strSecond) : strSecond);
        } else {
            theResult = df_time.format(calendar.getTime());
        }
        return theResult;
    }

    /**
     * 小时. 24 小时制.
     *
     * @return 小时.
     */
    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 分钟.
     *
     * @return 分钟.
     */
    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 秒数.
     *
     * @return 秒数.
     */
    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 日期时间. 格式"2005-04-11 17:37:55"
     *
     * @return 日期时间. 格式"2005-04-11 17:37:55"
     */
    public String getDateTime() {
        return this.getDate(true) + " " + this.getTime(true);
    }

    /**
     * 获得日期对象的毫秒数.
     *
     * @return 日期对象的毫秒数.
     */
    public long getMillionSecone() {
        return this.calendar.getTime().getTime();
    }

    /**
     * 获得日期对象.
     *
     * @return 日期对象.
     */
    public Date getDateObject() {
        return this.calendar.getTime();
    }

    /**
     * 日期加减.
     *
     * @param field 段
     * @param amount 值.
     */
    public void add(int field, int amount) {
        switch (field) {
            case YEAR:
                calendar.add(YEAR, amount);
                break;
            case MONTH:
                calendar.add(MONTH, amount);
                break;
            case DAY:
                calendar.add(DAY, amount);
                break;
            case HOUR:
                calendar.add(HOUR, amount);
                break;
            case MINUTE:
                calendar.add(MINUTE, amount);
                break;
            case SECOND:
                calendar.add(SECOND, amount);
                break;
        }
    }

    public static void main(String[] args) {
//    	  String s = DateUtil.getStrOfTime(100000);

        DateUtil du = new DateUtil("2008-01-01 01:00:00");
//        System.out.println(du.getDate(true));
//        System.out.println(du.getTime());
//        du.add(DateUtil.MINUTE, -3);
//
        System.out.println(du.getDate(true));
        System.out.println(du.getMillionSecone());
        /*
         try
         {
         Thread.sleep(3000);
         }catch(Exception e){}
         du.setCalendar(Calendar.getInstance());
         System.out.println(du.getTime());
         Calendar calendar = Calendar.getInstance();
         calendar.setFirstDayOfWeek(2);
         System.out.println(calendar.getFirstDayOfWeek());

         du.add(du.HOUR, 2);
         System.out.println(du.getYear());
         System.out.println(du.getMonth());
         System.out.println(du.getDay());
         System.out.println(du.getWeek());
         System.out.println(du.getWeekForChinese());
         System.out.println(du.getWeekForEnglishShort());
         System.out.println(du.getWeekForEnglishLong());
         System.out.println(du.getMonthForEnglishLong());
         System.out.println(du.getMonthForEnglishShort());
         */
    }
}
