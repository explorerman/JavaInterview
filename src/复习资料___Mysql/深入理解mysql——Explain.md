## Navicat for mysql索引内容

Navicat中可以选择的索引有三类：

- NORMAL索引是最基本的索引，并没有限制，如唯一性
- UNIQUE索引和NORMAL索引一样，只有一个差异，即索引列的全部值必须只出现一次
- FULL TEXT索引用于mysql全文搜索

索引方法：当创建索引时指定索引类型，BTREE或HASH

![image-20200619121515069](%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3mysql%E2%80%94%E2%80%94Explain.assets/image-20200619121515069.png)