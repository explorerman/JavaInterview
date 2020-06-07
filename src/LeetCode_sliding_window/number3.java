package LeetCode_sliding_window;

import java.util.HashMap;

//无重复字符的最长子串
//本题不需要need窗口，只需要window窗口
public class number3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = Integer.MIN_VALUE;
        while (right < s.length()){
            final char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            //判断窗口是否需要缩容
            while (window.get(c) > 1){
                final char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            //更新长度
            res = Math.max(res, right - left);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
