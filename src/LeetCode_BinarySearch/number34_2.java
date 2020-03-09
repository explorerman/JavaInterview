package LeetCode_BinarySearch;

public class number34_2 {
    //两次二分。第一次找到左边界，第二次调用找到右边界
    public int[] searchRange(int[] nums, int target){
        int[] res = new int[]{-1,-1};
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (right == nums.length || nums[right] != target) return res;
        res[0] = right;
        right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        res[1] = right - 1;
        return res;
    }

    public static void main(String[] args) {
        new number34_2().searchRange(new int[]{5,7,7,8,8,10},8);

    }
}
