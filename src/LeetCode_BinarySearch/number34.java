package LeetCode_BinarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//在排序数组中查找元素的第一个和最后一个位置
public class number34 {
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        if(nums.length == 1 && target == nums[0]) return new int[]{0,0};
        if(nums.length == 1 && target != nums[0]) return new int[]{-1,-1};
        int left = 0, right = nums.length - 1;
        List<Integer> res = new ArrayList<>();
        BinarySearch(nums,left, right, target, res);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[] result = new int[2];
        if(res.size()>=2){
            result[0] = res.get(0);
            result[1] = res.get(res.size() - 1);
        }else {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
    public void BinarySearch(int[] nums, int left, int right, int target, List<Integer> res){
        if(left == right && target == nums[left]){
            res.add(left);
            return;
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                res.add(mid);
                BinarySearch(nums, left, mid - 1, target, res);
                BinarySearch(nums, mid + 1, right, target, res);
                return;
            }
            if(target < nums[mid]){
                right = mid - 1;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
        }
        return;
    }

    public static void main(String[] args) {
        new number34().searchRange(new int[]{2,2}, 2);
    }
}
