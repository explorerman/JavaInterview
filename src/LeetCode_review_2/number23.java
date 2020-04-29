package LeetCode_review_2;


/**
 * @author 李杰
 * @version 1.0
 * @Description 合并K个排序链表（分治算法）
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/29 14:51
 * @title 标题: 合并K个排序链表（分治算法）
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
//合并k个排序链表
public class number23 {
    //笨办法，冒泡排序，改进方法使用分治算法，也就是归并的意思。
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        ListNode resDump = new ListNode(-1);
        ListNode pre = resDump;
        pre.next = lists[0];
        for (int i = 1; i < length; i++) {
            resDump.next = mergeTwoLists(resDump.next, lists[i]);
        }
        return resDump.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        ListNode resDump = new ListNode(-1);
        ListNode pre = resDump;
        while (length > 1){
            int k = (length + 1) / 2;
            for (int i = 0; i < length / 2; i++) {
                resDump.next = mergeTwoLists(lists[i], lists[i + k]);
            }
            length = k;
        }
        return resDump.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
