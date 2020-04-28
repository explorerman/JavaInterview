package LeetCode_review_2;

//被围绕的区域
public class number130 {

    //
    int[] px = new int[]{-1, 0, 1, 0};  //横坐标
    int[] py = new int[]{0, 1, 0, -1};  //纵坐标

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O') {
                    DFS(board, visited, i, j);
                }
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }

    }

    private void DFS(char[][] board, boolean[][] visited, int x, int y) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        board[x][y] = 'S';
        for (int i = 0; i != 4; i++) {
            DFS(board, visited, x + px[i], y + py[i]);
        }
    }
}
