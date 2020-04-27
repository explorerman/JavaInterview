package Java_Collections;

import java.util.HashMap;

/**
 * @author 李杰
 * @version 1.0
 * @Description Hashmap源码分析
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/26 10:11
 * @title 标题: Hashmap源码分析
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            hashMap.put(i, i);
        }
        hashMap.put(11,11);
        hashMap.put(12,12);
        hashMap.put(17,17);
        final int size = hashMap.size();
        System.out.println(size);
    }
}
