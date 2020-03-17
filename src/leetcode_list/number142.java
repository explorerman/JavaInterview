package leetcode_list;



public class number142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pHead = head;
        if(pHead == null || pHead.next ==null || pHead.next.next == null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
       while (fast != slow){
           if(fast.next != null && fast.next.next != null){
               fast = fast.next.next;
               slow = slow.next;
           }else {
               return null;
           }
       }
       fast = pHead;
       while (fast != slow){
           fast = fast.next;
           slow = slow.next;
       }

        return slow;
    }
    public static void main(String[] args) {

    }
}
