package leetcode_list;

public class number82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            int val = p.next.val;
            while (val == p.next.val){
                p.next = p.next.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicated2(ListNode head){
        if(head == null) return head;
        ListNode new_head = new ListNode(-1);   //空节点,新链表的头结点
        ListNode new_head_current = new_head;
        ListNode p_current = head;
        int store = head.val -1;   //保存重复值
        while(p_current.next != null){
            if(p_current.val == store){
                p_current = p_current.next;
            }else{
                if(p_current.val != p_current.next.val){
                    new_head_current.next = p_current;
                    p_current = p_current.next;
                }else{
                    store = p_current.val;
                    p_current = p_current.next;
                }
            }
        }
        if(p_current.val == store){
            p_current = p_current.next;
        }else {
            new_head_current.next = p_current;
        }
        return new_head.next;
    }
    public static void main(String[] args) {

    }
}
