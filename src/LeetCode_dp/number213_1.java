package LeetCode_dp;

public class number213_1 {
    //[1,7,9,2]
    //思路：因为首尾相连，其实就是说，首尾只能算一次，所以分开求首到次尾和1到尾的最大利润
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 1 ? nums[0] : 0;
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int left, int right) {
        if (right - left <= 1) return nums[left];
        int[] dp = new int[right];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i < right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right - 1];
    }

}
