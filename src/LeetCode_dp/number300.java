package LeetCode_dp;

import java.util.Arrays;

public class number300 {
    public int lengthOfLIS(int[] nums) {
       int res = 0;
       int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
       return res;
    }

    public static void main(String[] args) {
        new number300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
