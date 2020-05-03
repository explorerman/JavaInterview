package LeetCode_review_2;

//整数拆分
public class number343 {
    int res = Integer.MIN_VALUE;
    public int integerBreak(int n) {
        if (n == 0) {
            return 0;
        }
        helper(n,n, 1);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        System.out.println(res);
        return res;
    }
    void helper(int n, int amount, int count){
        if(amount < 0)
            return;
        if(amount == 0){
            res = Math.max(res, count);
        }
        for (int i = 1; i < n; i++) {
            helper(n,amount - i, count * i);
        }

    }

    public static void main(String[] args) {
        new number343().integerBreak(9);
    }
}
