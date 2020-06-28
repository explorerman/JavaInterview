package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 第k个排列
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/28 15:17
 * @title 标题: 第k个排列
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number60 {
    int count = 0;
    List<List<Integer>> res;
    public String getPermutation(int n, int k) {
        res = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        boolean[] visited = new boolean[arr.length];
        DFS(new ArrayList<Integer>(), arr, visited, k);
        final List<Integer> resList = res.get(res.size() - 1);
        String resStr = "";
        for (int i = 0; i < resList.size(); i++) {
            resStr += resList.get(i);
        }
        return resStr;
    }

    private void DFS(ArrayList<Integer> levelList, int[] arr, boolean[] visited, int k) {
        if(levelList.size() == arr.length && count <= k){
            count += 1;
            res.add(new ArrayList<>(levelList));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[i] == true) continue;
            visited[i] = true;
            levelList.add(arr[i]);
            DFS(levelList, arr, visited, k);
            visited[i] = false;
            levelList.remove(levelList.size() - 1);
        }
    }

}
