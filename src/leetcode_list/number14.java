package leetcode_list;

public class number14 {
    //思路就是暴力破解，对比每个字符串的值，注意两个点：1.每个串的长度可能不一样，2.如果有一个串的值与前面的不相同，则直接return就行。
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String res = "";
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;


    }
    public static void main(String[] args) {
        String[] strs = {"c","c","c"};
        System.out.println(longestCommonPrefix(strs));
    }
}
