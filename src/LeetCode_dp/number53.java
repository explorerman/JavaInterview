package LeetCode_dp;

public class number53 {
    //dp解法，
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //代表的是当前位置结尾的最大值
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
