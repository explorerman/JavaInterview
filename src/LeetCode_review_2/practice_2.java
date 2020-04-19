package LeetCode_review_2;

import java.util.PriorityQueue;

//给出两个升序数组A、B和长度m、n，求第k个大的
public class practice_2 {
    //思路：使用堆排序和双指针，维护一个k堆，双指针遍历两个数组
    public int practice_2(int[] nums1, int len1, int[] nums2, int len2, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int p1 = len1 - 1, p2 = len2 - 1;
        while (p1 >=0 && p2 >=0){
            if(nums1[p1] > nums2[p2]){
                pq.offer(nums1[p1--]);
            }else if(nums1[p1] < nums2[p2]){
                pq.offer(nums2[p2--]);
            }else {
                pq.offer(nums1[p1--]);
                p2--;
            }
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.out.printf(""+pq.peek());
        return pq.peek();
    }

    public static void main(String[] args) {
        new practice_2().practice_2(new int[]{1,3,4,6,8,9,10}, 7, new int[]{2,5,7}, 3, 2);
    }
}
