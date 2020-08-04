package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 搜索二维矩阵2，使用二分搜索,在二维数组中，每行每列中使用二分查找
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/4 18:28
 * @title 标题: 搜索二维矩阵2，使用二分搜索
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number240_1 {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0) return false;
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(vertical){
                if(matrix[start][mid] < target){
                    lo = mid + 1;
                }else if(matrix[start][mid] > target){
                    hi = mid - 1;
                }else {
                    return true;
                }
            }else {
                if(matrix[mid][start] < target){
                    lo = mid + 1;
                }else if(matrix[mid][start] > target){
                    hi = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
