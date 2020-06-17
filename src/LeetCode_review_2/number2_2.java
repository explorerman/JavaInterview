package LeetCode_review_2;

public class number2_2 {
    public static ListNode addTwoNumbers(ListNode str1, ListNode str2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (str1 != null || str2 != null){
            int str1Num = str1 != null ? str1.val : 0;
            int str2Num = str2 != null ? str2.val : 0;
            int sum = str1Num + str2Num + carry;
            carry = sum / 10;
            int num = sum % 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            if(str1 != null) str1 = str1.next;
            if(str2 != null) str2 = str2.next;
        }
        if(carry > 0) cur.next = new ListNode(carry);
        return dummy.next;
    }

}
