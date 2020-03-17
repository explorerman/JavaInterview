package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class number589 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return res;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return res;
    }

}
