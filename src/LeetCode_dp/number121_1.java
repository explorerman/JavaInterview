package LeetCode_dp;
//买卖股票的最佳时机
public class number121_1 {
//    动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        //dp代表了每天的最大收益
        int[] dp = new int[prices.length];
        int min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min_price = Math.min(min_price, prices[i]);
            dp[i] = Math.max(prices[i] - min_price, dp[i - 1]);
        }
        return dp[prices.length - 1];
    }
}
