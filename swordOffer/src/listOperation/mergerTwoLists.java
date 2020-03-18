package listOperation;

public class mergerTwoLists {

	/**
	 * 合并两个有序链表
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(-1), cur = res;
       while(list1 != null && list2 != null){
           if(list1.val < list2.val){
               cur.next = list1;
               list1 = list1.next;
           }else{
               cur.next = list2;
               list2 = list2.next;
           }
           cur = cur.next;
       }
       cur.next = (list1 != null) ? list1 : list2;
       return res.next;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
