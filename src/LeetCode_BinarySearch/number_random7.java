package LeetCode_BinarySearch;

public class number_random7 {
    int random5() {
        double x = Math.random();   //调用随机函数
        if (x > 32000) return random5();
        return (int)x % 5 + 1;  //1-5
    }

    public static void main(String[] args) {
        int x = new number_random7().random5();
        System.out.println(x);
    }
}
