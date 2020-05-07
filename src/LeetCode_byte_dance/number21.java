package LeetCode_byte_dance;


/**
 * @author 李杰
 * @version 1.0
 * @Description 合并两个有序链表
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/7 10:07
 * @title 标题: 合并两个有序链表
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
