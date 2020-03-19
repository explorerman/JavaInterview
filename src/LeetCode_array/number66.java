package LeetCode_array;

//加1
public class number66 {
    public static int[] plusOne(int [] digits){
        int n = digits.length;
        for(int i = digits.length - 1; i >= 0; --i){
            if(digits[i] < 9){
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int [] res = new int[n+1];
        res[0] = 1;
        return res;
    }

    public static int[] plusOne2(int[] digits){
        int n = digits.length;
        if(n == 0) return digits;
        int carry = 2;
        for(int i = digits.length - 1; i >= 0; --i){
            if(carry == 0) return digits;
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return carry == 0 ? digits : res;
    }

    public static void main(String[] args) {

        int[] a = new int[]{9,9,8};
        int[] b =  plusOne2(a);
        for (int i : b) {
            System.out.print(i+" ");
        }
    }
}
