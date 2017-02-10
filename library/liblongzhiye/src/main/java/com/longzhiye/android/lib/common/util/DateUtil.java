package com.longzhiye.android.lib.common.util;

import android.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间通用包
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:07
 */
public class DateUtil {

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str = format.format(date);
        return str;
    }


    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String[] DateToStr4(String date) {
        return date.split("-");
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            try {
                date = format.parse(str);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate1(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            try {
                date = format.parse(str);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获得当前时间
     *
     * @return
     */
    public static String getNowDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 以友好的方式显示时间
     *
     * @param sdate
     * @return
     */
    public static String friendlyTime(String sdate) {
        Date time = StrToDate(sdate);
        if (time == null) {
            return "时间错误";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2 && days <= 10) {
            ftime = days + "天前";
        } else if (days > 10) {
            ftime = dateFormater2.get().format(time);
        }
        return ftime;
    }


    public static String getAfterDate(String curDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM/dd");
        Date date = null;
        try {
            try {
                date = format.parse(curDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();

        return format.format(date);
    }


    public static String getBeforeDate(String curDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM/dd");
        Date date = null;
        try {
            try {
                date = format.parse(curDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();

        return format.format(date);
    }


    public static boolean isBCurrentDate(String curDate){
        SimpleDateFormat format_1 = new SimpleDateFormat("yyyy-MM/dd");
        Date date = null;
        try {
            try {
                date = format_1.parse(curDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Date date_cur = new Date();
        Calendar calendar_cur = Calendar.getInstance();
        calendar_cur.setTime(date_cur);

        LogUtil.e("e", calendar.get(Calendar.MONTH) + "_" + calendar_cur.get(Calendar.MONTH) + "_" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + calendar_cur.get(Calendar.DAY_OF_MONTH));
        boolean flag = false;
        if(calendar.get(Calendar.YEAR) == calendar_cur.get(Calendar.YEAR) &&
                calendar.get(Calendar.MONTH) == calendar_cur.get(Calendar.MONTH) &&
                calendar.get(Calendar.DAY_OF_MONTH) == calendar_cur.get(Calendar.DAY_OF_MONTH)){
            flag = true;
        }
        return flag;
    }

    //yymmdd 151124
    public static String getYYMMDD(String curDate){
        SimpleDateFormat format_1 = new SimpleDateFormat("yyyy-MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        Date date = null;
        try {
            try {
                date = format.parse(curDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return format_1.format(date);
    }

    public static long getNowTime() {
        return System.currentTimeMillis();
    }

}
