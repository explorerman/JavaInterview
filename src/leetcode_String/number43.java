package leetcode_String;

//字符串相乘
public class number43 {
    public String multiply(String num1, String num2) {

        String res = "";
        char[] numfirst = num1.toCharArray();
        char[] numsecond = num2.toCharArray();
        int m1 = num1.length(), m2 = num2.length();
        int[] temp = new int[m1 + m2];
        for (int i = m1 - 1; i>= 0 ; --i) {
            for (int j = m2 - 1; j >= 0 ; --j) {
                int mul = (numfirst[i] - '0') * (numsecond[j] - '0');
                int p1 = i + j; //p1是高位，因为是倒叙，所以数字越小，位越高
                int p2 = i + j + 1;
                int sum = mul + temp[p2];  //相乘后的数先与低位的数字相加
                temp[p1] += sum / 10;    //如果有进位，则高位+进位
                temp[p2] = sum % 10;     //低位上的数就是余数
            }
        }
        for (int num : temp) {
            if(!res.isEmpty() || num != 0){
                res +=  (num);
            }
        }
        return res.isEmpty()? "0" : res;
    }

    public static void main(String[] args) {
        new number43().multiply("2", "3");
    }
}
