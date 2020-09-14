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
public class DateUtils {
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
        if (date == null)
            return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
        Date lastDayOfWeek = getLastDayOfWeek(date);
        calendar.setTime(lastDayOfWeek);
        int curYear = calendar.get(Calendar.YEAR);
        return curYear;

    }

    /**
     * 功能描述 获取指定日期所在的年份
     *
     * @param * @param date
     * @return {@link int}
     * @name
     * @createTime: 2020/9/8 16:53
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static int getCurYearNum(Date date) {
        if (date == null)
            return 0;
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
        return DateUtils.getFirstDayOfWeek(data);
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
        return DateUtils.getLastDayOfWeek(parse);
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

    /**
     * 求两个时间的间隔差
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static final long daysInterval(Date fromDate, Date toDate) {
        return (toDate.getTime() - fromDate.getTime()) / 86400000L;
    }

    /**
     * 求两个时间的间隔差
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int daysInterval(String fromDate, String toDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(fromDate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(toDate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 功能描述
     *
     * @param *    @param date
     * @param days
     * @return {@link java.util.Date}
     * @name 在当前日期上加 N天,N可以为负
     * @createTime: 2020/9/9 23:17
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date addDate(Date date, int days) {
        Date d = null;
        d = new Date(date.getTime() + (long) (days * 24 * 60 * 60) * 1000L);
        return d;
    }

    /**
     * 功能描述 获取下一天的日期
     *
     * @param * @param date
     * @return {@link java.util.Date}
     * @name
     * @createTime: 2020/9/9 23:18
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 功能描述 获取上一天的日期
     *
     * @param * @param date
     * @return {@link java.util.Date}
     * @name
     * @createTime: 2020/9/9 23:18
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getPreDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 功能描述 根据指定格式，获取日期
     *
     * @param *       @param dateStr
     * @param pattern
     * @return {@link java.util.Date}
     * @name
     * @createTime: 2020/9/9 23:22
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getDateFromStr(String dateStr, String pattern) {
        String p = pattern == null ? "yyyy-MM-dd" : pattern;
        SimpleDateFormat sdf = new SimpleDateFormat(p);
        Date d = null;

        try {
            d = sdf.parse(dateStr);
        } catch (Exception var6) {
        }

        return d;
    }

    /**
     * 根据指定格式，从String获取日期Date，默认格式是yyyy-MM-dd HH:mm:ss
     *
     * @param * @param dateStr
     * @return {@link java.util.Date}
     * @name
     * @createTime: 2020/9/9 23:22
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getDateFromStr(String dateStr) {
        String p = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(p);
        Date d = null;

        try {
            d = sdf.parse(dateStr);
        } catch (Exception var6) {
        }

        return d;
    }

    /**
     * 功能描述 根据指定格式，从Date获取日期String
     *
     * @param *       @param date
     * @param pattern
     * @return {@link java.lang.String}
     * @name
     * @createTime: 2020/9/9 23:24
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String getDateToStr(Date date, String pattern) {
        String p = pattern == null ? "yyyy-MM-dd" : pattern;
        SimpleDateFormat sdf = new SimpleDateFormat(p);
        Date d = date == null ? new Date() : date;
        return sdf.format(d);
    }

    /**
     * 功能描述 从某日期到当前时间的间隔
     *
     * @param * @param fromDate
     * @return {@link long}
     * @name
     * @createTime: 2020/9/9 23:26
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static final long daysInterval(Date fromDate) {
        if (fromDate == null) {
            return 0L;
        } else {
            Date toDate = new Date();
            return daysInterval(fromDate, toDate);
        }
    }

    /**
     * 功能描述 从fromDate到toDate的间隔，间隔单位为：年
     *
     * @param *      @param fromDate
     * @param toDate
     * @return {@link int}
     * @name
     * @createTime: 2020/9/9 23:29
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static final int yearsInterval(Date fromDate, Date toDate) {
        return fromDate != null && toDate != null ? toDate.getYear() - fromDate.getYear() : 0;
    }

    public static final String leftDays(Date fromDate) {
        Date toDate = new Date();
        long l = daysInterval(fromDate, toDate);
        l = l * -1L + 1L;
        return l <= 0L ? "到期" : String.valueOf(l);
    }

    /**
     * 功能描述 从fromDate到当前系统时间的间隔，间隔单位为：年
     *
     * @param * @param fromDate
     * @return {@link int}
     * @name
     * @createTime: 2020/9/9 23:29
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static final int yearsInterval(Date fromDate) {
        if (fromDate == null) {
            return 0;
        } else {
            Date toDate = new Date();
            return yearsInterval(fromDate, toDate);
        }
    }

    /**
     * 功能描述 比较两个时间是否相同
     *
     * @param *  @param d1
     * @param d2
     * @return {@link boolean}
     * @name
     * @createTime: 2020/9/9 23:33
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean compareDate(Date d1, Date d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d1).equals(sdf.format(d2));
    }

    public static String getMinu(int minutes) {
        GregorianCalendar calTmp = new GregorianCalendar();
        calTmp.add(12, -1 * minutes);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(calTmp.getTime());
    }

    public static String getHour(int hours) {
        GregorianCalendar calTmp = new GregorianCalendar();
        calTmp.add(10, -1 * hours);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(calTmp.getTime());
    }

    public static String getDate(int days) {
        GregorianCalendar calTmp = new GregorianCalendar();
        calTmp.add(5, -1 * days);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calTmp.getTime());
    }

    /**
     * 功能描述 获取当前周的第一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getFirstWeek(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(7);
        cal.add(5, cal.getActualMinimum(7) - dayOfWeek + 1);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前周的第一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getFirstWeek(String d) {
        Calendar cal = new GregorianCalendar();
        final Date dateFromStr = getDateFromStr(d, null);
        cal.setTime(dateFromStr);
        int dayOfWeek = cal.get(7);
        cal.add(5, cal.getActualMinimum(7) - dayOfWeek + 1);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前周的最后一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getLastWeek(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(7);
        cal.add(5, cal.getActualMaximum(7) - dayOfWeek + 1);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前周的最后一天, 参数为String
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getLastWeek(String d) {
        Calendar cal = new GregorianCalendar();
        final Date dateFromStr = getDateFromStr(d, null);
        cal.setTime(dateFromStr);
        int dayOfWeek = cal.get(7);
        cal.add(5, cal.getActualMaximum(7) - dayOfWeek + 1);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前月的第一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getFirstMonth(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(5);
        cal.add(5, cal.getActualMinimum(5) - dayOfWeek);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前月的第一天,参数是String
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getFirstMonth(String d) {
        Calendar cal = new GregorianCalendar();
        final Date dateFromStr = getDateFromStr(d, null);
        cal.setTime(dateFromStr);
        int dayOfWeek = cal.get(5);
        cal.add(5, cal.getActualMinimum(5) - dayOfWeek);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前月的最后一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getLastMonth(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(5);
        cal.add(5, cal.getActualMaximum(5) - dayOfWeek);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前月的最后一天，参数为String
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getLastMonth(String d) {
        Calendar cal = new GregorianCalendar();
        final Date dateFromStr = getDateFromStr(d, null);
        cal.setTime(dateFromStr);
        int dayOfWeek = cal.get(5);
        cal.add(5, cal.getActualMaximum(5) - dayOfWeek);
        return cal.getTime();
    }



    /**
     * 功能描述 获取当前年的第一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getFirstYear(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(6);
        cal.add(5, cal.getActualMinimum(6) - dayOfWeek);
        return cal.getTime();
    }

    /**
     * 功能描述 获取当前年的最后一天
     *
     * @param * @param d
     * @return {@link Date}
     * @name
     * @createTime: 2020/9/9 23:32
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Date getLastYear(Date d) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dayOfWeek = cal.get(6);
        cal.add(5, cal.getActualMaximum(6) - dayOfWeek);
        return cal.getTime();
    }

    public static void main(String[] args) {
        // 其日历字段已由当前日期和时间初始化：
        Calendar rightNow = Calendar.getInstance(); // 子类对象
        // 获取年
        int year = rightNow.get(Calendar.YEAR);
        // 获取月
        int month = rightNow.get(Calendar.MONTH);
        // 获取日
        int date = rightNow.get(Calendar.DATE);
        //获取几点
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        //获取几分
        int minute = rightNow.get(Calendar.MINUTE);
        //获取几秒
        int second = rightNow.get(Calendar.SECOND);
        //获取上午下午
        int moa = rightNow.get(Calendar.AM_PM);
        if (moa == 1) {
            System.out.println("下午");
        } else {
            System.out.println("上午");
        }

        System.out.println(year + "年" + (month + 1) + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒");
        rightNow.add(Calendar.YEAR, 5);
        rightNow.add(Calendar.DATE, -10);
        int year1 = rightNow.get(Calendar.YEAR);
        int date1 = rightNow.get(Calendar.DATE);
        System.out.println(year1 + "年" + (month + 1) + "月" + date1 + "日" + hour + "时" + minute + "分" + second + "秒");

        System.out.println(DateUtils.getFirstYear(new Date()));
        System.out.println(DateUtils.getLastYear(new Date()));
        System.out.println(DateUtils.getFirstMonth(new Date()));
        System.out.println(DateUtils.getLastMonth(new Date()));
        System.out.println(DateUtils.getFirstWeek(new Date()));
        System.out.println(DateUtils.getLastWeek(new Date()));

        System.out.println(DateUtils.getHour(2));

        final Date dateFromStr = getDateFromStr("2020-09-14 18:3:54", null);
        System.out.println(dateFromStr);
    }
}
