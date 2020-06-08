package LeetCode_others;

/**
 * @author 李杰
 * @version 1.0
 * @Description 判断一个数是不是素数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 10:45
 * @title 标题: 输出1-1000之间的素数
 * 素数的定义：大于1的自然数中，除了1和他本身以外不再有其他的因数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class isPrime_2 {
    public static boolean isPrimes(int number) {
        final int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        for (int i = 3; i <= 1000; i++) {
            if(isPrimes(i)){
                System.out.print(i + ",");
            }
        }
    }
}
