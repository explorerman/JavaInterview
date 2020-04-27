package java_basic;

import java.util.Date;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/27 12:12
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class test {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now.getTime());
        System.out.println(now.getTime() / 1000L);
    }


}
