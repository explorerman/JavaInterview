package JUC_pv;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李杰
 * @version 1.0
 * @Description CountDownLatch测试类
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/16 17:03
 * @title 标题: CountDownLatch测试类
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class CountdownLatchExample {
    /**
     *功能描述
     * @name 维护了一个计数器 cnt，每次调用 countDown() 方法会让计数器的值减 1，减到 0 的时候，那些因为调用 await() 方法而在等待的线程就会被唤醒。
     * @createTime: 2020/4/16 17:09
     * @param  * @param args
     * @author 李杰
     * @return
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.print("run.."+ finalI +" ");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
