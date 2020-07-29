package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 搜索旋转排序数组2，本题与搜索旋转数组的不同在于数组中有重复值
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/29 17:17
 * @title 标题: 搜索旋转排序数组2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            //去掉右边的重复值
            if (nums[right] == nums[mid]) {
                right--;
                continue;
            }
            //后半部分有序
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
