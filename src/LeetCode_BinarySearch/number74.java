package LeetCode_BinarySearch;

//搜索二维矩阵
public class number74 {
    //输入:
    //matrix = [
    //  [1,   3,  5,  7],
    //  [10, 11, 16, 20],
    //  [23, 30, 34, 50]
    //]
    //target = 3  13
    //输出: true

    //方法1:不使用二分，直接从左下开始搜索matrix[matrix.length-1][0]
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length){
            if(target == matrix[row][col]){
                return true;
            }
            if(target > matrix[row][col]){
                col++;
            }
            else{
                row--;
            }
        }
        return false;
    }

    //方法2：使用二分查找,因为严格是按有序排列的，所以可当一维数组来对待
    public boolean searchMatrix2(int[][] matrix, int target){
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / col, j = mid % col;
            if(target == matrix[i][j]){
                return true;
            }
            else if(target > matrix[i][j]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        new number74().searchMatrix(res,13);
     }
}
