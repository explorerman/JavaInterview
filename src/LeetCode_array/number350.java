package LeetCode_array;

import java.util.Arrays;
import java.util.HashMap;

public class number350 {
//    输入: nums1 = [1,2,2,1], nums2 = [2,2]
//    输出: [2,2]
    //解题思路：使用hashmap来映射，先将num1的值映射到map中，然后对应着num2，如果map中有num2的值，则对应的value-1，直到value为0时，直接remove
    //新学会的数组的小技巧，Arrays.copyRange(),从from-to复制数组
    public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int lenght2 = nums2.length;
        int[] res = new int[length1 + lenght2];
        int count = 0;
        if(length1 == 0 || lenght2 == 0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : nums2){
            if(map.containsKey(i)){
                res[count++] = i;
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(res,0,count);

    }
}
