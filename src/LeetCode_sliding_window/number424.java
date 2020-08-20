package LeetCode_sliding_window;

/**
 * @author 李杰
 * @version 1.0
 * @Description 替换后的最长重复字符
 * 滑动窗口
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/20 11:33
 * @title 标题: 替换后的最长重复字符
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

public class number424 {
//    int[26]来存储当前窗口中各个字母的出现次数
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] window = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
//        historyCharMax保存滑动窗口内相同字母出现次数的历史最大值，
//        通过判断窗口宽度(right - left + 1)是否大于historyCharMax + K来决定窗口是否做滑动，否则窗口就扩张
        int historyCharMax = 0;
        for (; right < chars.length; right++) {
            int index = chars[right] - 'A';
            window[index]++;
            historyCharMax = Math.max(historyCharMax, window[index]);
            //如果当前字符串中的出现次数最多的字母个数+K大于串长度，那么这个串就是满足条件的
            //if (right - left + 1 - k > historyCharMax) 若长度过大
            if (right - left + 1 > historyCharMax + k) {
                window[chars[left] - 'A']--; //缩小窗口
                left++;
            }
        }
        //可以写成 right - left;
        return chars.length - left;
    }

}
