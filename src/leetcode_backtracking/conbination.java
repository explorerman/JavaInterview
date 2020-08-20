package leetcode_backtracking;

import java.util.ArrayList;
//组合问题
public class conbination {

    public ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        dfs(res, chars, 0);
        return res;
    }
    private void dfs(ArrayList<String> res, char[] chars, int level){
        if(level == chars.length){
            res.add(new String(chars));
            return;
        }
        for(int j = level; j < chars.length; j++){
            swap(chars,level, j);
            dfs(res, chars, level + 1);
            swap(chars, j, level);
        }
    }
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        new conbination().Permutation("abc");
    }
}
