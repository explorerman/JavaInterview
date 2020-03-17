package LeetCode_findtable;

import java.util.HashMap;
import java.util.Map;

//同构字符串
public class number290 {

    //方法跟205的一样，我们只需要验证 s - > t 和 t -> s 两个方向即可。
    //执行用时 :
    //1 ms, 在所有 Java 提交中击败了97。92%的用户
    //内存消耗 :
    //37.4 MB, 在所有 Java 提交中击败了5.25%的用户
    public boolean wordPattern(String pattern, String str){
        return wordPatternHelper(pattern,str) && wordPatternHelper2(str,pattern);
    }
    public boolean wordPatternHelper(String pattern, String str) {
        int n = pattern.length();
        String[] strList = str.split(" ");
        if(n != strList.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = pattern.charAt(i);
            String c2 = strList[i];
            if(!map.containsKey(c1)){
                map.put(c1,c2);
            }else{
                if(!map.get(c1).equals(c2)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPatternHelper2(String pattern, String str) {
        int n = str.length();
        String[] strList = pattern.split(" ");
        if(n != strList.length) return false;
        HashMap<String,Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String c1 = strList[i];
            char c2 = str.charAt(i);
            if(!map.containsKey(c1)){
                map.put(c1,c2);
            }else{
                if(!map.get(c1).equals(c2)){
                    return false;
                }
            }
        }
        return true;
    }

    //使用hashmap的映射，方法与上面一样，只是加了一行判断if(map.containsValue(s[i])) return false; 如果未映射，s[i]已经使用，则不匹配返回false
    //是为了应对：abba, dog,dog,dog,dog的情况
    public boolean wordPattern2(String pattern, String str) {
        String[] s = str.split(" "); //以空格分隔str
        if(s.length != pattern.length()) return false; //如果没有全部成对的映射则返回false
        Map<Character, String> map = new HashMap<>(); //存放映射
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){ //1. 没有映射时执行
                if(map.containsValue(s[i])) return false; //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                map.put(pattern.charAt(i), s[i]); //3. 构建映射
            }else{
                if(!map.get(pattern.charAt(i)).equals(s[i])) return false; //当前字符串与映射不匹配,返回false
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new number290().wordPattern("abba","dog dog dog dog"));
    }
}
