package LeetCode_array;

public class number674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        int max = Integer.MIN_VALUE;
        //初始化为1是因为，每个元素都是自己的递增子串
        int res = 1;
        //冒泡排序比较
        for(int i = 1; i < len; i++){
            if(nums[i] > nums[i - 1]){
                res++;
            }else{
                max = Math.max(max, res);
                res = 1;
            }
        }
        //判断都是递增数组的可能
        max = Math.max(max, res);
        return max;
    }

}
