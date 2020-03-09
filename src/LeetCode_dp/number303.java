package LeetCode_dp;

//区域和检索 - 数组不可变
public class number303 {

    int[] numss;
    public number303(int[] nums) {
        numss = nums;
    }

    public int sumRange(int i, int j) {
        if(j > numss.length) return 0;
        int sum = 0;
        for (int cur = i; cur < j; cur++) {
                sum += numss[cur];
        }
        return sum;
    }
}

//使用dp累加，转移方程为：dp[i] = dp[i]+dp[i-1],其中 dp[i] 表示 [0, i] 区间的数字之和，
// 那么 [i,j] 就可以表示为 dp[j]-dp[i-1]，这里要注意一下当 i=0 时，直接返回 dp[j] 即可
class NumArray {

    int[] dp;
    public NumArray(int[] nums) {
        dp = nums;
        for (int i = 1; i < nums.length; i++) {
            dp[i] += dp[i-1];   //转移方程，dp[i]中存的是到i的累加数
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}

