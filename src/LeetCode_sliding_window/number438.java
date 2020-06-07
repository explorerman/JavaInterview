package LeetCode_sliding_window;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//找到字符串中所有字母异位词
public class number438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (char cur : p.toCharArray()){
            need.put(cur, need.getOrDefault(cur, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()){
            final char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).compareTo(need.get(c)) == 0){
                    valid++;
                }
            }
            //判断窗口是否需要缩容
            while (right - left >= p.length()){
                // 当窗口符合条件时，把起始索引加入 res
                if(valid == need.size()){
                    res.add(left);
                }
                final char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).compareTo(need.get(d)) == 0){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
