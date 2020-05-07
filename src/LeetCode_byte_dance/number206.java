package LeetCode_byte_dance;


/**
 * @author 李杰
 * @version 1.0
 * @Description 反转链表
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/7 9:58
 * @title 标题: 反转链表
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = next;
        }
        return dummy;
    }
}
