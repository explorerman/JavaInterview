package LeetCode_review_2;


import java.util.Arrays;

//斐波那契数列
public class fibExample {
    //暴力破解，递归
    int fib(int N) {
        if(N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }
    //自顶向下+memo
    int fib2(int N){
        if (N == 0) return 0;
        int[] memo = new int[N + 1];
        Arrays.fill(memo, 0);
        return helper(memo, N);
    }

    private int helper(int[] memo, int N) {
        if (N == 1 || N == 2) return 1;
        if(memo[N] != 0) return memo[N];
        memo[N] = helper(memo,N -1 ) + helper(memo, N -2);
        return memo[N];
    }

    //dp:将上面的memo改成dp table,完成自底向上的代码
    int fib3(int N){
        if(N == 0) return 0;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        dp[0] = dp[1] = 1;
        for (int i = 3; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    //斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，其实并不需要那么长的一个 DP table 来存储所有的状态，
    // 只要想办法存储之前的两个状态就行了。所以，可以进一步优化，把空间复杂度降为 O(1)：
    int fib4(int N){
        if(N == 0) return 0;
        if(N == 2 || N == 1) return 1;
        int pre = 1, cur = 1;
        for (int i = 3; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
