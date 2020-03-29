# spring学习总结

## 注解

```Java
@Retention(RetentionPolicy.RUNTIME)
```

runtime才会对代码逻辑产生拦截和提示

```java
@Retention(RetentionPolicy.CLASS)
```

class注解不会对代码产生任何作用，只会对你的idea或者对应插件进行校验。

## 写代码顺序

Ctrl->service->serviceImpl->dao(不一定需要)->mapper->mapper.xml

api中放着第三方应用的接口

utils中存放工具类

task

constants常量表

entity（po,vo）实体类

## es和数据库如何保持同步

在业务代码中，查找list数据，根据是否打开es查询开关来判断是不是走es查询。

问题：es中的数据是怎么来的，es可以建索引（数据库），类型（表），索引文件（行数据），这些是数据库同步过去的还是，业务代码中主动扔进去的。

write->db->同步->es<->search

这个在es中建索引，是在数据库做的还是业务中做的

- 当业务数据发生变化时候更新对应索引信息，分为两种形式调用

- 同步调用：直接在业务方法重点调用searchService对应的方法。

- 异步调用：基于消息中间件，如kafka，rabbitmq等。

- 编写搜索业务。

- 当用户没输入关键字的时候，默认直接从数据库查询信息。

- 当用户输入关键字的时候先从elasticsearch条件查询出数据的IDs，然后拿IDs去从数据库中取。

## elastic->solr->es

## redis

[jedis和spring-data-redis的区别](https://blog.csdn.net/xhaimail/article/details/80685550)

 spring-data-redis与spring的整合，更像mybatis与spring整合，通过工厂，创建实例，再操作实例。而jedis，更像spring与MySQL结合，通过操作连接池，获取实例操作数据库 

问题三连：

redis/es是什么？

redis/es解决了项目中的什么问题？

redis只用来保存字典表数据，不保存业务数据

es保存业务数据（主要是列表里的数据），只需要将业务数据包装成json，然后调用接口就行，不过在业务层面需要手动控制事务，先写库，然后再写es，根据es的状态来判断是否成功，失败则连同数据库的操作一起回滚。

redis/es是怎么应用到项目中的？

redis基本不需要操作

es在存库的时候操作（保持事务的一致性）

扩展：es的分词算法是怎么实现的。