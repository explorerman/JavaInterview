package JUC_pv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李杰
 * @version 1.0
 * @Description synchronized测试类
 * synchronized可以锁对象，锁代码块，锁类（锁静态方法）
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/14 10:57
 * @title 标题: synchronized测试类
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class SynchronizedExample {
    //只作用于同一个对象，如果调用两个对象上的同步代码块，则不会同步
    public void func() {
        synchronized (this) {
            // ...
        }
    }
    //只作用于同一个对象，如果调用两个对象上的同步代码块，则不会同步
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    //锁方法
    public synchronized void func2 () {
        // ...
    }

    //锁类：作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
    public void func3() {
        synchronized (SynchronizedExample.class) {
            // ...
        }
    }

    //锁静态方法和锁类一样的效果
    public synchronized static void fun() {
        // ...
    }
    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
    }
}
