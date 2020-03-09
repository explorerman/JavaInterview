package leetcode_list;

public class number203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        if(head == null) return null;
        while (cur.next != null){
            if(cur.next.val != val){
                cur = cur.next;
            }else {
                cur.next = cur.next.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
