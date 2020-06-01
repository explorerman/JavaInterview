package LeetCode_byte_dance;

public class formal05 {
    //链表重排序，基数位元素升序，偶数位降序。
    public  void reorderList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        //找到中间节点，循环结束时，slow指向中间节点
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = reverse(slow.next);
        slow.next = null; //此时slow已经指向了right的最后的节点
        ListNode left = head;
        while(right != null){
            ListNode next = right.next;
            right.next = left.next;
            left.next = right;
            right = next;
            left = left.next.next;
        }
    }

    private  ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null ){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
