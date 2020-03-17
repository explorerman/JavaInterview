package leetcode_String;
//验证回文串
public class number125 {
    //输入: "A man, a plan, a canal: Panama"
    //输出: true
    //只考虑字符和数字

    //解题思路：将非数字，字母去掉，然后转成字符串数组，比较.
    public boolean isPalindrome(String s) {
        int length = s.length();
        if(length == 0) return true;
        char[] newS = s.toLowerCase().trim().replaceAll("[\\p{Punct}\\s]+","").toCharArray();
        int left = 0, right = newS.length - 1;
        while (left <= right){
            if(newS[left++] != newS[right--]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new number125().isPalindrome("A man, a plan, a canal: Panama");
    }
}
