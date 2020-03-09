package LeetCode_BinarySearch;

public class number34_1 {
    public int[] searchRange(int[] nums, int target) {
        int index = serach(nums,0, nums.length - 1,target);
        if(index == -1){
           return new int[]{-1,-1};
        }
        int left = index, right = index;
        while (left > 0 && nums[left - 1] == nums[index]){
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == nums[index]){
            right++;
        }
        return new int[]{left,right};
    }
    public int serach(int[] nums, int left, int right, int target){
        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        if(target == nums[mid]){
            return mid;
        }
        if(target < nums[mid]){
            return serach(nums, left, mid - 1, target);
        }
        else{
            return serach(nums, mid + 1, right, target);
        }
    }
}
