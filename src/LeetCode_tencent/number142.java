package LeetCode_tencent;


/**
 * @author 李杰
 * @version 1.0
 * @Description 环形链表2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/14 14:09
 * @title 标题: 环形链表2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }
}
public class number142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pHead = head;
        if(pHead == null || pHead.next ==null || pHead.next.next == null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow){
            if(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return null;
            }
        }
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

