package LeetCode_array;

public class number33 {
    /**
     * 要求时间复杂度为：O(logn)
     * 思路：二分查找，对数折一半
     * 题目要求中：未有重复数字
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            // 前有序，包括中间数
            // 6 7 8 9 1 2
            if(nums[mid] > nums[right]){ //说明左边为有序数列
                if(nums[left] <= target && target <= nums[mid]){  //注意边界：有＝是因为可能是边界值
                    right = mid;
                    if(nums[right] == target)
                        return right;
                }
                else{
                    left = left + 1;
                }
            }
            else{
                // 后有序，包括中间数
                // 6 7 1 2 3 4 5 6
                if (nums[mid] < target && target <= nums[right]) {  //注意边界
                    left = mid + 1;
                } else {
                    right = mid;  //注意边界
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{6,7 ,1 ,2 ,3, 4, 5, 6};
        int i = search(nums,7);
        System.out.println(i);

    }
}
