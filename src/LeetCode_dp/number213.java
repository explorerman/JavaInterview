package LeetCode_dp;

public class number213 {
    public  int rob(int[] nums) {
        int max = Integer.MIN_VALUE;
        int evenMax = 0;
        int oddMax = 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len <= 0) return 0;
        for(int i = 0; i < nums.length - 1;i++){
            if(i % 2 == 0){
                //只是确定要抢偶数位，最终值并不一定是偶数位置的值，并且最终能保证最大值的数字不相邻
                evenMax = Math.max(evenMax + nums[i], oddMax);
            }else{
                oddMax = Math.max(oddMax + nums[i], evenMax);
            }
        }
        if(len % 2 != 0){
            max = Math.max(evenMax, oddMax);
        }else {
            max = Math.max(evenMax, oddMax + nums[len - 1]);
        }
        max = Math.max(evenMax, oddMax);
        return max;
    }
}
