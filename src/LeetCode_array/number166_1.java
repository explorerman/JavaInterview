package LeetCode_array;

import java.util.HashMap;

/**
 * @author 李杰
 * @version 1.0
 * @Description 分数到小数，两数相除，
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/11 11:34
 * @title 标题: 分数到小数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number166_1 {
    // 输入: numerator = 2, denominator = 3
    //输出: "0.(6)"
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        //如果除数和被除数，有一个负数，则前面加“-”,等价于true为1，false为0
        if(numerator < 0 ^ denominator < 0){
            fraction.append("-");
        }
        //将int转为long，防止数组越界
        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        //余数
        long remainder = dividend % divisor;
        if(remainder == 0){
            return fraction.toString();
        }
        fraction.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0){
            if(map.containsKey(remainder)){
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append((String.valueOf(remainder / divisor)));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        int a = -1, b = -1;
        if(a < 0 ^ b < 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        boolean aa = false;
        boolean bb = false;
        if(aa ^ bb){
            System.out.println(true);
        }
    }
}
