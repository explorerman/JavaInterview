package leetcode_String;

/**
 * @author 李杰
 * @version 1.0
 * @Description 整数转罗马数字,使用贪心算法，也是先使用key-value缓存所有的整数-罗马数字的对应关系（从大到小排序）
 * 然后根据贪心算法的思想，每次都选最大的数字
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/15 9:47
 * @title 标题: 整数转罗马数字
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number12 {
    //从大到小排序，优先选择大的数字
    // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
    // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (num >= values[i]){
                num -= values[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }
}
