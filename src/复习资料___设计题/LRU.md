## LRU

LRU的数据结构：双向链表+哈希表
LRU要实现：get,set的时间复杂度都为1，则只能使用哈希表，但又要在lru中 查找快，插入快，删除快，有顺序之分  因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；而且我们要在 cache 中查找键是否已存在；如果容量删除头结点；每次访问还要把数据移动到链表尾部，插入也是尾部插入。
  思想很简单，就是借助哈希表赋予了链表快速查找的特性嘛：可以快速查找某个 key 是否存在缓存（链表）中，同时可以快速删除、添加节点。 

 当缓存容量已满，我们不仅仅要删除最后一个 Node 节点，还要把 map 中映射到该节点的 key 同时删除，而这个 key 只能由 Node 得到。如果 Node 结构中只存储 val，那么我们就无法得知 key 是什么，就无法删除 map 中的键，造成错误。 

自己实现LRU有两种方法：

1. 继承LinkedHashMap,构造函数中将accessOrder设置为true（默认为false），重写removeEldestEntry，可以自定义LRU容量。
2. 自己实现：在LRU中有三部分：
   1. Node 双向链表中存储的节点，Node中包含两个指针：prev，next
   2. 双向链表：addNode，moveNodeToTail，removeHead三个方法，两个私有变量：head,tail，一直指向双向链表的头和尾部
   3. LRU：自定义两个hashmap：HashMap<K, Node<V>> keyNodeMap，HashMap<Node<V>, K> nodeKeyMap，用于key和Node的相互映射。
      

[lru的数据结构图,这文章中是头部插，尾部删，注意与jdk中不一样](https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/lru-suan-fa)

## LFU

LFU 的全称是`Least Frequently Used`，表示按最近的访问频率进行淘汰，它比 LRU 更加精准地表示了一个 key 被访问的热度。