package leetcode_list;

public class number328 {
    // 输入: 2->1->3->5->6->4->7->8->NULL
    //输出: 2->3->6->7->1->5->4->NULL
    // 2,3,6,7
    // 1,5,4,8
    //跟86题解题方法一样，都是定义两个链表，然后各自挑选自己的节点，最后拼在一起。
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = new ListNode(-1);
        ListNode p_odd = odd;
        ListNode even = new ListNode(-1);
        ListNode p_even = even;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            p_odd.next = cur;
            p_even.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            p_odd = p_odd.next;
            p_odd.next = null;
            p_even = p_even.next;
            p_even.next = null;
        }
        if(cur != null){
            p_odd.next = cur;
            p_odd = p_odd.next;
        }
        p_odd.next = even.next;
        return odd.next;

    }
    public static void main(String[] args) {

    }
}
