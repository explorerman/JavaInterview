package java_basic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 李杰
 * @version 1.0
 * @Description lru的实现方式
 * 继承LinkedHashMap，构造函数中将accessOrder设置为true，重写removeEldestEntry
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/24 12:34
 * @title 标题: lru的实现方式
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = -1730062295475920794L;
//    设定最大缓存空间 MAX_ENTRIES 为 3；
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        //覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        //使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        cache.put(5, "e");
        cache.get(3);
        System.out.println(cache.keySet());
    }
}
