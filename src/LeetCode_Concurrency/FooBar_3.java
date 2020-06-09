package LeetCode_Concurrency;

/**
 * @author 李杰
 * @version 1.0
 * @Description 交替打印FooBar,使用自旋锁，但n为5的时候，会超出时间限制
 * 相当于一直让它自旋，等它的CPU时间片用完，就退回到就绪态
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 15:58
 * @title 标题: 交替打印FooBar LeetCode_1115
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class FooBar_3 {
    private int n;

    //模拟生产者消费者模式，用于判断共享变量是否为空
    private volatile boolean isEmpty = true;

    public FooBar_3(int n) {
        this.n = n;
    }

    //生产者
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            if(isEmpty){
                printFoo.run();
                i++;
                isEmpty = false;
            }
        }
    }

    //消费者
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(!isEmpty){
                printBar.run();
                i++;
                isEmpty = true;
            }
            Thread.sleep(1);
        }
    }
}
