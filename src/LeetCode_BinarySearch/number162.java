package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 寻找峰值
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/24 11:15
 * @title 标题: 寻找峰值
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number162 {
    //因为题目说，必然存在，那就找个数组中的最大值
    public int findPeakElement(int[] nums) {
        return dfs(nums, 0, nums.length -1);
    }

    private int dfs(int[] nums, int left, int right) {
        if(left == right) return left;
        int mid = left + ((right - left) >> 2);
        int leftMax = dfs(nums, left, mid);
        int rightMax = dfs(nums,mid + 1, right);
        return nums[leftMax] > nums[rightMax] ? leftMax : rightMax;
    }
}
