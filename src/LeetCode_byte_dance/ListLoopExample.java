package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 链表判环
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/7 10:58
 * @title 标题: 链表判环
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ListLoopExample {
    public ListNode findListLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        //循环出来说明有环
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
