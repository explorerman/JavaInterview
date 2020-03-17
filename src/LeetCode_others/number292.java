package LeetCode_others;

public class number292 {
    //使用数学归纳法：
    //1-3  赢
    //4 输    8 输    12 输   16 输
    //5 赢    9 赢    13 赢   17 赢
    //6 赢    10 赢   14 赢   18 赢
    //7 赢    11 赢   15 赢   19 赢
    public boolean canWinNim(int n) {
        if(n < 4) return false;
        if(n / 4 == 0) return false;
        else return true;
    }
    public boolean canWinNim2(int n) {
        return ((n & 3) != 0);
    }
}
