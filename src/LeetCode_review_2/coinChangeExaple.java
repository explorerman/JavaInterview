package LeetCode_review_2;

//凑零钱问题
//给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
//比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
public class coinChangeExaple {
    // coins 中是可选硬币面值，amount 是目标金额
    //res保存选择硬币最少的结果
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        helper(coins, amount, 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

     void helper(int[] coins, int amount, int count) {
        if(amount < 0)
            return;
        if(amount == 0){
            res = Math.min(res, count);
        }
        for (int coin : coins) {
            helper(coins,amount - coin, count + 1);
        }
    }
}
