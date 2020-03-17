package leetcode_String;

//反转字符串中的单词3
public class number557 {
// 输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc"
    public String reverseWords(String s) {
        if(s.length() < 0) return null;
        String[] str = s.split(" ");
        StringBuilder sb;
        String res = "";
        for (int i = 0; i < str.length; i++) {
            sb = new StringBuilder(str[i]);
            if(str.length - 1 == i){
                res += sb.reverse().toString();
            }else{
                res += sb.reverse().toString() + " ";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new number557().reverseWords("Let's take LeetCode contest");
    }
}
