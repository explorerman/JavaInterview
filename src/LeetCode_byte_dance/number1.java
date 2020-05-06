package LeetCode_byte_dance;

import java.util.*;

//两数之和
//注意不能使用双指针，笨办法就是两遍循环，hashmap也可以两遍循环。
public class number1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || target < 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] { map.get(temp), i };
            }
            map.put(nums[i], i);

        }
        return null;
    }
}
