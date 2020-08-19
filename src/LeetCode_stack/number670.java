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
public class number670 {
    //输入: 2736
    //输出: 7236
    //解释: 交换数字2和数字7。

    //输入: 9973
    //输出: 9973
    //解释: 不需要交换。
//    98368
//    98368
//    98863

    //暴力破解，两两比较
    public int maximumSwap(int num) {
        if(num < 10) return num;
        String strNum = String.valueOf(num);
        final char[] chars = strNum.toCharArray();
        for (int i = 0; i < chars.length; i++)
            for (int j = i + 1; j < chars.length; j++) {
                //两两交换
                swap(chars, i, j);
                //交换后的字符串在赚为数字比较
                int temp = toInt(chars);
                //如果大于当前的数字，则替换为大的数
                if (temp > num) num = temp;
                //把字符串恢复到交换前
                swap(chars, i,j);
            }
        return num;
    }

    private int toInt(char[] chars) {
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res += chars[i];
        }
        return Integer.valueOf(res);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new number670().maximumSwap(2736));
    }
}
