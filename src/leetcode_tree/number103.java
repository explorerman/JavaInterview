package leetcode_tree;

import java.util.*;

public class number103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int levelNum = 1;
        while(!queue.isEmpty()){
            List<Integer> oddlevel = new ArrayList<Integer>();
            Stack<Integer> evenlevel = new Stack<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode temp = queue.remove();
                if(levelNum % 2 == 1){
                    oddlevel.add(temp.val);
                }else{
                    evenlevel.push(temp.val);
                }
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            if(levelNum % 2 == 1){
                result.add(oddlevel);
            }else{
                result.add(evenList(evenlevel));
            }
            levelNum += 1;
        }
        return result;
    }
    public List<Integer> evenList(Stack<Integer> list){
        ArrayList<Integer> res = new ArrayList<>();
        while (!list.isEmpty()){
            res.add(list.pop());
        }
        return res;
    }
}
