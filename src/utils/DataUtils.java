package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 李杰
 * @version 1.0
 * @Description 日期工具类，根据给定日期用于确定当前日期所处的天，周等，获取当前年，周等
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/8 17:09
 * @title 标题: 日期工具类，根据给定日期用于确定当前日期所处的天，周等，获取当前年，周等
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class DataUtils {
    /**
     * 取得当前日期所在的周数
     */
    public static int getCurWeekNum() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(new Date());
        int curWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return curWeek;
    }

    /**
     * 取得当前日期所在的年份
     */
    public static int getCurYear() {
        int curYear = getYearNum(new Date());
        return curYear;

    }

    /**
     * 取得指定日期所在周的年份
     */
    public static int getYearNum(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
        Date lastDayOfWeek = getLastDayOfWeek(date);
        calendar.setTime(lastDayOfWeek);
        int curYear = calendar.get(Calendar.YEAR);
        return curYear;

    }

    /**
     * 功能描述
     *
     * @param * @param date
     * @return {@link int}
     * @name 获取指定日期所在的年份
     * @createTime: 2020/9/8 16:53
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static int getCurYearNum(Date date) {
        if (date == null) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String curYear = sdf.format(date);
        return Integer.valueOf(curYear);
    }


    /**
     * 取得指定日期所在的周数
     */
    public static int getWeekNum(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.setMinimalDaysInFirstWeek(4);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * 取得指定日期所在周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
        int d = 0;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - calendar.get(Calendar.DAY_OF_WEEK);
        }
        calendar.add(Calendar.DAY_OF_WEEK, d);
        return calendar.getTime();
    }

    /**
     * 取得指定日期所在周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(4);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }


    /**
     * 取得指定日期的前n天
     */
    public static Date getLastDate(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 指定年份和周数   取得这周的第一天
     */
    public static Date getFirstDayOfWeek(int year, int week) throws ParseException {

        int curWeek = getMaxWeekNumOfYear(year);
        if (week % curWeek >= 1 && week > curWeek) {
            week = week % curWeek;
            year = year + 1;
        }
        Calendar c = Calendar.getInstance();
        c.setMinimalDaysInFirstWeek(4);

        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(c.getTime());
        Date data = sdf.parse(s);
        return DataUtils.getFirstDayOfWeek(data);
    }


    /**
     * 指定年份和周数   取得这周的最后一天
     */
    public static Date getLastDayOfWeek(int year, int week) throws ParseException {

        int curWeek = getMaxWeekNumOfYear(year);
        if (week % curWeek >= 1 && week > curWeek) {
            week = week % curWeek;
            year = year + 1;
        }

        Calendar c = Calendar.getInstance();
        c.setMinimalDaysInFirstWeek(4);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(c.getTime());
        Date parse = sdf.parse(s);
        return DataUtils.getLastDayOfWeek(parse);
    }

    /**
     * 获取某一年最大的周数
     *
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        c.setMinimalDaysInFirstWeek(4);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getActualMaximum(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前时间在当前年的周数
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(4);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static void main(String[] args) {
        final int curYearNum = DataUtils.getCurYearNum(new Date());
        final int YearNum = DataUtils.getYearNum(new Date());
        System.out.println(curYearNum);
        System.out.println(YearNum);
    }
}
