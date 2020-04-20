package JUC_pv;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李杰
 * @version 1.0
 * @Description 使用Atmoic类类来保证同步问题
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/16 21:06
 * @title 标题: 使用synchronized类来保证同步问题
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ThreadsafeAtomicExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add() {
        cnt.incrementAndGet();
    }

    public  int get() {
        return cnt.get();
    }

    /**
     *功能描述
     * 局部变量都是在虚拟机栈中，属于线程私有，所以不会存在线程安全问题。
     */
    public void add100() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadsafeAtomicExample example = new ThreadsafeAtomicExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
