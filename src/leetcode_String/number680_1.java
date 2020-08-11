package leetcode_String;

/**
 * @author 李杰
 * @version 1.0
 * @Description 验证回文字符串2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/11 15:31
 * @title 标题: 验证回文字符串2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number680_1 {
    //"abca"
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                //flag标记是否删除过元素
                //flag1表示删除右指针对应的字符，留下左边的字符串，判断余下的字符串是否能成为回文串
                //flag2是删除左边的字符，留下右边的字符串，判断余下的字符串是否能成为回文串
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}

