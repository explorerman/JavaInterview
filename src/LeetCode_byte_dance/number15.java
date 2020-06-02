package LeetCode_byte_dance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//三叔之和
public class number15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int twoSum = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int temp = twoSum - nums[j];
                level.add(nums[i]);
                if(level.contains(temp)){
                    level.add(nums[j]);
                }
                level.add(nums[j]);
            }
        }
        return res;
    }
}
