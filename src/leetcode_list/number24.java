package leetcode_list;

public class number24 {
    //双指针写法，一个当前指针，两个前后指针，重点在看移动节点的步长
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        if(dummy.next == null) return null;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return pre.next;
    }
    public ListNode swapPairs2(ListNode head){
        ListNode dump = new ListNode(-1);
        ListNode pre = dump;
        dump.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            cur = cur.next;
            pre = pre.next.next;

        }
        return dump.next;
    }
    public static void main(String[] args) {

    }
}
