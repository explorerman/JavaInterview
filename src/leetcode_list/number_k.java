package leetcode_list;

import java.util.Stack;

public class number_k {
    public static ListNode FindKthToTail(ListNode head, int k){
        if(head == null || k ==0) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        int lenth = 0;
        while(cur.next != null){
            stack.push(cur);
            lenth++;
            cur = cur.next;
        }
        if(lenth < k) return null;
        while (k > 0){
            res = stack.pop();
            k--;
        }
        return res;

    }
    public static void main(String[] args) {

    }
}
