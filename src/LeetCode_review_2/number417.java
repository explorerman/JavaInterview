//package LeetCode_review_2;
//
//import java.util.ArrayList;
//import java.util.List;
//
////太平洋大西洋水流问题
//public class number417 {
//    int[] px = new int[]{-1,0,1,0};
//    int[] py = new int[]{0,-1,0,1};
//    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tempRes;
//        if(matrix.length == 0)  return res;
//        int row = matrix.length;
//        int col = matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(DFS(matrix,i,j)){
//                    tempRes = new ArrayList<>();
//                    tempRes.add(i);
//                    tempRes.add(j);
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean DFS(int[][] matrix, int x, int y) {
//        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length ){
//            return false;
//        }
//        for (int i = 0; i != 4; i++) {
//            DFS(matrix, i + px[i],y + py[i]);
//        }
//    }
//}
