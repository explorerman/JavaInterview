package leetcode_String;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 李杰
 * @version 1.0
 * @Description 翻转字符串里的单词
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/28 11:04
 * @title 标题: 翻转字符串里的单词
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number151_1 {
    public String reverseWords(String s) {
        //其中split中“ +”其实是正则表达式，表示可以是多个空格
        //可以换成正则表达式 final String[] sNum = s.trim().split("\\s+");
        final String[] sNum = s.trim().split(" +");
        Collections.reverse(Arrays.asList(sNum));
        return String.join(" " + sNum);
    }


    public static void main(String[] args) {
        new number151_1().reverseWords("  hello  world!  ");
    }
}
