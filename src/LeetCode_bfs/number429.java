package LeetCode_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class number429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            for(int i = queue.size(); i > 0; i--){
                Node temp = queue.remove();
                level.add(temp.val);
                if(temp.children != null)
                {
                    for (Node node : temp.children) {
                        queue.add(node);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
