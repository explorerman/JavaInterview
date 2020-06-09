package LeetCode_Concurrency;

/**
 * @author 李杰
 * @version 1.0
 * @Description 按序打印，使用synchronized
 * 题意还是要让线程按顺序走，3个线程，加两个内存屏障来让三个线程有序
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 14:15
 * @title 标题: 按序打印 leetcode_1114
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class Foo {

    private volatile boolean firstFinshed;
    private volatile boolean secondFinshed;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock){
            printFirst.run();
            firstFinshed = true;
            lock.notifyAll();

        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock){
            while (!firstFinshed){
                lock.wait();
            }
            printSecond.run();
            secondFinshed = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock){
            while (!secondFinshed){
                lock.wait();
            }
            printThird.run();
        }
    }
}
