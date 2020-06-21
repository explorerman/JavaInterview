package leetcode_String;

//字符串相乘
public class number43_1 {
    public String multiply(String num1, String num2) {
        //存放结果集
        StringBuilder sb = new StringBuilder();
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        //大数相乘的结果数组，两数相乘，乘积位数最大不会超过两数位数之和
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0 ; j--) {
                int product = (num1Char[i] - '0') * (num2Char[j] - '0');
                //索引位从左到右递增，最左为0，为最位，右边为最低位
                int pHigh = i + j;
                int pLow = i + j + 1;
                //两位相乘后的结果等于：两个数相乘 + 当前结果集位上的值
                //跟两数相加一样，也会有进位
                int sum = product + res[pLow];
                //当前低位存储的值,因为低位已经参与了和的运算，所以这时候更新低位就行
                res[pLow] = sum % 10;
                //高位没有参与运算，所以需要在原来高位的基础上加上新的值
                res[pHigh] += sum / 10;
            }
        }
        //因为res前面可能有空位，需要将空位去掉
        int i = 0;
        //找到第一个非0的数
        while (i < res.length && res[i] == 0) i++;
        //将res数组中的元素放入结果sb中
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }
        //判断边界：如果最后sb是空，说明没有元素，直接返回"0",否则返回sb字符串
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        new number43_1().multiply("2", "3");
    }
}
