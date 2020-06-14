## redis

Redis集群

如何从海量数据里快速找到所需？

分片：按某种规则去划分数据，分散存储在多个节点上

一致性哈希：根据ip或者业务id，hash取模组成hash环

缺点：hash环的数据倾斜问题，可以引入虚拟节点。

Redis主从同步：全同步过程

增量同步过程

Redis sentinel哨兵

解决主从同步maser宕机后的主从切换问题：

- 监控：检查主从服务器是否运行正常
- 提醒：通过API向管理员或者其他应用程序发送故障通知
- 自动故障迁移：主从切换

流言协议gossip：

在杂乱无章中寻找一致

- 每个节点都随机地与对方通信，最终所有节点的状态达成一致
- 种子节点定期随机向其他节点发送节点列表以及需要传播的消息
- 不保证信息一定会传递给所有节点，但是最终会趋于一致

AOF持久化：

日志重写解决AOF文件大小不断增大的问题：fork等

rdb的配置文件

save(阻塞Redis的服务进程，直到rdb文件被创建完毕),bgsave，可以使用Java定时器去调用bgsave，按照时间存放不同的dump.rdb文件

自动触发rdb持久化

- 根据Redis.config配置里的save m n定时触发（用的是bgsave）
- 主从复制时，主节点自动触发
- 执行debug reload
- 执行shutdown且没有开启aof持久化

bgsave的原理：fork，copy-on-write

Redis的pub/sub是实时的，如果当时没收到，那就收不到了，要想实现可控制的，使用kafka等专业消息队列

分布式锁：

需要解决的问题

- 互斥性
- 安全性
- 死锁
- 容错

setnx key value：如果key不存在，则创建并赋值

时间复杂度是1，设置成功返回1，失败0

如何解决setnx长时间存在的问题，使用expire设置过期时间。

缺点：原子性不能得到保障。

set key value [EX seconds] [PX milliseconds] [NX] [XX]

EX second:设置键的过期时间为second秒

PX millisecond:设置键的过期时间为millisecond毫秒

NX：只在键不存在时，才对键进行设置操作

XX：只在键已经存在时，才对键进行设置操作。

set操作成功完成时，返回OK，否则返回null

mem和Redis的区别：

mem:代码层次类似hash，mem不支持主从，也不支持分片

Redis：100000+qps

redis快的原因：

- 完全基于内存，绝大部分请求是纯粹的内存操作，执行效率高
- 数据结构简单，对数据操作也简单
- 采用单线程，单线程也能处理高并发请求，想多核可以启动多个实例
- Redis的主线程是单线程的，主线程进行：io处理，以及io对应的相关请求的业务处理，过期键的处理，父子协调，集群协调等，除了io事件之外的逻辑，会被分装成任务，周期性的处理，因为采用单线程的处理，所以多个客户端对同一个键进行写操作的时候，都有主线程串行的操作，省去了上下文切换和锁竞争，也不会有并发的问题。CPU并不是制约Redis并发量的瓶颈，制约瓶颈的是网络。
- 单线程只是在处理网络请求时是单线程的，在处理别的时候，并不是真正的单线程，譬如持久化时的fork
- 使用多路复用io，非阻塞io

多路复用模型：

fd:file descriptor文件描述符 

​	一个打开的文件通过唯一的描述符进行引用，该描述符是打开文件的元数据到文件本身的映射。

Redis采用的多路复用函数：epoll/kqueue/evport/select?

- 因地制宜
- 优先选择时间复杂度为O(1)的IO多路复用函数作为底层实现
- 以时间复杂度为O（n）的select作为保底
- 基于reactor设计模式监听IO事件

Redis的所有命令都是原子的

string: 最基本的数据类型，二进制安全，底层sdshdr，set,get

hash：string元素组成的字典，适合用于存储对象。 hset,hget

List：列表，按照string元素插入顺序排序, lpush, lrange

set：string元素组成的无序集合，通过hash表实现，不允许重复,sadd, smembers

zset:通过分数来为集合中的成员进行从小到大的排序 zadd myzset 3 abc; zadd myzset 1 abd,

zrangebyscore myzset 0 10,取0-10条记录

用于计数的hyperloglog，用于支持存储地理位置信息的geo

底层数据类型：

1. 简单动态字符串
2. 链表
3. 字典
4. 跳表
5. 整数集合
6. 压缩列表
7. 对象