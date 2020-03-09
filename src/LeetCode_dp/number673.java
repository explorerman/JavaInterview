package LeetCode_dp;

import java.util.Arrays;

public class number673 {
    public int findNumberOfLIS(int[] nums) {
        int max = 0,res = 0;
        int[] dp = new int[nums.length];
        int[] dc = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(dc, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    if(dp[i] < (dp[j] + 1)){
                        dp[i] = dp[j] + 1;
                        dc[i] = dc[j];
                    }else if(dp[i] == (dp[j]+1)){
                        dc[i] += dc[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] == max){
                res += dc[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new number673().findNumberOfLIS(new int[]{1,3,5,4,7});
    }
}
