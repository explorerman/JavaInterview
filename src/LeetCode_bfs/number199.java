package LeetCode_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class number199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //父类只能拥有父类的方法，这里面不能使用Queue接口，因为只有LinkedList实现了队列，所以只能使用实现类来声明
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                //将每层的最右边节点放入结果集，即可
                if(queue.peekLast() != null) res.add(queue.pollLast().val);
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
        }
        return res;
    }
}
