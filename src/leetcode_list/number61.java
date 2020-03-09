package leetcode_list;

//旋转链表
public class number61 {
    //输入: 1->2->3->4->5->NULL, k = 2
    //输出: 4->5->1->2->3->NULL
    //解释:
    //向右旋转 1 步: 5->1->2->3->4->NULL
    //向右旋转 2 步: 4->5->1->2->3->NULL
    // 1,2 1
    //思路是找出链表的长度，然后找首节点，k可以看做是链表长度的倍数
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode oldHead = head;
        ListNode newHead = new ListNode(-1);
        ListNode newHeadCursor = newHead;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        cur = head;
        //k % count 为起点 newK是新起点的位置
        int kk = k % count;
        int newK = count - kk;
        //找到新的起点，起点位置为；链表长度-k
        while(newK > 1 && cur != null){
            newK--;
            cur = cur.next;
        }
        if(newK == 1){
            newHeadCursor.next = cur.next;
            cur.next = null;
        }
        while(newHeadCursor.next!=null){
            newHeadCursor = newHeadCursor.next;
        }
        newHeadCursor.next = oldHead;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        new number61().rotateRight(n1, 1);
    }
}
