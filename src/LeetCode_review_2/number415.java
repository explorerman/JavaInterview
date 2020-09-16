package LeetCode_review_2;

public class number415 {
    public static String addTwoNumbers(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        //进位
        int carry = 0;

        //反转，方便操作
        str1 = (new StringBuilder(str1)).reverse().toString();
        str2 = (new StringBuilder(str2)).reverse().toString();

        //当前位的数 res = one + two + carry
        int loopNum = Math.max(len1, len2);
        for (int i = 0; i <= loopNum; i++) {
            int one = i > len1 ? 0 : Integer.parseInt(str1.charAt(i) + "");
            int two = i > len2 ? 0 : Integer.parseInt(str2.charAt(i) + "");
            int res = one + two + carry;
            carry = res / 10;
            int num = res % 10;
            sb.append(num);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addTwoNumbers("789", "11");
    }
}
