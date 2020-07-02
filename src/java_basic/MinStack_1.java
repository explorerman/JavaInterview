package java_basic;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack_1 {
    //使用辅助栈，
    /**
     * initialize your data structure here.
     */

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack_1() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);

    }

    public void pop() {
        if(mainStack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
