package LeetCode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class number18 {
    //-2, -1, 0, 0, 1, 2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 3; i++) {
            int tempFirst = target - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                int tempSecond = tempFirst - nums[j];
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < len - 1; k++) {
                    int num = tempSecond - nums[k];
                    if(map.containsKey(num)){
                        res.add(Arrays.asList(nums[i], nums[j], num, nums[k]));
                    }
                    map.put(nums[k], nums[k]);
                }
            }
        }
        return res;
    }
}
