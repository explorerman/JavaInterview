package LeetCode_byte_dance;

import java.util.ArrayList;
import java.util.List;

//括号生成
public class number22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n < 0) return res;
        DFS(n, n, "", res);
        return res;
    }

    private void DFS(int left, int right, String level, ArrayList<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(level);
            return;
        }
        DFS(left - 1, right, level + "(", res);
        DFS(left, right - 1, level + ")", res);
    }
}
