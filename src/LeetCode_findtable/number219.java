package LeetCode_findtable;

import java.util.HashMap;

//存在重复元素2
public class number219 {
    //输入: nums = [1,2,3,1,2,3], k = 2
    //输出: true
    //暴力破解，时间复杂度太高，仅仅击败全国百分之5的人
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        if(nums.length < 0) return false;
        int[] arr = new int[0];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; ((j - i) <= k) && j < length; j++) {
                if(nums[j] == nums[i]){
                    return true;
                }
            }
        }
        return false;
    }

    //使用hashmap存储元素，key为nums中的值，value为下标，如果碰到相同的，则判断差值是否是小于k，如果满足则直接true
    //如果不满足，则更新当前值的value，即更新为此时的下标
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int length = nums.length;
        if(nums.length < 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new number219().containsNearbyDuplicate2(new int[]{1,0,1,1},1));
    }

}
