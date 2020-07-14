package LeetCode_tencent;

public class number541 {
    int maxLen = 0;
    public String reverseStr(String s, int k) {
        int period = 2 * k;
        maxLen = period;
        int len = s.length();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < len){
            int end = index + period;
            if(end < len){
                res.append(reverse(s.substring(index, end)));
            }
            else {
                res.append(reverse(s.substring(index, len)));
            }
            index = end;
        }
        return res.toString();
    }

    private String reverse(String substring) {
        StringBuilder sb;
        if(substring.length() < maxLen / 2){
            sb = new StringBuilder(substring);
            return sb.reverse().toString();
        }else {
            final String substring1 = substring.substring(0, maxLen / 2);
            final String substring2 = substring.substring(maxLen / 2, substring.length());
            sb = new StringBuilder(substring1);
            return sb.reverse().toString() + substring2;
        }
    }
}
