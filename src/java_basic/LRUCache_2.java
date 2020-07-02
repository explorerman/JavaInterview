package java_basic;

import java.util.HashMap;
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
public class LRUCache_2 {
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DlinkedNode> cache = new HashMap<Integer, DlinkedNode>();
    int size;
    int capacity;
    private DlinkedNode head;
    private DlinkedNode tail;

    public LRUCache_2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        final DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        final DlinkedNode node = cache.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                final DlinkedNode deletedNode = removeTail();
                cache.remove(deletedNode.key);
                size--;

            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void addToHead(DlinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
