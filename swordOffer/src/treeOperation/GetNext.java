package treeOperation;

class TreeLinkNode{
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;
	public TreeLinkNode(int val) {
		this.val = val;
	}
	
}
	/**
	 * ��Ŀ��
	 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
	 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
	 * 
	 * @author JIEE_Shine
	 *
	 */
public class GetNext {

	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        if(pNode.right != null){  //�������������������������������
        	pNode = pNode.right;
        	while(pNode.left != null){
        		pNode = pNode.left;
        	}
        	return pNode;
        }
        while(pNode.next != null){  //���û�������������ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
        	if(pNode.next.left == pNode) return pNode.next;
        	pNode = pNode.next;
        }
        return null;  //�����˸��ڵ���Ȼû���ҵ����򷵻�null��
    }
	public static void main(String[] args) {
	}

}
