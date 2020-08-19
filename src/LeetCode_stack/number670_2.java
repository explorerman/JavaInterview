package LeetCode_stack;

import java.util.Arrays;

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
public class number670_2 {
//    将数字从大到小排列，与原数字比较，找出第一位置不一样的数。如8217排序后变为8721，两两对比，
//    第二个数不同，表示7和2交换，得到结果8712

    //先逆序排序处理，然后与原数比较不同的地方，记录位置，然后换
    public int maximumSwap(int num) {
        //1.排序数组元素
        char[] orderNum = Integer.toString(num).toCharArray();
        char[] oldNum = Integer.toString(num).toCharArray();
        Arrays.sort(orderNum);//这里是从小到大排列，所以下面都是从尾部开始比较，防止了1993，这种出现相同元素，但需要取后者的情况

        //1993  9931
        //1399
        int diff = -1;
        //2.找到第一个不同的元素
        for (int i = 0; i < orderNum.length; i++) {
            if (oldNum[i] != orderNum[orderNum.length - 1 - i]) {
                diff = i;
                break;
            }
        }
        System.out.println(diff);
        //两数相同，不需要交换
        if (diff == -1) return num;

        //从尾部开始遍历，找到与diff要交换的元素位置，两两交换
        for (int i = oldNum.length - 1; i >= diff; i--) {
            if (oldNum[i] == orderNum[orderNum.length - 1 - diff]) {
                //交换后直接跳出
                swap(oldNum, diff, i);
                break;
            }
        }

        return Integer.parseInt(new String(oldNum));
    }

    private void swap(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }


    public static void main(String[] args) {
        System.out.println(new number670_2().maximumSwap(1993));
    }
}
