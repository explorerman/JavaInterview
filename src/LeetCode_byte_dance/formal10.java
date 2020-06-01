package LeetCode_byte_dance;

import java.util.HashSet;
import java.util.Set;

//找出字符串中没有重复字符的最长子串的长度
//lc的3题,滑动窗口+set
//"abcabcbb"
public class formal10 {
    public int lengthOfLongestSubstring0(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        //right初始化为-1，是说明滑动窗口右边界在最左边，还没有开始滑动
        int right = -1, ans = 0;
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (right + 1 < sLength && !occ.contains(s.charAt(right + 1))) {
                occ.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right + 1 - i);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int right = 0, ans = 0;
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (right < sLength && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - i);
        }
        return ans;
    }
}
