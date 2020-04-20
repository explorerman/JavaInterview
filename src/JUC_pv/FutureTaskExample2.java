package JUC_pv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i = 3;
                String flag = isOdd(3);
                return flag;
            }

            private String isOdd(int i) {
                if(i == 3){
                    return "true";
                }else{
                    return "false";
                }
            }
        });

        Thread completeThread = new Thread(futureTask);
        completeThread.start();
        Thread otherThread = new Thread(() -> {
            System.out.printf("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.printf(futureTask.get());
    }
}
