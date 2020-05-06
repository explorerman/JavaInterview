package LeetCode_review_2;

/**
 * @author 李杰
 * @version 1.0
 * @Description 完全平方数，使用memo来保存中间结果
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/6 9:38
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number279_2_3 {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n];
        return helper(n);
    }

    private int helper(int n) {
        if(n < 0) return -1;
        if (n == 0) return 0;
        int count = Integer.MAX_VALUE;
        if(memo[n - 1] != 0) return memo[n - 1];
        //依次减去一个平方数
        for (int i = 1; i * i <= n; i++) {
            //选最小的
            count = Math.min(count, 1 + helper(n - i * i));
        }
        memo[n - 1] = count;
        return memo[n - 1];
    }

    public static void main(String[] args) {
        new number279_2_3().numSquares(12);
    }
}
