package leetcode_list;
//反转链表2
public class number92 {
    //思路： 找到要翻转的链表，翻转后与原来的链表连起来。
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //方法1
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        for(int i = 0; i< m - 1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode temp = null;
        ListNode node = null;
        for(int i = 0; i < n - m + 1; i++){
            temp = cur.next;
            cur.next = node;
            node = cur;
            cur = temp;
        }
        pre.next.next = temp;
        pre.next = node;
        return dummy.next;
    }
}
