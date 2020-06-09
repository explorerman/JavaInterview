package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description 用数组实现一个循环列表
 * @package
 * @file ${fileName.java} number622
 * @createTime: 创建时间: 2020/6/9 10:05
 * @title 标题: 用数组实现一个循环队列
 * 用数组实现一个循环队列，进阶:在上面的基础上实现一个无锁的支持并发的队列
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class MyCircularQueue {
    int[] CircularQueue;
    //队列长度
    int capacity;
    //队列头指针:始终指向当前元素的队首位置
    int front;
    //队列尾指针：始终指向当前队尾元素的下一个位置，也就是下一个入队元素的位置
    int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k + 1;
        CircularQueue = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if(isFull() == false){
            this.CircularQueue[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(isEmpty() == false){
            front = (front + 1) % capacity;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty() == false){
            return CircularQueue[front];
        }else{
            return -1;
        }
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty() == false){
            return CircularQueue[(rear - 1 + capacity) % capacity];
        }
        return -1;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (front == rear) return true;
        else return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if((rear + 1) % capacity == front){
            return true;
        }else {
            return false;
        }
    }

}
