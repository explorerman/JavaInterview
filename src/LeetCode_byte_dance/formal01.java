package LeetCode_byte_dance;

public class formal01 {
    //给定一个数组代表股票每天的价格，请问只能买卖一次的情况下，最大化利润是多少？
    //输入: {100, 80, 120, 130, 70, 60, 100, 125} 
    //输出:65（60 买进，125 卖出）
    public int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(prices[j] - prices[i], res);
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices){
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            res = Math.max(res,price - buy);
        }
        return res;
    }

}
