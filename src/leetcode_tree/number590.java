package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

//N叉树的后序遍历
public class number590 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return res;
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }
}
