package treeOperation;

import java.util.ArrayList;

public class FindPath {

	/**
	 * 题目：
	 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
	 */
	private	ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
	private ArrayList<Integer> list = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root == null) return listAll;
		list.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null && root.right == null){
			//一定是深拷贝
			listAll.add(new ArrayList<>(list));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		//深度搜索后清除当前节点,移除最后一个元素，深度遍历完一条路径后要回退。原因：递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
		list.remove(list.size() - 1);
		return listAll;
    }
	public static void main(String[] args) {

	}

}
