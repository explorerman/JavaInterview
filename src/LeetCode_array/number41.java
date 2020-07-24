package LeetCode_array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李杰
 * @version 1.0
 * @Description 缺少的第一个正数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/24 13:51
 * @title 标题: 缺少的第一个正数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number41 {
    //时间复杂度为O（N），N为数组长度，遍历了两次数组，第二次【1，len】
    //空间复杂度：O（N），把N个数存在哈希表里面，使用了N个空间，哈希表的大小与数组的长度是线性相关的
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int cur : nums) {
            hashSet.add(cur);
        }
        for (int i = 1; i <= len; i++) {
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return len + 1;
    }
}
