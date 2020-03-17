package LeetCode_bfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//N叉树的最大深度
public class number559 {
    int maxLength;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        else if(root.children.isEmpty()){
            return 1;
        }else{
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < root.children.size(); i++) {
                list.add(maxDepth(root.children.get(i)));
            }
            return Collections.max(list) + 1;
        }
    }
}
