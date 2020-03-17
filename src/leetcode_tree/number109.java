package leetcode_tree;

public class number109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int count = 1;
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            count++;
        }
        int[] nums = new int[count];
        for (int i = 0; i< count; i++){
            nums[i] = head.val;
            head = head.next;
        }
        TreeNode res = sort(nums, 0, nums.length -1);
        return res;
    }
    public TreeNode sort(int[] nums, int start, int end){
        if(start > end) return null;
        int middle = start + (end - start) / 2 ;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sort(nums, start, middle - 1);
        root.right = sort(nums, middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new number109().sortedListToBST(n1);
    }
}
