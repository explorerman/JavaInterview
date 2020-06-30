package LeetCode_array;

public class number33_1 {
    /**
     * 要求时间复杂度为：O(logn)
     * 思路：二分查找，对数折一半
     * 题目要求中：未有重复数字
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
//        [1,3]
//        3
        //总归一点：二分法应用的场景必须是数组有序
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            //左边有序，如果mid处的值大于右边界，至少说明左边是递增的，判断元素是否在左边
//            nums = [4,5,6,7,0,1,2], target = 0
            if(nums[mid] > nums[right]){
                if(target == nums[mid]) return mid;
                //这里target大于等于是因为，可能会在边界处相等
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else {
                //如果mid处的值小于右边，至少说明右边是递增的
                if(target == nums[mid]) return mid;
                //同理这里target小于等于，可能会在边界处相等
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{6,7 ,1 ,2 ,3, 4, 5, 6};
        int i = search(nums,3);
        System.out.println(i);

    }
}
