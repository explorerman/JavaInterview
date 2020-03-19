package LeetCode_array;

import java.util.HashMap;
//寻找重复数
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


    //思路：使用set,或者hashmap的方法来判断，找到大于2的就return
    public int findDuplicate2(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) >= 2)
                return num;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        int result = new Solution287().findDuplicate(nums);
        System.out.println(result);
    }

}