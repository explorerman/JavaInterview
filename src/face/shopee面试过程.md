## shopee面经

### shopee介绍

东南亚电商，在东南亚和阿里收购的lazada在打，东南亚top2，有东南亚以及泰国在内的7-8个市场，高速发展中。氛围似乎不错，钱据说给的还行。



### 技术一面

虾皮的面试使用牛客网，邮件有链接，我以为是微信视频，刚开始没登上去让面试官等了一会有点小尴尬。

先自我介绍，我就随便说了说。因为主语言是java，所以面试官说聊聊java

#### **object equals和hashcode方法**

 面试官：为什么equals和hashcode要一起重写，不然会有什么问题。

我：以hashmap为例子举例。

这里答的不太好，我说了一种情况，他期望一种情况。刚开始没聊到一起去。

**结论:**

**只重写一个都会导致出现重复,无法覆盖**

**new一个相等意义的对象get不到**

具体比较长，可以先跳过。

##### 只重写了equals没有重写hashcode

```java
import java.util.HashMap;
import java.util.Map;

public class OnlyEquals {
    public static class String3 {

        private String value;


        public String3(String value) {
            this.value = value;

        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof String3) {
                String3 o = (String3) obj;
                return this.value.equals(o.value);
            }
            return false;

        }
    }

    public static void main(String[] args) {
        Map<String3, String> map = new HashMap<String3, String>();
        String3 str1 = new String3("fo");
        String3 str2 = new String3("fo");
        map.put(str1, "fo1");
        map.put(str2, "fo2");
        System.out.println(map.size());
        System.out.println(map.get(str1));
        System.out.println(map.get(str2));
        String3 str3 = new String3("fo");
        System.out.println(map.get(str3));
    }
}

```

输出

2
fo1
fo2
null



**因为就算“相等”,但是hash不同,导致分布在不同的数组项.**

**其实就是不相等.因为在 Map 和 Set 类集合中，用到这两个方法时，首先判断 hashCode 的值，如果 hash 相等，则再判断 equals 的结果**.

**去用一个“相等”的对象get,肯定是null.**

##### 只重写了hashcode没有重写equals

我们知道`String`类重写了hashcode方法.

String的hashCode方法实现如下， 计算方法是 `s[0]*31^(n-1) + s[1]*31^(n-2) + … + s[n-1]`，其中`s[0]`表示字符串的第一个字符，n表示字符串长度：

```
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```

比如”fo”的hashCode = `102 *31^1 + 111` = 3273， “foo”的hashCode = 102* 31^2 + 111 * 31^1 + 111 = 101574 

> 'f'的ascii码为102, 'o'的ascii码为111)

```java
import java.util.HashMap;
import java.util.Map;

public class OnlyHashCode {
    public static class String2 {

        private String value;

        public String2(String name) {
            this.value = name;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
    public static void main(String[] args) {
        Map<String2, String> map = new HashMap<String2, String>();
        String2 str1 = new String2("fo");
        String2 str2 = new String2("fo");
        map.put(str1, "fo1");
        map.put(str2, "fo2");
        System.out.println(map.size());
        System.out.println(map.get(str1));
        System.out.println(map.get(str2));
        String2 str3 = new String2("fo");
        System.out.println(map.get(str3));
    }
}
```

2
fo1
fo2
null

**这样的实现,实际也不存在相等的对象,因为equals比较的都是内存地址.**

上面这段代码中，map中有2个元素str1和str2。但是这2个元素是在哈希表中的同一个数组项中，也就是在同一串链表中。 但是为什么stu1和stu2的hashCode相同，但是两条元素都插到map里了，这是因为map判断重复数据的条件是 **两个对象的哈希码相同并且(两个对象是同一个对象或者两个对象相等[equals为true])**。 所以再给Student重写equals方法，并且只比较name的话，这样map就只有1个元素了。



#### **volatile和展开**

面试官:volatile用过吗

我:可见性，有序性，非原子。展开实现原理：读写主内存，内存屏障，编译器重排序，处理器重排序。

使用场景：double-check实现单例，volatile避免了其中重排序的问题。

面试官:提到了主内存和线程工作内存的概念，工作内存是？

我：JMM抽象概念，处理器寄存器，高速缓存，写缓存区等。

和面试官就写缓冲区的问题产生了争议，他似乎认为不存在，我说一定存在，不然没办法合并写回内存的操作，每次都写一次浪费性能。

他问了寄存器和高速缓存的区别，为什么有L1，L2，L3.这里答的不是很好。

