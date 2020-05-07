package LeetCode_review_2;

import java.util.function.BinaryOperator;

//矩阵中的路径
public class face12 {
    int[] px = new int[]{1, 0, -1, 0};
    int[] py = new int[]{0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        final char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (words[0] == board[i][j] && !visited[i][j]) {
                    if (DFS(board, words, visited, i, j, 0)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, char[] words, boolean[][] visited, int x, int y, int wordIndex) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != words[wordIndex]) {
            return false;
        }
        if (wordIndex == words.length - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i != 4; i++) {
            if (DFS(board, words, visited, x + px[i], y + py[i], wordIndex + 1)) {
                return true;
            }
        }
        visited[x][y] = false;   //因为上层函数exist还要使用，所以递归后回退。
        return false;
//        boolean res = DFS(board, words, visited, x + 1, y, wordIndex + 1) || DFS(board, words, visited,x - 1, y, wordIndex + 1) ||
//                DFS(board, words, visited,x, y + 1, wordIndex + 1) || DFS(board, words, visited, x , y - 1, wordIndex + 1);
    }
}
