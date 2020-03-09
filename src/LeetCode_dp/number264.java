package LeetCode_dp;

import java.util.ArrayList;
import java.util.List;

//丑数 动态规划
public class number264 {
    //输入: n = 10
    //输出: 12
    //解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    public int nthUglyNumber(int n) {
        if(n > 1690) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;//定义三个指针，
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] *3, dp[i5]*5));//每个子列表都是一个丑陋数分别乘以 2，3，5，按从小到大顺序排序
            if(min == dp[i2] * 2) i2++;
            if(min == dp[i3] * 3) i3++;
            if(min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        new number264().nthUglyNumber(10);
    }
}
