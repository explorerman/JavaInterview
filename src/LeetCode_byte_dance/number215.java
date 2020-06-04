package LeetCode_byte_dance;

import java.util.PriorityQueue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 数组中的第K个最大元素
 * 方法1：使用K小顶堆，最后peek就行,java默认是小顶堆，大顶堆需要重写Comparator
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/4 10:56
 * @title 标题: 数组中的第K个最大元素
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);
        for (int num : nums) {
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
