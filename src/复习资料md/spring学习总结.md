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

