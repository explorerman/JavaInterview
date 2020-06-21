package leetcode_String;

//字符串相加
public class number415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        //进位，切记进位要参与运算
        int carry = 0;
        //确定谁是要遍历的最长长度
        int loopLen = Math.max(len1, len2);
        //因为计算要从末尾计算，所以可以先将题目给的字符串反转，然后从头开始计算，方便一些
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        for(int i = 0; i < loopLen; i++){
            //求当前位置的数字，因为字符串可能一长一短，所以需要判断长度差的数字，超出短字符串的部分直接赋给0，继续参与运算
            int num1_x = i > len1 - 1 ? 0 : num1.charAt(i) - '0';
            int num2_y = i > len2 - 1 ? 0 : num2.charAt(i) - '0';
            //因为有进位，所以要参与运算
            int sum = num1_x + num2_y + carry;
            //更新进位，下个位置加时要使用
            carry = sum / 10;
            //当前位置真正的数字
            int curNum = sum % 10;
            //拼接已经填好的数字
            sb.append(curNum);
        }
        //因为高位可能也有进位，所以需要在判断一下，如果有进位直接追加
        if(carry != 0){
            sb.append(carry);
        }
        //因为我们是反转相加的，自然结果也要反转回来
        return sb.reverse().toString();
    }
}
