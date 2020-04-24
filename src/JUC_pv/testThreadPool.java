package JUC_pv;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试线程池改名字
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/24 10:56
 * @title 标题: 测试线程池改名字
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class testThreadPool {
    static class count extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "++++"+i);
            }
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutorExapmle.threadPoolExecutor1.execute(new count());
        System.out.println(ThreadPoolExecutorExapmle.threadPoolExecutor1.getActiveCount());
        System.out.println(ThreadPoolExecutorExapmle.threadPoolExecutor1.getThreadFactory().getClass().getName());
    }
}
