package leetcode_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class number98_2 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
