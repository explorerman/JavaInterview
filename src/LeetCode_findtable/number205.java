package LeetCode_findtable;

import java.util.HashMap;
import java.util.HashSet;

public class number205 {

    //参考链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
    //执行用时 :
    //38 ms, 在所有 Java 提交中击败了23%的用户
    //内存消耗 :
    //42.2 MB, 在所有 Java 提交中击败了5.39%的用户
    public boolean isIsomorphic(String s, String t) {
       int n = s.length();
       int[] mapS = new int[256];
       int[] mapT = new int[256];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(mapS[c1] != mapT[c2]){
                return false;
            }else {
                if(mapS[c1] == 0){
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }

    //方法2：我们只需要验证 s - > t 和 t -> s 两个方向即可。
    //执行用时 :
    //10 ms, 在所有 Java 提交中击败了65.45%的用户
    //内存消耗 :
    //38.2 MB, 在所有 Java 提交中击败了8.25%的用户
    public boolean isIsomorphic2(String s, String t){
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }
    public boolean isIsomorphicHelper(String s, String t){
        int n = s.length();
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(!map.containsKey(c1)){
                map.put(c1,c2);
            }else{
                if(map.get(c1) != c2){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new number205().isIsomorphic("egg","eoo");
    }
}
