package LeetCode_tencent;

import java.util.HashMap;

public class number1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)){
                res[0] = map.get(num);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
