package LeetCode_sliding_window;

import java.util.HashMap;

//字符串的排列
public class number567 {
    //    s1 = "ab" s2 = "eidbaooo"
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char cur : s1.toCharArray()){
            need.put(cur, need.getOrDefault(cur, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()){
            //1. c是将移入窗口的字符
            //2. 右移窗口
            //3. 进行窗口内的一系列更新
            //4. 判断左右窗口是否需要收缩
            //5.  d 是将移出窗口的字符
            //6. 左移窗口
            //7. 进行窗口内的一系列更新
            final char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).compareTo(need.get(c)) == 0){
                    valid++;
                }
            }

            //debug输出的位置
            System.out.println("window:"+ left + right);
            //重点，根据题不同，则不同，判断左右窗口是否需要收缩
            while (right - left >= s1.length()){ //这儿其实直接写出等于更好理解
                if(valid == need.size()){
                    return true;
                }
                final char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).compareTo(need.get(d)) == 0){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
