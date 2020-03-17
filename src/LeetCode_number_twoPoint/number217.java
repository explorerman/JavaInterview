package LeetCode_number_twoPoint;

import java.util.HashMap;

public class number217 {
    //输入: [1,2,3,1]
    //输出: true
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num)+1);
                if(map.get(num) > 1){
                    return true;
                }
            }
        }
        return false;
    }
}
