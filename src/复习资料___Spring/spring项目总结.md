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

### es的使用

1. create

   create(String sessionId, String indexName, List<Map> dataList, boolean refresh)，

   其中sessionId， 可以为null

   indexName 索引名称,目前oa中只有一个gwgl的index

   dataList  添加的记录, List格式, Map结结构中key为字段名称， value为具体数据

   相当于hash一样，大key是indexName,小key是map的key，可以传入处理单id

   refresh   是否立即刷新，true：强制刷新，可以及时检索到，false：按es的刷新策略刷新，有一定延时，但对存储日志效率高

2. update

   更新es

3. search

   查找es

   

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

### AegisCacheUtils的用法

存放的是通过redis对应表中获取字典数据等的信息的API，常用的两个就是获取list和map的方法：

1. getMapCacheValueFromRedisByTableNameAndDmz(String tableName, String dmz)

   tablename就是表名，dmz就是数据库中redis对应表的index_columns列的值，其中index_columns列的值可能是个字符串：wjlxId,appId,orgId。

## vo,po,do,dto

1. vo就是我们在web的controller层返回的Object，在接口中这个VO都会被转成Json对象输出，view object。 
2.  DO就是一个业务实体对象 
3.  DTO就是一个复合的DO对象，由于业务需要我们需要调用业务A查询数据得到业务对象A，再调用业务B查询数据得到业务对象B然后一系列封装转化得到复合的对象C此时他就是一个DTO，data transfer object 它是一个服务层和服务层以上之间转换的对象。 
4.  po持久化对象 一般放在domain 或者 Entry中是一个与数据库表关联的对象，每一个属性都是表中的一个字段。
   当业务过于简单时，po ，do，dto，vo并没有什么区别的时候我们也可以直接复用PO 

## fastjson的使用

fastjson和Jackson的比较：

fastsjon是阿里的，Jackson外国人用的比较多

[参考知乎问题，fastjson这么快为什么老外还热衷于Jackson](https://www.zhihu.com/question/44199956)

[fastjson在创建对象时与jackson的比较，fastjson快一些](https://www.jianshu.com/p/a3ebb54445be)

常用的工具：JSONObject,JSON

## spring中调用远程API

1. 在常量类中定义远程API的路径：可以写成单例：双检索等。

   ```java
    private static final String API_QX001ORGAPI_QUERYORGBYORGID = "/Qx001OrgAPI/queryOrgByOrgId";
   
       public static String getApiQx001orgapiQueryorgbyorgid() {
           return API_QX001ORGAPI_QUERYORGBYORGID;
       }
   ```

2. 如果是公用的API，则可以在util包里写一个公用方法：方法的大概过程为：

   1. 获取上面写的API路径
   2. 根据API路径实例化restRequest类
   3. 创建RestClientUtils类似的类用来发起post，put等rest请求，请求参数中可以根据实际自定义，一般都转化为json形式。
   4. 根据3中返回的response的状态，如果返回错误，则返回异常信息
   5. 如果返回正常，则获取body,将body转成JsonResult,并取出info体,用于别的业务.

