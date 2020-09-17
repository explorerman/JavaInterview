/**
 * @author 李杰
 * @version 1.0
 * @Description 实现strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/17 18:12
 * @title 标题: 实现strStr()
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number28 {
    // 输入: haystack = "heoll", needle = "ll"
    //输出: 2
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i <= hLen - nLen; i++) {
            if(haystack.substring(i, i + nLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
