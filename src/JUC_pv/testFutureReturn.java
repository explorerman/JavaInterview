package JUC_pv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//测试两个线程前后执行，互不影响，但主线程，可以使用新线程的返回值。
public class testFutureReturn {
    private static class FutureTaskTest{
       static FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 1;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count = 1;
        for (int i = 0; i < 10; i++) {
            count += i;
        }
        System.out.println(count);
        Thread futureTaskTest = new Thread(FutureTaskTest.futureTask);
        futureTaskTest.start();

        System.out.println(FutureTaskTest.futureTask.get() + 1);
    }
}
