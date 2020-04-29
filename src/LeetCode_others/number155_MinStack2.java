package LeetCode_others;

import java.util.Stack;
//最小栈，使用了链表方法，每个节点都保存了当前节点时的最小值（固定）
public class number155_MinStack2 {
    private Node head;

    public number155_MinStack2() {

    }

    public void push(int x) {

        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {

        head = head.next;
    }

    public int top() {

        return head.val;
    }

    public int min() {

        return head.min;
    }

    private class Node {

        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {

            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        number155_MinStack2 m = new number155_MinStack2();
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
