复习内容：hashmap的遍历

遍历mapkey的几种方式：

通过map.keySet()

```java
//方法一：通过得到key的值，然后获取value; 
for(String key : map.keySet()){ 
　　String value = map.get(key); 
　　System.out.println(key+" "+value); 
} 
```

```java
//使用迭代器，获取key; 
Iterator<String> iter = map.keySet().iterator(); 
while(iter.hasNext()){ 
　　String key=iter.next(); 
　　String value = map.get(key); 
　　System.out.println(key+" "+value); 
} 
```

通过map.entrySet()

```java
//方法一：循环map里面的每一对键值对，然后获取key和value 
for(Entry<String, String> vo : map.entrySet()){ 
　　vo.getKey(); 
　　vo.getValue(); 
　　System.out.println(vo.getKey()+"  "+vo.getValue()); 
} 
```

```java
//使用迭代器，获取key 
Iterator<Entry<String,String>> iter = map.entrySet().iterator(); 
while(iter.hasNext()){ 
　　Entry<String,String> entry = iter.next(); 
　　String key = entry.getKey(); 
　　String value = entry.getValue(); 
　　System.out.println(key+" "+value); 
}
```

hashmap：可以存放任何东西，匿名内部类

```java
Map<String, Object> map = new HashMap<String, Object>() {
    　　{
        　　put("name", "June");  
       　　 put("age", 12);  
    　　}
　　};
```

这边有必要说清楚两个大括号表示的是啥意思，是一种什么语法呢？其实，外层的一组“{}”表示的是一个匿名类，内层的一对“{}”表示的是实例初始化块，然后这边还有一点需要明白，实例初始化块的代码在编译器编译过后，是放在类的构造函数里面的，并且是在原构造函数代码的前面。   

 3.String的用法：

```java
string.charAt(index), string.toCharArray()
```

