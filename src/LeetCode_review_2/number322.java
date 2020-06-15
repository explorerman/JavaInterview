package LeetCode_review_2;

//零钱兑换
public class number322 {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        DFS(coins, amount, 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
            return res;

    }

    private void DFS(int[] coins, int amount, int count) {
        if(amount < 0) {
            return;
        }
        if(amount == 0){
            res = Math.min(res, count);
        }
        for (int coin : coins){
            DFS(coins, amount - coin, count + 1);
        }
    }
}
