package LeetCode_greedy;

public class number122 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i -1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        new number122().maxProfit(prices);
    }
}
