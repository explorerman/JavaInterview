package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n < 0) return res;
        generateParenthesisDFS(n,n,"", res);
        return res;
    }
    public void generateParenthesisDFS(int left, int right, String level, ArrayList<String> res){
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0 && right == 0){
            res.add(level);
            return;
        }
        generateParenthesisDFS(left - 1, right, level + "(" ,res);
        generateParenthesisDFS(left, right - 1, level + ")" ,res);
    }
}
