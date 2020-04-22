package chapter4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 11:25
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ThreadLocalDemo_Gc {
    static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is gc");
        }
    };
    static volatile CountDownLatch cd = new CountDownLatch(10000);

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (t1.get() == null) {
                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        private static final long serialVersionUID = -5691152505939500328L;

                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + ":create SimpleDateFormat");
                }
                Date t = t1.get().parse("2015-03-29 19:29:" + i % 60);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        cd.wait();
        System.out.println("mission complete!!");
        t1 = null;
        System.gc();
        System.out.println("first GC complete!!");
        t1 = new ThreadLocal<SimpleDateFormat>();
        cd = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        cd.wait();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complete!!");
    }
}
