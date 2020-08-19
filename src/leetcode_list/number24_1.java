package leetcode_list;

public class number24_1 {
    //递归解法
    public ListNode swapPairs(ListNode head) {
        //递归出口
        if(head == null || head.next == null) return head;
        //初始化条件
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        //递归进行两两反转
        //firstNode指向后面的交换节点
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
}
