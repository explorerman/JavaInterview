package LeetCode_byte_dance;

//最大子序和
public class number53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, cur = 0;
        for (int num : nums){
            cur = Math.max(cur + num, num);
            res = Math.max(res, cur);
        }
        return res;
    }
}
