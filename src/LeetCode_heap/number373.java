package LeetCode_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class number373 {
    //使用优先队列构造的堆，自定义排序方式为：num1[i]+ num2[i]从小到大排
    //然后将num1和num2数组的值二维数组循环，放入优先队列中
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k < 0) return res;
        PriorityQueue<List<Integer>> pqRes = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(0)+o1.get(1)) - (o2.get(0)+o2.get(1));
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                pqRes.offer(temp);
            }
        }
        while (k > 0){
            if(pqRes.peek() != null){
                res.add(pqRes.poll());
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
