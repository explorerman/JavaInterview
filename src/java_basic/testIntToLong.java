package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试类型转换,int,long,float,double
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/21 12:40
 * @title 标题: 测试类型转换
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class testIntToLong {
    /**
     *功能描述
     * 基本类型：int 二进制位数：32
     * 包装类：java.lang.Integer
     * 最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
     * 最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
     *
     * 基本类型：long 二进制位数：64
     * 包装类：java.lang.Long
     * 最小值：Long.MIN_VALUE=-9223372036854775808 （-2的63次方）
     * 最大值：Long.MAX_VALUE=9223372036854775807 （2的63次方-1）
     *
     * 基本类型：float 二进制位数：32
     * 包装类：java.lang.Float
     * 最小值：Float.MIN_VALUE=1.4E-45 （2的-149次方）
     * 最大值：Float.MAX_VALUE=3.4028235E38 （2的128次方-1）
     *
     * 基本类型：double 二进制位数：64
     * 包装类：java.lang.Double
     * 最小值：Double.MIN_VALUE=4.9E-324 （2的-1074次方）
     * 最大值：Double.MAX_VALUE=1.7976931348623157E308 （2的1024次方-1）
     */
    public static void main(String[] args) {
        int i = 12;
        long j = i;
        System.out.println("int -> long 自动转化= "+ j);

        long x = 123343434332323232L;
        int y = (int)x;
        System.out.println("long -> int 强转后=" + y);

    }
}
