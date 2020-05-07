package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 两个链表的第一个公共起点
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/7 9:46
 * @title 标题: 两个链表的第一个公共起点
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class face52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = generationLen(headA);
        int lenB = generationLen(headB);

        if(lenA > lenB){
            int len = lenA - lenB;
            while (len > 0){
                headA = headA.next;
                len--;
            }
        }else if(lenA < lenB){
            int len = lenB - lenA;
            while (len > 0){
                headB = headB.next;
                len--;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int generationLen(ListNode Node) {
        int len = 0;
        while (Node != null){
            Node = Node.next;
            len++;
        }
        return len;
    }
}
