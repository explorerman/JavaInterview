package leetcode_backtracking;

import java.util.HashMap;

public class number36_1 {

    //使用数组来做映射，初始三个二维数组，一个用于判断行，一个用于判断列，一个用于判断子数独
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int box_index =  (i / 3) * 3 + j / 3;
                    if(rows[i][num] == 1) return false;
                    else {
                        rows[i][num] = 1;
                    }
                    if(cols[j][num] == 1) return false;
                    else {
                        cols[j][num] = 1;
                    }
                    if(boxes[box_index][num] == 1) return false;
                    else {
                        boxes[box_index][num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
