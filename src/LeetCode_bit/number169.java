package LeetCode_bit;

import java.util.HashMap;

public class number169 {
    //输入: [2,2,1,1,1,2,2]
    //输出: 2
    //后续使用位运算来解决
    public int majorityElement(int[] nums) {

        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        int length = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
                if(map.get(i) > length){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        new number169().majorityElement(arr);
    }
}
