package treeOperation;

import java.util.ArrayList;

public class TreeDepth {

	public int TreeDepth(TreeNode root){
		if(root == null) return 0;
		int left = TreeDepth(root.left) + 1;
		int right = TreeDepth(root.right) + 1;
		return Math.max(left, right);
	}
	public int TreeDepth2(TreeNode root){
	        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	        if(root == null)
	            return 0;
	        queue.add(root);
	        int dept = 0, count = 0, nextCount = 1;
	        while(queue.size() != 0){
	        	count++;
	            TreeNode temp = queue.remove(0);
	            if(temp.left != null)
	                queue.add(temp.left);
	            if(temp.right != null)
	                queue.add(temp.right);
	            if(count == nextCount){
	            	nextCount = queue.size();
	            	count = 0;
	            	dept++;
	            }
	        }
	        return dept;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
