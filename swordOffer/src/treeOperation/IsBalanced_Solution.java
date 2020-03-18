package treeOperation;

public class IsBalanced_Solution {

	/**
	 * 题目：
	 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
	 * 
	 * 思路1：
	 * 遍历每一个节点，借助于一个获取树深度的递归函数，根据该结点的左右子树高度差判断是否平衡，然后递归的对左右子树进行判断。
	 * 
	 * 思路2：
	 * 思路1中有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销，如果改为从下往上遍历，如果
	 * 子树是平衡二叉树，则返回子树的高度，如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) return true;
		return Math.abs(maxDept(root.left) - maxDept(root.right)) <= 1 && 
				IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
	public int maxDept(TreeNode root){
		if(root == null) return 0;
		return 1 + Math.max(maxDept(root.left), maxDept(root.right));
				
	}
	
	public boolean IsBalanced_Solution2(TreeNode root) {
		return getDept(root) != -1;
    }
	public int getDept(TreeNode root){
		if(root == null) return 0;
		int left = getDept(root.left);
		if(left == -1) return -1;
		int right = getDept(root.right);
		if(right == -1) return -1;
		return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
