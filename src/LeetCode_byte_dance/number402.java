package LeetCode_byte_dance;

import java.util.ArrayList;

/**
 * @author 李杰
 * @version 1.0
 * @Description 移掉K位数字
 * 使用单调栈
 * 求最小数字,构造一个递增单调栈，如果碰到小于栈顶的元素，则将栈顶元素出栈，保证高位的数尽可能的小
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/10 11:16
 * @title 标题: 移掉K位数字，使得剩下的最小
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number402 {
    //1432219
    public static String removeKdigits(String num, int k) {
        ArrayList<Character> res = new ArrayList<>();
        int len = num.length(), keep = len - k;
        for (char cur : num.toCharArray()) {
            while (k > 0 && res.size() > 0 && res.get(res.size() - 1) > cur) {
                res.remove(res.size() - 1);
                k--;
            }
            res.add(cur);
        }
        //如果还有k，则直接把后面的元素删除
        for(int i=0; i<k; ++i) {
            res.remove(res.size() - 1);
        }
        while (!res.isEmpty() && res.get(0) == '0'){
            res.remove(0);
        }
        StringBuilder sb = new StringBuilder();
        for (char cur : res){
            sb.append(cur);
        }
        return res.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        removeKdigits("1432219",3);
    }
}
