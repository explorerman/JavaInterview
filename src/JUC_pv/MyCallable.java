package JUC_pv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 李杰
 * @version 1.0
 * @Description 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/21 20:20
 * @title 标题: 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer  call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
