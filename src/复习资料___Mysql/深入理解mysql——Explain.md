## Explain详解

SELECT, DELETE,UPDATE,REPLACE都可以查看执行计划

![image-20200619122826752](%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3mysql%E2%80%94%E2%80%94Explain.assets/image-20200619122826752.png)

列一下：


| 列名            | 描述                                                       |
| :-------------- | :--------------------------------------------------------- |
| `id`            | 在一个大的查询语句中每个`SELECT`关键字都对应一个唯一的`id` |
| `select_type`   | `SELECT`关键字对应的那个查询的类型                         |
| `table`         | 表名                                                       |
| `type`          | 针对单表的访问方法                                         |
| `possible_keys` | 可能用到的索引                                             |
| `key`           | 实际上使用的索引                                           |
| `key_len`       | 实际使用到的索引长度                                       |
| `ref`           | 当使用索引列等值查询时，与索引列进行等值匹配的对象信息     |
| `rows`          | 预估的需要读取的记录条数                                   |
| `filtered`      | 某个表经过搜索条件过滤后剩余记录条数的百分比               |
| `Extra`         | 一些额外的信息                                             |

![image-20200619122853921](%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3mysql%E2%80%94%E2%80%94Explain.assets/image-20200619122853921.png)

### Extra

### `Using index`

当我们查询列表以及搜索条件中只包含属于某个索引的列，也就是在可以使用索引覆盖的情况下，在extra列会提示该额外信息。

### `Using index condition`

有些搜索条件中虽然出现了索引列，但却不能使用索引

### `Using where`

当我们使用全表扫描来执行对某个表的查询，并且该语句的where子句中有针对该表的搜索条件时，在extra列中会提示上述额外信息。

### `No tables used`

当查询的语句没有from子句时将会提示该额外信息

### `Impossible WHERE`

查询语句的`WHERE`子句永远为`FALSE`时将会提示该额外信息



## Navicat for mysql索引内容

Navicat中可以选择的索引有三类：

- NORMAL索引是最基本的索引，并没有限制，如唯一性
- UNIQUE索引和NORMAL索引一样，只有一个差异，即索引列的全部值必须只出现一次
- FULL TEXT索引用于mysql全文搜索

索引方法：当创建索引时指定索引类型，BTREE或HASH

![image-20200619122728471](%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3mysql%E2%80%94%E2%80%94Explain.assets/image-20200619122728471.png)