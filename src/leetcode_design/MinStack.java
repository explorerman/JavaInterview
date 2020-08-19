package java_basic;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    //使用小顶堆和栈，直接实现，好处是直接实现了getMin方法
    /** initialize your data structure here. */

    Stack<Integer> mainStack;
    //默认小顶堆
    PriorityQueue<Integer> minPq;
    public MinStack() {
        mainStack = new Stack<>();
        minPq = new PriorityQueue<>();
    }

    public void push(int x) {
        mainStack.push(x);
        minPq.offer(x);
    }

    public void pop() {
        final Integer cur = mainStack.peek();
        mainStack.pop();
        minPq.remove(cur);
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minPq.poll();
    }
}
