package leetcode_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李杰
 * @version 1.0
 * @Description 罗马数字转整数，方法就是使用hashmap缓存所有的key-value对，然后遍历字符串，注意有特殊情况
 * IV - 4等几种特殊情况
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/15 9:41
 * @title 标题: 罗马数字转整数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i += 1;
            }
        }
        return ans;
    }
}
