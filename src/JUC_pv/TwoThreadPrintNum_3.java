package JUC_pv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李杰
 * @version 1.0
 * @Description 两个线程交叉打印1-100的数字
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 13:53
 * @title 标题: 两个线程交叉打印1-100的数字
 * 使用ReentrantLock + Condition + await + signalAll
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class TwoThreadPrintNum_3 implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private static int count = 0;
    private Integer threadNo;

    public TwoThreadPrintNum_3(Integer threadNo){
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                while (count % 3 != threadNo){
                    if(count > 100){
                        break;
                    }
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count > 100){
                    break;
                }
                System.out.println("thread_" + threadNo + " "+ count);
                count++;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TwoThreadPrintNum_3 t0 = new TwoThreadPrintNum_3(0);
        TwoThreadPrintNum_3 t1 = new TwoThreadPrintNum_3(1);
        TwoThreadPrintNum_3 t2 = new TwoThreadPrintNum_3(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t0);
        executorService.execute(t1);
        executorService.execute(t2);
    }
}
