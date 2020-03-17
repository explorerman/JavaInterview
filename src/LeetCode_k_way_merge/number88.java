package LeetCode_k_way_merge;

import java.util.PriorityQueue;

public class number88 {
    //nums1 = [1,2,3,0,0,0], m = 3
    // nums2 = [2,5,6],       n = 3
    //输出: [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(nums1[0]);
        minHeap.offer(nums2[0]);
        int[] res = new int[m + n];
        int n1 = 0;
        int n2 = 0;
        int resPointer = 0;
        while (minHeap.size() > 0 && n1 < m && n2 < n){
            int temp = minHeap.peek();
            res[resPointer++] = minHeap.poll();
            if(temp == nums1[n1] && nums1[n1] != 0){
                minHeap.offer(nums1[++n1]);
            }else {
                minHeap.offer(nums2[++n2]);
            }
        }
        nums1= res.clone();
    }

    public static void main(String[] args) {
        new number88().merge(new int[]{1,2,3,4},3,new int[]{2,5,6},3);
    }
}
