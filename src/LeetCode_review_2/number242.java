package LeetCode_review_2;

import java.util.Arrays;
//有效的字母异位词
public class number242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if(sChars[i] != tChars[i]) return false;
        }
        return true;
    }
}
