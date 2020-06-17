package LeetCode_review_2;

public class number2_3 {
    public static String addTwoNumbers(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String res = "";
        int carry = 0;
        while (len1 > 0 || len2 > 0) {
            int str1Num = (len1  > 0) ? str1.charAt(len1 - 1) - '0' : 0;
            int str2Num = (len2  > 0) ? str2.charAt(len2 - 1) - '0' : 0;
            int sum = str1Num + str2Num + carry;
            carry = sum / 10;
            res += sum % 10 + "";
            len1--;
            len2--;
        }
        if (carry > 0) {
            res += carry + "";
        }
        StringBuilder sb = new StringBuilder(res);
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();

    }
    public static void main(String[] args) {
        addTwoNumbers("789", "11");
    }

}
