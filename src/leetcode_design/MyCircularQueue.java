package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description 用数组实现一个循环列表
 * @package
 * @file ${fileName.java} number622
 * @createTime: 创建时间: 2020/6/9 10:05
 * @title 标题: 用数组实现一个循环队列    设计一个循环队列 number622
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
    // 在 front 出队，故设计在数组的头部，方便删除元素
    // 删除元素的时候，只索引 +1（注意取模）
    int front;
    //队列尾指针：始终指向当前队尾元素的下一个位置，也就是下一个入队元素的位置
    // 在 rear 入队，故设计在数组的尾部，方便插入元素
    // 插入元素的时候，先赋值，后索引 +1（注意取模）
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
        // 注意：这是这个经典设计的原因
        //使用循环数组实现的队列，实际存储的元素比数组的长度至少少一个单位，我们认为是浪费一个单位是为了保证，队列为空，队列为满的判断条件不冲突
        if((rear + 1) % capacity == front){
            return true;
        }else {
            return false;
        }
    }

}
