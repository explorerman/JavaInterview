package JUC_pv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 李杰
 * @version 1.0
 * @Description SemaphoreExample测试类
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/16 17:32
 * @title 标题: SemaphoreExample测试类
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class SemaphoreExample {
    /**
     * 功能描述
     * Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
     * <p>
     * 以下代码模拟了对某个服务的并发请求，每次只能有 3 个客户端同时访问，请求总数为 10。
     */
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 15;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"   ");
                    semaphore.acquire(1);
                    System.out.println(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("release = "+ Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();
    }
}
