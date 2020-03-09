package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class number230 {
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        preorderTraversal(root);
        list.sort((o1, o2) -> o1);
        return list.get(k-1);

    }
    public void preorderTraversal(TreeNode root) {
        if(root == null) return;
        preorderTraversal(root.left);
        list.add(root.val);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("2");
        list.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }

}
