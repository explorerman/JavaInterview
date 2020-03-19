package LeetCode_dp;
//买卖股票的最佳时机
public class number121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
               max = Math.max(prices[j] - prices[i],max);
            }
        }
        if(max <= 0) return 0;
        return max;
    }
    //该方法更好，定义一个buy和res，一个最小买入点，一个最大收益
    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int res = 0, buy = Integer.MAX_VALUE;
        for(int price : prices){
            buy = Math.min(buy, price);
            res = Math.max(res,price - buy);
        }
        return res;
    }
}
