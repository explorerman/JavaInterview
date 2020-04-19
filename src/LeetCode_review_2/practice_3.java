package LeetCode_review_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给出数组A，长度为n，数组中元素的值位于[0, n - 1]之间，求是否有重复元素
public class practice_3 {
    //思路1：先排序，然后遍历一遍，前后比较
    //思路2：用hashmap来判断
    //思路3：利用set不重复的特性，set进去后，跟原长度对比
    public boolean practice_3(int[] nums, int n){
        Set<Integer> set = new HashSet<>();
        for (int cur : nums)
        {
            boolean flag = set.add(cur);
            if(!flag){
                return true;
            }
            System.out.printf(""+flag);
        }
        return set.size() < n ? true : false;
    }

    public static void main(String[] args) {
        new practice_3().practice_3(new int[]{1,2,3,1}, 4);
    }
}
