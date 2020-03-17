package leetcode_list;

public class number86 {
    //新建两个链表，将大小值分开，最后小的在前，大的在后。
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode dummyNew = new ListNode(-1);
        dummy.next = head;
        ListNode pOld = dummy;
        ListNode pNew = dummyNew;
        while (pOld.next != null){
            if(pOld.next.val < x){
                pNew.next = pOld.next;
                pNew = pNew.next;
                pOld.next = pOld.next.next;
                pNew.next = null;
            }else{
                pOld = pOld.next;
            }
        }
        pNew.next = dummy.next;
        return dummyNew.next;
    }
    public ListNode partition2(ListNode head, int x) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;  //小数
        ListNode p2 = dummy2;  //大数
        while (cur != null){
            if(cur.val < x){
                p1.next = cur;
                cur = cur.next;
                p1 = p1.next;
                p1.next = null;
            }else{
                p2.next = cur;
                cur = cur.next;
                p2 = p2.next;
                p2.next = null;
            }
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
    public static void main(String[] args) {
        Integer a = new Integer(123);

        System.out.println(a.toString().length());
    }
}
