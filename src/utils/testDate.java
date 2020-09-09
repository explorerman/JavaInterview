package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试时间类
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/9 17:20
 * @title 标题: 测试时间类
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class testDate {
    public static Date getDefaultBeginTime(String beginTime) throws Exception {
        String begin[] = beginTime.split(" ");
        String defaultBeginTimeStr = begin[0] + " " + "08:30";
        Date defaultBeginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(defaultBeginTimeStr);//默认首日开始时间表
        return defaultBeginTime;
    }

    public static int daysBetween(String smdate, String bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static final long daysInterval(Date fromDate, Date toDate) {
        return (toDate.getTime() - fromDate.getTime()) / 86400000L;
    }

    public static Date addDate(Date date, int days) {
        Date d = null;
        d = new Date(date.getTime() + (long)(days * 24 * 60 * 60) * 1000L);
        return d;
    }
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String format = sdf.format(date);
        System.out.println(format);
        Date cur = getDefaultBeginTime(format);
        System.out.println(cur);
        final int yearNum = DateUtils.getYearNum(date);
        System.out.println(yearNum);

        String start = "2020-09-09";
        String end = "2020-09-11";
        final int i = daysBetween(start, end);
        System.out.println(i);

        final long l = daysInterval(new Date(), addDate(new Date(), 2));
        System.out.println(l);
    }
}
