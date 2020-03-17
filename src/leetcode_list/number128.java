package leetcode_list;

import java.util.ArrayList;
import java.util.Comparator;

public class number128 {
    //输入: -1->5->3->4->0
    //输出: -1->0->3->4->5
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ArrayList list = new ArrayList();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((int)o1 - (int)o2);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < list.size(); i++) {
            ListNode res = new ListNode((int)list.get(i));
            p.next = res;
            p = p.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {  //4->2->1->3
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        new number128().sortList(n1);
    }
}
