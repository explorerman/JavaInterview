package treeOperation;

public class isSymmetrical {

	/**
	 * 题目：
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
	 * 思路：递归方法
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot)
    {
		if(pRoot == null) return true;
		return isSame(pRoot.left, pRoot.right);
        
    }
	private boolean isSame(TreeNode left, TreeNode right){
		if(left == null) return right == null;
		if(right == null) return false;
		if(left.val == right.val){
			return isSame(left.left, right.right) && isSame(left.right, right.left);
		}else{
		return false;
		}
	}
	public static void main(String[] args) {
	}
}
