package java_function_programming;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 函数式编程，例子1
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/14 15:12
 * @title 标题: 函数式编程，例子1
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class fp_1 {
    public static void main(String[] args) {
        String[] array = {"orange", "Pear","Apple"};
        Arrays.sort(array, String::compareToIgnoreCase);
        System.out.println(array);
    }
}
