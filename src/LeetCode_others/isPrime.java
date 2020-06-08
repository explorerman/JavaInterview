package LeetCode_others;

/**
 * @author 李杰
 * @version 1.0
 * @Description 判断一个数是不是素数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 10:45
 * @title 标题: 判断一个数是不是素数（质数）
 * 素数的定义：大于1的自然数中，除了1和他本身以外不再有其他的因数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class isPrime {
    public static boolean isPrimes(int number){
        //为什么要开平方
        //拿16这个数字来说，他能可以拆分成2*8、4*4。我们不能说他还有8*2吧，前面已经出现过2和8了，不需要再去判断一次，
        // 也就是到4就行了。
        // 再想想九九乘法表，也就是说，我们只需要判断到他的平方根这里就行了，不然就是重复的判断，浪费运算力
        final int sqrt = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrimes(13));
    }
}
