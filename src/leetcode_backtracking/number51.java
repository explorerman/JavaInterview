package leetcode_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//N皇后
public class number51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return res;
        res = new LinkedList<>();
        //构造棋盘，并初始化为.  .表示空，Q表示存放了皇后
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        DFS(board, 0);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void DFS(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            DFS(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    //是否可以在 board[row][col] 放置皇后？
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 & j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> charToString(char[][] board) {
        List<String> result = new LinkedList<>();
        for (char[] chars : board) {
            result.add(String.valueOf(chars));
        }
        return result;
    }
}
