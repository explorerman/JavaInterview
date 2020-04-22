package chapter4;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试多线程访问一个对象和多线程单独分配各自对象所用时间的比较
 * 在数据量大的时候，多线程访问各自对象的时间少
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 12:21
 * @title 标题: 测试多线程访问一个对象和多线程单独分配各自对象所用时间的比较
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ThreadLocalPerformance {
    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_COUNT = 4;
    private static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>(){

        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {
        private int mode = 0;
        public RndTask(int mode){
            this.mode = mode;
        }
        public Random getRandom(){
            if(mode == 0){
                return rnd;
            } else if (mode == 1){
                return tRnd.get();
            } else{
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            long b =System.currentTimeMillis();
            for(long i=0;i<GEN_COUNT;i++){
                getRandom().nextInt();
            }
            long e =System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend" + (e-b) + "ms");
            return e - b;
        }
    }

    public static void main(String []args) throws ExecutionException, InterruptedException {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for(int i=0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(0));
        }
        long totaltime = 0;
        for(int i=0;i<THREAD_COUNT;i++){
            totaltime += futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例："+ totaltime + "ms");

        for(int i=0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(1));
        }
        totaltime = 0;
        for(int i=0;i<THREAD_COUNT;i++){
            totaltime += futs[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例："+ totaltime + "ms");
        exe.shutdown();
    }
}
