package JUC_pv;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 李杰
 * @version 1.0
 * @Description 手动创建线程池
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/21 12:19
 * @title 标题: 手动创建线程池
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ThreadPoolExecutorExapmle {
    public static ThreadPoolExecutor threadPoolExecutor1;

    static {
        threadPoolExecutor1 = new ThreadPoolExecutor(5,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "ThreadPoolExecutorExapmle的线程池" + r.hashCode());
                    }
                },
        new ThreadPoolExecutor.DiscardOldestPolicy()
        );
    }
}
