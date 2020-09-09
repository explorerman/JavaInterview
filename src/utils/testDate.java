package utils;

import java.text.SimpleDateFormat;
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
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String format = sdf.format(date);
        System.out.println(format);
        final int yearNum = DateUtils.getYearNum(date);
        System.out.println(yearNum);
    }
}
