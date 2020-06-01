package LeetCode_byte_dance;

import java.util.*;

public class formal06 {
    //    二叉树按层遍历，偶数层倒序
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            List<Integer> oddlevel = new ArrayList<Integer>();
            Stack<Integer> evenlevel = new Stack<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.remove();
                if (levelNum % 2 == 1) {
                    oddlevel.add(temp.val);
                } else {
                    evenlevel.push(temp.val);
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if (levelNum % 2 == 1) {
                resList.add(oddlevel);
            } else {
                resList.add(evenList(evenlevel));
            }
        }
        return resList;
    }

    private List<Integer> evenList(Stack<Integer> evenlevel) {
        List<Integer> res = new ArrayList<>();
//        while (!evenlevel.isEmpty()){
//            res.add(evenlevel.pop());
//        }
        for (int i = 0; i < evenlevel.size(); i++) {
            res.add(evenlevel.pop());
        }
        return res;
    }
}
