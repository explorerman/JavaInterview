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

    public int maximumSwap(int num) {
        String nums = String.valueOf(num);
        final char[] numsChars = nums.toCharArray();
        int sentinel = 0;
        for (int i = 1; i < numsChars.length; i++) {
            if(numsChars[i] > numsChars[sentinel]){
                sentinel = i;
            }
        }
        if(numsChars[0] == numsChars[sentinel]){
            return num;
        }else {
            char temp = numsChars[0];
            numsChars[0] = numsChars[sentinel];
            numsChars[sentinel] = temp;
            String res = "";
            for (int i = 0; i < numsChars.length; i++) {
                res += numsChars[i];
            }
            return Integer.valueOf(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new number670().maximumSwap(2736));
    }
}
