package LeetCode_array;

import java.util.LinkedList;

//长度最小的子数组
public class number209<main> {
    //使用滑动窗口
    //输入: s = 7, nums = [2,3,1,2,4,3]
    //输出: 2
    //使用滑动窗口，将
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int res = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if(!sum(list,s)){
                list.offer(nums[i]);
                if(sum(list,s)){
                    while (sum(list,s)){
                        res = Math.min(res,list.size());
                        list.removeFirst();
                    }
                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }

    private boolean sum(LinkedList<Integer> list , int s) {
        int res = 0;
        for(Integer i : list){
            res += i;
        }
        if(res >= s){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
       System.out.println(new number209().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
