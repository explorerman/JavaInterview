package LeetCode_byte_dance;

//最大子序和
public class number53_3 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);

    }

    private int helper(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int leftMax = helper(nums, left, mid);
        int rightMax = helper(nums, mid + 1, right);
        int max = nums[mid], temp = max;
        for (int i = mid - 1; i >= left; i--) {
            temp += nums[i];
            max = Math.max(max, temp);
        }
        temp = max;
        for (int i = mid + 1; i <= right ; i++) {
            temp += nums[i];
            max = Math.max(max, temp);
        }
        return Math.max(max, Math.max(leftMax, rightMax));
    }
}
