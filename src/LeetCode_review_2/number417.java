package LeetCode_review_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//太平洋大西洋水流问题
public class number417 {
    int[] px = new int[]{-1, 0, 1, 0};
    int[] py = new int[]{0, -1, 0, 1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = null;
        if (matrix.length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            DFS(matrix, pacific, Integer.MIN_VALUE, i, 0);
            DFS(matrix, atlantic, Integer.MIN_VALUE, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            DFS(matrix, pacific, Integer.MIN_VALUE, 0, i);
            DFS(matrix, atlantic, Integer.MIN_VALUE, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][i]) {
                    tempRes = new ArrayList<>();
                    tempRes.add(i);
                    tempRes.add(j);
                    res.add(tempRes);
                }
            }
        }
        return res;
    }

    private void DFS(int[][] matrix, boolean[][] visited, int pre, int x, int y) {
        if ((x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) || matrix[x][y] < pre || visited[x][y] == true) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i != 4; i++) {
            DFS(matrix, visited, matrix[x][y], i + px[i], y + py[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        new number417().pacificAtlantic(matrix);
    }
}
