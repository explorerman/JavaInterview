package LeetCode_byte_dance;

//最大子序和
//分治算法
public class number53_2 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = (left + right)/2;
        int lmax = helper(nums, left, mid);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for(int i = mid - 1; i >= left; i--){
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for(int i = mid + 1; i <= right; i++){
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}
