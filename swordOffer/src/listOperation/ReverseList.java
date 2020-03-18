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
	 * ��ת����
	 * @param head
	 * @return
	 */
	public ListNode ReverseList(ListNode head) {
		 	ListNode prev = null;  //�������ͷָ��
	        ListNode curr = head;   //��ǰָ��
	        ListNode nextTemp = null;  // ��ǰָ�����һ��ָ��
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
