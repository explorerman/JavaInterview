package LeetCode_review_2;

public class number2_1 {
    public static String addTwoNumbers(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int carry = 0;
        //存放结果
        StringBuilder sb = new StringBuilder();
        //方便理解，将str1，str2都翻转
        str1 = (new StringBuilder(str1)).reverse().toString();
        str2 = (new StringBuilder(str2)).reverse().toString();
        int loopLen = Math.max(len1, len2);
        for (int i = 0; i < loopLen; i++) {
//            int str1Num = i > len1 -1 ? 0 : Integer.parseInt(str1.charAt(i) + "");
            int str1Num = i > len1 - 1 ? 0 : str1.charAt(i) - '0';
            int str2Num = i > len2 - 1 ? 0 : Integer.parseInt(str2.charAt(i) + "");
            int sum = str1Num + str2Num + carry;
            carry = sum / 10;
            int num = sum % 10;
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
