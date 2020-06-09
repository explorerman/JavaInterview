package LeetCode_Concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author 李杰
 * @version 1.0
 * @Description 按序打印，使用AtomicInteger来构造两个内存屏障
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 14:15
 * @title 标题: 按序打印 leetcode_1114
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class Foo_4 {
    private Semaphore first = new Semaphore(1);
    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    public Foo_4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        first.acquire();
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();
        first.release();
    }
}
