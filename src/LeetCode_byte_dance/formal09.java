package LeetCode_byte_dance;

public class formal09 {
    //两个链表融合成一个，并排序
    //思路1:先合并链表，在排序，只需要排序一次，选择该方法
    //思路2:先排序，在合并链表，需要排序两次
    // 1-4-2  5-7-3
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 != null) ? l1 : l2;
        ListNode res = orderListNode(dummy.next);
        return res;
    }

    //先排序在合并
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode orderl1 = orderListNode(l1);
        ListNode orderl2 = orderListNode(l2);
        final ListNode resList = merge(orderl1, orderl2);
        return resList;
    }

    //排序，使用归并排序（快慢指针）
    private ListNode orderListNode(ListNode head) {
        if (head == null || head.next.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(orderListNode(head), orderListNode(slow));
    }
    //合并两个排序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
