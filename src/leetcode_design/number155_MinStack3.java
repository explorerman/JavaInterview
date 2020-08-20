package leetcode_design;

import java.util.Stack;

//使用了辅助栈，辅助栈中始终保存的是最小值，并且按照栈顶-栈底，从小到大排序（栈顶一直是最小值）
public class number155_MinStack3 {
    Stack<Integer> datas;
    Stack<Integer> stacks;

     public number155_MinStack3() {
        datas = new Stack<>();
        stacks = new Stack<>();
    }

    void push(int x) {
        if (stacks.empty() || x <= stacks.peek()) {
            stacks.push(x);
        }
        datas.push(x);

    }

    void pop() {
        int x = datas.peek();
        if (x == stacks.peek()) {
            stacks.pop();
        }
        datas.pop();

    }

    int top() {
        return datas.peek();
    }

    int min() {
        return stacks.peek();
    }

    public static void main(String[] args) {
        number155_MinStack3 m = new number155_MinStack3();
        m.push(-2);
        m.push(0);
        m.push(-3);
        int o = m.min();
        m.pop();
        m.pop();
        int n = m.top();
        int oo = m.min();

    }
}
