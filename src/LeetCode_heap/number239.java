package LeetCode_heap;

import java.util.*;

//滑动窗口最大值
public class number239 {
    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]
    //解释:
    //
    //  滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //不错的一个方法：https://zhuanlan.zhihu.com/p/34456480
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            ll.offer(nums[i]);
            pq.offer(nums[i]);
            if(ll.size() == k && pq.size() == k){
                list.add(pq.peek());
                if(pq.contains(ll.getFirst())){
                    pq.remove(ll.getFirst());
                    ll.remove(ll.getFirst());
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new number239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
