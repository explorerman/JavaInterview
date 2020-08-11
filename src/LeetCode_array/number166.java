package LeetCode_array;

import java.util.HashMap;
import java.util.Map;

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
public class number166 {
    // 输入: numerator = 2, denominator = 3
    //输出: "0.(6)"
    //核心思想是当余数出现循环的时候，对应的商也会循环。
    //需要用一个哈希表记录余数出现在小数部分的位置，当你发现已经出现的余数，就可以将重复出现的小数部分用括号括起来。
    //再出发过程中余数可能为 0，意味着不会出现循环小数，立刻停止程序。
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        //使用异或来 处理正负号，一正一负取负号
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        //转化为long，防止数字溢出
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        //追加整数部分
        fraction.append(String.valueOf(dividend / divisor));
        //余数
        long remainder = dividend % divisor;
        //余数为0，表示整除了，直接返回结果
        if (remainder == 0) {
            return fraction.toString();
        }
        //余数不为0，添加小数点
        fraction.append(".");
        //map用来记录出现重复数的下标，然后将'('插入到重复数前面就好了
        Map<Long, Integer> map = new HashMap<>();
        //小数部分：余数不为0且余数还没有出现重复数字
        while (remainder != 0) {
            //出现循环余数，我们直接在重复数字前面添加'(',字符串末尾添加')'
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            //记录数组出现重复数的下标，然后将'('插入到重复数前面，map的key是重复数，value是重复数最开始的下标
            map.put(remainder, fraction.length());
            //余数扩大10倍，然后求商，和草稿本上运算方法是一样的
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        new number166().fractionToDecimal(2,3);
    }
}
