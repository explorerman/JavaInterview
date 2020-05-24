# hashmap

## 1.7版本



## 1.8版本

# concurrentHashmap

## 1.7版本

1.7版本下，concurrentHashmap的实现和hashmap思想一样，差别就是concurrenthashmap在hashmap拉链的上层增加了一个继承了ReentrantLock的segment，segment下面使用拉链，多个线程可以同时访问不同分段锁上的桶(默认也是16)，从而使其并发度更高（并发度就是 Segment 的个数）

结构图如下:

![img](https://upload-images.jianshu.io/upload_images/2184951-af57d9d50ae9f547.png?imageMogr2/auto-orient/strip|imageView2/2/w/767/format/webp)

## 1.8版本