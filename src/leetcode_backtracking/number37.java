package leetcode_backtracking;

public class number37 {
    public void solveSudoku(char[][] board) {
        DFS(board, 0, 0);
    }

    private boolean DFS(char[][] board, int row, int col) {
        //如果第9行填完了，直接返回true
        if(row == 9) return true;
        //如果列超过了9列，则说明本行填完了，递归到下一行
        if(col >= 9) return DFS(board, row + 1, 0);
        //如果当前值是数字，则说明已经填过了，返回true
        if(board[row][col] != '.') return DFS(board, row, col + 1);
        //在填入空格时，每个数字都要试一遍
        for (char i = '1'; i <= '9'; i++) {
            //当前的数字填入后，进行校验，如果失败，continue
            //排除不合法选择
            if(!isValid(board, row, col, i)) continue;
            //校验通过后，赋值
            //做选择
            board[row][col] = i;
            //递归到同行的下一列，这时候可以剪枝，如果下一列返回true，直接true
            //进入下一次决策
            if(DFS(board, row, col + 1)) return true;
            //撤销选择
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        //判断行是否满足条件
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == num) return false;
        }
        //判断列是否满足条件
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == num) return false;
        }
        //判断子数独是否满足条件，为什么这么做?
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i + row - row % 3][j + col - col % 3] == num) return false; //怎么确定子数独
            }
        }
        return true;
    }
}
