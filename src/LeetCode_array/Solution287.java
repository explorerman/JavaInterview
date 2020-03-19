package LeetCode_array;

public class Solution287 {

    /**
     * 寻找重复数
     * {3,1,3,4,2}
     * 将元素移动到合适的位置。
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){
                return nums[i];    //如果当前位置的值不等于索引值，则就是重复的元素，返回就行。
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        int result = new Solution287().findDuplicate(nums);
        System.out.println(result);
    }

}