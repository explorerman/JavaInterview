package LeetCode_Concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李杰
 * @version 1.0
 * @Description 按序打印，使用ReentrantLock重入锁
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 14:15
 * @title 标题: 按序打印 leetcode_1114
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class Foo_2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile boolean firstFinshed;
    private volatile boolean secondFinshed;

    public Foo_2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        printFirst.run();
        firstFinshed = true;
        condition.signalAll();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        while (!firstFinshed) {
            condition.await();
        }
        printSecond.run();
        secondFinshed = true;
        condition.signalAll();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        while (!secondFinshed) {
            condition.await();
        }
        printThird.run();
        lock.unlock();
    }
}
