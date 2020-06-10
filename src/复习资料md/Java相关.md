## Java基础

多态

## Java锁

AQS，CAS

自定义线程池：参数是如何决定的，应用于两个地方：一个消息推送，一个交换推送。

future：为什么使用future

单例使用双检锁：为什么这么使用，以前是懒汉式。

懒汉式的缺点:

虽然满足了线程安全， 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。 

```Java
public static synchronized Singleton getUniqueInstance() {
    if (uniqueInstance == null) {
        uniqueInstance = new Singleton();
    }
    return uniqueInstance;
}
```

双检锁的优点：

```java
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
```

uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。

双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁。

 考虑下面的实现，也就是只使用了一个 if 语句。在 uniqueInstance == null 的情况下，如果两个线程都执行了 if 语句，那么两个线程都会进入 if 语句块内。虽然在 if 语句块内有加锁操作，但是两个线程都会执行 `uniqueInstance = new Singleton();` 这条语句，只是先后的问题，那么就会进行两次实例化。因此必须使用双重校验锁，也就是需要使用两个 if 语句：第一个 if 语句用来避免 uniqueInstance 已经被实例化之后的加锁操作，而第二个 if 语句进行了加锁，所以只能有一个线程进入，就不会出现 uniqueInstance == null 时两个线程同时进行实例化操作。

uniqueInstance 采用 volatile 关键字修饰也是很有必要的， `uniqueInstance = new Singleton();` 这段代码其实是分为三步执行：

1. 为 uniqueInstance 分配内存空间
2. 初始化 uniqueInstance
3. 将 uniqueInstance 指向分配的内存地址

但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。

使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。 

还可以使用静态内部类：

```java
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。只有当调用 `getUniqueInstance()` 方法从而触发 `SingletonHolder.INSTANCE` 时 SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。

这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。



可以引出：volatile，synchronized两个关键字的用法：

volatile：保证可见性，有序性，但不保证原子性，因为语句不一定是原子的，类如：add(找)

[synchronized锁字符串印发的坑](https://www.cnblogs.com/xrq730/p/6662232.html#top)



## JavaIO

BIO,NIO，AIO

## Java容器

hashmap，concurrenthashmap,weakhashmap,linkedlist

## JVM

内存分布，垃圾收集器，垃圾收集算法，字节码，内存和工作内存。

[Java对象在内存中的存储结构](https://blog.csdn.net/yiqiu3812/article/details/90610179?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase)

Jvm是什么时候申请os的内存的？

malloc备用使用的是mmap，如果你用strace跟踪jvm的话，你会发现每次jvm启动都会申请一定的内存

```text
sudo strace -f java -Xms8192m -XX:NativeMemoryTracking=summary foo.java
```

```java
import java.util.Vector;

public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        Vector v = new Vector();
        while (true)
        {
            byte b[] = new byte[1048576];
            v.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.println( "free memory: " + rt.freeMemory() );
        }
    }

}
```

JVM只会在你需要的时候向操作系统申请内存，也就是懒加载

```text
mmap(NULL, 134217728, PROT_NONE, MAP_PRIVATE|MAP_ANONYMOUS|MAP_NORESERVE, -1, 0) = 0x7f0eb26ca000
```

## java并发相关

as if serial语义保证单线程内程序的执行结果不被改变

happen-before关系保证争取同步的多线程程序的执行结果不被改变

二者都是为了在不改变程序执行结果的前提下，尽可能的提高程序执行的并行度。

### 编译器重排序和处理器重排序

### volatile

从汇编指令来看volatile进行写操作时，会在volatile修饰的共享变量的后面多出一行lock前缀的指令

该指令在多核处理器下会引发两件事情：

- 将当前处理器缓存行的数据写回到系统内存中
- 这个写回内存的操作会使在其他CPU里缓存了该内存地址的数据无效。

从内存语义角度来说：

- 可见性：对一个volatile变量的读，总能看到（任意线程）对这个volatile变量最后的写入。
- 原子性：对任意单个volatile变量的读/写具有原子性。但类似于volatile++这种复合操作不具有原子性

volatile的写-读与锁的释放-获取有相同的内存效果：volatile写和锁的释放有相同的内存语义，volatile的读与锁的获取有相同的内存语义。

volatile会建立写在读之前的happens-before关系。

线程A修改共享变量，并将修改后的数据由工作内存刷新到主内存，线程B读共享变量时，发现工作内存中的变量已经失效，需要从主内存中获取最新的数据。

volatile内存语义的实现：**编译器**在生成字节码时，会在指令序列中插入内存屏障来禁止特定类型的处理器重排序。

volatile写操作前插入**StoreStore**屏障

volatile写操作后面插入一个**StoreLoad**屏障（选择该方式，是因为大多情况下都是一个volatile写，多个volatile读）

volatile读操作后面插入**LoadLoad**屏障

volatile读操作后面插入**LoadStore**屏障

上述的优化，不同的处理器有不同的“松紧度”的处理器内存模型，内存屏障的插入还可以根据具体的处理器内存模型继续优化。

不同处理器对volatile的写-读，读-读，读-写，写-写做不同的重排序。

在x86处理器中，JMM仅需在volatile写后面插入一个storeLoad屏障即可正确实现volatile写-读的内存语义，这意味着再x86处理器中，volatile写的开销比volatile读的开销大很多（因为执行StoreLoad屏障开销会比较大）

严格限制编译器和处理器对volatile变量与普通变量的重排序，确保volatile的写-读和锁的释放-获取具有相同的内存语义。

只要volatile变量与普通变量直接的重排序可能会破坏volatile的内存语义，这种重排序就会被编译器重排序规则和处理器内存屏障插入策略禁止。

注意锁和volatile的区别：

volatile仅能保证单个volatile变量的读-写具有原子性，而锁的互斥执行的特征可以确保整个临界区代码的执行具有原子性。

### synchronized

锁是java并发编程中最重要的同步机制，锁除了让临界区互斥执行外，还可以让释放锁的线程向获取同一个锁的线程发送消息。

线程A在释放锁之前所有可见的共享变量，在线程B获取同一个锁之后，将立刻变的对B线程可见

当线程A释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中，当线程B获取锁时，JMM会把该线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须从主内存读取共享变量。

**所以：锁释放与volatile写有相同的内存语义；锁获取与volatile有相同的内存语义。**

### final

#### 逃逸分析（编译器优化）

在编程语言的编译优化原理中，分析指针动态范围的方法称之为逃逸分析。

通俗的讲，就是当一个对象的指针被多个方法或者线程引用时，我们称这个指针发生了逃逸，用来分析这种逃逸现象的方法，就称之为逃逸分析。

## java并发框框

- 信号量模型与管程模型是线程间协作的两大利器，大部分情况下，二者可以互相转换。它们的区别在于，信号量模型可以让多个线程共享临界区，而管程模型是让线程独占临界区；
- CountDownLatch主要用于一个线程等待多个线程的场景，而CyclicBarrier则用于多个线程之间互相等待的场景。