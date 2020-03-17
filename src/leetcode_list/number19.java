package leetcode_list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class number19 {
    //链表题切记画图理思路。

    //单指针，两遍遍历，第一遍求链表长度，第二遍找到倒数第n的前一个node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int count = 1;
        ListNode temp = head;
        ListNode res = new ListNode(-1), cur = res;
        res.next = head;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        if(n > count) return null;
        int num = count - n;
        for(int i = 0; i < num; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return res.next;
    }
    //双指针
    public ListNode removeNthFromEnd2(ListNode head, int n){
        if(head == null) return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = res;
        for(int i = 0; i <= n; i++){
            cur = cur.next;
        }
        while(cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return res.next;
    }
    public static void main(String[] args) {

    }
}
