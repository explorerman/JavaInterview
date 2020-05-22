package LeetCode_hot;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 单向链表，判断是否是回文字符串
 * 根据快慢指针， 判断以下 fast 是否为null，如果是奇数，fast不为null，slow 再迁移一位不用判断最中间的数，prev和slow的值比较即可。
 * 例: a->b->c->b->a->null , 到比较之前队列变成null<-a<-b c->b->a->null 此时slow 是 c->b->a->null的b节点，prev 为 null<-a<-b的b节点，然后挨个对比即可。
 * 如果是偶数，fast为null，slow不动，prev和slow的值比较即可。
 * 例: a->b->c->c->b->a->null 到比较之前队列变成null<-a<-b<-c c->b->a->null 此时slow 是 c->b->a->null的c节点，prev 为 null<-a<-b<-c的c节点，然后挨个对比即可。
 *
 */
public class PalindromeStringByList {
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
        //fast == null为偶数，不为null为奇数
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
