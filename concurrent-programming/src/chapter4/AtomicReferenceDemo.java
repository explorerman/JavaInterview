package chapter4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 李杰
 * @version 1.0
 * @Description AtomicReference是对对象的封装
 * 运行下面demo可以见到错误，进行了多次充值，原因是状态可能不同，但是值却可能相同，所以不应该用值来判断状态
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 14:58
 * @title 标题: AtomicReference是对对象的封装
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class AtomicReferenceDemo {
    static AtomicReference<Integer> money = new AtomicReference<Integer>();

    public static void main(String[] args) {
        money.set(19);
        for (int i = 0; i < 3; i++) {
            new Thread() {

                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20)) {
                                    System.out.println("余额小于20元，充值成功，余额：" + money.get() + "元");
                                    break;
                                }
                            } else {
                                System.out.println("余额大于20元，无需充值");
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("成功消费10元，余额：" + money.get());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
