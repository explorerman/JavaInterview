package LeetCode_bit;

import java.util.Arrays;

public class number137 {
    //后续使用别的方法，真正的位运算写
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i = i+3) {
            if(nums[i] == nums[i - 1]){
                continue;
            }else{
                res ^= nums[i - 1];
                return res;
            }
        }
        res ^= nums[nums.length-1];
        return res;
    }
}
