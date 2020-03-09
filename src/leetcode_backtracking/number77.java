package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class number77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        combineDFS(res,new ArrayList<>(),n,k);
        return res;
    }
    public void combineDFS(List<List<Integer>> result, ArrayList<Integer> level, int n, int k){
        if(level.size() == k ){
            result.add(new ArrayList<>(level));
            return;
        }
        for (int i = 1; i <= n; i++){
            if(level.contains(i)){
                continue;
            }
           level.add(i);
            if(level.get(level.size() - 1) > i){
                level.remove(level.size() - 1);
            }
            combineDFS(result,level,n,k);
            level.remove(level.size() -1);
        }
    }

    public static void main(String[] args) {
        new number77().combine(4,2);
    }
}
