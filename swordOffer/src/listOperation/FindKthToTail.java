package listOperation;

public class FindKthToTail {

	public ListNode FindKthToTail(ListNode head, int k){
		if(head == null) return null;
		int count = 1;
		ListNode cur = head;
		while(cur.next != null){
			count++;
			cur = cur.next;
		}
		cur = head;
		if(k > count) return null;
		for(int i = 0; i < count - k; i++){
			cur = cur.next;
		}
		return cur;
	}
	public static void main(String[] args) {

	}

}
