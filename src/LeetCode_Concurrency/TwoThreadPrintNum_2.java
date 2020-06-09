package LeetCode_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李杰
 * @version 1.0
 * @Description 两个线程交叉打印1-100的数字
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 13:53
 * @title 标题: 两个线程交叉打印1-100的数字
 * 思路：多个线程共用一把锁，然后自然数0-100是公共资源，让3个线程去消费；
 * 我们可以每个线程加上一个标号：0，1，2，来表示具体是哪个线程； 通过一个计数器对3进行求余，余数和具体的线程标号去比较，
 * 只有当余数和线程标号相等的时候才进行打印(不等加入等待队列)，打印完计数器进行自增；
 * 然后唤醒等待队列里面线程去获取锁，获取锁成功则继续执行以上步骤，否则加入锁的同步队列中，等待上一个线程唤醒；
 *
 * 使用volatile + synchronized + wait + notifyAll + 线程序号
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class TwoThreadPrintNum_2 implements Runnable {
    private static final Object lock = new Object();
    private static int count = 0;
    private Integer threadNo;

    public TwoThreadPrintNum_2(Integer threadNo){
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock){
                while (count % 3 != threadNo){
                    if(count > 100) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count > 100){
                    break;
                }
                System.out.println("thread_" + threadNo + " " + count);
                count++;
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadPrintNum_2 t0 = new TwoThreadPrintNum_2(0);
        TwoThreadPrintNum_2 t1 = new TwoThreadPrintNum_2(1);
        TwoThreadPrintNum_2 t2 = new TwoThreadPrintNum_2(2);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(t0);
        executorService2.execute(t1);
        executorService2.execute(t2);
    }
}
