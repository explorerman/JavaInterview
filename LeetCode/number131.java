import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @Description 分割回文串，使用回溯方法
 */
public class number131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;
        DFS(s, 0, len, new ArrayList<String>(), res);
        return res;

    }

    //level记录从根到叶子结点的路径
    private void DFS(String s, int start, int len, ArrayList<String> level, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            level.add(s.substring(start, i + 1));
            DFS(s, i + 1, len, level, res);
            level.remove(level.size() - 1);
        }
    }

    //判断是否是回文字符串
    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
