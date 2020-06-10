package LeetCode_byte_dance;

//实现开根号函数，要求精确到小数点后三位
public class number69_1 {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x / 2;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            int temp = mid * mid;
            if (temp == x)
                return mid;
            else if (temp > x)
                right = mid;
            else left = mid + 1;
        }
        if (left > x / left) return left - 1;
        else return left;

    }


    public static void main(String[] args) {
        mySqrt(3);
        System.out.println(mySqrt(3));
    }
}
