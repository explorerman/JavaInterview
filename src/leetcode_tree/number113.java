package leetcode_tree;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class number113 {
    private  List<List<Integer>> resList = new ArrayList<>();
    private  List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return resList;
        sum = sum - root.val;
        list.add(root.val);
        if(sum == 0 && root.left == null && root.right == null){
            resList.add(new ArrayList<>(list));
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        list.remove(list.size()-1);
        return resList;

    }
}
