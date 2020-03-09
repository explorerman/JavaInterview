package leetcode_list;

public class number876 {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        int count = 1;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        cur = head;
        if(count % 2 == 1){
            int temp = count / 2 + 1;
            while (temp == 0){
                cur = cur.next;
                temp--;
            }
            return cur.next;
        }else{
            int temp = count / 2 + 1;
            while (temp == 0){
                cur = cur.next;
                temp--;
            }
            return cur.next;
        }
    }

    public static void main(String[] args) {
        int a = 1;
        int b = a;
        b = 3;
        System.out.println(a);
    }
}
