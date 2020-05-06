package LeetCode_review_2;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 完全平方数 ,dp
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/6 9:38
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number279_3 {
    public int numSquares(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i ; j++) {
                if (i - j < 0) continue;
                dp[i] = Math.min(dp[i], 1+ dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new number279_3().numSquares(12);
    }
}
