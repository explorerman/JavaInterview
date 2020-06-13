## 杭州商业化广告：

1.设计一个blockingqueue，满足如下要求： 

1、大小固定 

2、多线程 

3、支持泛型 

put、get方法

参考ArrayBlockingQueue<E>，有界队列的实现

在put,offer,poll都用ReentrantLock锁住,队列中的元素使用Object[] items

2. Redis中的value过大会有什么问题？为什么？

使用Redis时，要保证的就是不阻塞Redis，如果Redis中的value过大，导致在分片的时候，某个具体存储这个big key的实例内存使用量远大于其他实例，造成内存不足，拖累整个集群，单线程还可能会阻塞Redis，删除时，如果直接进行del，可能也会阻塞实例。