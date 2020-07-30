package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 数字1的个数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/30 11:26
 * @title 标题: 数字1的个数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number233 {
    //暴力破解，直接根据题意来解，但会超时
    int res = 0;
    public int countDigitOne(int n) {
        for (int i = 0; i <= n; i++) {
            count(i);
        }
        return res;
    }

    private void count(int number) {
        final String cur = String.valueOf(number);
        for (int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) == '1'){
                res++;
            }
        }
    }

    public static void main(String[] args) {
        new number233().countDigitOne(13);
    }
}
