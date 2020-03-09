package leetcode_list;

public class number82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode new_head = new ListNode(-1);   //空节点,新链表的头结点
        ListNode p_new = new_head;
        ListNode p_old = head;
        double store = 0.1;   //保存重复值
        while(p_old.next != null){
            if(p_old.val == store){
                p_old = p_old.next;
            }else{
                if(p_old.val != p_old.next.val){
                    p_new.next = p_old;
                    p_old = p_old.next;
                    p_new = p_new.next;
                }else{
                    store = p_old.val;
                    p_new.next = p_old.next;
                    p_old = p_old.next;
                }
            }
        }
        if(p_old.val == store){
            p_old = p_old.next;
        }else{
            p_new.next = p_old;
            p_new = p_new.next;
        }
        p_new.next = null;
        return new_head.next;
    }
    public static void main(String[] args) {

    }
}
