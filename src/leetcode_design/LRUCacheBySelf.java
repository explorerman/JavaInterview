package java_basic;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 李杰
 * @version 1.0
 * @Description 实现一个基本的LRU, 不使用API
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/24 14:48
 * @title 标题: 实现一个基本的LRU,不使用API  使用头删，尾增的方法，与redis的方法刚好相反
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class LRUCacheBySelf<K, V> {
    private HashMap<K, Node<V>> keyNodeMap; //key到node的映射
    private HashMap<Node<V>, K> nodeKeyMap;   //node到key的映射
    private DoubleList<V> nodeList;
    private int capacity;

    public static void main(String[] args) {
        LRUCacheBySelf<Integer, String> cache = new LRUCacheBySelf<>(3);
        cache.set(1, "a");
        cache.set(2, "b");
        cache.set(3, "c");
        cache.get(1);
        cache.set(4, "d");
        cache.set(5, "e");
        cache.get(3);
        System.out.println(cache.keySet());
    }

    public LRUCacheBySelf(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("should be more than 0.");
        }
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<K, Node<V>>();
        this.nodeKeyMap = new HashMap<Node<V>, K>();
        this.nodeList = new DoubleList<V>();
        this.capacity = capacity;
    }

    public void set(K key, V value) {
        if (this.keyNodeMap.containsKey(key)) {
            final Node<V> node = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        } else {
            Node<V> newNode = new Node<>(value);
            this.keyNodeMap.put(key,newNode);
            this.nodeKeyMap.put(newNode, key);
            this.nodeList.addNode(newNode);
            if(this.keyNodeMap.size() == this.capacity + 1){
                this.removeMostUnusedCache();
            }
        }
    }

    private void removeMostUnusedCache(){
        final Node<V> removeNode  = this.nodeList.removeHead();
        final K removeKey  = this.nodeKeyMap.get(removeNode);
        this.nodeKeyMap.remove(removeNode);
        this.keyNodeMap.remove(removeKey);
    }

    //get的时候，返回节点的值，并且将该结点，移动到链表尾部表示刚刚使用过
    public V get(K key) {
        if (this.keyNodeMap.containsKey(key)) {
            final Node<V> res = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(res);
            return res.value;
        }
        return null;
    }

    public Set<K> keySet(){
        final Set<K> ks = this.keyNodeMap.keySet();
        return ks;
    }

    /**
     * 功能描述
     *
     * @param * @param null
     * @author 李杰
     * @name 双向链表的node节点, 和prev, next双向的指针，跟树形结构一样。
     * @createTime: 2020/4/24 14:59
     * @return {@link null}
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static class Node<V> {
        public V value;
        public Node<V> prev;   //上一个节点
        public Node<V> next;   //下一个节点

        public Node(V value) {
            this.value = value;
        }
        public V getValue(){
            return value;
        }
    }

    /**
     * 功能描述
     *
     * @param * @param null
     * @author 李杰
     * @name head优先级最低，tail优先级最高，头删，尾插
     * 包含三种操作：
     * * 1.当加入一个节点时，将新加入的节点放在这个链表的tail,并将这个节点设置为新的尾部。
     * * 2.对这个结构中的任意节点，都可以抽出来并放到tail
     * * 3.移除head节点并返回这个节点，然后将head-next设置为新的head节点。
     * @createTime: 2020/4/24 15:07
     * @return {@link null}
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static class DoubleList<V> {
        private Node<V> head;
        private Node<V> tail;

        public DoubleList() {
            this.head = head;
            this.tail = tail;
        }

        //操作1：当加入一个节点时，将新加入的节点放在这个链表的tail,并将这个节点设置为新的尾部。
        public void addNode(Node<V> newNode) {
            if (newNode == null) {
                return;
            }
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
        }

        //操作2：对这个结构中的任意节点，都可以抽出来并放到tail
        public void moveNodeToTail(Node<V> node) {
            if (this.tail == node) {
                return;
            }
            if (this.head == node) {
                this.head = node.next;
                this.head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        //操作3：移除head节点并返回这个节点，然后将head-next设置为新的head节点。
        public Node<V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.prev = null;
            }
            return res;
        }
    }
}
