package LeetCode_bit;

//汉明重量
public class number191 {
    //输入：00000000000000000000000000001011
    //输出：3

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n & mask) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
