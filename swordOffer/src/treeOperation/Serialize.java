package treeOperation;

public class Serialize {

	/**
	 * ��Ŀ����ʵ�������������ֱ��������л��ͷ����л�������
	 * ˼·������������л�������
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
