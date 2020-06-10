package LeetCode_Concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author 李杰
 * @version 1.0
 * @Description 打印零与奇偶数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/10 13:54
 * @title 标题: 打印零与奇偶数,使用管程，也就是重入锁
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ZeroEvenOdd_1 {
    private int n;

    //计数用的
    private int count = 1;
    //用于判断是哪个线程，0为zero，1为odd，2为even
    private int state = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd_1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n){
                if(state != 0){
                    zero.await();
                }
                printNumber.accept(0);
                if((count & 1) == 0){
                    state = 2;
                    even.signal();
                }else {
                    state = 1;
                    odd.signal();
                }
                zero.await();
            }
            odd.signal();
            even.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n){
                if(state != 2){
                    even.await();
                }else {
                    printNumber.accept(count++);
                    state = 0;
                    zero.signal();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n){
                if(state != 1){
                    odd.await();
                }else {
                    printNumber.accept(count++);
                    state = 0;
                    zero.signal();
                }
            }

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();

    }
}
