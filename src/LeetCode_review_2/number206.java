package LeetCode_review_2;

public class number206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyIndex = dummy;
        ListNode temp;
        while(head != null){
            temp = head.next;
            head.next = dummyIndex;
            dummyIndex = head;
            head = temp;
        }
        return dummy.next;
    }

}
