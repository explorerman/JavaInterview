package LeetCode_review_2;

//不同路径
public class number62_2 {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(m - 1,n - 1);
    }
    int helper(int x,int y){
        if(x == 0 || y == 0) return 1; //只能一直向右走或向下走，所以路径数为 1
        if(memo[x][y] != 0){
            return memo[x][y];
        }
        int left = helper(x-1, y);
        int right = helper(x, y - 1);
        memo[x][y] = left + right;
        return memo[x][y];
    }

}
