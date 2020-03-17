package LeetCode_heap;

import java.util.Collections;
import java.util.PriorityQueue;

//数据流的中位数
//题目中求最大最小元素，或者平均数，等跟最大最小元素有关的则使用堆，即优先队列
public class number295 {
    //使用双堆，一个堆中存最小元素,一个堆中存最大元素
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public number295() {
        maxHeap = new PriorityQueue<>();   //大堆存的是右边元素，从小到大
        minHeap = new PriorityQueue<>(Collections.reverseOrder());    //小堆存的是最左边元素，从大到小
    }
    public void addNum(int num) {
        maxHeap.offer(num);   //先将元素放入大堆
        minHeap.offer(maxHeap.poll());     //将大堆中的堆顶
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());    //因为最后的中位数位于中间，而且大堆是从小到大排序，所以如果是奇数，则直接弹出堆顶
        }
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : 0.5 * (maxHeap.peek() + minHeap.peek());
    }

    public static void main(String[] args) {
        number295 n = new number295();
        n.addNum(6);
        n.addNum(10);
        n.addNum(2);
        n.addNum(6);
        n.addNum(5);
        n.addNum(0);
//        n.addNum(6);
//        n.addNum(3);
//        n.addNum(1);
//        n.addNum(0);
//        n.addNum(0);
        System.out.println(n.findMedian());
    }
}
