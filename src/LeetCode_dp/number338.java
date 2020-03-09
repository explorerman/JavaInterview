package LeetCode_dp;

//Counting Bits 比特位计数
public class number338 {
    //发现countbit(n) = countbit(n/2) + n % 2这么一个方程，就是说一个数乘2意味着bit位左移一位
    //一个数乘以2意味着bit左移动一位，如果刚好是2的倍数，则和/2的值相同，若是奇数，则加1,即二进制末尾加1
    //输入: 2
    //输出: [0,1,1]
    //输入: 5
    //输出: [0,1,1,2,1,2]
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <=num ; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        return dp;
    }
}
