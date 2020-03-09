package leetcode_list;

import java.util.Stack;

public class number234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(head != null){
            int temp = stack.peek();
            stack.pop();
            if(head.val != temp) return false;
            head = head.next;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
