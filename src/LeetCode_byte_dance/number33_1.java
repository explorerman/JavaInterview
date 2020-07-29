package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 搜索旋转排序数组, 使用二分搜索，logn的时间复杂度
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/9 11:08
 * @title 标题: 搜索旋转排序数组（暴力破解，复杂度为n）
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
//二分查找，判断mid和最右边元素的大小，如大于最右边，则说明左边有序，小于最右边，说明，右边有序
public class number33_1 {
    public int search(int[] nums, int target) {
        if (nums.length < 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
