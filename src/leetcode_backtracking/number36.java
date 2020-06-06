package leetcode_backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class number36 {

    //使用hashmap映射来做，初始三个hashmap数组，一个用于判断行，一个用于判断列，一个用于判断子数独
    public boolean isValidSudoku(char[][] board) {
        //初始化数据
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box_index].get(n) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
