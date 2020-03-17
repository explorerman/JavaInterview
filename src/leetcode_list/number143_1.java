package leetcode_list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class number143_1 {
    //给定链表 1->2->3->4, 重新排列为 1->4->2->3
    //给定链表1->2->3->4->5 重新排列为 1->5->2->4->3.
    // L0→Ln→L1→Ln-1→L2→Ln-2→…
    public static void reorderList(ListNode head) {
        if(head == null) return;
        Queue<ListNode> first = new LinkedList<ListNode>();
        Stack<ListNode> last = new Stack<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p_dummy = dummy;
        ListNode cur = head;
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
        int lenth_2 = lenth;
        lenth = lenth / 2;
        while (lenth > 0){
            p_dummy.next = first.poll();
            p_dummy = p_dummy.next;
            p_dummy.next = last.pop();
            p_dummy = p_dummy.next;
            p_dummy.next = null;
            lenth--;
        }
        if(lenth_2 % 2 == 1){
            p_dummy.next = first.poll();
            p_dummy = p_dummy.next;
            p_dummy.next = null;
        }
        head = dummy.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reorderList(n1);
    }
}
