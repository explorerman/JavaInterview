package leetcode_String;

import java.util.*;

/**
 * @author 李杰
 * @version 1.0
 * @Description 字母异位词分组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/15 16:05
 * @title 标题: 字母异位词分组
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number49 {
    //思路就是：依次比较数组中的字符串，定义一个Boolean数组，用于判断元素是否已经访问过，用于剪枝
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> level = null;
            if(!used[i]){
                level = new ArrayList<>();
                level.add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    if(isAnagram(strs[i], strs[j])){
                        used[j] = true;
                        level.add(strs[j]);
                    }
                }
            }
            if(level != null){
                res.add(level);
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == t.length() && s.length() == 0) return true;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int length = chars.length;
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < length; i++) {
            if(chars[i] != chart[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
