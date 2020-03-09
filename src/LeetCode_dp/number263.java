package LeetCode_dp;

//丑数 不属于动态规划
public class number263 {
    public boolean isUgly(int num) {
        if(num == 1) return true;
        while (num % 2 == 0){
            num /= 2;
        }
        while (num % 3 == 0){
            num /= 3;
        }
        while (num % 5 == 0){
            num /= 5;
        }
        if(num == 1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        new number263().isUgly(14);
    }
}
