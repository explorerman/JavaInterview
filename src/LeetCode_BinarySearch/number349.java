package LeetCode_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//两个数组的交集
public class number349 {
    //nums1 = [1,2,2,2], nums2 = [2,2]
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums1.length == 0) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1 < len1 && i2 < len2){
            if(nums1[i1] == nums2[i2] && !list.contains(nums1[i1])){
                list.add(nums1[i1]);
                i1++;
                i2++;
            }else if(nums1[i1] < nums2[i2]){
                i1++;
            }else {
                i2++;
            }
        }
        //list转化为int数组的方法
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
        return res;
    }
}
