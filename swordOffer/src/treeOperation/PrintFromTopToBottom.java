package treeOperation;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PrintFromTopToBottom {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if(root == null)
            return result;
        queue.add(root);
        while(queue.size() != 0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            result.add(temp.val);
        }
        return result;
    }
	public static void main(String[] args) {
	}
}
