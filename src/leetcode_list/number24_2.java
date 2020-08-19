package leetcode_list;

public class number24_2 {
    //迭代解法：两两交换，其中需要一个preNode来一直做索引,每次都指向下次交换的头结点
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        while (head != null && head.next != null){
            //初始化
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //交换
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            //重新初始化
            preNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
