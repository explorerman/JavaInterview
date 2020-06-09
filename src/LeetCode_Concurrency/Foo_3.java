package LeetCode_Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

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
public class Foo_3 {

    private AtomicInteger firstFinshed = new AtomicInteger();
    private AtomicInteger secondFinshed = new AtomicInteger();

    public Foo_3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //first线程+1
        firstFinshed.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (firstFinshed.get() != 1) {}
        printSecond.run();
        secondFinshed.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondFinshed.get() != 1){}
        printThird.run();
    }
}
