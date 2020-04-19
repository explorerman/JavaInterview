package LeetCode_review_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//数组中的第K个最大元素
public class number215 {
    //使用排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //使用小顶堆，维护一个k堆
    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int cur : nums){
            pq.offer(cur);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
