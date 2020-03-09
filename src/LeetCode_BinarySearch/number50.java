package LeetCode_BinarySearch;

import java.util.Random;

//power(x,n)
public class number50 {
    //基本类型：int 二进制位数：32
    //包装类：java.lang.Integer
    //最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
    //最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
    //
    //基本类型：long 二进制位数：64
    //包装类：java.lang.Long
    //最小值：Long.MIN_VALUE=-9223372036854775808 （-2的63次方）
    //最大值：Long.MAX_VALUE=9223372036854775807 （2的63次方-1）
    //
    //基本类型：double 二进制位数：64
    //包装类：java.lang.Double
    //最小值：Double.MIN_VALUE=4.9E-324 （2的-1074次方）
    //最大值：Double.MAX_VALUE=1.7976931348623157E308 （2的1024次方-1）

    //参考链接：https://www.cnblogs.com/pangpanghuan/p/6418441.html
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return Math.pow(x,N);

    }

    public static void main(String[] args) {
//        new number50().myPow(2.00000,-3);
        double x = Math.random();
        System.out.println(x);
    }
}
