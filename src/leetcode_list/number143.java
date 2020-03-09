package leetcode_list;

import java.util.LinkedList;
import java.util.Stack;

public class number143 {
    public static void reorderList(ListNode head) {
        if(head == null) return;
        LinkedList<ListNode> first = new LinkedList<>();
        Stack<ListNode> last = new Stack<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        int lenth = 0;
        while (cur != null){
            last.push(cur);
            cur = cur.next;
            lenth++;
        }
        cur = head;
        while (cur != null){
            first.offer(cur);
            cur = cur.next;
        }
        System.out.println(first.size() +"  "+last.size());
        cur = head;
        while (lenth > 0 && cur.next != null){
            res = first.poll();
            cur = res;
            res = last.pop();
            cur.next = res;
            cur = cur.next;
            lenth--;
        }

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        reorderList(n1);
//        LinkedList<ListNode> first = new LinkedList<>();
//
//        first.push(n5);
//        first.add(n5);
//        first.offer(n5);
//        System.out.println(first.size());
    }
}
