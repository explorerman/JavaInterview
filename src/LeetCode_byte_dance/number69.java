package LeetCode_byte_dance;

//实现开根号函数，要求精确到小数点后三位
public class number69 {
    public static double mySqrt(int n) {
        double mid = 0.0f;
        if(n < -1e-3){
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }else if(Math.abs(n) >= -1e-3 && Math.abs(n) <= 1e-3){
            return mid;
        }else{
            // 逐次逼近，默认平方根的不会超过n的一半
            double high = n / 2.0d;
            double low = 0.0d;
            while(Math.abs(high - low) > 1e-3){
                // 首先找到中间值
                mid = low + (high - low) / 2;
                double tmp = mid * mid;
                // 比较并更新 high和low
                if((tmp - n) > 1e-3){
                    high = mid;
                }else if((tmp -n) < -1e-3){
                    low = mid;
                }else{
                    return mid;
                }
            }
        }
        return mid;
    }


    public static void main(String[] args) {
        mySqrt(3);
        System.out.println(mySqrt(3));
    }
}
