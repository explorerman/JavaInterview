package leetcode_design;

import java.util.Stack;

public class number155_MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    /** initialize your data structure here. */
    Stack<Object> stack;
    public number155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return (int)stack.peek();
    }

    public int getMin() {
        Object[] obj = new Object[stack.size()];
        stack.copyInto(obj);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < obj.length; i++) {
            res = Math.min(res, (int)obj[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        number155_MinStack m = new number155_MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        int o = m.getMin();
        m.pop();
        int n = m.top();
        int oo = m.getMin();
    }
}
