package LeetCode_findtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//有效的字母异位词
public class number242 {
    //输入: s = "anagram", t = "nagaram"
    //输出: true
    //使用hashmap,将s中的字符加入map，中在t中查找，如果没有相同的key,则直接返回false，如果有，则将value-1，最后如果
    //map中还有值，则说明不满足情况。
    //执行用时 :
    //23 ms, 在所有 Java 提交中击败了19.60%的用户
    //内存消耗 :
    //41.8 MB, 在所有 Java 提交中击败了5.01%的用户
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == t.length() && s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char cur: chars) {
            if(!map.containsKey(cur)){
                map.put(cur, 1);
            }else{
                map.put(cur,map.get(cur)+1);
            }
        }
        char[] chart = t.toCharArray();
        for (char cur : chart) {
          if(!map.containsKey(cur)){
              return false;
          }else{
              map.put(cur,map.get(cur) -1);
              if(map.get(cur) == 0){
                  map.remove(cur);
              }
          }
        }
        if(map.size() > 0){
            return false;
        }else{
            return true;
        }
    }
         //执行用时 :
         //4 ms, 在所有 Java 提交中击败了84.79%的用户
        //内存消耗 :
       //41 MB, 在所有 Java 提交中击败了5.01%的用户
    //先排序，然后挨着比较
    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length()) return false;
        if(s.length() == t.length() && s.length() == 0) return true;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int length = chars.length;
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < length; i++) {
            if(chars[i] != chart[i]){
                return false;
            }
        }
        return true;
    }
}
