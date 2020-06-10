package LeetCode_others;

//给定一个无序整数数组, 其中只有一个数出现了奇数次数，其他的数都是偶数词，打印这个数
//异或可以交换顺序
//如果出现两个数，异或后，可以想办法让这两个数，分到不同的子数组，然后在异或一次
public class test_1 {
    public static int testNum(int[] num) {
        int first = 0, second = 0;
        //异或整体数组后的结果，结果为first和second异或后的结果
        int res = num[0];
        for (int i = 1; i < num.length; i++) {
            res ^= num[i];
        }
        //找res中最后一位为1的数
        int flag = 1;
        while (flag != 0) {
            if ((res & flag) != 0){
                break;
            }
            flag = flag << 1;
        }
        for (int i = 0; i < num.length; i++) {
            //分组
            if ((num[i] & flag) != 0) {
                first ^= num[i];
            } else {
                second ^= num[i];
            }
        }
        System.out.println(res + " " + flag);
        System.out.println(first + "   " + second);
        return res;
    }

    public static void main(String[] args) {
        testNum(new int[]{1,1,2,2,3,3,4,8});
    }
}
