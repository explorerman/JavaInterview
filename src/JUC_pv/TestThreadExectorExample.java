package JUC_pv;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadExectorExample {

    private volatile static Long start = System.currentTimeMillis();

    public static void useTestThreadExectorExample(){
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        for (int i = 0; i < 100; i++) {
            ThreadPoolExecutorExapmle.threadPoolExecutor1.execute(() -> {
                example.add();
            });
        }
        System.out.println("ThreadPoolExecutorExapmle总耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(example.get());
    }

    public static void useThreadPoolExecutorSingletonExapmle(){
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        for (int i = 0; i < 100; i++) {
            ThreadPoolExecutorSingletonExapmle.getInstance().execute(() -> {
                example.add();
            });
        }
        System.out.println("ThreadPoolExecutorSingletonExapmle总耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(example.get());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(2);
            for (int i = 0; i < 1; i++) {
                executorService.execute(() -> {
                    useTestThreadExectorExample();
                    useThreadPoolExecutorSingletonExapmle();
                });
            }
    }

}
