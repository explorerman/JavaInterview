package leetcode_list;


//K个一维翻转链表
public class number25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        for (int i = 1; cur != null; i++) {
            if(i % k == 0){
                pre = reverse(pre, cur.next);
                cur = pre.next;
            }else{
                cur = cur.next;
            }
        }

        return dummy.next;
    }
    //反转k前后
    private ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next, cur = last.next;
        while (cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

}
