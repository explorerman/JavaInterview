package LeetCode_review_2;

import sun.nio.cs.ext.MacHebrew;

//凑零钱问题
//给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
//比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
public class coinChangeExaple2 {
    // coins 中是可选硬币面值，amount 是目标金额
    //res保存选择硬币最少的结果
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];
        return helper(coins, amount);
    }


    int helper(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0) {
            return 0;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = helper(coins, amount - coin);
            if (subproblem == -1) continue;
            min = Math.min(min, 1 + subproblem);
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
}
