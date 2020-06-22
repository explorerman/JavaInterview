1-8讲是基础

mysql的基础主要是:日志系统，事务隔离，索引，锁等四个方面

剩下的是实战

mysql术语解释：

首先mysql查询管理器（主要将用户的请求提交给存储管理器，来实现真正的数据管理）：有DDL解释器，DML解释器

![image-20200622142553489](%E6%9E%81%E5%AE%A2%E6%97%B6%E9%97%B4mysql45%E8%AE%B2.assets/image-20200622142553489.png)

- DDL:**Data Definition Languages**数据库定义语句，用来创建数据库中的表，索引，视图，存储过程，触发器等，常用的关键字有：create，alter，drop，truncate，comment，rename
- DML:**Data Manipulation Language**，数据操作语句，用来查询，添加，更新，删除等，常用的语句关键字有：select，insert，update，delete，merge，call，explain plan，lock table，包括通用性的增删查改
- DCL: Data control language: 数据控制语句，用于授权/撤销数据库及其字段的权限（DCL is short name of Data control language which includes commands such as GRANT and mostly concerned with rights, permissions and other controls of the database system）常用的关键字有：grant，revoke
- TCL:**Transaction Control Language**,事务控制语句，用于控制事务，常用的语句关键字有：commit,rollback, savepoint, set transaction