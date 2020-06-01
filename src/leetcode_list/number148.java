package leetcode_list;

/**
 * @author 李杰
 * @version 1.0
 * @Description 链表排序
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/29 16:30
 * @title 标题: 链表排序
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number148 {
    //思路使用归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));

    }

    private ListNode merge(ListNode l1, ListNode l2) {
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

    //递归方法
    private ListNode merge2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge2(l1.next, l2);
            return l1;
        }else{
            l2.next = merge2(l1, l2.next);
            return l2;
        }
    }
}
