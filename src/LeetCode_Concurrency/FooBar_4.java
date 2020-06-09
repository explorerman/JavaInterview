package LeetCode_Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 李杰
 * @version 1.0
 * @Description 交替打印FooBar, 使用循环栅栏，CyclicBarrier
 * 这种方法和上一个无锁，都是利用了线程占用CPU的时间片，耗时让该线程的时间片用完
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 15:58
 * @title 标题: 交替打印FooBar LeetCode_1115
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class FooBar_4 {
    private int n;

    CyclicBarrier cb = new CyclicBarrier(2);
    //是否完成的标志
    private volatile boolean isFin = true;

    public FooBar_4(int n) {
        this.n = n;
    }

    //生产者
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!isFin) {
                Thread.sleep(1);
            };
            printFoo.run();
            isFin = false;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    //消费者
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            isFin = true;
        }
    }
}
