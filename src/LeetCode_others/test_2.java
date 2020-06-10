package LeetCode_others;

//给定一个无序整数数组, 其中只有一个数出现了奇数次数，其他的数都是偶数词，打印这个数
//异或可以交换顺序
//如果出现两个数，异或后，可以想办法让这两个数，分到不同的子数组，然后在异或一次
public class test_2 {
    public static int testNum(int[] num) {
        int first = 0, second = 0;
        //异或整体数组后的结果，结果为first和second异或后的结果
        for (int i = 0; i < num.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        testNum(new int[]{1,1,2,2,3,3,4,8});
    }
}
