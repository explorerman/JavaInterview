package LeetCode_review_2;

//零钱兑换
public class number322_1 {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];
        return DFS(coins, amount);
    }

    private int DFS(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount - 1] != 0) return memo[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = DFS(coins, amount - coin);
            if (sub == -1) continue;
            min = Math.min(min, sub + 1);
        }
        memo[amount - 1] = min;
        return memo[amount - 1];
    }
}
