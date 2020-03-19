package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//二叉树的层次遍历
public class number102 {

    //思路：BFS遍历
    //层序遍历二叉树是典型的广度优先搜索BFS的应用
    //我们把各层的数分开，存到一个二维向量里
    //1.先建立一个queue队列，把根结点存进去。
    //2.找找根节点的左右子结点，去掉根节点，此时队列里的元素就是下一层的所有结点。
    //3.用for循环将该层的节点放到一个链表，也就是一维向量中。
    //4.for循环结束后，将一维向量加到二维向量中。

    //注意：for(int queue.size(); i > 0; i--)不能写为for(int i = 0; i< queue.size(); i++)
    //是因为queue的size每次都会变，放在初始条件则只是赋值，若放在判断条件，则会跟迭代器一样发生失效。
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            //for循环是找到当前层
            for(int i = queue.size(); i > 0; i--){
                TreeNode temp = queue.remove();
                level.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            result.add(level);
        }
        return result;
    }
}
