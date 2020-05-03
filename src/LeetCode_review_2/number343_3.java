package LeetCode_review_2;

import java.util.Arrays;

//整数拆分
public class number343_3 {

    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int j = 1; j <= n; j++) {
                // 子问题无解，跳过
                if (i - j < 0) continue;
                dp[i] = Math.min(dp[i], i * dp[i - j]);
            }
        }
        return (dp[n] == n + 1) ? -1 : dp[n];
    }


    public static void main(String[] args) {
        new number343_3().integerBreak(10);
    }
}
