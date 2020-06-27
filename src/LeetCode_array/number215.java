package LeetCode_array;

import java.util.Arrays;

//数组中的第K个最大元素
public class number215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        if(k > nums.length || k < 0) return 0;
        Arrays.sort(nums);
        k = nums.length -k;
        for (int i = nums.length - 1; i >= 0 ; --i) {
            if(i == k){
                System.out.println(nums[i]);
                return nums[i];
            }else{
                continue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new number215().findKthLargest(new int[]{1,2,2,3,5,5,6},3);
    }
}
