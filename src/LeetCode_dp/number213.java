package LeetCode_dp;

public class number213 {
    public int rob(int[] nums) {
        //[1,2,3,1]
        if (nums.length <= 1) return nums.length == 1 ? nums[0] : 0;
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int left, int right) {
        if (right - left <= 1) return nums[left];
        int max = Integer.MIN_VALUE;
        int evenMax = 0;
        int oddMax = 0;
        for (int i = left; i < right; i++) {
            if (i % 2 == 0) {
                //只是确定要抢偶数位，最终值并不一定是偶数位置的值,而是当前位置时的最大值，并且最终能保证最大值的数字不相邻
                evenMax = Math.max(evenMax + nums[i], oddMax);
            } else {
                oddMax = Math.max(oddMax + nums[i], evenMax);
            }
        }
        max = Math.max(evenMax, oddMax);
        return max;
    }

}
