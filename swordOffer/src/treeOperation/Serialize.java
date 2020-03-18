package treeOperation;

public class Serialize {

	/**
	 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
	 * 思路：先序遍历序列化二叉树
	 * @param root
	 * @return
	 */
	public int index = -1;
	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if(root == null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	TreeNode Deserialize(String str) {
		index++;
		int len = str.length();
		if(index >= len) return null;
		String[] strs = str.split(",");
		TreeNode node = null;
		if(!strs[index].equals("#")){
			node = new TreeNode(Integer.valueOf(strs[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
	public static void main(String[] args) {
	}
}
