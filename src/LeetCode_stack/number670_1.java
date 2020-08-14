package LeetCode_stack;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最大交换，目前想法是使用——单调栈
 * 如果是单调递减栈，则说明不需要交换,503也是单调栈的应用
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/13 14:13
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number670_1 {
    //输入: 2736
    //输出: 7236
    //解释: 交换数字2和数字7。

    //输入: 9973
    //输出: 9973
    //解释: 不需要交换。
//    98368   10909091  19909001  90909011
//    98368
//    98863

    public int maximumSwap(int num) {
        if (num == 0)
            return 0;
        char[] chars = String.valueOf(num).toCharArray();
        //存放的是数组中，最大值的递减序列的索引，也就是构造了一个单调递减栈，这个数组中的每个值，就是代表着原数组当前位置下的最大值索引
        int[] maxIndex = new int[chars.length];
        int max = chars.length - 1;
        //倒过来寻找，当前位置往右，最大的数的下标
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] - '0' > chars[max] - '0') {
                max = j;
            }
            maxIndex[j] = max;
        }
        //正序遍历，找到第一个不是最大的数，将该位置和右边最大数换位置
        for (int i = 0; i < chars.length; i++) {
            int iValue = chars[i] - '0';
            int maxValue = chars[maxIndex[i]] - '0';
            if (maxValue != iValue) {
                chars[i] = (char) (maxValue + '0');
                chars[maxIndex[i]] = (char) (iValue + '0');
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new number670_1().maximumSwap(19909001));
    }
}
