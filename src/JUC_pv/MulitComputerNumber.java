package JUC_pv;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 需求：使用countdownLatch倒计时法+future实现传入不同的数，计算不同的结果
 */
public class MulitComputerNumber {
    public static void main(String[] args){
         final int total = 100;
        CountDownLatch countDownLatch = new CountDownLatch(total);
        try {
            for (int i = 0; i < total; i++) {
                FutureTask<Boolean> futureTask = new FutureTask<Boolean>(new FutureTaskComputer(i));
                ThreadPoolExecutorExapmle.threadPoolExecutor1.execute(futureTask);
                if(futureTask.get()){
                    System.out.println("发生了错误");
                    throw new Exception("错误");
                }else{
                    System.out.println("一个任务完成");
                }
                countDownLatch.countDown();
            }
            countDownLatch.await();
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ThreadPoolExecutorExapmle.threadPoolExecutor1.shutdown();
        }
    }
}
