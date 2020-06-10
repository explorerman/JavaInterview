package LeetCode_Concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 李杰
 * @version 1.0
 * @Description 打印零与奇偶数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/10 13:54
 * @title 标题: 打印零与奇偶数,使用信号量
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ZeroEvenOdd {
    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if((i & 1) == 0){
                odd.release();
            }else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i+=2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
