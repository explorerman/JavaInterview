package leetcode_list;

public class number876_1 {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        cur = head;
        if(count % 2 == 1){
            int temp = count / 2;
            while (temp != 0){
                ListNode tempNode = cur.next;
                cur.next = null;
                cur = tempNode;
                temp--;
            }
        }else {
            int temp = count / 2;
            while (temp != 0){
                ListNode tempNode = cur.next;
                cur.next = null;
                cur = tempNode;
                temp--;
            }
        }
        return cur;
    }

    public static void main(String[] args) {

    }
}
