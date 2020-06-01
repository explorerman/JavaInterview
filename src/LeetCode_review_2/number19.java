package LeetCode_review_2;


//删除链表的倒数第N个节点
public class number19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        //引入虚拟节点是为了解决删除首部的问题
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n ; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
