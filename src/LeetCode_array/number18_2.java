package LeetCode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 四数之和
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/29 9:59
 * @title 标题: 四数之和
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number18_2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //思路和三数之和一样，无非就是多加了个外层循环
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int k = 0; k < len - 3; k++) {
            int tempFirst = target - nums[k];
            if (k > 0 && nums[k] == nums[k - 1]) continue; //确保nums[a] 改变了
            for (int i = k + 1; i < len - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;  ////确保nums[b] 改变了
                int curTarget = tempFirst - nums[i];
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == curTarget) {
                        res.add(Arrays.asList(nums[k],nums[i],nums[left],nums[right]));
                        //   跳过重复数字的步骤了，两个指针都需要检测重复数字
                        while (left < right && nums[left] == nums[left + 1]) left++; //确保nums[left] 改变了
                        while (left < right && nums[right] == nums[right - 1]) right--; //确保nums[right]改变了
                        left++;
                        right--;
                    } else if (twoSum < curTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
