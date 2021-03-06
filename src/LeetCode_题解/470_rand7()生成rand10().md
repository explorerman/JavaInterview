470——已知rand7()函数，求生成rand10()函数

题解：本题是概率题，最终目的是由等概率的rand7生成等概率的rand10

已知 rand_N()可以等概率的生成【1-N】范围的随机数，那么：

（rand_X() - 1）* Y  + rand_Y() ==> 可以等概率的生成【1， X * Y】范围的随机数，即实现了rand_XY()

要实现rand10()，就要先实现rand_N(),并且保证N大于10且是10的倍数。这样在通过rand_N() % 10 + 1就可以得到【1-10】范围的随机数了。

所以套用公式：

（rand7() - 1）* 7 + rand7() 可以等概率生成【1- 49】范围的随机数，只有剔除41-49的数 ，然后进行rand_N() % 10 + 1

```java
 public int rand10() {
        int res;
        while (true){
            //构造1-49的均匀分布
            res = (rand7() - 1) * 7 + rand7();
            //剔除大于40的值，1-40等概率出现
            if(res <= 40) break;
        }
        //构造1-10的均匀分布，+1是为了解决40%10==0的情况
        return res % 10 + 1;
    }
```

