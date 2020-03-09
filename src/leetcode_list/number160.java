package leetcode_list;

public class number160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        int lenA = 1;
        ListNode pB = headB;
        int lenB = 1;
        if(pA == null & pB ==null) return null;
        while (pA.next != null){
            pA = pA.next;
            lenA++;
        }
        while (pB.next != null){
            pB = pB.next;
            lenB++;
        }
        pA = headA;
        pB = headB;
        if(lenA >= lenB){
            int count = lenA - lenB;
            while (count != 0){
                pA = pA.next;
                count--;
            }
            while (pB != pA){
                if(pA.next != null && pB.next != null){
                    pA = pA.next;
                    pB = pB.next;
                }else {
                    return null;
                }
            }
        }else {
            int count = lenB - lenA;
            while (count != 0){
                pB = pB.next;
                count--;
            }
            while (pB != pA){
                if(pA.next != null && pB.next != null){
                    pA = pA.next;
                    pB = pB.next;
                }else {
                    return null;
                }
            }
        }
        return pA;
    }
    public static void main(String[] args) {

    }
}
