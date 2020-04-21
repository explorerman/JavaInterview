package JUC_pv;

/**
 * @author 李杰
 * @version 1.0
 * @Description  测试两个线程前后执行，互不影响，但主线程，可以使用新线程的返回值。
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/21 9:47
 * @title 标题: 测试两个线程前后执行，互不影响，但主线程，可以使用新线程的返回值。
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class testJoinReturn {
    private static class A implements Runnable{

        private String flag = "false";
        @Override
        public void run() {
            int result = 1;
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result += i;
            }
            System.out.println(result);
            flag = "true";
        }

        public String getFlag(){
            return flag;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int count = 1;
        for (int i = 0; i < 10; i++) {
            count += i;
        }
        System.out.println(count);
        A a = new A();
        Thread thread = new Thread(a);
        thread.start();
        thread.join();
        if(a.getFlag() == "true"){
            System.out.println("返回正常");
        }else{
            System.out.println("返回错误");
        }
        new Thread(() -> {
            Thread.currentThread().setName("新的线程__");
            System.out.println("新的线程"+Thread.currentThread().getName());
        }).start();
    }
}
