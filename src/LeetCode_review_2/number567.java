package LeetCode_review_2;

import java.util.HashMap;

public class number567 {
//    s1 = "ab" s2 = "eidbaooo"
    //问题1：用什么表示滑动窗口，数组， map,set?
    //问题2：用什么结构存储要查找的目标字符串
    //问题3：怎么遍历字符串
public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    for(char cur : s1.toCharArray()){
        need.put(cur, need.getOrDefault(cur, 0) + 1);
    }
    int left = 0, right = 0, valid = 0;
    while(right < s2.length()){
        char push = s2.charAt(right);
        right++;
        if(need.containsKey(push)){
            window.put(push, window.getOrDefault(push, 0) + 1);
            if(window.get(push).compareTo(need.get(push)) == 0){
                valid++;
            }
        }
        while(right - left >= s1.length()){
            if(valid == need.size()){
                return true;
            }
            char pop = s2.charAt(left);
            left++;
            if(need.containsKey(pop)){
                if(window.get(push).compareTo(need.get(push)) == 0){
                    valid--;
                }
                window.put(pop, window.get(pop) - 1);
            }
        }
    }
    return false;
}
}
