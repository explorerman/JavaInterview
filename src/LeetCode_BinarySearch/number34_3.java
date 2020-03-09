package LeetCode_BinarySearch;

public class number34_3 {
    //其实我们也可以只使用一个二分查找的子函数，来同时查找出第一个和最后一个位置。如何只用查找第一个大于等于目标值的二分函数来查找整个范围呢，
    // 这里用到了一个小 trick，首先来查找起始位置的 target，就是在数组中查找第一个大于等于 target 的位置，当返回的位置越界，
    // 或者该位置上的值不等于 target 时，表示数组中没有 target，直接返回 {-1, -1} 即可。若查找到了 target 值，则再查找第一个大于等于 target+1 的位置，
    // 然后把返回的位置减1，就是 target 的最后一个位置，即便是返回的值越界了，减1后也不会越界，这样就实现了使用一个二分查找函数来解题啦
    public int[] searchRange(int[] nums, int target){
        int start = search(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start, search(nums, target + 1) - 1};
    }
    public int search(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
