package treeOperation;

public class HasSubtree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		//��tree1��tree2����Ϊ���ʱ�򣬲Ž��бȽ�
		if(root1 != null && root2 != null){
			//����ҵ��˶�Ӧtree2�ĸ��ڵ�
			if(root1.val == root2.val){  
				//��������ڵ�Ϊ����ж��Ƿ����tree2
				result = doesTree1HaveTree2(root1, root2);
			}
			//����Ҳ�������ȥtree1����ڵ���
			if(!result){
				result = HasSubtree(root1.left, root2);
			}
			//����Ҳ�����ȥtree1���ҽڵ���
			if(!result){
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
    }
	public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2){
		//���tree2�Ѿ��������˲����ܶ�Ӧ�ϣ��򷵻�true
		if(node2 == null) return true;
		//���tree2��û���꣬tree1�Լ������ˣ��򷵻�false
		if(node1 == null) return false;
		//��������и����û��Ӧ�ϣ��򷵻�false
 		if(node1.val != node2.val) return false;
 		//���������Ӧ���ϣ��Ǿͷֱ�ȥ�ӽ�������ƥ�䡣
 		return (doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right));
	}
	public static void main(String[] args) {
	}
}
