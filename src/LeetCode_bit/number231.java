package LeetCode_bit;

public class number231 {
    public boolean isPowerOfTwo(int n) {

        String str = Integer.toBinaryString(n);
        char[] chars = str.toCharArray();
        int count = 0;
        for (char i :chars) {
            if(i == 1){
                count++;
            }
        }
        if(count == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        new number231().isPowerOfTwo(256);
    }
}
