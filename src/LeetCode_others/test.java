package LeetCode_others;

//给定一个整数数组, 其中只有一个数出现了奇数次数，其他的数都是偶数词，打印这个数
//异或可以交换顺序
//如果出现两个数，异或后，可以想办法让这两个数，分到不同的子数组，然后在异或一次
public class test {
    public static int  testNum(int[] num){
        int res = num[0];
        for (int i = 1; i < num.length; i++) {
            res ^= num[i];
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        testNum(new int[]{7,6,2,6,7,5,4,2,4});
    }
}
