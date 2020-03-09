package LeetCode_bit;

//有交替位的二进制数
public class number693 {
    //利用了0和1的交替的特性，进行错位相加，从而组成全1的二进制数，然后再用一个检测全1的二进制数的trick，
    // 就是‘与’上加1后的数，因为全1的二进制数加1，就会进一位，并且除了最高位，其余位都是0，跟原数相‘与’就会得0，所以我们可以这样判断。
    // 比如n是10101，那么n>>1就是1010，二者相加就是11111，再加1就是100000，二者相‘与’就是0，
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp+1)) != 0 ? false:true;
    }


    public boolean hasAlternatingBits2(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp+1)) != 0 ? false:true;
    }
}
