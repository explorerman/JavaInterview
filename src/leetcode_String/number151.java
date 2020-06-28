package leetcode_String;

import java.util.LinkedList;

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
public class number151 {
    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (s.length() <= 0) return "";
        final String[] sNums = s.split(" ");
        if (sNums.length <= 0) return "";
        for (String cur : sNums) {
            String temp = cur.trim();
            if (temp.length() != 0) {
                list.addFirst(temp);
                list.addFirst(" ");
            }
        }
        list.remove(0);
        for (String cur : list) {
            sb.append(cur);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        new number151().reverseWords("  hello world!  ");
    }
}
