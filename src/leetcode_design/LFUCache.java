package java_basic;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node{
        int key;
        int value;
        int frequent = 1;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DLinkedNode{
        Node head;
        Node tail;
        public DLinkedNode(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        //头插入
        public void addToHead(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        //尾删除
        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //移除尾部节点
        private Node removeTail() {
            Node res = tail.prev;
            removeNode(res);
            return res;
        }

    }
    //存放真实node
    private Map<Integer, Node> cache = new HashMap<>();
    //访问次数哈希表,key为访问次数，DLinkedNode来对应的双向链表
    private Map<Integer, DLinkedNode> frequentMap = new HashMap<>();
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        final Node node = cache.get(key);
        if(node == null) return -1;
        //更新当前节点的频率
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        //如果node存在，则更新value，并更新节点频率
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            //如果实际存放的容量等于最大容量，说明要淘汰访问频率最小的双向链表的尾部
            if (size == capacity) {
                DLinkedNode minFreqLinkedList = frequentMap.get(min);
                //移除cache的节点
                cache.remove(minFreqLinkedList.tail.prev.key);
                //移除尾部
                minFreqLinkedList.removeTail();
//                minFreqLinkedList.removeNode(minFreqLinkedList.tail.prev); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            //新结点，访问频率为1，所以找第一个桶
            DLinkedNode linkedList = frequentMap.get(1);
            if (linkedList == null) {
                linkedList = new DLinkedNode();
                frequentMap.put(1, linkedList);
            }
            linkedList.addToHead(newNode);
            size++;
            min = 1;
        }
    }
    //更新当前节点的频率
    private void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.frequent;
        //找到具体的那条链表
        DLinkedNode linkedList = frequentMap.get(freq);
        //从链表中移除元素
        linkedList.removeNode(node);
        //如果当前节点就是在最小访问频率的那条链表，并且当前链表没有节点了，则更新min为freq + 1
        if (freq == min && linkedList.head.next == linkedList.tail) {
            min = freq + 1;
        }
        //将当前元素对应的访问频率+1，并加入新freq对应的链表
        node.frequent++;
        linkedList = frequentMap.get(freq + 1);
        //如果没有新访问频率的双向链表，则创建一条
        if (linkedList == null) {
            linkedList = new DLinkedNode();
            frequentMap.put(freq + 1, linkedList);
        }
        linkedList.addToHead(node);

    }


}
