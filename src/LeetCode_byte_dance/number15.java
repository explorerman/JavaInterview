package LeetCode_byte_dance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三叔之和
public class number15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 0 || nums[0] > 0 || nums[len - 1] < 0) return res;
        for (int i = 0; i < len - 2; i++) {
            //当遍历到正数的时候，直接break，因为数组已经有序，所以此时为正数，后续都是正数，不可能相加为0
            if (nums[i] > 0) break;
            //重复跳过，如果方法是从第二数开始的，如果和前面的数字想到，就跳过，因为不想把相同的数字fix两次
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                    跳过重复数字的步骤了，两个指针都需要检测重复数字
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (twoSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}