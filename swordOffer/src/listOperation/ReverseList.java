package listOperation;


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {

	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public ListNode ReverseList(ListNode head) {
		 	ListNode prev = null;  //新链表的头指针
	        ListNode curr = head;   //当前指针
	        ListNode nextTemp = null;  // 当前指针的下一个指针
	        while(curr != null){
	            nextTemp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = nextTemp;
	        }
	        return prev;
    }
	public static void main(String[] args) {
	}
}
