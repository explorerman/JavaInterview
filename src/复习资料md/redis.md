## 缓存的通用性

缓存命中

缓存一致性问题

缓存应用地方：all

缓存存储方式：hash存储，顺序存储

解决hash存储问题：一致性哈希

## memcached

使用场景：

1. 缓存业务数据：表单数据，字典项等基本，所有的都放缓存了

## redis

使用场景：

1. 主要用来存字典表
2. 也可以存业务数据
3. 存基础平台的一些信息：机构树，人员数等

![image-20200511171919456](C:\Users\JIEE_Shine\AppData\Roaming\Typora\typora-user-images\image-20200511171919456.png)

![image-20200511171854077](C:\Users\JIEE_Shine\AppData\Roaming\Typora\typora-user-images\image-20200511171854077.png)

redis的目标就是为了防止阻塞

redis为了防止出现bigkey，hotkey

为了防止bigkey，将redis拆分，把一个大json放到一个对象里，会导致bigkey问题，把对象拆分，类似于list记录id,每个id对应json的子数据。

[redis中hotkey,bigkey的解决方法](https://www.jianshu.com/p/58615a1e2cac)

[本地缓存等](https://www.jianshu.com/p/c50c3f22650b)

复习内容：redis的基础结构，zset（跳表）的数据结构，LRU，LFU,持久化，其他的一些实现：布隆过滤器，hyperloglog等，分布式锁。

## es

简单介绍一下es，这边的业务场景是存列表，存表单数据。原理就是倒排索引，准备一下倒排索引的概念。