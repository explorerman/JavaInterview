如何设计一个关系型数据库

为什么要使用索引？

什么样的信息能称为索引？

索引的数据结构？

## mysql

怎么设计一个关系型数据库

hash索引的缺点：

仅能满足：= in，不能使用范围查询

无法被用来避免数据的排序操作

不能利用部分索引键查询

不能避免表扫描

遇到大量hash值相等的情况后性能并一定就会比Btree索引高

bitmap索引

密集索引和稀疏索引

innodb数据即索引，索引即数据

mysiam数据和索引分开

如何定位并优化慢查询sql

1. 根据慢日志定位慢查询sql
2. 使用explain等工具分析sql
3. 修改sql或者尽量让sql走索引

show variable like '%quer%' 查询系统相关变量 slow_query_log 

show status like '%slow_queries%'

set global slow_query_log = on 打开慢查询

set global long_query_time = 1 这是慢查询时间为1s

explain中type（是否走索引，all，ref等），extra（using filesort，using temporary）重点,extra出现以下2项意味着MySQL根本不能使用索引，效率会受到重大影响，应尽可能对此进行优化

强制走索引：force index 

联合索引的最左匹配原则：

myisam与innodb关于锁方面的区别：

rc,rr级别下的innodb的非阻塞读如何实现，rr:repeatable read;  rc:read committed

给select上排他锁，可以在后面加for update

innodb是采用二段锁，加锁和减锁是分两个步骤进行的

show variable like 'autocommit'

set auto commit = 0; 关闭自动提交

innodb加共享锁：lock in share mode

表级锁跟索引无关，涉及到表里的数据都会上表锁。

**行级锁，除了主键索引外，别的键二级索引，只要使用索引，涉及的行都会被上共享锁或者排他锁**

当不走索引的时候，整张表都会被锁住，用的是表级锁，所以innodb在sql没用到索引的时候，会走表锁。

走索引用的是行级锁，或gap锁（走普通非唯索引的时候用到）

innodb还支持表级意向锁，ls，lx

myisam适合的场景：

1. 频繁执行全表count语句
2. 对数据进行增删改的频率不高，查询非常频繁。
3. 没有事务

innodb适合的场景：

1. 数据增删查改都相当频繁
2. 可靠性要求比较高，要求支持事务

select @@tx_isolation查看数据库的隔离级别

set session  transaction isolation levle read uncommitted 设置为读未提交

rr级别下：当前读都是最新的，也就是符合可重复读的隔离级别

快照读，可能读到之前的记录，也可能读到最新的记录

undo包含：insert undo,update undo

insert undo 在事务提交后，就没用了

update undo重要，更新，删除都靠它

read view针对可重复读

3-16重新看

c