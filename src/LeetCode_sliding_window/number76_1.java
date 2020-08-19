package LeetCode_sliding_window;

import java.util.HashMap;

//最小覆盖字串
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC"
public class number76_1 {
    public String minWindow(String s, String t) {
        //存放t中的字符
        HashMap<Character, Integer> need = new HashMap<>();
        //将t中的字符，初始化到need中
        for (char cur : t.toCharArray()) {
            need.put(cur, need.getOrDefault(cur, 0) + 1);
        }
        //window中存放s中的字符，用于匹配need中的字符，注意window窗口是左开右闭
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        //valid表示窗口中满足need条件的字符个数，如果valid和need.size的大小相同，则说明窗口已满足条件，已经完全覆盖了串T
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            final char c = s.charAt(right);
            //右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).compareTo(need.get(c)) == 0) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                final char d = s.charAt(left);
                //左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d)) == 0) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        new number76_1().minWindow("ADOBECODEBANC","ABC");
    }
}
