package leetcode_list;

public class number83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        if(pre == null) return null;
        while(pre != null && pre.next != null){
            if(pre.val == pre.next.val){
                pre.next = pre.next.next;

            }else{
                pre = pre.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
