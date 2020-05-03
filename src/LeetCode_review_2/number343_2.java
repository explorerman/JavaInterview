package LeetCode_review_2;

//整数拆分
public class number343_2 {
    int[] memo;

    public int integerBreak(int n) {
        if (n == 0) {
            return 0;
        }
        memo = new int[n];
        int res = helper(n,n);
        System.out.println(res);
        return res;
    }

    int helper(int n, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0) {
            return 1;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            int subproblem = helper(n, amount - i);
            if (subproblem == -1) continue;
            max = Math.max(max, subproblem *= i);
        }
        memo[amount - 1] = (max == Integer.MAX_VALUE ? -1 : max);
        return memo[amount - 1];

    }

    public static void main(String[] args) {
        new number343_2().integerBreak(10);
    }
}