我个人理解是寄存器到L1，L2，L3，性能逐渐下降，容量逐渐增大，寄存器存的是cpu执行的指令数据，比如add操作。其实可就寄存器的类型展开下，指令寄存器，数据寄存器等。高速缓存，实际就是缓存的内存读入的操作数据。这俩功能不一样。

面试官:重排序的类型，分别说说，为什么提高性能。

我：以编译器重排序为例子，比如读写内存的场景，在没有数据依赖的情况下，保证单线程as if serial语义，调整顺序，可以合并成读一次、写一次。提高效率。

面试官:还有吗？处理器重排序呢

我：类似的，也差不多，这两个都是输入输出嘛。

面试官:处理器重排序的时机是什么？

我：执行的时候？

面试官:程序是有程序计数器的，处理器运行时候重排序了，程序计数器不就乱了

这里没答好，我现在理解，cpu是流水线的机制，会读入多个指令，这时候程序计数器应该指向这些指令的下一行。对于读入的这些指令，处理器会重排序。



#### hashmap

这里他问到了我先开始讲了好多。

数组链表红黑树，计算hash1.8的优化，树化阀值（6和8），为啥是6和8.

初始容量，负载因子，如何选择这俩参数，是空间换时间，还是时间换空间。

1.8的其他优化，比如扩容时候重新计算hash的方式。

为什么1.7并发有死循环，1.8没了。头插，尾插的变化。



他问了一个我没想到的问题，元素的hash是无序的，红黑树是有序的，那这个顺序是怎么确定的。

这里答的不是很好，我说了compareTo方法，他说object没有这个方法也可以当key，回头看了下源码。

大体是用compareTo可以用compareTo，没有看看元素class类型的字典序，再不行就用System.identifyHash那个方法用对象生成一个hash，然后比较。



#### mysql索引

我说了聚簇索引的实现，局部性原理，空间局部，时间局部，B树B+树区别，为啥用B+，性能等。

他问还有其他索引吗，我说聚簇索引一定有，因为索引即数据，数据即索引。别的比如自适应hash索引还有一些。

谈了下主键索引和唯一非空索引的区别，我说本质是一样的，但是唯一非空索引就等于二级，需要回表。

有个没想到的问题是，聊到了mysql数据页，他问为啥是这个大小（16k），这个我还没完全搞清楚，网上说啥的都有，我先不谈了。



#### 算法题

合并2个有序链表，我说就是归并排序，一遍过。虚拟头结点+3while循环那种写法。

```java
 Node merge(Node l1 , Node l2){
     Node l = new Node(0);//dummy pre
     Node lOrigin = l;
        while(l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                l.next =l1;
                l= l.next;
                l1= l1.next;
            }else{
                 l.next =l2;
                l= l.next;
                l2= l2.next;
            }
        }
        
        while(l1 !=null){
              l.next =l1;
              l = l.next;
             l1 =l1.next;
        }dneg
        while(l2 !=null){
              l.next =l2;
              l = l.next;
             l2 =l2.next;
        }
        return lOrigin.next;
        

    }
```



#### 有啥想问他的

我想了想没有，然后谈了下，我觉得他知识很深，咋学的，他大体说了下，多问为什么。

其实没啥好问的，继续把知识砸深就行。





### 技术二面

#### 业务中的技术实现

问了能力点，我谈了思路，责任链->规则引擎->能力点，为啥这么走。

https://github.com/Imatvoid/APF

问了业务，默默掏出总结的5页，tob 物流的业务大体讲了了下，没太展开，不然说不完。

问了下MQ大报文怎么弄的，垂直按业务拆，水平拆，水平拆就是底层计算机网络IP数据包分片的思路。

都是业务中的技术问题，咋实现的。

#### 有啥问题

。。。额，没啥问题，他特地留了10分钟。然后，我没问题，他就给我讲了10分钟他们部门的业务。大体情况等。

### hr面

约二面的时候说hr面会一起，我还挺奇怪的，原来是二面后hr会打电话微信视频。我说没空，从宾馆出来了，约了1.30小时后。

个人情况，为啥要走等等。我谈了下我有好绩效，简历上可以看出来想给团队做职责外的贡献，走主要是追求挑战和成长。

谈现在薪资，我直接承认了，我说没事，可以告诉你具体数字，base很低。

谈薪资，这个就博弈嘛，每个人有每个人的方式，我赌了一下，主要是要低了感觉没必要，寄希望于觉得我要的高就再谈嘛，不至于不给，当然这是我的猜测，虽然我现在在本公司确实呆的难受。

**如果看到这个面经，觉得有点用，就祝我好运吧，哈哈，hr说下周出结果。**











