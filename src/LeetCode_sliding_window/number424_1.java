package LeetCode_sliding_window;

/**
 * @author 李杰
 * @version 1.0
 * @Description 替换后的最长重复字符
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/20 14:31
 * @title 标题: 替换后的最长重复字符
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number424_1 {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        int[] window = new int[26];

        int right = 0, left = 0, freq = 0, len = 0;
        char str[] = s.toCharArray();
        while (right < str.length) {
            int ch = str[right++] - 'A';
            window[ch]++;
            freq = Math.max(window[ch], freq);
            while (right - left - freq > k) {
                ch = str[left++] - 'A';
                window[ch]--;
                if (window[ch] == freq) freq--;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
