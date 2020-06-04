package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 删除链表的倒数第N个结点
 * 使用快慢指针，快指针先走N+1步，然后快慢指针一起走，直到快指针为null，
 * 这时候慢指针指向的下一个位置，就是要删除的节点，直接指向下一个的下一个结点。
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/4 10:35
 * @title 标题: 删除链表的倒数第N个结点
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //注意：这里走n+1步，是因为前面设置了虚节点，为了出现删除元素的首部的问题
        for (int i = 0; i <= n ; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
