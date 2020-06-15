package leetcode_backtracking;

//79单词搜索
public class number79 {
    int[] px = new int[]{-1, 0, 1, 0};
    int[] py = new int[]{0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    if(DFS(board, i, j, visited, word, 0)) return true;
                    else continue;
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || index >= word.length() || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        if(index == word.length() - 1) return true;
        visited[i][j] = true;
        for (int k = 0; k != 4; k++) {
            if(DFS(board, i + px[k], j + py[k], visited, word, index+1)) return true;

        }
        visited[i][j] = false;
        return false;
    }
}
