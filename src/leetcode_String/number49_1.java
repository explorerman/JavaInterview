package leetcode_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
public class number49_1 {
    //
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = null;
        HashMap<String, List<String>> keys = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final char[] chars = strs[i].toCharArray();
            //按照字典项排序
            Arrays.sort(chars);
            //构造map的key
            final String key = String.valueOf(chars);
            if(keys.containsKey(key)){
                keys.get(key).add(strs[i]);
            }else {
                List<String> level = new ArrayList<>();
                level.add(strs[i]);
                keys.put(key, level);
            }
        }
        res = new ArrayList<List<String>>(keys.values());
        return res;
    }

}
