package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 单向链表，判断是否是回文字符串
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/22 14:23
 * @title 标题: 单向链表，判断是否是回文字符串
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class formal13 {
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        //fast为null时，为偶数，不为null，为奇数
        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if(slow.val != pre.val){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
