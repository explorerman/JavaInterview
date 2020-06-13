# tidb

### tidb简介：

​		 TiDB 是一个分布式 NewSQL 数据库。它支持水平弹性扩展、ACID 事务、标准 SQL、MySQL 语法和 MySQL 协议，具有数据强一致的高可用特性，是一个不仅适合 OLTP 场景还适合 OLAP 场景的混合数据库。 

### tidb的特点

​	tidb支持事务。

​	tidb存储的方式其实就是key,value。

​	 **TiDB 是 Server 计算层，主要负责 SQL 的解析、制定查询计划、生成执行器。** 

​	 TiDB 使用起来很简单，可以将 TiDB 集群当成 MySQL 来用，你可以将 TiDB 用在任何以 MySQL 作为后台存储服务的应用中，并且基本上不需要修改应用代码，同时你可以用大部分流行的 MySQL 管理工具来管理 TiDB。 

## TiKV

​	 TiKV 是分布式 Key-Value 存储引擎，用来存储真正的数据，简而言之，TiKV 是 TiDB 的存储引擎。 

## PD（Placement Driver ）

​	 PD 是 TiDB 集群的管理组件，负责存储 TiKV 的元数据，同时也负责分配时间戳以及对 TiKV 做负载均衡调度。 

## TiSpark

## 参考资料

[PingCAP官方文档](https://pingcap.com/ )

[tidb的常见问题](https://pingcap.com/docs-cn/stable/faq/tidb/#119-tidb-%E6%94%AF%E6%8C%81%E5%88%86%E5%B8%83%E5%BC%8F%E4%BA%8B%E5%8A%A1%E5%90%97)

## TiDB与MySQL

 	 TiDB 使用起来很简单，可以将 TiDB 集群当成 MySQL 来用，你可以将 TiDB 用在任何以 MySQL 作为后台存储服务的应用中，并且基本上不需要修改应用代码，同时你可以用大部分流行的 MySQL 管理工具来管理 TiDB。 

​	TiDB 目前还不支持触发器、存储过程、自定义函数、外键，除此之外，TiDB 支持绝大部分 MySQL 5.7 的语法。 

## 相关术语

### ACID

ACID 是指数据库管理系统在写入或更新资料的过程中，为保证[事务](https://pingcap.com/docs-cn/stable/glossary/#事务)是正确可靠的，所必须具备的四个特性：原子性 (atomicity)、一致性 (consistency)、隔离性（isolation）以及持久性（durability）。

- 原子性 (atomicity) 指一个事务中的所有操作，或者全部完成，或者全部不完成，不会结束在中间某个环节。TiDB 通过 Primary Key 所在 [Region](https://pingcap.com/docs-cn/stable/glossary/#regionpeerraft-group) 的原子性来保证分布式事务的原子性。
- 一致性 (consistency) 指在事务开始之前和结束以后，数据库的完整性没有被破坏。TiDB 在写入数据之前，会校验数据的一致性，校验通过才会写入内存并返回成功。
- 隔离性 (isolation) 指数据库允许多个并发事务同时对其数据进行读写和修改的能力。隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致，主要用于处理并发场景。TiDB 目前只支持一种隔离级别，**即可重复读。**
- 持久性 (durability) 指事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失。在 TiDB 中，事务一旦提交成功，数据全部持久化存储到 TiKV，此时即使 TiDB 服务器宕机也不会出现数据丢失。