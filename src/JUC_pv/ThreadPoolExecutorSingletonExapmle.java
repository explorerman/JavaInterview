package JUC_pv;

import chapter3.TraceThreadPoolExecutor;

import java.util.SplittableRandom;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorSingletonExapmle {
    private volatile static ThreadPoolExecutor threadPoolExecutor1;

    private ThreadPoolExecutorSingletonExapmle(){
    }
    public static ThreadPoolExecutor getInstance(){
        if(threadPoolExecutor1 == null){
            synchronized (ThreadPoolExecutorSingletonExapmle.class){
                if(threadPoolExecutor1 == null){
                    threadPoolExecutor1 = new ThreadPoolExecutor(5,
                            10,
                            10,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<>(1024),
                            new ThreadFactory() {
                                @Override
                                public Thread newThread(Runnable r) {
                                    return new Thread(r, "ThreadPoolExecutorSingletonExapmle的线程池" + r.hashCode());
                                }
                            },
                            new ThreadPoolExecutor.DiscardOldestPolicy()
                    );
                }
            }
        }
        return threadPoolExecutor1;
    }

}
